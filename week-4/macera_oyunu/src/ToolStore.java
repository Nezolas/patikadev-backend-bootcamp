public class ToolStore extends NormalLoc{

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------ Mağazaya Hoşgeldiniz! -----------");

        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1- Silahlar");
            System.out.println("2- Zırhlar");
            System.out.println("3- Çıkış Yap");
            System.out.print("Seçiminiz: ");

            int selectCase = input.nextInt();

            while (selectCase < 1 || selectCase > 3) {
                System.out.print("Geçersiz bir değer girdiniz. Tekrar Giriniz:  ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmour();
                    buyArmour();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz!");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }
    public void printWeapon() {
        System.out.println("------ Silahlar ------");
        for (Weapon w: Weapon.weapons()) {
            System.out.println(w.getId() + "-" + w.getName() + " <Para : " + w.getPrice() + ", Hasar: " + w.getDamage() + ">");
        }
        System.out.println("0 - Çıkış Yap");
    }
    public void buyWeapon() {
        System.out.print("Bir silah seçiniz: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.print("Geçersiz bir değer girdiniz. Tekrar Giriniz:  ");
            selectWeaponID = input.nextInt();
        }

        if(selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

            if(selectedWeapon != null) {
                if(selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunamamaktadır!");
                } else {
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }
    public void printArmour() {
        System.out.println("------ Zırhlar ------");
        for (Armour a: Armour.armours()) {
            System.out.println(a.getId() + "-" + a.getName() + " <Para: " + a.getPrice() + ", Zırh: " + a.getBlock() + ">");
        }
        System.out.println("0 - Çıkış Yap");
    }
    public void buyArmour() {
        System.out.print("Bir zırh seçiniz: ");

        int selectArmourID = input.nextInt();
        while (selectArmourID < 0 || selectArmourID > Armour.armours().length) {
            System.out.print("Geçersiz bir değer girdiniz. Tekrar Giriniz:  ");
            selectArmourID = input.nextInt();
        }

        if(selectArmourID != 0 ) {
            Armour selectedArmour = Armour.getArmourObjByID(selectArmourID);

            if(selectedArmour != null) {
                if(selectedArmour.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunamamaktadır!");
                } else {
                    System.out.println(selectedArmour.getName() + " zırhını satın aldınız.");
                    int balance = this.getPlayer().getMoney() - selectedArmour.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmour(selectedArmour);
                }
            }
        }
    }
}