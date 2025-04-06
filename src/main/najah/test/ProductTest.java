package main.najah.test;
import main.najah.code.Product;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Testing Product Things")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductTest {
    Product product;
    @BeforeEach
    void setup() {
        product = new Product("Keyboard", 200);
        System.out.println("Product setup done.");
    }

    @Test
    @Order(1)
    @DisplayName("Make sure product name and price are okay")
    void testProductCreation() {
        assertEquals("Keyboard", product.getName());
        assertEquals(200.0, product.getPrice());
        assertEquals(0.0, product.getDiscount());
    }
    @Test
    @Order(2)
    @DisplayName("Discount is working?")
    void testDiscountThing() {
        product.applyDiscount(25);
        assertEquals(150.0, product.getFinalPrice());
    }
   
    
    
    @Test
    @Order(3)
    @DisplayName("error!")
    void testBadDiscount() {
        assertThrows(IllegalArgumentException.class, () -> product.applyDiscount(70));
    }
    @ParameterizedTest
    @Order(4)
    @ValueSource(doubles = {0, 10, 30, 50})
    @DisplayName("Try bunch of discounts")
    void testMoreDiscounts(double discount) {
        product.applyDiscount(discount);
        double expected = 200 * (1 - discount / 100);
        assertEquals(expected, product.getFinalPrice(), 0.01);
    }

    @Test
    @Order(5)
    @Timeout(1)
    @DisplayName("Is price fast?")
    void testSpeedyPrice() {
        product.applyDiscount(20);
        assertEquals(160.0, product.getFinalPrice());
    }

    @Test
    @Order(6)
    @Disabled("Product allert-Disable")
    @DisplayName("This one gonna fail")
    void testBrokenProduct() {
        new Product("Broken", -100);
    }
}

