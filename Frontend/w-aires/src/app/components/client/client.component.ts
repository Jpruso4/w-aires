import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, EventEmitter, OnInit, Output, TemplateRef } from '@angular/core';
import { FormControl } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  search: string;

  clients: any;
  token: any;
  respuesta: any;

  idNew: number;
  emailNew: string;
  nameNew: string;
  phoneNew: string;
  addressNew: string;
  idClientTypeNew: string;
  isActiveNew: string;

  idEdit: number;
  emailEdit: string;
  nameEdit: string;
  phoneEdit: string;
  addressEdit: string;
  idClientTypeEdit: string;
  isActiveEdit: string;


  constructor(private httpClient: HttpClient, public modal:NgbModal) { 
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
          this.httpClient.post('http://localhost:8090/w-aires/api/client/create', this.mapperModeloClienteAgregar()).subscribe((response) =>{
            this.respuesta = response;
            if(this.respuesta){
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
            this.respuesta = response;
            if(this.respuesta){
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
      id: this.idNew,
      name: this.nameNew,
      phone: this.phoneNew,
      email: this.emailNew,
      address: this.addressNew,
      active: this.isActiveNew,
      idClientType: this.idClientTypeNew
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
