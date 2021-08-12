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
@Table(name="ahcrecogappsubtestequipdomain",schema="bis_hall")
public class AHCAppSubTestEquipDomain implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2037711149399495971L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ahcrecogappsubtestequipdomain")
	@TableGenerator(initialValue=1, allocationSize=1, name="ahcrecogappsubtestequipdomain")
	@Column(name="numid")
	int numId;
			
	@Column(name="strappid",length=12)
	String strAppId;
	
	@Column(name="numregionid",length=2)
	int numRegionId=0;
		
	@Column(name="strisno",length=10)
	String strIsNo;
	
	@Column(name="strmethodtest", length=50)
	String strMethodTest;
	
	@Column(name="strtestfacility", length=50)
	String strTestFacility;
	
	@Column(name="strmodeltype", length=50)
	String strModelType;
	
	@Column(name="strrange", length=100)
	String strRange;
	
	@Column(name="strleastcount",length=100)
	String strLeastCount;
	
	@Column(name="strvalidity",length=50)
	String strValidity;
	
	@Column(name="strtraceability", length=100)
	String strTraceability;
	
	@Column(name="strremarksany",length=100)
	String strRemarksAny;
	
	@Column(name="strCalibratName", length=60)
	String strCalibratName;
	
	@Column(name="strCalibratValidity", length=60)
	String strCalibratValidity;
	
	
	public String getStrCalibratName() {
		return strCalibratName;
	}

	public void setStrCalibratName(String strCalibratName) {
		this.strCalibratName = strCalibratName;
	}

	public String getStrCalibratValidity() {
		return strCalibratValidity;
	}

	public void setStrCalibratValidity(String strCalibratValidity) {
		this.strCalibratValidity = strCalibratValidity;
	}

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

	public String getStrIsNo() {
		return strIsNo;
	}

	public void setStrIsNo(String strIsNo) {
		this.strIsNo = strIsNo;
	}

	public String getStrMethodTest() {
		return strMethodTest;
	}

	public void setStrMethodTest(String strMethodTest) {
		this.strMethodTest = strMethodTest;
	}

	public String getStrTestFacility() {
		return strTestFacility;
	}

	public void setStrTestFacility(String strTestFacility) {
		this.strTestFacility = strTestFacility;
	}

	public String getStrModelType() {
		return strModelType;
	}

	public void setStrModelType(String strModelType) {
		this.strModelType = strModelType;
	}

	public String getStrRange() {
		return strRange;
	}

	public void setStrRange(String strRange) {
		this.strRange = strRange;
	}

	public String getStrLeastCount() {
		return strLeastCount;
	}

	public void setStrLeastCount(String strLeastCount) {
		this.strLeastCount = strLeastCount;
	}

	public String getStrValidity() {
		return strValidity;
	}

	public void setStrValidity(String strValidity) {
		this.strValidity = strValidity;
	}

	public String getStrTraceability() {
		return strTraceability;
	}

	public void setStrTraceability(String strTraceability) {
		this.strTraceability = strTraceability;
	}

	public String getStrRemarksAny() {
		return strRemarksAny;
	}

	public void setStrRemarksAny(String strRemarksAny) {
		this.strRemarksAny = strRemarksAny;
	}

		
	
}
