class Building
{
    public void leave(Player player)
    {
        player.building = null;
        player.currentCity.menu(player);

    }


}

