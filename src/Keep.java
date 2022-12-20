import java.util.Random;
import java.util.Scanner;

public class Keep extends Building
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

    private final Type type;
    public Keep(Type type) {this.type = type;}

    public void pickpocket(Player player) throws InterruptedException {
        Random chance = new Random();
        Integer stealChance = chance.nextInt(0, 2);
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
            Integer stolenMoney = stolen.nextInt(50,600);
            player.money += stolenMoney;
            System.out.println("> You stole " + stolenMoney + " septims");
            menu(player);
        }
    }

    public void greet()
    {
        if(type.name.equals("Solitude")) {System.out.println("- If you have business, please see Falk Firebeard, my steward.");}
        if(type.name.equals("Morthal")) {System.out.println("- So, life has brought you to Morthal, and to me. What purpose this serves, we will no doubt see. Welcome.");}
        if(type.name.equals("Markarth")) {System.out.println("- You speak to Igmund. Son of Hrolfdir. Jarl of Markarth");}
        if(type.name.equals("Falkreath")) {System.out.println("- Yes? What is it that you want?");}
        if(type.name.equals("Whiterun")) {System.out.println("- May the gods watch over your battles. What do you need?");}
        if(type.name.equals("Dawnstar")) {System.out.println("- Don't bother me unless it's important.");}
        if(type.name.equals("Winterhold")) {System.out.println("- What's your business here in Winterhold?");}
        if(type.name.equals("Windhelm")) {System.out.println("- Only the foolish or the courageous approach a Jarl without summons... Anyway, what do you want? ");}
        if(type.name.equals("Riften")) {System.out.println("- Speak, I wish to hear everything my subjects have to say");}
    }

    public void choices()
    {
        System.out.println("0. See your statistics");
        System.out.println("1. Talk to Jarl");
        System.out.println("2. Pickpocket");
        System.out.println("3. Leave");
    }

    String keepQuestTaken = "- Thank you Dovakiin, we owe you an eternal and infinity debt";

    public void menu(Player player) throws InterruptedException
    {
        switch (type)
        {
            case SOLITUDE ->
            {
                choices();

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player); menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[28].completed)
                        {
                            System.out.println(" - In the name of Queen Elisif, wife of High King Torygg, and all citizens of Haafingar I humbly beg you to kill dragon residing on the Mount Kilkreath.");
                            System.out.println(" You will be rewarded with two thousand septims and forever will be recognized as honorary citizen of Solitude.");
                            System.out.println();
                        }
                        else {System.out.println(keepQuestTaken); System.out.println();}
                    }
                    case "2" -> {pickpocket(player);}
                    case "3" -> {leave(player);}
                }
            }
            case MORTHAL ->
            {
                choices();

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player); menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[29].completed)
                        {
                            System.out.println(" - Yes... I have seen you in my dreams, Dovakiin. Your destiny is to stop the dragons. And the dragon in Eldersblood Peak is a sign. You have to kill it.");
                            System.out.println("Morthal isn't reach hold, but I'm sure you will be rewarded wtih... let's say one thousand septims for killing the beast.");
                            System.out.println();
                        }
                        else
                        {
                            System.out.println(keepQuestTaken);
                            System.out.println();
                        }
                    }
                    case "2" -> {pickpocket(player);}
                    case "3" -> {leave(player);}
                }
            }
            case MARKARTH ->
            {
                choices();

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player); menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[30].completed)
                        {
                            System.out.println(" - By the name of Eight or any different gods you believe. You have to protect the city from dragon that infested in Dragontooth Crater!");
                            System.out.println("Markarth flows with silver and blood. If you will come back, then you will have enough silver for a long time. If not, well... I will pray for your soul");
                            System.out.println();
                        }
                        else
                        {
                            System.out.println(keepQuestTaken);
                            System.out.println();
                        }
                    }
                    case "2" -> {pickpocket(player);}
                    case "3" -> {leave(player);}
                }
            }
            case FALKREATH ->
            {
                choices();

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player); menu(player);}
                    case "1" -> {}
                    case "2" -> {pickpocket(player);}
                    case "3" -> {leave(player);}
                }
            }
            case WHITERUN ->
            {
                choices();

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player); menu(player);}
                    case "1" -> {}
                    case "2" -> {pickpocket(player);}
                    case "3" -> {leave(player);}
                }
            }
            case DAWNSTAR ->
            {
                choices();

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player); menu(player);}
                    case "1" -> {}
                    case "2" -> {pickpocket(player);}
                    case "3" -> {leave(player);}
                }
            }
            case WINTERHOLD ->
            {
                choices();

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player); menu(player);}
                    case "1" -> {}
                    case "2" -> {pickpocket(player);}
                    case "3" -> {leave(player);}
                }
            }
            case WINDHELM ->
            {
                choices();

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player); menu(player);}
                    case "1" -> {}
                    case "2" -> {pickpocket(player);}
                    case "3" -> {leave(player);}
                }
            }
            case RIFTEN ->
            {
                choices();

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player); menu(player);}
                    case "1" -> {}
                    case "2" -> {pickpocket(player);}
                    case "3" -> {leave(player);}
                }
            }
        }
    }
}