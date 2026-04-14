import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankTest {

	@Test
	void withdraw_reducesPlayerBalance_whenSufficientFunds() {
		Player p = new Player("A", 500);
		boolean ok = Bank.withdraw(200, p);
		assertTrue(ok);
		assertEquals(300, p.getBalance());
	}

	@Test
	void withdraw_returnsFalse_andLeavesBalanceUnchanged_whenInsufficientFunds() {
		Player p = new Player("B", 100);
		boolean ok = Bank.withdraw(150, p);
		assertFalse(ok);
		assertEquals(100, p.getBalance());
	}

	@Test
	void deposit_increasesPlayerBalance() {
		Player p = new Player("C", 50);
		Bank.deposit(25, p);
		assertEquals(75, p.getBalance());
	}

	@Test
	void transfer_movesFullAmount_whenSenderCanPay() {
		Player giver = new Player("G", 1000);
		Player modtager = new Player("M", 100);
		boolean fullAmount = Bank.transfer(400, giver, modtager);
		assertTrue(fullAmount);
		assertEquals(600, giver.getBalance());
		assertEquals(500, modtager.getBalance());
	}

	@Test
	void transfer_sendsOnlySendersBalance_whenNotEnoughMoney() {
		Player giver = new Player("G", 150);
		Player modtager = new Player("M", 0);
		boolean fullAmount = Bank.transfer(500, giver, modtager);
		assertFalse(fullAmount);
		assertEquals(0, giver.getBalance());
		assertEquals(150, modtager.getBalance());
	}
}
