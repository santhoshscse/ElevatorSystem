package com.treebo.elevator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Elevator {
	private int basementFloor;
	private int topFloor;
	private List<Person> personList;
	private HashMap<Person, Integer> floorMap;
	private int currentFloor;
	private boolean isUp;

	public Elevator(int basementFloor, int topFloor, int currentFloor) {
		this.basementFloor = basementFloor;
		this.currentFloor = currentFloor;
		this.topFloor = topFloor;
	}

	public int getBasementFloor() {
		return basementFloor;
	}

	public void setBasementFloor(int basementFloor) {
		this.basementFloor = basementFloor;
	}

	public int getTopFloor() {
		return topFloor;
	}

	public void setTopFloor(int topFloor) {
		this.topFloor = topFloor;
	}

	public HashMap<Person, Integer> getFloorMap() {
		return floorMap;
	}

	public void setFloorMap(HashMap<Person, Integer> floorMap) {
		this.floorMap = floorMap;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public void addPerson(Person p) {
		if (personList == null) {
			personList = new ArrayList<>();
		}
		personList.add(p);
	}

	public void setFloorList(HashMap<Person, Integer> floorList) {
		this.floorMap = floorList;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public boolean isUp() {
		return isUp;
	}

	public void setUp(boolean isUp) {
		this.isUp = isUp;
	}

	public void removePerson(Person p) {
		personList.remove(p);
		floorMap.remove(p);
	}

	public void addFloorOption(Person p, int floorNo) {
		if (floorMap == null) {
			floorMap = new HashMap<>();
		}
		if (floorMap.isEmpty()) {
			if (floorNo > currentFloor) {
				isUp = true;
			} else {
				isUp = false;
			}
		}
		floorMap.put(p, floorNo);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Elevator [personList=");
		builder.append(personList);
		builder.append(", floorList=");
		builder.append(floorMap);
		builder.append(", currentFloor=");
		builder.append(currentFloor);
		builder.append(", isUp=");
		builder.append(isUp);
		builder.append("]");
		return builder.toString();
	}

}
