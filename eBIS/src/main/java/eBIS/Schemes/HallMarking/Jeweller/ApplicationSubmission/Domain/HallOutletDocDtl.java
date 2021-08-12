package eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


	@Entity
	@Table(name="hall_outlet_doc_dtl",schema="bis_hall")
	public class HallOutletDocDtl{

		@Id			
		@GeneratedValue(strategy=GenerationType.TABLE, generator="hall_outlet_doc_dtl")
		@TableGenerator(
				initialValue=1,
				name = "hall_outlet_doc_dtl",
		        table = "hibernate_sequences",
		        pkColumnName = "sequence_name",
		        pkColumnValue="hall_outlet_doc_dtl",
		        allocationSize = 1        
		)
	    @Column (name="num_id")
		private int num_id;
	        
	    @Column(name="str_app_id",length=12)
	    private String str_app_id; 
	    	    	    
	    @Column (name="str_doc_name",length=255)
		private String str_doc_name;
	    
	    @Column(name="num_sr_no",length=3)
	    private int num_sr_no=0;
	    
	    @Column(name="num_doc_id",length=3)
	    private int num_doc_id;
	    
	    @Column (name="num_isvalid",length=1)
		private int num_isvalid=1;
	    
	    @Column (name="dt_entry_date")
		private Date dt_entry_date=new Date();
	    	    	    
	    @Column(name="num_entry_emp_id",length=10)
		Long num_entry_emp_id;
	    
		@Column(name="num_branch_id",length=3)
		private int num_branch_id;
			    
	    @Column(name="str_file_checksum", length=255)
	    private String str_file_checksum;
	    
	    @Column(name="str_outlet_numid", length=255)
	    private String str_outlet_numid;

	    @Column(name = "str_application_id_ref")
		String str_application_id_re="0";
	    
	    @Column (name="str_remarks",length=500)
		private String str_remarks;
		    
	    @Column(name = "num_ok", nullable = false, columnDefinition = "int default 0")
		private int num_ok;
		
		
		@Column (name="str_clarify",length=500)
		private String str_clarify;
	    
	
		
		public String getStr_remarks() {
			return str_remarks;
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

		public String getStr_clarify() {
			return str_clarify;
		}

		public void setStr_clarify(String str_clarify) {
			this.str_clarify = str_clarify;
		}

		public String getStr_outlet_numid() {
			return str_outlet_numid;
		}

		public void setStr_outlet_numid(String str_outlet_numid) {
			this.str_outlet_numid = str_outlet_numid;
		}

		public String getStr_application_id_re() {
			return str_application_id_re;
		}

		public void setStr_application_id_re(String str_application_id_re) {
			this.str_application_id_re = str_application_id_re;
		}

		public int getNum_id() {
			return num_id;
		}

		public void setNum_id(int num_id) {
			this.num_id = num_id;
		}

		public String getStr_app_id() {
			return str_app_id;
		}

		public void setStr_app_id(String str_app_id) {
			this.str_app_id = str_app_id;
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

		public Long getNum_entry_emp_id() {
			return num_entry_emp_id;
		}

		public void setNum_entry_emp_id(Long num_entry_emp_id) {
			this.num_entry_emp_id = num_entry_emp_id;
		}

		public int getNum_branch_id() {
			return num_branch_id;
		}

		public void setNum_branch_id(int num_branch_id) {
			this.num_branch_id = num_branch_id;
		}

		public String getStr_file_checksum() {
			return str_file_checksum;
		}

		public void setStr_file_checksum(String str_file_checksum) {
			this.str_file_checksum = str_file_checksum;
		}

		public int getNum_doc_id() {
			return num_doc_id;
		}

		public void setNum_doc_id(int num_doc_id) {
			this.num_doc_id = num_doc_id;
		}

		@Override
		public String toString() {
			return "HallOutletDocDtl [num_id=" + num_id + ", str_app_id=" + str_app_id + ", str_doc_name="
					+ str_doc_name + ", num_sr_no=" + num_sr_no + ", num_doc_id=" + num_doc_id + ", num_isvalid="
					+ num_isvalid + ", dt_entry_date=" + dt_entry_date + ", num_entry_emp_id=" + num_entry_emp_id
					+ ", num_branch_id=" + num_branch_id + ", str_file_checksum=" + str_file_checksum
					+ ", str_outlet_numid=" + str_outlet_numid + ", str_application_id_re=" + str_application_id_re
					+ ", str_remarks=" + str_remarks + ", num_ok=" + num_ok + ", str_clarify=" + str_clarify + "]";
		}
	    	    
	}