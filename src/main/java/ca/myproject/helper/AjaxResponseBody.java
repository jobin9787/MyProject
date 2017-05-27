package ca.myproject.helper;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonView;

import ca.myproject.car.model.CarMakeModel;
import ca.myproject.jsonview.Views;

public class AjaxResponseBody {

	@JsonView(Views.Public.class)
	String msg;
	@JsonView(Views.Public.class)
	String code;
	

	@JsonView(Views.Public.class)
	Map<String,String> result;
	
	@JsonView(Views.Public.class)
	Map<String,String> mapResult;
	
	public Map<String, String> getMapResult() {
		return mapResult;
	}

	public void setMapResult(Map<String, String> mapResult) {
		this.mapResult = mapResult;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}



	@Override
	public String toString() {
		return "AjaxResponseResult [msg=" + msg + ", code=" + code + ", result=" + result + "]";
	}

}
