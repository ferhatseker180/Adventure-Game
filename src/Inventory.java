public class Inventory {
    private boolean water, food, firewood;
    // private String weaponName, armorName;
    // private int weaponDamage, armorDefence;
    private Guns gun;
    private Armors armor;

    public Inventory() {

        this.gun = new Guns("Hand", 0, 0, 0);
        this.armor = new Armors("Human Body",0,0,0);
    }

    public boolean isWater() {
        return water;
    }

    public Guns getGun() {
        return gun;
    }

    public Armors getArmor() {
        return armor;
    }

    public void setArmor(Armors armor) {
        this.armor = armor;
    }

    public void setGun(Guns gun) {
        this.gun = gun;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

}
