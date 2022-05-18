import java.util.Scanner;

public class Account {
    int balance = 0;
    int previousTransaction;
    String customerName;
    String customerID;
    Account(String cname, String cid){
        customerName = cname;
        customerID = cid;
    }


    public void showmenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID + "\n");
        System.out.println("What would you like to do?\n");
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View Previous transaction");
        System.out.println("E. Calculate Interest");
        System.out.println("F. Exit\n");
        while (true){
            System.out.println("Enter your option: ");
            char option = scanner.next().charAt(0);
            switch (option){
                case 'A':
                System.out.println(balance);
                continue;
                case 'B':
                System.out.println("Enter Amount To Deposit: ");
                int depoamount = scanner.nextInt();
                deposit(depoamount);
                continue;
                case 'C':
                System.out.println("Enter Amount To Withdraw: ");
                int withdrawamount = scanner.nextInt();
                withdraw(withdrawamount);
                continue;
                case 'D':
                getPreviousTransaction();
                continue;
                case 'E':
                System.out.println("Enter years: ");
                int year = scanner.nextInt();
                calculateInterest(year);
                continue;
                case 'F':
                System.out.println("====== Exiting Bank ======");
                break;
                default:
                System.out.println("Invalid Option. Enter A B C D E or F.");
                continue;



            }
            scanner.close();
            break;
        }

    }
    public void deposit(int amount){
        if(amount >0){
            balance += amount;
            previousTransaction = amount;
        }
    }
    public void withdraw(int amount){
        if (amount > 0 ){
            balance -= amount;
            previousTransaction = -amount;
        }
    }
    public void getPreviousTransaction(){
        if (previousTransaction > 0){
        System.out.println("You deposited " + previousTransaction);
        }
        else if(previousTransaction < 0){
            System.out.println("You Withdrew " + Math.abs(previousTransaction));
        }
        else{
            System.out.println("No previous transaction");
        }
    }
    public void calculateInterest(int years){
        double interestRate = 0.0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate));
        System.out.println("After "+ years + " years, your balance will be: " + newBalance);

    }
}
