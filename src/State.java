import java.io.*;

public class State
{

    public static final String FILE_PATH = "Save\\player.state";

    public static void save(Player player)
    {
        try
        {
            FileOutputStream fileOut = new FileOutputStream(FILE_PATH);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(player);
            out.close();
            fileOut.close();
            System.out.println("Player state SUCCESSFULLY saved to " + FILE_PATH);
            System.out.println();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("NOT SAVED");
            System.out.println();
        }
    }

    public static Player load()
    {
        try
        {
            FileInputStream fileIn = new FileInputStream(FILE_PATH);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Player player = (Player) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Player state SUCCESSFULLY loaded from " + FILE_PATH);
            System.out.println();
            return player;
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("NOT LOADED");
            System.out.println();
            return null;
        }
    }
}