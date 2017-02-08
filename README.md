# Sales Taxes

## About

This was my first Java project. In order to complete this project, I had to learn the Java language, how to build and test a Java application, and how to use an IDE.

The goal of this project was to read a file of item data, calculate sales taxes on the items, and output a receipt file.

It was built utilizing JDK 1.8, JUnit, and Maven.

### Sample Inputs

    Input 1:
    1 book at 12.49
    1 music CD at 14.99
    1 chocolate bar at 0.85

    Input 2:
    1 imported box of chocolates at 10.00
    1 imported bottle of perfume at 47.50

    Input 3:
    1 imported bottle of perfume at 27.99
    1 bottle of perfume at 18.99
    1 packet of headache pills at 9.75
    1 box of imported chocolates at 11.25

### Sample Outputs

    Output 1:
    1 book : 12.49
    1 music CD: 16.49
    1 chocolate bar: 0.85
    Sales Taxes: 1.50
    Total: 29.83

    Output 2:
    1 imported box of chocolates: 10.50
    1 imported bottle of perfume: 54.65
    Sales Taxes: 7.65
    Total: 65.15

    Output 3:
    1 imported bottle of perfume: 32.19
    1 bottle of perfume: 20.89
    1 packet of headache pills: 9.75
    1 imported box of chocolates: 11.85
    Sales Taxes: 6.70
    Total: 74.68

## Setup

This application was built using Apache Maven.

If you do not already have Maven installed, please follow installation instructions here:
https://maven.apache.org/download.cgi

## Run Application from the Command Line

The following commands should be run from the root directory of the application:

**Compile application**

    $ mvn clean compile

**Run application**

    $ mvn exec:java -Dexec.mainClass="salestaxes.Application" -Dexec.args="<YOUR_INPUT_FILES_GO_HERE>"

**Sample command to read one file**

    $ mvn exec:java -Dexec.mainClass="salestaxes.Application" -Dexec.args="./src/resources/input-files/input-3.txt"

**Sample command to read multiple files at once**

    $ mvn exec:java -Dexec.mainClass="salestaxes.Application" -Dexec.args="./src/resources/input-files/input-1.txt ./src/resources/input-files/input-2.txt ./src/resources/input-files/input-3.txt"


- Valid input files can be found in `./src/resources/input-files`

- Output files will be written to `./src/resources/output-files`

## Run Tests from the Command Line

The following command should be run from the root directory of the application:

**Run tests**

    $ mvn clean test

## Assumptions

- Input files read from the command line must include the full path to the file starting from the root directory
    * Example: `./src/resources/input-files/input-1.txt`


- Input files are valid .txt files with each line formatted in a specific manner
    * Example: `1 imported bottle of perfume at 27.99`


- Tax exempt categories and items respectively include the following:
    * CATEGORY => ITEM
    * "book" => "book"
    * "food" => "chocolate"
    * "medical" => "pill"


- Sales tax calculations for each item are rounded up to the nearest five hundredth
    * Example: 0.01 rounds up to 0.05

## Design

### Execution

* Files are read as command line arguments
* Each file is read line-by-line and parsed into data
* Parsed data is stored as an Item
* Sales taxes are calculated and stored for each Item
* Items are saved in a List
* List of Items is converted into a Receipt
* Receipt calculates total sales taxes and cost for all Items
* Receipt is formatted into text that can be printed
* Receipt text is printed in an output file

### Class Responsibility

* Application.java - *Responsible for running the application*
* Formatter.java - *Responsible for formatting data*
* Item.java - *Responsible for storing data of an individual item*
* MyFileReader.java - *Responsible for reading a file*
* MyFileWriter.java - *Responsible for writing to a file*
* Parser.java - *Responsible for parsing data*
* Receipt.java - *Responsible for storing data about a list of items and their total expenses*
* TaxCalculator.java - *Responsible for calculating tax rates*
