import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Alchemist extends Building
{
    public Alchemist() {}

    public void greet(Player player)
    {
        Random greet = new Random();
        int greeting = greet.nextInt(0,1);
        switch (greeting)
        {
            case 0 -> System.out.println("- Got a pretty full stock of potions and alchemy reagents.");
            case 1 -> System.out.println("- So you're interested in my potions and ingredients?");
        }
    }

    public void buyPotion(Player player) throws InterruptedException, IOException, ClassNotFoundException {
        if (player.money >= 125)
        {
            player.maximumHP += 10;
            player.money -= 125;
            System.out.println("> YOU PURCHASED A POTION");
        }
        else System.out.println("- Come back when you will have enough gold.");
        System.out.println();

        interact(player);
    }

    public void pickpocket(Player player) throws InterruptedException, IOException, ClassNotFoundException {
        Random chance = new Random();
        int stealChance = chance.nextInt(0, 5);
        if (stealChance == 1)
        {
            System.out.println("- Stop right there you criminal scum! You have commited crimes against Skyrim and her people. You will rot in jail!");
            System.out.println("> ALL YOUR BELONGINGS WERE CONFISCATED");
            System.out.println("> DURING JAIL TIME YOU CURED YOURSELF");
            player.follower = null;
            System.out.println();
            player.currentHP = player.maximumHP;
            player.money = 0;
        }
        else
        {
            Random stolen = new Random();
            int stolenMoney = stolen.nextInt(10,100);
            player.money += stolenMoney;
            System.out.println("> You stole " + stolenMoney + " septims");
            interact(player);
        }
    }

    public void interact(Player player) throws InterruptedException, IOException, ClassNotFoundException {
        System.out.println("0. See your statistics");
        System.out.println("1. Buy health increment potion");
        System.out.println("2. Pickpocket");
        System.out.println("3. Leave");

        Scanner input = new Scanner(System.in);
        String playerInput = input.nextLine();

        if (playerInput.equals("0")) {player.sheet(player); interact(player);}
        else if (playerInput.equals("1")) {buyPotion(player);}
        else if (playerInput.equals("2")) {pickpocket(player);}
        else if (playerInput.equals("3")) {leave(player);}
        else if (playerInput.equals("save")) {State.savePlayer(player); State.saveWorld(player.world);}
        //else {System.out.println("> Invalid command <"); System.out.println();}
    }
}