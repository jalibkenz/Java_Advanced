package unidirection;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccounts {
	@Id
	private int bankAccount;
	private String bankName;
	private String bankAddress;

	public int getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(int bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	
	

}
