package org.univ.project.rdf;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.Rio;
import org.openrdf.rio.helpers.RDFHandlerBase;

public final class RDFRawParser {

	private static class RDFListener extends RDFHandlerBase {
		
		String tuple;
		
		@Override
		public void handleStatement(Statement st) {
			System.out.println("------------------ avant ------------");
			System.out.println("\n" + st.getSubject() + "\t " + st.getPredicate() + "\t "
					+ st.getObject());
			System.out.println("------------ apres -----------------------");
		  
		    
		    //tuple=  st.getSubject() + "\t " + st.getPredicate() + "\t "+ st.getObject();
		    		
		}
		
		public String getTuple(){
			
			return "--------------------------------------"+tuple;
		}

	};
	
		public static void parseRDF(String path) throws FileNotFoundException {
			
			Reader reader = new FileReader(path);

			org.openrdf.rio.RDFParser rdfParser = Rio.createParser(RDFFormat.RDFXML);
			
			rdfParser.setRDFHandler(new RDFListener());
			
			try {
								
				rdfParser.parse(reader, "");
				
				
			} catch (Exception e) {
				System.out.println("Erreur de parsing \t"+e.getMessage());
			}

			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("Fichier introuvable \t"+e.getMessage());
			}
			
		}


}