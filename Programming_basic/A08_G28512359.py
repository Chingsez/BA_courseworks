#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Oct 25 10:34:27 2018

@author: chingsez
"""

#Print temperature in the first row, print blank space for the wind spped column
for i in range(-20, 60, 10):
    print("   ", end = "\t")
    print(i, end=" ")
    #Seperate the first row with  "="
print()
print("=====================================================================\n")

#Print wind spped as the first column, seperate with "|"
for j in range(0, 55, 5):
    #Turn the integer into strings in order to right-justify them
    str_j = str(j)
    print(str_j.rjust(3), "|  ", end = " ")
    #Biuld a nested loop to print the result of calculation
    for k in range(-20, 60, 10):
       wc = 35.74 + 0.6215*k - 35.75*j**0.16 + 0.4275*k*j**0.16
       #Set the print format with 2 decimals
       print("%.2f" %(wc), end="\t")
    print("\n")
