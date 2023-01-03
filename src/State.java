import java.io.*;

public class State
{
    World world;
    Player player;

    public void save()
    {
        try (ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("C:\\skyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy")))
        {
            save.writeObject(world);
            save.writeObject(player);
            System.out.println("GAME SAVED SUCCESSFULLY");
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("SOMETHING WENT WRONG - GAME NOT SAVED");
        }
    }

    public void load()
    {
        try (ObjectInputStream load = new ObjectInputStream(new FileInputStream("C:\\skyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy")))
        {
            world = (World) load.readObject();
            player = (Player) load.readObject();
            System.out.println("GAME LOADED SUCCESSFULLY");
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("SOMETHING WENT WRONG - GAME NOT LOADED");
        }
    }
}