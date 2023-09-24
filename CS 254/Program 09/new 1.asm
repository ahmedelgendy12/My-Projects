## CS 254 Program 9
##
## Enter temperture in Celcius, compute the equivalent Fahrenheit temperture.
## F = C*9/5+32
##
## Programmer: Ahmed Elgendy
## Date: 11/20/2021
##
## Register use table:
## $f2 -- 9
## $f4 -- 5
## $f6 -- 32
## $f8 -- result
        .text
        .globl main
main:
        li      $v0,4         # print prompt
        la      $a0,prompt
        syscall
        li      $v0,6         # read float
        syscall
        l.s     $f2,a         # load 9 to $f2
        l.s     $f4,bb        # load 5 to $f4
        l.s     $f6,c         # load 32 to $f6
        mul.s   $f8,$f0,$f2   # C * 9
        div.s   $f8,$f8,$f4   # C * 9 / 5
        add.s   $f8,$f8,$f6   # C * 9 / 5 + 32
        li      $v0,4         # print answer
        la      $a0,answer
        syscall
        mov.s   $f12,$f8      # copy $f8 to $f12
        li      $v0,2         # print result
        syscall
        li      $v0,10        # exit
        syscall
        .data
prompt: .asciiz  "Enter Celsius: "
answer: .asciiz  "Fahrenheit: "
a:      .float   9.0
bb:     .float   5.0
c:      .float   32.0