## CS 254 Program 10
##
## Compute sin(x) with a Taylor series:
## sin(x) = x - x^3/3! + x^5/5! - x^7/7! ... n =1 3 5 7
##
## Programmer: Ahmed Elgendy
## Date: 11/27/2021
##
## Register use table:
## $f2  --  x
## $f4  --  term
## $f6  --  n
## $f8  --  21
## $f10 --  2
## $f14 --  -1
## $f18 --  sin
## $s0  --  count
        .text
        .globl main
main:
        li      $v0,4         # print prompt
        la      $a0,prompt
        syscall
        li      $v0,6         # read float
        syscall
		mov.s   $f2,$f0       # copy x to register $f2
		mov.s   $f4,$f0       # copy x to register $f4
		mov.s   $f18,$f0      # copy x to register $f18
        l.s     $f6,n         # load n to $f6
        ori     $s1,$0,21  
		ori     $s0,$0,3
        l.s     $f10,a        # load 2 to $f10
        l.s     $f14,bb       # load 1 to $f12
loop:   beq     $s0,$s1,done  # if count = 21 branch 
        mul.s   $f12,$f2,$f2  # get x^2
        sub.s   $f16,$f6,$f14 # get n-1
        mul.s   $f16,$f6,$f16 # get n * (n-1)
        div.s   $f12,$f12,$f16# get (x * x) / n * (n-1)
        mul.s   $f4,$f12,$f4  # get term * (x * x) / n * (n-1)
        neg.s   $f4,$f4       # get -(term)
        add.s   $f18,$f18,$f4 # get sin = sin + term
		add.s   $f6,$f6,$f10  # add 2 to n
        addiu   $s0,$s0,2     # add 2 to count
        j       loop
done:   li      $v0,4         # print answer
        la      $a0,answer
        syscall
        mov.s   $f12,$f18     # copy $f18 to $f12
        li      $v0,2         # print result
        syscall
        li      $v0,10        # exit
        syscall
        .data
prompt: .asciiz  "Enter x: "
answer: .asciiz  "Sin(x) : "
n:      .float   3.0
a:      .float   2.0
bb:     .float   1.0