import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-probando-formulario',
  templateUrl: './probando-formulario.component.html',
  styleUrls: ['./probando-formulario.component.css']
})
export class ProbandoFormularioComponent implements OnInit {

  contacto: FormGroup;
  submitted:boolean = false;

  constructor(public formBuilder: FormBuilder) { }

  ngOnInit(){
    this.contacto = this.formBuilder.group({
      nombre: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    });
  }

  get f() { return this.contacto.controls; }

  onSubmit(){
    this.submitted = true;

    console.log(this.contacto.value.nombre)

    if(this.contacto.invalid){
      return;
    }

    //Metodo post

  }

}
