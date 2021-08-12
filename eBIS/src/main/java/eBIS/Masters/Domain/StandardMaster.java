package eBIS.Masters.Domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="gblt_standard_mst", schema="bis_dev")
public class StandardMaster {

	@Id
	@Column(name="num_standard_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="gblt_standard_mst")
	@TableGenerator(
			initialValue=1,
			name = "gblt_standard_mst",
	        table = "hibernate_sequences",
	        pkColumnName = "sequence_name",
	        pkColumnValue="gblt_standard_mst",
	        allocationSize = 1        
	)
	private int num_standard_id;
	
	////////id as auto_generated key///////////////
	
		
	@Column(name="str_product_id")
	String str_product_id;
	
	
	@Column(name="str_standard_no")
	String str_standard_no;
	
	@Column(name="num_std_year")
	int num_std_year ;
	
	@Column(name="num_ref_year")
	int num_ref_year ;
	
	
	@Column(name="num_amendments")
	int num_amendments ;
	
	@Column(name="num_PC_amendments")
	int num_PC_amendments ;
	
	
	@Column(name="str_standard_title")
	String str_standard_title;
	
	
	@Column(name="str_tech_comitee")
	String str_tech_comitee;
	
	
	@Column(name="str_equ_standard_no")
	String str_equ_standard_no;
	
	
	@Column(name="str_iden_standard_no")
	String str_iden_standard_no;
	
	
	
	@Column(name="str_not_equ_standard_no")
	String str_not_equ_standard_no;
	
	
	@Column(name="num_revision")
	String num_revision;
	
	
	@Column(name="str_entry_emp_id")
	long str_entry_emp_id;
	
	
	@Column(name="dt_entry_date")
	Date dt_entry_date = new Date();
	
	@Column(name="num_isvalid")
	int num_isvalid;
	
	@Column(name="str_superseded_byis",length=128)
	String str_superseded_byis;
	
	@Column(name="str_filename",length=500)
	String str_filename;
	
	@Column(name="str_remarks",length=500)
	String str_remarks;
	
	@Column(name="num_pages")
	int num_pages;
	
	@Column(name="str_pagesize",length=4)
	String str_pagesize;
	
	@Column(name="num_pricegroup")
	int num_pricegroup;
	
	@Column(name="num_rupee_price_india")
	double num_rupee_price_india;
	
	@Column(name="str_withdrawn",length=4)
	String str_withdrawn;
	
	@Column(name="str_language",length=2)
	String str_language;
	
	@Column(name="str_pdfavailable",length=1)
	String str_pdfavailable;
	
	@Column(name="str_icscode",length=128)
	String str_icscode;
	
	@Column(name="str_foldername",length=16)
	String str_foldername;
	
	@Column(name="num_filesize")
	int num_filesize;
	
	@Column(name="str_pdftype",length=1)
	String str_pdftype;
	
	@Column(name="str_comments",length=16)
	String str_comments;
	
	@Column(name="str_sravailable",length=1)
	String str_sravailable;
	
	
	@Column(name="num_techcommitteeid",length=20)
	int num_techcommitteeid;
	
	@Column(name="num_subsubgroupid")
	int num_subsubgroupid;
	
	@Column(name="num_subgroupid")
	int num_subgroupid;
	
	@Column(name="num_groupid")
	int num_groupid;
	
	@Column(name="str_pc_hall_others",length=10)
	String str_pc_hall_others;
	
	@Column(name="str_superseding_is",length=2000)
	String str_superseding_is;
	
	@Column(name="str_mandat_vol_sdoc",length=20)
	String str_mandat_vol_sdoc;
	
	@Column(name="num_dicipline",length=3)
	int num_dicipline;
	
	@Column(name="str_status_name",length=225)
	String str_status_name;
	
	@Formula(value="to_number(str_product_id)")
	private String intProductId;
	
	@Column(name="str_standard_Title_Hindi",length=2000)
	private String str_standard_Title_Hindi;
	
	@Column(name="dt_concurrent_running_upto")
	Date dt_concurrent_running_upto;
	
	@Column(name="str_notification_for_mandatory")
	String str_notification_for_mandatory;
	
	@Column(name="dt_date_enforcement")
	Date dt_date_enforcement;
	
	@Column(name="str_grouping_guidelines",length=2000)
	String str_grouping_guidelines;
	
	@Column(name="str_product_manual",length=2000)
	String str_product_manual;
	
	@Column(name="str_optionvalue",length=40)
	String str_optionvalue;

	public int getNum_standard_id() {
		return num_standard_id;
	}

	public void setNum_standard_id(int num_standard_id) {
		this.num_standard_id = num_standard_id;
	}

	public String getStr_product_id() {
		return str_product_id;
	}

	public void setStr_product_id(String str_product_id) {
		this.str_product_id = str_product_id;
	}

	public String getStr_standard_no() {
		return str_standard_no;
	}

	public void setStr_standard_no(String str_standard_no) {
		this.str_standard_no = str_standard_no;
	}

	public int getNum_std_year() {
		return num_std_year;
	}

	public void setNum_std_year(int num_std_year) {
		this.num_std_year = num_std_year;
	}

	public int getNum_ref_year() {
		return num_ref_year;
	}

	public void setNum_ref_year(int num_ref_year) {
		this.num_ref_year = num_ref_year;
	}

	public int getNum_amendments() {
		return num_amendments;
	}

	public void setNum_amendments(int num_amendments) {
		this.num_amendments = num_amendments;
	}

	public int getNum_PC_amendments() {
		return num_PC_amendments;
	}

	public void setNum_PC_amendments(int num_PC_amendments) {
		this.num_PC_amendments = num_PC_amendments;
	}

	public String getStr_standard_title() {
		return str_standard_title;
	}

	public void setStr_standard_title(String str_standard_title) {
		this.str_standard_title = str_standard_title;
	}

	public String getStr_tech_comitee() {
		return str_tech_comitee;
	}

	public void setStr_tech_comitee(String str_tech_comitee) {
		this.str_tech_comitee = str_tech_comitee;
	}

	public String getStr_equ_standard_no() {
		return str_equ_standard_no;
	}

	public void setStr_equ_standard_no(String str_equ_standard_no) {
		this.str_equ_standard_no = str_equ_standard_no;
	}

	public String getStr_iden_standard_no() {
		return str_iden_standard_no;
	}

	public void setStr_iden_standard_no(String str_iden_standard_no) {
		this.str_iden_standard_no = str_iden_standard_no;
	}

	public String getStr_not_equ_standard_no() {
		return str_not_equ_standard_no;
	}

	public void setStr_not_equ_standard_no(String str_not_equ_standard_no) {
		this.str_not_equ_standard_no = str_not_equ_standard_no;
	}

	public String getNum_revision() {
		return num_revision;
	}

	public void setNum_revision(String num_revision) {
		this.num_revision = num_revision;
	}

	public long getStr_entry_emp_id() {
		return str_entry_emp_id;
	}

	public void setStr_entry_emp_id(long str_entry_emp_id) {
		this.str_entry_emp_id = str_entry_emp_id;
	}

	public Date getDt_entry_date() {
		return dt_entry_date;
	}

	public void setDt_entry_date(Date dt_entry_date) {
		this.dt_entry_date = dt_entry_date;
	}

	public int getNum_isvalid() {
		return num_isvalid;
	}

	public void setNum_isvalid(int num_isvalid) {
		this.num_isvalid = num_isvalid;
	}

	public String getStr_superseded_byis() {
		return str_superseded_byis;
	}

	public void setStr_superseded_byis(String str_superseded_byis) {
		this.str_superseded_byis = str_superseded_byis;
	}

	public String getStr_filename() {
		return str_filename;
	}

	public void setStr_filename(String str_filename) {
		this.str_filename = str_filename;
	}

	public String getStr_remarks() {
		return str_remarks;
	}

	public void setStr_remarks(String str_remarks) {
		this.str_remarks = str_remarks;
	}

	public int getNum_pages() {
		return num_pages;
	}

	public void setNum_pages(int num_pages) {
		this.num_pages = num_pages;
	}

	public String getStr_pagesize() {
		return str_pagesize;
	}

	public void setStr_pagesize(String str_pagesize) {
		this.str_pagesize = str_pagesize;
	}

	public int getNum_pricegroup() {
		return num_pricegroup;
	}

	public void setNum_pricegroup(int num_pricegroup) {
		this.num_pricegroup = num_pricegroup;
	}

	public double getNum_rupee_price_india() {
		return num_rupee_price_india;
	}

	public void setNum_rupee_price_india(double num_rupee_price_india) {
		this.num_rupee_price_india = num_rupee_price_india;
	}

	public String getStr_withdrawn() {
		return str_withdrawn;
	}

	public void setStr_withdrawn(String str_withdrawn) {
		this.str_withdrawn = str_withdrawn;
	}

	public String getStr_language() {
		return str_language;
	}

	public void setStr_language(String str_language) {
		this.str_language = str_language;
	}

	public String getStr_pdfavailable() {
		return str_pdfavailable;
	}

	public void setStr_pdfavailable(String str_pdfavailable) {
		this.str_pdfavailable = str_pdfavailable;
	}

	public String getStr_icscode() {
		return str_icscode;
	}

	public void setStr_icscode(String str_icscode) {
		this.str_icscode = str_icscode;
	}

	public String getStr_foldername() {
		return str_foldername;
	}

	public void setStr_foldername(String str_foldername) {
		this.str_foldername = str_foldername;
	}

	public int getNum_filesize() {
		return num_filesize;
	}

	public void setNum_filesize(int num_filesize) {
		this.num_filesize = num_filesize;
	}

	public String getStr_pdftype() {
		return str_pdftype;
	}

	public void setStr_pdftype(String str_pdftype) {
		this.str_pdftype = str_pdftype;
	}

	public String getStr_comments() {
		return str_comments;
	}

	public void setStr_comments(String str_comments) {
		this.str_comments = str_comments;
	}

	public String getStr_sravailable() {
		return str_sravailable;
	}

	public void setStr_sravailable(String str_sravailable) {
		this.str_sravailable = str_sravailable;
	}

	public int getNum_techcommitteeid() {
		return num_techcommitteeid;
	}

	public void setNum_techcommitteeid(int num_techcommitteeid) {
		this.num_techcommitteeid = num_techcommitteeid;
	}

	public int getNum_subsubgroupid() {
		return num_subsubgroupid;
	}

	public void setNum_subsubgroupid(int num_subsubgroupid) {
		this.num_subsubgroupid = num_subsubgroupid;
	}

	public int getNum_subgroupid() {
		return num_subgroupid;
	}

	public void setNum_subgroupid(int num_subgroupid) {
		this.num_subgroupid = num_subgroupid;
	}

	public int getNum_groupid() {
		return num_groupid;
	}

	public void setNum_groupid(int num_groupid) {
		this.num_groupid = num_groupid;
	}

	public String getStr_pc_hall_others() {
		return str_pc_hall_others;
	}

	public void setStr_pc_hall_others(String str_pc_hall_others) {
		this.str_pc_hall_others = str_pc_hall_others;
	}

	public String getStr_superseding_is() {
		return str_superseding_is;
	}

	public void setStr_superseding_is(String str_superseding_is) {
		this.str_superseding_is = str_superseding_is;
	}

	public String getStr_mandat_vol_sdoc() {
		return str_mandat_vol_sdoc;
	}

	public void setStr_mandat_vol_sdoc(String str_mandat_vol_sdoc) {
		this.str_mandat_vol_sdoc = str_mandat_vol_sdoc;
	}

	public int getNum_dicipline() {
		return num_dicipline;
	}

	public void setNum_dicipline(int num_dicipline) {
		this.num_dicipline = num_dicipline;
	}

	public String getStr_status_name() {
		return str_status_name;
	}

	public void setStr_status_name(String str_status_name) {
		this.str_status_name = str_status_name;
	}

	public String getIntProductId() {
		return intProductId;
	}

	public void setIntProductId(String intProductId) {
		this.intProductId = intProductId;
	}

	public String getStr_standard_Title_Hindi() {
		return str_standard_Title_Hindi;
	}

	public void setStr_standard_Title_Hindi(String str_standard_Title_Hindi) {
		this.str_standard_Title_Hindi = str_standard_Title_Hindi;
	}

	public Date getDt_concurrent_running_upto() {
		return dt_concurrent_running_upto;
	}

	public void setDt_concurrent_running_upto(Date dt_concurrent_running_upto) {
		this.dt_concurrent_running_upto = dt_concurrent_running_upto;
	}

	public String getStr_notification_for_mandatory() {
		return str_notification_for_mandatory;
	}

	public void setStr_notification_for_mandatory(String str_notification_for_mandatory) {
		this.str_notification_for_mandatory = str_notification_for_mandatory;
	}

	public Date getDt_date_enforcement() {
		return dt_date_enforcement;
	}

	public void setDt_date_enforcement(Date dt_date_enforcement) {
		this.dt_date_enforcement = dt_date_enforcement;
	}

	public String getStr_grouping_guidelines() {
		return str_grouping_guidelines;
	}

	public void setStr_grouping_guidelines(String str_grouping_guidelines) {
		this.str_grouping_guidelines = str_grouping_guidelines;
	}

	public String getStr_product_manual() {
		return str_product_manual;
	}

	public void setStr_product_manual(String str_product_manual) {
		this.str_product_manual = str_product_manual;
	}

	public String getStr_optionvalue() {
		return str_optionvalue;
	}

	public void setStr_optionvalue(String str_optionvalue) {
		this.str_optionvalue = str_optionvalue;
	}
	
}
