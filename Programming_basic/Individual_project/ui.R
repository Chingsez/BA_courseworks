library(shiny)
library(leaflet)
library(shinythemes)

# Define UI for application that analyzes the patterns of crimes in DC
shinyUI(fluidPage(
  
  # Change the theme to flatly
  theme = shinytheme("sandstone"),
  
  # Application title
  titlePanel("Average SAT score of public schools in New York"),
  
  # Three sidebars for uploading files, selecting time slots and districts
  sidebarLayout(
    sidebarPanel(
      
      # Create a file input
      fileInput("file","Choose A CSV File Please",
                multiple = TRUE,
                accept = c("text/csv",
                           "text/comma-separated-values,text/plain",
                           ".csv")),
      
      

      
      # Create a multiple checkbox input for police districts
      checkboxGroupInput("Subjects",
                         "SAT Subjects",
                         choices = list("Math" = 1, "Reading" = 2, "Writing" = 3),
                         selected = 1
      ),
      
      hr(),
      helpText("Please Select The SAT Subject You Want To Analyze"),
      hr(),
      helpText("You can click on the bubble to see each schools' student composition.")
    ),
    
    # Make the sidebar on the right of the webpage
    position = "right",
    fluid = TRUE,
    
    
    
    # Show the map in the tab panel
    mainPanel(
      hr(),
      
      tabsetPanel(type="tabs",
                  tabPanel("Problem Description", textOutput("text")),
                  tabPanel("Map", leafletOutput("map", height=630)),
                  tabPanel("Descriptive Analysis",
                           
                           #Add two subtabs
                           tabsetPanel(
                             tabPanel("Average SAT Score",verbatimTextOutput("table1"), verbatimTextOutput("summary1"), verbatimTextOutput("summary2"), verbatimTextOutput("summary3"),
                                      plotOutput("plot1"), plotOutput("plot2"), plotOutput("plot3"), textOutput("discrip1")),
                             tabPanel("Student Composition",verbatimTextOutput("table2"))
                           )
                  )
                  
      )
    )
  )
))
