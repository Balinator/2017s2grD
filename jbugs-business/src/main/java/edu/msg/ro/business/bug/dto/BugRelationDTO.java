package edu.msg.ro.business.bug.dto;

import edu.msg.ro.business.bug.enums.BugRelationEnum;
import edu.msg.ro.business.common.dto.AbstractDTO;

public class BugRelationDTO extends AbstractDTO {

	private BugDTO bug1;

	private BugDTO bug2;

	private BugRelationEnum relation;

	public BugDTO getBug1() {
		return bug1;
	}

	public void setBug1(BugDTO bug1) {
		this.bug1 = bug1;
	}

	public BugDTO getBug2() {
		return bug2;
	}

	public void setBug2(BugDTO bug2) {
		this.bug2 = bug2;
	}

	public BugRelationEnum getRelation() {
		return relation;
	}

	public void setRelation(BugRelationEnum relation) {
		this.relation = relation;
	}

}
