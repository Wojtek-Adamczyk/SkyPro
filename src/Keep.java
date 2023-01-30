import java.io.IOException;
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

    public void pickpocket(Player player) throws InterruptedException, IOException, ClassNotFoundException
    {
        Random chance = new Random();
        int stealChance = chance.nextInt(0, 2);
        if (stealChance == 1)
        {
            Dialogue.pickpocket();
            player.follower = null;
            System.out.println();
            player.currentHP = player.maximumHP;
            player.money = 0;
            player.currentCity.menu(player);
        }
        else
        {
            Random stolen = new Random();
            int stolenMoney = stolen.nextInt(50,600);
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

    public void menu(Player player) throws InterruptedException, IOException, ClassNotFoundException
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
                        if (!player.world.missions[28].completed) {Dialogue.solitudeKeep();}
                        else {System.out.println(keepQuestTaken); System.out.println();}
                    }
                    case "2" -> pickpocket(player);
                    case "3" -> leave(player);
                    case "save" -> {State.saveGame(player, player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
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
                        if (!player.world.missions[29].completed) {Dialogue.morthalKeep();}
                        else {System.out.println(keepQuestTaken);System.out.println();}
                    }
                    case "2" -> pickpocket(player);
                    case "3" -> leave(player);
                    case "save" -> {State.saveGame(player, player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
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
                        if (!player.world.missions[30].completed) {Dialogue.markarthKeep();}
                        else {System.out.println(keepQuestTaken);System.out.println();}
                    }
                    case "2" -> pickpocket(player);
                    case "3" -> leave(player);
                    case "save" -> {State.saveGame(player, player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
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
                    case "1" ->
                    {
                        if (!player.world.missions[31].completed) {Dialogue.falkreathKeep();}
                        else {System.out.println(keepQuestTaken); System.out.println();}
                    }
                    case "2" -> pickpocket(player);
                    case "3" -> leave(player);
                    case "save" -> {State.saveGame(player, player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
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
                    case "1" ->
                    {
                        if (!player.world.missions[32].completed) {Dialogue.whiterunKeep();}
                        else {System.out.println(keepQuestTaken); System.out.println();}
                    }
                    case "2" -> {pickpocket(player);}
                    case "3" -> {leave(player);}
                    case "save" -> {State.saveGame(player, player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
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
                    case "1" ->
                    {
                        if (!player.world.missions[33].completed) {Dialogue.dawnstarKeep();}
                        else {System.out.println(keepQuestTaken); System.out.println();}
                    }
                    case "2" -> {pickpocket(player);}
                    case "3" -> {leave(player);}
                    case "save" -> {State.saveGame(player, player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
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
                    case "1" ->
                    {
                        if (!player.world.missions[34].completed) {Dialogue.winterholdKeep();}
                        else {System.out.println(keepQuestTaken); System.out.println();}
                    }
                    case "2" -> {pickpocket(player);}
                    case "3" -> {leave(player);}
                    case "save" -> {State.saveGame(player, player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
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
                    case "1" ->
                    {
                        if (!player.world.missions[35].completed) {Dialogue.windhelmKeep();}
                        else {System.out.println(keepQuestTaken); System.out.println();}
                    }
                    case "2" -> {pickpocket(player);}
                    case "3" -> {leave(player);}
                    case "save" -> {State.saveGame(player, player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
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
                    case "1" ->
                    {
                        if (!player.world.missions[36].completed) {Dialogue.riftenKeep();}
                        else {System.out.println(keepQuestTaken); System.out.println();}
                    }
                    case "2" -> {pickpocket(player);}
                    case "3" -> {leave(player);}
                    case "save" -> {State.saveGame(player, player.world);}
                    default -> {System.out.println("> Invalid command <"); System.out.println();}
                }
            }
        }
    }
}