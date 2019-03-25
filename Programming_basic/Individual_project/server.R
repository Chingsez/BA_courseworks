options(shiny.maxRequestSize=30*1024^2)
library(shiny)
library(leaflet)
library(dplyr)

# Define server that analyzes the patterns of crimes in DC
shinyServer(function(input, output) {
  
  output$text <- renderText({
    
    "This dataset contains students' average SAT score of public schools in New York. By analyzing the dataset, we are able to know the student composition in each school and their performance on SAT. With higher average score, the circle shows on map will be bigger, and the color represents the city where the school belongs to. This system could be useful for parents who wants to choose a great school for their children. "
    
  })
  
  # Create a descriptive table for 3 SAT subjects' average score
  output$table1 <- renderPrint({
    
    # Connect to the sidebar of file input
    inFile <- input$file
    
    if(is.null(inFile))
      return("Please Upload A File For Analysis")
    
    # Read input file
    mydata <- read.csv(inFile$datapath)
    attach(mydata)
    
    # Create a dataframe for subjects, only show the first 20 lines.
    head(data.frame(Math = mydata$Math, Reading = mydata$Reading, Writing = mydata$Writing), 20)
    
  })
  
  #Create plots for score distribution
  output$plot1 <- renderPlot({
    inFile <- input$file
    mydata <- read.csv(inFile$datapath)
    attach(mydata)
    
    hist(mydata$Math, main = "Distribution of SAT Math", col = "grey", xlab = "Math")
  })
  
  output$plot2 <- renderPlot({
    inFile <- input$file
    mydata <- read.csv(inFile$datapath)
    attach(mydata)
    
    hist(mydata$Reading, main = "Distribution of SAT Reading", col = "grey", xlab = "Reading" )
  })
  
  output$plot3 <- renderPlot({
    inFile <- input$file
    mydata <- read.csv(inFile$datapath)
    attach(mydata)
  
    hist(mydata$Writing, main = "Distribution of SAT Writing", col = "grey", xlab = "Writing")
  })
  
  #Create summary output
  output$summary1 <- renderPrint({
    inFile <- input$file
    mydata <- read.csv(inFile$datapath)
    attach(mydata)
    
    summary(mydata$Math)
  })
  
  output$summary2 <- renderPrint({
    inFile <- input$file
    mydata <- read.csv(inFile$datapath)
    attach(mydata)
    
    summary(mydata$Reading)
  })
  
  output$summary3 <- renderPrint({
    inFile <- input$file
    mydata <- read.csv(inFile$datapath)
    attach(mydata)

    summary(mydata$Writing)
  })
  
  output$discrip1 <- renderText({
    "From 3 histogram and summary above, we can see that each subjuct of most of the schools are mainly focusing around 400. On average, the schools did  best on math and worse on writing."
  })
  
  output$table2 <- renderPrint({
    
    # Connect to the sidebar of file input
    inFile <- input$file
    
    if(is.null(inFile))
      return("Please Upload A File For Analysis")
    
    # Read input file
    mydata <- read.csv(inFile$datapath)
    attach(mydata)
    
    # Create a data frame for student composition
   head(data.frame(White = mydata$Percent.White, Black = mydata$Percent.Black, Hispanic = mydata$Percent.Hispanic, Asian = mydata$Percent.Asian), 20)
    
  })
  
 
  # Create a map output variable
  output$map <- renderLeaflet({
    
    # Connect to the sidebar of file input
    inFile <- input$file

    if(is.null(inFile))
      return(NULL)
    
    # Read input file
    map_df <- read.csv(inFile$datapath)
    attach(map_df)
    
    
    # Create colors with a categorical color function
    color <- colorFactor("Greens", map_df$City)
    
    # Create the leaflet function for data
    leaflet(map_df) %>%
      
      # Set the default view
      setView(lng = -73.99786, lat = 40.75321, zoom = 12) %>%
      
      # Provide tiles
      addProviderTiles("CartoDB.Positron", options = providerTileOptions(noWrap = TRUE)) %>%
      
      # Add circles
      addCircleMarkers(
        radius = if(input$Subjects == 1){
          map_df$Math/50
          } else if(input$Subjects == 2){
            map_df$Reading/50
          } else if(input$Subjects == 3){
            map_df$Writing/50
          },
        lng= map_df$Longitude,
        lat= map_df$Latitude,
        stroke= FALSE,
        fillOpacity=0.8,
        popup = paste("White:", map_df$Percent.White, "<br>",
                      "Black:",map_df$Percent.Black, "<br>",
                      "Hispanic:", map_df$Percent.Hispanic, "<br>", 
                      "Asian:", map_df$Percent.Asian), 
        color=color(City)
      ) %>%
      
      # Add legends for different types of crime
      addLegend(
        "bottomleft",
        pal=color,
        values=City,
        opacity=0.5,
        title="Cities"
      )
  })
})
