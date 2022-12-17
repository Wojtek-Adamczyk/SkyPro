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

    public void buyWeapon(Player player)
    {
        if (player.money >= 100)
        {
            player.damage++;
            player.money -= 100;
            System.out.println("> YOU SUCCESFULLY PURSHACES A WEAPON");
        }
        else System.out.println("- Come back when you will have enough gold.");
        System.out.println();

        interact(player);
    }

    public void buyArmor(Player player)
    {
        if (player.money >= 300)
        {
            player.armor++;
            player.money -= 300;
            System.out.println("> YOU SUCCESFULLY PURSHACES AN ARMOR");
        }
        else System.out.println("- Gold solves a lor of problems, eh?");
        System.out.println();

        interact(player);
    }

    public void pickpocket(Player player)
    {
        Random chance = new Random();
        Integer stealChance = chance.nextInt(0, 5);
        if (stealChance == 1)
        {
            System.out.println("- Stop right there you criminal scum! You have commited crimes against Skyrim and her people. You will rot in jail!");
            System.out.println("> ALL YOUR BELONGINGS WERE CONFISCATED");
            System.out.println("> DURING JAIL TIME YOU CURED YOURSELF");
            // usun followera
            System.out.println();
            player.currentHP = player.maximumHP;
            player.money = 0;
        }
        else
        {
            Random stolen = new Random();
            Integer stolenMoney = stolen.nextInt(1,150);
            player.money += stolenMoney;
            System.out.println("> You stole " + stolenMoney + " septims");
            interact(player);
        }
    }

    public void sheet(Player player)
    {
        System.out.println("HP: " + player.currentHP + "/" + player.maximumHP);
        System.out.println("Damage: " + player.damage);
        System.out.println("Armor: " + player.armor);
        System.out.println("Money: " + player.money + " septims");
        System.out.println();
        interact(player);
    }

    public void interact(Player player)
    {
        System.out.println("0. See your statistics");
        System.out.println("1. Buy a weapon");
        System.out.println("2. Buy armor");
        System.out.println("3. Pickpocket");
        System.out.println("4. Leave");

        Scanner input = new Scanner(System.in);
        int playerInput = input.nextInt();

        if (playerInput == 0) {sheet(player);}
        else if (playerInput == 1) {buyWeapon(player);}
        else if (playerInput == 2) {buyArmor(player);}
        else if (playerInput == 3) {pickpocket(player);}
        else if (playerInput == 4) {leave(player);}
    }

    public void leave(Player player)
    {
        player.building = null;
        player.currentCity.menu(player);
    }
}