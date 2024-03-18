public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {
        super(player, " Mağaza ");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz! ");
        System.out.println("1- Silahlar");
        System.out.println("2- Zirhlar");
        System.out.print("Seçiminiz: ");
        int selectCase = Location.input.nextInt();
        while (selectCase < 1 || selectCase > 3){
            System.out.println("Lütfen Geçerli Bİr Seçim Yapınız!");
            selectCase = Location.input.nextInt();
        }
        switch (selectCase){
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyWeapon();
                break;
            case 3:
                System.out.println("Mağazadan Çıkış yapıldı.");
                return true;

        }
        return true;
    }
    public void printWeapon(){
        System.out.println();
        System.out.println("######### Silahlar #########");
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + " - " + w.getName() + " Değeri: " + w.getPrice() + " Hasarı: " + w.getDamage() );
        }
    }
    public void buyWeapon(){
        System.out.println("Silahinizi seçiniz: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length){
            System.out.println("Lütfen Geçerli Bİr Seçim Yapınız!");
            selectWeaponID = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
        if( selectedWeapon != null){
            if(selectedWeapon.getPrice() > getPlayer().getCoin()){
                System.out.println("Bakiye Yetersiz.");
            }else{
                System.out.println(selectedWeapon.getName() + " Silahını aldınız.");
                int balance = this.getPlayer().getCoin() - selectedWeapon.getPrice();
                this.getPlayer().setCoin(balance);
                System.out.println("KALAN BAKIYE: "+ this.getPlayer().getCoin());
                //System.out.println("eski silah: " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                //System.out.println("suanki silah: " + this.getPlayer().getInventory().getWeapon().getName());
            }
        }
    }

    public void printArmor(){
        System.out.println();
        System.out.println("######### Zırhlar #########");
    }
}
