package eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="ahcrecogappsubdepttdtlsdomain",schema="bis_hall")
public class AHCAppSubDepttDtlsDomain implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2037711149399495971L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ahcrecogappsubdepttdtlsdomain")
	@TableGenerator(initialValue=1, allocationSize=1, name="ahcrecogappsubdepttdtlsdomain")
	@Column(name="numid")
	int numId;
			
	@Column(name="strappid",length=12)
	String strAppId;
	
	@Column(name="numregionid",length=2)
	int numRegionId=0;
		
	@Column(name="strdepartment",length=50)
	String strDepartment;
	
	@Column(name="strdeptname", length=50)
	String strDeptName;
	
	@Column(name="strdeptdesig", length=50)
	String strDeptDesig;
	
	@Column(name="strdeptquali", length=50)
	String strDeptQuali;
	
	@Column(name="strdeptexper", length=100)
	String strDeptExper;
	
	@Column(name="strdepttraining",length=100)
	String strDeptTraining;
	
	@Column(name="strdeptdeputyname",length=50)
	String strDeptDeputyName;

	public int getNumId() {
		return numId;
	}

	public void setNumId(int numId) {
		this.numId = numId;
	}

	public String getStrAppId() {
		return strAppId;
	}

	public void setStrAppId(String strAppId) {
		this.strAppId = strAppId;
	}

	public int getNumRegionId() {
		return numRegionId;
	}

	public void setNumRegionId(int numRegionId) {
		this.numRegionId = numRegionId;
	}

	public String getStrDepartment() {
		return strDepartment;
	}

	public void setStrDepartment(String strDepartment) {
		this.strDepartment = strDepartment;
	}

	public String getStrDeptName() {
		return strDeptName;
	}

	public void setStrDeptName(String strDeptName) {
		this.strDeptName = strDeptName;
	}

	public String getStrDeptDesig() {
		return strDeptDesig;
	}

	public void setStrDeptDesig(String strDeptDesig) {
		this.strDeptDesig = strDeptDesig;
	}

	public String getStrDeptQuali() {
		return strDeptQuali;
	}

	public void setStrDeptQuali(String strDeptQuali) {
		this.strDeptQuali = strDeptQuali;
	}

	public String getStrDeptExper() {
		return strDeptExper;
	}

	public void setStrDeptExper(String strDeptExper) {
		this.strDeptExper = strDeptExper;
	}

	public String getStrDeptTraining() {
		return strDeptTraining;
	}

	public void setStrDeptTraining(String strDeptTraining) {
		this.strDeptTraining = strDeptTraining;
	}

	public String getStrDeptDeputyName() {
		return strDeptDeputyName;
	}

	public void setStrDeptDeputyName(String strDeptDeputyName) {
		this.strDeptDeputyName = strDeptDeputyName;
	}
	
	
			
	
}
