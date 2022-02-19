import { HttpClient } from '@angular/common/http';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-tipo-refrigerante',
  templateUrl: './tipo-refrigerante.component.html',
  styleUrls: ['./tipo-refrigerante.component.css']
})
export class TipoRefrigeranteComponent implements OnInit {

  tipoRefrigerante: FormGroup;
  submitted:boolean = false;
  tipoRefrigerantes: any;

  constructor(private httpClient : HttpClient, private modal: NgbModal, private formBuilder: FormBuilder) { }

  ngOnInit(){
    this.httpClient.get('https://w-aires.herokuapp.com/w-aires/api/tipoRefrigerante/tipoRefrigerantes').subscribe(
      (response) => {
        this.tipoRefrigerantes = response
      },
      (error) => console.log("Error mostrando los tipos de refrigerantes: " + error.value)
    );
    this.tipoRefrigerante = this.formBuilder.group({
      idTipoRefrigerante: ['', Validators.required],
      refrigerante: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{1,20}$")]],
    })
  }

  get f() {return this.tipoRefrigerante.controls;}

  onSubmit(){
    this.submitted = true;
    if(this.tipoRefrigerante.invalid){
      return;
    }else{
      this.httpClient.post('https://w-aires.herokuapp.com/w-aires/api/tipoRefrigerante/create', this.mapperModeloTipoRefrigerante()).subscribe((response) =>{
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
    if(this.tipoRefrigerante.invalid){
      return;
    }else{
      this.httpClient.put('https://w-aires.herokuapp.com/w-aires/api/tipoRefrigerante/modified', this.mapperModeloTipoRefrigerante()
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
        this.tipoRefrigerante.reset();
    }else{
    }})
  }

  crearTipoRefrigerante(){
    Swal.fire({
      title: 'Registrar Tipo de Refrigerante',
      text: '¿Desea registrar un nuevo tipo de refrigerante?',
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

  editarTipoRefrigerante(){
    Swal.fire({
      title: 'Editar Cliente',
      text: '¿Desea editar el tipo de refrigerante?',
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

  eliminarTipoRefrigerante(id: any){
    Swal.fire({
      title: '¿Desea eliminar el tipo de refrigerante?',
      showDenyButton: true,
      confirmButtonText: 'Sí',
      denyButtonText: 'No',
    }).then((result) => {
      if (result.isConfirmed) {
      this.httpClient.delete('https://w-aires.herokuapp.com/w-aires/api/tipoRefrigerante/delete/'+ id).subscribe(
        (response) => {
          console.log(response);
          if(response){
            Swal.fire(
              'Eliminado con exito',
              'Se ha eliminado el tipo de refrigerante con exito'
            )
            window.location.reload();
          }
        },
        (error) => {
          Swal.fire(
            'Proceso fallido',
            'El tipo de refrigerante no se ha podido eliminar'
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

  openModalEdit(template: TemplateRef<any>, tipoRefrigerante: any){
    this.tipoRefrigerante = this.formBuilder.group({
      idTipoRefrigerante: [tipoRefrigerante.idTipoRefrigerante, Validators.required],
      refrigerante: [tipoRefrigerante.refrigerante, [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{50}$")]],
    });
    this.modal.open(template);
  }

  mapperModeloTipoRefrigerante(){
    return{
      idTipoRefrigerante: this.tipoRefrigerante.value.idTipoRefrigerante,
      refrigerante: this.tipoRefrigerante.value.refrigerante
    }
  }
}
