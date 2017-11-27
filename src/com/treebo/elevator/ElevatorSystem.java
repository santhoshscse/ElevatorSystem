package com.treebo.elevator;

import com.treebo.elevator.model.Person;

public interface ElevatorSystem {
	public void open();

	public void close();

	public void enter(Person p);

	public void exit(Person p);

	public void press(Person p, int floorNo);

	public void alarm();
	
	public void start();
	
	public void display();
}
