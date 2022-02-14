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
  typeClient: any;

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

    this.httpClient.get('http://localhost:8090/w-aires/api/client/clients').subscribe(
      (response) => {
        this.typeClient = response
        console.log(this.clients);
      },
      (error) => console.log("Error mostrando los clientes: " + error.value)
    );

    this.httpClient.get('http://localhost:8090/w-aires/api/client/clients').subscribe(
      (response) => {
        this.typeDocuments = response
        console.log(this.clients);
      },
      (error) => console.log("Error mostrando los clientes: " + error.value)
    );

    this.client = this.formBuilder.group({
      tipoDocumento: ['', Validators.required],
      numeroDocumento: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{8,10}$")]],
      nombre: ['', [Validators.required, Validators.pattern("[a-zA-Z0-9 ]{4,50}")]],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{7}$")]],
      cellPhone: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      address: ['', Validators.required],
      typeClient: ['', Validators.required],
      active: ['', Validators.required]
    })
  }

  get f() { return this.client.controls; }

  onSubmit(){
    this.submitted = true;
    if(this.client.invalid){
      return;
    }

    this.httpClient.post('http://localhost:8090/w-aires/api/client/create', this.mapperModeloClienteAgregar()).subscribe((response) =>{
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
      }   
    )
  }

  obtenerToken(){
    this.token = JSON.parse(localStorage.getItem("token")!).jwt;
    console.log(this.token);
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
          this.httpClient.put('http://localhost:8090/w-aires/api/client/modified', this.mapperModeloClienteEditar()
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
      }else if (result.dismiss === Swal.DismissReason.cancel) {
        Swal.fire(
          'Editar Cancelado',
          'La edición no se ha completado',
          'error'
        );
      }
    });
  }

  eliminarCliente(id:any){
    Swal.fire({
      title: '¿Desea eliminar el cliente?',
      showDenyButton: true,
      confirmButtonText: 'Sí',
      denyButtonText: `No`,
    }).then((result) => {
      if (result.isConfirmed) {
      this.httpClient.delete('http://localhost:8090/w-aires/api/client/delete/'+ id).subscribe(
        (response) => {
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
            'El cliente no se ha podido elimianr'
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
    this.idEdit = client.id;
    this.emailEdit = client.email;
    this.nameEdit = client.name;
    this.phoneEdit = client.phone;
    this.addressEdit = client.address;
    this.idClientTypeEdit = client.idClientType;
    this.isActiveEdit = client.active;
    this.modal.open(template);
  }

  
  mapperModeloClienteAgregar(){
    return{
      id: this.client.value.cedula,
      name: this.client.value.name,
      phone: this.client.value.phone,
      email: this.client.value.email,
      address: this.client.value.address,
      active: this.client.value.active,
      idClientType: this.client.value.idClientType,
    }
  }

  mapperModeloClienteEditar(){
    return{
      id: this.idEdit,
      name: this.nameEdit,
      phone: this.phoneEdit,
      email: this.emailEdit,
      address: this.addressEdit,
      active: this.isActiveEdit,
      idClientType: this.idClientTypeEdit
    }
  }
}
