public class Bank {
	private int balance = 1000000;

	public boolean withdraw(int amount, Player p) {
		if (amount > p.getBalance()) {
			return false;
		} else {
			p.setBalance(p.getBalance() - amount);
			this.balance += amount;
			return true;
		}
	}

	public void deposit(int amount, Player p) {
		p.setBalance(p.getBalance() + amount);
		this.balance -= amount;
	}

}
