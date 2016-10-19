package com.company.app.service;

import lombok.Data;

@Data
public class VersionPrinter {
	private int majorVersion;
	private int minorVersion;

	public void print() {
		System.out.println("MajorV:" + majorVersion + " minorV:" + minorVersion);
	}
}
