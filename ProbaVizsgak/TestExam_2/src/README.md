# Junior Java Backend fejlesztő tanfolyam

## Próbavizsga

### 1. Feladat - Java programozási nyelv alapjai:

A `java_basics` package-ben egy jelszó létrehozó alkalmazást kell folytatnia a következő szempontok figyelembevételével:

- Az alkalmazás 4 jelszó típust támogat:
    - `Weak` - csak kisbetűk szerepelhetnek a jelszóban.
    - `Average` - kis és nagybetűk is szerepelhetnek a jelszóban.
    - `Strong` - kis és nagybetűk valamint számok is szerepelhetnek a jelszóban
    - `VeryStrong` - betűk, számok valamint speciális karakterek is szerepelhetnek a jelszóban. A lehetséges speciális
      karakterek definiálva vannak a `PasswordGenerator` osztályban.

A feladatod az lesz, hogy a `PasswordGenerator` osztály hiányzó metódusait befejezd és az elkészült metódusok mintájára
teszteket készítesz a `PasswordGeneratorTest` osztályban.
A jelenlegi tesztek közül nem fut le az összes, ezek megjavítása is a te dolgod.

### 2. Feladat - Java objektumorientált programozás:

A `java_oop` package-ben egy lévő autó kezelő alkalmazást kell folytatnia a következő szempontok figyelembevételével:

- A `Car` osztály egy autót reprezentál:
    - `identifier` - Az autó azonosítója
    - `manufacturer` - Az autó gyártója
    - `model` - Az autó modelle
    - `price` - Az autó ára
    - `isAvailable` - Az autó elérhetősége

A megrendelő szeretné, hogy minden autónak csak nagybetűk és számok lehessen az azonosítójában és mindig 10 karakterből
álljon.
Oldd meg, hogy ha ennél rövidebb azonosítót ad meg, akkor legyen feltöltve 10 karakterig `0`-s értékekkel kipótolva, ha
pedig ennél hosszabbat, akkor vágja le a végéről az extra karaktereket és mindenkép nagybetűssé legyen alakítva.
Példa: `id673 -> ID67300000`,  `FKLAKCI20KSCLAR -> FKLAKCI20K`.

Készíts a módosításhoz teszteseteket, ami ellenőrzi az azonosító hosszát.

A `Car` osztályban található `getNetPrice(Vat vat)` metódus, az autó árát számolja ki az adot ÁFA mértékkel. A `Vat`
enum-ba
vegyél fel két új régiót, `Malta(18)` és `Romania(19)` értékkel. Készíts teszteseteket a két új ÁFA régió tesztelésére.

Jelenleg egyik teszteset sem fut le, a tesztesetek jól lettek megírva egy senior fejlesztő által, keresd meg a hibákat
a `Car` osztályban és javítsd őket, amíg a meglévő tesztesetek hibátlanul le nem futnak.

### 3. Feladat - Java kollekciók:

A `java_collections` package-ben található `ComputerStorageSystem` osztály befejezése lesz a feladatod.
Az osztály egy számítógép raktár kezelő alkalmazás, amiben különböző lekérdezések vannak, ami alapján szűrni lehet a
számítógépeket. Az előző fejlesztő nem tudta befejezni az összes lekérdezést, ezeknek a pótlása a te feladatod lesz és a
tesztelő csapat szerint a jelenlegi lekérdezések közül nem működik az összes az elvárás szerint. A `tests` package-ben
található `ComputerStorageSystemTest` teszt esetek találsz, amik az elvárt működés szerint vizsgálják a metódusokat.
A feladatod a teszt esetek mentén javítani a jelenlegi lekérdezéseket, valamint a három befejezetlen metódus
implementálása
a `ComputerStorageSystem` osztályban. A három új metódus tesztelése is a te feladatod lesz.

### Feladat 4 - Java io:

A feladatod a `people.csv` fáljban lévő adatok beolvasása. A beolvasáshoz használd a `PeopleReader` osztály
`readPeoplesFromCsv` metódusát. A fájl feldolgozása során az adatokból `People` objektumokat kell létrehoznod, majd egy
listával
visszatérni ami az összes beolvasot sort tartalmazza.

