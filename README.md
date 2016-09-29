# ChickenGame

### What is the game about?
* This is a Java application (game) that I made for my Software Architecture. The game is remade from the Egg Catching game which was famous in Vietnam in 2002. 
* The game contain 3 design pattern: MVC, Prototype and Singleton

### How to set up?
To run our game, you must create a default netbean database
* You open the NetBeans, then go to the Services tab (next to Projects Tab).
* Expand the Databases tab, right click to the Java DB, choose Create Database
* Name the database is GamePlayer, username is Anonymous and password is 2440.
* You will see the line jdbc:derby://localhost:1527/GamePlayer [Anonymous on ANONYMOUS] appear. Double click to that line to connect to the database.
* Right click to the line, choose execute command.
* Run this SQL command: 
CREATE TABLE PLAYER(
    "NAME" VARCHAR(100) PRIMARY KEY,
    SCORE INT DEFAULT 0,
    LIFE INT DEFAULT 5
);

**_Notes_**: When you unzip the project, the file derbyclient.jar may be lost. Without that file, the program can not run. Therefore, if NetBeans shows error that derbyclient can not be found, you should download the derbyclient.jar that be shared on drive and link it to the project.

### Game rules
* The game is endless as there is no levels. The player plays until losing. And that is when he or she has lost all the given lives. 
* To play the game, the player has to move the basket place at the bottom of the Main Screen so that he/she can catch the falling eggs.
* A golden egg gives the player 20 points and a normal one gives only 10.  
* However, if the player misses an egg or accidentally catches a poop, he/she will lose a life.
* A chicken product is considered as being caught or going inside the basket only when it drops in the middle of the basket. If it made contact with the edge, the product will automatically bounce out.

### 1-minute Game Play video
https://www.youtube.com/watch?v=8FrrTFFbMdg
