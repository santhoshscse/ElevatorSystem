package com.treebo.elevator;

public class ElevatorSystemFactory {
	public static ElevatorSystemImpl getElevator() {
		return new ElevatorSystemImpl();
	}
}
