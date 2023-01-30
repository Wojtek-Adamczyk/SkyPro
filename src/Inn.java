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
            System.out.println("> YOU AWAKENED FEELING WELL RESTED");
        }
        else System.out.println("- Come back when you will have enough gold.");
        System.out.println();
    }

    public void pickpocket(Player player) throws IOException, InterruptedException, ClassNotFoundException {
        Random chance = new Random();
        int stealChance = chance.nextInt(0, 10);
        if (stealChance == 1)
        {
            Dialogue.pickpocket();
            player.follower = null;
            System.out.println();
            player.currentHP = player.maximumHP;
            player.currentCity.menu(player);
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

    public void menu(Player player) throws InterruptedException, IOException, ClassNotFoundException
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
                            System.out.println("- Bard's Guild is looking for someone to bring them some lost verse of ancient king Olaf One-Eye.\n" +
                                    "They are convinced that taking the poem from Dead Man's Respite will wake this long-death and powerful dead \n" +
                                    "man and I can imagine he will not be happy with that.\n" +
                                    "You know what I'm saying. That's why they haven't find any volunteer yet.");
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
                            System.out.println("> You overheard the conversation between two Argonians. North-east of Solitude there is a cave inhabited by few smugglers.\n" +
                                    "They are convinced that no one knows about their location so they won't be aware and careful.");
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
                            System.out.println("> Daredevil needed, who will take care of necromancers residing in Wolfskull Cave west of the city\n" +
                                    "This is a dangerous task and queen Elisif the Fair takes no responsibility of anyone's death. Reward: 1200 septims. <");
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
                    case "save" -> {State.saveGame(player, player.world);}
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
                            System.out.println("North of the town, there is cave. Powerful vampire Movart lives there and he's gathering his servants.\n" +
                                    "Each day he's gaining more and more power. Please, do something about it and whole Morthal will be thankful.\n" +
                                    "We do not have anything for you but I'm sure that you will find lots of treasures in his lair.");
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
                            System.out.println("> You heard conversation about woman called Alva. She has a hut somewhere in the swamps, where she's collecting their family treasures.");
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
                            System.out.println("> Volunteer is needed to hunt mudcrabs all over the swamps surrounding Mortahl. Jarl will reward the volunteer with 200 septims <");
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
                    case "save" -> {State.saveGame(player, player.world);}
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
                            System.out.println("- They say that some cannibal cult arranges its meetings in Hall of the Dead. Personally I don't think they are dangerous, if they were, why they need to hide themselves?\n" +
                                    "Maybe you should check it out. Priests will be thankful.");
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
                            System.out.println("> In the Silver-Blood Inn you overheard the conversation of two citizens about ancient Dwemer ruins in the east.\n" +
                                    "Rumors has it it's full of treasures but no one is brave enough to fight with it's guardians - fearsome automatons.");
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
                            System.out.println("> Jarl is looking for brave men or women to liberate Sanuarch Mine. Cave is currently inhabited by very dangerous Forsworn squad. Volunteer will be rewarded with 800 septims. <");
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
                    case "save" -> {State.saveGame(player, player.world);}
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
                    case "0" -> {player.sheet(player); menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[9].completed)
                        {
                            System.out.println("- People say that a monstrous bear has a lair in a nearby cave. They make bets who will kill the beasts first... You look like a tough man. Maybe you will kill the beast before it will hurt one of these imbecils?");
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
                            System.out.println("> You overheard a rumor that someone heard a rumor that one of the Jarl's prisoners buried a ring of extraordinary value in the cemetery. The point is that the place is haunted by the ghosts or skeletons");
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
                            System.out.println("> Jarl is looking for a daredevil who will slay Deadra lurking around the town. Risk is high but the payment is even higher <");
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
                    case "save" -> {State.saveGame(player, player.world);}
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
                            System.out.println("- Have you heard of Heimskr? This man comes to town every day and speaks in the forum about Talos and his divinity. Another moment and it will bring misfortune to the city.\n" +
                                    "Everyone would be grateful if someone shut his mouth, like... forever.");
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
                            System.out.println("> You've heard rumors of a cave called the Elderglow Sanctuary. wealthy nobles go there to drink the sap from the Elderglow Tree to ensure good luck in business and health, but many of them do not return.\n" +
                                    "If their bodies are still there, there's certainly a lot of gold to be found there");
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
                            System.out.println("> Jarl put a bounty on the head of the Redguard rebel who orchestrated the assassination of the Thalmor ambassador. Recent information on his whereabouts points to his whereabouts at Swindler's Den. Reward: 500 septims <");
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
                    case "save" -> {State.saveGame(player, player.world);}
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
                            System.out.println("- No one in town can sleep. It's been like this for a few weeks since this mage moved into the Windward Tower on the shore. No one knows what he's doing there, but people are saying more and more that he cursed us.\n" +
                                    "Maybe... would you take care of this problem?");
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
                            System.out.println("> You heard that the curator of the newly created Mythic Dawn Museum has collected many legendary items, including one extremely valuable - the necklace of Mankar Camoran, the leader of the cult during the Oblivion Crisis\n");
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
                            System.out.println("> Jarl offered a bounty of 600 septims for killing an extremely dangerous horker that had already killed four experienced hunters. The beast has a lair somewhere on the shores of the Sea of Ghosts. <");
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
                    case "save" -> {State.saveGame(player, player.world);}
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
                            System.out.println("- A pack of wolves has been attacking travelers lately. Together with the citizens, we collected a small amount for a volunteer who will take care of this matter, but so far no one has come forward");
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
                            System.out.println("> You overheard that some rich nobleman who wanted to visit the College is staying at the Nightgate Inn a short distance from the town");
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
                            System.out.println("> Jarl offered a bounty for getting rid of the elemental accidentally created by the mages. The beast is unpredictable and dangerous, so the jarl has also banned ordinary people from taking this task <\n");
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
                    case "save" -> {State.saveGame(player, player.world);}
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
                            System.out.println("- These out-of-town hunters are asking for a brawl... They come here every day and drink and then hurl racial slurs at Dunmers and Argonians. It scares away all non-human clients.\n" +
                                    "Why don't you take care of them for a few gold coins? No one will miss them.");
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
                            System.out.println("> You overheard Dunmer and Argonian talking about the Viola Giordiano's ring they plan to steal.");
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
                            System.out.println("> King Ulfric seeks out a seasoned tracker to track down and kill the fugitive criminal responsible for three murderers in the Windhelm. Reward: 1000 septims <");
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
                    case "save" -> {State.saveGame(player, player.world);}
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
                            System.out.println("- These Briar Rose Meadery thugs come here every week and demand some protection money and the Jarl doesn't do anything about it. The citizens would take care of it themselves, but their seat is a real fortress.\n" +
                                    "But you... you seem like someone who could help us.");
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
                            System.out.println("> You've heard rumors that one of the merchants camping near the city never closes his chest of valuables, as if he's waiting for someone to get at them");
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
                            System.out.println("\n" +
                                    "> Jarl is looking for a volunteer to collect Nirnroot for the court alchemist. To the best of honorable Wylandriah knowledge, Nirnroot grows at Sutumnshade Clearing infested with aggresive spriggans. Reward: 300 septims <");
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
                    case "save" -> {State.saveGame(player, player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
                }
            }
        }
    }
}