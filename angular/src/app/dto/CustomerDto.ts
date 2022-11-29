import {IsEmpty, IsNumber, IsString, MaxLength} from "class-validator";

export class CustomerDto {
    @IsNumber()
    customerId:number|undefined;
    @IsString()
    firstName:string|undefined;
    @IsString()
    lastName:string|undefined;
    @IsString()
    address:string|undefined;
    @IsString()
    email:string|undefined;
    @IsNumber()
    mobile:number|undefined;
    @IsString()
    userName:string|undefined;
    @IsString()
    password:string|undefined;


}
