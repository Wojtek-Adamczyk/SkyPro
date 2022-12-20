import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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

    String questCompleted = "> There's nothing more I can do there.";


    public void menu(Player player) throws InterruptedException
    {
        switch (type)
        {
            case SOLITUDE ->
            {
                System.out.println("> YOU ARE STANDING IN THE SOLITUDE'S WALLS OUTER RING");
                System.out.println("0. See your statistics");
                System.out.println("1. Enter the city");
                System.out.println("2. Examine Dead Man's Respite");
                System.out.println("3. Search for Smuggler's Cave");
                System.out.println("4. Examine the Wolfskull Cave");
                System.out.println("5. CLimb Mount Kilkreath");
                System.out.println("6. Travel to another city");

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" ->
                    {
                        System.out.println(player.world.missions[0].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[0].completed)
                        {
                            player.mission = player.world.missions[0];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "3" ->
                    {
                        System.out.println(player.world.missions[1].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[1].completed)
                        {
                            player.mission = player.world.missions[1];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "4" ->
                    {
                        System.out.println(player.world.missions[2].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[2].completed)
                        {
                            player.mission = player.world.missions[2];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "5" ->
                    {
                        System.out.println(player.world.missions[28].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[28].completed)
                        {
                            player.mission = player.world.missions[28];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "6" -> {player.travel();}
                }
            }
            case MORTHAL ->
            {
                System.out.println("> YOU ARE STANDING IN THE HAAFINGAR MARSHES. IN THE DISTANCE YOU SEE HOUSES OF MORTHAL");
                System.out.println("0. See your statistics");
                System.out.println("1. Enter the city");
                System.out.println("2. Examine Movarth's Lair");
                System.out.println("3. Search for Alva's hidden hut");
                System.out.println("4. Hunt mudcrabs");
                System.out.println("5. misja jarla");
                System.out.println("6. Travel to another city");

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" ->
                    {
                        System.out.println(player.world.missions[3].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[3].completed)
                        {
                            player.mission = player.world.missions[3];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "3" ->
                    {
                        System.out.println(player.world.missions[4].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[4].completed)
                        {
                            player.mission = player.world.missions[4];
                            player.mission.sneak(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "4" ->
                    {
                        System.out.println(player.world.missions[5].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[5].completed)
                        {
                            player.mission = player.world.missions[5];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "5" ->
                    {
                        System.out.println(player.world.missions[29].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[29].completed)
                        {
                            player.mission = player.world.missions[29];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "6" -> {player.travel();}
                }
            }
            case MARKARTH ->
            {
                System.out.println("> YOU ARE STANDING IN FRONT OF GATES OF THE ANCIENT DWEMER CITY' - MARKARTH");
                System.out.println("0. See your statistics");
                System.out.println("1. Enter the city");
                System.out.println("2. Search Hall of the Dead");
                System.out.println("3. Go to Arkngthand");
                System.out.println("4. Go to Sanuruch Mine");
                System.out.println("5. Go to Dragontooth Crater");
                System.out.println("6. Travel to another city");

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" ->
                    {
                        System.out.println(player.world.missions[6].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[6].completed)
                        {
                            player.mission = player.world.missions[6];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "3" ->
                    {
                        System.out.println(player.world.missions[7].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[7].completed)
                        {
                            player.mission = player.world.missions[7];
                            player.mission.sneak(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "4" ->
                    {
                        System.out.println(player.world.missions[8].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[8].completed)
                        {
                            player.mission = player.world.missions[8];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "5" ->
                    {
                        System.out.println(player.world.missions[30].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[30].completed)
                        {
                            player.mission = player.world.missions[30];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "6" -> {player.travel();}
                }
            }
            case FALKREATH ->
            {
                System.out.println("> BETWEEN THE WOODS YOU SEE THE LIGHTS OF FALKREATH");
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

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" ->
                    {
                        if (player.world.missions[0].completed == false)
                        {
                            player.mission = player.world.missions[0];
                            player.mission.fight(player);
                        }
                        else System.out.println("chuj");
                    }
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
                System.out.println("0. See your statistics");
                System.out.println("1. Enter the city");
                System.out.println("2. misja 1");
                System.out.println("3. misja 2");
                System.out.println("4. misja 3");
                System.out.println("5. misja jarla");
                System.out.println("6. Travel to another city");

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
                System.out.println("0. See your statistics");
                System.out.println("1. Enter the city");
                System.out.println("2. misja 1");
                System.out.println("3. misja 2");
                System.out.println("4. misja 3");
                System.out.println("5. misja jarla");
                System.out.println("6. Travel to another city");

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