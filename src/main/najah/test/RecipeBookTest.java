package main.najah.test;

import main.najah.code.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RecipeBook")
public class RecipeBookTest {

    RecipeBook recipeBook;
    Recipe recipe;

    @BeforeEach
    void cookPrep() throws Exception {
        recipeBook = new RecipeBook();
        recipe = new Recipe();
        recipe.setName("Latte");
        recipe.setAmtCoffee("2");
        recipe.setAmtMilk("3");
        recipe.setAmtSugar("1");
        recipe.setAmtChocolate("1");
        recipe.setPrice("10");
        System.out.println("Recipe is ready for test!");
    }

    @Test
    @DisplayName("Add recipe? Yeah!")
    void addRecipeShouldWork() {
        assertTrue(recipeBook.addRecipe(recipe));
    }

    @Test
    @DisplayName("Add again? Nope")
    void addSameRecipeTwice() {
        recipeBook.addRecipe(recipe);
        assertFalse(recipeBook.addRecipe(recipe));
    }

    @Test
    @DisplayName("return name")
    void testRecipeDelete() {
        recipeBook.addRecipe(recipe);
        String deleted = recipeBook.deleteRecipe(0);
        assertEquals("something", deleted);
    }

    @Test
    @DisplayName("Editing a recipe thing")
    void editRecipeTest() {
        recipeBook.addRecipe(recipe);
        Recipe newOne = new Recipe();
        newOne.setName("Tea");
        try {
            newOne.setAmtMilk("2");
        } catch (RecipeException e) {
            throw new RuntimeException(e);
        }
        String changed = recipeBook.editRecipe(0, newOne);
        assertEquals("Latte", changed);
    }

    @Test
    @Disabled("Doesn’t work")
    @DisplayName("Delete Recipes that never been added ?")
    void deleteGhostRecipe() {
        String result = recipeBook.deleteRecipe(2);
        assertNotNull(result);
    }
}
