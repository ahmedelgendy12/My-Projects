## CS 254 Program 4
##
## compute sum of the odd integers and the sum of even integers
##
## Programmer: Ahmed Elgendy
## Date: 10/19/2021
## $12 count
## $19 sum of evens
## $18 sum of odds
## $14 remainder

        .text
        .globl main
main:
        ori    $17,$0,2           #intialize 2 in register $17
        lui    $10,0x1000         #Initialize base register
        ori    $15,$0,0           #sum = 0
        lw     $11,0($10)         #Load N
        ori    $12,$0,0           #count = 0
test:   sltu   $13,$12,$11        #count < N
        beq    $13,$0,endLp       #end loop if count >= N
        sll    $0,$0,0            #delay
        

        addiu  $12,$12,1          #count++
        div    $12,$17            #count / 2
        mfhi   $14                #get the remainder of count/2
        beq    $14,$0,even        #if remainder = 0 jump to even
        sll    $0,$0,0            #delay
        addu   $18,$18,$12        #adds odd numbers
        j      test
        sll    $0,$0,0            #delay


even:   addu   $19,$19,$12        #Adds even numbers
        j      test
        sll    $0,$0,0            #delay


endLp:  sw     $19,4($10)         #Store evenSum
        sw     $18,8($10)         #Store oddSum 
        sll    $0,$0,0            #jump target
        .data
N:      .word   4                 #Intialize N
evenSum:.word   0                 #get the sum of the odds
oddSum: .word   0                 #get the sum of the evens