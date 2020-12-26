package org.statckspace.springmessagebeans;

public class PdfFormatter implements MessageFormatter {

	public void write() {
		System.out.println("Write to PDF");
	}

	public void print() {
		System.out.println("Print to PDF");
	}

}
