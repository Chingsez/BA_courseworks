#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Nov  2 21:27:14 2018

@author: chingsez
"""

def getData(f1, f2):
    with open(f1) as f:
        s1 = f.read()    
    with open(f2) as f:
        s2 = f.read()
    s = s1 + s2
    return s

def countWords(s):
    file = s.lower()
    count = []
#Remove some special charactors
    for ch in file:
        if ch in "~@#$%^&*()_-+=<>?/,.:;{}[]|\'""":
           file = file.replace(ch, '')
    words = file.split()
    for i in words:
        if i in count:
            continue
        else:
            count.append([i, words.count(i)])
#Remove repeated results
    count = [list(t) for t in set(tuple(_) for _ in count)]
    return count

def output(count, outf):
    import os
#Remove output file if it exists
    if os.path.exists(outf):
        os.remove(outf)
        #Create a new output file
    f = open(outf, 'a')
    for i in count:
        k='  '.join([str(j) for j in i])
        f.write(k+"\n")        
    
    #Define sys.argv
if __name__ == "__main__":
    import os, sys
    if len(sys.argv) == 4:
        myString = getData(sys.argv[1], sys.argv[2])
        myList = countWords(myString)
        myOutput = output(myList, sys.argv[3])
        os.system('notepad ' + sys.argv[3]) # for Windows
        #os.system('TextEdit ' + sys.argv[3]) # for Macs
    else:
        print ("Invalid number of arguments; you need three arguments")

