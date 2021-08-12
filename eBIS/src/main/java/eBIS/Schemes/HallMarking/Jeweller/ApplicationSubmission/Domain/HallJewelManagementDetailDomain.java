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
@Table(name="hall_jewel_managementdetail_domain", schema="bis_hall")
public class HallJewelManagementDetailDomain {

	
	@Id
	@Column(name="num_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="hall_jewel_managementdetail_domain")
	@TableGenerator(
			initialValue=1,
			name = "hall_jewel_managementdetail_domain",
	        table = "hibernate_sequences",
	        pkColumnName = "sequence_name",
	        pkColumnValue="hall_jewel_managementdetail_domain",
	        allocationSize = 1        
				)
			int num_id;
		    
            @Column(name="str_app_id", length=255)
            String str_app_id;
            
            @Column(name="str_name", length=255)
            String str_name;
            
            @Column(name="str_designation", length=255)
            String str_designation;		            
            
            @Column (name="num_branch_id")
			int num_branch_id;
            
            @Column (name="num_isvalid")
			private int num_isvalid=1;
            
            @Column(name="dt_entry_date",nullable = true)
            Date dt_entry_date = new Date();         
            
            @Column(name="num_entry_emp_id")
            int num_entry_emp_id;
            
            @Column(name="str_auth_signatory", length=100)
            String str_auth_signatory;
            
            @Column(name="str_aadhar_base", length=100)
            String str_aadhar_base;
            
            @Column(name="str_aadhar_otp_verif", length=100)
            String str_aadhar_otp_verif;
            
            @Column(name="str_application_id_ref")
        	String str_application_id_ref;

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

			public String getStr_name() {
				return str_name;
			}

			public void setStr_name(String str_name) {
				this.str_name = str_name;
			}

			public String getStr_designation() {
				return str_designation;
			}

			public void setStr_designation(String str_designation) {
				this.str_designation = str_designation;
			}

			public int getNum_branch_id() {
				return num_branch_id;
			}

			public void setNum_branch_id(int num_branch_id) {
				this.num_branch_id = num_branch_id;
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

			public int getNum_entry_emp_id() {
				return num_entry_emp_id;
			}

			public void setNum_entry_emp_id(int num_entry_emp_id) {
				this.num_entry_emp_id = num_entry_emp_id;
			}

			public String getStr_auth_signatory() {
				return str_auth_signatory;
			}

			public void setStr_auth_signatory(String str_auth_signatory) {
				this.str_auth_signatory = str_auth_signatory;
			}

			public String getStr_aadhar_base() {
				return str_aadhar_base;
			}

			public void setStr_aadhar_base(String str_aadhar_base) {
				this.str_aadhar_base = str_aadhar_base;
			}

			public String getStr_aadhar_otp_verif() {
				return str_aadhar_otp_verif;
			}

			public void setStr_aadhar_otp_verif(String str_aadhar_otp_verif) {
				this.str_aadhar_otp_verif = str_aadhar_otp_verif;
			}

			public String getStr_application_id_ref() {
				return str_application_id_ref;
			}

			public void setStr_application_id_ref(String str_application_id_ref) {
				this.str_application_id_ref = str_application_id_ref;
			}

			@Override
			public String toString() {
				return "HallJewelManagementDetailDomain [num_id=" + num_id + ", str_app_id=" + str_app_id
						+ ", str_name=" + str_name + ", str_designation=" + str_designation + ", num_branch_id="
						+ num_branch_id + ", num_isvalid=" + num_isvalid + ", dt_entry_date=" + dt_entry_date
						+ ", num_entry_emp_id=" + num_entry_emp_id + ", str_auth_signatory=" + str_auth_signatory
						+ ", str_aadhar_base=" + str_aadhar_base + ", str_aadhar_otp_verif=" + str_aadhar_otp_verif
						+ ", str_application_id_ref=" + str_application_id_ref + "]";
			}

	
}
