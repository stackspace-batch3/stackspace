package org.stackspace.springcore;

import org.springframework.stereotype.Repository;

@Repository
public class WordFormatter implements MessageFormatter {

	public void write() {
		System.out.println("Write to Word");

	}

	public void print() {
		System.out.println("Print to Word");

	}

}
