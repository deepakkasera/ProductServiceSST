package com.sst.productservicesst.controllers;

import com.sst.productservicesst.controllers.ProductController;
import com.sst.productservicesst.exceptions.ProductNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class RandomTest {

    @Test
    public void testTwoPlusTwoIsFour() {
        //Arrange + Act
        int x = 2 + 2;

//        assert x == 4;

        //assert methods.



        assertEquals(4, x, "Expected value of x was 4, please check your implementation.");
        // assertNull(object); If object is NULL, assert statement will pass, else fails.
//        assertThrows(ProductNotFoundException.class, productController.getProductById(10000L));

//        assertTimeout(Duration.ofSeconds(1), productController.getProductById(10000L));
    }

}

/*

Settle Expenses -> Code Splitwise-1 or 2

Test case is nothing but a method which executes some other method
and compares the output with the expected output. If output matches,
test cases passes else it fails.

3A's

-> Arrange
-> Act
-> Assert (check)


In assert statements, first value should always be the expected value.
 */
