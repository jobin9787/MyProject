package ca.myproject.helper;

public class SearchCriteria {

	String name;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "SearchCriteria [name=" +name +  "]";
	}

}
