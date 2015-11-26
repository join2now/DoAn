package vd_jena;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.VCARD;

public class RDF_K24_VD {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//DINH NGHIA
		String personURI =  "http://vandeo_web/johnsmith";
		String giveName = "John";
		String familyName = "Smith";
		String fullName = giveName + " " + familyName;
		//TAO MOT Model rong
		Model model = ModelFactory.createDefaultModel();
		//TAO MOT resource
		 model.createResource(personURI)
				.addProperty(VCARD.FN,fullName)
				.addProperty(VCARD.N, model.createResource()
						.addProperty(VCARD.Given, giveName)
						.addProperty(VCARD.Family, familyName)
						)
				.addProperty(VCARD.EMAIL, "dvdeoit@gmail.com")
				.addProperty(VCARD.TEL, model.createResource()
						.addProperty(VCARD.TEL, "0915597407")
						);
		model.write(System.out );
		OutputStream out = new FileOutputStream("RDF_PERSON.rdf");
		model.write(out);
		
	}

}
