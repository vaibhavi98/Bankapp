package bankapp;
import java.util.Scanner;
import java.util.ArrayList;


/**
 *
 * @author vaibhavi
 */
public class Bankapp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    int ch,acc;float bal;String name;
    int sender,receiver,hightracker;
    float s,totbal,highest;
    Scanner inp=new Scanner(System.in);
    ArrayList<Bank> mylist = new ArrayList<Bank>();
    int count=0;
    do{
        System.out.println("\nPlease Select Your Choice");
        System.out.println("1.Add Customer");
        System.out.println("2.Deposit");
        System.out.println("3.Withdraw");
        System.out.println("4.Transfer");
        System.out.println("5.Total Money");
        System.out.println("6.Richest Person");
        System.out.println("7.Exit");
        System.out.println("Enter Choice : ");
        ch=inp.nextInt();
        
        switch(ch)
        {
            case 1:
                System.out.println("Account no :"+count);
                System.out.println("Enter the name");
                name=inp.next();
                System.out.println("Enter the balance");
                bal=inp.nextFloat();
                Bank b=new Bank(count,bal,name);
                mylist.add(b);
                count++;
                break;
            case 2:
                System.out.println("Enter the Account Number : ");
                acc=inp.nextInt();
                Bank a= new Bank();
                a=mylist.get(acc);
                System.out.println("Customer Name is: "+a.name);
                System.out.println("Balance is : "+a.balance);
                System.out.println("Enter the amount to be Deposited :");
                bal=inp.nextFloat();
                a.balance=a.balance+bal;
                System.out.println("The new balance is : "+a.balance);
                break;
            case 3:
                System.out.println("Enter the Account Number : ");
                acc=inp.nextInt();
                Bank c= new Bank();
                c=mylist.get(acc);
                System.out.println("Customer Name is: "+c.name);
                System.out.println("Balance is : "+c.balance);
                System.out.println("Enter the amount to be Withdrawn :");
                bal=inp.nextFloat();
                if(bal > c.balance || c.balance <= 1000)
                {
                    System.out.println("Sorry Insufficient Funds");
                           
        
                }
                else{
                c.balance=c.balance-bal;
                System.out.println("The New Balance is :"+c.balance);
                }
                break;
            case 4:
                System.out.println("Enter The senders Account Number : ");
                sender=inp.nextInt();
                Bank d= new Bank();
                d=mylist.get(sender);
                System.out.println("Sender's Name is: "+d.name);
                System.out.println("Sender's Balance is : "+d.balance);
                
                System.out.println("Enter The Reciever's Account Number : ");
                receiver=inp.nextInt();
                Bank e= new Bank();
                e=mylist.get(receiver);
                System.out.println("Reciever's Name is: "+e.name);
                System.out.println("Reciever's Balance is : "+e.balance);
                
                
                System.out.println("Enter the amount to be Transferred :");
                s=inp.nextFloat();
                if(s>d.balance-1000)
                    System.out.println("Sorry Insufficient balance to transfer");
                else{
                d.balance=d.balance-s;
                e.balance=e.balance+s;
                System.out.println("Transfer completed");
                System.out.println("Sender's Balance is : "+d.balance);
                System.out.println("Reciever's Balance is : "+e.balance);
                
              }
                break;
            case 5:
                totbal=0;
                for(acc=0;acc<mylist.size();acc++)
                {
                    Bank f= new Bank();
                    f=mylist.get(acc);
                    totbal=totbal+f.balance;
                    
                }
                System.out.println("The Total Money in bank : "+totbal);
                break;
            case 6:
                highest=0;
                hightracker=0;
                for(acc=0;acc<mylist.size();acc++)
                {
                    Bank g = new Bank();
                    g=mylist.get(acc);
                    if(highest <= g.balance)
                    {
                        highest=g.balance;
                        hightracker=acc;
                        
                    }
                         
                }
                Bank g = new Bank();
                g=mylist.get(hightracker);
                System.out.println("Richest person is : "+g.name);
                System.out.println("Account number is : "+g.accno);
                System.out.println("Balance is : "+g.balance);
                break;
            case 7: 
                System.exit(0);
            
           }
        
        
    }while(ch!=7);
    
  }
    
}

class Bank {
    int accno;
    float balance;
    String name;
    
    public Bank() {}
    
    public Bank(int accno,float balance,String name)
    {
        super();
        this.accno=accno;
        this.balance=balance;
        this.name=name;
    }
 
    }
