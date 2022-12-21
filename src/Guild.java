import java.util.Scanner;

public class Guild extends Building
{
    public enum Type
    {
        BROTHERHOOD("Dark Brotherhood"),
        COMPANIONS("Companions"),
        COLLEGE("College of Winterhold"),
        THIEVES("Thieves Guild");

        private final String name;

        Type(String name) {this.name = name;}
    }

    private final Type type;
    public Guild(Type type) {this.type = type;}

    Integer points = 0;

    public void greet()
    {
        if(type.name.equals("Dark Brotherhood")) {System.out.println("- Hail Sithis brother! Night Mother is asking for a next prey.");}
        if(type.name.equals("Companions")) {System.out.println("- Welcome shield-brother. Good to see you.");}
        if(type.name.equals("College of Winterhold")) {System.out.println("- Watch out with these spells, apprentice. You don't want to burn anything.");}
        if(type.name.equals("Thieves Guild")) {System.out.println("- How ya' doin' mate? Did ya' get your hands on something lately?");}
    }

    public void choices()
    {
        System.out.println("0. See your statistics");
        System.out.println("1. Take beginner mission");
        System.out.println("2. Take intermediate mission");
        System.out.println("3. Take advenced mission");
        System.out.println("4. Hire follower");
        System.out.println("5. Leave");
    }

    String brotherhoodQuestTaken = "- You fulfilled the will of a Dread-Father, child.";
    String companionQuestTaken = "- You've already fulfilled your duties";
    String collegeQuestTaken = "- You have already helped us a lot in this matter";
    String thievesQuestTaken = "- Those trinkets already disappeared, don't be too greedy, pal";

