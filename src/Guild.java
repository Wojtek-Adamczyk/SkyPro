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
        System.out.println("4. Leave");
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
                    case "1" -> {}
                    case "2" -> {}
                    case "3" -> {}
                    case "4" -> {leave(player);}
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
                    case "4" -> {leave(player);}
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
                    case "4" -> {leave(player);}
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
                    case "4" -> {leave(player);}
                }
            }
        }
    }
}
