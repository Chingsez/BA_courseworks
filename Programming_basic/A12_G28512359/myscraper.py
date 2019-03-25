#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Nov 24 11:35:33 2018

@author: chingsez
"""
def myscraper(f):
    with open(f) as file:
        url = file.read()
    from bs4 import BeautifulSoup as bs
    import requests
    r = requests.get(url)
    data = r.text    
    soup = bs(data, "html.parser")
    allRows = soup.findAll('tr',{'align':'center'})
    tableData = []
    for row in allRows:
        eachRow = []
        cells = row.findAll('td')
        for cell in cells:
            eachRow.append(str(cell.text.strip()))
        tableData.append(eachRow)
    labels = tableData.pop(0) # keep for later use
    import pandas as pd
    df = pd.DataFrame.from_records(tableData, columns=labels)
    return df


def output(df, file):
    df['SUBJECT'] = df['SUBJECT'].str.replace("\n","")
    df['SUBJECT'] = df['SUBJECT'].str.replace("\t","")
    df.to_csv(file,index=False,sep=',')


import argparse as ap
def Main():
    myP = ap.ArgumentParser()
    
    myP.add_argument("-i", "--input", help="The txt file contains a link", default = 'input.txt', action = "store")
    myP.add_argument("-o", "--output", help="Send the result to a file", default = 'output.csv')
    
    myArgs = myP.parse_args()

    
    if myArgs.input:
       myscraper(myArgs.input)
    
    if myArgs.output:
        output(myscraper(myArgs.input), myArgs.output)

if __name__ == "__main__":
    Main()
