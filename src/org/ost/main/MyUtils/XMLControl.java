/**
 * XMLControl, save out XML Docs, read XML Docs.
 * 
 */
package org.ost.main.MyUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format.TextMode;
import org.jdom.output.XMLOutputter;

/**
 * @author Celestian
 *
 */
public class XMLControl {

	/**
	 * constructor
	 */
	public XMLControl(){
	}
	
	 /**
	   * unescape characters we escaped in XML
	   *
	   * @param sEscapeThis String
	   * @return String
	   */
	  public static String unEscapeChars(String sEscapeThis) {
	    if (sEscapeThis != null) {
	      sEscapeThis = sEscapeThis.replaceAll("\\\\n", "\n");
	      sEscapeThis = sEscapeThis.replaceAll("\\\\r", "\r");

	      sEscapeThis = sEscapeThis.replaceAll("\\&amp;","&");
	      sEscapeThis = sEscapeThis.replaceAll("\\&apos;","'");
	      sEscapeThis = sEscapeThis.replaceAll("\\&lt;","<");
	      sEscapeThis = sEscapeThis.replaceAll("\\&gt;",">");
	      sEscapeThis = sEscapeThis.replaceAll("\\&quot;","\"");
	    }

	    return sEscapeThis;
	  } // end unEscapeChars()
	  
	  /**
	   * fix escape characters for XML
	   *
	   * @param sEscapeThis String
	   * @return String
	   */
	  public static String escapeChars(String sEscapeThis) {
	    if (sEscapeThis != null) {
	      sEscapeThis = sEscapeThis.replaceAll("&", "\\&amp;");
	      sEscapeThis = sEscapeThis.replaceAll("'", "\\&apos;");
	      sEscapeThis = sEscapeThis.replaceAll("<", "\\&lt;");
	      sEscapeThis = sEscapeThis.replaceAll(">", "\\&gt;");
	      sEscapeThis = sEscapeThis.replaceAll("\"", "\\&quot;");
	      sEscapeThis = sEscapeThis.replaceAll("\n", "\\\\" + "n");
	      sEscapeThis = sEscapeThis.replaceAll("\r", "\\\\" + "r");
	    }

	    return sEscapeThis;
	  } // end escapeChars()

	  
	  /**
	   * Save document to sFilename
	   * @param doc
	   * @param sFileName
	   */
	  public static void saveDoc(Document doc, String sFileName) {
	    try {
	      FileOutputStream oOut = new FileOutputStream(sFileName);
	      XMLOutputter serializer = new XMLOutputter();
	      serializer.getFormat().setIndent("  ");
//	      serializer.getFormat().getTextMode();
	      serializer.getFormat().setTextMode(TextMode.NORMALIZE);
	      serializer.output(doc, oOut);
	      oOut.close();
	    }
	    catch (IOException err) {
	      SimpleDialog.showError("XMLControl.saveDoc() "+sFileName+" caused IOException\n"+err.getMessage()+"\n");
	    }

	  }// end saveDoc()
	  
	  /**
	   * load XML document and return as Document
	   * @param sFileName
	   * @return
	   */
	  public static Document loadDoc(String sFileName) {
	    Document doc = null;
	    try {
	      SAXBuilder builder = new SAXBuilder();
	      doc = builder.build(new URL("file:///" + sFileName));
	    }
	    catch (IOException err) {
	      //SimpleDialog.showError("XMLControl.loadDoc() "+sFileName+" caused IOException\n"+err.getMessage()+"\n");
	    }
	    catch (JDOMException err) {
	      //SimpleDialog.showError("XMLControl.loadDoc() "+ sFileName+" caused JDOMException\n"+err.getMessage()+"\n");
	    }

	    return doc;
	  } // end loadDoc();
	  
	  /**
	   * return document as a text string
	   * 
	   * @param doc
	   * @return
	   */
	  public static String getDocAsText(Document doc) {
		  String outputText = "";
		      XMLOutputter serializer = new XMLOutputter();
		      serializer.getFormat().setIndent("  ");
		      serializer.getFormat().setTextMode(TextMode.NORMALIZE);
		      outputText += serializer.outputString(doc);
		      return outputText;
		  }// end getDocAsText()


	  /**
	   * get Document from XML string
	   * 
	   * @param xmlString
	   * @return
	   */
	  public static Document loadDocFromXMLString(String xmlString) {
	    Document doc = null;
	    try {
	      SAXBuilder builder = new SAXBuilder();
	      doc = builder.build(new StringReader(xmlString));
	    }
	    catch (IOException err) {
	      SimpleDialog.showError("loadDocFromXMLString() caused IOException\n"+err.getMessage()+"\n");
	    }
	    catch (JDOMException err) {
	      SimpleDialog.showError("loadDocFromXMLString() caused JDOMException\n"+err.getMessage()+"\n");
	    }

	    return doc;
	  } // end loadDoc();

} // end XMLControl
