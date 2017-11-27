package com.treebo.elevator.handler;

import com.treebo.elevator.model.AlarmType;

public class AlarmHandler {

	private static AlarmHandler handler = new AlarmHandler();

	public static AlarmHandler getInstance() {
		return handler;
	}

	public void makeAlarm(AlarmType type) {
		System.out.println("Make alaram of type " + type);
	}
}
