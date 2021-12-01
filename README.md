# FitnessCenterMembersManager
JavaCore console project. OOP, Collections, Generics, Java IO, Exceptions, Lambda expressions

This project introduces a fitness center visitor data management program. 
It has three branches (Club Mercury, Club Neptune and Club Jupiter). 
Visitors are also divided into two categories: visitors to one club (Single Club Member) and visitors to several clubs (Multi Club Members).

A visitor to one club is allowed access only to his own club. On the other hand, all three clubs are available to visitors to several clubs.

The amount of the membership fee depends on whether the visitor uses the services of one or more clubs. 
For visitors to one club, the amount of payment also depends on which club he has access to.

Visitors to several clubs receive bonus points for joining the club. 
Upon registration, they receive 100 points that can be used to receive souvenirs and drinks. 
The program will not implement the process of obtaining, but will be limited to a simple accrual of 100 points to the account of a visitor to several clubs.

The application uses a CSV file to store information about each visitor. 
Each time the application is launched, information is read from the CSV file and passed to the LinkedList. 
When we add or remove a visitor from the LinkedList, the CSV file is updated.
