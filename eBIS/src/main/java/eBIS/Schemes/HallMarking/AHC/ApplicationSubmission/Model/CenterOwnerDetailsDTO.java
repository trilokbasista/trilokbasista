package eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Model;
import java.util.Date;
public class CenterOwnerDetailsDTO {

	private String name;
	private String designation;
	private long centerOwnerDetailsId;
	private long createdBy;
	private Date createDate;
	private long updatedBy;
	private Date updatedDate;
	private String ipAddress;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public long getCenterOwnerDetailsId() {
		return centerOwnerDetailsId;
	}
	public void setCenterOwnerDetailsId(long centerOwnerDetailsId) {
		this.centerOwnerDetailsId = centerOwnerDetailsId;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}


}
