## CS 254  Program 2  Fall 2021
##
## Compute 1 + 2 + 3 + 4
##
## Programmer: Ahmed Elgendy
## Date: 09/21/2021

        .text
        .globl  main

main:
        ori     $8,$0,0x1       # puts 1 into register 8
        ori     $9,$0,0x2       # puts 2 into register 9
        ori     $11,$0,0x3      # puts 3 into register 11
        ori     $12,$0,0x4      # puts 4 into register 12
        addu    $13,$8,$9       # adds 1 and 2
        addu    $14,$11,$12     # adds 3 and 4
        addu    $10,$13,$14     # adds 1,2,3, and 4

## End of file