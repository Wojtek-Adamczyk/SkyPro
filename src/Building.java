import java.io.Serializable;

class Building implements Serializable
{
    public void leave(Player player) throws InterruptedException
    {
        player.building = null;
        player.currentCity.menu(player);
    }
}

