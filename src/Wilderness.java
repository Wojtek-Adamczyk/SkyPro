import java.io.IOException;
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

    State state;

    public void menu(Player player) throws InterruptedException, IOException, ClassNotFoundException
    {
        switch (type)
        {
            case SOLITUDE ->
            {
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
                }
            }
            case DAWNSTAR ->
            {
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