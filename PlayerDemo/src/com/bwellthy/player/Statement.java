package com.bwellthy.player;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class Statement {
	@XmlElement
	Statements statements;
	
	@XmlAttribute
	String msg;
	
	

	@XmlAttribute
	String type;
	
	public static void main(String[] args) {
		try {
			Statement statement = new Statement();
			statement.msg = "Hi";
			statement.type = "plain";
			statement.statements = new Statements();
			
			Statement statement1 = new Statement();
			statement1.msg = "How are you?";
			statement1.type = "choice";
			statement1.statements  = new Statements();
			statement.statements.getStatement().add(statement1);
			
			Statement statement2 = new Statement();
			statement2.msg = "Fine";
			statement2.type = "plain";
			statement1.statements.getStatement().add(statement2);
			
			print(statement);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public static void print(Object obj) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		m.marshal(obj, System.out);
	}
}
