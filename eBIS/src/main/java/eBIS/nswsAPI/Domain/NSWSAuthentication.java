package eBIS.nswsAPI.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="NSWS_Authentication",schema="bis_nsws")
public class NSWSAuthentication {
	@Id
	@Column(name="num_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="nsws_authentication")
	@TableGenerator(
			initialValue=1,
			name = "nsws_authentication",
	        table = "hibernate_sequences",
	        pkColumnName = "sequence_name",
	        pkColumnValue="nsws_authentication",
	        allocationSize = 1        
	)
	private Long num_id;
	private String nsws_id="";
	private String nsws_key="";
	public Long getNum_id() {
		return num_id;
	}
	public void setNum_id(Long num_id) {
		this.num_id = num_id;
	}
	public String getNsws_id() {
		return nsws_id;
	}
	public void setNsws_id(String nsws_id) {
		this.nsws_id = nsws_id;
	}
	public String getNsws_key() {
		return nsws_key;
	}
	public void setNsws_key(String nsws_key) {
		this.nsws_key = nsws_key;
	}
	@Override
	public String toString() {
		return "NSWSAuthentication [num_id=" + num_id + ", nsws_id=" + nsws_id + ", nsws_key=" + nsws_key + "]";
	}
	
}
