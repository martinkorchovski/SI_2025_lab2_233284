import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    public void testEveryStatement() {
        // Тест 1
        RuntimeException ex1 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(null, "123456")
        );
        assertTrue(ex1.getMessage().contains("allItems list can't be null!"));

        // Тест 2
        List<Item> items2 = List.of(new Item(null, 5, 200, 0.1));
        RuntimeException ex2 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items2, "123456")
        );
        assertTrue(ex2.getMessage().contains("Invalid item!"));

        // Тест 3
        List<Item> items3 = List.of(new Item("Item", 5, 400, 0.2));
        double result3 = SILab2.checkCart(items3, "1234567890123456");
        assertEquals(400 * 0.8 * 5 - 30, result3);

        // Тест 4
        List<Item> items4 = List.of(new Item("Item", 2, 150, 0));
        double result4 = SILab2.checkCart(items4, "1234567890123456");
        assertEquals(2 * 150, result4);

        // Тест 5
        List<Item> items5 = List.of(new Item("Item", 1, 100, 0));
        RuntimeException ex5 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items5, "1234abc6789xyz00")
        );
        assertTrue(ex5.getMessage().contains("Invalid character in card number!"));

        // Тест 6
        List<Item> items6 = List.of(new Item("Item", 1, 100, 0));
        RuntimeException ex6 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items6, "123456789")
        );
        assertTrue(ex6.getMessage().contains("Invalid card number!"));

        // Тест 7
        List<Item> items7 = List.of(new Item("Item", 2, 350, 0));
        double result7 = SILab2.checkCart(items7, "1234567890123456");
        assertEquals(2 * 350 - 30, result7);

        // Тест 8
        List<Item> items8 = List.of(new Item("Item", 1, 100, 0.0));
        RuntimeException ex8 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(items8, "12345X6")
        );
        assertTrue(ex8.getMessage().contains("Invalid card number!"));
    }

    @Test
    public void testMultipleCondition() {
        // Тест 1
        Item only_price = new Item("Laptop", 1, 301, 0);
        double result1 = SILab2.checkCart(List.of(only_price), "1234567890123456");
        assertEquals(301 - 30, result1); // намалување 30

        // Тест 2
        Item only_discount = new Item("Mouse", 1, 100, 0.2);
        double result2 = SILab2.checkCart(List.of(only_discount), "1234567890123456");
        assertEquals(100 * 0.8 - 30, result2); // discount и намалување 30

        // Тест 3
        Item only_quantity = new Item("Notebook", 11, 10, 0);
        double result3 = SILab2.checkCart(List.of(only_quantity), "1234567890123456");
        assertEquals(110 - 30, result3); // quantity и намалување 30

        // Тест 4
        Item all_false = new Item("Paper", 1, 100, 0);
        double result4 = SILab2.checkCart(List.of(all_false), "1234567890123456");
        assertEquals(100, result4);
    }
}