```text
15,Bekki,Box,bboxe@istockphoto.com,Male,100.30.61.219
16,Foss,Coath,fcoathf@quantcast.com,Female,117.4.186.76
17,Isaak,McKendo,imckendog@hubpages.com,Female,137.173.34.102
18,Brod,Lattie,blattieh@hibu.com,Male,193.218.145.204
19,Minette,Avraam,mavraami@mail.ru,Female,160.75.62.47
20,Fredia,Gostall,fgostallj@hostgator.com,Male,230.186.235.18
21,Dickie,Temby,dtembyk@smh.com.au,Female,162.217.250.191
22,Johnnie,Shier,jshierl@amazon.co.jp,Male,17.224.59.156
23,Karl,Eckh,keckhm@smugmug.com,Female,219.245.232.31
24,Dee,Corrado,dcorradon@bing.com,Male,59.138.238.50
25,Cynthy,Torrecilla,ctorrecillao@unicef.org,Female,185.167.151.86
26,Rriocard,Pledger,rpledgerp@ask.com,Male,154.198.234.59
27,Rica,Bullick,rbullickq@whitehouse.gov,Female,232.176.243.117
28,Bink,Nightingale,bnightingaler@flickr.com,Female,238.54.63.78
29,Matti,MacClay,mmacclays@linkedin.com,Male,199.156.221.87
30,Bren,Solman,bsolmant@privacy.gov.au,Male,47.120.166.73
```

A feladatod a `readPeoplesFromCsv` metódus implementálása. A sikeres implementálás után a `PeopleReaderTest` -ben található
metódusok sikeresen le fognak futni.
A `peopleReadTest_5` metódusban teszteld, hogy a férfiak száma `545` a nők száma pedig `455`.

### Feladat 5 - Java adatbázis:

A feladatod egy Hotel szobanyilvántartó rendszerének befejezése lesz.
Hozz létre egy adatbázist és csatlakozz hozzá a `Database` osztályban található `createConnection` metódus megfelelő
paraméterezésével.

A PgAdmin felületen futtasd az alábbi SQL-t, hogy létrehozd a táblákat és beszúrd a kezdő adatokat.

```sql
CREATE TABLE IF NOT EXISTS room_category (
	room_category_id serial PRIMARY KEY,
	room_category_name VARCHAR ( 50 ) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS room (
	room_id serial PRIMARY KEY,
	room_level INT NOT NULL,
	room_area REAL NOT NULL,
	room_price INT NOT NULL,
	room_reserved BOOL NOT NULL,
	room_on_sale BOOL NOT NULL,
	room_category_id INT NOT NULL,
	FOREIGN KEY (room_category_id)
		REFERENCES room_category (room_category_id)
);

INSERT INTO room_category(room_category_name) VALUES ('Economy'),('Default'),('Premium'),('Luxury');
INSERT INTO room(room_level,room_area,room_price,room_reserved,room_on_sale,room_category_id) VALUES
	(1,19.5,400,TRUE,FALSE,1),
	(1,20.5,450,FALSE,FALSE,1),
	(1,23.5,500,FALSE,FALSE,1),
	(1,25.5,475,TRUE,FALSE,1),
	(2,32.5,550,TRUE,TRUE,2),
	(2,43.5,600,TRUE,TRUE,2),
	(2,40.5,650,FALSE,TRUE,2),
	(3,60.5,700,TRUE,TRUE,3),
	(3,65.5,760,TRUE,FALSE,3),
	(3,70.0,800,FALSE,FALSE,3),
	(4,83.5,1400,TRUE,TRUE,4),
	(4,132.5,2400,FALSE,TRUE,4);
```

A feladatod, befejezni az alkalmazást.

- Javítsd ki a hibás teszt eseteket
- Az `Hotel` osztály tartalmaz egy grafikus felületet, de jelenleg az `Add Room` gomb nem működik.
    - Találsz egy `addRoom(RoomDao room)` a `Hotel` osztályban. A gomb megnyomására hozz létre egy `Dialog`-t amin a
      felhasználó fel tudja vinni az új szoba adatait és az Ok gomb lenyomására az új szoba szúrodjon be az adatbázisba.
    - Old meg, hogy a táblázat frissüljön az új szoba adataival.
- A `RoomDaoTest`-ben található teszt metódus nem fut le sikeresen. A teszt azt ellenőrzi, hogy a `getOnSalePrice`
  megfelelően működik-e. Ha a szoba akciós, akkor az `getOnSalePrice` metódusnak, a szoba árának 90%-val kell
  visszatérnie. Ha nem akciós, akkor pedig a rendes árral.