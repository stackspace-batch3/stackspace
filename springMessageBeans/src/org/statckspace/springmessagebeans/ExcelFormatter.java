package org.statckspace.springmessagebeans;

public class ExcelFormatter implements MessageFormatter {

	public void write() {
		System.out.println("Write to EXCEL");
	}

	public void print() {
		System.out.println("Print to EXCEL");
	}
}
