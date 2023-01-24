import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Inn extends Building
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

    private final Inn.Type type;
    public Inn(Inn.Type type) {this.type = type;}

    public void greet(Player player)
    {
        Random greet = new Random();
        Integer greeting = greet.nextInt(0,4);
        switch (greeting)
        {
            case 0 -> {System.out.println("- Come on in. Let me know if you need anything, or take a seat by the fire and I'll send someone over."); break;}
            case 1 -> {System.out.println("- Come on in. Just stoked the fire. Take a seat and get the cold out."); break;}
            case 2 -> {System.out.println("- Welcome. Let me know if you want anything... think I got a clean mug around here somewhere."); break;}
            case 3 -> {System.out.println("- Come on in. We got warm food, warm drinks, and warm beds."); break;}
        }
    }

    public void rentRoom(Player player) throws InterruptedException
    {
        if (player.money >= 10)
        {
            player.currentHP = player.maximumHP;
            player.money -= 10;
            System.out.println("> Drowsiness overwhelms you...");
            TimeUnit.SECONDS.sleep(8);
            System.out.println("> YOU AWAKEND FEELING WELL RESTED");
        }
        else System.out.println("- Come back when you will have enough gold.");
        System.out.println();
    }

    public void pickpocket(Player player)
    {
        Random chance = new Random();
        Integer stealChance = chance.nextInt(0, 10);
        if (stealChance == 1)
        {
            System.out.println("- Stop right there you criminal scum! You have commited crimes against Skyrim and her people. You will rot in jail!");
            System.out.println("> ALL YOUR BELONGINGS WERE CONFISCATED");
            System.out.println("> DURING JAIL TIME YOU CURED YOURSELF");
            player.follower = null;
            System.out.println();
            player.currentHP = player.maximumHP;
            player.money = 0;
        }
        else
        {
            Random stolen = new Random();
            Integer stolenMoney = stolen.nextInt(1,50);
            player.money += stolenMoney;
            System.out.println("> You stole " + stolenMoney + " septims");
            choices(player);
        }
    }

    public void choices(Player player)
    {
        System.out.println("0. See your statistics");
        System.out.println("1. Talk to the Innkeeper");
        System.out.println("2. Eavesdrop rumors");
        System.out.println("3. Examine the notice board");
        System.out.println("4. Rent a room for one night");
        System.out.println("5. Hire follower");
        System.out.println("6. Pickpocket");
        System.out.println("7. Leave");
    }

    String inkeeperQuestTaken = "- I told you everything I knew, traveller.";
    String rumorsQuestTaken = "> You don't hear anything interesting";
    String boardQuestTaken = "> You don't see anything interesting";

    public void menu(Player player) throws InterruptedException, IOException, ClassNotFoundException {
        switch (type)
        {
            case SOLITUDE ->
            {
                choices(player);

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[0].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(inkeeperQuestTaken); System.out.println();}
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[1].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(rumorsQuestTaken); System.out.println();}
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[2].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(boardQuestTaken); System.out.println();}
                    }
                    case "4" -> {rentRoom(player);}
                    case "5" ->
                    {
                        if (player.currentCity.follower != null) {player.hireFollower(player.currentCity.follower); player.currentCity.inn.menu(player); System.out.println();}
                        else System.out.println("> There is no one in the inn who wants to join you");
                    }
                    case "6" -> {pickpocket(player);}
                    case "7" -> {leave(player);}
                    case "save" -> {State.savePlayer(player); State.saveWorld(player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
                }
            }
            case MORTHAL ->
            {
                choices(player);

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[3].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(inkeeperQuestTaken); System.out.println();}
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[4].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(rumorsQuestTaken); System.out.println();}
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[5].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(boardQuestTaken); System.out.println();}
                    }
                    case "4" -> {rentRoom(player);}
                    case "5" ->
                    {
                        if (player.currentCity.follower != null) {player.hireFollower(player.currentCity.follower); player.currentCity.inn.menu(player); System.out.println();}
                        else System.out.println("> There is no one in the inn who wants to join you");
                        System.out.println();
                    }
                    case "6" -> {pickpocket(player);}
                    case "7" -> {leave(player);}
                    case "save" -> {State.savePlayer(player); State.saveWorld(player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
                }
            }
            case MARKARTH ->
            {
                choices(player);

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[6].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(inkeeperQuestTaken); System.out.println();}
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[7].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(rumorsQuestTaken); System.out.println();}
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[8].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(boardQuestTaken); System.out.println();}
                    }
                    case "4" -> {rentRoom(player);}
                    case "5" ->
                    {
                        if (player.currentCity.follower != null) {player.hireFollower(player.currentCity.follower); player.currentCity.inn.menu(player); System.out.println();}
                        else System.out.println("> There is no one in the inn who wants to join you");
                        System.out.println();
                    }
                    case "6" -> {pickpocket(player);}
                    case "7" -> {leave(player);}
                    case "save" -> {State.savePlayer(player); State.saveWorld(player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
                }
            }
            case FALKREATH ->
            {
                choices(player);

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[9].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(inkeeperQuestTaken); System.out.println();}
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[10].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(rumorsQuestTaken); System.out.println();}
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[11].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(boardQuestTaken); System.out.println();}
                    }
                    case "4" -> {rentRoom(player);}
                    case "5" ->
                    {
                        if (player.currentCity.follower != null) {player.hireFollower(player.currentCity.follower); player.currentCity.inn.menu(player); System.out.println();}
                        else System.out.println("> There is no one in the inn who wants to join you");
                        System.out.println();
                    }
                    case "6" -> {pickpocket(player);}
                    case "7" -> {leave(player);}
                    case "save" -> {State.savePlayer(player); State.saveWorld(player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
                }
            }
            case WHITERUN ->
            {
                choices(player);

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[12].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(inkeeperQuestTaken); System.out.println();}
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[13].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(rumorsQuestTaken); System.out.println();}
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[14].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(boardQuestTaken); System.out.println();}
                    }
                    case "4" -> {rentRoom(player);}
                    case "5" ->
                    {
                        if (player.currentCity.follower != null) {player.hireFollower(player.currentCity.follower); player.currentCity.inn.menu(player); System.out.println();}
                        else System.out.println("> There is no one in the inn who wants to join you");
                        System.out.println();
                    }
                    case "6" -> {pickpocket(player);}
                    case "7" -> {leave(player);}
                    case "save" -> {State.savePlayer(player); State.saveWorld(player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
                }
            }
            case DAWNSTAR ->
            {
                choices(player);

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[15].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(inkeeperQuestTaken); System.out.println();}
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[16].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(rumorsQuestTaken); System.out.println();}
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[17].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(boardQuestTaken); System.out.println();}
                    }
                    case "4" -> {rentRoom(player);}
                    case "5" ->
                    {
                        if (player.currentCity.follower != null) {player.hireFollower(player.currentCity.follower); player.currentCity.inn.menu(player); System.out.println();}
                        else System.out.println("> There is no one in the inn who wants to join you");
                        System.out.println();
                    }
                    case "6" -> {pickpocket(player);}
                    case "7" -> {leave(player);}
                    case "save" -> {State.savePlayer(player); State.saveWorld(player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
                }
            }
            case WINTERHOLD ->
            {
                choices(player);

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[18].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(inkeeperQuestTaken); System.out.println();}
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[19].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(rumorsQuestTaken); System.out.println();}
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[20].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(boardQuestTaken); System.out.println();}
                    }
                    case "4" -> {rentRoom(player);}
                    case "5" ->
                    {
                        if (player.currentCity.follower != null) {player.hireFollower(player.currentCity.follower); player.currentCity.inn.menu(player); System.out.println();}
                        else System.out.println("> There is no one in the inn who wants to join you");
                        System.out.println();
                    }
                    case "6" -> {pickpocket(player);}
                    case "7" -> {leave(player);}
                    case "save" -> {State.savePlayer(player); State.saveWorld(player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
                }
            }
            case WINDHELM ->
            {
                choices(player);

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[21].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(inkeeperQuestTaken); System.out.println();}
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[22].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(rumorsQuestTaken); System.out.println();}
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[23].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(boardQuestTaken); System.out.println();}
                    }
                    case "4" -> {rentRoom(player);}
                    case "5" ->
                    {
                        if (player.currentCity.follower != null) {player.hireFollower(player.currentCity.follower); player.currentCity.inn.menu(player); System.out.println();}
                        else System.out.println("> There is no one in the inn who wants to join you");
                        System.out.println();
                    }
                    case "6" -> {pickpocket(player);}
                    case "7" -> {leave(player);}
                    case "save" -> {State.savePlayer(player); State.saveWorld(player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
                }
            }
            case RIFTEN ->
            {
                choices(player);

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player);menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[24].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(inkeeperQuestTaken); System.out.println();}
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[25].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(rumorsQuestTaken); System.out.println();}
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[26].completed)
                        {
                            System.out.println();
                            player.currentCity.inn.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(boardQuestTaken); System.out.println();}
                    }
                    case "4" -> {rentRoom(player);}
                    case "5" ->
                    {
                        if (player.currentCity.follower != null) {player.hireFollower(player.currentCity.follower); player.currentCity.inn.menu(player); System.out.println();}
                        else System.out.println("> There is no one in the inn who wants to join you");
                        System.out.println();
                    }
                    case "6" -> {pickpocket(player);}
                    case "7" -> {leave(player);}
                    case "save" -> {State.savePlayer(player); State.saveWorld(player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
                }
            }
        }
    }
}