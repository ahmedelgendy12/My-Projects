## CS 254 Program 7
##
## Enter seed and how many random ints are desired.
## Take input for an intial number and how many random numbers
## and return random numbers as desired from the input
##
## Programmer: Ahmed Elgendy
## Date: 11/1/2021
##
## Register use table:
## $s0 = random number
## $s1 = initialize how many values
## $s3 = copy of register $s1
## $t1 = A
## $t2 = B
## $t3 = 100
        .text
        .globl main
main:
        li      $v0,4         # print ask intial value
        la      $a0,prompt
        syscall
        li      $v0,5         # read integer
        syscall
        move    $s0,$v0       # save input in $s0
        
        li      $v0,4         # print ask how many
        la      $a0,how
        syscall
        li      $v0,5         # read integer
        syscall
        move    $s1,$v0       # save input in $s1
        
        or      $s3,$0,$s1    # save input to register to $s3 
        ori     $t0,$0,0
cont:   beq     $s3,$t0,done  # If input is equal to 0
        ori     $t1,$0,21     # Intialize A 
        ori     $t2,$0,53     # Intialize B
        ori     $t3,$0,100
        mul     $s0,$s0,$t1   # randi * A 
        addu    $s0,$s0,$t2   # (randi*A + B)
        remu    $s0,$s0,$t3   # (randi*A + B)%100
        addiu   $s3,$s3,-1    #count minus 1
        li      $v0,1         #print integer
        or      $a0,$0,$s0
        syscall
        li      $v0,4         # print new line
        la      $a0,newLine
        syscall
        j   cont
        nop

done:   li      $v0,4         # print Done
        la      $a0,over
        syscall
        
        .data
prompt: .asciiz  "Intial value:  "
how:    .asciiz  "Enter how many: "
over:   .asciiz  "Done"
newLine:.asciiz  "\n"