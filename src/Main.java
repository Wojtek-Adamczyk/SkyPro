public class Main
{
    public static void main(String[] args)
    {
        Player player = new Player(100, 100, 10, 0, 300);
        World world = new World();
        player.world = world;

        player.currentCity = world.cities[4];
        System.out.println();
        world.cities[4].wilderness.menu(player);

        while (true) {player.currentCity.wilderness.menu(player);}
    }
}