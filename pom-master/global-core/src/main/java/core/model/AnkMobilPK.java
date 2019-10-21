package core.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

//@Embeddable
public class AnkMobilPK implements Serializable{

	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String mobilId;
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getMobilId() {
		return mobilId;
	}
	public void setMobilId(String mobilId) {
		this.mobilId = mobilId;
	}
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AnkMobilPK)) {
			return false;
		}
		AnkMobilPK castOther = (AnkMobilPK)other;
		return 
			this.companyCode.equals(castOther.companyCode)
			&& this.mobilId.equals(castOther.mobilId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyCode.hashCode();
		hash = hash * prime + this.mobilId.hashCode();
		
		return hash;
	}
}
