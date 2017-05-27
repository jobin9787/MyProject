package ca.myproject.car.dao;

import java.util.List;

import ca.myproject.car.model.CarAd;

public interface CarAdDao {
	
	public CarAd getCarAdByID(int id);
	public List<CarAd> getListAllCarAd();
	public void addCarAd(CarAd carad);
	public void deleteCarAd(int id);

}
