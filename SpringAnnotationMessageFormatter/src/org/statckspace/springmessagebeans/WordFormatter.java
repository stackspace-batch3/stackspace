package org.statckspace.springmessagebeans;

import org.springframework.stereotype.Repository;

@Repository
public class WordFormatter implements MessageFormatter {

	@Override
	public void write() {
		System.out.println("Write to Word");

	}

	@Override
	public void print() {
		System.out.println("Print to Word");

	}

}
