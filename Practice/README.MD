# Szintfelmermérő

Az alábbi feladatok megoldására 180 perc áll rendelkezésetekre. Figyelmesen olvassátok el a feladatokat és mindkét
feladatot oldjátok meg egy-egy külön package-ben. A feladatok megoldásánál törekedjetek a megfelelő osztályok
létrehozására és tartsátok tiszteletben az OOP és a Clean Code alapelveit. Mindkét feladat package-ében hozzatok létre
egy-egy `main` metódust, ahol bemutatjátok a feladatok megoldását.

A feladatok beadásához, hozzatok létre egy merge requestet az elkészült fájlokkal, akinek ez nem megy az `/src` mappát
küldje el becsomagolva nekem emailben.

## Pizza futár

Adott az `orders.txt` melyben pizza rendeléseket tárolunk. A fájl blokkokra van osztva, egy
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

Old meg az alábbi feladatokat az OOP alapelvek és a Clean Code előírásai szerint!

- Melyik napon volt a legkevesebb rendelés?
- Egy metódus várjon paraméterül egy dátumot, pontos időponttal és adjuk vissza a hozzá tartozó rendelést. Ha nincs
  ilyen akkor dobjunk kivételt.
- Készíts statisztikát a futárok szállításiból, futáronként add vissza, hogy mennyi rendelést teljesítettek.
- Melyik címre szállították a legtöbb pizzát?

## Vetélkedő

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

Old meg az alábbi feladatokat az OOP alapelvek és a Clean Code előírásai szerint!

- Írj egy metódust, melynek paramétere a téma és add vissza, az összes kérdést abban a témában. (Csak a kérdéseket)
- Írj egy metódust, ami random sorsol ki n darab kérdést, és adja vissza annak összes adatát. (Nem lehetnek egyezőek)
- Készíts egy metódust ami rendszerezi a kérdéseket témakörönként. Visszatér egy adatszerkezetben amelyben témánként
  megtalálható az összes kérdés, összes adata.
- Az előző feladat segítségével határozd meg, hogy melyik téma kérdései érik a legtöbb pontot (összpontszám)!