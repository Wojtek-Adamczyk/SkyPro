import java.io.IOException;
import java.util.Scanner;

public class School extends Building
{
    public School() {}

    public void greet(Player player) {{System.out.println("- Why would you like to train your stealth, hm? Just joking. I don't care, unless you got shining septims, it stands to reason.");}}

    public void train(Player player) throws InterruptedException, IOException, ClassNotFoundException
    {
        if (player.money >= 50)
        {
            player.stealth += 1;
            player.money -= 50;
            System.out.println("> YOUR STEALTH LEVEL INCREASED");
        }
        else System.out.println("- Gold solves a lot of problems, eh?");
        System.out.println();

        interact(player);
    }

    public void interact(Player player) throws InterruptedException, IOException, ClassNotFoundException
    {
        System.out.println("0. See your statistics");
        System.out.println("1. Train your stealth");
        System.out.println("2. Leave");

        Scanner input = new Scanner(System.in);
        String playerInput = input.nextLine();

        if (playerInput.equals("0")) {player.sheet(player); interact(player);}
        else if (playerInput.equals("1")) {train(player);}
        else if (playerInput.equals("2")) {leave(player);}
        else if (playerInput.equals("save")) {State.savePlayer(player); State.saveWorld(player.world);}
        else {System.out.println("> Invalid command <"); System.out.println();}
    }
}