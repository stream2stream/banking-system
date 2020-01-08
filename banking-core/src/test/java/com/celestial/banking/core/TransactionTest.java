/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.celestial.banking.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Admin
 */
public class TransactionTest
{
    
    public TransactionTest()
    {
    }

    @Test
    public void transaction_created_balance_is_equal_to_deposit() 
    {
        // arrange
        double  initAmount = 67.77;
        double  expectedResult = 67.77;
        Transaction t1 = new Transaction(initAmount);
        
        // act
        double actualResult = t1.getAmount();
        
        // assert
        assertEquals(expectedResult, actualResult);
    }
}
