package q9_7;

import java.awt.desktop.SystemEventListener;
import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    void Account(){
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
    }
    void Acccount(int id, double balance){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
    }
    void setId(int id){
        this.id = id;
    }
    void setBalance(double balance){
        this.balance = balance;
    }
    void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }
    String visitDateCreated(){
        return(dateCreated.toString());
    }
    double getMonthlyInterestRate(){
        return(annualInterestRate/12.0);
    }
    void withDraw(double money){
        if(money < balance){
            balance -= money;
        }
        else{
            System.out.println("You don't have enough money");
        }
    }
    void deposit(double money){
        this.balance += money;
        System.out.println("You don't have deposited" + money);
    }
}
