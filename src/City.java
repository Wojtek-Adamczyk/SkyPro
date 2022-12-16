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

        if (isKeep)
        {
            buildings[0] = true;
            this.keep = new Keep();
        }
        if (isBlacksmith)
        {
            buildings[1] = true;
            this.blacksmith = new Blacksmith();
        }
        if (isAlchemist)
        {
            buildings[2] = true;
            this.alchemist = new Alchemist();
        }
        if (isInn)
        {
            buildings[3] = true;
            this.inn = new Inn();
        }
        if (isGuild)
        {
            buildings[4] = true;
            this.guild = new Guild();
        }
        if (isWilderness)
        {
            buildings[5] = true;
            this.wilderness = new Wilderness();
        }
    }

    public void menu(Player player)
    {
        int i;
        System.out.println("0. See your statistics");
        for (i = 0; i <= 5; i++)
        {
            if (buildings[i])
            {
                switch (i)
                {
                    case 0 -> System.out.println("1. Go to the keep");
                    case 1 -> System.out.println("2. Go to the blacksmith");
                    case 2 -> System.out.println("3. Go to the alchemy shop");
                    case 3 -> System.out.println("4. Go to the inn");
                    case 4 -> System.out.println("5. Visit the guild");
                    case 5 -> System.out.println("6. Leave the city");

                }
            }
        }

        Scanner input = new Scanner(System.in);
        String playerInput = input.nextLine();
        switch (playerInput)
        {
            case "0" -> inn.sheet(player);
            case "1" -> {}
            case "2" -> {blacksmith.greet(player); blacksmith.interact(player);}
            case "3" -> {alchemist.greet(player); alchemist.interact(player);}
            case "4" -> {inn.greet(player); inn.interact(player);}
            case "5" -> {}
            case "6" -> {}
        }

    }

}