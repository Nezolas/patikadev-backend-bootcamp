
# PATIKA+ TURIZM ACENTE SISTEMI PROJESI

#### UYGULAMA İSTERLERİ:
Patika Turizm Acentesi pek çok otel ile anlaşma yaparak otellerin odalarını müşterilere rezerve etmektedir. Acente tarafından admin yetkisine sahip ilk kişi yazılımcı tarafından veri tabanına kaydedilecektir. Admin yetkisine sahip kişi de sisteme login olup hem admin hem acente çalışanı ekleyebilecektir. Acente çalışanları sisteme otel, oda kaydedecek ve müşterilerin taleplerine göre oda araması yapıp rezervasyon işlemi yapacaktır. Müşterilerin sisteme erişimi olmadığını, telefon veya yüz yüze destek aldığı bir senaryo düşünün.

Otel Yönetim Sistemi, kullanıcı dostu bir arayüzle acente çalışanlarına esnek fiyatlandırma, detaylı otel ve oda yönetimi, rezervasyon kolaylığı ve otomatik hesaplama gibi özellikler sunarak bu amaçları gerçekleştirmeyi hedeflemektedir.

Acente bu işleri kağıt üzerinde ve manuel olarak yapmanın zaman kaybı olduğunu düşünür, işini kolaylaştıracak bir yazılıma ihtiyaç duymaktadır.


## Kullanılan Teknolojiler ve Yapı

- JAVA SE
- Swing
- MySQL
- Çok Katmanlı Mimari (N-Tier Architecture) 
## ALAKALI İÇERİK

Projede kullanılan veritabanını tekra oluşturmak için aşağıdaki bağlantıya tıklayabilir yada dosya içersindeki database.md sayfasını ziyaret edebilirsiniz.

[DATABASE](https://github.com/nezolas)


## Uygulama Yapısı

Uygulama Business, Core, Data Access, Entities ve GUI katmanlarından oluşuyor, katmanlar ise şu şekilde;

- **Business**
    -
    - #### *abstracts*
        - IHotelService
        - ILoginService
        - ISeasonService
        - IUserService
    - #### *concretes*
        - AdminManager
        - EmployeeHotelDetailManager
        - EmployeeManager
        - LoginManager

- **Core**
    -
    - Config
    - DBConnector
    - Notify

- **Data Access**
    -
    - #### *abstracts*
        - IAdminRepository
        - IEmployeeDetailRepository
        - IEmployeeRepository
        - ILoginRepository
        - IPensionRepository
        - ISeasonRepository
        - IUserRepository

    - #### *concretes*
        - MysqlAdminRepository
        - MysqlEmployeeDetailRepository
        - MysqlEmployeeRepository
        - MysqlLoginRepository
        - MysqlUserRepository

- **Entities Concretes**
    -
    - Hotel
    - HotelFeature
    - Presentation
    - Reservation
    - Room
    - RoomFeature
    - SearchResult
    - Season
    - User
- **Presentation GUI**
    -
- #### *abstracts*
    - Layout
- #### *AddRoomPropertyGUI*
    - AddRoomPropertyGUI
    - AddRoomPropertyGUI.form
- #### *AdminGUI*
    - AdminGUI
    - AdminGUI.form
- #### *EmployeeGUI*
    - EmployeeGUI
    - EmployeeGUI.form
- #### *EmployeeHotelDetailGUI*
    - EmployeeHotelDetailGUI
    - EmployeeHotelDetailGUI.form
- #### *LoginGUI*
    - LoginGUI
    - LoginGUI.form
- #### *ReservationGUI*
    - ReservationGUI
    - ReservationGUI.form


## Değerlendirme Kriterleri 
Aşağıdaki listede soruların cevaplarına karşılık gelen kodların yerleri belirtişmiştir.
```bash
  6  - core             -> DBConnector 
  7  - presentation.gui -> AdminGUI         -> AdminGUI
  8  - presentation.gui -> EmployeeGUI      -> EmployeeGUI
  9  - presentation.gui -> EmployeeGUI      -> LoginGUI         -> line 24
  10 - presentation.gui -> EmployeeGUI      -> EmployeeGUI      -> line 216
  11 - presentation.gui -> EmployeeHotelGUI -> EmployeeHotelGUI -> line 188
  12 - presentation.gui -> EmployeeHotelGUI -> EmployeeHotelGUI -> line 202
  13 - presentation.gui -> EmployeeHotelGUI -> EmployeeHotelGUI -> line 230
  14 - presentation.gui -> EmployeeGUI      -> EmployeeGUI      -> line 196
  15 - presentation.gui -> EmployeeGUI      -> EmployeeGUI      -> line 235
  16 - presentation.gui -> EmployeeGUI      -> EmployeeGUI      -> line 287
  17 - presentation.gui -> EmployeeGUI      -> EmployeeGUI      -> line 196
  18 - presentation.gui -> ReservationGUI   -> ReservationGUI   -> line 25
  19 - presentation.gui -> ReservationGUI   -> ReservationGUI   -> line 39
```
## Proje Tanıtım Videosu 
[![Watch the video](https://png.pngtree.com/png-vector/20190215/ourmid/pngtree-play-video-icon-graphic-design-template-vector-png-image_530837.jpg)](https://youtu.be/rQ_5madsPvc)

## Gerekli Olabilecek Bağlantılar

 - [AMPPS](https://awesomeopensource.com/project/elangosundar/awesome-README-templates)
 - [MYSQL JDBC Connector](https://dev.mysql.com/downloads/file/?id=525081)


