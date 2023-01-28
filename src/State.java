import java.io.*;
import java.util.Scanner;

public class State {

    public static final String FOLDER_PATH = "Saved games";

    public static void savePlayer(Player player)
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a name for the .player save file:");
            String fileName = scanner.nextLine();
            FileOutputStream fileSave = new FileOutputStream(FOLDER_PATH + "\\" + fileName + ".player");
            ObjectOutputStream save = new ObjectOutputStream(fileSave);
            save.writeObject(player);
            save.close();
            fileSave.close();
            System.out.println("PLAYER STATE saved SUCCESSFULLY as " + fileName);
            System.out.println();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("SOMETHING WENT WRONG - GAME NOT SAVED");
            System.out.println();
        }
    }

    public static void saveWorld(World world)
    {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a name for the .world save file: (recommended name should be the same as the PLAYER STATE)");
            String fileName = scanner.nextLine();
            FileOutputStream fileSave = new FileOutputStream(FOLDER_PATH + "\\" + fileName + ".world");
            ObjectOutputStream save = new ObjectOutputStream(fileSave);
            save.writeObject(world);
            save.close();
            fileSave.close();
            System.out.println("WORLD STATE saved SUCCESSFULLY as " + fileName);
            System.out.println();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("SOMETHING WENT WRONG - GAME NOT SAVED");
            System.out.println();
        }
    }

    public static Player loadPlayer()
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of the .player save file you want to load:");
            String fileName = scanner.nextLine();
            FileInputStream fileLoad = new FileInputStream(FOLDER_PATH + "\\" + fileName + ".player");
            ObjectInputStream load = new ObjectInputStream(fileLoad);
            Player player = (Player) load.readObject();
            load.close();
            fileLoad.close();
            System.out.println("PLAYER STATE loaded SUCCESSFULLY from " + fileName);
            System.out.println();
            return player;
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("SOMETHING WENT WRONG - GAME NOT LOADED");
            System.out.println();
            return null;
        }
    }

    public static World loadWorld()
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of the .world save file you want to load:");
            String fileName = scanner.nextLine();
            FileInputStream fileLoad = new FileInputStream(FOLDER_PATH + "\\" + fileName + ".world");
            ObjectInputStream load = new ObjectInputStream(fileLoad);
            World world = (World) load.readObject();
            load.close();
            fileLoad.close();
            System.out.println("WORLD STATE loaded SUCCESSFULLY from " + fileName);
            System.out.println();
            return world;
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("SOMETHING WENT WRONG - GAME NOT LOADED");
            System.out.println();
            return null;
        }
    }
}