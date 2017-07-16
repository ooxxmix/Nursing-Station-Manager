package com.bionime.assignment.nursingstationManager.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	// private Set<Nurse> nurses = new HashSet<Nurse>(0);

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

	// @ManyToMany(cascade = CascadeType.ALL)
	// @JoinTable(name = "nursingstation", joinColumns = { @JoinColumn(name = "SID")
	// }, inverseJoinColumns = {
	// @JoinColumn(name = "NID") })
	// public Set<Nurse> getNurses() {
	// return nurses;
	// }
	//
	// public void setNurses(Set<Nurse> nurses) {
	// this.nurses = nurses;
	// }
}
