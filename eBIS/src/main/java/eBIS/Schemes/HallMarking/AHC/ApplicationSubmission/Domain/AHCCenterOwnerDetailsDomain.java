package eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="hall_center_owner_details", schema = "bis_hall")
public class AHCCenterOwnerDetailsDomain {
	
	private long hallCenterOwnerDetailsId;
	private long applicationIdFk;
	private String centerOwnerName;
	private String ownerDesignation;
	private boolean status;
	private long createdBy;
	private Date createDate;
	private long updatedBy;
	private Date updateDate;
	private String ipAddress;
	

	@Id
	@GenericGenerator(name = "centerHallOwnerDetailSequence",strategy = "sequence",parameters = @Parameter(value = "hall_center_owner_details_id_seq", name = "centerHallOwnerDetailSequence"))
	@GeneratedValue(generator = "centerHallOwnerDetailSequence")
	@Column(name = "hall_center_owner_details_id")
	public long getHallCenterOwnerDetailsId() {
		return hallCenterOwnerDetailsId;
	}
	public void setHallCenterOwnerDetailsId(long hallCenterOwnerDetailsId) {
		this.hallCenterOwnerDetailsId = hallCenterOwnerDetailsId;
	}
	
	@Column(name="application_id_fk")
	public long getApplicationIdFk() {
		return applicationIdFk;
	}
	public void setApplicationIdFk(long applicationIdFk) {
		this.applicationIdFk = applicationIdFk;
	}
	
	@Column(name="center_owner_name")
	public String getCenterOwnerName() {
		return centerOwnerName;
	}
	public void setCenterOwnerName(String centerOwnerName) {
		this.centerOwnerName = centerOwnerName;
	}
	
	@Column(name="owner_designation")
	public String getOwnerDesignation() {
		return ownerDesignation;
	}
	public void setOwnerDesignation(String ownerDesignation) {
		this.ownerDesignation = ownerDesignation;
	}
	
	@Column(name="status")
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Column(name="created_by")
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Column(name="updated_by")
	public long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@Column(name="ip_address")
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
}

