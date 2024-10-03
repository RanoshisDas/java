import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM {
    //variable declaration
    private  int pin;
    private int balance;
    //parameterize constructor
    public ATM(int balance,int pin){
        this.balance = balance;
        this.pin = pin;
    }
    //list of operations
    public void display(){
        System.out.println("\nWelcome to ATM!");
        System.out.println("1.Display Balance");
        System.out.println("2.Deposit Balance");
        System.out.println("3.Withdrawal Balance");
        System.out.println("4.Change PIN");
        System.out.println("5.Exit/Cancel Transaction");
    }
    //get balance if pin is correct
    public void getBalance(int pin){
        if(validatePin(pin)){
            System.out.println("Your balance is "+ balance);
        }
        else {
            System.out.println("Your PIN is not valid");
        }
    }
    //validating the pin that user entered
    public boolean validatePin(int pin){
        return this.pin == pin;
    }
    //add money to account with pin validation
    public void deposit(int amount, int pin){
        if(validatePin(pin)){
            this.balance += amount;
        }
        else {
            System.out.println("Your PIN is not valid");
        }
    }
    //subtract withdrawal amount from balance if pin is valid
    public void withdraw(int amount,int pin){
        if(validatePin(pin)){
            if(this.balance >= amount){
                this.balance -= amount;
                System.out.println("Withdraw Successfully");
            }
            else {
                System.out.println("You don't have enough money");
            }
        }
        else {
            System.out.println("Your PIN is not valid");
        }
    }
    //change the  existing pin
    public void changePin(int oldPin,int pin){
        if(validatePin(oldPin)){
            this.pin = pin;
        }
        else {
            System.out.println("Your PIN is not valid");
        }
    }

    //main driver
    public static void main(String[] args){
        ATM atm = new ATM(10000,1245);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int pin;
        int operation=0;

        while(operation!=5){
            atm.display();
            System.out.print("Enter your operation: ");
            try {
                operation = Integer.parseInt(in.readLine());
            }
            catch (IOException e) {
                System.out.println("Enter a valid choice");
            }
            switch(operation){
                //check balance
                case 1:
                    System.out.print("Enter your pin: ");
                    try {
                        pin=Integer.parseInt(in.readLine());
                        System.out.println();
                        atm.getBalance(pin);
                    }
                    catch (IOException e) {
                        System.out.println("Enter a valid pin");
                    }
                    break;
                //Deposit money to account
                case 2:
                    System.out.print("Enter your deposit amount: ");
                    try {
                        int deposit= Integer.parseInt(in.readLine());
                        System.out.print("Enter your pin: ");
                        pin=Integer.parseInt(in.readLine());
                        System.out.println();
                        atm.deposit(deposit,pin);
                    }
                    catch (IOException e) {
                        System.out.println("Enter a valid pin");
                    }
                    break;
                //Withdrawal money from account
                case 3:
                    System.out.print("Enter your withdrawal amount: ");
                    try {
                        int withdraw= Integer.parseInt(in.readLine());
                        System.out.print("Enter your pin: ");
                        pin= Integer.parseInt(in.readLine());
                        System.out.println();
                        atm.withdraw(withdraw,pin);
                    }
                    catch (IOException e) {
                        System.out.println("Enter a valid pin");
                    }
                    break;
                //Change pin
                case 4:
                    System.out.print("Enter your new pin: ");
                    try {
                        int change= Integer.parseInt(in.readLine());
                        System.out.print("Enter your old pin: ");
                        pin=Integer.parseInt(in.readLine());
                        System.out.println();
                        atm.changePin(pin,change);
                    }
                    catch (IOException e) {
                        System.out.println("Enter a valid pin");
                    }
                    break;
                //Close/Exit
                case 5:
                    System.out.println("Thank you for using ATM!");
                    break;
                //in valid operation handle
                default:
                    System.out.println("Invalid operation");
                    break;

            }

        }
    }
}
