import java.io.*;

public class Main implements Serializable
{
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException
    {
        Player player = new Player(100000, 1000, 100, 0, 3000, 0, new World());
        World world = new World();
        player.world = world;

        player.currentCity = world.cities[4];
        System.out.println();
        world.cities[4].wilderness.menu(player);

        while (player.currentHP >= 0) {player.currentCity.wilderness.menu(player);}
    }
}