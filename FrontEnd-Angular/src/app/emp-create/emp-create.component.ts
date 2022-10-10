import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-emp-create',
  templateUrl: './emp-create.component.html',
  styleUrls: ['./emp-create.component.css']
})
export class EmpCreateComponent implements OnInit {
  employee: Employee = new Employee();

  constructor(private employeeService:EmployeeService,private router:Router) { }

  ngOnInit(): void {
  }


  goToEmployeeList() {
    this.router.navigate(["/employees"]);
    
  }

  saveEmployee() {
    this.employeeService.createEmployee(this.employee).subscribe(data => {
      console.log(data);
      this.goToEmployeeList();
    }
    );
}  
  onSubmit() {

    console.log(this.employee);
    this.saveEmployee();
    
  }

}
