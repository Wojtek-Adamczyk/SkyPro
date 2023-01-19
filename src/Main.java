import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;


public class Main implements Serializable
{
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException
    {
        System.out.println();
        System.out.println("// this 'game' in currently in 'development' and will be expanded and/or changed over time");
        System.out.println("// for now there is only one save slot to save your progress and every 'save' will overwrite previous slot");
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
                System.out.println();
                world.cities[4].wilderness.menu(player);

                while (player.currentHP >= 0) {player.currentCity.wilderness.menu(player);}
            }
            case "load" ->
            {

                Player player = State.load();
                World world = State.loadWorld();

                player.currentCity = world.cities[4];
                System.out.println();
                world.cities[4].wilderness.menu(player);

                while (player.currentHP >= 0) {player.currentCity.wilderness.menu(player);}
            }
        }
    }
}