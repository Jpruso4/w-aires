import { HttpClient} from '@angular/common/http';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  client: FormGroup;
  submitted:boolean = false;

  clients: any;
  typeDocuments: any;
  typeClients: any;

  token: any;

  idEdit: number;
  emailEdit: string;
  nameEdit: string;
  phoneEdit: string;
  addressEdit: string;
  idClientTypeEdit: string;
  isActiveEdit: string;


  constructor(private httpClient: HttpClient, private modal:NgbModal, private formBuilder: FormBuilder) { 
    this.obtenerToken();
  }

  ngOnInit(){
    this.httpClient.get('http://localhost:8090/w-aires/api/client/clients').subscribe(
      (response) => {
        this.clients = response
        console.log(this.clients);
      },
      (error) => console.log("Error mostrando los clientes: " + error.value)
    );

    this.httpClient.get('http://localhost:8090/w-aires/api/clientType/clientsTypes').subscribe(
      (response) => {
        this.typeClients = response
      },
      (error) => console.log("Error mostrando los tipos de cliente: " + error.value)
    );

    this.httpClient.get('http://localhost:8090/w-aires/api/documentType/documentsTypes').subscribe(
      (response) => {
        this.typeDocuments = response
      },
      (error) => console.log("Error mostrando los tipo de documento: " + error.value)
    );

    this.client = this.formBuilder.group({
      tipoDocumento: ['', Validators.required],
      numeroDocumento: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{8,10}$")]],
      nombre: ['', [Validators.required, Validators.pattern("[a-zA-Z0-9 ]{4,50}")]],
      email: ['', [Validators.required, Validators.pattern("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")]],
      phone: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{7}$")]],
      cellPhone: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      address: ['', [Validators.required, Validators.maxLength(50), Validators.minLength(5)]],
      typeClient: ['', Validators.required],
      active: ['', Validators.required]
    })
  }

  get f() { return this.client.controls; }

  onSubmit(){
    this.submitted = true;
    if(this.client.invalid){
      return;
    }else{
      this.httpClient.post('http://localhost:8090/w-aires/api/client/create', this.mapperModeloCliente()).subscribe((response) =>{
        if(response){
          Swal.fire(
            'Registro con exito',
            'El Registro se ha hecho con exito',
          );
          window.location.reload();
        }else{
          Swal.fire(
            'Registro fallado, por favor revise los campos'
          );
        }
      });
    }
  }

  onSubmitEdit(){
    this.submitted = true;
    if(this.client.invalid){
      return;
    }else{
      this.httpClient.put('http://localhost:8090/w-aires/api/client/modified', this.mapperModeloCliente()
      ).subscribe((response) =>{
        if(response){
          Swal.fire(
            'Editado con exito',
            'Se ha editado con exito',
          );
          window.location.reload();
        }else{
          Swal.fire(
           'Ha fallado la edición, por favor revise los campos'
          );
        }   
      })
    }
  }

  obtenerToken(){
    this.token = JSON.parse(localStorage.getItem("token")!).jwt;
  }

  cancelModal(){
    Swal.fire({
      text: '¿Desea cancelar el proceso?, recuerde que perdera todos los datos ingresados',
      icon: 'warning',
      showCancelButton: true,
      cancelButtonText: 'No',
      confirmButtonText: 'Sí',
    }).then((result) => {
      if (result.isConfirmed){
        this.modal.dismissAll();
        this.client.reset();
    }else{
    }})
  }

  crearCliente(){
    Swal.fire({
      title: 'Registrar Cliente',
      text: '¿Desea registrar un nuevo cliente?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Registrar',
      cancelButtonText: 'Cancelar'
    }).then((result) => {
      if (result.isConfirmed) {
        this.onSubmit();
      }else if (result.dismiss === Swal.DismissReason.cancel) {
        Swal.fire(
          'Registro Cancelado',
          'El registro no se ha completado',
          'error'
        );
      }
    });
  }

  editarCliente(){
    Swal.fire({
      title: 'Editar Cliente',
      text: '¿Desea editar el cliente?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Editar',
      cancelButtonText: 'Cancelar'
    }).then((result) => {
      if (result.isConfirmed) {
          this.onSubmitEdit();
      }else if (result.dismiss === Swal.DismissReason.cancel) {
        Swal.fire(
          'Editar Cancelado',
          'La edición no se ha completado',
          'error'
        );
      }
    });
  }

  eliminarCliente(numDocumento:any){
    Swal.fire({
      title: '¿Desea eliminar el cliente?',
      showDenyButton: true,
      confirmButtonText: 'Sí',
      denyButtonText: `No`,
    }).then((result) => {
      if (result.isConfirmed) {
      this.httpClient.delete('http://localhost:8090/w-aires/api/client/delete/'+ numDocumento).subscribe(
        (response) => {
          console.log(response);
          if(response){
            Swal.fire(
              'Eliminado con exito',
              'Se ha eliminado el cliente con exito'
            )
            window.location.reload();
          }
        },
        (error) => {
          Swal.fire(
            'Proceso fallido',
            'El cliente no se ha podido eliminar'
          )});
      }
      else if (result.isDenied) {
        Swal.fire(
          'Eliminar Cancelado',
          'La eliminación del registro no se ha completado',
          'error'
        )}
    });
  }

  openModalCreate(template: TemplateRef<any>){
    this.modal.open(template);
  }

  openModalEdit(template: TemplateRef<any>, client:any){
    this.client = this.formBuilder.group({
      tipoDocumento: [client.idTipoDocumento, Validators.required],
      numeroDocumento: [client.numDocumento, [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{8,10}$")]],
      nombre: [client.nombre, [Validators.required, Validators.pattern("[a-zA-Z0-9 ]{4,50}")]],
      email: [client.correo, [Validators.required, Validators.pattern("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")]],
      phone: [client.telefono, [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{7}$")]],
      cellPhone: [client.celular, [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      address: [client.direccion, [Validators.required, Validators.maxLength(50), Validators.minLength(5)]],
      typeClient: [client.idTipoCliente, Validators.required],
      active: [client.activo, Validators.required]
    });
    this.modal.open(template);
  }

  
  mapperModeloCliente(){
    return{
      numDocumento: this.client.value.numeroDocumento,
      nombre: this.client.value.nombre,
      telefono: this.client.value.phone,
      celular: this.client.value.cellPhone,
      correo: this.client.value.email,
      direccion: this.client.value.address,
      activo: this.client.value.active,
      idTipoCliente: this.client.value.typeClient,
      idTipoDocumento: this.client.value.tipoDocumento
    }
  }
}
