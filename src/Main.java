public class Main
{
    public static void main(String[] args)
    {
        Player player = new Player(100,100,10,0,300);

        City[] cities = new City[9];

        System.out.println();

        cities[0] = new City("Solitude", true, true, true, true, false, true);
        cities[1] = new City("Morthal", true, false, true, true, false, true);
        cities[2] = new City("Markarth", true, true, true, true, false, true);
        cities[3] = new City("Falkreath", true, true, false, true, true, true);
        cities[4] = new City("Whiterun", true, true, true, true, true, true);
        cities[5] = new City("Dawnstar", true, true, true, true, false, true);
        cities[6] = new City("Winterhold", true, false, false, true, true, true);
        cities[7] = new City("Windhelm", true, true, true, true, false, true);
        cities[8] = new City("Riften", true, true, true, true, true, true);

        player.currentCity = cities[4];
        cities[4].menu(player);

        while (true)
        {
            player.currentCity.menu(player);
            System.out.println(player.currentCity);
        }
    }
}