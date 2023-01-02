import java.io.IOException;
import java.io.Serializable;

class Building implements Serializable
{

    public void leave(Player player) throws InterruptedException, IOException, ClassNotFoundException {
        player.building = null;
        player.currentCity.menu(player);
    }
}

