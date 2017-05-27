package ca.myproject.car.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.myproject.car.model.CarMakeModel;
import ca.myproject.car.dao.CarMakeModelDao;


@Repository
@Transactional
public class CarMakeModelDaoImpl implements CarMakeModelDao {

	
	@Autowired
	SessionFactory sessionFactory;
		
	@Override
	public List<CarMakeModel> findAll(String carModelCode) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CarMakeModel");
		List<CarMakeModel> carMakeModelList = query.list();
		session.flush();
		return carMakeModelList;
	}

	@Override
	public List<CarMakeModel> findAllByMakeId(String makeId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From CarMakeModel where CARMAKEID = :id ");
        query.setParameter("id", makeId);
        List<CarMakeModel> carMakeModelList = query.list();
		session.flush();
		return carMakeModelList;
	}

}
