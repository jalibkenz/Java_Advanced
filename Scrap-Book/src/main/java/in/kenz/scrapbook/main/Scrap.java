package in.kenz.scrapbook.main;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Scrap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private int scrapId;
	private long mobile;
    private String scrapMsg;

    // getters and setters


    public String getScrapMsg() {
    	return scrapMsg;
    }
    
    public int getScrapId() {
		return scrapId;
	}

	public void setScrapId(int scrapId) {
		this.scrapId = scrapId;
	}

	public void setScrapMsg(String scrapMsg) {
    	this.scrapMsg = scrapMsg;
    }

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
    
}
