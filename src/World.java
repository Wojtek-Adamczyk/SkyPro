public class World
{
    public World()
    {

        followers[0] = new Follower("Belrand", 100, 11, 2, cities[0]);
        followers[1] = new Follower("Benor", 110, 11, 1, cities[1]);
        followers[2] = new Follower("Vorstag", 130, 14, 1, cities[2]);
        followers[3] = new Follower("Rayya", 130, 12, 3, cities[3]);
        followers[4] = new Follower("Jenassa", 140, 12, 1, cities[4]);
        followers[5] = new Follower("Erandur", 110, 22, 0, cities[5]);
        followers[6] = new Follower("Golldir", 130, 12, 1, cities[6]);
        followers[7] = new Follower("Stenvar", 140, 15, 3, cities[7]);
        followers[8] = new Follower("Marcurio", 120, 20, 0, cities[8]);

        followers[9] = new Follower("Cicero", 130, 14, 0, cities[3]);
        followers[10] = new Follower("Farkas", 160, 16, 3, cities[4]);
        followers[11] = new Follower("J'zargo", 120, 22, 0, cities[6]);
        followers[12] = new Follower("Sapphire", 150, 13, 1, cities[8]);

        cities[0] = new City("Solitude", true, true, true, true, false, true, followers[0]);
        cities[1] = new City("Morthal", true, false, true, true, false, true, followers[1]);
        cities[2] = new City("Markarth", true, true, true, true, false, true, followers[2]);
        cities[3] = new City("Falkreath", true, true, false, true, true, true, followers[3], followers[9]);
        cities[4] = new City("Whiterun", true, true, true, true, true, true, followers[4], followers[10]);
        cities[5] = new City("Dawnstar", true, true, true, true, false, true, followers[5]);
        cities[6] = new City("Winterhold", true, false, false, true, true, true, followers[6], followers[11]);
        cities[7] = new City("Windhelm", true, true, true, true, false, true, followers[7]);
        cities[8] = new City("Riften", true, true, true, true, true, true, followers[8], followers[12]);
    }

    public City[] cities = new City[9];
    public Follower[] followers = new Follower[14];
}
