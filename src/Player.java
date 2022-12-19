import java.util.Scanner;

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

    public void sheet(Player player)
    {
        System.out.println("HP: " + player.currentHP + "/" + player.maximumHP);
        System.out.println("Damage: " + player.damage);
        System.out.println("Armor: " + player.armor);
        System.out.println("Money: " + player.money + " septims");
        System.out.println();

        if (follower != null)
        {
            System.out.println("Follower HP: " + follower.currentHP);
            System.out.println("Follower damage: " + follower.damage);
            System.out.println("Follower armor: " + follower.armor);
            System.out.println();
        }
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
        if (playerInput == 1) {currentCity = world.cities[0];}
        if (playerInput == 2) {currentCity = world.cities[1];}
        if (playerInput == 3) {currentCity = world.cities[2];}
        if (playerInput == 4) {currentCity = world.cities[3];}
        if (playerInput == 5) {currentCity = world.cities[4];}
        if (playerInput == 6) {currentCity = world.cities[5];}
        if (playerInput == 7) {currentCity = world.cities[6];}
        if (playerInput == 8) {currentCity = world.cities[7];}
        if (playerInput == 9) {currentCity = world.cities[8];}
    }

    public void hireFollower(Follower follower)
    {
        if (money >= 500)
        {
            money -= 500;
            System.out.println(follower.name + " joins you");
            this.follower = follower;

            if (currentCity.guildFollower == follower) {currentCity.guildFollower = null;}
            if (currentCity.follower == follower) {currentCity.guildFollower = null;}
        }
        else System.out.println("- I'm sorry traveller. You can't afford my skills.");
    }

    World world;
    Follower follower;
    public Building building;
    public City currentCity;

}


