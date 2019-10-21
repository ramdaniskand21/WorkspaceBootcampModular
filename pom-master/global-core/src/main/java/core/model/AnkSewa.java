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
@Table(name="ANK_SEWA")
@IdClass(AnkSewaPK.class)
@NamedQuery(name="AnkSewa.findAll", query="SELECT m FROM AnkSewa m")
public class AnkSewa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String companyCode;
	private String sewaId;
	private String supirId;
	private String mobilId;
	
	private String sewaAlamat;
	private String sewaNama;
//	private String merk;
//	private String platPolisi;
//	private String supirNama;
	
	private Date tglSewa;
	private Date tglAkhir;
	
	private long harga;
	
	private String createdBy;
	private String updateBy;
	
	private Date createdDate;
	private Date updataDate;
	
	
//	@Id
	@Column(name="SUPIR_ID")
	public String getSupirId() {
		return supirId;
	}
	public void setSupirId(String supirId) {
		this.supirId = supirId;
	}
	
//	@Column(name="SUPIR_NAMA")
//	public String getSupirNama() {
//		return supirNama;
//	}
//	public void setSupirNama(String supirNama) {
//		this.supirNama = supirNama;
//	}
	
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
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}
	

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name="HARGA")
	public long getHarga() {
		return harga;
	}
	public void setHarga(long harga) {
		this.harga = harga;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="UPDATE_DATE")
	public Date getUpdataDate() {
		return updataDate;
	}
	public void setUpdataDate(Date updataDate) {
		this.updataDate = updataDate;
	}
	
	
//	@Column(name="MERK")
//	public String getMerk() {
//		return merk;
//	}
//	public void setMerk(String merk) {
//		this.merk = merk;
//	}
//	
//	@Column(name="PLAT_ID")
//	public String getPlatPolisi() {
//		return platPolisi;
//	}
//	public void setPlatPolisi(String platPolisi) {
//		this.platPolisi = platPolisi;
//	}
	@Id
	@Column(name="SEWA_ID")
	public String getSewaId() {
		return sewaId;
	}
	public void setSewaId(String sewaId) {
		this.sewaId = sewaId;
	}
	
	@Column(name="SEWA_ALAMAT")
	public String getSewaAlamat() {
		return sewaAlamat;
	}
	public void setSewaAlamat(String sewaAlamat) {
		this.sewaAlamat = sewaAlamat;
	}
	
	@Column(name="SEWA_NAMA")
	public String getSewaNama() {
		return sewaNama;
	}
	public void setSewaNama(String sewaNama) {
		this.sewaNama = sewaNama;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="TGL_SEWA")
	public Date getTglSewa() {
		return tglSewa;
	}
	public void setTglSewa(Date tglSewa) {
		this.tglSewa = tglSewa;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="TGL_AKHIR")
	public Date getTglAkhir() {
		return tglAkhir;
	}
	public void setTglAkhir(Date tglAkhir) {
		this.tglAkhir = tglAkhir;
	}
	
	@Id
	@Column(name="MOBIL_ID")
	public String getMobilId() {
		return mobilId;
	}
	public void setMobilId(String mobilId) {
		this.mobilId = mobilId;
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
