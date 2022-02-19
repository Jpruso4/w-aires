import { HttpClient } from '@angular/common/http';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-empleados',
  templateUrl: './empleados.component.html',
  styleUrls: ['./empleados.component.css']
})
export class EmpleadosComponent implements OnInit {

  employ: FormGroup;
  submitted:boolean = false;

  employs: any;
  typeDocuments: any;
  typesPerfil: any;

  constructor(private httpClient: HttpClient, private modal:NgbModal, private formBuilder: FormBuilder) { 
  }

  ngOnInit(){
    this.httpClient.get('https://w-aires.herokuapp.com/w-aires/api/employee/employees').subscribe(
      (response) => {
        this.employs = response
        console.log(this.employs);
      },
      (error) => console.log("Error mostrando los empleados: " + error.value)
    );

    this.httpClient.get('https://w-aires.herokuapp.com/w-aires/api/profile/profiles').subscribe(
      (response) => {
        this.typesPerfil = response
      },
      (error) => console.log("Error mostrando los tipos de perfil: " + error.value)
    );

    this.httpClient.get('https://w-aires.herokuapp.com/w-aires/api/documentType/documentsTypes').subscribe(
      (response) => {
        this.typeDocuments = response
      },
      (error) => console.log("Error mostrando los tipo de documento: " + error.value)
    );

    this.employ = this.formBuilder.group({
      cedula: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{8,10}$")]],
      nombre: ['', [Validators.required, Validators.pattern("[a-zA-Z0-9 ]{4,50}")]],
      email: ['', [Validators.required, Validators.pattern("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")]],
      contrasena: ['', [Validators.required, Validators.pattern("^(?=.{8,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).*$")]],
      cellPhone: ['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      perfil: ['', Validators.required],
      active: ['S', Validators.required]
    })
  }

  get f() { return this.employ.controls; }

  onSubmit(){
    this.submitted = true;
    if(this.employ.invalid){
      return;
    }else{
      this.httpClient.post('https://w-aires.herokuapp.com/w-aires/api/employee/create', this.mapperModeloEmpleado()).subscribe((response) =>{
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
    if(this.employ.invalid){
      return;
    }else{
      this.httpClient.put('https://w-aires.herokuapp.com/w-aires/api/employee/modified', this.mapperModeloEmpleado()
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
        this.employ.reset();
    }else{
    }})
  }

  crearEmpleado(){
    Swal.fire({
      title: 'Registrar empleado',
      text: '¿Desea registrar un nuevo empleado?',
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

  editarEmpleado(){
    Swal.fire({
      title: 'Editar Empleado',
      text: '¿Desea editar el empleado?',
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

  eliminarEmpleado(cedula:any){
    Swal.fire({
      title: '¿Desea eliminar el empleado?',
      showDenyButton: true,
      confirmButtonText: 'Sí',
      denyButtonText: `No`,
    }).then((result) => {
      if (result.isConfirmed) {
      this.httpClient.delete('https://w-aires.herokuapp.com/w-aires/api/employee/delete/'+ cedula).subscribe(
        (response) => {
          console.log(response);
          if(response){
            Swal.fire(
              'Eliminado con exito',
              'Se ha eliminado el empleado con exito'
            )
            window.location.reload();
          }
        },
        (error) => {
          Swal.fire(
            'Proceso fallido',
            'El empleado no se ha podido eliminar'
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

  openModalEdit(template: TemplateRef<any>, employ:any){
    this.employ = this.formBuilder.group({
      cedula: [employ.cedula, [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{8,10}$")]],
      nombre: [employ.nombre, [Validators.required, Validators.pattern("[a-zA-Z0-9 ]{4,50}")]],
      email: [employ.correo, [Validators.required, Validators.pattern("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")]],
      contrasena: [employ.contrasena, [Validators.required, Validators.pattern("^(?=.{8,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).*$")]],
      cellPhone: [employ.celular, [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      perfil: [employ.perfil, Validators.required],
      active: [employ.activo, Validators.required]
    });
    this.modal.open(template);
  }

  
  mapperModeloEmpleado(){
    return{
      cedula: this.employ.value.cedula,
      nombre: this.employ.value.nombre,
      celular: this.employ.value.cellPhone,
      correo: this.employ.value.email,
      contrasena: this.employ.value.contrasena,
      activo: this.employ.value.active,
      perfil: this.employ.value.perfil,
    }
  }
}
