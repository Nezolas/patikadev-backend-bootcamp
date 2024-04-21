# Turizm Acente Sistemi

Tech Stack : Java, Java Swing

Turizm Acentesinin çalışma mantığı şu şekildedir : Oteller Patika Turizm Acentesine belirli oda rezerv ederler ve bu odaları acentenin satmasını beklerler. Acente bu odaları satarken üstüne kendi hizmet bedelini yüzde veya sabit bir fiyat koyarak müşterilerine satar.

Acente bu işleri kağıt üzerinde ve manuel olarak yapmanın zaman kaybı olduğunu düşünür, işini kolaylaştıracak bir yazılıma ihtiyaç duymaktadır.

Acentenin yazılımdan beklentisi :

Otel Yönetimi
Acente anlaşmalı olduğu otelleri, konum bilgileri ve diğer özellikleri ile birlikte sistemden yönetmeli. Otel eklenirken Otel Adı, Adres, E-posta, Telefon, Yıldız, Tesis Özellikleri, Pansiyon tipleri gibi diğer tanımlamalar yapılır.

Otellere ait tarihsel dönemler eklenir ve fiyatlandırmalar bu dönemler üzerinden yapılır. Burada ki amaç değişken bir fiyatlandırma sunabilmektir. Yaz aylarında otel fiyatları daha yüksek iken, bu durum kış ayları için daha azdır. Fiyatlandırmalar turizm sektöründe dönemsel olarak yapılır. Dönemler iki tarih aralığı olarak tanımlanır.

Uygulamanın yapısını ve ekranların özelliklerini anlattıgım 5 dk'lık loom videosu: 
https://www.loom.com/share/312f07ef65134fba9fa9aeb71fc33920?sid=c2ea3347-27e0-4750-99f9-26c7cfcc2091

## Uygulama Yapısı

![](/ss/ss1.PNG)

Bu uygulamada Business,Data Access ve Presentation katmanlarımız var. Her bir katmanı kısaca inceleyecek olursak;


![](/ss/ss2.PNG)

Business katmanımız Veritabanı işlemlerimiz ve kullanıcı ekranlarımız arasındaki alıcıdır. İş kuralları bu katmanda uygulanır.


![](ss/ss3.PNG)

Core paketini uygulamamızdaki yardımcı bir sınıf olarak tanımlayabiliriz.


![](/ss/ss4.PNG)

Data Access katmanında Veri tabanı işlemleri yapılır. LoginGUI, AdminGUI ve EmployeeGUI için ayrı sınıflarımız var.


![](/ss/ss5.PNG)

Entities bizim Veri tabanı nesnelerimizin tutuldugu pakettir. Veri tabanındaki tablolarımızı uygulamamızda ki karşılıklarıdır.


![](/ss/ss6.PNG)

Presentation katmanı kullanıcının uygulamayı kullanırken gördügü katman diyebiliriz. Bu uygulamada temel olarak LoginGUI,AdminGUI
ve EmployeeGUI ımız vardır. Gördüğünüz diğer GUI'lar bu sınıflar içerisinde duruma göre kullanılır.

