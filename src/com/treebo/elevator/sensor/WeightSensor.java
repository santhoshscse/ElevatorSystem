package com.treebo.elevator.sensor;

import com.treebo.elevator.model.SensorType;

public class WeightSensor implements Sensor {

	@Override
	public String getInfo() {
		return "";
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public SensorType getType() {
		return SensorType.Weight;
	}
}
