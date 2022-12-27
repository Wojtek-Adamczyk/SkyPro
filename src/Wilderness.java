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

    State gameState;
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
                    case "help" -> player.help();
                }
            }
            case MORTHAL ->
            {
                System.out.println("> YOU ARE STANDING IN THE HJAALMARCH MARSHES. IN THE DISTANCE YOU SEE HOUSES OF MORTHAL");
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
                    case "help" -> player.help();
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
                    case "help" -> player.help();
                }
            }
            case FALKREATH ->
            {
                System.out.println("> BETWEEN THE WOODS YOU SEE THE LIGHTS OF FALKREATH");
                System.out.println("0. See your statistics");
                System.out.println("1. Enter the city");
                System.out.println("2. Find Moss Mother Cave");
                System.out.println("3. Go to the graveyard");
                System.out.println("4. Search the forest");
                System.out.println("5. Go to Ancestors Glade");
                System.out.println("6. Search for abandoned shack");
                System.out.println("7. Go to Half-Moon Mill");
                System.out.println("8. Go to Penitus Oculatus Outpost");
                System.out.println("9. Travel to another city");

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" ->
                    {
                        System.out.println(player.world.missions[9].dialog);
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
                        System.out.println(player.world.missions[10].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[10].completed)
                        {
                            player.mission = player.world.missions[10];
                            player.mission.sneak(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "4" ->
                    {
                        System.out.println(player.world.missions[11].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[11].completed)
                        {
                            player.mission = player.world.missions[11];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "5" ->
                    {
                        System.out.println(player.world.missions[31].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[31].completed)
                        {
                            player.mission = player.world.missions[31];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "6" ->
                    {
                        System.out.println(player.world.missions[37].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[37].completed)
                        {
                            player.mission = player.world.missions[37];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "7" ->
                    {
                        System.out.println(player.world.missions[38].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[38].completed)
                        {
                            player.mission = player.world.missions[38];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "8" ->
                    {
                        System.out.println(player.world.missions[39].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[39].completed)
                        {
                            player.mission = player.world.missions[39];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "9" -> {player.travel();}
                    case "help" -> player.help();
                }
            }
            case WHITERUN ->
            {
                System.out.println("> YOU ARE STANDING IN FRONT OF THE WHITERUN WALLS");
                System.out.println("0. See your statistics");
                System.out.println("1. Enter the city");
                System.out.println("2. Go to Heimskr hut");
                System.out.println("3. Search for Elderglow Sanctuary");
                System.out.println("4. Search for Swindler's Den");
                System.out.println("5. Go to the Watchtower");
                System.out.println("6. Go to Pelagia's Farm");
                System.out.println("7. Go to Glenmoril Cave");
                System.out.println("8. Go to Gallows Rock");
                System.out.println("9. Travel to another city");

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" ->
                    {
                        System.out.println(player.world.missions[12].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[12].completed)
                        {
                            player.mission = player.world.missions[12];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "3" ->
                    {
                        System.out.println(player.world.missions[13].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[13].completed)
                        {
                            player.mission = player.world.missions[13];
                            player.mission.sneak(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "4" ->
                    {
                        System.out.println(player.world.missions[14].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[14].completed)
                        {
                            player.mission = player.world.missions[14];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "5" ->
                    {
                        System.out.println(player.world.missions[32].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[32].completed)
                        {
                            player.mission = player.world.missions[32];
                            player.mission.check(player);
                            player.damage += 1;
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "6" ->
                    {
                        System.out.println(player.world.missions[40].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[40].completed)
                        {
                            player.mission = player.world.missions[40];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "7" ->
                    {
                        System.out.println(player.world.missions[41].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[41].completed)
                        {
                            player.mission = player.world.missions[41];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "8" ->
                    {
                        System.out.println(player.world.missions[42].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[42].completed)
                        {
                            player.mission = player.world.missions[42];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "9" -> {player.travel();}
                    case "help" -> player.help();
                    case "save" -> player.gameState.saveGame();
                    case "load" -> {player.gameState.loadGame();
                    }

                }
            }
            case DAWNSTAR ->
            {
                System.out.println("> FROZEN BAY OF THE DAWNSTAR SHINES IN THE DISTANCE");
                System.out.println("0. See your statistics");
                System.out.println("1. Enter the city");
                System.out.println("2. Go to Windward Tower");
                System.out.println("3. Visit the Mythic Dawn Museum");
                System.out.println("4. Walk along the coast");
                System.out.println("5. Go to Nightcaller Temple");
                System.out.println("6. Travel to another city");

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" ->
                    {
                        System.out.println(player.world.missions[15].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[15].completed)
                        {
                            player.mission = player.world.missions[15];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "3" ->
                    {
                        System.out.println(player.world.missions[16].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[16].completed)
                        {
                            player.mission = player.world.missions[16];
                            player.mission.sneak(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "4" ->
                    {
                        System.out.println(player.world.missions[17].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[17].completed)
                        {
                            player.mission = player.world.missions[17];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "5" ->
                    {
                        System.out.println(player.world.missions[33].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[33].completed)
                        {
                            player.mission = player.world.missions[33];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "6" -> {player.travel();}
                    case "help" -> player.help();
                }
            }
            case WINTERHOLD ->
            {
                System.out.println("> GIANT TOWERS OF COLLEGE OF WINTERHOLD STRIKES TO THE SKY");
                System.out.println("0. See your statistics");
                System.out.println("1. Enter the city");
                System.out.println("2. Walk around the city");
                System.out.println("3. Go to the Nightgate Inn");
                System.out.println("4. Search the tundra");
                System.out.println("5. Go to Skytemple Ruins");
                System.out.println("6. Go to Saarthal");
                System.out.println("7. Go to Alftand");
                System.out.println("8. Search for Labirynthian");
                System.out.println("9. Travel to another city");

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" ->
                    {
                        System.out.println(player.world.missions[18].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[18].completed)
                        {
                            player.mission = player.world.missions[18];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "3" ->
                    {
                        System.out.println(player.world.missions[19].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[19].completed)
                        {
                            player.mission = player.world.missions[19];
                            player.mission.sneak(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "4" ->
                    {
                        System.out.println(player.world.missions[20].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[20].completed)
                        {
                            player.mission = player.world.missions[20];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "5" ->
                    {
                        System.out.println(player.world.missions[34].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[34].completed)
                        {
                            player.mission = player.world.missions[34];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "6" ->
                    {
                        System.out.println(player.world.missions[43].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[43].completed)
                        {
                            player.mission = player.world.missions[43];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "7" ->
                    {
                        System.out.println(player.world.missions[44].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[44].completed)
                        {
                            player.mission = player.world.missions[44];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "8" ->
                    {
                        System.out.println(player.world.missions[45].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[45].completed)
                        {
                            player.mission = player.world.missions[45];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "9" -> {player.travel();}
                    case "help" -> player.help();
                }
            }
            case WINDHELM ->
            {
                System.out.println("> ON THE OTHER SIDE OF THE STONE BRIDGE STANDS ANCIENT CITY OF FORMER KINGS - WINDHELM");
                System.out.println("0. See your statistics");
                System.out.println("1. Enter the city");
                System.out.println("2. Serach for a hunter's camp");
                System.out.println("3. Go to Viola Giordiano's household");
                System.out.println("4. Serach the forest");
                System.out.println("5. Go to Yngol Barrow");
                System.out.println("6. Travel to another city");

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" ->
                    {
                        System.out.println(player.world.missions[21].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[21].completed)
                        {
                            player.mission = player.world.missions[21];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "3" ->
                    {
                        System.out.println(player.world.missions[22].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[22].completed)
                        {
                            player.mission = player.world.missions[22];
                            player.mission.sneak(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "4" ->
                    {
                        System.out.println(player.world.missions[23].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[23].completed)
                        {
                            player.mission = player.world.missions[23];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "5" ->
                    {
                        System.out.println(player.world.missions[35].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[35].completed)
                        {
                            player.mission = player.world.missions[35];
                            player.mission.check(player);
                            player.armor += 1;
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "6" -> {player.travel();}
                    case "help" -> player.help();
                }
            }
            case RIFTEN ->
            {
                System.out.println("> FALLEN YELLOW AND RED LEAVES COVERS THE GROUND OF THE RIFT");
                System.out.println("0. See your statistics");
                System.out.println("1. Enter the city");
                System.out.println("2. Go to Black Briar Lodge");
                System.out.println("3. Go to the merchants camp");
                System.out.println("4. Go to Autumnshade Clearing");
                System.out.println("5. Go to Northwind Summit");
                System.out.println("6. Go to Merryfair Farm");
                System.out.println("7. Go to Goldenglow Estate");
                System.out.println("8. Go to Honningbrew Meadery");
                System.out.println("9. Travel to another city");

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);}
                    case "1" -> {player.currentCity.menu(player);}
                    case "2" ->
                    {
                        System.out.println(player.world.missions[24].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[24].completed)
                        {
                            player.mission = player.world.missions[24];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "3" ->
                    {
                        System.out.println(player.world.missions[25].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[25].completed)
                        {
                            player.mission = player.world.missions[25];
                            player.mission.sneak(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "4" ->
                    {
                        System.out.println(player.world.missions[26].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[26].completed)
                        {
                            player.mission = player.world.missions[26];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "5" ->
                    {
                        System.out.println(player.world.missions[36].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[36].completed)
                        {
                            player.mission = player.world.missions[36];
                            player.mission.check(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "6" ->
                    {
                        System.out.println(player.world.missions[46].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[46].completed)
                        {
                            player.mission = player.world.missions[46];
                            player.mission.sneak(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "7" ->
                    {
                        System.out.println(player.world.missions[47].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[47].completed)
                        {
                            player.mission = player.world.missions[47];
                            player.mission.sneak(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "8" ->
                    {
                        System.out.println(player.world.missions[48].dialog);
                        TimeUnit.SECONDS.sleep(2);
                        if (!player.world.missions[48].completed)
                        {
                            player.mission = player.world.missions[48];
                            player.mission.sneak(player);
                        }
                        else {System.out.println(questCompleted); System.out.println();}
                    }
                    case "9" -> {player.travel();}
                    case "help" -> player.help();
                }
            }
        }
    }
}