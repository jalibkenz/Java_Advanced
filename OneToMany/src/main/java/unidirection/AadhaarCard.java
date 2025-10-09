package unidirection;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class AadhaarCard {
	
	@Id
	private long aadhaarNumber;
	private String aadhaarName;
	private long aadhaarPhone;
	
	@OneToMany
	List<BankAccounts> lba;

	public long getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(int aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public String getAadhaarName() {
		return aadhaarName;
	}

	public void setAadhaarName(String aadhaarName) {
		this.aadhaarName = aadhaarName;
	}

	public long getAadhaarPhone() {
		return aadhaarPhone;
	}

	public void setAadhaarPhone(long aadhaarPhone) {
		this.aadhaarPhone = aadhaarPhone;
	}

	public List<BankAccounts> getLba() {
		return lba;
	}

	public void setLba(List<BankAccounts> lba) {
		this.lba = lba;
	}

	

}
