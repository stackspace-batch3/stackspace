package org.stackspace.messageformatter.service;

import org.stackspace.messageformatter.interfaces.MessageFormatter;

public class PdfFormatter implements MessageFormatter {

	public void write() {
		System.out.println("Write to PDF");
	}

	public void print() {
		System.out.println("Print to PDF");
	}

}
