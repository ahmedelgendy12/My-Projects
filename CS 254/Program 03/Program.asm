## CS 254 Program 3
##
## Compute 27*x
##
## Programmer: Ahmed Elgendy
## Date:10/06/2021
## $5  --- Saves x value
## $6  --- Gets 16*x
## $7  --- Gets 8*x
## $8  --- Gets 4*x
## $9  --- Gets 17*x
## $11 --- Gets 10*x
## $10 --- Gets 27*x
        .text
        .globl  main

main:
        ori      $5, $0,0x3      #Assigns x to register 5
        sll      $6, $5,4        #Multiplies 16*x
        sll      $7,$5,3         #Multiplies 8*x
        sll      $8,$5,1         #Multiplies 2*x
        addu     $9,$5,$6        #Adds x + 16*x
        addu     $11,$7,$8       #Adds 8*x + 2*x
        addu     $10,$11,$9      #Adds 17*x + 10*x

## End of file