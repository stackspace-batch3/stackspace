package org.stackspace.messageformatter.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.stackspace.messageformatter.interfaces.MessageFormatter;
import org.stackspace.messageformatter.service.ExcelFormatter;
import org.stackspace.messageformatter.service.PdfFormatter;
import org.stackspace.messageformatter.service.WordFormatter;

public class ObjectFactory {

	public static MessageFormatter getObject() throws Exception {

		Properties properties = new Properties();

		properties.load(new FileInputStream(new File("target.properties")));

		String classType = (String) properties.get("target");

		Class<?> clazz = Class.forName(classType);

		Object newInstance = clazz.newInstance();

		return (MessageFormatter) newInstance;
	}
}
