package ca.myproject.car.dao;

import java.util.List;

import ca.myproject.car.model.CarMakeModel;



public interface CarMakeModelDao {

	List<CarMakeModel> findAll(String carModelCode);
	
	List<CarMakeModel> findAllByMakeId(String makeId);

}
