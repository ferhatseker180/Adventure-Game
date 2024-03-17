import java.util.Scanner;

public class Player {
    private int damage, health, money, initialHealth;
    private String userName;
    private Inventory inventory;

    private Samurai samurai = new Samurai();
    private Archer archer = new Archer();
    private Knight knight = new Knight();

    Scanner input = new Scanner(System.in);

    public Player(String name) {
        this.userName = name;
        this.inventory = new Inventory();
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getGun().getDamage();
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
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void selectChar() {
        GameCharacter[] characterList = {samurai, archer, knight};
        for (GameCharacter gameCharacter : characterList) {
            System.out.println(gameCharacter.getCharacterName() + " id: " +
                    gameCharacter.getId() + "\t" + " Damage:" +
                    gameCharacter.getDamage() + "\t" + " Health:" +
                    gameCharacter.getHealth() + "\t" + " Money:" +
                    gameCharacter.getMoney());
        }

        int selectedId;
        do {
            System.out.print("Please choose your game character with id: ");
            selectedId = input.nextInt();
        } while (selectedId <= 0 || selectedId > 3);


        switch (selectedId) {
            case 1:
                initPlayer(samurai);
                System.out.println("Character Name: " + samurai.getCharacterName() + " ID:" + selectedId +
                        " Damage:" + this.damage + " Health:" + this.health + " Money:" + this.money);
                break;
            case 2:
                initPlayer(archer);
                System.out.println("Character Name: " + archer.getCharacterName() + " ID:" + selectedId +
                        " Damage:" + this.damage + " Health:" + this.health + " Money:" + this.money);
                break;
            case 3:
                initPlayer(knight);
                System.out.println("Character Name: " + knight.getCharacterName() + " ID:" + selectedId +
                        " Damage:" + this.damage + " Health:" + this.health + " Money:" + this.money);
                break;
            default:
                System.out.println("Wrong Value");
        }

    }

    public void selectLocation() {

        Location location = null;
        while (true) {
            printInfo();
            System.out.println();
            System.out.println("***LOCATIONS***");
            System.out.println("1-> SafeHouse\n2-> Store\n3-> Go Cave\n4-> Go Forest\n5-> Go River\n0-> Exit Game");

            int chooseLocation;
            do {
                System.out.print("Please enter the location number you want to go: ");
                chooseLocation = input.nextInt();
            } while (chooseLocation < 0 || chooseLocation > 5);

            switch (chooseLocation) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(this);

                    break;
                case 2:
                    location = new ToolStore(this);
                    break;
                case 3:
                    location = new Cave(this);
                    break;
                case 4:
                    location = new Forest(this);
                    break;
                case 5:
                    location = new River(this);
                    break;
                default:
                    location = new SafeHouse(this);
            }
            if (location == null) {
                System.out.println("Giving Up Does Not Suit The Warrior Soul!");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Game Over!!");
            }
        }
    }

    public void printInfo() {
        System.out.println("Your Gun: " + this.getInventory().getGun().getName() + "\t" +
                "Your Armor: " + this.getInventory().getArmor().getName() + "\t" +
                " Damage: " + this.getTotalDamage() + "\t" +
                " Blocking: " + this.getInventory().getArmor().getBlock() +
                "\t" + " Health:" + this.getHealth() + "\t" +
                " Money:" + this.getMoney());
    }


    public int getInitialHealth() {
        return initialHealth;
    }

    public void setInitialHealth(int initialHealth) {
        this.initialHealth = initialHealth;
    }

    public void initPlayer(GameCharacter gameCharacter) {
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setInitialHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
        this.setUserName(gameCharacter.getCharacterName());
    }
}
