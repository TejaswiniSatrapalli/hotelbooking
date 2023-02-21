export class Booking {

    
    name:string;
    checkIn:number;
    checkOut:number;
	noOfAdults:number;
	noOfChildren:number;
    mobileNum:number;


    constructor(  
        name:string,
        checkIn:number,
        checkOut:number,
        noOfAdults:number,
        noOfChildren:number,
        mobileNum:number,
    
     )
     {
        this.name=name;
        this.checkIn=checkIn;
        this.checkOut=checkOut;
        this.noOfAdults=noOfAdults;
        this.noOfChildren=noOfChildren;
        this.mobileNum=mobileNum;

     }
	
}
