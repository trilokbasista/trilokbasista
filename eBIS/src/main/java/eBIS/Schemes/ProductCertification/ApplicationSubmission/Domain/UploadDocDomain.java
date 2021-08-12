package eBIS.Schemes.ProductCertification.ApplicationSubmission.Domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="gblt_app_doc_dtl",schema="bis_dev")
public class UploadDocDomain {
    @Id			
	@GeneratedValue(strategy=GenerationType.TABLE, generator="gblt_app_doc_dtl")
    @TableGenerator(
			initialValue=1,
			name = "gblt_app_doc_dtl",
	        table = "hibernate_sequences",
	        pkColumnName = "sequence_name",
	        pkColumnValue="gblt_app_doc_dtl",
	        allocationSize = 1        
	)
    @Column (name="num_id")
	private int num_id;
        
    @Column(name="str_app_id",length=12)
    private String str_app_id; 
    
    @Column(name="num_doc_id", length=2)
    private int num_doc_id;   
    
    @Column (name="str_doc_name",length=255)
	private String str_doc_name;
    
    @Column(name="num_sr_no",length=3)
    private int num_sr_no=0;      
    
    @Column (name="num_isvalid",length=1)
	private int num_isvalid=1;
    
    @Column (name="num_scheme_id",length=1)
	private int num_scheme_id=0;
    
    @Column (name="dt_entry_date")
	private Date dt_entry_date=new Date();
    
    
    @Column (name="str_remarks",length=255)
   	private String str_remarks;
    
    @Column (name="num_ok")
   	private int num_ok;
    
    @Column(name="num_entry_emp_id",length=10)
	Long num_entry_emp_id;
    
	@Column(name="num_branch_id",length=3)
	private int num_branch_id;
	
	@Column(name="str_file_ext",length=10)
	private String str_file_ext;
	
	
    @Column (name="num_draft_status",length=1)
	private int num_draft_status=0;
	
    @Column (name="str_clarify",length=255)
   	private String str_clarify;
    
    @Column(name="str_file_checksum", length=255)
    private String str_file_checksum;
    
    @Column(name="str_file_name_profile", length=255)
    private String str_file_name_profile;
    
    @Column(name="str_doc_option", length=1000)
    private String str_doc_option;
    
    @Column(name = "str_application_id_ref")
	String str_app_id_ref;
    
    @Column(name = "num_app_id")
    int num_app_id=0;
    
    
    public String getStr_app_id_ref() {
		return str_app_id_ref;
	}

	public void setStr_app_id_ref(String str_app_id_ref) {
		this.str_app_id_ref = str_app_id_ref;
	}

	public String getStr_doc_option() {
		return str_doc_option;
	}

	public void setStr_doc_option(String str_doc_option) {
		this.str_doc_option = str_doc_option;
	}

	public String getStr_file_name_profile() {
		return str_file_name_profile;
	}

	public void setStr_file_name_profile(String str_file_name_profile) {
		this.str_file_name_profile = str_file_name_profile;
	}

	public String getStr_file_checksum() {
		return str_file_checksum;
	}

	public void setStr_file_checksum(String str_file_checksum) {
		this.str_file_checksum = str_file_checksum;
	}

	public String getStr_clarify() {
		return str_clarify;
	}

	public void setStr_clarify(String str_clarify) {
		this.str_clarify = str_clarify;
	}

	public int getNum_draft_status() {
		return num_draft_status;
	}

	public void setNum_draft_status(int num_draft_status) {
		this.num_draft_status = num_draft_status;
	}

	public int getNum_branch_id() {
		return num_branch_id;
	}

	public void setNum_branch_id(int num_branch_id) {
		this.num_branch_id = num_branch_id;
	}

/*	public Long getStrEntryEmpId() {
		return strEntryEmpId;
	}

	public void setStrEntryEmpId(Long strEntryEmpId) {
		this.strEntryEmpId = strEntryEmpId;
	}*/

	public String getStr_remarks() {
		return str_remarks;
	}

	public Long getNum_entry_emp_id() {
		return num_entry_emp_id;
	}

	public void setNum_entry_emp_id(Long num_entry_emp_id) {
		this.num_entry_emp_id = num_entry_emp_id;
	}

	public void setStr_remarks(String str_remarks) {
		this.str_remarks = str_remarks;
	}

	public int getNum_ok() {
		return num_ok;
	}

	public void setNum_ok(int num_ok) {
		this.num_ok = num_ok;
	}

	public int getNum_id() {
		return num_id;
	}

	public void setNum_id(int num_id) {
		this.num_id = num_id;
	}

	

	public int getNum_doc_id() {
		return num_doc_id;
	}

	public void setNum_doc_id(int num_doc_id) {
		this.num_doc_id = num_doc_id;
	}

	public String getStr_doc_name() {
		return str_doc_name;
	}

	public void setStr_doc_name(String str_doc_name) {
		this.str_doc_name = str_doc_name;
	}

	public int getNum_sr_no() {
		return num_sr_no;
	}

	public void setNum_sr_no(int num_sr_no) {
		this.num_sr_no = num_sr_no;
	}

	public int getNum_isvalid() {
		return num_isvalid;
	}

	public void setNum_isvalid(int num_isvalid) {
		this.num_isvalid = num_isvalid;
	}

	public Date getDt_entry_date() {
		return dt_entry_date;
	}

	public void setDt_entry_date(Date dt_entry_date) {
		this.dt_entry_date = dt_entry_date;
	}

	public String getStr_app_id() {
		return str_app_id;
	}

	public void setStr_app_id(String str_app_id) {
		this.str_app_id = str_app_id;
	}

	public String getStr_file_ext() {
		return str_file_ext;
	}

	public void setStr_file_ext(String str_file_ext) {
		this.str_file_ext = str_file_ext;
	}

	public int getNum_scheme_id() {
		return num_scheme_id;
	}

	public void setNum_scheme_id(int num_scheme_id) {
		this.num_scheme_id = num_scheme_id;
	}

	public int getNum_app_id() {
		return num_app_id;
	}

	public void setNum_app_id(int num_app_id) {
		this.num_app_id = num_app_id;
	}

	@Override
	public String toString() {
		return "UploadDoc_Domain [num_id=" + num_id + ", str_app_id=" + str_app_id + ", num_doc_id=" + num_doc_id
				+ ", str_doc_name=" + str_doc_name + ", num_sr_no=" + num_sr_no + ", num_isvalid=" + num_isvalid
				+ ", num_scheme_id=" + num_scheme_id + ", dt_entry_date=" + dt_entry_date + ", str_remarks="
				+ str_remarks + ", num_ok=" + num_ok + ", num_entry_emp_id=" + num_entry_emp_id + ", num_branch_id="
				+ num_branch_id + ", str_file_ext=" + str_file_ext + ", num_draft_status=" + num_draft_status
				+ ", str_clarify=" + str_clarify + ", str_file_checksum=" + str_file_checksum
				+ ", str_file_name_profile=" + str_file_name_profile + ", str_doc_option=" + str_doc_option
				+ ", str_app_id_ref=" + str_app_id_ref + ", num_app_id=" + num_app_id + "]";
	}

    
}
