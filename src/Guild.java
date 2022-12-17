public class Guild
{
    public enum Type
    {
        BROTHERHOOD("Dark Brotherhood"),
        COMPANIONS("Companions"),
        COLLEGE("College of Winterhold"),
        THIEVES("Thieves Guild");

        private final String name;

        Type(String name) {this.name = name;}

        public String getName() {return name;}

    }

    private final Type type;

    public Guild(Type type) {this.type = type;}

    public void menu(Player player)
    {
        switch (type)
        {
            case BROTHERHOOD ->
            {
                System.out.println("- Hail Sithis brother! Night Mother is asking for a next prey.");
                break;
            }
            case COMPANIONS ->
            {
                System.out.println("- Welcome shield-brother. Good to see you.");
                break;
            }

            case COLLEGE ->
            {
                System.out.println("- We are masters of the arcane arts.");
                break;
            }

            case THIEVES ->
            {
                System.out.println("- We are the masters of stealth and deception.");
                break;
            }

        }
    }
}
