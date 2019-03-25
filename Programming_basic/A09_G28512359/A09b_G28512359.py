#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Nov  2 19:22:30 2018

@author: chingsez
"""

def getData(f1, f2):
    with open(f1) as f:
        s1 = f.read()    
    with open(f2) as f:
        s2 = f.read()
    s = s1 + s2
    return s

def countChars(s) :
    #Count each letter by order， sourted them and choose top 10
    import string
    count = list()
    for i in string.ascii_lowercase:
        count.append([i, s.count(i)])
        
    top10 = sorted(count, key= lambda x: (x[1]), reverse = True)[0:10]
    return top10

  
def output(top10, outf):
    import os
#Remove output file if it exists
    if os.path.exists(outf):
        os.remove(outf)
        #Create a new output file
    f = open(outf, 'a')
    for i in top10:
        k='  '.join([str(j) for j in i])
        f.write(k+"\n")        
    
    #Define sys.argv
if __name__ == "__main__":
    import os, sys
    if len(sys.argv) == 4:
        myString = getData(sys.argv[1], sys.argv[2])
        myList = countChars(myString)
        myOutput = output(myList, sys.argv[3])
        os.system('notepad ' + sys.argv[3]) # for Windows
        #os.system('TextEdit ' + sys.argv[3]) # for Macs
    else:
        print ("Invalid number of arguments; you need three arguments")
