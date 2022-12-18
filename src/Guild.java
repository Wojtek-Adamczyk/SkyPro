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

    Integer points = 0;

    private final Type type;

    public Guild(Type type) {this.type = type;}

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

    public void menu(Player player)
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
                    case "1" -> {points += 1;}
                    case "2" -> {points += 2;}
                    case "3" -> {points += 3;}
                    case "4" ->
                    {
                        if (player.currentCity.guildFollower != null && points >= 6) {player.hireFollower(player.currentCity.guildFollower);}
                        else System.out.println("- You are not ready child. Take more lives in the name of Dread Father.");
                        System.out.println();
                    }
                    case "5" -> {leave(player);}
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
                    case "1" -> {System.out.println();}
                    case "2" -> {}
                    case "3" -> {}
                    case "4" ->
                    {
                        if (player.currentCity.guildFollower != null && points >= 6) {player.hireFollower(player.currentCity.guildFollower);}
                        else System.out.println("- You haven't proven your worth yet, brother.");
                        System.out.println();
                    }
                    case "5" -> {leave(player);}
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
                    case "1" -> {System.out.println();}
                    case "2" -> {System.out.println();}
                    case "3" -> {}
                    case "4" ->
                    {
                        if (player.currentCity.guildFollower != null && points >= 6) {player.hireFollower(player.currentCity.guildFollower);}
                        else System.out.println("- Khajiit got better things to do than chasing after a rookie. Be back when you will be master at our arts.");
                        System.out.println();
                    }
                    case "5" -> {leave(player);}
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
                    case "1" -> {System.out.println();}
                    case "2" -> {}
                    case "3" -> {System.out.println();}
                    case "4" ->
                    {
                        if (player.currentCity.guildFollower != null && points >= 6) {player.hireFollower(player.currentCity.guildFollower);}
                        else System.out.println("- If you can't help yourself, no one here can help you. Prove yourself and we'll talk.");
                        System.out.println();
                    }
                    case "5" -> {leave(player);}
                }
            }
        }
    }
}
