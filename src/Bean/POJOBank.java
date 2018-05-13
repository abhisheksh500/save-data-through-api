package Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank_detail")
public class POJOBank {
	private int id;
	private int cus_id;
	private int time;
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="Cus_id")
	public int getCus_id() {
		return cus_id;
	}
	
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	
}
