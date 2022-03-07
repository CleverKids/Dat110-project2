package no.hvl.dat110.messages;

import static no.hvl.dat110.messages.MessageType.CREATETOPIC;

public class CreateTopicMsg extends Message {
	
	// message sent from client to create topic on the broker
	
	// TODO: 
	// Implement object variables - a topic is required
	private String topic;

	public CreateTopicMsg( String user,String topic) {

		super(CREATETOPIC, user);
		this.topic = topic;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "CreateTopicMsg " + super.toString() + "topic= " + topic;
	}
	
	
	// Constructor, get/set-methods, and toString method
    // as described in the project text	
}
