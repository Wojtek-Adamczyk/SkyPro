import java.util.Random;
import java.util.Scanner;

public class Wilderness extends Building
{
    public enum Type
    {
        SOLITUDE("Solitude"),
        MORTHAL("Morthal"),
        MARKARTH("Markarth"),
        FALKREATH("Falkreath"),
        WHITERUN("Whiterun"),
        DAWNSTAR("Dawnstar"),
        WINTERHOLD("Winterhold"),
        WINDHELM("Windhelm"),
        RIFTEN("Riften");

        private final String name;
        Type(String name) {this.name = name;}
    }

    private final Wilderness.Type type;

    public Wilderness(Wilderness.Type type) {this.type = type;}

    public void menuGuild(Player player)
    {
        System.out.println("0. See your statistics");
        System.out.println("1. Enter the city");
        System.out.println("2. misja 1");
        System.out.println("3. misja 2");
        System.out.println("4. misja 3");
        System.out.println("5. misja jarla");
        System.out.println("6. misja gildii 1");
        System.out.println("7. misja gildii 2");
        System.out.println("8. misja gildii 3");
        System.out.println("9. Travel to another city");
    }

    public void menuNoGuild(Player player)
    {
        System.out.println("0. See your statistics");
        System.out.println("1. Enter the city");
        System.out.println("2. misja 1");
        System.out.println("3. misja 2");
        System.out.println("4. misja 3");
        System.out.println("5. misja jarla");
        System.out.println("6. Travel to another city");
    }

    public void menu(Player player)
    {
        switch (type)
        {
            case SOLITUDE ->
            {
                System.out.println("> YOU ARE STANDING IN THE SOLITUDE'S WALLS OUTER RING");
                menuNoGuild(player);

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" -> {}//misja1
                    case "3" -> {}//misja2
                    case "4" -> {}//misja3
                    case "5" -> {}//misja jarla
                    case "6" -> {player.travel();}
                }
            }
            case MORTHAL ->
            {
                System.out.println("> YOU ARE STANDING IN THE HAAFINGAR MARSHES. IN THE DISTANCE YOU SEE HOUSES OF MORTHAL");
                menuNoGuild(player);

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" -> {}//misja1
                    case "3" -> {}//misja2
                    case "4" -> {}//misja3
                    case "5" -> {}//misja jarla
                    case "6" -> {player.travel();}
                }
            }
            case MARKARTH ->
            {
                System.out.println("> YOU ARE STANDING IN FRONT OF GATES OF THE ANCIENT DWEMER CITY' - MARKARTH");
                menuNoGuild(player);

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" -> {}//misja1
                    case "3" -> {}//misja2
                    case "4" -> {}//misja3
                    case "5" -> {}//misja jarla
                    case "6" -> {player.travel();}
                }
            }
            case FALKREATH ->
            {
                System.out.println("> BETWEEN THE WOODS YOU SEE THE LIGHTS OF FALKREATH");
                menuGuild(player);

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" -> {}//misja1
                    case "3" -> {}//misja2
                    case "4" -> {}//misja3
                    case "5" -> {}//misja jarla
                    case "6" -> {}//misja gildii1
                    case "7" -> {}//misja gildii2
                    case "8" -> {}//misja gildii 3
                    case "9" -> {player.travel();}
                }
            }
            case WHITERUN ->
            {
                System.out.println("> YOU ARE STANDING IN FRONT OF THE WHITERUN WALLS");
                menuGuild(player);

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" -> {}//misja1
                    case "3" -> {}//misja2
                    case "4" -> {}//misja3
                    case "5" -> {}//misja jarla
                    case "6" -> {}//misja gildii1
                    case "7" -> {}//misja gildii2
                    case "8" -> {}//misja gildii 3
                    case "9" -> {player.travel();}
                }
            }
            case DAWNSTAR ->
            {
                System.out.println("> FROZEN BAY OF THE DAWNSTAR SHINES IN THE DISTANCE");
                menuNoGuild(player);

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" -> {}//misja1
                    case "3" -> {}//misja2
                    case "4" -> {}//misja3
                    case "5" -> {}//misja jarla
                    case "6" -> {player.travel();}
                }
            }
            case WINTERHOLD ->
            {
                System.out.println("> GIANT TOWERS OF COLLEGE OF WINTERHOLD STRIKES TO THE SKY");
                menuGuild(player);

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" -> {}//misja1
                    case "3" -> {}//misja2
                    case "4" -> {}//misja3
                    case "5" -> {}//misja jarla
                    case "6" -> {}//misja gildii1
                    case "7" -> {}//misja gildii2
                    case "8" -> {}//misja gildii 3
                    case "9" -> {player.travel();}
                }
            }
            case WINDHELM ->
            {
                System.out.println("> ON THE OTHER SIDE OF THE STONE BRIDGE STANDS ANCIENT CITY OF FORMER KINGS - WINDHELM");
                menuNoGuild(player);

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" -> {}//misja1
                    case "3" -> {}//misja2
                    case "4" -> {}//misja3
                    case "5" -> {}//misja jarla
                    case "6" -> {player.travel();}
                }
            }
            case RIFTEN ->
            {
                System.out.println("> FALLEN YELLOW AND RED LEAVES COVERS THE GROUND OF THE RIFT");
                menuGuild(player);

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" -> {}//misja1
                    case "3" -> {}//misja2
                    case "4" -> {}//misja3
                    case "5" -> {}//misja jarla
                    case "6" -> {}//misja gildii1
                    case "7" -> {}//misja gildii2
                    case "8" -> {}//misja gildii 3
                    case "9" -> {player.travel();}
                }
            }
        }
    }
}