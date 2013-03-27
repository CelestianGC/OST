package org.ost.main.MyClasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;

import org.ost.main.MyUtils.SimpleDialog;
import org.ost.main.MyUtils.XMLControl;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
/**
 * 
 * @author Celestian
 *
 */
public class XMLManage {

	public Object listObject;
	
	public String fileName;
	
	public Class list;
	public String listAlias;

	public Class data;
	public String dataAlias;
	
	public ArrayList<String> omitFields;

	public ArrayList<AliasClass> aliasFields;

	public XMLManage(Object listObject, String fileName, Class list,
			String listAlias, Class data, String dataAlias,
			ArrayList<String> omitFields) {
		super();
		this.listObject = listObject;
		this.fileName = fileName;
		this.list = list;
		this.listAlias = listAlias;
		this.data = data;
		this.dataAlias = dataAlias;
		this.omitFields = omitFields;
	}

	/**
	 * 
	 * @author Celestian
	 *
	 */
	class AliasClass {
		private Class theClass;
		private String theAlias;
		
		public AliasClass(Class theClass, String theAlias) {
			super();
			this.theClass = theClass;
			this.theAlias = theAlias;
		}
		/**
		 * @return the theClass
		 */
		public Class getTheClass() {
			return theClass;
		}
		/**
		 * @param theClass the theClass to set
		 */
		public void setTheClass(Class theClass) {
			this.theClass = theClass;
		}
		/**
		 * @return the theAlias
		 */
		public String getTheAlias() {
			return theAlias;
		}
		/**
		 * @param theAlias the theAlias to set
		 */
		public void setTheAlias(String theAlias) {
			this.theAlias = theAlias;
		}
		
	}
	
	
	/**
	 * @return the aliasFields
	 */
	public ArrayList<AliasClass> getAliasFields() {
		return aliasFields;
	}

	/**
	 * @param aliasFields the aliasFields to set
	 */
	public void setAliasFields(ArrayList<AliasClass> aliasFields) {
		this.aliasFields = aliasFields;
	}

	/**
	 * @return the listObject
	 */
	public Object getListObject() {
		return listObject;
	}

	/**
	 * @param listObject the listObject to set
	 */
	public void setListObject(Object listObject) {
		this.listObject = listObject;
	}

	/**
	 * @return the omitFields
	 */
	public ArrayList<String> getOmitFields() {
		return omitFields;
	}

	/**
	 * @param omitFields the omitFields to set
	 */
	public void setOmitFields(ArrayList<String> omitFields) {
		this.omitFields = omitFields;
	}


	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the list
	 */
	public Class getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(Class list) {
		this.list = list;
	}

	/**
	 * @return the listAlias
	 */
	public String getListAlias() {
		return listAlias;
	}

	/**
	 * @param listAlias the listAlias to set
	 */
	public void setListAlias(String listAlias) {
		this.listAlias = listAlias;
	}

