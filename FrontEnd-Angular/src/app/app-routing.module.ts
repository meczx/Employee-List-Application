import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmpCreateComponent } from './emp-create/emp-create.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { UpdateEmpComponent } from './update-emp/update-emp.component';

const routes: Routes = [
 
  { path: 'employees', component:EmployeeListComponent},
  {path: 'emp-create',component:EmpCreateComponent},
  {
    path: 'empUpadte/:id', component:UpdateEmpComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const Routearr = [EmployeeListComponent, EmpCreateComponent,UpdateEmpComponent];