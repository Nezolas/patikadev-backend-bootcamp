public class Armour {
    private int id;
    private String name;
    private int block;
    private int price;

    public Armour(int id, String name, int block, int price) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }
    public static Armour[] armours() {
        Armour[] armourList = new Armour[3];
        armourList[0] = new Armour(1,"Hafif",1,15);
        armourList[1] = new Armour(2,"Orta",3,25);
        armourList[2] = new Armour(3,"Ağır",5,40);

        return armourList;
    }
    public static Armour getArmourObjByID(int id) {
        for(Armour a : Armour.armours()) {
            if(a.getId() == id) {
                return  a;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}