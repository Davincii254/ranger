# Squad

The system will allow a user to create a new hero, create and view a squad of heroes and delete heroe's from the list.

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


### License
MIT
Copyright (c) {2020} Davincii254.


### License

MIT License

Copyright (c) 2020 Davincii254

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.