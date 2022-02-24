package no.hvl.dat110.messages;

import no.hvl.dat110.common.TODO;

import static no.hvl.dat110.messages.MessageType.PUBLISH;

public class PublishMsg extends Message {
	
	// message sent from client to create publish a message on a topic 

	// TODO:
	// Implement object variables - a topic and a message is required
	private String topic;
	private String message;
	
	
	public PublishMsg(String topic, String message, String user) {
		super(PUBLISH, user);
		this.topic = topic;
		this.message = message;
	}


	// Constructor, get/set-methods, and toString method
	// as described in the project text
	
	public String getTopic() {
		return topic;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "PublishMsg " + super.toString() + "topic= " + topic + "message= " + message;
	}


	public String getMessage() {
		
		return this.message;
	}
}
