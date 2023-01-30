import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;


public class Main implements Serializable
{
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException
    {
        System.out.println();
        System.out.println("// this 'game' in currently in 'development' and will be expanded and/or changed over time");
        System.out.println();

        System.out.println("'start' - start new game");
        System.out.println("'load' - load saved game");
        Scanner newGame = new Scanner(System.in);
        String isNewGame = newGame.nextLine();
        
        switch (isNewGame)
        {
            case "start" ->
            {
                Player player = new Player(100, 100, 10, 0, 300, 0);
                World world = new World();
                player.world = world;

                player.currentCity = world.cities[4];
                while (player.currentHP > 0)
                {
                    world.cities[4].wilderness.menu(player);
                    player.currentCity.wilderness.menu(player);
                }
            }
            case "load" ->
            {
                Game game = State.loadGame();
                Player player = game.getPlayer();
                World world = game.getWorld();
                while (player.currentHP > 0) { player.currentCity.wilderness.menu(player); }
            }
        }
    }
}