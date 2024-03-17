public class Inventory {
    private String water, food, firewood;
    private Guns gun;
    private Armors armor;

    public Inventory() {

        this.gun = new Guns("Hand", 0, 0, 0);
        this.armor = new Armors("Human Body",0,0,0);
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFirewood() {
        return firewood;
    }

    public void setFirewood(String firewood) {
        this.firewood = firewood;
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



}
