package share;

import java.io.Serializable;
import java.util.Date;

public class AnkSupirDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String companyCode;
	private String supirId;
	private String supirNama;
	private String supirAlamat;
	private String createdBy;
	private String updateBy;
	
	private int harga;
	private Date createdDate;
	private Date updataDate;
	
	public AnkSupirDto(){
	}
	public String getSupirId() {
		return supirId;
	}
	public void setSupirId(String supirId) {
		this.supirId = supirId;
	}
	
	
	public String getSupirNama() {
		return supirNama;
	}
	public void setSupirNama(String supirNama) {
		this.supirNama = supirNama;
	}
	
	
	public String getSupirAlamat() {
		return supirAlamat;
	}
	public void setSupirAlamat(String supirAlamat) {
		this.supirAlamat = supirAlamat;
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
	
	
	public Date getUpdataDate() {
		return updataDate;
	}
	public void setUpdataDate(Date updataDate) {
		this.updataDate = updataDate;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
}
