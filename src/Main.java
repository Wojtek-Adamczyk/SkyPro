import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Player player = new Player(100,100,10,0,300);

        System.out.println();


//        Alchemist alchemist = new Alchemist();
//        alchemist.greet(player);
//        alchemist.interact(player);

        City solitude = new City("Solitude", true, true, true, true, false, true);
        City morthal = new City("Morthal", true, false, true, true, false, true);

        morthal.menu(new City("Solitude", true, true, true, true, false, true), player);







    }
}