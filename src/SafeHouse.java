public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(player,"Safe House");
    }

    @Override
    public boolean onLocation() {
        this.getPlayer().setHealth(this.getPlayer().getInitialHealth());
        System.out.println("You are safe and your health is restored...");
        return true;
    }
}
