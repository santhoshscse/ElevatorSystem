package com.treebo.elevator.model;

public class Person {
	private int weight;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [weight=");
		builder.append(weight);
		builder.append("]");
		return builder.toString();
	}

}
