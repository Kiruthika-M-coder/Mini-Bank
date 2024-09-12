import java.util.Scanner;
public class Bank {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //get input for account name/customer name
        System.out.print("Enter Account Name:");
        String custName=sc.nextLine();
        //get input for customer id
        System.out.print("Enter Customer ID:");
        String cusID=sc.nextLine();
        //create object for account class
        Account account=new Account(custName,cusID);
        //print statements to print on the console
        System.out.println("-----------------------------------");
        System.out.println("Welcome," + account.customerName + "!");
        System.out.println("Your ID is:" + account.customerID);
        System.out.println("-----------------------------------");
        System.out.println("Select Any Option to Proceed");
        System.out.println();
        System.out.println("A.Check Balance");
        System.out.println("B.Deposit");
        System.out.println("C.Withdraw");
        System.out.println("D.Previous Transaction");
        System.out.println("E.Interest");
        System.out.println("F.Exit");
        //declare a char variable to select option
        char option;
        //set flag = true
        boolean flag=true;
        //while loop continues until the flag becomes false
        while (flag){
            //get input choice
            System.out.print("Enter your choice:");
            option=sc.next().charAt(0);

            switch (option){
                case 'A':
                    //returns amount balance
                    System.out.println("Account Balance = $" + account.balance);
                    break;
                case 'B':
                    //get input for amount to deposit
                    System.out.println("Enter an amount to deposit:");
                    int deposit=sc.nextInt();
                    //call deposit() method from the Account class
                    account.deposit(deposit);
                    break;
                case 'C':
                    //get input for amount to withdraw
                    System.out.println("Enter an amount to withdrawn:");
                    int withdrawn=sc.nextInt();
                    //call the withdraw() method from Account class
                    account.withdraw(withdrawn);
                    break;
                case 'D':
                    //call getPreviousTransaction() method from Account class
                    account.getPreviousTransaction();
                    break;
                case 'E':
                    //get input for years to calculate interest
                    System.out.println("Enter the years for which you wish to calculate the interest:");
                    int years=sc.nextInt();
                    //call the calculateInterest() method from the Account class
                    account.calculateInterest(years);
                    break;
                case 'F':
                    System.out.println("Thankyou for banking with us!");
                    //flag becomes false so while loop exits
                    flag=false;
                    break;
                default:
                    System.out.println("Error:Invalid option.Please enter valid option.");
            }
        }
    }
}



//account class creation
class Account{
    String customerName;
    String customerID;
    int balance=0;
    int previousTransaction=0;

    Account(String customerName, String customerID){
        this.customerName=customerName;
        this.customerID=customerID;
    }
    void deposit(int amount){
        if (amount>0){ //checks input amount is greater than 0
            balance +=amount;//updating new balance
            previousTransaction=amount;//marking this for previous transactions
            System.out.println("Amount Deposited Successfully.");
            System.out.println("New Balance:" + balance);
        }else {
            System.out.println("Please enter amount greater than 0");
        }
    }
    void withdraw(int amount){
        if (amount<balance){ //check input amount is lesser than balance
            if (amount>0){ //check input amount is greater than 0
                balance -=amount;
                previousTransaction = -amount;
                System.out.println("Withdrawal Successful");
                System.out.println("New Balance:");
            }else {
                System.out.println("Please enter amount greater than 0");
            }
        }else {
            System.out.println("Insufficient Funds, Cannot Withdraw");
        }
    }

    void getPreviousTransaction(){
        if (previousTransaction>0){ //check previousTransaction is greater than 0
            System.out.println("Deposited:" + previousTransaction);
        } else if (previousTransaction<0) { //check previousTransaction is lesser than 0
            System.out.println("Withdrawn:" + previousTransaction);
        }else{
            System.out.println("No transaction done");
        }
    }
    void calculateInterest(int years){
        double interestRate=.0185;
        double newBalance=(balance*interestRate*years)+balance;
        System.out.println("The current interest rate is" + (100*interestRate) + "%");
        System.out.println("After" + years + " years,your balance will be:" + newBalance);
    }
}
