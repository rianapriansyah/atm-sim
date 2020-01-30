# ATM Simulation Stage-1

How to build and run ATM Simulation using command line.

Open command line. If you you are using Windows Terminal, make sure you have Git installed on your machine. 

Clone the repository: `git clone https://github.com/rianapriansyah/atm-sim.git atm_simulation`

Change your current work directory to cloned repository from Github: `cd atm_simulation`

Compile all the resources using command: `javac src/com/mitrais/*.java`

Create Manifest and jar file: `echo Main-Class: src.com.mitrais.Main > manifest.txt`

Create executable Jar file: `jar cvfm Atm.jar manifest.txt src/com/mitrais/*.class`

After Jar file successfully created, you will be able to run the program by typing this into your terminal: `java -jar Atm.jar` 