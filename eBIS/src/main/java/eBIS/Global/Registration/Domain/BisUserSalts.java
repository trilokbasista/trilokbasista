/*
 * File - BisUserSalts.java
 * Author - Dhruv Pant
 * Purpose - Table in the Database to store user salts*/

package eBIS.Global.Registration.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name="bis_user_salts", schema="bis_dev")
public class BisUserSalts {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="bis_user_salts")
	@TableGenerator(
			initialValue=1,
			name = "bis_user_salts",
	        table = "hibernate_sequences",
	        pkColumnName = "sequence_name",
	        pkColumnValue="bis_user_salts",
	        allocationSize = 1        
	)
	private int id;
	
	
	@Column(name="salts")
	private String salts;
	
	@Column(name="user_id1")
	private int user_id1;
	
	@Column(name="crsdata", length=2)
	String crsdata = "0";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSalts() {
		return salts;
	}

	public void setSalts(String salts) {
		this.salts = salts;
	}

	public int getUser_id1() {
		return user_id1;
	}

	public void setUser_id1(int user_id1) {
		this.user_id1 = user_id1;
	}

	public String getCrsdata() {
		return crsdata;
	}

	public void setCrsdata(String crsdata) {
		this.crsdata = crsdata;
	}

	@Override
	public String toString() {
		return "BisUserSalts [id=" + id + ", salts=" + salts + ", user_id1=" + user_id1 + ", crsdata=" + crsdata + "]";
	}
	
	
}
