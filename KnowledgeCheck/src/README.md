# Junior Java Backend fejlesztő tanfolyam

## Tudásfelmérő

### 1. feladat - User name generator

A `user_name_generator` package-ben található felhasználónév létrehozó alkalmazást kell folytatnia a következő
szempontok
figyelembevételével.

- A felhasználónév létrehozása a vezetéknév, keresztnév és születési év alapján történik.
- A felhasználónév első kettő karaktere nagybetű a vezetéknév első két karaktere, majd ezt követi a keresztnév első
  három karaktere kisbetűvel. Végül egy alulvonás és a születési év utolsó két karaktere.
- Egy lehetséges bemenet: Teszt (Vezetéknév) Elek (Keresztnév) 1996 (Születési év) -> TEele_96

A jelenlegi implementáció hibás és rosszul állítja össze a felhasználónevet, a feladata, hogy javítsa meg az alkalmazást
a generálási szempontok figyelembevételével.

Bővítse az alkalamzást: Készítsen egy új `generateUserNameV2` metódust a `UserNameGenerator` osztályba, ahol születési
év 3 számjegye kerül a
felhasználónévbe, ha 2000 előtt
született a felhasználó és mind a négy karakter, ha 2000 után.

### 2. feladat - Emission io:

A `emission_io` package-ben található széndioxid kibocsájtás feldolgozó alkalmazást kell folytatnia a következő
szempontok
figyelembevételével.

```text
Make,Model,Vehicle Class,Engine Size(L),Cylinders,Transmission,Fuel Type,Fuel Consumption City (L/100 km),Fuel Consumption Hwy (L/100 km),Fuel Consumption Comb (L/100 km),Fuel Consumption Comb (mpg),CO2 Emissions(g/km)
ACURA,ILX,COMPACT,2,4,AS5,Z,9.9,6.7,8.5,33,196
ACURA,ILX,COMPACT,2.4,4,M6,Z,11.2,7.7,9.6,29,221
ACURA,ILX HYBRID,COMPACT,1.5,4,AV7,Z,6,5.8,5.9,48,136
ACURA,MDX 4WD,SUV - SMALL,3.5,6,AS6,Z,12.7,9.1,11.1,25,255
```

> A feldolgozás során, nem kell az összes oszlopot felhasználni!

- Olvassa be az emission.csv fáljban található adatokat az `EmissionReader` osztály felhasználásával.
- Valósítsa meg a `readEmissionFromCSV` metódust, ami `CarEmissionInfo` objektumok listájával tér vissza.
- Az `EmissionRepository` osztályban található `carEmissionInfoList` listát az `EmissionReader`
  osztály `readEmissionFromCSV` metódusa tölti fel adatokkal.
- Valósítsa meg az `EmissionRepository` osztályban található metódusokat:
    - `getMinCo2Emission` - Térjen vissza a legkisebb co2 emission értékkel.
    - `getMaxCo2Emission` - Térjen vissza a legnagyobb co2 emission értékkel.
    - `getUniqueEngineSizeCount` - Térjen a különböző motor méretek számával.
    - `getAllManufacturer` - Térjen vissza egy listával, ami tartalmazza az összes különböző gyártót.
    - `getAllEmissionInfoByEngineSize` - Térjen vissza egy listával, ami az összes `CarEmissionInfo` objektumot
      tartalmazza, aminek a motormérete megegyezik a paraméterül kapott motor mérettel. Ha nincs egyezés térjen vissza
      üres listával.