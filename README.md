# ticketservice
Ticket Reservation System

Assumptions:

* Seat preference -
Seats are allocated in the last row towards the first row.

* Priority -
There are 2 categories of Reservation, decided by Code.
As per the order:
1) Private Reservation 
Where all the seats are together besides each other.
2) Remaining Seat Reservation
Seats are allocated where ever available with best possible privacy allocation.

* Hold timeout is 5 seconds. 

* Booking is not allowed if there are less number of seats available.

All these scenarios are verified in Test cases.
Command for testing - mvn test