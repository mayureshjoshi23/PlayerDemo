package com.bwellthy.player;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "statements")
@XmlAccessorType (XmlAccessType.FIELD)
public class Statements {
	@XmlElement(name = "statement")
	ArrayList<Statement> statement = new ArrayList<>();

	public ArrayList<Statement> getStatement() {
		return statement;
	}

	public void setStatement(ArrayList<Statement> statement) {
		this.statement = statement;
	}
}
