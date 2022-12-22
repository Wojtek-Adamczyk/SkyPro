class Building
{
    public void leave(Player player) throws InterruptedException
    {
        player.building = null;
        player.currentCity.menu(player);
    }
}

