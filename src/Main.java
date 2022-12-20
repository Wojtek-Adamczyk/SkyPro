public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Player player = new Player(100, 1000, 10, 0, 100000, 4);
        World world = new World();
        player.world = world;

        player.currentCity = world.cities[4];
        System.out.println();
        world.cities[4].wilderness.menu(player);

        while (player.currentHP >= 0) {player.currentCity.menu(player);}
    }
}