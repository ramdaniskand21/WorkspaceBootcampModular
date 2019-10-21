package core.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="ANK_MOBIL")
@IdClass(AnkMobilPK.class)
@NamedQuery(name="AnkMobil.findAll", query="SELECT m FROM AnkMobil m")
public class AnkMobil implements Serializable {

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
	
	@Id
	@Column(name="MOBIL_ID")
	public String getMobilId() {
		return mobilId;
	}
	public void setMobilId(String mobilId) {
		this.mobilId = mobilId;
	}
	
	@Column(name="MERK")
	public String getMerk() {
		return merk;
	}
	public void setMerk(String merk) {
		this.merk = merk;
	}
	
	@Column(name="PLAT_NO")
	public String getPlatPolisi() {
		return platPolisi;
	}
	public void setPlatPolisi(String platPolisi) {
		this.platPolisi = platPolisi;
	}
	
	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="UPDATE_BY")
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	@Column(name="HARGA")
	public int getHarga() {
		return harga;
	}
	public void setHarga(int harga) {
		this.harga = harga;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="UPDATE_DATE")
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@Id
	@Column(name="COMPANY_CODE")
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
}
