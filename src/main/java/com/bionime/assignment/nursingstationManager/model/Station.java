package com.bionime.assignment.nursingstationManager.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name = "station")
public class Station {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CREATEDATE")
	private Timestamp createDate;

	// @ManyToMany(mappedBy = "stations")
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "stations", fetch = FetchType.EAGER)
	private Set<Nurse> nurses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Transactional
	public Set<Nurse> getNurses() {
		return nurses;
	}

	public void setNurses(Set<Nurse> nurses) {
		this.nurses = nurses;
	}

	public void addNurse(Nurse nurse) {
		nurses.add(nurse);
		nurse.getStations().add(this);
	}

	public void removeNurse(Nurse nurse) {
		nurses.remove(nurse);
		nurse.getStations().remove(this);
	}

}
