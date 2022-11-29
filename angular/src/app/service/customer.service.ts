import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {CustomerDto} from "../dto/CustomerDto";
import {catchError, Observable, throwError} from "rxjs";
import {GlobalErrorHandler} from "../exception/GlobalErrorHandler";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient,private errors: GlobalErrorHandler) {
  }

  errorHandler(error: { message: any; }) {
    return throwError(error.message);
  }

  addCustomer(customerDto:CustomerDto):Observable<CustomerDto>{
    return this.http.post<CustomerDto>('http://localhost:8080/api/addCustomer',customerDto).pipe(catchError(this.errorHandler));
  }

  getAllCustomer():Observable<Array<CustomerDto>> {
    return this.http.get<Array<CustomerDto>>('http://localhost:8080/api/getAllCustomer').pipe(catchError(this.errorHandler));
  }

  deleteCustomer(customerId: string):Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/deleteCustomer/'+customerId).pipe(catchError(this.errorHandler));
  }

  updateCustomer(customer: CustomerDto):Observable<CustomerDto> {
    return this.http.put<CustomerDto>('http://localhost:8080/api/updateCustomer/'+customer.customerId,customer).pipe(catchError(this.errorHandler));
  }

  searchByCustomerName(customerName: string):Observable<CustomerDto> {
    return this.http.get<CustomerDto>('http://localhost:8080/api/searchCustomer/'+customerName).pipe(catchError(this.errorHandler));
  }
}
