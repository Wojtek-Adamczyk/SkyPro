import java.io.IOException;
import java.util.Scanner;

public class Guild extends Building
{
    public enum Type
    {
        BROTHERHOOD("Dark Brotherhood"),
        COMPANIONS("Companions"),
        COLLEGE("College of Winterhold"),
        THIEVES("Thieves Guild");

        private final String name;

        Type(String name) {this.name = name;}
    }

    private final Type type;
    public Guild(Type type) {this.type = type;}

    Integer points = 0;

    public void greet()
    {
        if(type.name.equals("Dark Brotherhood")) {System.out.println("- Hail Sithis brother! Night Mother is asking for a next prey.");}
        if(type.name.equals("Companions")) {System.out.println("- Welcome shield-brother. Good to see you.");}
        if(type.name.equals("College of Winterhold")) {System.out.println("- Watch out with these spells, apprentice. You don't want to burn anything.");}
        if(type.name.equals("Thieves Guild")) {System.out.println("- How ya' doin' mate? Did ya' get your hands on something lately?");}
    }

    public void choices()
    {
        System.out.println("0. See your statistics");
        System.out.println("1. Take beginner mission");
        System.out.println("2. Take intermediate mission");
        System.out.println("3. Take advenced mission");
        System.out.println("4. Hire follower");
        System.out.println("5. Leave");
    }

    String brotherhoodQuestTaken = "- You fulfilled the will of a Dread-Father, child.";
    String companionQuestTaken = "- You've already fulfilled your duties";
    String collegeQuestTaken = "- You have already helped us a lot in this matter";
    String thievesQuestTaken = "- Those trinkets already disappeared, don't be too greedy, pal";

    public void menu(Player player) throws InterruptedException, IOException, ClassNotFoundException
    {
        switch (type)
        {
            case BROTHERHOOD ->
            {
                greet();
                choices();

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player); menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[37].completed)
                        {
                            points += 1;
                            System.out.println();
                            Dialogue.brotherhoodBeg();
                            player.currentCity.guild.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(brotherhoodQuestTaken); System.out.println();}
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[38].completed)
                        {
                            points += 2;
                            Dialogue.brotherhoodMid();
                            System.out.println();
                            player.currentCity.guild.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(brotherhoodQuestTaken); System.out.println();}
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[39].completed)
                        {
                            points += 3;
                            Dialogue.brotherhoodAdv();
                            System.out.println();
                            player.currentCity.guild.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(brotherhoodQuestTaken); System.out.println();}
                    }
                    case "4" ->
                    {
                        if (player.currentCity.guildFollower != null && points >= 6) {player.hireFollower(player.currentCity.guildFollower); player.money -= 500;}
                        else if (player.currentCity.guildFollower == null) System.out.println("- Cicero is already with you brother... isn't he?");
                        else {System.out.println("- You are not ready child. Take more lives in the name of Dread Father."); player.currentCity.menu(player); System.out.println();}
                        System.out.println();
                    }
                    case "5" -> {leave(player);}
                    case "save" -> {State.saveGame(player, player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
                }
            }

            case COMPANIONS ->
            {
                greet();
                choices();

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player); menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[40].completed)
                        {
                            points += 1;
                            Dialogue.companionBeg();
                            System.out.println();
                            player.currentCity.guild.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(companionQuestTaken); System.out.println();}
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[41].completed)
                        {
                            points += 2;
                            Dialogue.companionMid();
                            System.out.println();
                            player.currentCity.guild.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(companionQuestTaken); System.out.println();}
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[42].completed)
                        {
                            points += 3;
                            Dialogue.companionAdv();
                            System.out.println();
                            player.currentCity.guild.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(companionQuestTaken); System.out.println();}
                    }
                    case "4" ->
                    {
                        if (player.currentCity.guildFollower != null && points >= 6) {player.hireFollower(player.currentCity.guildFollower); player.money -= 500;}
                        else if (player.currentCity.guildFollower == null) System.out.println("- Farkas is your shield-brother now. Is everything good with him?");
                        else {System.out.println("- You haven't proven your worth yet, brother.");  player.currentCity.menu(player); System.out.println();}
                        System.out.println();
                    }
                    case "5" -> {leave(player);}
                    case "save" -> {State.saveGame(player, player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
                }
            }

            case COLLEGE ->
            {
                greet();
                choices();

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player); menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[43].completed)
                        {
                            points += 1;
                            Dialogue.collegeBeg();
                            System.out.println();
                            player.currentCity.guild.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(collegeQuestTaken); System.out.println();}
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[44].completed)
                        {
                            points += 2;
                            Dialogue.collegeMid();
                            System.out.println();
                            player.currentCity.guild.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(collegeQuestTaken); System.out.println();}
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[45].completed)
                        {
                            points += 3;
                            Dialogue.collegeAdv();
                            System.out.println();
                            player.currentCity.guild.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(collegeQuestTaken); System.out.println();}
                    }
                    case "4" ->
                    {
                        if (player.currentCity.guildFollower != null && points >= 6) {player.hireFollower(player.currentCity.guildFollower); player.money -= 500;
                        }
                        else if (player.currentCity.guildFollower == null) System.out.println("- What is it? J'zargo got bored with you and left?");
                        else
                        {
                            System.out.println("- Khajiit got better things to do than chasing after a rookie. Be back when you will be master in our arts.");
                            player.currentCity.menu(player);
                            System.out.println();
                        }
                        System.out.println();
                    }
                    case "5" -> {leave(player);}
                    case "save" -> {State.saveGame(player, player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
                }
            }

            case THIEVES ->
            {
                greet();
                choices();

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player); menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[46].completed)
                        {
                            points += 1;
                            Dialogue.thievesBeg();
                            System.out.println();
                            player.currentCity.guild.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(thievesQuestTaken); System.out.println();}
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[47].completed)
                        {
                            points += 2;
                            Dialogue.thievesMid();
                            System.out.println();
                            player.currentCity.guild.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(thievesQuestTaken); System.out.println();}
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[48].completed)
                        {
                            points += 3;
                            Dialogue.collegeAdv();
                            System.out.println();
                            player.currentCity.guild.menu(player);
                            System.out.println();
                        }
                        else {System.out.println(thievesQuestTaken); System.out.println();}
                    }
                    case "4" ->
                    {
                        if (player.currentCity.guildFollower != null && points >= 6) {player.hireFollower(player.currentCity.guildFollower); player.money -= 500;}
                        else if (player.currentCity.guildFollower == null) System.out.println("- What's wrong pal? Sapphire used you and disappeared?");
                        else {System.out.println("- If you can't help yourself, no one here can help you. Prove yourself and we'll talk.");  player.currentCity.menu(player); System.out.println();}
                        System.out.println();
                    }
                    case "5" -> {leave(player);}
                    case "save" -> {State.saveGame(player, player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
                }
            }
        }
    }
}
