##
## Multipy 3 integers
## Programmer: Ahmed Elgendy
## Date: 12/05/2021
##
## Register use table:
## $t0 -- save X * Y
## $a1 -- X
## $a2 -- Y
## $a3 -- Z
## $v0 -- result
mult3:
        mul      $t0,$a1,$a2         # multiply X and Y
        mul      $v0,$t0,$a3         # X * Y * Z
        jr       $ra                 # return
        nop