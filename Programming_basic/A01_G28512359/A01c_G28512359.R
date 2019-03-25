
myBinom <- function(n, x, p){
  result = floor(choose(n, x)* p^x * (1-p)^(n-x)*10000)/10000
  sprintf("The probability of %.0f successes in %.0f tries is %.4f", x, n, result)
}