package com.treebo.elevator.test;

import com.treebo.elevator.ElevatorSystem;
import com.treebo.elevator.ElevatorSystemFactory;
import com.treebo.elevator.model.Person;

public class ElevatorSystemTest {
	public static void main(String[] args) {
		ElevatorSystem elevatorSystem = ElevatorSystemFactory.getElevator();

		elevatorSystem.open();
		Person p = new Person();
		p.setWeight(50);
		
		//starting with person
		elevatorSystem.enter(p);
		elevatorSystem.display();
		elevatorSystem.press(p, 2);
		elevatorSystem.start();
		elevatorSystem.exit(p);
		elevatorSystem.display();
		
		
		//starting without anybody
		elevatorSystem.start();
		elevatorSystem.display();
		
		elevatorSystem.enter(p);
		elevatorSystem.display();
		elevatorSystem.press(p, 1);
		elevatorSystem.start();
		elevatorSystem.display();
	}
}
