import { HttpClient } from '@angular/common/http';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-type-team',
  templateUrl: './type-team.component.html',
  styleUrls: ['./type-team.component.css']
})
export class TypeTeamComponent implements OnInit {

  tipoEquipo: FormGroup;
  submitted:boolean = false;
  tipoEquipos: any;

  constructor(private httpClient : HttpClient, private modal: NgbModal, private formBuilder: FormBuilder) { }

  ngOnInit(){
    this.httpClient.get('https://w-aires.herokuapp.com/w-aires/api/tipoEquipo/tipoEquipos').subscribe(
      (response) => {
        this.tipoEquipos = response
      },
      (error) => console.log("Error mostrando los tipos de equipos: " + error.value)
    );
    this.tipoEquipo = this.formBuilder.group({
      idTipoEquipo: ['', Validators.required],
      tipoEquipo: ['', [Validators.required, Validators.pattern("[a-zA-Z0-9 ]{4,50}")]],
    })
  }

  get f() {return this.tipoEquipo.controls;}

  onSubmit(){
    this.submitted = true;
    if(this.tipoEquipo.invalid){
      return;
    }else{
      this.httpClient.post('https://w-aires.herokuapp.com/w-aires/api/tipoEquipo/create', this.mapperModeloTipoEquipo()).subscribe((response) =>{
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
    if(this.tipoEquipo.invalid){
      return;
    }else{
      this.httpClient.put('https://w-aires.herokuapp.com/w-aires/api/tipoEquipo/modified', this.mapperModeloTipoEquipo()
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
        this.tipoEquipo.reset();
    }else{
    }})
  }

  crearTipoEquipo(){
    Swal.fire({
      title: 'Registrar tipo de Equipo',
      text: '¿Desea registrar un nuevo tipo Equipo?',
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

  editarTipoEquipo(){
    Swal.fire({
      title: 'Editar tipo de Equipo',
      text: '¿Desea editar el tipo de equipo?',
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

  eliminarTipoEquipo(id: any){
    Swal.fire({
      title: '¿Desea eliminar el tipo de Equipo?',
      showDenyButton: true,
      confirmButtonText: 'Sí',
      denyButtonText: 'No',
    }).then((result) => {
      if (result.isConfirmed) {
      this.httpClient.delete('https://w-aires.herokuapp.com/w-aires/api/tipoEquipo/delete/'+ id).subscribe(
        (response) => {
          console.log(response);
          if(response){
            Swal.fire(
              'Eliminado con exito',
              'Se ha eliminado el tipo de Equipo con exito'
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

  openModalEdit(template: TemplateRef<any>, tipoEquipo: any){
    this.tipoEquipo = this.formBuilder.group({
      idTipoEquipo: [tipoEquipo.idTipoEquipo, Validators.required],
      tipoEquipo: [tipoEquipo.tipoEquipo, [Validators.required, Validators.pattern("[a-zA-Z0-9 ]{4,50}")]],
    });
    this.modal.open(template);
  }

  mapperModeloTipoEquipo(){
    return{
      idTipoEquipo: this.tipoEquipo.value.idTipoEquipo,
      tipoEquipo: this.tipoEquipo.value.tipoEquipo
    }
  }
}
