package ca.myproject.car.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.myproject.car.dao.CarAdDao;
import ca.myproject.car.model.CarAd;

@Repository
@Transactional
public class CarAdDaoImpl implements CarAdDao {

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public CarAd getCarAdByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		CarAd carad = (CarAd) session.get(CarAd.class, id);
		return carad;
	}

	@Override
	public List<CarAd> getListAllCarAd() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CarAd");
		List<CarAd> carAdList = query.list();
		session.flush();
		return carAdList;
	}

	@Override
	public void addCarAd(CarAd carad) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(carad);
		session.flush();

	}

	@Override
	public void deleteCarAd(int id) {
		// TODO Auto-generated method stub

	}

}
