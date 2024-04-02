import java.util.Random;

public class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = randomObstacleNumber();
        System.out.println("Şu an buradasınız: " + this.getName());
        System.out.println("Dikkatli ol! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor! ");
        System.out.println("<S>avaş veya <K>aç ");
        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)) {
            if (combat(obsNumber)) {
                System.out.println(this.getName() + " tüm düşmanları yendiniz.");
                return true;
            }

        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz!");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
        for (int i = 1; i < obsNumber; i++) {
            playerStats();
            obstacleStats(i);

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("<V>ur veya <K>aç");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")) {

                    double condition = Math.random() * 100;
                    if (condition > 50) {
                        System.out.println("Siz Vurdunuz ");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();

                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Canavar Vurdu ");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmour().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }

                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                        else {
                            return false;
                        }
                    }
                    else {
                        System.out.println("Canavar Vurdu ");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmour().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();

                        if (this.getPlayer().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Siz Vurdunuz ");
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                        }
                    }
                    if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                        System.out.println("Düşmanı Yendiniz!");
                        if (getObstacle().getName() == "Yılan") {
                            earnItem();
                        } else {
                            System.out.println(this.getObstacle().getAward() + "para kazandınız");
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                            System.out.println("Güncel Paranız :" + this.getPlayer().getMoney());

                        }

                    }

                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        ;
        System.out.println(this.getObstacle().getName() + "Can1: " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("Oyuncu Değerleri");
        System.out.println("--------------------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmour().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmour().getBlock());
        System.out.println("Para: " + this.getPlayer().getMoney());
    }

    public void obstacleStats(int i) {
        System.out.println(i + "." + this.getObstacle().getName() + " Değerleri");
        System.out.println("--------------------------");
        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Hasar : " + this.getObstacle().getDamage());
        System.out.println("Ödül : " + this.getObstacle().getAward());
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public void earnItem() {
        Random random = new Random();
        int randomItem = random.nextInt(1, 101);
        if (randomItem <= 15) {
            Random r1 = new Random();
            int randomItem1 = random.nextInt(1, 101);
            if (randomItem1 <= 20) {
                System.out.println("Tüfek Kazandınız!");
                getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(3));
            } else if (randomItem1 > 20 && randomItem1 <= 50  ) {
                System.out.println("Kılıç Kazandınız!");
                getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));

            } else {
                System.out.println("Tabanca Kazandınız");
                getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));
            }


        } else if (randomItem > 15 && randomItem <= 30) {
            Random r2 = new Random();
            int randomItem2 = random.nextInt(1, 101);
            if (randomItem2 <= 20) {
                System.out.println(" Ağır Zırh Kazandınız");
                getPlayer().getInventory().setArmour(Armour.getArmourObjByID(3));
            } else if (randomItem2 > 20 && randomItem2 <= 50) {
                System.out.println("Orta Zırh Kazandınız");
                getPlayer().getInventory().setArmour(Armour.getArmourObjByID(2));

            } else {
                System.out.println(" Hafif Zırh Kazandınız");
                getPlayer().getInventory().setArmour(Armour.getArmourObjByID(1));

            }
        } else if (randomItem > 30 && randomItem <= 55) {
            Random r2 = new Random();
            int randomItem2 = random.nextInt(1, 101);
            if (randomItem2 <= 20) {
                System.out.println(" 10 Para  Kazandınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
            } else if (randomItem2 > 20 && randomItem2 <= 50) {
                System.out.println("5 Para Kazandınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
            } else {
                System.out.println(" 1 Para Kazandınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
            }
            System.out.println("Güncel Paranız :" + this.getPlayer().getMoney());
        } else
            System.out.println("Hiçbir şey kazanamadınız.");


    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}