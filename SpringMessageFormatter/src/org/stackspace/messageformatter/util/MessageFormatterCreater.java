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

public class MessageFormatterCreater {

	public static MessageFormatter create() throws FileNotFoundException, IOException {

		Properties properties = new Properties();

		properties.load(new FileInputStream(new File("C:\\Users\\sri\\Videos\\target.properties")));

		String type = (String) properties.get("type");

		if (type.equalsIgnoreCase("pdf")) {
			return new PdfFormatter();
		} else if (type.equalsIgnoreCase("excel")) {
			return new ExcelFormatter();
		} else if(type.equals("word")){
			return new WordFormatter();
		}
		return null;
	}
}
