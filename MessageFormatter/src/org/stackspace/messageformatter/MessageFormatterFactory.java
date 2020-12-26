package org.stackspace.messageformatter;

public class MessageFormatterFactory {

	public static MessageFormatter getObject(String type) {
		if (type.equalsIgnoreCase("Pdf")) {
			return new PdfFormatter();
		} else if (type.equalsIgnoreCase("excel")) {
			return new ExcelFormatter();
		}

		return null;
	}
}
