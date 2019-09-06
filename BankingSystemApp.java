import java.io.*;
import java.math.*;

class BankingSystemApp
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("#####################################");
        System.out.println();
        System.out.println("WELCOME TO  JAVA DEVELOPER CO-OPERATIVE  BANK ");
        System.out.println();
        System.out.println("#####################################");
        System.out.println();
        Banking ob = new Banking();
        ob.showMenu();
    }
}

class Banking
{
    private String Customer_name;
    private double amount;
    private double balance;
    private int Account_number = 110091109;
    private double prevBalance;
    private int retry;
    Console c = System.console();

    void CreateAccount() 
    {
        int choice = 0;
        System.out.println();
        System.out.println("*********************************************************************");
        

        choice = Integer.parseInt(c.readLine(">>>>Enter 1 to create an account: \n>>>>Enter anykey to exit:  "));
        if (choice == 1)
        {
            do
            {
                Customer_name = c.readLine((">>>>Enter your name: "));
                for (int i = 0; i < Customer_name.length(); i++)
                {
                    if (Character.isLetter(Customer_name.charAt(i)) || Customer_name.charAt(i) == ' ')
                        retry = 0;
                    else
                    {
                        System.out.println("***************WARNING!!***********");
                        System.out.println("Name should contain only letters ");
                        retry = 1;
                        break;
                    }
                }
            }while (retry == 1);

        }
        else
        {
            System.exit(0);
        }

        do
        {
            try
            {
                System.out.println();
                balance = Double.parseDouble(c.readLine(">>>>Please deposit initial balance >= 5000 \n "));
                retry = 0;
                if (balance >= 5000)
                {
                    System.out.println();
                    System.out.println();
                    System.out.println("***********ACCOUNT  CREATED  SUCCESSFULLY**********");
                    System.out.println("COSTUMER NAME:  "+ Customer_name);
                    System.out.println("ACCOUNT NUMBER: " + Account_number);
                    System.out.println("****THANK YOU FOR CHOOSING JAVA DEVELOPERS CO-OPERATIVE BANK**** ");
                    System.out.println();
                    System.out.println();

                }
                else if (balance < 5000) {
                    System.out.println();
                    System.out.println("***************WARNING!!***********");
                    System.out.println("Initial Balance cannot be less than 5000");
                    System.out.println();
                    retry = 1;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("***************WARNING!!***********");
                System.out.println("   Please enter amount in digits!");
                retry = 1;
            }
        } while (retry == 1);
    }

    void deposit()
    {

        do
        {
            try
            {
                System.out.println();
                System.out.println("**************************************");
                System.out.println(">>>>Enter 0 to terminate Transaction");
                amount = Double.parseDouble(c.readLine(">>>>Enter Amount to Deposit:\n "));
                if(amount>0)
                {
                    balance +=amount;
                    System.out.println("Amount deposited successfully");
                    prevBalance = amount;
                    retry = 0;
                }
                else if(amount == 0)
                {
                    System.out.println("*****Transaction Terminated!*****");
                    retry = 0;
                }
                else if(amount < 0)
                {
                    System.out.println("amount cannot be negative");
                    retry = 1;
                }
            }
            catch(NumberFormatException e)
                {
                    System.out.println("***************WARNING!!***********");
                    System.out.println("    ENTER AMOUNT ONLY IN DIGITS!\n\n");
                    retry  = 1;
                }
        }while(retry==1);
    }

    void withdraw()
    {
        do
        {
            try
            {
                System.out.println("**************************************");
                System.out.println(">>>>Enter 0 to terminate Transaction");
                amount = Double.parseDouble(c.readLine(">>>>Enter Amount to Withdraw: \n"));
                retry = 0;
                if(amount <= balance && amount > 0 )
                {
                    balance -=amount;
                    System.out.println("Amount withdrawn successfully");
                    prevBalance = -amount;
                    retry = 0;
                }
                else if(amount > balance)
                {
                    System.out.println("Insufficient Funds, your account has "+balance+" Rupees");
                    retry = 1;
                }
                else if(amount == 0)
                {
                    System.out.println("*****Transaction Terminated!*****  ");
                    retry = 0;
                }
                else if(amount<0)
                {
                    System.out.println("Amount cannot be negative");
                    retry = 1;
                }
            }
            catch(NumberFormatException e)
            {
                System.out.println("***************WARNING!!***********");
                System.out.println("    ENTER AMOUNT ONLY IN DIGITS!\n\n");
                    retry  = 1;
            }
        }while(retry==1);



        
    }

    void PreviousTransaction(double prevBalance)
    {
        if (prevBalance > 0)
        {
            System.out.println("Last balance deposted was  " + prevBalance);
        } else
        {
            System.out.println("Last balance withdrawn was  " + Math.abs(prevBalance));
        }
    }

    void showBalance(double balance)
    {
        System.out.println("Updated balance is: " + balance);
    }

    void showAccountInfo(int Account_number, String Customer_name, double balance)
    {
        System.out.println("COSTUMER  NAME: " + Customer_name);
        System.out.println("ACCOUNT NUMBER: " + Account_number);
        System.out.println("UPDATED BALANCE: " + balance);
    }

    void showMenu()
    {
        CreateAccount();
        int op = 0;
        do
        {
            System.out.println();
            System.out.println("**************************************");
            System.out.println("SELECTED OPERATION TO BE PERFORMED ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Previous Transaction");
            System.out.println("4. Show Balance");
            System.out.println("5. Show Account Information");
            System.out.println("6. Exit");
            System.out.println("**************************************");
            System.out.println();
            do
            {
                try
                    {
                    op = Integer.parseInt(c.readLine());
                    retry = 0;
                    }
                    catch(NumberFormatException e)
                    {
                        System.out.println("Please select valid option: ");
                        retry = 1;
                    }
            }while(retry == 1);
           
            switch (op)
            {              
                case 1:
                    System.out.println();
                    System.out.println("************************************************");
                    deposit();
                    System.out.println("************************************************");
                    break;

                case 2:
                    System.out.println();
                    System.out.println("**************************************************");
                    withdraw();
                    System.out.println("**************************************************");
                    break;

                case 3:
                    PreviousTransaction(prevBalance);
                    break;

                case 4:
                    System.out.println();
                    System.out.println("***************************************************");
                    showBalance(balance);
                    System.out.println("***************************************************");
                    break;

                case 5:
                    System.out.println();
                    System.out.println("*****************************************************");
                    showAccountInfo(Account_number, Customer_name, balance);
                    System.out.println("*****************************************************");
                    break;

                case 6:
                    System.out.println();
                    System.out.println("*****************************************************************");
                    System.out.println("*****************THANK YOU FOR USING OUR SERVICES***************");
                    System.out.println("*****************************************************************");
                    break;

                default:
                    System.out.println("Please select valid option: ");
              }
        } while (op != 6);
    }
}