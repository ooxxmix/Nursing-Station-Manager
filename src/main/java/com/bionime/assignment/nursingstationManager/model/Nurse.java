package com.bionime.assignment.nursingstationManager.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nurse")
public class Nurse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "NO")
	private String no;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CREATEDATE")
	private Timestamp createDate;

	// private Set<Station> stations = new HashSet<Station>(0);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
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
	// @JoinTable(name = "nursingstation", joinColumns = { @JoinColumn(name = "NID")
	// }, inverseJoinColumns = {
	// @JoinColumn(name = "SID") })
	// public Set<Station> getStations() {
	// return stations;
	// }
	//
	// public void setStations(Set<Station> stations) {
	// this.stations = stations;
	// }

}