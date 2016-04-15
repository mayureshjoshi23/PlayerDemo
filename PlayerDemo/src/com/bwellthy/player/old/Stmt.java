package com.bwellthy.player.old;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Stmt {

	@XmlElement
	ArrayList<Stmt> stmt = new ArrayList<>();

	@XmlAttribute
	String msg;

	@XmlAttribute
	String type;

	@XmlAttribute
	String lbl;

	public static void print(Object obj) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		m.marshal(obj, System.out);
	}

	/*public static void main(String[] args) {
		try {
			Stmt statement = new Stmt();
			statement.msg = "Hi";
			statement.type = "plain";


			Stmt stmt1 = new Stmt();
			stmt1.msg = "How are you?";
			stmt1.type = "choice";
			statement.stmt.add(stmt1);

			Stmt stmt2 = new Stmt();
			stmt2.msg = "Good";
			stmt2.type = "plain";
			stmt2.lbl = "fine";
			stmt1.stmt.add(stmt2);


			Stmt stmt3 = new Stmt();
			stmt3.msg = "what happened";
			stmt3.type = "plain";
			stmt3.lbl = "not fine";
			stmt1.stmt.add(stmt3);

			print(statement);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}*/

	public static void main(String[] args) {
		//File file = new File("D:/DAYS_OF_WORK/20160123/stmt.txt"); 
		File file = new File("D:/DAYS_OF_WORK/20160304/20160304.xml"); 
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Stmt.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
			Stmt stmt= (Stmt) jaxbUnmarshaller.unmarshal(file);  
			System.out.println(stmt.toString());

			/*Jackson related code start*/
			

			/*Jackson related code start*/


			processStmt(stmt);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}



	private static void processStmt(Stmt stmt) {
		System.out.println(stmt.msg);
		for (Stmt stmtChild : stmt.stmt) {
			System.out.println(stmtChild.msg);
			if (stmtChild.type.equals("choice")) {
				String choice = "not fine";
				for(Stmt stmtForLbl: stmtChild.stmt) {
					System.out.println(stmtForLbl.lbl);
					if(stmtForLbl.lbl.equalsIgnoreCase(choice)){
						processStmt(stmtForLbl);
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Stmt [msg=" + msg + ", type=" + type + ", child=" + stmt + "]";
	}
}
