/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.celestial.banking.core.Account;
import com.celestial.banking.core.CreditAccount;
import com.celestial.banking.core.InterestRate;
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
        
        test_does_balance_match_after_dedit_and_credit();
        
        test_going_overdrwn_on_credit_account();
    
        test_does_balance_match_after_dedit_on_CreditAccount();
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
        
        Account acc = new CreditAccount( 1, "Selvyn", openingBalance, InterestRate.BUSINESS_LOAN );
        
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

    static  void    test_does_balance_match_after_dedit_and_credit()
    {
        // arrange
        double  openingBalance = 56.78;
        double  amountToDebit = 44.00;
        double  amountToCredit = 78.45;
        Account acc = new Account( 1, "Selvyn", openingBalance );
        
        // act 
        acc.dedit(amountToDebit);
        acc.credit(amountToCredit);
        
        // assert
        if( (openingBalance-amountToDebit+amountToCredit) == acc.availableBalance() 
            && (openingBalance-amountToDebit+amountToCredit) == acc.currentbalance() )
            System.out.println( "test_does_balance_match_after_dedit_and_credit:PASSED" );
        else
            System.out.println( "test_does_balance_match_after_dedit_and_credit:FAILED");
    }

    static  void    test_going_overdrwn_on_credit_account()
    {
        // arrange
        double  openingBalance = 56.78;
        double  amountToDebit = 77.00;
        Account acc = new CreditAccount( 1, "Selvyn", openingBalance, InterestRate.HOME_LOAN );
        
        // act 
        acc.dedit(amountToDebit);
        
        // assert
        amountToDebit += amountToDebit * InterestRate.HOME_LOAN.rate()/100;
        if( (openingBalance-amountToDebit) == acc.availableBalance() 
            && (openingBalance-amountToDebit) == acc.currentbalance() )
            System.out.println( "test_going_overdrwn_on_credit_account:PASSED" );
        else
            System.out.println( "test_going_overdrwn_on_credit_account:FAILED");
    }
    

    static  void    test_does_balance_match_after_dedit_on_CreditAccount()
    {
        // arrange
        double  openingBalance = 56.78;
        double  amountToDebit = 44.00;
        Account acc = new CreditAccount( 1, "Selvyn", openingBalance, InterestRate.HOME_LOAN );
        
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
