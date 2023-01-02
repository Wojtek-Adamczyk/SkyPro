import java.io.Serializable;

public class Follower implements Serializable
{
    String name;
    Integer currentHP;
    Integer damage;
    Integer armor;
    City city;



    public Follower(String name, Integer currentHP, Integer damage, Integer armor, City city)
    {
        this.name = name;
        this.currentHP = currentHP;
        this.damage = damage;
        this.armor = armor;
        this.city = city;
    }
}