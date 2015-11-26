package vd_jena;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.VCARD;

public class HelloRDFWorld {
	//some definitions
	 static final String personURI = "http://somewhere/JohnSmith";
	 
	 //thêm một vài thuộc tính khác
	 static final String giveName = "John";
	 static final String familyName = "Smith";
	 static final String fullName = giveName + " " +familyName;
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
				//create an empty Model- tao mot RDF model
				Model m = ModelFactory.createDefaultModel();
				//create the resource
				Resource johnSmith = m.createResource(personURI);
//						.addProperty(VCARD.FN, fullName)
//						.addProperty(VCARD.N, m.createResource()
//								.addProperty(VCARD.Given, giveName)
//								.addProperty(VCARD.Family, familyName));
				//add the property
				johnSmith.addProperty(VCARD.FN, fullName);
				m.write(System.out);
				
		//Statement
				//danh sach statement trong m
				StmtIterator iter = m.listStatements();
				//in ra predicate, subject va object cua moi statement
				while(iter.hasNext()){
					Statement stmt = iter.nextStatement();
					Resource subject = stmt.getSubject();
					Property predicate = stmt.getPredicate();
					RDFNode object = stmt.getObject();
					System.out.println("Subject " + subject.toString());
					System.out.print("Predicate "+predicate.toString() + " ");
					if(object instanceof Resource){
						System.out.print("object " + object.toString());
					}else{
						//
						System.out.print("Literal \""+ object.toString() + "\"");
					}
					System.out.print(" .\n");
				}
		
	}

}
