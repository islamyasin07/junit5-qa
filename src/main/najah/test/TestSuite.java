package main.najah.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
	    ProductTest.class,
        CalculatorTest.class,
        UserServiceSimpleTest.class,
        RecipeBookTest.class
})
public class TestSuite {
}
