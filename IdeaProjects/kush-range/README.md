# kush-range

## Description

- This a web app that allows rangers to report sightings of all animals they make, with the sightings being recorded in a database

#### By Davincii254

## Behavior Driven Development

> INPUTS: Animal's name, location spotted, other physical attributes of the animal, ranger who made the spotting.
> Output: A table that shows all the animals in the database with their detailed information

## Prerequisites

You need Java installed on your pc. First install sdkman, then use sdk man to install java on your pc using the command "sdk install java"

You also need Gradle. Install it using "sdk install gradle"

You need postgres installed for the database to work.

###  Setup.

- Clone the repo to your pc.

- Open the project folder with the IDE of your choice, preferably Intellij

### Database Setup
Open your terminal, and type in psql. Then type the following

       * CREATE DATABASE wildlife_tracker;
       * \c wildlife_tracker;
       * CREATE TABLE animals (id SERIAL PRIMARY KEY, ranger_name VARCHAR, animal_name VARCHAR,health VARCHAR, age VARCHAR, location VARCHAR);
       * CREATE TABLE sightings (id SERIAL PRIMARY KEY, ranger_name VARCHAR, animal_name VARCHAR,health VARCHAR, age VARCHAR, location VARCHAR);
 
 ### Technologies Used
     
* HTML
* CSS
* Java
* Spark
* Heroku

### Contacts
Reach me at soniamakena02@gmail.com incase of any issues.

### License
MIT
Copyright (c) {2020} Davincii254

