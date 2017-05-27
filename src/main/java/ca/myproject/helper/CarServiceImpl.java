package ca.myproject.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.myproject.car.dao.CarMakeDao;
import ca.myproject.car.dao.CarMakeModelDao;
import ca.myproject.car.model.CarMake;
import ca.myproject.car.model.CarMakeModel;


public class CarServiceImpl implements CarService{
	//private Logger 
	private Map <String, String> carModelMap = new HashMap<String, String>();
	private Map <String, String> carMakeModelMap= new HashMap<String, String>();;
	private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
	
	@Autowired
	CarMakeDao carMakeDao;
	
	@Autowired
	CarMakeModelDao carMakeModelDao;
	
	 @PostConstruct
	    public void init() {
		 
	
			List<CarMake> caremakeList = 	 carMakeDao.getAllList();
				
			 for(CarMake caremake: caremakeList){
				System.out.println(caremake.getMakename() + "  " +caremake.getMakename().length());
				carModelMap.put(caremake.getCarmakeid(), caremake.getMakename().trim());
				 
				 Map modelMap = new HashMap<String,String>();
				 modelMap=initCarModelListMap( caremake.getCarmakeid() );
				 
					System.out.println(caremake.getMakename() + "  " +caremake.getMakename().length());
				 data.put(caremake.getCarmakeid(),modelMap );
			 }
		 

	    }


	 public Map initCarModelListMap(String carModelCode) {
			 
			List<CarMakeModel> carmakemodelList = carMakeModelDao.findAllByMakeId(carModelCode);
			Map ModelMap =new HashMap<String, String>();
		  for(CarMakeModel caremakemodel: carmakemodelList){
			  
			  ModelMap.put(caremakemodel.getCarmakemodelid(),caremakemodel.getMakemodelname());
			
			 }
		  
		  return ModelMap;
		
		} 


	@Override
	public Map <String,String> getCarModelMap() {
		// TODO Auto-generated method stub
		return carModelMap;
	}



	@Override
	public   Map<String, String>  getCarMakeModelMap() {
		// TODO Auto-generated method stub
		return carMakeModelMap;
	}
	
	@Override
	public   Map<String, String>  getCarMakeModelMap(String modelId) {
		// TODO Auto-generated method stub
		return data.get(modelId);
	}
	
	

}
