import java.util.Random;
import java.util.Scanner;

public class School extends Building
{
    public School() {}

    public void greet(Player player)
    {
        Random greet = new Random();
        Integer greeting = greet.nextInt(0,2);
        switch (greeting)
        {
            case 0 -> {System.out.println("- The finest weapons and armor."); break;}
            case 1 -> {System.out.println("- Lookin' to protect yourself? Or deal some damage?"); break;}
        }
    }

    public void train(Player player) throws InterruptedException
    {
        if (player.money >= 50)
        {
            player.stealth += 1;
            player.money -= 50;
            System.out.println("> YOUR STEALTH LEVEL INCREASED");
        }
        else System.out.println("- Gold solves a lor of problems, eh?");
        System.out.println();

        interact(player);
    }

    public void interact(Player player) throws InterruptedException {
        System.out.println("0. See your statistics");
        System.out.println("1. Train your stealth");
        System.out.println("2. Leave");


        Scanner input = new Scanner(System.in);
        int playerInput = input.nextInt();

        if (playerInput == 0) {player.sheet(player); interact(player);}
        else if (playerInput == 1) {train(player);}
        else if (playerInput == 2) {leave(player);}
    }
}