public class Bank {
    private static int balance = 1000000;


    static void deposit(int amount, Player p){
        p.setBalance(p.getBalance()+amount);
        balance-=amount;

    }

    static boolean withdraw(int amount, Player p){
        if (p.getBalance()>=amount) {
            p.setBalance(p.getBalance() - amount);
            balance+=amount;

            System.out.println("Transfer success");
            return true;
        } else {
            System.out.println("Transfer failed");
            return false;
        }
    }
    static boolean transfer(int amount, Player giver, Player recipient) {
        if (giver.getBalance() >= amount) {
            giver.setBalance(giver.getBalance() - amount);
            recipient.setBalance(recipient.getBalance() + amount);

            System.out.println("Transfer success");
            return true;
        } else {
            System.out.println("Transfer failed");
            return false;
        }
    }

        static int getBalance(){
        return balance;
    }
}
