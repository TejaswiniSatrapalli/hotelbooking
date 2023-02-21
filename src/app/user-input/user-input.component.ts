import { Component } from '@angular/core';
import { Booking } from '../booking';
import { BookingOperationsService } from '../booking-operations.service';

@Component({
  selector: 'app-user-input',
  templateUrl: './user-input.component.html',
  styleUrls: ['./user-input.component.css']
})
export class UserInputComponent {

  __bookingService:BookingOperationsService;

  constructor(bookingService:BookingOperationsService)
  {
    this.__bookingService=bookingService;
  }

  confirmBooking(name:string,checkIn:string,checkOut:string,noOfAdults:string,noOfChildren:string,mobileNum:string)
  {
    console.log(name+" "+checkIn+" "+checkOut+" "+noOfAdults+" "+noOfChildren+" "+mobileNum);
    let bookingDetailsFromUser:Booking = new Booking(name, parseInt(checkIn) ,parseInt(checkOut),parseInt(noOfAdults),parseInt(noOfChildren),parseInt(mobileNum));
    this.__bookingService.confirmBooking(bookingDetailsFromUser);
  }

}


