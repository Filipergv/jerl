package com.objects;

import java.util.ArrayList;

public class ObjectCode {

	private ArrayList<Object> contents;

	public ObjectCode() {
		contents = new ArrayList<Object>();
	}

	public ArrayList<Object> getContents() {
		return contents;
	}

	public void setContents(ArrayList<Object> contents) {
		this.contents = contents;
	}
}