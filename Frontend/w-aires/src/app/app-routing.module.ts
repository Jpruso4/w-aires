import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActivityComponent } from './components/activity/activity.component';
import { CapacidadEquipoComponent } from './components/capacidad-equipo/capacidad-equipo.component';
import { ClientComponent } from './components/client/client.component';
import { EmpleadosComponent } from './components/empleados/empleados.component';
import { HomePrivComponent } from './components/home-priv/home-priv.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { MarcasComponent } from './components/marcas/marcas.component';
import { TipoRefrigeranteComponent } from './components/tipo-refrigerante/tipo-refrigerante.component';
import { TypeTeamComponent } from './components/type-team/type-team.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path:'home', component: HomePrivComponent},
  {path: 'login', component: LoginComponent},
  {path: 'cliente', component: ClientComponent},
  {path: 'empleado', component: EmpleadosComponent},
  {path: 'actividad', component: ActivityComponent},
  {path: 'marca', component: MarcasComponent},
  {path: 'tipoRefrigerante', component: TipoRefrigeranteComponent},
  {path: 'tipoEquipo', component: TypeTeamComponent},
  {path: 'capacidadEquipo', component: CapacidadEquipoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
