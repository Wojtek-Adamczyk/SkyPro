import java.util.Scanner;

class City
{
    String name;
    Inn inn;
    Blacksmith blacksmith;
    Alchemist alchemist;
    Guild guild;
    Keep keep;
    Wilderness wilderness;

    boolean isKeep;
    boolean isBlacksmith;
    boolean isAlchemist;
    boolean isInn;
    boolean isGuild;
    boolean isWilderness;

    public boolean[] buildings = new boolean[6];

    City(String name, boolean isKeep, boolean isBlacksmith, boolean isAlchemist, boolean isInn, boolean isGuild, boolean isWilderness)
    {
        this.name = name;
        this.isKeep = isKeep;
        this.isBlacksmith = isBlacksmith;
        this.isAlchemist = isAlchemist;
        this.isInn = isInn;
        this.isGuild = isGuild;
        this.isWilderness = isWilderness;
        if (isKeep) buildings[0] = true;
        if (isBlacksmith) buildings[1] = true;
        if (isAlchemist) buildings[2] = true;
        if (isInn) buildings[3] = true;
        if (isGuild) buildings[4] = true;
        if (isWilderness) buildings[5] = true;
    }

    public City() {}

    public void menu(City city, Player player)
    {
        int i;
        for (i = 0; i <= 5; i++) {
            if (buildings[i] == true) {
                switch (i)
                {
                    case 0 -> {System.out.println("1. Go to the keep");}
                    case 1 -> {System.out.println("2. Go to the blacksmith");}
                    case 3 -> {System.out.println("3. Go to the alchemy shop");}
                    case 4 -> {System.out.println("4. Go to the inn");}
                    case 5 -> {System.out.println("5. Visit the guild");}
                    case 6 -> {System.out.println("4. Leave the city");}
                }
            }
        }

            Scanner input = new Scanner(System.in);
            String playerInput = input.nextLine();
            switch (playerInput)
            {
                case "0" -> city.blacksmith.sheet(player);
                case "1" -> {}
                case "2" -> city.blacksmith.interact(player);
                case "3" -> {city.alchemist.greet(player); city.alchemist.interact(player);}
            }




    }


}