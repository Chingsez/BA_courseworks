#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Nov  2 18:03:28 2018

@author: chingsez
"""
#Open two files and merge them into one
def getData(f1, f2):
    with open(f1) as f:
        s1 = f.read()    
    with open(f2) as f:
        s2 = f.read()
    s = s1 + s2
    return s

def countChars(s, outf) :
    #Turn all the charactors into lower case
    s = s.lower()
    import os
#Remove output file if it exists
    if os.path.exists(outf):
        os.remove(outf)
        #Create a new output file
    f = open(outf, 'a')
    #Count each letter by order and output them into the file
    import string
    for i in string.ascii_lowercase:
        f.write(str(i) + '  ' + str(s.count(i)) + '\n')
    #Define sys.argv
if __name__ == "__main__":
    import os, sys
    if len(sys.argv) == 4:
        myString = getData(sys.argv[1], sys.argv[2])
        countChars(myString, sys.argv[3])
        os.system('notepad ' + sys.argv[3]) # for Windows
        #os.system('TextEdit ' + sys.argv[3]) # for Macs
    else:
        print ("Invalid number of arguments; you need three arguments")
