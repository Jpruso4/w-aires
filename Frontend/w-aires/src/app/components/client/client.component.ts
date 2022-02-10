import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {
  clients: any;
  token: any;
  respuesta: any;

  constructor(private httpClient: HttpClient, public modal:NgbModal) { 
    this.obtenerToken();
  }

  ngOnInit(){
    this.token = "Bearer " + this.token;
    console.log(this.token);
    let headers = new HttpHeaders({
      'Authorization': this.token,
    });
    console.log(headers);
    this.httpClient.get('http://localhost:8090/w-aires/api/client/clients', { headers: headers}).subscribe(
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
          this.httpClient.post('http://localhost:8090/w-aires/api/client/create', this.token).subscribe((response) =>{
            this.respuesta = response;
            if(this.respuesta.body){
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
          this.httpClient.put('http://localhost:8090/w-aires/api/client/modified', this.token).subscribe((response) =>{
            this.respuesta = response;
            if(this.respuesta.body){
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

  eliminarCliente(){
    Swal.fire({
      title: 'Eliminar Cliente',
      text: '¿Desea eliminar el cliente?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Eliminar',
      cancelButtonText: 'Cancelar'
    }).then((result) => {
      if (result.isConfirmed) {
          this.httpClient.delete('http://localhost:8090/w-aires/api/client/delete/1').subscribe((response) =>{
            this.respuesta = response;
            if(this.respuesta.body){
              Swal.fire(
                'Eliminado con exito',
                'Se ha eliminado el registro con exito',
              );
              window.location.reload();
            }  
          })
      }else if (result.dismiss === Swal.DismissReason.cancel) {
        Swal.fire(
          'Eliminar Cancelado',
          'La eliminación del registro no se ha completado',
          'error'
        );
      }
    });
  }

  openModalCreate(template: TemplateRef<any>){
    this.modal.open(template);
  }

  openModalEdit(template: TemplateRef<any>){
    this.modal.open(template);
  }
}
