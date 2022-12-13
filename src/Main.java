import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Player player = new Player(100,100,10,0,300);

        System.out.println();

        Blacksmith blacksmith = new Blacksmith();
        blacksmith.interact(player);

        Alchemist alchemist = new Alchemist();
        alchemist.interact(player);
    }
}