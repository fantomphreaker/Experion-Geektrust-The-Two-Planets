# Problem Context
Our problem is set in the planet of Lengaburu…in the distant distant
galaxy of Tara B. Our protagonists are King Shan, the emperor of
Lengaburu, and the evil queen Al Falcone of Falicornia
Lengaburu has been at peace with her neighbours for over 50 years
but now…. planet Falicornia dares attack Lengaburu. Write code to
help King Shan identify the optimal force he should deploy to defend
Lengaburu

## Rules of War
**Rule #1.** The Power Rule: Each Lengaburu army unit is 2X more powerful than their Falcornia counterpart. Example: 1
Lengaburu Horse can counter 2 Falicornia Horses, 1 Lengaburu Elephant can counter 2 Falicornia Elephants and so on.   
**Rule #2.** The Like-to-Like Rule: Falicornia Horses battalion should be countered with Lengaburu horses battalion, Elephants
with elephants and so on. Except when the battalion is completely exhausted (see Rule #3).  
**Rule #3.** The Substitution Rule: When all units of a particular Lengaburu battalion is exhausted, a different type of battalion can be used. 1 Elephant can replace 2 Horses (and 2 Horses can replace 1 Elephant), 1 Armoured Tank can replace 2 Elephants (and vice versa) and 1 Sling Gun can replace 2 Armoured Tanks (and vice versa).          
**Rule #4.** The Substitution Choice Rule: When there are 2 possibilities of substitution, then always a lower ranked battalion should be used (Horses is lower than Elephants, is lower than Armoured Tanks, is lower than Sling Guns)

## Assumptions
1. This program is run by Lengaburu and is coded to generate number of troops for each battalion of Lengaburu needed to counter different combinations of troops sent by Falicornia and see Lengaburu wins or loses against Falicornia in each scenario.
2. For each attack by Falicornia, their troop combination is used as input which is saved in the text file in the order as shown below.
```bash
FALICORNIA_ATTACK 100H 101E 20AT 5SG 
```
 3. The rest of inputs of each attack must be entered as a new line in the *input.txt* file.
```bash
FALICORNIA_ATTACK 150H 96E 26AT 8SG
FALICORNIA_ATTACK 100H 101E 20AT 5SG
FALICORNIA_ATTACK 250H 50E 20AT 15SG 
```
 4. The troops are strictly in the order: Horses(H), Elephants(E), Armoured Tanks(AT), Sling Gun(SG).
## Solution and Logic
 **1.** Power of troops doubles as we move from Horses(H) to Sling Guns(SG). Thus, while substituting a particular troop(say E) by adjacent troops(say H or AT) the strength of the troops substituting is converted to its equivalent strength of substituted troops.
 For example,

    If  2H and 1 AT substitutes 3E, then 2H is converted into its equivalent E by  
    
    (1/2) x 2H = 1E. 

    And 1AT is converted into equivalent E by

     2 x 1AT = 2E.
**2.**  During substitution, only whole number values are used because the numbers denote the number of troops substituted. So fractional values and negative values are converted into positive greatest integer values less than or equal to the fractional values. For example, It makes no sense to counter 3 Horses with 1.5 Elephants when 2 Elephants are available. 

**3.** The solution is obtained after executing methods that uses Rules of War to generate the number of each battalion of troops left in Lengaburu. The difference between the number of each battalion of troops left and the total number of troops available in the corresponding battalion gives the number of troops Lengaburu needs to deploy from that battalion to counter Falicornia.

**4.** Whether Lengaburu WINS or LOSES depends upon the net battle power of the remaining troops after deploying and substitution of troops. If the net battle power of the remaining troops in all battalions of Lenganuru together is greater than that of the corresponding net battle power of remaining troops in all battalions of Falicornia, then Lengaburu WINS. Otherwise, Lengaburu LOSES.

## Code Organization

**1.** The program consists of 3 Classes namely, 
* Geektrust - Main class
* Battalion - Contains class methods and states that describe the battalion of either kingdoms.
* War - Class that have methods and state that deals with deployment of battalions for war w.r.t the rules of war and has methods that calculate the outcome of the war.


## Code Execution
* Make sure you have Java version 11 (OpenJDK 11 or Java SE 11) atleast installed in your computer. 
* Input file is in the directory *The Two Planets*. The input file is named *input.txt*. Each input must be entered in a new line using text editor and must be saved before executing the program.
* Change the path of *input.txt* in the code to the absolute path to the location of *The Two Planets* in your computer.
```java
File file = new File("<your absolute path>\\The Two Planets\\input.txt");
```
* After the above step, you can open the project folder in your IDE, navigate to src  and run Geektrust.java
* Alternatively, you could use cmd prompt or terminal to change directory to *src* in *The Two Planets* and enter the following commands.

For Windows
```cmd
C:\<enter absolute path to The Two Planets here>\src>javac *.java
C:\<enter absolute path to The Two Planets here>\src>java Geektrust
```
For Linux/Mac
```bash
<absolute path to The Two Planets here>/src$javac *.java
<absolute path to The Two Planets here>/src$java Geektrust
```
## Sample Input and Output 

in *input.txt* file

Input
```txt
FALICORNIA_ATTACK 150H 96E 26AT 8SG
FALICORNIA_ATTACK 100H 101E 20AT 5SG
FALICORNIA_ATTACK 250H 50E 20AT 15SG  
```
Output
```bash
WINS 75H 50E 10AT 5SG

WINS 52H 50E 10AT 3SG

LOSES 100H 38E 10AT 5SG
```

