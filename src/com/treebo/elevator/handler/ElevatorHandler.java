package com.treebo.elevator.handler;

import java.util.Collection;
import java.util.Iterator;

import com.treebo.elevator.model.AlarmType;
import com.treebo.elevator.model.Elevator;
import com.treebo.elevator.model.Person;
import com.treebo.elevator.model.SensorType;

public class ElevatorHandler {
	private static ElevatorHandler handler = new ElevatorHandler();
	private Elevator elevator;

	public static ElevatorHandler getInstance() {
		return handler;
	}

	private ElevatorHandler() {
		elevator = new Elevator(0, 10, 0);
	}

	public void open() {
		System.out.println("Elevator door opens");
	}

	public void close() {
		System.out.println("Elevator door closes");
		System.out.println();
	}

	public void enter(Person p) {
		elevator.addPerson(p);
		SensorHanlder.getInstance().notifySensor(SensorType.Weight);
	}

	public void exit(Person p) {
		elevator.removePerson(p);
		SensorHanlder.getInstance().notifySensor(SensorType.Weight);
	}

	public void press(Person p, int floorNo) {
		elevator.addFloorOption(p, floorNo);
	}

	public void alarm() {
		AlarmHandler.getInstance().makeAlarm(AlarmType.Emergency);
	}

	public void display() {
		System.out.println(elevator);
	}

	public void start() {
		Collection<java.lang.Integer> floorList = elevator.getFloorMap().values();
		Iterator<java.lang.Integer> itr = floorList.iterator();
		int currentFloor = elevator.getCurrentFloor();

		if (elevator.isUp()) {
			while (itr.hasNext()) {
				int next = itr.next();
				if (next > currentFloor) {
					elevator.setCurrentFloor(next);
					System.out.println("Elevator moves up & stops at the floor" + next);
					break;
				}
			}
		} else {
			int prev = 0;
			while (itr.hasNext()) {
				int next = itr.next();
				if (next > currentFloor) {
					prev = next;
				} else {
					System.out.println("Elevator moves down & stops at the floor" + next);
					elevator.setCurrentFloor(prev);
					break;
				}
			}

		}

		int newCurrentFloor = elevator.getCurrentFloor();
		if (currentFloor == newCurrentFloor) {
			System.out.println("No need to move");
		}
	}

}
