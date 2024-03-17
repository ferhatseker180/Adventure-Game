import java.util.Random;

public abstract class BattleLocation extends Location {
    private Monster monster;
    private String award;
    private int maxMonster;

    public BattleLocation(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    public int randomMonsterCount() {
        Random random = new Random();
        return random.nextInt(this.getMaxMonster()) + 1;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        int monsterCount = this.randomMonsterCount();
        System.out.println("Now, You Are Here: " + this.getName());
        System.out.println("Be Careful!! " + monsterCount + " " + this.monster.getMonsterName() + " Live Here...");
        System.out.println("1-> Fight\n2-> Run Away");
        int yourChoise = input.nextInt();
        switch (yourChoise) {
            case 1:
                System.out.println("Fight Fight!!");
                if (combat(monsterCount)) {
                    return true;
                }
                break;
            case 2:
                System.out.println("Run Run Run!!");
                break;
            default:
                System.out.println("Wrong Choises");
        }
        return true;
    }

    public boolean combat(int monsterCount) {
        for (int i = 0; i < monsterCount; i++) {
            this.getMonster().setHealth(this.getMonster().getInitialHealth());
            playerStats();
            monsterStats(i);
            fight();
        }
        // If you completed monster's area, you will won award but if you have this award, you won't take this award again.
        // checkAward() : This is a homework's first bullet.
        checkAward(this.getPlayer());

        return false;
    }

    public void checkAward(Player player) {
        if (player.getHealth() > 0) {
            if (monster.getMonsterName() == Zombie.class.getSimpleName()) {
                if (player.getInventory().getFood() == null) {
                    player.getInventory().setFood("Food");
                    System.out.println("You Won Big Award: " + player.getInventory().getFood());
                } else {
                    System.out.println("You Have Already Won");
                }
            }
            if (monster.getMonsterName() == "Vampire") {
                if (player.getInventory().getFirewood() == null) {
                    player.getInventory().setFirewood("Firewood");
                    System.out.println("You Won Big Award: " + player.getInventory().getFirewood());
                } else {
                    System.out.println("You Have Already Won");
                }
            }
            if (monster.getMonsterName() == "Bear") {
                if (player.getInventory().getWater() == null) {
                    player.getInventory().setWater("Water");
                    System.out.println("You Won Big Award: " + player.getInventory().getWater());
                } else {
                    System.out.println("You Have Already Won");
                }
            }

        }
    }

    public boolean fight() {

        while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
            System.out.println("Do you want to continue the war? 1-> No 2-> Yes");
            int chooseWar = input.nextInt();
            if (chooseWar == 1) {
                if (this.getPlayer().getHealth() <= 0) {
                    System.out.println("You Are Dead!!");
                    return false;
                }
                System.out.println("Go Home");
                break;
            }
            if (chooseWar == 2) {
                // Whether the player or the monster will hit first was determined using the random library as follows.
                // This is the 2nd item in the game's homework.
                int randomHit = (int) (Math.random() * 2) + 1;
                if (randomHit == 1) {
                    System.out.println("You Hit it.");
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getMonster().getHealth() > 0) {
                        System.out.println();
                        System.out.println("Monster Hit You");
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        afterHit();
                    }
                }
                if (randomHit == 2) {
                    System.out.println();
                    System.out.println("Monster Hit You");
                    int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                    if (monsterDamage < 0) {
                        monsterDamage = 0;
                    }
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                    afterHit();
                    System.out.println();
                    System.out.println("You Hit it.");
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                }

                checkHealth();
            }
        }
        return false;
    }


    public void afterHit() {

        if (this.getMonster().getHealth() <= 0) {
            this.getMonster().setHealth(0);
        }
        if (this.getPlayer().getHealth() <= 0) {
            this.getPlayer().setHealth(0);
        }
        System.out.println(this.getMonster().getMonsterName() + " Health: " + this.getMonster().getHealth());
        System.out.println("Your Health: " + this.getPlayer().getHealth());
    }

    public void monsterStats(int i) {
        System.out.println();
        System.out.println((i + 1) + "." + "Monster Stats");
        System.out.println("--------------------------");
        System.out.println("Monster Name: " + this.getMonster().getMonsterName());
        System.out.println("Monster Health: " + this.getMonster().getHealth());
        System.out.println("Monster Damage: " + this.getMonster().getDamage());
        System.out.println("Monster's Loot: " + this.getMonster().getLoot());
    }

    public void playerStats() {
        System.out.println("Player Stats");
        System.out.println("--------------------------");
        System.out.println("Health: " + this.getPlayer().getHealth());
        if (this.getPlayer().getInventory().getGun().getDamage() > 0) {
            System.out.println("Your Gun: " + this.getPlayer().getInventory().getGun().getName());
        }
        if (this.getPlayer().getInventory().getArmor().getBlock() > 0) {
            System.out.println("Your Armor: " + this.getPlayer().getInventory().getArmor().getName());
        }
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Blocking: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money: " + this.getPlayer().getMoney());
    }

    public boolean checkHealth() {
        if (this.getMonster().getHealth() <= 0) {
            System.out.println();
            System.out.println("You Defeated Your Monster Enemy");
            System.out.println("You Earned " + this.getMonster().getLoot());
            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getLoot());
            System.out.println("Your Current Money: " + this.getPlayer().getMoney());
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println();
            System.out.println("Game Over!!");
            this.getPlayer().setHealth(0);
            return false;
        }
        return true;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public void battleLocation(Monster o) {

    }

}
