package ca.myproject.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import ca.myproject.car.dao.CarMakeDao;
import ca.myproject.car.dao.CarMakeModelDao;
import ca.myproject.car.dao.impl.CarMakeModelDaoImpl;
import ca.myproject.car.model.CarMake;
import ca.myproject.car.model.CarMakeModel;



public class DropDownBoxControllerImpl implements DropDownBoxController {
	
	
	private Map<String,String> carMakeMap =new HashMap<String, String>() ;
	

	private Map<String,String> ModelMap  ;
	private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
	
    private Map<String,String> carMakeModelList ;
	
	
	
	@Autowired
	 CarMakeDao carMakeDao;
	
	CarMakeModelDao carMakeModeDao ;
	
	public DropDownBoxControllerImpl(){
	
			List<CarMake> caremakeList = carMakeDao.getAllList();
				
			 for(CarMake caremake: caremakeList){
				System.out.println(caremake.getMakename() + "  " +caremake.getMakename().length());
				 carMakeMap.put(caremake.getMakename().trim(),caremake.getCarmakeid() );
				 
				 Map modelMap = new HashMap<String,String>();
				 modelMap=initCarModelListMap(caremake.getCarmakeid());
				 
					System.out.println(caremake.getMakename() + "  " +caremake.getMakename().length());
				 data.put(caremake.getCarmakeid(),modelMap );
			 }
		
	}
	

	

	
	public Map initCarModelListMap(String carModelCode) {
		carMakeModeDao = new CarMakeModelDaoImpl(); 
		List<CarMakeModel> carmakemodelList = carMakeModeDao.findAll(carModelCode);
		ModelMap =new HashMap<String, String>();
	  for(CarMakeModel caremakemodel: carmakemodelList){
		  
		  ModelMap.put(caremakemodel.getMakemodelname(), 
					 caremakemodel.getCarmakemodelid());
		
		 }
	  
	  return ModelMap;
	
	} 
	
	
//	public void onCarMakeChange(String carMake) {
//		
//		
//        if(carMake !=null && !carMake.equals(""))
//        {
//        	carMakeModelList = data.get(carMake);
//        System.out.println("Found "+ carMakeModelList.size() );
//        }
//        else
//        	carModelListMap = new HashMap<String, String>();
//    }
	

}
