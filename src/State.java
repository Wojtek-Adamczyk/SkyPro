import java.io.*;
import java.util.Scanner;

public class State {

    public static final String FOLDER_PATH = "Saved games";

    public static void saveGame(Player player, World world)
    {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a name for the .game save file:");
            String fileName = scanner.nextLine();
            FileOutputStream fileSave = new FileOutputStream(FOLDER_PATH + "\\" + fileName + ".game");
            ObjectOutputStream save = new ObjectOutputStream(fileSave);
            Game game = new Game(player, world);
            save.writeObject(game);
            save.close();
            fileSave.close();
            System.out.println("GAME STATE saved SUCCESSFULLY as " + fileName);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("SOMETHING WENT WRONG - GAME NOT SAVED");
            System.out.println();
        }
    }

    public static Game loadGame()
    {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of the .game save file you want to load:");
            String fileName = scanner.nextLine();
            FileInputStream fileLoad = new FileInputStream(FOLDER_PATH + "\\" + fileName + ".game");
            ObjectInputStream load = new ObjectInputStream(fileLoad);
            Game game = (Game) load.readObject();
            load.close();
            fileLoad.close();
            System.out.println("GAME STATE loaded SUCCESSFULLY from " + fileName);
            System.out.println();
            return game;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("SOMETHING WENT WRONG - GAME NOT LOADED");
            System.out.println();
            return null;
        }
    }
}