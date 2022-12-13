public class Player
{
    Integer currentHP = 100;
    Integer maximumHP = 100;
    Integer damage = 10;
    Integer armor = 0;
    Integer money = 300;

    City currentCity;

    public Player(Integer currentHP, Integer maximumHP, Integer damage, Integer armor, Integer money)
    {
        this.currentHP = currentHP;
        this.maximumHP = maximumHP;
        this.damage = damage;
        this.armor = armor;
        this.money = money;
    }
}


