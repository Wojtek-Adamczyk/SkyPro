import java.io.Serializable;

class GameState implements Serializable
{
    private final Player player;
    private final World world;

    public GameState(Player player, World world)
    {
        this.player = player;
        this.world = world;
    }

    public Player getPlayer() {return player;}

    public World getWorld() {return world;}
}