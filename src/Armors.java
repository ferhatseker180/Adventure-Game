public class Armors extends Item {

    private int block;

    public Armors(String name, int id, int price, int block) {
        super(name, id, price);
        this.block = block;
    }

    public static Armors[] armors() {
        Armors[] armorList = new Armors[3];
        armorList[0] = new Armors("Light Weight", 1, 2, 5);
        armorList[1] = new Armors("Medium Armor", 2, 3, 15);
        armorList[2] = new Armors("Heavy Armor", 3, 7, 20);
        return armorList;
    }

    public static Armors getArmorsObjById(int id) {
        for (Armors armor : Armors.armors()) {
            if (armor.getId() == id) {
                return armor;
            }
        }
        return null;
    }
    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(int price) {
       this.setPrice(price);
    }
}
