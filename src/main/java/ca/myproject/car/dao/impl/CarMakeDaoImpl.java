package ca.myproject.car.dao.impl;

import ca.myproject.car.model.CarMake;

import java.util.List;


import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.myproject.car.dao.CarMakeDao;

@Repository
@Transactional
public class CarMakeDaoImpl implements CarMakeDao{
@Autowired
SessionFactory sessionFactory;
	
	@Override
	public CarMake getCarMakeById(String id) {
		Session session = sessionFactory.getCurrentSession();
		CarMake carMake = session.get(CarMake.class,id);
		session.flush();
		return carMake;
	}

	@Override
	public List<CarMake> getAllList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CarMake");
		List<CarMake> carMakeList=query.list();
		return carMakeList;
	}
	
	
	

}
