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
            if (name.equals("Solitude")) {this.keep = new Keep(Keep.Type.SOLITUDE);}
            else if (name.equals("Morthal")) {this.keep = new Keep(Keep.Type.MORTHAL);}
            else if (name.equals("Markarth")) {this.keep = new Keep(Keep.Type.MARKARTH);}
            else if (name.equals("Falkreath")) {this.keep = new Keep(Keep.Type.FALKREATH);}
            else if (name.equals("Whiterun")) {this.keep = new Keep(Keep.Type.WHITERUN);}
            else if (name.equals("Dawnstar")) {this.keep = new Keep(Keep.Type.DAWNSTAR);}
            else if (name.equals("Winterhold")) {this.keep = new Keep(Keep.Type.WINTERHOLD);}
            else if (name.equals("Windhelm")) {this.keep = new Keep(Keep.Type.WINDHELM);}
            else if (name.equals("Riften")) {this.keep = new Keep(Keep.Type.RIFTEN);}
        }
        if (isBlacksmith) {buildings[1] = true; this.blacksmith = new Blacksmith();}
        if (isAlchemist) {buildings[2] = true; this.alchemist = new Alchemist();}
        if (isInn) {buildings[3] = true; this.inn = new Inn();}
        if (isGuild)
        {
            buildings[4] = true;
            if (name.equals("Falkreath")) {this.guild = new Guild(Guild.Type.BROTHERHOOD);}
            else if (name.equals("Whiterun")) {this.guild = new Guild(Guild.Type.COMPANIONS);}
            else if (name.equals("Winterhold")) {this.guild = new Guild(Guild.Type.COLLEGE);}
            else if (name.equals("Riften")) {this.guild = new Guild(Guild.Type.THIEVES);}
        }
        if (isWilderness) {buildings[5] = true; this.wilderness = new Wilderness();}
    }

    public void menu(Player player)
    {
        System.out.println("0. See your statistics");

        int i;
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
            else if (!buildings[i])
            {
                switch (i)
                {
                    case 1 -> System.out.println("2. <NOT AVILABLE>");
                    case 2 -> System.out.println("3. <NOT AVILABLE>");
                    case 4 -> System.out.println("5. <NOT AVILABLE>");
                }
            }
        }

        Scanner input = new Scanner(System.in);
        String playerInput = input.nextLine();
        switch (playerInput)
        {
            case "0" -> inn.sheet(player);
            case "1" -> {keep.menu(player);}
            case "2" -> {blacksmith.greet(player); blacksmith.interact(player);}
            case "3" -> {alchemist.greet(player); alchemist.interact(player);}
            case "4" -> {inn.greet(player); inn.interact(player);}
            case "5" -> {guild.menu(player);}
            case "6" -> {}
        }
    }
}