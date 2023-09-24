## CS 254 Program 8
##
## Enter age in years, compute the equivalent human age.
##
## Programmer: Ahmed Elgendy
## Date: 11/13/2021
##
## Register use table:
## $s1 -- answer for one
## $s2 -- answer for two
## $s0 -- answer for more than 2
## $s3 -- times 5 multiplier
        .text
        .globl main
main:
        li      $v0,4         # print prompt
        la      $a0,prompt
        syscall
        ori     $t0,$0,2      # intiate 2
        ori     $s1,$0,14     # intiate 14
        li      $v0,5         # read integer
        syscall
        move    $s0,$v0       # save input in $s0
        ori     $s2,$0,22     # intiate 22
        ori     $s3,$0,5      # intiate 5
        li      $v0,4         # print answer
        la      $a0,answer
        syscall
        bltu    $s0,1,one     #If input less than 1
        ble     $s0,2,two     #If input less or equal to 2
        bge     $s0,3,more    #If input is equal or more than 3
one:    li      $v0,1         # print 14
        or      $a0,$0,$s1    
        syscall
        j       done
        sll     $0,$0,$0
two:    li      $v0,1         # print 22
        or      $a0,$0,$s2 
        syscall
        j       done
        sll     $0,$0,$0
more:   sub     $s0,$s0,$t0   # input - 2
        mul     $s0,$s0,$s3   # multiply input by 5
        addu    $s0,$s0,$s2   # input * 5 + 22
        li      $v0,1         # print input * 5 + 22
        or      $a0,$0,$s0    
        syscall
        j       done
        sll     $0,$0,$0
done:   sll     $0,$0,$0
        li      $v0,10        # exit
        syscall
        .data
prompt: .asciiz  "Enter dog’s age: "
answer: .asciiz  "Equivalent human age: "