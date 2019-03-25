cToF <- function(tempInc) {
  temp1 <- tempInc * 1.8 + 32
  
  x = format(round(tempInc, 2), nsmall=2)
  y = format(round(temp1, 2), nsmall=2)
  
  print(paste(x, "degrees celcius is", y, "degrees farenheit"))
}

fToC <- function(tempInF) {
  temp2 <- (tempInF - 32) / 1.8
  
  a = format(round(tempInF, 2), nsmall=2)
  b = format(round(temp2, 2), nsmall=2)
  
  print(paste(a, "degrees farenheit is", b, "degrees celcius"))
}