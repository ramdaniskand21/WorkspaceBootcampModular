package share;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class AnkSewaDto implements Serializable {
	
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
	
	private String namaSupir;

	
	public AnkSewaDto(){
		
	}
	
	
	public String getSupirId() {
		return supirId;
	}
	public void setSupirId(String supirId) {
		this.supirId = supirId;
	}
	
	
//	public String getSupirNama() {
//		return supirNama;
//	}
//	public void setSupirNama(String supirNama) {
//		this.supirNama = supirNama;
//	}
	
	
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
	
	
	
	
	public long getHarga() {
		return harga;
	}


	public void setHarga(long harga) {
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
	
	
	
//	public String getMerk() {
//		return merk;
//	}
//	public void setMerk(String merk) {
//		this.merk = merk;
//	}
//	
//	
//	public String getPlatPolisi() {
//		return platPolisi;
//	}
//	public void setPlatPolisi(String platPolisi) {
//		this.platPolisi = platPolisi;
//	}
	
	
	public String getSewaId() {
		return sewaId;
	}
	public void setSewaId(String sewaId) {
		this.sewaId = sewaId;
	}
	
	
	public String getSewaAlamat() {
		return sewaAlamat;
	}
	public void setSewaAlamat(String sewaAlamat) {
		this.sewaAlamat = sewaAlamat;
	}
	
	
	public String getSewaNama() {
		return sewaNama;
	}
	public void setSewaNama(String sewaNama) {
		this.sewaNama = sewaNama;
	}
	
	
	public Date getTglSewa() {
		return tglSewa;
	}
	public void setTglSewa(Date tglSewa) {
		this.tglSewa = tglSewa;
	}
	
	
	public Date getTglAkhir() {
		return tglAkhir;
	}
	public void setTglAkhir(Date tglAkhir) {
		this.tglAkhir = tglAkhir;
	}
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

	@Column(name="SUPIR_NAMA")
	public String getNamaSupir() {
		return namaSupir;
	}


	public void setNamaSupir(String namaSupir) {
		this.namaSupir = namaSupir;
	}
	
}
