package org.stackspace.messageformatter.test;

import org.stackspace.messageformatter.interfaces.MessageFormatter;
import org.stackspace.messageformatter.util.ObjectFactory;

public class MessageFormatterTest {

	public static void main(String[] args) throws Exception {

		/*ExcelFormatter excelFormatter=new ExcelFormatter();
		excelFormatter.write();
		excelFormatter.print();*/
		
		/*PdfFormatter pdfFormatter=new PdfFormatter();
		pdfFormatter.write();
		pdfFormatter.print();*/
		
		/*MessageFormatter formatter=new PdfFormatter();
		formatter.write();
		formatter.print();*/
						
		MessageFormatter formatter = ObjectFactory.getObject();
		formatter.write();
		formatter.print();
	}
}
