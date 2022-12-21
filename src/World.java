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

        cities[0] = new City("Solitude", true, true, true, true, false, true, true, followers[0]);
        cities[1] = new City("Morthal", true, false, true, true, false, false, true, followers[1]);
        cities[2] = new City("Markarth", true, true, true, true, false, false, true, followers[2]);
        cities[3] = new City("Falkreath", true, true, false, true, true, false, true, followers[3], followers[9]);
        cities[4] = new City("Whiterun", true, true, true, true, true, false,true, followers[4], followers[10]);
        cities[5] = new City("Dawnstar", true, true, true, true, false, false, true, followers[5]);
        cities[6] = new City("Winterhold", true, false, false, true, true, false,true, followers[6], followers[11]);
        cities[7] = new City("Windhelm", true, true, true, true, false, false, true, followers[7]);
        cities[8] = new City("Riften", true, true, true, true, true, true,true, followers[8], followers[12]);

        enemies[0] = new Enemy(0);
        enemies[1] = new Enemy(1);
        enemies[2] = new Enemy(2);
        enemies[3] = new Enemy(3);
        enemies[4] = new Enemy(4);
        enemies[5] = new Enemy(5);
        enemies[6] = new Enemy(6);
        enemies[7] = new Enemy(7);
        enemies[8] = new Enemy(8);
        enemies[9] = new Enemy(9);
        enemies[10] = new Enemy(10);

        missions[0] = new Mission("> King Olaf's tomb exudes sinister energy", enemies[1], enemies[0].reward, false, cities[0], 0);
        missions[1] = new Mission("> There are several bags with various things next to the cave", enemies[0], enemies[0].reward, false, cities[0], 2);
        missions[2] = new Mission("> As you enter the cave you hear the necromancers incanting some ritual", enemies[2], enemies[0].reward + 1200, false, cities[0], 0);
        missions[3] = new Mission("> The filthy cave is filled with human bones and a disgusting smell emanates from inside", enemies[5], enemies[0].reward, false, cities[1], 0);
        missions[4] = new Mission("> Turns out Alva is a vampire, but the ring on the table looks valuable indeed", enemies[5], enemies[0].reward, false, cities[1], 4);
        missions[5] = new Mission("> The swamps are vast but the crabs make familiar sounds", enemies[3], enemies[0].reward + 200, false, cities[1], 0);
        missions[6] = new Mission("> Hall of the Dead seems quiet, but after few moments you see a group of people devouring on a corpse", enemies[0], enemies[0].reward, false, cities[2], 0);
        missions[7] = new Mission("> As the clatter of the gate dies down, only gusts of steam and steady knocking can be heard", enemies[1], enemies[0].reward, false, cities[2], 5);
        missions[8] = new Mission("> When you enter the mine, you see fornsworns taking clothes and money from the murdered people", enemies[1], enemies[0].reward + 800, false, cities[2], 0);
        missions[9] = new Mission("> Animal, and not only animal bones spill out of the cave", enemies[6], enemies[0].reward, false, cities[3], 0);
        missions[10] = new Mission("> A strange mist hovers over the graves", enemies[0], enemies[0].reward, false, cities[3], 0);
        missions[11] = new Mission("> As you make your way through the dense forest, you suddenly smell sulfur", enemies[9], enemies[0].reward, false, cities[3], 0);
        missions[12] = new Mission("> Heimskr's hut looks warm and welcoming", enemies[0], enemies[0].reward, false, cities[4], 0);
        missions[13] = new Mission("> A strange unnatural flash comes from the Elderglow Cave", enemies[8], enemies[0].reward, false, cities[4], 5);
        missions[14] = new Mission("> Swinder's Den is well hidden among the rocks of the lowlands", enemies[1], enemies[0].reward + 500, false, cities[4], 0);


        missions[15] = new Mission("-chuj ci na łeb", enemies[3], enemies[0].reward, false, cities[5], 0);
        missions[16] = new Mission("-chuj ci na łeb", enemies[3], enemies[0].reward, false, cities[5], 0);
        missions[17] = new Mission("-chuj ci na łeb", enemies[3], enemies[0].reward, false, cities[5], 0);

        missions[18] = new Mission("-chuj ci na łeb", enemies[3], enemies[0].reward, false, cities[6], 0);
        missions[19] = new Mission("-chuj ci na łeb", enemies[3], enemies[0].reward, false, cities[6], 0);
        missions[20] = new Mission("-chuj ci na łeb", enemies[3], enemies[0].reward, false, cities[6], 0);

        missions[21] = new Mission("-chuj ci na łeb", enemies[3], enemies[0].reward, false, cities[7], 0);
        missions[22] = new Mission("-chuj ci na łeb", enemies[3], enemies[0].reward, false, cities[7], 0);
        missions[23] = new Mission("-chuj ci na łeb", enemies[3], enemies[0].reward, false, cities[7], 0);

        missions[24] = new Mission("-chuj ci na łeb", enemies[3], enemies[0].reward, false, cities[8], 0);
        missions[25] = new Mission("-chuj ci na łeb", enemies[3], enemies[0].reward, false, cities[8], 0);
        missions[26] = new Mission("-chuj ci na łeb", enemies[3], enemies[0].reward, false, cities[8], 0);

        // missions[27] - there is one break mission because I can't count

        missions[28] = new Mission("> As you climbing higher, you see marks of dragon's claws in the snow", enemies[4], enemies[0].reward + 2000, false, cities[0], 0);
        missions[29] = new Mission("> In the distance you see Eldersblood Peak and marks of dragon's presence between the marsh trees", enemies[4], enemies[0].reward + 1000, false, cities[1], 0);
        missions[30] = new Mission("> Mountains and ravines of The Reach hold seems a perfect place to dragon's lair", enemies[4], enemies[0].reward + 1500, false, cities[0], 0);
        missions[31] = new Mission("> Forests near Ancestors Glade are really magnificent, but some of them have marks of dragon's claws on them", enemies[4], enemies[0].reward + 200, false, cities[3], 0);
        missions[32] = new Mission("> Even from afar you can see how much destruction the dragon has caused in the Watchtower", enemies[4], enemies[0].reward + 750, false, cities[4], 0);
        missions[33] = new Mission("> Walls of the temple are destroyed by dragon's claws and fire, and smell of burned bodies emanates in the air", enemies[4], enemies[0].reward + 500, false, cities[5], 0);
        missions[34] = new Mission("> Skytemple Ruins are indeed ruins, but despite everything the presence of dragon is tangible", enemies[4], enemies[0].reward + 500, false, cities[6], 0);
        missions[35] = new Mission("> The Yngol Barrow is burned by dragon almost to the ground. partially it's still smoldering", enemies[4], enemies[0].reward + 1000, false, cities[7], 0);
        missions[36] = new Mission("> The closer you get to Northwind Summit, the more it seems to you that there is no better place for a dragon lair", enemies[4], enemies[0].reward + 1000, false, cities[8], 0);

        missions[37] = new Mission("> An abandoned hut is located by a small stream. inside are the remains of an primitive bonfire", enemies[3], enemies[0].reward, false, cities[3], 0);
        missions[38] = new Mission("> The mill wheel is in full swing. you can hear the pleasant crackling of grains crushed by the millstones", enemies[5], enemies[0].reward, false, cities[3], 0);
        missions[39] = new Mission("> The outpost is surrounded by a small stone wall and continuously patrolled by soldiers, but nobody notice your presence", enemies[7], enemies[0].reward, false, cities[3], 0);
        missions[40] = new Mission("> The shed is sealed off from the outside and the farmers seem scared of whats inside", enemies[6], enemies[0].reward, false, cities[4], 0);
        missions[41] = new Mission("> In front of the cave you can see several goat heads impaled on poles and a trickle of musty blood leads inside", enemies[2], enemies[0].reward, false, cities[4], 0);
        missions[42] = new Mission("> Gallows rock is smaller than suggested. over the arch of the gate there are several hanged men, devoured by birds and silver hand soldiers watch over the walls", enemies[7], enemies[0].reward, false, cities[4], 0);
        missions[43] = new Mission("> The ruins of Saarthal make an ominous impression. standing over the excavations, you see archaeologists bustling around", enemies[0], enemies[0].reward + 300, false, cities[6], 0);
        missions[44] = new Mission("> The gate to the Alftands is snowed over and the Dwemer elevator doesn't seem to be working after centuries of disuse", enemies[1], enemies[0].reward, false, cities[6], 0);
        missions[45] = new Mission("> The dragon priest's sanctuary is built of the blackest granite you have ever seen", enemies[8], enemies[0].reward, false, cities[6], 0);
        missions[46] = new Mission("> Small farm surrounded by fallen leaves of different colors makes a beautiful impression ", enemies[3], enemies[0].reward, false, cities[8], 3);
        missions[47] = new Mission("> In the distance you can see the lights of an estate located on a small island", enemies[0], enemies[0].reward, false, cities[8], 8);
        missions[48] = new Mission("> The employees of the brewery look at you with a meaningful pattern", enemies[2], enemies[0].reward, false, cities[8], 6);
    }

    public City[] cities = new City[9];
    public Follower[] followers = new Follower[14];
    public Mission[] missions = new Mission[49];
    public Enemy[] enemies = new Enemy[11];

}
