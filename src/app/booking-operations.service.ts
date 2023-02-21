import { Injectable } from '@angular/core';
import { Booking } from './booking';

@Injectable({
  providedIn: 'root'
})
export class BookingOperationsService {

  constructor() { }

  bookingArr:Booking[]=[];
  
  confirmBooking(bookingDetailsFromUser:Booking)
  {
    this.bookingArr.push(bookingDetailsFromUser);
    console.log("Inside Booking Service:Booking Confirmed"+bookingDetailsFromUser.name);
    console.log("Total Bookings are:-"+this.bookingArr.length);

  }

  getBookingArr():Booking[]
  {
    return this.bookingArr;
  }

  
}
