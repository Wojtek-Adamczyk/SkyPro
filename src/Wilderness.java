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
        System.out.println("1. Enter the city");
        System.out.println("2. misja 1");
        System.out.println("3. misja 2");
        System.out.println("4. misja 3");
        System.out.println("5. Travel to another city");

        Scanner input = new Scanner(System.in);
        int playerInput = input.nextInt();

        if (playerInput == 0) {sheet(player);}
        else if (playerInput == 1) {misja1(player);}
        else if (playerInput == 2) {misja2(player);}
        else if (playerInput == 3) {misja3(player);}
        else if (playerInput == 4) {travel(player);}
    }

    public void travel(Player player)
    {
        System.out.println("1. Travel to Solitude");
        System.out.println("2. Travel to Morthal");
        System.out.println("3. Travel to Markarth");
        System.out.println("4. Travel to Falkreath");
        System.out.println("5. Travel to Whiterun");
        System.out.println("6. Travel to Dawnstar");
        System.out.println("7 .Travel to Winterhold");
        System.out.println("8. Travel to Windhelm");
        System.out.println("9. Travel to Riften");

        Scanner input = new Scanner(System.in);
        int playerInput = input.nextInt();
        //if (playerInput == 1) player.currentCity
    }
}