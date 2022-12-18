public class Player
{
    Integer currentHP = 100;
    Integer maximumHP = 100;
    Integer damage = 10;
    Integer armor = 0;
    Integer money = 300;

    public Player(Integer currentHP, Integer maximumHP, Integer damage, Integer armor, Integer money)
    {
        this.currentHP = currentHP;
        this.maximumHP = maximumHP;
        this.damage = damage;
        this.armor = armor;
        this.money = money;
    }

    public Building building;
    public City currentCity;

    public void sheet(Player player)
    {
        System.out.println("HP: " + player.currentHP + "/" + player.maximumHP);
        System.out.println("Damage: " + player.damage);
        System.out.println("Armor: " + player.armor);
        System.out.println("Money: " + player.money + " septims");
        System.out.println();
    }
}


