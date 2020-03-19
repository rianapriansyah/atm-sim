# ATM Simulation Stage-1

How to build and run ATM Simulation using command line.

1. Open command line. If you you are using Windows Terminal, make sure you have Git installed on your machine. 

2. Clone the repository: `git clone https://github.com/rianapriansyah/atm-sim.git atm_simulation`

3. Change your current work directory to cloned repository from Github: `cd atm_simulation`

4. Compile all the resources using command: `javac src/com/mitrais/*.java`

5. Create Manifest and jar file: `echo Main-Class: src.com.mitrais.Main > manifest.txt`

6. Create executable Jar file: `jar cvfm Atm.jar manifest.txt .`

7. After Jar file successfully created, you will be able to run the program by typing this into your terminal: `java -jar Atm.jar` 