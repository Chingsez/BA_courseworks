#Draw a scatterplot with mpg on the y axis and displacement on the x axis. 
plot(mtcars$mpg~mtcars$disp, xlab ="Displacement", ylab = "mpg")
##The graph shows that when the displacement increase, the mpg is tend to decrease.


#Draw histograms for mpg by am in the same plot.
#Drawing histogram of mpg which am equals 0
mpg0 <- subset(mtcars, mtcars$am == 0)
hist(mpg0$mpg, col = "grey")
#Drawing histogram of mpg which am equals 1
mpg1 <- subset(mtcars, mtcars$am == 1)
hist(mpg1$mpg, col = "grey")