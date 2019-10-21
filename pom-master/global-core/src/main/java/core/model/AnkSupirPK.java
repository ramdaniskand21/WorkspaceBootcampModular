package core.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

//@Embeddable
public class AnkSupirPK implements Serializable{

	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String supirId;
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getSupirId() {
		return supirId;
	}
	public void setSupirId(String supirId) {
		this.supirId = supirId;
	}
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AnkSupirPK)) {
			return false;
		}
		AnkSupirPK castOther = (AnkSupirPK)other;
		return 
			this.companyCode.equals(castOther.companyCode)
			&& this.supirId.equals(castOther.supirId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyCode.hashCode();
		hash = hash * prime + this.supirId.hashCode();
		
		return hash;
	}
}