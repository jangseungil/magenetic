/**
 * 
 */
package com.magnetic.myapp.main.service.impl;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.magnetic.myapp.main.service.MainService;
import com.magnetic.myapp.main.vo.MainVo;

/**
 * @author Administrator
 *
 */
@Service
public class MainServiceImpl implements MainService{

	public MainVo aaaa() {
		MainVo mainVo = new MainVo();
		try {
			File file = new File("d:/workspace/magnetic/src/main/webapp/WEB-INF/xml/contents.xml");
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			
			System.out.println("Root element = " + doc.getDocumentElement().getNodeName());
			NodeList headNodeList = doc.getElementsByTagName("user");
			
			
			for(int i=0; i<headNodeList.getLength(); i++) {
				MainVo mainVoNode = new MainVo();
				Node headNode = headNodeList.item(i);
				
				if(headNode.getNodeType() == Node.ELEMENT_NODE) {
					Element headLineElement = (Element)headNode;
					
					NodeList nameElement = headLineElement.getElementsByTagName("name");
					Element subItem = (Element)nameElement.item(0);
					NodeList subElement1 = subItem.getChildNodes();
					
					NodeList contentElement = headLineElement.getElementsByTagName("content");
					subItem = (Element)contentElement.item(0);
					NodeList subElement2 = subItem.getChildNodes();
					
					mainVoNode.setName(subElement1.item(0).getNodeValue());
					mainVoNode.setContent(subElement2.item(0).getNodeValue());
					//mainVo.getMainVoList().add(mainVoNode);
				}
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		
		return mainVo;
	}

}
