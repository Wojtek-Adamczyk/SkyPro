import java.util.Random;
import java.util.Scanner;

public class Inn extends Building
{
    public Inn() {}

    public void greet(Player player)
    {
        Random greet = new Random();
        Integer greeting = greet.nextInt(0,4);
        switch (greeting)
        {
            case 0 -> {System.out.println("- Come on in. Let me know if you need anything, or take a seat by the fire and I'll send someone over."); break;}
            case 1 -> {System.out.println("- Come on in. Just stoked the fire. Take a seat and get the cold out."); break;}
            case 2 -> {System.out.println("- Welcome. Let me know if you want anything... think I got a clean mug around here somewhere."); break;}
            case 3 -> {System.out.println("- Come on in. We got warm food, warm drinks, and warm beds."); break;}
        }
    }

    public void talkToInkeeper(Player player)
    {
        // dodanie metody i jakiesgos dialogu
        // systemout - jakis napis mowiacy ze nowa lokacja zostala dodana w wilderness

        interact(player);
    }

    public void eavesdropRumors(Player player)
    {
        // dodanie metody i jakiesgos dialogu
        // systemout - jakis napis mowiacy ze nowa lokacja zostala dodana w wilderness

        interact(player);
    }

    public void examineNoticeBoard(Player player)
    {
        // dodanie metody i jakiesgos dialogu
        // systemout - jakis napis mowiacy ze nowa lokacja zostala dodana w wilderness

        interact(player);
    }

    public void rentRoom(Player player)
    {
        if (player.money >= 10)
        {
            player.currentHP = player.maximumHP;
            player.money -= 10;
            System.out.println("> YOU AWAKEND FEELING WELL RESTED");
        }
        else System.out.println("- Come back when you will have enough gold.");
        System.out.println();

        interact(player);
    }

    public void hireFollower(Player player)
    {
        if (player.money >= 500)
        {
            // add follower
            player.money -= 500;
            System.out.println("> FOLLOWER JOINS TO YOUR PARTY");
        }
        else System.out.println("- I'm sorry. You can't afford my skills.");
        System.out.println();

        interact(player);
    }

    public void pickpocket(Player player)
    {
        Random chance = new Random();
        Integer stealChance = chance.nextInt(0, 10);
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
            Integer stolenMoney = stolen.nextInt(1,50);
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
        System.out.println("1. Talk to the Innkeeper");
        System.out.println("2. Eavesdrop rumors");
        System.out.println("3. Examine the notice board");
        System.out.println("4. Rent a room for one night");
        System.out.println("5. Hire follower");
        System.out.println("6. Pickpocket");
        System.out.println("7. Leavet");

        Scanner input = new Scanner(System.in);
        int playerInput = input.nextInt();
        System.out.println();

        if (playerInput == 0) {sheet(player);}
        // else if (playerInput == 1) {talkToInkeeper(player);}
        // else if (playerInput == 2) {eavesdropRumors(player);}
        // else if (playerInput == 3) {examineNoticeBoard(player);}
        else if (playerInput == 4) {rentRoom(player);}
        else if (playerInput == 5) {hireFollower(player);}
        else if (playerInput == 6) {pickpocket(player);}
    }
}