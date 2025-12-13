import java.util.Scanner;
class Account {
    String customerName;
    int accountNumber;
    String accountType;
    double balance;

    Account(String name, int accNo, String type, double bal) {
        customerName = name;
        accountNumber = accNo;
        accountType = type;
        balance = bal;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited: " + amount);
        displayBalance();
    }

    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
        displayBalance();
    }
}
class Sav_acct extends Account {
    double interestRate = 5.0; // 5% interest per year

    Sav_acct(String name, int accNo, double bal) {
        super(name, accNo, "Savings", bal);
    }

    void computeAndDepositInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest deposited: " + interest);
        displayBalance();
    }
}
class Cur_acct extends Account {
    double minBalance = 1000;
    double serviceCharge = 100;

    Cur_acct(String name, int accNo, double bal) {
        super(name, accNo, "Current", bal);
    }
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient balance!");
        }
        displayBalance();
    }

    void checkMinimumBalance() {
        if (balance < minBalance) {
            balance -= serviceCharge;
            System.out.println("Balance below minimum. Service charge imposed: " + serviceCharge);
        }
    }
}
public class lab3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter customer name:");
        String name = sc.nextLine();
        System.out.println("Enter account number:");
        int accNo = sc.nextInt();
        System.out.println("Enter initial balance:");
        double balance = sc.nextDouble();

        System.out.println("Choose account type: 1. Savings 2. Current");
        int choice = sc.nextInt();

        if (choice == 1) {
            Sav_acct s = new Sav_acct(name, accNo, balance);
            s.displayBalance();
            s.deposit(1000);
            s.computeAndDepositInterest();
            s.withdraw(500);
            s.displayBalance();
        } else {
            Cur_acct c = new Cur_acct(name, accNo, balance);
            c.displayBalance();
            c.deposit(2000);
            c.withdraw(1500);
            c.checkMinimumBalance();
            c.displayBalance();
        }
    }
}
