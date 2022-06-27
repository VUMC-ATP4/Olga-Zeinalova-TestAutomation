package mavenTestNGHomework;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {

    Calculator calculator;


    @BeforeClass
    public void beforeClass(){
        System.out.println("Mans TestNG tests.");

    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Tests ir sācies.");
        calculator = new Calculator();
    }

    @Test
    public void testAdd(){
        System.out.println("Tests saskaitīšana.");
        int actualResult = calculator.add(2,3);
        int expectedResult = 5;
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void testSubtraction(){
        System.out.println("Tests atņemšana.");
        int actualResult = calculator.substract(10,5);
        int expectedResult = 5;
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void testDivision(){
        System.out.println("Tests dalīšana");
        float actualResult = calculator.divide(15,5);
        float expectedResult = 3;
        Assert.assertEquals(actualResult,expectedResult);
    }

    @AfterClass
    public void afterTest(){
        System.out.println("Tests ir beidzies.");
    }
}
