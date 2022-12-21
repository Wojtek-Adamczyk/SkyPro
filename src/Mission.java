import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Mission
{
    String dialog;
    Enemy enemy;
    Integer reward;
    boolean completed;
    City currentCity;
    Integer stealth;


    public Mission(String dialog, Enemy enemy, Integer reward, boolean completed, City currentCity, Integer stealth)
    {
        this.dialog = dialog;
        this.enemy = enemy;
        this.reward = reward;
        this.completed = completed;
        this.currentCity = currentCity;
        this.stealth = stealth;
    }

    public void check(Player player) throws InterruptedException
    {
        System.out.println("1. Engage in fight");
        System.out.println("2. Turn back");

        Scanner input = new Scanner(System.in);
        String playerInput = input.nextLine();
        switch (playerInput)
        {
            case "1" -> fight(player);
            case "2" -> player.currentCity.wilderness.menu(player);
        }
    }

    public void sneak(Player player) throws InterruptedException
    {
        System.out.println("1. Try to sneak past");
        System.out.println("2. Engage in fight");
        System.out.println("3. Turn back");

        Scanner input = new Scanner(System.in);
        String playerInput = input.nextLine();
        switch (playerInput)
        {
            case "1" ->
            {
                if (player.stealth >= stealth)
                {
                    System.out.println("You managed to sneak through and steal " + player.mission.reward + " septims");
                    System.out.println();
                    player.money += player.mission.reward;
                    completed = true;
                }
                else {System.out.println("You were caught!"); System.out.println(); fight(player);}
            }
            case "2" -> fight(player);
            case "3" -> player.currentCity.wilderness.menu(player);
        }
    }

    public void fight(Player player) throws InterruptedException
    {
        if (player.follower != null)
        {
            while (true)
            {
                System.out.println("Follower HP: " + (player.follower.currentHP -= (enemy.damage - player.follower.armor)));
                TimeUnit.SECONDS.sleep(1);
                enemy.currentHP -= (player.damage - enemy.armor);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Enemy HP: " + (enemy.currentHP -= (player.follower.damage - enemy.armor)));
                TimeUnit.SECONDS.sleep(1);
                if (player.follower.currentHP <= 0 )
                {
                    System.out.println();
                    System.out.println(player.follower + "died");
                    System.out.println();
                    break;
                }
                if (enemy.currentHP <= 0)
                {
                    System.out.println();
                    System.out.println("> You defeated the enemy and collected " + player.mission.reward + " septims");
                    player.money += player.mission.reward;
                    System.out.println();
                    completed = true;
                    break;
                }
            }
        }
        else
        {
            while (true)
            {
                System.out.println("Your HP: " + (player.currentHP -= (enemy.damage - player.armor)));
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Enemy HP:" + (enemy.currentHP -= (player.damage - enemy.armor)));
                TimeUnit.SECONDS.sleep(1);
                if (player.currentHP <= 0)
                {
                    System.out.println();
                    System.out.println("> YOU DIED - with yours character's death, the thread of prophecy is severed. Start a new game to restore the weave of fate");
                    break;
                }
                if (enemy.currentHP <= 0 )
                {
                    System.out.println("> You defeated the enemy and collected " + player.mission.reward + " septims");
                    player.money += player.mission.reward;
                    System.out.println();
                    completed = true;
                    break;
                }
            }
        }
    }
 }




