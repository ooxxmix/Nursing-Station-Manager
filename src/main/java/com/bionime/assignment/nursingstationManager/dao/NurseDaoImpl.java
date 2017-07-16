package com.bionime.assignment.nursingstationManager.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bionime.assignment.nursingstationManager.model.Nurse;

@Repository("Dao")
public class NurseDaoImpl implements Dao<Nurse> {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Nurse> list() {
		Criteria criteria = getSession().createCriteria(Nurse.class);
		return (List<Nurse>) criteria.list();
	}

	public void update(Nurse t) {
		getSession().saveOrUpdate(t);
	}

	public Nurse get(int id) {
		return (Nurse) getSession().get(Nurse.class, id);
	}

	public void delete(int id) {
		getSession().delete(get(id));
	}

}
