In this assignment you will be analyzing sales data for the sales of Tesla vehicles between 2016 and 2019.

Your job will be to read the data from 3 different CSV files and store that information for analysis and reporting.

You will need to use Java Streams to go through this data and output the following information onto the console:

Note: anywhere you see #### or yyyy-MM, you'll need to output actual numbers / dates based on your analysis.

    Model 3 Yearly Sales Report
    ---------------------------
    2017 -> ####
    2018 -> ####
    2019 -> ####

    The best month for Model 3 was: yyyy-MM
    The worst month for Model 3 was: yyyy-mm

    Model S Yearly Sales Report
    ---------------------------
    2016 -> ####
    2017 -> ####
    2018 -> ####
    2019 -> ####

    The best month for Model S was: yyyy-MM
    The worst month for Model S was: yyyy-MM

    Model X Yearly Sales Report
    ---------------------------
    2016 -> ####
    2017 -> ####
    2018 -> ####
    2019 -> ####

    The best month for Model X was: yyyy-MM
    The worst month for Model X was: yyyy-MM

The CSV Files

You can download the three CSV files via these links:

https://s3.amazonaws.com/javavideotutorials.net/exerciseFiles/Assignment6/model3.csv
https://s3.amazonaws.com/javavideotutorials.net/exerciseFiles/Assignment6/modelS.csv
https://s3.amazonaws.com/javavideotutorials.net/exerciseFiles/Assignment6/modelX.csv

Hints

You don't need to output this entire report in a single stream. 

You'll want to read the data into three separate Lists.

You will likely need to stream through each of the Lists a few times to be able to output all the necessary data in the report.