import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Blacksmith extends Building
{
    public Blacksmith() {}

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

    public void buyWeapon(Player player) throws InterruptedException, IOException, ClassNotFoundException
    {
        if (player.money >= 100)
        {
            player.damage++;
            player.money -= 100;
            System.out.println("> YOU PURCHASED A WEAPON");
        }
        else System.out.println("- Come back when you will have enough gold.");
        System.out.println();

        interact(player);
    }

    public void buyArmor(Player player) throws InterruptedException, IOException, ClassNotFoundException
    {
        if (player.money >= 300)
        {
            player.armor++;
            player.money -= 300;
            System.out.println("> YOU PURCHASED AN ARMOR");
        }
        else System.out.println("- Gold solves a lor of problems, eh?");
        System.out.println();

        interact(player);
    }

    public void pickpocket(Player player) throws InterruptedException, IOException, ClassNotFoundException
    {
        Random chance = new Random();
        Integer stealChance = chance.nextInt(0, 5);
        if (stealChance == 1)
        {
            Dialogue.pickpocket();
            player.follower = null;
            System.out.println();
            player.currentHP = player.maximumHP;
            player.money = 0;
            player.currentCity.menu(player);
        }
        else
        {
            Random stolen = new Random();
            Integer stolenMoney = stolen.nextInt(10,150);
            player.money += stolenMoney;
            System.out.println("> You stole " + stolenMoney + " septims");
            interact(player);
        }
    }

    public void interact(Player player) throws InterruptedException, IOException, ClassNotFoundException
    {
        System.out.println("0. See your statistics");
        System.out.println("1. Buy a weapon");
        System.out.println("2. Buy armor");
        System.out.println("3. Pickpocket");
        System.out.println("4. Leave");

        Scanner input = new Scanner(System.in);
        String playerInput = input.nextLine();

        if (playerInput.equals("0")) {player.sheet(player); interact(player);}
        else if (playerInput.equals("1")) {buyWeapon(player);}
        else if (playerInput.equals("2")) {buyArmor(player);}
        else if (playerInput.equals("3")) {pickpocket(player);}
        else if (playerInput.equals("4")) {leave(player);}
        else if (playerInput.equals("save")) {State.saveGame(player, player.world);}
        else {System.out.println("> Invalid command <"); System.out.println();}
    }
}