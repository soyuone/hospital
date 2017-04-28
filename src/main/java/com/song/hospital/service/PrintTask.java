package com.song.hospital.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrintTask implements Runnable {

	String name;

	public PrintTask(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + " is running.");
		try {
			Thread.sleep(5000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " is running again.");
	}

}
