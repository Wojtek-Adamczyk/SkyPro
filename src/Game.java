import java.io.Serializable;

class Game implements Serializable
{
    private final Player player;
    private final World world;

    public Game(Player player, World world)
    {
        this.player = player;
        this.world = world;
    }

    public Player getPlayer() {return player;}

    public World getWorld() {return world;}
}