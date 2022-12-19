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
                if (player.follower.currentHP <= 0 ) {System.out.println(); System.out.println("ded"); System.out.println();  break;}
                if (enemy.currentHP <= 0 ) {System.out.println(); System.out.println("> You defeated the enemy and collected " + player.mission.reward + " septims"); System.out.println();  completed = true; break;}
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
                if (player.currentHP <= 0) {System.out.println("> YOU DIED - with yours character's death, the thread of prophecy is severed. Star a new game to restore the weave of fate"); break;}
                if (enemy.currentHP <= 0 ) {System.out.println("> You defeated the enemy and collected " + player.mission.reward + " septims"); System.out.println(); completed = true; break;}
            }
        }
    }
}



