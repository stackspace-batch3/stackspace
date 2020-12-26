package org.stackspace.messageformatter.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.stackspace.messageformatter.interfaces.MessageFormatter;
import org.stackspace.messageformatter.util.MessageFormatterCreater;

public class MessageFormatterTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		/*ExcelFormatter excelFormatter=new ExcelFormatter();
		excelFormatter.write();
		excelFormatter.print();*/
		
		/*PdfFormatter pdfFormatter=new PdfFormatter();
		pdfFormatter.write();
		pdfFormatter.print();*/
		
		/*MessageFormatter formatter=new PdfFormatter();
		formatter.write();
		formatter.print();*/
						
		MessageFormatter formatter = MessageFormatterCreater.create();
		formatter.write();
		formatter.print();
	}
}
