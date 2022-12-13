class City {
    String name;
    Inn inn;
    Blacksmith blacksmith;
    Alchemist alchemist;
    Guild guild;
    Keep keep;
    Wilderness wilderness;

    boolean isKeep;
    boolean isBlacksmith;
    boolean isAlchemist;
    boolean isInn;
    boolean isGuild;
    boolean isWilderness;

    City(String name, boolean isKeep, boolean isBlacksmith, boolean isAlchemist, boolean isInn, boolean isGuild, boolean isWilderness) {
        this.name = name;
        this.isKeep = isKeep;
        this.isBlacksmith = isBlacksmith;
        this.isAlchemist = isAlchemist;
        this.isInn = isInn;
        this.isGuild = isGuild;
        this.isWilderness = isWilderness;
    }

    public City()
    {

    }
}