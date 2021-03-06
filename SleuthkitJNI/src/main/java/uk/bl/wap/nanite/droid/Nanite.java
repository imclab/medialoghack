/**
 * 
 */
package uk.bl.wap.nanite.droid;

import java.io.File;
import java.io.IOException;
import javax.activation.MimeTypeParseException;

import org.apache.commons.configuration.ConfigurationException;
import uk.gov.nationalarchives.droid.core.SignatureParseException;
import uk.gov.nationalarchives.droid.core.interfaces.signature.SignatureFileException;
import uk.gov.nationalarchives.droid.core.interfaces.signature.SignatureManagerException;

/**
 * 
 
 */
public class Nanite {

	DroidBinarySignatureDetector nan = null;
	
	public Nanite(String fname) throws IOException, SignatureFileException, SignatureParseException, ConfigurationException {
		nan = new DroidBinarySignatureDetector();
        File file = new File(fname);
        System.out.println("\t\tNANITE: " + nan.getMimeType(file));

	}

	/**
	 * @param args
	 * @throws java.io.IOException
	 * @throws uk.gov.nationalarchives.droid.core.interfaces.signature.SignatureManagerException
	 * @throws org.apache.commons.configuration.ConfigurationException
	 * @throws uk.gov.nationalarchives.droid.core.interfaces.signature.SignatureFileException
	 * @throws javax.activation.MimeTypeParseException
	 * @throws uk.gov.nationalarchives.droid.core.SignatureParseException
	 */
	public static void main(String[] args) throws IOException, SignatureManagerException, ConfigurationException, SignatureFileException, MimeTypeParseException, SignatureParseException {
		DroidBinarySignatureDetector nan = new DroidBinarySignatureDetector();
		for( String fname : args ) {
			File file = new File(fname);
			System.out.println("File: "+fname);
			System.out.println("Nanite using DROID binary signature file version "+nan.getBinarySigFileVersion());
			System.out.println("Result: " + nan.getMimeType(file));
			System.out.println("----");
		}
	}

	/**
	 * @param payload
	 * @return
	 */
	public String identify(byte[] payload) {
		return nan.identify(payload);
	}	

}
