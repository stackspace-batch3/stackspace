package org.stackspace.messageformatter.service;

import org.stackspace.messageformatter.interfaces.MessageFormatter;

public class ExcelFormatter implements MessageFormatter{

	public void write() {
		System.out.println("Write to EXCEL");
	}
	public void print() {
		System.out.println("Print to EXCEL");
	}
}
