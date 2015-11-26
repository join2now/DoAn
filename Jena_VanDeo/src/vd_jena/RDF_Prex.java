package vd_jena;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

public class RDF_Prex {

	public static void main(String[] args) {
		//MOT SO DINH NGHIA
				String personURI =  "http://vandeo_web/person#";
				String fullName = "Duong Van Deo";
				String givenName = "Duong";
				String familyName = "Van Deo";
		//TAO Model
				Model model = ModelFactory.createDefaultModel();
		//Tao resource
				Resource vandeo = model.createResource(personURI + "vandeo");
				Property fName = model.createProperty(personURI + "fName");
				
	}

}
