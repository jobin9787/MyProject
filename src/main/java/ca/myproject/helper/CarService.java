package ca.myproject.helper;

import java.util.Map;

public interface CarService {
	
	 Map<String,String> getCarModelMap();
	 Map <String,String> getCarMakeModelMap();
	 Map <String,String> getCarMakeModelMap(String modelId);

}