    public void menu(Player player) throws InterruptedException {
        switch (type)
        {
            case BROTHERHOOD ->
            {
                greet();
                choices();

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player); menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[37].completed)
                        {
                            System.out.println("- Narfi at the abandoned shack in the woods. Someone wants this filthy beggar dead. Accept this gold, then eliminate the target. So begins a contract, bound in blood.");
                            points += 1;
                            System.out.println();
                        }
                        else
                        {
                            System.out.println(brotherhoodQuestTaken);
                            System.out.println();
                        }
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[38].completed)
                        {
                            System.out.println("- Hern at the Half-Moon Mill. This vile vampire needs to meet a grim end. Accept this gold, then kill the target. Hail Sithis!");
                            points += 2;
                            System.out.println();
                        }
                        else
                        {
                            System.out.println(brotherhoodQuestTaken);
                            System.out.println();
                        }
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[39].completed)
                        {
                            System.out.println("- Gaius Maro in Penitus Oculatus Outpost. This pathetic Empire minion has offended our client. Accept this gold, then kill the target. All hail the Listener! All hail Sithis!");
                            points += 3;
                            System.out.println();
                        }
                        else
                        {
                            System.out.println(brotherhoodQuestTaken);
                            System.out.println();
                        }
                    }
                    case "4" ->
                    {
                        if (player.currentCity.guildFollower != null && points >= 6) {player.hireFollower(player.currentCity.guildFollower); player.money += 500;}
                        else if (player.currentCity.guildFollower == null) System.out.println("- Cicero is already with you brother... isn't he?");
                        else System.out.println("- You are not ready child. Take more lives in the name of Dread Father.");
                        System.out.println();
                    }
                    case "5" -> {leave(player);}
                }
            }

            case COMPANIONS ->
            {
                greet();
                choices();

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player); menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[40].completed)
                        {
                            System.out.println("- Your first quest, ey? Good. It won't be hard, brother. You have to go to Pelagia Farm and kill some wild cat that infested in the shed. Beast killed one farmer already so the landowner ask us to take care of this 'problem'.");
                            points += 1;
                            System.out.println();
                        }
                        else
                        {
                            System.out.println(companionQuestTaken);
                            System.out.println();
                        }
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[41].completed)
                        {
                            System.out.println("- Kodlak himself want you to kill the witches from Glenmoril and bring him the head of one of them. I'm not sure why he's asking for this spawn's head but those are his words. Don't make him wait.");
                            points += 2;
                            System.out.println();
                        }
                        else
                        {
                            System.out.println(companionQuestTaken);
                            System.out.println();
                        }
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[42].completed)
                        {
                            System.out.println("- It is time to strike the Silver Hand. They've been after us for too long. We will hit them in their own headquarters in Gallows Rock. Preprare yourself brother. It will be tough battle.");
                            points += 3;
                            System.out.println();
                        }
                        else
                        {
                            System.out.println(companionQuestTaken);
                            System.out.println();
                        }
                    }
                    case "4" ->
                    {
                        if (player.currentCity.guildFollower != null && points >= 6) {player.hireFollower(player.currentCity.guildFollower); player.money += 500;}
                        else if (player.currentCity.guildFollower == null) System.out.println("- Farkas is your shield-brother now. Is everything good with him?");
                        else System.out.println("- You haven't proven your worth yet, brother.");
                        System.out.println();
                    }
                    case "5" -> {leave(player);}
                }
            }

            case COLLEGE ->
            {
                greet();
                choices();

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player); menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[43].completed)
                        {
                            System.out.println("- We need you in Saarthal. A team of archaeologists found something interesting and probably dangerous. you have to protect them");
                            points += 1;
                            System.out.println();
                        }
                        else
                        {
                            System.out.println(collegeQuestTaken);
                            System.out.println();
                        }
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[44].completed)
                        {
                            System.out.println("- Our informants says that there is ancient Dwemwer Artifact in Alftand ruins - Focusing Crystal.");
                            System.out.println("Rumors has it that it can store great amounts of magic energy to use it later in any way. Bring this artifact here");
                            points += 2;
                            System.out.println();
                        }
                        else
                        {
                            System.out.println(collegeQuestTaken);
                            System.out.println();
                        }
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[45].completed)
                        {
                            System.out.println("- Some dark power is raising in the Labyrynthian. We think this might be one of the legendary Dragon Priests. If it is true, we have to stop him before it's too late");
                            points += 3;
                            System.out.println();
                        }
                        else
                        {
                            System.out.println(collegeQuestTaken);
                            System.out.println();
                        }
                    }
                    case "4" ->
                    {
                        if (player.currentCity.guildFollower != null && points >= 6) {player.hireFollower(player.currentCity.guildFollower); player.money += 500;}
                        else if (player.currentCity.guildFollower == null) System.out.println("- What is it? J'zargo got bored with you and left?");
                        else System.out.println("- Khajiit got better things to do than chasing after a rookie. Be back when you will be master in our arts.");
                        System.out.println();
                    }
                    case "5" -> {leave(player);}
                }
            }

            case THIEVES ->
            {
                greet();
                choices();

                Scanner input = new Scanner(System.in);
                String playerInput = input.nextLine();
                switch (playerInput)
                {
                    case "0" -> {player.sheet(player); menu(player);}
                    case "1" ->
                    {
                        if (!player.world.missions[46].completed)
                        {
                            System.out.println("- Listen pal, I don't know if you are good with our arts, so I'll give you simple task. There is a farm nearby city. One of farmers have valuable ring. I want it to change it's owner.");
                            System.out.println("I don't care who will it be, but remember we are not murderers. He doesn't have to die. Got it?");
                            points += 1;
                            System.out.println();
                        }
                        else
                        {
                            System.out.println(thievesQuestTaken);
                            System.out.println();
                        }
                    }
                    case "2" ->
                    {
                        if (!player.world.missions[47].completed)
                        {
                            System.out.println("- This task is a little more dangerous so listen carefully. Our vwery powerful client wants Goldenglow Estate for himself. You will get inside, steal act of ownership, and come back in one piece.");
                            System.out.println("This is is important thing, got it? Prepare yourself and by the gods, don't get your hands dirty.");
                            points += 2;
                            System.out.println();
                        }
                        else
                        {
                            System.out.println(thievesQuestTaken);
                            System.out.println();
                        }
                    }
                    case "3" ->
                    {
                        if (!player.world.missions[48].completed)
                        {
                            System.out.println("- This one will be more personal. Maybe you heard that our organisation owns a Honningbrew Meadery. And here's the problem. Some hobo mage hold up himself in basement.");
                            System.out.println("I don't know what he wants but I know that this man is dangerous. Also, we are convinced that his necklace gives him his power. You will get down there, steal the necklace and then we will kick this pal out.");
                            System.out.println("This will be more personal. Maybe you heard that our organisation owns a Honningbrew Meadery. And here's the problem. Some hobo mage hold up himself in basement. I don't know what he wants but I know that this man is dangerous.");
                            System.out.println("Also, we are convinced that his necklace gives him his power. You will get down there, steal the necklace and then we will kick this pal out. You don't have to kill him.");
                            System.out.println("  We are not Dark Brotherhood, remember. Quiet and sneaky.");
                            points += 3;
                            System.out.println();
                        }
                        else
                        {
                            System.out.println(thievesQuestTaken);
                            System.out.println();
                        }
                    }
                    case "4" ->
                    {
                        if (player.currentCity.guildFollower != null && points >= 6) {player.hireFollower(player.currentCity.guildFollower); player.money += 500;}
                        else if (player.currentCity.guildFollower == null) System.out.println("- What's wrong pal? Sapphire used you and disappeared?");
                        else System.out.println("- If you can't help yourself, no one here can help you. Prove yourself and we'll talk.");
                        System.out.println();
                    }
                    case "5" -> {leave(player);}
                }
            }
        }
    }
}
