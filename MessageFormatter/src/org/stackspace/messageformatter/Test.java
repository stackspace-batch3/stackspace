package org.stackspace.messageformatter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Test {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		/*
		 * ExcelFormatter excelFormatter=new ExcelFormatter(); excelFormatter.write();
		 * excelFormatter.print();
		 */

		/*
		 * PdfFormatter pdfFormatter=new PdfFormatter(); pdfFormatter.write();
		 * pdfFormatter.print();
		 */

		Properties properties = new Properties();
		properties.load(new FileInputStream(new File("application.properties")));

		String target = (String) properties.get("target");

		MessageFormatter formatter = MessageFormatterFactory.getObject(target);
		formatter.write();
		formatter.print();
	}
}
