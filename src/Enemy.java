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

        if (level == 0) // bandyty, słabe draugry
        {
            currentHP = generator.nextInt(50,110);
            damage = generator.nextInt(5,11);
            armor = generator.nextInt(0,1);
            reward = generator.nextInt(30,200);
        }

        if (level == 1) // silne draugry, fornswrons, automatony
        {
            currentHP = generator.nextInt(150,220);
            damage = generator.nextInt(11,15);
            armor = generator.nextInt(0,2);
            reward = generator.nextInt(70,300);
        }

        if (level == 2) // magowie
        {
            currentHP = generator.nextInt(70,100);
            damage = generator.nextInt(20,24);
            armor = generator.nextInt(0,1);
            reward = generator.nextInt(100,200);
        }

        if (level == 3) // zwierzaki małe
        {
            currentHP = generator.nextInt(20,50);
            damage = generator.nextInt(5,8);
            armor = generator.nextInt(0,1);
            reward = generator.nextInt(0,50);
        }

        if (level == 4) // smoki
        {
            currentHP = generator.nextInt(400,600);
            damage = generator.nextInt(15,25);
            armor = generator.nextInt(1,5);
            reward = generator.nextInt(300,900);
        }

        if (level == 5) // wampiry/wilkołaki
        {
            currentHP = generator.nextInt(150,250);
            damage = generator.nextInt(11,18);
            armor = generator.nextInt(0,2);
            reward = generator.nextInt(200,400);
        }

        if (level == 6) // duze zwierzaki
        {
            currentHP = generator.nextInt(100,150);
            damage = generator.nextInt(8,14);
            armor = generator.nextInt(0,1);
            reward = generator.nextInt(0,10);
        }

        if (level == 7) // herszty
        {
            currentHP = generator.nextInt(150,250);
            damage = generator.nextInt(8,14);
            armor = generator.nextInt(1,3);
            reward = generator.nextInt(100,300);
        }

        if (level == 8) // silny mag
        {
            currentHP = generator.nextInt(150,250);
            damage = generator.nextInt(20,26);
            armor = generator.nextInt(0,1);
            reward = generator.nextInt(100,300);
        }

        if (level == 8) // fey
        {
            currentHP = generator.nextInt(150,250);
            damage = generator.nextInt(12,26);
            armor = generator.nextInt(1,3);
            reward = generator.nextInt(50,150);
        }
    }
}