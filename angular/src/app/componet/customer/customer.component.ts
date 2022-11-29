import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {CustomerDto} from "../../dto/CustomerDto";
import {GlobalErrorHandler} from "../../exception/GlobalErrorHandler";




@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.scss']
})
export class CustomerComponent implements OnInit {

  // this variable for hold customer data from customer form (two way baingding)
  customer: CustomerDto = new CustomerDto();
  customerList: Array<CustomerDto>=new Array<CustomerDto>();
  filterText: string = "";

  constructor(private customerService:CustomerService,private message: GlobalErrorHandler) {

  }

  ngOnInit(): void {
    this.getAllCustomer();
  }

  addCustomer() {
    this.customerService.addCustomer(this.customer).subscribe(obj=>{
      this.message.systemMessages("save data","save CustomerDto","success",1000);
    });

  }
  getAllCustomer() {
    this.customerService.getAllCustomer().subscribe(obj=> {
      this.customerList = obj;
      this.message.systemMessages("load data","load","success",1000);
    },error => {
      this.message.systemMessages("load data","load","error",1000);
    });
  }
  editCustomer(obj: CustomerDto) {
    this.customer=obj;
  }

  deleteCustomer(customerId: string) {
    this.customerService.deleteCustomer(customerId).subscribe(obj=>{
      this.message.systemMessages("Delete","Delete CustomerDto "+this.customer.userName +" Details Successful Save","success",4000);

    });
  }

  updateCustomer() {
    this.customerService.updateCustomer(this.customer).subscribe(obj=>{
        if(obj !=null){
          this.message.systemMessages("Update CustomerDto","Update "+this.customer.userName +" Details Successful Save","success",4000);
        }
    });
  }

  searchByCustomerName() {
    this.customerService.searchByCustomerName(this.filterText).subscribe(obj=>{
      console.log("hiiiiiiii");
      console.log(obj);
    });
  }
}
