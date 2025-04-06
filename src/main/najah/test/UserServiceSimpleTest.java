package main.najah.test;

import main.najah.code.UserService;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("UserService Testing Thing")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceSimpleTest {

    UserService userService;

    @BeforeEach
    void beforeEach() {
        userService = new UserService();
        System.out.println("UserService is ready.");
    }

    @Test
    @Order(1)
    @DisplayName("Email looks okay?")
    void emailShouldBeValid() {
        assertTrue(userService.isValidEmail("hey@juicewrld.com"));
    }

    @Test
    @Order(2)
    @DisplayName("Email is trash")
    void emailIsBad() {
        assertFalse(userService.isValidEmail("justtext"));
    }

    @Test
    @Order(3)
    @DisplayName("Login should work")
    void goodLogin() {
        assertTrue(userService.authenticate("admin", "1234"));
    }

    @Test
    @Order(4)
    @DisplayName("Wrong login fail expected")
    void badLogin() {
        assertFalse(userService.authenticate("wrong", "pass"));
    }

    @Test
    @Order(5)
    @Timeout(1)
    @DisplayName("Login should be speedy")
    void testFastLogin() {
        assertTrue(userService.authenticate("admin", "1234"));
    }

    @Test
    @Order(6)
    @Disabled("Empty emails not checked yet")
    @DisplayName("Disabled test for empty email")
    void testEmptyEmail() {
        assertFalse(userService.isValidEmail(""));
    }
}
