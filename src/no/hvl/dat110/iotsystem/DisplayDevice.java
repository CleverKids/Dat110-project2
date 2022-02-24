package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import static no.hvl.dat110.iotsystem.Common.*;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		// TODO - START
		
		Client client = new Client("Disply device", BROKERHOST, BROKERPORT);
		client.connect();
		client.createTopic(TEMPTOPIC);
		client.subscribe(TEMPTOPIC);
		for (int i =0; i<COUNT; i++) {
			PublishMsg msg = (PublishMsg) client.receive();
			System.out.println(msg.toString());
		}
		client.unsubscribe(TEMPTOPIC);
		client.disconnect();
		
		
		// create a client object and use it to
		
		// - connect to the broker - use "display" as the username
		// - create the temperature topic on the broker
		// - subscribe to the topic
		// - receive messages on the topic
		// - unsubscribe from the topic
		// - disconnect from the broker
		
		// TODO - END
		
		System.out.println("Display stopping ... ");
		
		
	}
}
