import { HttpClient } from '@angular/common/http';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-marcas',
  templateUrl: './marcas.component.html',
  styleUrls: ['./marcas.component.css']
})
export class MarcasComponent implements OnInit {

  marca: FormGroup;
  submitted:boolean = false;
  marcas: any;

  constructor(private httpClient : HttpClient, private modal: NgbModal, private formBuilder: FormBuilder) { }

  ngOnInit(){
    this.httpClient.get('https://w-aires.herokuapp.com/w-aires/api/marca/marcas').subscribe(
      (response) => {
        this.marcas = response
      },
      (error) => console.log("Error mostrando los tipos de refrigerantes: " + error.value)
    );
    this.marca = this.formBuilder.group({
      idMarca: ['', Validators.required],
      nombreMarca: ['', [Validators.required, Validators.pattern("[a-zA-Z0-9 ]{4,50}")]],
    })
  }

  get f() {return this.marca.controls;}

  onSubmit(){
    this.submitted = true;
    if(this.marca.invalid){
      return;
    }else{
      this.httpClient.post('https://w-aires.herokuapp.com/w-aires/api/marca/create', this.mapperModeloMarca()).subscribe((response) =>{
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
    if(this.marca.invalid){
      return;
    }else{
      this.httpClient.put('https://w-aires.herokuapp.com/w-aires/api/marca/modified', this.mapperModeloMarca()
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
        this.marca.reset();
    }else{
    }})
  }

  crearMarca(){
    Swal.fire({
      title: 'Registrar Marca',
      text: '¿Desea registrar una nueva marca?',
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

  editarMarca(){
    Swal.fire({
      title: 'Editar Marca',
      text: '¿Desea editar la marca?',
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

  eliminarMarca(id: any){
    Swal.fire({
      title: '¿Desea eliminar la marca?',
      showDenyButton: true,
      confirmButtonText: 'Sí',
      denyButtonText: 'No',
    }).then((result) => {
      if (result.isConfirmed) {
      this.httpClient.delete('https://w-aires.herokuapp.com/w-aires/api/marca/delete/'+ id).subscribe(
        (response) => {
          console.log(response);
          if(response){
            Swal.fire(
              'Eliminado con exito',
              'Se ha eliminado la marca con exito'
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

  openModalEdit(template: TemplateRef<any>, marca: any){
    this.marca = this.formBuilder.group({
      idMarca: [marca.idMarca, Validators.required],
      nombreMarca: [marca.nombreMarca, [Validators.required, Validators.pattern("[a-zA-Z0-9 ]{4,50}")]],
    });
    this.modal.open(template);
  }

  mapperModeloMarca(){
    return{
      idMarca: this.marca.value.idMarca,
      nombreMarca: this.marca.value.nombreMarca
    }
  }
}

