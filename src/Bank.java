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

	public static boolean transfer(int amount, Player giver, Player recipient) {
		boolean canPayFullAmount = withdraw(amount, giver);
		if (!canPayFullAmount) {
			amount = giver.getBalance();
			withdraw(amount, giver);
		}
		deposit(amount, recipient);
		return canPayFullAmount;
	}

}
