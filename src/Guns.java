public class Guns {
    private String name;
    private int id;
    private int damage;
    private int price;

    Guns(String name, int id, int damage, int price) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Guns[] guns() {
        Guns[] weaponList = new Guns[3];
        weaponList[0] = new Guns("Pistol", 1, 2, 5);
        weaponList[1] = new Guns("Sword", 2, 3, 15);
        weaponList[2] = new Guns("Riffle", 3, 7, 45);
        return weaponList;
    }

    public static Guns getGunsObjById(int id) {
        for (Guns gun : Guns.guns()) {
            if (gun.getId() == id) {
                return gun;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
