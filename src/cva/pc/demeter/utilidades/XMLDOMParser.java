package cva.pc.demeter.utilidades;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLDOMParser {
	private File xmlFile = null;
	private Document docXMLFile = null;

	public XMLDOMParser(File xmlFile) {
		super();
		this.xmlFile = xmlFile;
	}

	public XMLDOMParser(String xmlFilePath) {
		super();
		try {
			this.xmlFile = new File(xmlFilePath);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public Document parseXMLFile() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			docXMLFile = db.parse(xmlFile);
			docXMLFile.getDocumentElement().normalize();
			return docXMLFile;
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Node getRootNode() {
		return docXMLFile.getDocumentElement();
	}

	public NodeList getNodesByTagName(String tag) {
		return docXMLFile.getElementsByTagName(tag);
	}

	public Node getSearchedNode(NodeList nodes, String tagSearched, String value) {
		if (nodes == null && nodes.getLength() <= 0) {
			System.out.println("El Elemento " + tagSearched
					+ " no existe en el Documento.");
		} else {
			for (int i = 0; i < nodes.getLength(); i++) {
				Node nodoActual = nodes.item(i);
				if (nodoActual.getNodeType() == Node.ELEMENT_NODE) {
					NodeList nodosHijos = nodoActual.getChildNodes();
					for (int i2 = 0; i2 < nodosHijos.getLength(); i2++) {
						Node nodoHijo = nodosHijos.item(i2);
						// Busqueda
						if (nodoHijo.getNodeName().equals(tagSearched)
								&& nodoHijo.getTextContent().equals(value)) {
							System.out.println(nodoHijo.getNodeName() + "= "
									+ nodoHijo.getTextContent());
							return nodoHijo.getParentNode();
						}
					}
				}
			}
		}
		return null;
	}

	public String getTextValue(Node nodo, String tag) {
		NodeList nodosHijos = nodo.getChildNodes();
		for (int i = 0; i < nodosHijos.getLength(); i++) {
			Node nodoHijo = nodosHijos.item(i);
			if (nodoHijo.getNodeName().equals(tag)) {
				System.out.println(nodoHijo.getNodeName() + "= "
						+ nodoHijo.getTextContent());
				return nodoHijo.getTextContent();
			}
		}
		return null;
	}

	public File getXmlFile() {
		return xmlFile;
	}

	public void setXmlFile(File xmlFile) {
		this.xmlFile = xmlFile;
	}

	public Document getDocXMLFile() {
		return docXMLFile;
	}

	public void setDocXMLFile(Document docXMLFile) {
		this.docXMLFile = docXMLFile;
	}

}
