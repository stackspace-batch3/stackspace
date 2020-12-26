package org.statckspace.springmessagebeans;

import org.springframework.stereotype.Service;

@Service
public class PdfFormatter implements MessageFormatter {

	public void write() {
		System.out.println("Write to PDF");
	}

	public void print() {
		System.out.println("Print to PDF");
	}

}
