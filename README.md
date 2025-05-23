# Martin Korchovski 233284

### 3. Цикломатската комплексност
Цикломатската комплексност е 9, а резултатот го добив според формулата за предикатните јазли P + 1 (односно тие јазли кај кои се врши некаква проверка, т.е. се разгрануваат) која гласи дека комплексноста се пресметува како бројот на предикатните јазли +1.

### 4. Тест случаи

**Тест случај бр.1:**  
`SILab2.checkCart(null, "123456");`  
Во овој тест случај листата е null, така што if условот во 54та линија ќе биде исполнет и ќе се фрли exception во 55та линија.

**Тест случај бр.2:**  
`List<Item> items = List.of(new Item(null, 5, 200, 0.1));`  
`SILab2.checkCart(items, "123456");`  
Во овој тест случај креираме item со име null, па затоа if условот ќе биде исполнет во 62ра линија и ќе се фрли exception во 63та линија.

**Тест случај бр.3:**  
`List<Item> items = List.of(new Item("Item", 5, 400, 0.2));`  
`double result = SILab2.checkCart(items, "123456");`  
Во овој тест случај се проверува дали се пресметува сумата со попуст, кога условот за попуст е исполнет (цената е > 300).

**Тест случај бр.4:**  
`List<Item> items = List.of(new Item("Item", 2, 150, 0));`  
`double result = SILab2.checkCart(items, "123456");`  
Во овој тест случај се пресметува сумата, но без попуст.

**Тест случај бр.5:**  
`SILab2.checkCart(items, "123abc6789");`  
Во овој тест случај се проверува дали успешно ќе се фрли exception доколку се внесе невалиден број на картичка.

**Тест случај бр.6:**  
`SILab2.checkCart(items, "123456789");`  
Во овој тест случај се проверува дали ќе се изврши успешно доколку се внесе валиден број на картичка.

**Тест случај бр.7:**  
`List<Item> items = List.of(new Item("Item", 2, 350, 0));`  
`double result = SILab2.checkCart(items, "123456");`  
Во овој тест случај се проверува дали сумата ќе се намали за 30 ако цената на предметот е над 300.

**Тест случај бр.8:**  
`List<Item> items = List.of(new Item("Item", 1, 100, 0.0));`  
`SILab2.checkCart(items, "12345X6");`  
Во овој тест случај ќе се фрли exception во линија 89 бидејќи бројот на картичката содржи знак кој не е цифра.

### 5. Минимални тест случаи

За да се постигне овој критериум мора да има минимално 4 тест случаи:

1. **List<Item> items = List.of(new Item("Item", "", 320, ""));**  
   Се креира item со price поголем од 300, а другите две ставки не се битни. (ТXX)

2. **List<Item> items = List.of(new Item("Item", "", 200, 50));**  
   Се креира item кој го задоволува само вториот дел од if условот, односно discount > 0. (FTX)

3. **List<Item> items = List.of(new Item("Item", 15, 200, "-3"));**  
   Се креира item кој го задоволува само третиот дел од if условот, односно quantity > 10. (FFT)

4. **List<Item> items = List.of(new Item("Item", 5, 200, "-3"));**  
   Се креира item кој не задоволува ниеден дел од if условот. (FFF)
