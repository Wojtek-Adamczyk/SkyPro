public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Player player = new Player(100, 100, 10, 0, 3666600, 0);
        World world = new World();
        player.world = world;

        player.currentCity = world.cities[4];
        System.out.println();
        world.cities[4].wilderness.menu(player);

        while (true) {player.currentCity.menu(player);}
    }
}