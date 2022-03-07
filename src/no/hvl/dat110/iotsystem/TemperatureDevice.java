package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

import static no.hvl.dat110.iotsystem.Common.BROKERHOST;
import static no.hvl.dat110.iotsystem.Common.BROKERPORT;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start
		// create a client object and use it to
		Client client = new Client("Tempratur device", BROKERHOST, BROKERPORT);
		// - connect to the broker - user "sensor" as the user name
		client.connect();
		// - publish the temperature(s)
		for(int i = 0; i<COUNT; i++) {
			int temp = sn.read();
			client.publish(Common.TEMPTOPIC, "Temperature is: " + temp);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// - disconnect from the broker
		client.disconnect();
		// TODO - end

		System.out.println("Temperature device stopping ... ");


	}
}
