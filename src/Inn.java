import java.util.Random;
import java.util.Scanner;

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

    public void rentRoom(Player player)
    {
        if (player.money >= 10)
        {
            player.currentHP = player.maximumHP;
            player.money -= 10;
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

    public void menu(Player player) throws InterruptedException
    {
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
                            System.out.println("- Bard's Guild is looking for someone to bring them some lost verse of ancient king Olaf One-Eye.");
                            System.out.print("They are convinced that taking the poem from Dead Man's Respite will wake this long-death and powerful dead ");
                            System.out.println("man and I can imagine he will not be happy with that.");
                            System.out.println("You know what I'm saying. That's why they haven't find any volunteer yet.");
                            System.out.println();
                        }
                        else {System.out.println(inkeeperQuestTaken); System.out.println();}
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[1].completed)
                        {
                            System.out.print("> You overheard the conversation between two Argonians. North-east of Solitude there is a cave inhabited by few smugglers.");
                            System.out.println(" They are convinced that no one knows about their location so they won't be aware and careful.");
                            System.out.println();
                        }
                        else {System.out.println(rumorsQuestTaken); System.out.println();}
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[2].completed)
                        {
                            System.out.print("> Daredevil needed, who will take care of necromancers residing in Wolfskull Cave west of the city");
                            System.out.println(" This is a dangerous task and queen Elisif the Fair takes no responsibility of anyone's death. Reward: 1200 septims. <");
                            System.out.println();
                        }
                        else {System.out.println(boardQuestTaken); System.out.println();}
                    }
                    case "4" -> {rentRoom(player);}
                    case "5" ->
                    {
                        if (player.currentCity.follower != null) {player.hireFollower(player.currentCity.follower);}
                        else System.out.println("> There is no one in the inn who wants to join you");
                    }
                    case "6" -> {pickpocket(player);}
                    case "7" -> {leave(player);}
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
                            System.out.println(" - Hey, stranger! I have an offer for you, because our so-called guards will not even lift a finger until it's too late.");
                            System.out.println("North of the town, there is cave. Powerful vampire Movart lives there and he's gathering his servants.");
                            System.out.println("Each day he's gaining more and more power. Please, do something about it and whole Morthal will be thankful.");
                            System.out.println("We do not have anything for you but I'm sure that you will find lots of treasures in his lair.");
                            System.out.println();
                        }
                        else {System.out.println(inkeeperQuestTaken); System.out.println();}
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[4].completed)
                        {
                            System.out.println("You heard conversation about woman called Alva. She has a hut somewhere in the swamps, where she's collecting their family treasures.");
                            System.out.println();
                        }
                        else {System.out.println(rumorsQuestTaken); System.out.println();}
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[5].completed)
                        {
                            System.out.println("> Volunteer is needed to hunt mudcrabs all over the swamps surrounding Mortahl. Jarl will reward the volunteer with 200 septims <");
                            System.out.println();
                        }
                        else {System.out.println(boardQuestTaken); System.out.println();}
                    }
                    case "4" -> {rentRoom(player);}
                    case "5" ->
                    {
                        if (player.currentCity.follower != null) {player.hireFollower(player.currentCity.follower);}
                        else System.out.println("> There is no one in the inn who wants to join you");
                        System.out.println();
                    }
                    case "6" -> {pickpocket(player);}
                    case "7" -> {leave(player);}
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
                            System.out.println(" - They say that some cannibal cult arranges its meetings in Hall of the Dead. Personally I don't think they are dangerous, if they were, why they need to hide themselves?");
                            System.out.println("Maybe you should check it out. Priests will be thankful.");
                            System.out.println();
                        }
                        else {System.out.println(inkeeperQuestTaken); System.out.println();}
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[7].completed)
                        {
                            System.out.println("> In the Silver-Blood Inn you overheard the conversation of two citizens about ancient Dwemer ruins in the east.");
                            System.out.println("Rumors has it it's full of treasures but no one is brave enough to fight with it's guardians - fearsome automatons.");
                            System.out.println();
                        }
                        else {System.out.println(rumorsQuestTaken); System.out.println();}
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[8].completed)
                        {
                            System.out.println("Jarl is looking for brave men or women to liberate Sanuarch Mine. Cave is currently inhabited by very dangerous Forsworn squad. Volunteer will be rewarded with 800 septims.");
                            System.out.println();
                        }
                        else {System.out.println(boardQuestTaken); System.out.println();}
                    }
                    case "4" -> {rentRoom(player);}
                    case "5" ->
                    {
                        if (player.currentCity.follower != null) {player.hireFollower(player.currentCity.follower);}
                        else System.out.println("> There is no one in the inn who wants to join you");
                        System.out.println();
                    }
                    case "6" -> {pickpocket(player);}
                    case "7" -> {leave(player);}
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
                    case "1" -> {}
                    case "2" -> {}
                    case "3" -> {}
                    case "4" -> {rentRoom(player);}
                    case "5" ->
                    {
                        if (player.currentCity.follower != null) {player.hireFollower(player.currentCity.follower);}
                        else System.out.println("> There is no one in the inn who wants to join you");
                        System.out.println();
                    }
                    case "6" -> {pickpocket(player);}
                    case "7" -> {leave(player);}
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
                    case "1" -> {System.out.println("");}
                    case "2" -> {}
                    case "3" -> {}
                    case "4" -> {rentRoom(player);}
                    case "5" ->
                    {
                        if (player.currentCity.follower != null) {player.hireFollower(player.currentCity.follower);}
                        else System.out.println("> There is no one in the inn who wants to join you");
                        System.out.println();
                    }
                    case "6" -> {pickpocket(player);}
                    case "7" -> {leave(player);}
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
                    case "1" -> {}
                    case "2" -> {}
                    case "3" -> {}
                    case "4" -> {rentRoom(player);}
                    case "5" ->
                    {
                        if (player.currentCity.follower != null) {player.hireFollower(player.currentCity.follower);}
                        else System.out.println("> There is no one in the inn who wants to join you");
                        System.out.println();
                    }
                    case "6" -> {pickpocket(player);}
                    case "7" -> {leave(player);}
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
                    case "1" -> {}
                    case "2" -> {}
                    case "3" -> {}
                    case "4" -> {rentRoom(player);}
                    case "5" ->
                    {
                        if (player.currentCity.follower != null) {player.hireFollower(player.currentCity.follower);}
                        else System.out.println("> There is no one in the inn who wants to join you");
                        System.out.println();
                    }
                    case "6" -> {pickpocket(player);}
                    case "7" -> {leave(player);}
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
                    case "1" -> {}
                    case "2" -> {}
                    case "3" -> {}
                    case "4" -> {rentRoom(player);}
                    case "5" ->
                    {
                        if (player.currentCity.follower != null) {player.hireFollower(player.currentCity.follower);}
                        else System.out.println("> There is no one in the inn who wants to join you");
                        System.out.println();
                    }
                    case "6" -> {pickpocket(player);}
                    case "7" -> {leave(player);}
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
                    case "1" -> {}
                    case "2" -> {}
                    case "3" -> {}
                    case "4" -> {rentRoom(player);}
                    case "5" ->
                    {
                        if (player.currentCity.follower != null) {player.hireFollower(player.currentCity.follower);}
                        else System.out.println("> There is no one in the inn who wants to join you");
                        System.out.println();
                    }
                    case "6" -> {pickpocket(player);}
                    case "7" -> {leave(player);}
                }
            }
        }
    }
}