	/**
	 * @return the data
	 */
	public Class getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Class data) {
		this.data = data;
	}

	/**
	 * @return the dataAlias
	 */
	public String getDataAlias() {
		return dataAlias;
	}

	/**
	 * @param dataAlias the dataAlias to set
	 */
	public void setDataAlias(String dataAlias) {
		this.dataAlias = dataAlias;
	}

	/**
	 * generate XML file from struct
	 * 
	 * @param fileName
	 * @param aList
	 */
	public void serializeToXMLFile() {
		XStream xs = new XStream(new DomDriver("UTF-8"));
		xs.alias(getListAlias(), getList());
		xs.alias(getDataAlias(), getData());
		xs.addImplicitCollection(getList(), getListAlias());

		// omit this struct
		xs.omitField(getList(), "xm");
		
		if (getOmitFields() != null)
			for (String omit: getOmitFields())
				xs.omitField(getData(), omit);

		if (getAliasFields() != null)
			for (AliasClass oA: getAliasFields())
				xs.alias(oA.getTheAlias(),oA.getTheClass());

		try {
			FileOutputStream fs = new FileOutputStream(getFileName());
			xs.toXML(getListObject(),fs);
		} catch (Exception e) {
			SimpleDialog.showError(e.getLocalizedMessage()+":error in serializeListToXMLFile");
		}
	}
	/**
	 * return list of objects from XML
	 * 
	 * @param fileName
	 * @return
	 */
	public void deserializeFromXMLFile() {
		XStream xs = new XStream(new DomDriver("UTF-8"));
		xs.alias(getListAlias(), getList());
		xs.alias(getDataAlias(), getData());
		xs.addImplicitCollection(getList(), getListAlias());

		// omit this struct
		xs.omitField(getList(), "xm");

		if (getOmitFields() != null)
			for (String omit: getOmitFields())
				xs.omitField(getData(), omit);
		if (getAliasFields() != null)
			for (AliasClass oA: getAliasFields())
				xs.alias(oA.getTheAlias(),oA.getTheClass());

		try {
			FileInputStream fis = new FileInputStream(getFileName());
			xs.fromXML(new InputStreamReader(fis), getListObject());
		} catch (Exception e) {
			SimpleDialog.showError(e.getLocalizedMessage()+":error in deserializeFromXMLFile");
		}
	}

	/**
	 * return XML String from struct
	 * 
	 * @param fileName
	 * @param aList
	 */
	public String serializeToXML() {
		String resultXML = null;
		XStream xs = new XStream();
		xs.alias(getListAlias(), getList());
		xs.alias(getDataAlias(), getData());
		xs.addImplicitCollection(getList(), getListAlias());

		// omit this struct
		xs.omitField(getList(), "xm");
		
		if (getOmitFields() != null)
			for (String omit: getOmitFields())
				xs.omitField(getData(), omit);
		if (getAliasFields() != null)
			for (AliasClass oA: getAliasFields())
				xs.alias(oA.getTheAlias(),oA.getTheClass());

		try {
			resultXML = xs.toXML(getListObject());
		} catch (Exception e) {
			SimpleDialog.showError(e.getLocalizedMessage()+":error in serializeListToXML");
		}
		
		return resultXML;
	}
	/**
	 * return list of objects from XML text
	 * 
	 * @param fileName
	 * @return
	 */
	public void deserializeFromXML(String textXML) {
		XStream xs = new XStream(new DomDriver());
		xs.alias(getListAlias(), getList());
		xs.alias(getDataAlias(), getData());
		xs.addImplicitCollection(getList(), getListAlias());

		// omit this struct
		xs.omitField(getList(), "xm");

		if (getOmitFields() != null)
			for (String omit: getOmitFields())
				xs.omitField(getData(), omit);
		if (getAliasFields() != null)
			for (AliasClass oA: getAliasFields())
				xs.alias(oA.getTheAlias(),oA.getTheClass());

		try {
			xs.fromXML(textXML, getListObject());
		} catch (Exception e) {
			SimpleDialog.showError(e.getLocalizedMessage()+":error in deserializeFromXML");
		}
	}

	/** 
	 * return xml string of object
	 * @param obj
	 * @return
	 */
	public String getSerialXML(Object obj) {
		XStream xs = new XStream();
		xs.alias(getListAlias(), getList());
		xs.alias(getDataAlias(), getData());
		// omit this struct
		xs.omitField(getList(), "xm");

		if (getOmitFields() != null)
			for (String omit: getOmitFields())
				xs.omitField(getData(), omit);
		if (getAliasFields() != null)
			for (AliasClass oA: getAliasFields())
				xs.alias(oA.getTheAlias(),oA.getTheClass());

		return(xs.toXML(obj));
	}

	/**
	 * return object from xml string
	 * 
	 * @param xml
	 * @return
	 */
	public Object getDeserializeXML(String xml) {
		XStream xs = new XStream();
		xs.alias(getListAlias(), getList());
		xs.alias(getDataAlias(), getData());
		// omit this struct
		xs.omitField(getList(), "xm");

		if (getOmitFields() != null)
			for (String omit: getOmitFields())
				xs.omitField(getData(), omit);
		if (getAliasFields() != null)
			for (AliasClass oA: getAliasFields())
				xs.alias(oA.getTheAlias(),oA.getTheClass());

		return(xs.fromXML(xml));
	}

}
