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
@Table(name="ANK_SUPIR")
@IdClass(AnkSupirPK.class)
@NamedQuery(name="AnkSupir.findAll", query="SELECT m FROM AnkSupir m")
public class AnkSupir implements Serializable{
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
	
	
	@Id
	@Column(name="SUPIR_ID")
	public String getSupirId() {
		return supirId;
	}
	public void setSupirId(String supirId) {
		this.supirId = supirId;
	}
	
	@Column(name="SUPIR_NAMA")
	public String getSupirNama() {
		return supirNama;
	}
	public void setSupirNama(String supirNama) {
		this.supirNama = supirNama;
	}
	
	@Column(name="SUPIR_ALAMAT")
	public String getSupirAlamat() {
		return supirAlamat;
	}
	public void setSupirAlamat(String supirAlamat) {
		this.supirAlamat = supirAlamat;
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
	
	@Column(name="SUPIR_HARGA")
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
	public Date getUpdataDate() {
		return updataDate;
	}
	public void setUpdataDate(Date updataDate) {
		this.updataDate = updataDate;
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
