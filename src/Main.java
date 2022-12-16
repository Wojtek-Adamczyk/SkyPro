import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Player player = new Player(100,100,10,0,300);

        System.out.println();

        City solitude = new City("Solitude", true, true, true, true, false, true);
        City morthal = new City("Morthal", true, false, true, true, false, true);
        City markarth = new City("Markarth", true, true, true, true, false, true);
        City falkreath = new City("Falkreath", true, true, false, true, true, true);
        City whiterun = new City("Whiterun", true, false, true, true, true, true);
        City dawnstar = new City("Dawnstar", true, true, true, true, false, true);
        City winterhold = new City("Winterhold", true, false, false, true, true, true);
        City windhelm = new City("Windhelm", true, true, true, true, false, true);
        City riften = new City("Riften", true, true, true, true, true, true);

        solitude.menu(player);







    }
}