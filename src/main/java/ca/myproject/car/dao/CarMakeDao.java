package ca.myproject.car.dao;

import java.util.List;

import ca.myproject.car.model.CarMake;

public interface CarMakeDao {
	CarMake getCarMakeById(String id);
	List<CarMake> getAllList();


}
