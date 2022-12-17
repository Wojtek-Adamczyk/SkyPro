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

        public final String name;
        Type(String name) {this.name = name;}
    }

    private final Type type;

    public Keep(Type type) {this.type = type;}


    public void pickpocket(Player player)
    {
        Random chance = new Random();
        Integer stealChance = chance.nextInt(0, 2);
        if (stealChance == 1)
        {
            System.out.println("- Stop right there you criminal scum! You have commited crimes against Skyrim and her people. You will rot in jail!");
            System.out.println("> ALL YOUR BELONGINGS WERE CONFISCATED");
            System.out.println("> DURING JAIL TIME YOU CURED YOURSELF");
            // usun followera
            System.out.println();
            player.currentHP = player.maximumHP;
            player.money = 0;
        }
        else
        {
            Random stolen = new Random();
            Integer stolenMoney = stolen.nextInt(1,600);
            player.money += stolenMoney;
            System.out.println("> You stole " + stolenMoney + " septims");
            interact(player);
        }
    }

    public void sheet(Player player)
    {
        System.out.println("HP: " + player.currentHP + "/" + player.maximumHP);
        System.out.println("Damage: " + player.damage);
        System.out.println("Armor: " + player.armor);
        System.out.println("Money: " + player.money + " septims");
        System.out.println();
        interact(player);
    }

    public void interact(Player player)
    {
        Scanner input = new Scanner(System.in);
        int playerInput = input.nextInt();

        if (playerInput == 0) {sheet(player);}
       // else if (playerInput == 1) {talkToJarl(player);}
        else if (playerInput == 2) {pickpocket(player);}
        else if (playerInput == 3) {leave(player);}
    }

    public void leave(Player player)
    {
        player.building = null;
        player.currentCity.menu(player);
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

    public void menu(Player player)
    {
        switch (type)
        {
            case SOLITUDE ->
            {

            }
            case MORTHAL ->
            {

            }
            case MARKARTH ->
            {

            }
            case FALKREATH ->
            {

            }
            case WHITERUN ->
            {

            }
            case DAWNSTAR ->
            {

            }
            case WINTERHOLD ->
            {

            }
            case WINDHELM ->
            {

            }
            case RIFTEN ->
            {

            }
        }

    }
}