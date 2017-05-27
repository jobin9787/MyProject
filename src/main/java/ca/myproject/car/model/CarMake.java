package ca.myproject.car.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
public class CarMake {
	
	/**
	 * @author Hamid
	 */

	private String carmakeid;
	private String makename;
	
	
//	private Set<CarMakeModel> CareMakeModelRecords = new HashSet<CarMakeModel>();
	@Id
	@Column (name="CARMAKEID")
	public String getCarmakeid() {
		return carmakeid;
	}
	public void setCarmakeid(String carmakeid) {
		this.carmakeid = carmakeid;
	}
	@Column(name = "MAKENAME", nullable = false, length = 100)
	public String getMakename() {
		return makename;
	}
	public void setMakename(String makename) {
		this.makename = makename;
	}
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caremake")
//	public Set<CarMakeModel> getCareMakeModelRecords() {
//		return CareMakeModelRecords;
//	}
//	public void setCareMakeModelRecords(Set<CarMakeModel> careMakeModelRecords) {
//		CareMakeModelRecords = careMakeModelRecords;
//	}

	
	
}
