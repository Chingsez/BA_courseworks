rnorm2 <- function(n,mean,sd) { mean+sd*scale(rnorm(n)) } #Create a funtion to generate random n numbers that obbey standardlized normal distribution

set.seed(1239) #Generate a seed to make sure the function is repeatable

r1 <- rnorm2(100,25,4) 

r2 <- rnorm2(50,10,3)

samplingframe <- c(r1,r2) #combine r1 & r2

hist(samplingframe, breaks=20,col = "pink") #plot a histogram 

#The two distributions both fit the central limit theorem. When the random number n increase, the distribution of n is more close to the normal distribution.


#Draw 50 samples of size 15 from the sampling frame in part a, and plot the sampling distribution of means as a histogram.
#Randomly get 15 samples from samplingframe and repeat for 50 times
sample1 <- replicate(50, sample(samplingframe, 15))
#Calculate the mean of each group
sample1_mean <- apply(sample1, 2, mean)
#Plot the sampling distribution of means as a histogram
hist(sample1_mean, col = "grey")


#Draw 50 samples of size 45 from the sampling frame in part a, and plot the sampling distribution of means as a histogram.
#Randomly get 45 samples from samplingframe and repeat for 50 times
sample2 <- replicate(50, sample(samplingframe, 45))
#Calculate the mean of each group
sample2_mean <- apply(sample2, 2, mean)
#Plot the sampling distribution of means as a histogram
hist(sample2_mean, col = "grey")

#Explain CLT in your own words in one or two sentences based on your answers to parts b and c.
#CLT is that when randomly collect some sample for n times, as the sample size increase, the distribution of the sample means will obbey the normal distribution.