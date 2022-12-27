import java.io.*;

public class State implements Serializable
{

    private static final long serialVersionUID = 1L;

    public Player player;
    public World world;
    public Building building;

    public State(Player player, World world, Building building)
    {
        this.player = player;
        this.world = world;
        this.building = building;
    }

    public void saveGame()
    {
        State gameState = new State(this.player, this.world, this.building);
        try
        {
            FileOutputStream saveGame = new FileOutputStream("C:\\skyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy\\sajwik");
            ObjectOutputStream save = new ObjectOutputStream(saveGame);
            save.writeObject(gameState);
            save.close();
            saveGame.close();
            System.out.println("* GAME SAVED SUCCESSFULLY *");
            System.out.println();
        }
        catch (IOException e) {e.printStackTrace(); System.out.println("*** SOMETHING WENT WRONG - GAME NOT SAVED ***"); System.out.println();}
    }

    public void loadGame()
    {
        try
        {
            FileInputStream loadGame = new FileInputStream("C:\\skyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy\\sajwik");
            ObjectInputStream load = new ObjectInputStream(loadGame);
            State gameState = (State) load.readObject();
            player = gameState.player;
            load.close();
            loadGame.close();
        }
        catch (IOException | ClassNotFoundException e) {e.printStackTrace();}

    }
}
