import static java.lang.System.out;
import java.util.Random;
import java.util.Scanner;
public class twoPlayer

{
    public static void main(String[]args)
    {
        out.println("Hello! We are going to play the game Guess My Number version 2!");
        out.println("Before we start, I need each player's name.");
        game();
    }
    
    public static void game()
    {
        int guess;
        int max =100;
        int min = 0;
        Scanner keyboard = new Scanner(System.in);
        out.println("What is player one's name?");
        String playerOne = keyboard.nextLine();
        out.println("What is player two's name?");
        String playerTwo = keyboard.nextLine();
        out.println("\nOk," + playerOne +" and " + playerTwo + " let's play --Guess My Number!--(v.2)");
        out.println(playerOne + " please guess a number between 1-100.");
        boolean keepGuessing =true;
        int secretNum = random(0,100);
        int counter =0;
        while(keepGuessing)
        {
            counter ++;
            guess = keyboard.nextInt();
            out.println("Guess: " + guess);
            if (guess >max || guess<min)
            {
                out.println("Error, you have entered an incorrect number. Try again.");
            }
            else if (guess == secretNum)
            {
                keepGuessing=false;
                if(counter%2==0)
                {
                    out.println("Congrats! " + playerTwo + " you have guessed the number correctly and are clearly the better player. YOU WIN!");
                }
                if (counter%2!=0)
                {
                    out.println("Congrats! " + playerOne + " you have guessed the number correctly and are clearly the better player. YOU WIN!");
                }
               
            }
            else if (guess > secretNum && counter%2==0 && counter<=10)
            {
                out.println("You have guessed a number that is too high " + playerTwo + ".\nNEXT PLAYER!" );
                
            }
            else if (guess > secretNum && counter%2!=0 && counter<=10)
            {
                out.println("You have guessed a number that is too high " + playerOne + ".\nNEXT PLAYER!" );
            }
            else if (guess < secretNum && counter%2==0 && counter<=10)
            {
                out.println("You have guessed a number that is too low " + playerTwo + ".\nNEXT PLAYER!");
            }
            else if (guess < secretNum && counter%2!=0 && counter<=10)
            {
                out.println("You have guessed a number that is too low " + playerOne + "\nNEXT PLAYER!");
                
            }
            else if (guess!= secretNum && counter>10)
            {
                keepGuessing=false;
                out.println("You have run out of guesses " + playerTwo + ", " + playerOne + " sorry, you are both terrible players!");
            }
            
        }
    }
     public static int random (int min, int max )
    {
       
       long seed = System.currentTimeMillis();
       Random r = new Random(seed);
       int a = r.nextInt(max);
       return a;
       
       
    }
}