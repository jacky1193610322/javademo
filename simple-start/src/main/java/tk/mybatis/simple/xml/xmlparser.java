/*
 * Fabric4cloud.com Inc.
 * Copyright (c) 2015-2018 All Rights Reserved.
 */
package tk.mybatis.simple.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @author jacky
 * @version $Id: xmlparser.java, v 0.1 2018-07-10 14:23:20 jacky Exp $
 */
public class xmlparser {
    public static void main(String[] args) throws Exception {

        try {
            ClassLoader classLoader = xmlparser.class.getClassLoader();
            File xmlFile = new File(classLoader.getResource("tk/mybatis/simple/mapper/test.xml").getFile());

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = builderFactory.newDocumentBuilder();

            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root  element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("mapper");
            System.out.println(nList.getLength());
            for (int i = 0; i < nList.getLength(); i++) {
                printNode(nList.item(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printNode(Node node) {
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {

            Node cNode = children.item(i);

            System.out.println("Node name: " + cNode.getNodeName());
            System.out.println("----------------------------");
            System.out.println(cNode.getNodeType());
            //Element element = (Element) cNode;

            if (cNode.getNodeType() == Node.ELEMENT_NODE) {
                printNode(cNode);
            } else if (cNode.getNodeType() == Node.TEXT_NODE) {
                System.out.println("text content");
                System.out.println(cNode.getTextContent());
            }
        }
    }
}