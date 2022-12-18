import java.util.Random;
import java.util.Scanner;

public class Wilderness extends Building
{
    public Wilderness() {}

    public void misja1(Player player)
    {
        // misja 1
        interact(player);
    }

    public void misja2(Player player)
    {
        // misja 2
        interact(player);
    }

    public void misja3(Player player)
    {
        //misja 3
        interact(player);
    }

    public void interact(Player player)
    {
        System.out.println("0. See your statistics");
        System.out.println("1. Enter the city");
        System.out.println("2. misja 1");
        System.out.println("3. misja 2");
        System.out.println("4. misja 3");
        System.out.println("5. Travel to another city");

        Scanner input = new Scanner(System.in);
        int playerInput = input.nextInt();

        if (playerInput == 0) {player.sheet(player);}
        else if (playerInput == 1) {player.currentCity.menu(player);}
        else if (playerInput == 2) {misja1(player);}
        else if (playerInput == 3) {misja2(player);}
        else if (playerInput == 4) {misja3(player);}
        else if (playerInput == 5) {player.travel();}
    }
}