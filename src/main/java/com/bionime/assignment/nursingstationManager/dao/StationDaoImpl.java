package com.bionime.assignment.nursingstationManager.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bionime.assignment.nursingstationManager.model.Nurse;
import com.bionime.assignment.nursingstationManager.model.Station;

@Repository
public class StationDaoImpl implements StationDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Station> list() {
		Criteria criteria = getSession().createCriteria(Station.class);
		return (List<Station>) criteria.list();
	}
	
	@Override
	public void add(Station t) {
		getSession().save(t);
	}

	@Override
	public void update(Station t) {
		getSession().saveOrUpdate(t);
	}

	@Override
	public Station get(int id) {
		return (Station) getSession().get(Station.class, id);
	}

	@Override
	public void delete(int id) {
		getSession().delete(get(id));
	}
}
