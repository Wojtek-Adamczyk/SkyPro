import java.util.Random;
import java.util.Scanner;

public class Keep extends Building
{
    public Keep() {}

    public void greet(Player player)
    {
        Random greet = new Random();
        Integer greeting = greet.nextInt(0,1);
        switch (greeting)
        {
            case 0 -> System.out.println("- ");
            case 1 -> System.out.println("- ");
        }
    }

    public void talkToJarl(Player player)
    {
        // coś tam dialog i emtoda

        interact(player);
    }

    public void pickpocket(Player player)
    {
        Random chance = new Random();
        Integer stealChance = chance.nextInt(0, 2);
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
            Integer stolenMoney = stolen.nextInt(1,600);
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
        System.out.println("1. Talk to jarl");
        System.out.println("2. Pickpocket");
        System.out.println("3. Leave");

        Scanner input = new Scanner(System.in);
        int playerInput = input.nextInt();

        if (playerInput == 0) {sheet(player);}
        else if (playerInput == 1) {talkToJarl(player);}
        else if (playerInput == 2) {pickpocket(player);}
        else if (playerInput == 3) {leave(player);}
    }

    public void leave(Player player)
    {
        player.building = null;
        player.currentCity.menu(player);
    }
}