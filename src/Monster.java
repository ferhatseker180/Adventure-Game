public class Monster {
    private int id;
    private String monsterName;
    private int damage;

    private int initialHealth;
    private int health;
    private int loot;

    public int getInitialHealth() {
        return initialHealth;
    }

    public void setInitialHealth(int initialHealth) {
        this.initialHealth = initialHealth;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

    public Monster(int id, String monsterName, int damage, int healthy, int loot,int initialHealth) {
        this.id = id;
        this.damage = damage;
        this.health = healthy;
        this.monsterName = monsterName;
        this.loot = loot;
        this.initialHealth = initialHealth;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0){
            health = 0;
        }
        this.health = health;
    }

}
