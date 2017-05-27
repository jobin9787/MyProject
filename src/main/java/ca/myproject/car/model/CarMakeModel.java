package ca.myproject.car.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="carmakemodel")
public class CarMakeModel {

	/**
	 * 
	 */

	
	
	public CarMakeModel(){
	
	}
	
	private String carmakemodelid;
	private String makemodelname;
	private CarMake caremake;
	
	
	@Id
	@Column (name="MAKEMODELID")
	public String getCarmakemodelid() {
		return carmakemodelid;
	}
	public void setCarmakemodelid(String carmakemodelid) {
		this.carmakemodelid = carmakemodelid;
	}
	public String getMakemodelname() {
		return makemodelname;
	}
	
	@Column (name="MAKEMODELNAME")
	public void setMakemodelname(String makemodelname) {
		this.makemodelname = makemodelname;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARMAKEID", nullable = false)
	public CarMake getCaremake() {
		return caremake;
	}
	public void setCaremake(CarMake caremake) {
		this.caremake = caremake;
	}
	
	
	
}
