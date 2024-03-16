public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {
        super(player, "Store");
    }


    @Override
    public boolean onLocation() {
        System.out.println("Welcome To ***GÖKTÜRK*** Store");
        int chooseStore;
        do {
            System.out.println("1-> Buy Guns\n2-> Buy Armors\n3-> Exit Store");
            chooseStore = input.nextInt();
        } while (chooseStore > 3 || chooseStore <= 0);

            switch (chooseStore) {
                case 1:
                    printGuns();
                    buyGun();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("We hope you come again!!");
                    break;
                default:
                    System.out.println("Invalid Value");
            }


        return true;
    }

    public void printGuns() {
        System.out.println("*********Guns*********");
        System.out.println();
        for (Guns gun : Guns.guns()) {
            System.out.println("Gun Name: " + gun.getName() + "   Gun Id: " + gun.getId() + "   Gun Damage: " + gun.getDamage() + "  Gun's Price: " + gun.getPrice());
        }
    }

    public void buyGun() {

        System.out.print("Please, Choose Your Gun ID: ");
        int chooseGun = input.nextInt();

        while (chooseGun < 1 || chooseGun > Guns.guns().length) {
            System.out.println("Wrong Gun's ID, Please Try Again");
            System.out.println("Please, Choose Your Gun ID: ");
            chooseGun = input.nextInt();
        }

        Guns selectedGun = Guns.getGunsObjById(chooseGun);

        if (selectedGun != null) {
            if (selectedGun.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("You do not have enough money");
            } else {
                System.out.println("You bought " + selectedGun.getName());
                int balance = this.getPlayer().getMoney() - selectedGun.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Your Budget: " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setGun(selectedGun);
                System.out.println("Your New Gun: " + this.getPlayer().getInventory().getGun().getName());
            }
        }
    }

    public void buyArmor(){

        System.out.print("Please, Choose Your Armor ID: ");
        int chooseArmor = input.nextInt();

        while (chooseArmor < 1 || chooseArmor > Armors.armors().length) {
            System.out.println("Wrong Gun's ID, Please Try Again");
            System.out.println("Please, Choose Your Armor ID: ");
            chooseArmor = input.nextInt();
        }

        Armors selectedArmor = Armors.getArmorsObjById(chooseArmor);
        if (selectedArmor != null){
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                System.out.println("You do not have enough money");
            } else {
                System.out.println("You bought " + selectedArmor.getName());
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Your Budget: " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Your New Armor: " + this.getPlayer().getInventory().getArmor().getName());
            }
        }

    }

    public void printArmor() {
        System.out.println("*********Armors*********");
        System.out.println();
        for (Armors armor : Armors.armors()) {
            System.out.println("Armor Name: " + armor.getName() + "   Armor Id: " + armor.getId() + "   Armor Block: " + armor.getBlock() + "  Armor's Price: " + armor.getPrice());
        }
    }
}
