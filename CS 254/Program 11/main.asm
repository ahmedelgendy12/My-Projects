## CS 254 Program 11
##
## computes X*Y*Z and returns that value in $v0
##
## Programmer: Ahmed Elgendy
## Date: 12/05/2021
##
## Register use table:
## $a1 -- X
## $a2 -- Y
## $a3 -- Z
## $v0 -- result
main:
        li      $v0,4         # print prompt
        la      $a0,prompt
        syscall
        li      $v0,5         # read integer
        syscall
        move    $a1,$v0       # Stores X in $a1
        li      $v0,4         # print prompt2
        la      $a0,prompt2
        syscall
        li      $v0,5         # read integer
        syscall
        move    $a2,$v0       # Stores Y in $a2
        li      $v0,4         # print prompt3
        la      $a0,prompt3
        syscall
        li      $v0,5         # read integer
        syscall
        move    $a3,$v0       # Stores Z in $a3
        li      $v0,4         # print answer
        la      $a0,answer
        syscall
        jal     mult3
        nop
        move    $a0,$v0       # copy result to register $a0
        li      $v0,1         # print result
        syscall
        li      $v0,10        # exit
        syscall
    .data
prompt: .asciiz  "Enter X: "
prompt2: .asciiz  "Enter Y: "
prompt3: .asciiz  "Enter Z: "
answer: .asciiz  "Product: "