import java.util.Scanner;

public class Player
{
    Integer currentHP = 100;
    Integer maximumHP = 100;
    Integer damage = 10;
    Integer armor = 0;
    Integer money = 300;

    City[] cities = new City[9];

    public Player(Integer currentHP, Integer maximumHP, Integer damage, Integer armor, Integer money)
    {
        this.currentHP = currentHP;
        this.maximumHP = maximumHP;
        this.damage = damage;
        this.armor = armor;
        this.money = money;

        cities[0] = new City("Solitude", true, true, true, true, false, true);
        cities[1] = new City("Morthal", true, false, true, true, false, true);
        cities[2] = new City("Markarth", true, true, true, true, false, true);
        cities[3] = new City("Falkreath", true, true, false, true, true, true);
        cities[4] = new City("Whiterun", true, true, true, true, true, true);
        cities[5] = new City("Dawnstar", true, true, true, true, false, true);
        cities[6] = new City("Winterhold", true, false, false, true, true, true);
        cities[7] = new City("Windhelm", true, true, true, true, false, true);
        cities[8] = new City("Riften", true, true, true, true, true, true);
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

    public void travel()
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
        if (playerInput == 1) {currentCity = cities[0];}
        if (playerInput == 2) {currentCity = cities[1];}
        if (playerInput == 3) {currentCity = cities[2];}
        if (playerInput == 4) {currentCity = cities[3];}
        if (playerInput == 5) {currentCity = cities[4];}
        if (playerInput == 6) {currentCity = cities[5];}
        if (playerInput == 7) {currentCity = cities[6];}
        if (playerInput == 8) {currentCity = cities[7];}
        if (playerInput == 9) {currentCity = cities[8];}
    }
}


