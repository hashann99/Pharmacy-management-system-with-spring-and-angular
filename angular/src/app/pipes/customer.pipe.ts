import { Pipe, PipeTransform } from '@angular/core';
import {CustomerDto} from "../dto/CustomerDto";

@Pipe({
  name: 'customerFilter'
})
export class CustomerPipe implements PipeTransform {

  transform(customerList: Array<CustomerDto>, filterText:string ):any {
    if (filterText.trim() == ""){
      return customerList;
    }else{
      return customerList.filter((customer)=>{
        return customer.firstName?.toLocaleLowerCase().startsWith(filterText.toLocaleLowerCase());
      })
    }

  }

}
