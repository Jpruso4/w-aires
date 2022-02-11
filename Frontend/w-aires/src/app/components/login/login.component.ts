import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Login } from 'src/app/models/login.model';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {

  username:string;
  password:string;
  constructor(
    private router: Router,
    private httpClient: HttpClient
    ){ }

  ngOnInit(): void {
  }

  login(){
    let user = new Login(this.username, this.password);
    return this.httpClient.post('http://localhost:8090/w-aires/api/auth/authenticate',user).subscribe(
      (response)=>{
        console.log(response)
        this.guardarLocalStorage(response);
        this.router.navigate(["/client"]);
      },
      (error) => {
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'El usuario que has ingresado es incorrecto',
        })
      }
    );
  }

  guardarLocalStorage(token:any){
    localStorage.setItem("token", JSON.stringify(token));
  }
}
