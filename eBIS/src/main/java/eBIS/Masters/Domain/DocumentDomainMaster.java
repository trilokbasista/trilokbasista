package eBIS.Masters.Domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.TableGenerator;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gblt_document_mst", schema = "bis_dev")
public class DocumentDomainMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gblt_document_mst")
	@TableGenerator(
			initialValue=1,
			name = "gblt_document_mst",
	        table = "hibernate_sequences",
	        pkColumnName = "sequence_name",
	        pkColumnValue="gblt_document_mst",
	        allocationSize = 1        
	)
	@Column(name = "num_doc_id")
	private int num_doc_id;

	@Column(name = "str_doc_name", unique = true, length = 255)
	String str_doc_name;
	@Column(name = "num_isvalid", length = 1)
	int num_isvalid = 1;

	@Column(name = "dt_entry_date", nullable = true)
	Date dt_entry_date = new Date();

	@Column(name = "num_entry_emp_id", length = 10)
	long num_entry_emp_id;

	@Column(name = "test_doc_name", unique = true, length = 255)
	String test_doc_name;

	public String getTest_doc_name() {
		return test_doc_name;
	}

	public void setTest_doc_name(String test_doc_name) {
		this.test_doc_name = test_doc_name;
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

	public long getNum_entry_emp_id() {
		return num_entry_emp_id;
	}

	public void setNum_entry_emp_id(long num_entry_emp_id) {
		this.num_entry_emp_id = num_entry_emp_id;
	}

	@Override
	public String toString() {
		return "DocumentDomainMaster [num_doc_id=" + num_doc_id + ", str_doc_name=" + str_doc_name + ", num_isvalid="
				+ num_isvalid + ", dt_entry_date=" + dt_entry_date + ", num_entry_emp_id=" + num_entry_emp_id
				+ ", test_doc_name=" + test_doc_name + "]";
	}

}
