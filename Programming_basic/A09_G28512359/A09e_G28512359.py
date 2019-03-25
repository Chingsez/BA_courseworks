#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Nov  4 09:26:18 2018

@author: chingsez
"""

def getData(f1, f2):
    with open(f1) as f:
        s1 = f.read()    
    with open(f2) as f:
        s2 = f.read()
    
    return s1,s2


def countWords(text):
    #Remove special charactors
    file = text.replace('\n', ' ').lower().split(' ')
    filtered = []
    for word in file:
        filterwords = ''.join(char for char in word if char.isalpha())
        filtered.append(filterwords)
    filtered = [word for word in filtered if word != '' and len(word)!= 1]
    
    #Count words  
    count_dict = {}
   
    for char in filtered:
        if char in count_dict.keys():
            count_dict[char] = count_dict[char] + 1
        else:
            count_dict[char] = 1
    
    return count_dict




def writeOutput(count_list, outf):
    import os

    if os.path.exists(outf):
        os.remove(outf)     
    #Sort count result
    count = []
    for dic in count_list:
        count.append(sorted(dic.items(),key = lambda x:x[1],reverse = True))
    
    #Filter stopwords and put them into a list
    stop_words = open('stopwords.csv','r').read().split('\n')
    stopwords = []
    for word in stop_words:
        filterwords = ''.join(char for char in word if char.isalpha())
        stopwords.append(filterwords)
    stopwords = [word for word in stopwords if word != '' and len(word)!= 1]
    
    


 
    
    with open (outf, 'a') as f:
        first_line = 'WORD\tCount 1\tCount 2 \n'
        second_line = '----------------------------------------------- \n'
        f.write(first_line)
        f.write(second_line)
        #Choose the top 10 words and write them into files
        i = 0
        for a in count[0]:
                if a[0] not in stopwords:
                    i += 1
                    s1 = str(a[0]) + '\t' + str(a[1]) + '\t'  
                    
                    for b in count[1]:      
                        if b[0] == a[0]:
                            text2_count = b[1]
                            if text2_count != 0:
                                break
                        else:
                            text2_count = 0
                
                
                    s2 = str(text2_count) + '\n' 
                    s = s1 + s2
                    f.write (s)
                    if i == 10:
                        break
        


if __name__ == "__main__":
    import os, sys
    if len(sys.argv) == 4:
        myString1, myString2 = getData(sys.argv[1], sys.argv[2])
        myDict1 = countWords(myString1)
        myDict2 = countWords(myString2)
        myDict = [myDict1,myDict2]
        writeOutput(myDict, sys.argv[3])
        os.system('notepad ' + sys.argv[3]) # for Windows
        #os.system('TextEdit ' + sys.argv[3]) # for Macs
    else:
        print ("Invalid number of arguments; you need three arguments")

