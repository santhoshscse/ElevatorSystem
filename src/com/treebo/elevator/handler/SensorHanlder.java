package com.treebo.elevator.handler;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.treebo.elevator.model.AlarmType;
import com.treebo.elevator.model.SensorType;
import com.treebo.elevator.sensor.FireSensor;
import com.treebo.elevator.sensor.Sensor;
import com.treebo.elevator.sensor.WeightSensor;

public class SensorHanlder {
	private static SensorHanlder handler = new SensorHanlder();
	private HashMap<SensorType, Sensor> sensorList = new HashMap<>();
	private ExecutorService pool = Executors.newCachedThreadPool();

	public static SensorHanlder getInstance() {
		return handler;
	}

	public void register(Sensor s) {
		sensorList.put(s.getType(), s);
	}

	private SensorHanlder() {
		register(new FireSensor());
		register(new WeightSensor());
		startObservingSensors();
	}

	private void startObservingSensors() {

		pool.submit(new Runnable() {

			@Override
			public void run() {
				for (SensorType s : sensorList.keySet()) {
//					feedSensorInput(s, sensorList.get(s).getInfo());
				}
			}
		});

	}

	public void notifySensor(SensorType sensorType) {
		pool.submit(new Runnable() {

			private SensorType type;

			public Runnable init(SensorType type) {
				this.type = type;
				return this;
			}

			@Override
			public void run() {
//				feedSensorInput(type, sensorList.get(type).getInfo());
			}
		}.init(sensorType));
	}

	protected void feedSensorInput(SensorType type, String info) {
		switch (type) {
		case Fire:
			AlarmHandler.getInstance().makeAlarm(AlarmType.Smoke);
			break;
		case Weight:
			AlarmHandler.getInstance().makeAlarm(AlarmType.Weight);
			break;
		}
	}

}
