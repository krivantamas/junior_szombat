# Junior Java Backend fejlesztő tanfolyam

## Feladatsor 1

### 1. Feladat - Java programozási nyelv alapjai:

Szoftverfejlesztés során több különböző módon hívhatjuk a változóinkat. Több konvenció is kialakulásra került az évek
alatt. Ezekkel a koncenciókkal fogunk dolgozni.

- snake_case - A szavak egymást követik `_` karakterrel elválasztva. Vagy nagybetűs vagy kisbetűs minden szó.
- camelCase - Minden új megkezdett szó nagybetűval kapcsolódik az előző szóhoz.
- PascalCase - Nagyon hasonló a camelCase-hez, annyi különbséggel, hogy az első szó is nagybetűvel indul.
- kebab-case - A szavak egymást követik `-` karakterrel elválasztva.

A feladatotok a `NamingConventionConverter` osztályba található, metódusok megvalósítása és az elkészültek kijavítása,
amíg a `/tests` package-ben lévő tesztesetek sikeresen le nem futnak.

### 2. Feladat - Java objektumorientált programozás:

Adott egy az `orders.txt` melyben pizza rendeléseket tárolunk. A fájl blokkokra van osztva, egy
blokk egy napot jelöl, és minden ilyen blokk egy dátummal kezdődik. Ezután egy rendelés adatai két sorban találhatók. Az
első sor a futár azonosítója, a második sorban irányítószám, utcanév, házszám és a szállítás pontos ideje található.

```
2020.12.01
FUT_1
1113 Petőfi 12 12:30
FUT_2
1114 Kossuth 9 11:20
FUT_2
1211 Jókai 10 19:30
FUT_3
1191 Kossuth 9 18:12
FUT_1
1144 Tököly 11 16:33
2020.12.02
FUT_1
1123 Ady 12 12:30
....
```

Old meg az alábbi feladatok az OOP alapelvek segítségével és használj osztályt, ahol tudsz.

- `leastAmountOrder`: Melyik napon volt a legkevesebb rendelés?
- `getOrderByDateAndTime`: Egy metódus várjon paraméterül egy dátumot, pontos időponttal és adjuk vissza a hozzá tartozó rendelést. Ha nincs
  ilyen akkor dobjunk kivételt.
- `getPostmanStatistics`: Készíts statisztikát a futárok szállításiból, futáronként add vissza, hogy mennyi rendelést teljesítettek.
- `mostFavoredAddress`: Melyik címre szállították a legtöbb pizzát?

Készíts teszt esetet minden metódusodhoz!

### 3. Feladat - Java kollekciók:

Adott egy vetélkedő kérdésbankja a `kerdesek.txt` fájlban. A fájlban az egy kérdéshez tartozó adatok
két sorban helyezkednek el. Első sorban a kérdés, a második sorban a válasz a pontszám és a téma, szóközzel
elválasztava. Olvasd be a fájl tartalmát a memóriába, majd oldjátok meg a lenti feladatokat.

```
Mikor volt a mohacsi vesz?
1526 1 tortenelem
Melyik evben bomlott fel a Nyugat-Romai Birodalom?
476 1 tortenelem
Melyik a legkisebb primszam?
2 1 matematika
Mennyi 64 kobgyoke?
4 2 matematika
...
```
A QuizManager osztályba készítsd el az alábbi metódusokat:

- Írj egy metódust, melynek paramétere a téma és add vissza, az összes kérdést abban a témában. (Csak a kérdéseket)
- Írj egy metódust, ami random sorsol ki n darab kérdést, és adja vissza annak összes adatát. (Nem lehetnek egyezőek)
- Készíts egy metódust ami rendszerezi a kérdéseket témakörönként. Visszatér egy adatszerkezetben amelyben témánként
  megtalálható az összes kérdés, összes adata.
- Az előző feladat segítségével határozd meg, hogy melyik téma kérdései érik a legtöbb pontot (összpontszám)!

Készíts teszt esetet minden metódusodhoz!

Próbáld meg a feladatot az OOP alapelvek segítségével megvalósítani és használj osztályt, ahol tudsz.

## Feladat 4 - Java io:

Adott egy fájl melyben egy reptér egy napi munkáját rögzítettük. Adott egy járatszám, az, hogy érkező vagy felszálló
gépről van-e szó. A kiinduló/cél város, attól függöen hogy indul vagy érkezik-e a gép és a felszállás/leszállás pontos
ideje.

```
FC5354 Arrival Dublin 18:16
KH2442 Departure Berlin 15:54
ID4963 Departure Amsterdam 15:22
CX8486 Arrival Brussels 10:37
EJ9251 Departure  Toronto 11:30
KJ7245 Departure Bern 6:18
JN6048 Arrival Moscow 18:39
MN5047 Arrival Athens 9:35
```

Az időpontok szándékosan így szereplnek, nincsenek nullák a számok előtt. Az adatok össze vissza szerepelnek a fájlban.
Feladatok:

- Olvasd be a fájl tartalmát a memóriába.
- Határozd meg, hogy induló vagy érkező járatból volt-e több.
- Legyen egy metódus ami járatszám alapján ad vissza egy járatot.
- Írj egy metódust ami bekér egy várost és azt, hogy az induló vagy érkező járatokat szeretnénk-e. És egy Listába adjuk
  viassza az összes abba városba induló/érkező repülőt.
- Adjuk vissza a legkorábban induló repülőt!
- Készíts egy `arrival.txt` és `departure.txt` fáljt amiben külön bontod a sorokat, attól függően, hogy érkező vagy
  induló járatról van szó.

Készíts teszt esetet minden metódushoz!

## Feladat 5 - Java adatbázis:

A feladatod egy félkész Film adatbázis befejezése. Futtasd az alábbi **SQL** utasítást, hogy létrehozd a megfelelő
táblákat és beszúrd az adatokat.

```sql
CREATE TABLE IF NOT EXISTS movie_category (
                                              movie_category_id serial PRIMARY KEY,
                                              movie_category_name VARCHAR ( 50 ) UNIQUE NOT NULL
    );

CREATE TABLE IF NOT EXISTS movie (
                                     movie_id serial PRIMARY KEY,
                                     movie_name VARCHAR ( 50 ) UNIQUE NOT NULL,
    movie_imdb_score REAL NOT NULL,
    movie_category_id INT NOT NULL,
    FOREIGN KEY (movie_category_id)
    REFERENCES movie_category (movie_category_id)
    );

INSERT INTO movie_category(movie_category_name) VALUES ('Horror'),('Akció'),('Vígjáték'),('Thriller');
INSERT INTO movie(movie_name,movie_imdb_score,movie_category_id) VALUES
                                                                     ('Oppenheimer',8.8,4),
                                                                     ('Barbie',7.5,3),
                                                                     ('Flash',7.0,2),
                                                                     ('Madarak',5.4,1);

```

A feladatod, befejezni az alkalmazást.
 - Az `Imdb` osztály tartalmaz egy grafikus felületet, de jelenleg egyik gomb se műdködik.
   - A meglévő implementáció alapján az `ImdbController` osztályban írd meg a hiányzó metódusokat.
   - Készíts egy grafikus felületet, az új film létrehozására. Az `addNewMovie` gomb megnyomására, jöjjön elő egy dialógus,
 amiben meg tudod adni a film adatait és a megfelelő metódus felhasználásával szúrd be azt az adatbázisba.