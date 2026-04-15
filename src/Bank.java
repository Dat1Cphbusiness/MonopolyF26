public class Bank {
	private static int balance = 1000000;

	//FROM PLAYER'S ACCOUNT
	public static boolean withdraw(int amount, Player p) {
		if (amount > p.getBalance()) {
			return false;
		} else {
			p.setBalance(p.getBalance() - amount);
			balance += amount;
			return true;
		}
	}

	//TO PLAYER'S ACCOUNT
	public static void deposit(int amount, Player p) {
		p.setBalance(p.getBalance() + amount);
		balance -= amount;
		//OBS: Banken kan ikke løbe tør for penge
	}

	static boolean transfer(int amount, Player giver, Player recipient) {
		if (withdraw(amount,giver)) {
			deposit(amount,recipient);

			System.out.println("Transfer success");
			return true;
		} else {
			System.out.println("Transfer failed");
			return false;
		}
	}



}
