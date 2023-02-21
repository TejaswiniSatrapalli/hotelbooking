import { Component } from '@angular/core';
import { Booking } from '../booking';
import { BookingOperationsService } from '../booking-operations.service';

@Component({
  selector: 'app-user-view',
  templateUrl: './user-view.component.html',
  styleUrls: ['./user-view.component.css']
})
export class UserViewComponent {

  __bookingService:BookingOperationsService;

  allBookings:Array<Booking> = [];


  constructor(bookingService:BookingOperationsService){
    this.__bookingService=bookingService;
    this.allBookings = this.__bookingService.getBookingArr();
  }

}
