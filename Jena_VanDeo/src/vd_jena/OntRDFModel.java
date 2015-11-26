package vd_jena;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.Ontology;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class OntRDFModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Tao mot ontology model mac dinh
		OntModel ontModel = ModelFactory.createOntologyModel();
		String ns =  new String ("http://www.example.com/onto1#");
		String baseURI = new String ("http://www.example.com/onto1");
		Ontology onto = ontModel.createOntology(baseURI);
		//tao lop 'person', 'MalePerson' va 'FemalePerson'
		OntClass person = ontModel.createClass(ns + "Person");
		OntClass malePerson = ontModel.createClass(ns + "MalePerson");
		OntClass femalePerson = ontModel.createClass(ns + "FemalePerson");
		//FemalePerson va MalePerson la lop con cua Person
		person.addSubClass(malePerson);
		person.addDisjointWith(malePerson);
		 
		ontModel.write(System.out);
	}

}
