package com.treebo.elevator;

import com.treebo.elevator.handler.ElevatorHandler;
import com.treebo.elevator.model.Person;

class ElevatorSystemImpl implements ElevatorSystem {

	@Override
	public void open() {
		ElevatorHandler.getInstance().open();
	}

	@Override
	public void close() {
		ElevatorHandler.getInstance().close();

	}

	@Override
	public void enter(Person p) {
		ElevatorHandler.getInstance().enter(p);

	}

	@Override
	public void exit(Person p) {
		ElevatorHandler.getInstance().exit(p);
	}

	@Override
	public void press(Person p, int floorNo) {
		ElevatorHandler.getInstance().press(p, floorNo);
	}

	@Override
	public void alarm() {
		ElevatorHandler.getInstance().alarm();
	}

	@Override
	public void start() {
		ElevatorHandler.getInstance().start();
	}

	@Override
	public void display() {
		ElevatorHandler.getInstance().display();
	}

}
