import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ClientComponent } from './components/client/client.component';
import { NavbarPrivadoComponent } from './components/navbar-privado/navbar-privado.component';
import { EmpleadosComponent } from './components/empleados/empleados.component';
import { ActivityComponent } from './components/activity/activity.component';
import { HomePrivComponent } from './components/home-priv/home-priv.component';
import { CapacidadEquipoComponent } from './components/capacidad-equipo/capacidad-equipo.component';
import { MarcasComponent } from './components/marcas/marcas.component';
import { TypeTeamComponent } from './components/type-team/type-team.component';
import { TipoRefrigeranteComponent } from './components/tipo-refrigerante/tipo-refrigerante.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    NavbarComponent,
    ClientComponent,
    NavbarPrivadoComponent,
    EmpleadosComponent,
    ActivityComponent,
    HomePrivComponent,
    CapacidadEquipoComponent,
    MarcasComponent,
    TypeTeamComponent,
    TipoRefrigeranteComponent,
  ],
  imports: [
    BrowserModule,
    NgbModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
