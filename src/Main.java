import java.util.concurrent.TimeUnit;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Player player = new Player(100, 100, 10, 0, 300, 0);
        World world = new World();
        player.world = world;

        player.currentCity = world.cities[4];
        System.out.println();
        world.cities[4].wilderness.menu(player);

        while (player.currentHP >= 0) {player.currentCity.menu(player);}

    }
}