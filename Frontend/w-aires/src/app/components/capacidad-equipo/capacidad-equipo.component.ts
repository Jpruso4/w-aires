import { HttpClient } from '@angular/common/http';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-capacidad-equipo',
  templateUrl: './capacidad-equipo.component.html',
  styleUrls: ['./capacidad-equipo.component.css']
})
export class CapacidadEquipoComponent implements OnInit {

  capacidadEquipo: FormGroup;
  submitted:boolean = false;
  capacidadEquipos: any;

  constructor(private httpClient : HttpClient, private modal: NgbModal, private formBuilder: FormBuilder) { }

  ngOnInit(){
    this.httpClient.get('https://w-aires.herokuapp.com/w-aires/api/capacidadEquipo/capacidadEquipos').subscribe(
      (response) => {
        this.capacidadEquipos = response
      },
      (error) => console.log("Error mostrando los tipos de refrigerantes: " + error.value)
    );
    this.capacidadEquipo = this.formBuilder.group({
      idCapacidad: ['', Validators.required],
      capacidad: ['', [Validators.required, Validators.pattern("[a-zA-Z0-9 ]{4,50}")]],
    })
  }

  get f() {return this.capacidadEquipo.controls;}

  onSubmit(){
    this.submitted = true;
    if(this.capacidadEquipo.invalid){
      return;
    }else{
      this.httpClient.post('https://w-aires.herokuapp.com/w-aires/api/capacidadEquipo/create', this.mapperModeloCapacidadEquipo()).subscribe((response) =>{
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
    if(this.capacidadEquipo.invalid){
      return;
    }else{
      this.httpClient.put('https://w-aires.herokuapp.com/w-aires/api/capacidadEquipo/modified', this.mapperModeloCapacidadEquipo()
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
        this.capacidadEquipo.reset();
    }else{
    }})
  }

  crearCapacidadEquipo(){
    Swal.fire({
      title: 'Registrar Capacidad de equipo',
      text: '¿Desea registrar un nueva capacidad de equipo?',
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

  editarCapacidadEquipo(){
    Swal.fire({
      title: 'Editar Capacidad de equipo',
      text: '¿Desea editar la capacidad de equipo?',
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

  eliminarCapacidadEquipo(id: any){
    Swal.fire({
      title: '¿Desea eliminar la capacidad de equipo?',
      showDenyButton: true,
      confirmButtonText: 'Sí',
      denyButtonText: 'No',
    }).then((result) => {
      if (result.isConfirmed) {
      this.httpClient.delete('https://w-aires.herokuapp.com/w-aires/api/capacidadEquipo/delete/'+ id).subscribe(
        (response) => {
          console.log(response);
          if(response){
            Swal.fire(
              'Eliminado con exito',
              'Se ha eliminado la capacidad de equipo con exito'
            )
            window.location.reload();
          }
        },
        (error) => {
          Swal.fire(
            'Proceso fallido',
            'La marca no se ha podido eliminar'
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

  openModalEdit(template: TemplateRef<any>, capacidadEquipo: any){
    this.capacidadEquipo = this.formBuilder.group({
      idCapacidad: [capacidadEquipo.idCapacidad, Validators.required],
      capacidad: [capacidadEquipo.capacidad, [Validators.required, Validators.pattern("[a-zA-Z0-9 ]{4,50}")]],
    });
    this.modal.open(template);
  }

  mapperModeloCapacidadEquipo(){
    return{
      idCapacidad: this.capacidadEquipo.value.idCapacidad,
      capacidad: this.capacidadEquipo.value.capacidad
    }
  }
}