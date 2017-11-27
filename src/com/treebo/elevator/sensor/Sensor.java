package com.treebo.elevator.sensor;

import com.treebo.elevator.model.SensorType;

public interface Sensor {
	String getInfo();

	void start();

	SensorType getType();
}
