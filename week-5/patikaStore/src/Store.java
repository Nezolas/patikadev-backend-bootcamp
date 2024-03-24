import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Store {


    private List<Brand> brands;
    private List<Product> phones;
    private List<Product> notebooks;

    public Store() {
        this.brands = new ArrayList<>();
        this.phones = new ArrayList<>();
        this.notebooks = new ArrayList<>();
        //Brand Ekleme
        brands.add(new Brand(1, "Apple"));
        brands.add(new Brand(2, "Asus"));
        brands.add(new Brand(3, "Casper"));
        brands.add(new Brand(4, "HP"));
        brands.add(new Brand(5, "Huawei"));
        brands.add(new Brand(6, "Lenovo"));
        brands.add(new Brand(7, "Monster"));
        brands.add(new Brand(8, "Samsung"));
        brands.add(new Brand(9, "Xiaomi"));
        brands.sort(Comparator.comparing(Brand:: getName));//Alfabatik sıralama
    }

    public void addProduct(Product product, int selection){
        if (product instanceof Product){
            for (Brand brand : brands){
                if (product.getBrand().getName().equals(brand.getName())){
                    if(selection == 1){
                        phones.add(product);
                    }else {
                        notebooks.add(product);
                    }
                    break;
                }
            }
        }
    }

    public void deleteProduct(int productID){

        phones.removeIf(product -> product.getId() == productID );
        notebooks.removeIf(product -> product.getId() == productID );
     /*   Iterator<Product> iterator = cepTelefonlari.iterator();
        while (iterator.hasNext()){
            Product urun = iterator.next();
            if (urun.getId() == urunId){
                iterator.remove();;
            }

        }*/


    }
    public  void listProduct(){

        System.out.println("Notebook Listesi");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat        | Marka     | Depolama   | Ekran  | RAM         |");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        for (Product product : notebooks) {
            System.out.format("| %-2d | %-29s | %-9.1f TL | %-9s | %-10d | %-6.1f | %-11d |\n", product.getId(), product.getName(), product.getUnitPrice(), product.getBrand().getName(), product.getStorage(), product.getScreenSize(), product.getRam());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("\nCep Telefonu Listesi");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat        | Marka     | Depolama  | Ekran   | Kamera    | Pil       | RAM       | Renk      |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        for (Product product : phones) {
            System.out.format("| %-2d | %-29s | %-9.1f TL | %-9s | %-10d | %-6.1f | %-9d | %-9.1f | %-9d | %-9s |\n", product.getId(), product.getName(), product.getUnitPrice(), product.getBrand().getName(), product.getStorage(), product.getScreenSize(), product.getCamera(), product.getBattery(), product.getRam(), product.getColor());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");

    }

    public  void listBrand(){
        System.out.println("| ID | Brand Adı  |");
        for (Brand brand : brands) {
            System.out.format("| %-1d  | %-10s |\n", brand.getId(), brand.getName());
        }
    }

    public Brand getBrandById(int id) {
        for (Brand brand : brands) {
            if (brand.getId() == id) {
                return brand;
            }
        }
        return null;
    }

}
