package com.bionime.assignment.nursingstationManager.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bionime.assignment.nursingstationManager.model.Nurse;

@Repository
public class NurseDaoImpl implements NurseDao {

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
	public List<Nurse> list() {
		Criteria criteria = getSession().createCriteria(Nurse.class);
		return (List<Nurse>) criteria.list();
	}

	@Override
	public void add(Nurse t) {
		getSession().save(t);
	}

	@Override
	public void update(Nurse t) {
		getSession().update(t);
	}

	@Override
	public Nurse get(int id) {
		return (Nurse) getSession().get(Nurse.class, id);
	}

	@Override
	public void delete(int id) {
		getSession().delete(get(id));
	}
}
