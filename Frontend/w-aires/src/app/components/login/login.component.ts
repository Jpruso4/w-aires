import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Login } from 'src/app/models/login.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {

  username:string="";
  password:string="";
  constructor(private router: Router,private httpClient: HttpClient) { }

  ngOnInit(): void {
  }

  login(){
    let user = new Login(this.username,this.password);
    return this.httpClient.post('http://localhost:8090/auth/authenticate',user).subscribe(
      (response)=>{console.log(response)}
    )
  }
}
