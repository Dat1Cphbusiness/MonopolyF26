public class Bank {
	private static int balance = 1000000;

	public static boolean withdraw(int amount, Player p) {
		if (amount > p.getBalance()) {
			return false;
		} else {
			p.setBalance(p.getBalance() - amount);
			balance += amount;
			return true;
		}
	}

	public static void deposit(int amount, Player p) {
		p.setBalance(p.getBalance() + amount);
		balance -= amount;
		//OBS: Banken kan ikke løbe tør for penge
	}
}
