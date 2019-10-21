package core.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

//@Embeddable
public class AnkSewaPK implements Serializable{
	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String sewaId;
	
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getSewaId() {
		return sewaId;
	}
	public void setSewaId(String sewaId) {
		this.sewaId = sewaId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AnkSewaPK)) {
			return false;
		}
		AnkSewaPK castOther = (AnkSewaPK)other;
		return 
			this.companyCode.equals(castOther.companyCode)
			&& this.sewaId.equals(castOther.sewaId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.companyCode.hashCode();
		hash = hash * prime + this.sewaId.hashCode();
		
		return hash;
	}
}
