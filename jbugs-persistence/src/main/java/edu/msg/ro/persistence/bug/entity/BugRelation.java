package edu.msg.ro.persistence.bug.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import edu.msg.ro.persistence.common.entity.AbstractEntity;

@Entity
public class BugRelation extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne()
	private Bug bug1;

	@OneToOne
	private Bug bug2;

	@Column
	private int relation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bug getBug1() {
		return bug1;
	}

	public void setBug1(Bug bug1) {
		this.bug1 = bug1;
	}

	public Bug getBug2() {
		return bug2;
	}

	public void setBug2(Bug bug2) {
		this.bug2 = bug2;
	}

	public int getRelation() {
		return relation;
	}

	public void setRelation(int relation) {
		this.relation = relation;
	}
}
