import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Enemy
{
    Integer currentHP;
    Integer damage;
    Integer armor;
    Integer level;
    Integer reward;


    public Enemy(Integer level)
    {
        this.level = level;
        Random generator = new Random();

        if (level == 0)
        {
            currentHP = generator.nextInt(50,150);
            damage = generator.nextInt(5,10);
            armor = generator.nextInt(0,1);
            reward = generator.nextInt(30,200);
        }

        if (level == 1)
        {
            currentHP = generator.nextInt(150,250);
            damage = generator.nextInt(11,15);
            armor = generator.nextInt(0,2);
            reward = generator.nextInt(70,300);
        }

        if (level == 2)
        {
            currentHP = generator.nextInt(250,400);
            damage = generator.nextInt(13,17);
            armor = generator.nextInt(0,4);
            reward = generator.nextInt(150,500);
        }

        if (level == 3)
        {
            currentHP = generator.nextInt(400,600);
            damage = generator.nextInt(15,25);
            armor = generator.nextInt(1,5);
            reward = generator.nextInt(300,900);
        }
    }





}