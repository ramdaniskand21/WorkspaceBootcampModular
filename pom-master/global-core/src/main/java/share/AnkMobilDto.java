package share;

import java.io.Serializable;
import java.util.Date;


public class AnkMobilDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String mobilId;
	private String merk;
	private String platPolisi;
	private String createdBy;
	private String updateBy;
	
	private int harga;
	private Date createdDate;
	private Date updateDate;
	
	
	public AnkMobilDto(){
		
	}
	
	public String getMobilId() {
		return mobilId;
	}
	public void setMobilId(String mobilId) {
		this.mobilId = mobilId;
	}
	

	public String getMerk() {
		return merk;
	}
	public void setMerk(String merk) {
		this.merk = merk;
	}
	

	public String getPlatPolisi() {
		return platPolisi;
	}
	public void setPlatPolisi(String platPolisi) {
		this.platPolisi = platPolisi;
	}
	

	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	

	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	

	public int getHarga() {
		return harga;
	}
	public void setHarga(int harga) {
		this.harga = harga;
	}
	

	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	

	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
}
