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
            currentHP = generator.nextInt(50,110);
            damage = generator.nextInt(5,11);
            armor = generator.nextInt(0,1);
            reward = generator.nextInt(30,200);
        }

        if (level == 1)
        {
            currentHP = generator.nextInt(150,220);
            damage = generator.nextInt(11,15);
            armor = generator.nextInt(0,2);
            reward = generator.nextInt(70,300);
        }

        if (level == 2)
        {
            currentHP = generator.nextInt(70,100);
            damage = generator.nextInt(20,24);
            armor = generator.nextInt(0,1);
            reward = generator.nextInt(100,200);
        }

        if (level == 3)
        {
            currentHP = generator.nextInt(20,50);
            damage = generator.nextInt(5,8);
            armor = generator.nextInt(0,1);
            reward = generator.nextInt(0,50);
        }

        if (level == 4)
        {
            currentHP = generator.nextInt(400,600);
            damage = generator.nextInt(15,25);
            armor = generator.nextInt(1,5);
            reward = generator.nextInt(300,900);
        }

        if (level == 5)
        {
            currentHP = generator.nextInt(150,250);
            damage = generator.nextInt(11,18);
            armor = generator.nextInt(0,2);
            reward = generator.nextInt(200,400);
        }

        if (level == 6)
        {
            currentHP = generator.nextInt(100,180);
            damage = generator.nextInt(8,15);
            armor = generator.nextInt(0,2);
            reward = generator.nextInt(0,10);
        }

        if (level == 7)
        {
            currentHP = generator.nextInt(150,250);
            damage = generator.nextInt(8,14);
            armor = generator.nextInt(1,3);
            reward = generator.nextInt(100,300);
        }

        if (level == 8)
        {
            currentHP = generator.nextInt(150,250);
            damage = generator.nextInt(20,26);
            armor = generator.nextInt(0,1);
            reward = generator.nextInt(100,300);
        }

        if (level == 8)
        {
            currentHP = generator.nextInt(150,250);
            damage = generator.nextInt(12,16);
            armor = generator.nextInt(1,3);
            reward = generator.nextInt(50,100);
        }

        if (level == 9)
        {
            currentHP = generator.nextInt(200,300);
            damage = generator.nextInt(15,19);
            armor = generator.nextInt(2,4);
            reward = generator.nextInt(50,150);
        }
    }
}