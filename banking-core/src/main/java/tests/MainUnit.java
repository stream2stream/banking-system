/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.celestial.banking.core.Account;
import com.celestial.banking.core.Transaction;

/**
 *
 * @author Admin
 */
public class MainUnit
{
    public  static  void    main( String args[] )
    {
        test_Transactions();
        
        test_does_balance_match_opening_amount_on_acount();

        test_does_balance_match_after_credit();
        
        test_does_balance_match_after_dedit();
    }
    
    static  void    test_Transactions()
    {
        Transaction t1 = new Transaction(67.77);
        
        System.out.println( "Amount: " + t1.getAmount());
        System.out.println( "When: " + t1.getWhen()); 
    }
    
    static  void    test_does_balance_match_opening_amount_on_acount()
    {
        
        // arrange & act
        double  openingBalance = 56.78;
        
        Account acc = new Account( 1, "Selvyn", openingBalance );
        
        // assert
        if( openingBalance == acc.availableBalance() 
            && openingBalance == acc.currentbalance() )
            System.out.println( "test_does_balance_match_opening_amount_on_acount:PASSED" );
        else
            System.out.println( "test_does_balance_match_opening_amount_on_acount:FAILED");
    }

    static  void    test_does_balance_match_after_credit()
    {
        // arrange
        double  openingBalance = 56.78;
        double  amountToDeposit = 44.00;
        Account acc = new Account( 1, "Selvyn", openingBalance );
        
        // act 
        acc.credit(amountToDeposit);
        
        // assert
        if( (openingBalance+amountToDeposit) == acc.availableBalance() 
            && (openingBalance+amountToDeposit) == acc.currentbalance() )
            System.out.println( "test_does_balance_match_after_credit:PASSED" );
        else
            System.out.println( "test_does_balance_match_after_credit:FAILED");
    }

    static  void    test_does_balance_match_after_dedit()
    {
        // arrange
        double  openingBalance = 56.78;
        double  amountToDebit = 44.00;
        Account acc = new Account( 1, "Selvyn", openingBalance );
        
        // act 
        acc.dedit(amountToDebit);
        
        // assert
        if( (openingBalance-amountToDebit) == acc.availableBalance() 
            && (openingBalance-amountToDebit) == acc.currentbalance() )
            System.out.println( "test_does_balance_match_after_dedit:PASSED" );
        else
            System.out.println( "test_does_balance_match_after_dedit:FAILED");
    }
}
