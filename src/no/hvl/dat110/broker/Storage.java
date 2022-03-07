package no.hvl.dat110.broker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messagetransport.Connection;

public class Storage {

	// data structure for managing subscriptions
	// maps from a topic to set of subscribed users
	protected ConcurrentHashMap<String, Set<String>> subscriptions;
	
	// data structure for managing currently connected clients
	// maps from user to corresponding client session object
	
	protected ConcurrentHashMap<String, ClientSession> clients;

	protected ConcurrentHashMap<String, List<Message>> messageBuffer;

	public Storage() {
		subscriptions = new ConcurrentHashMap<String, Set<String>>();
		clients = new ConcurrentHashMap<String, ClientSession>();
		messageBuffer = new ConcurrentHashMap<String, List<Message>>();
	}

	public Collection<ClientSession> getSessions() {
		return clients.values();
	}

	public Set<String> getTopics() {

		return subscriptions.keySet();

	}

	// get the session object for a given user
	// session object can be used to send a message to the user
	
	public ClientSession getSession(String user) {

		ClientSession session = clients.get(user);

		return session;
	}

	public Set<String> getSubscribers(String topic) {

		return (subscriptions.get(topic));

	}

	public void addClientSession(String user, ClientSession client) {
		
		clients.put(user, client);
		
	}

	public void removeClientSession(String user) {
		messageBuffer.put(user,new ArrayList<>());
		clients.get(user).disconnect();
		clients.remove(user);

		
	}

	public void createTopic(String topic) {


		subscriptions.put(topic, ConcurrentHashMap.newKeySet());
		
	}

	public void deleteTopic(String topic) {

		subscriptions.remove(topic);
		
	}

	public void addSubscriber(String user, String topic) {
		
		subscriptions.get(topic).add(user);
		
	}

	public void removeSubscriber(String user, String topic) {

		subscriptions.get(topic).remove(user);
	}

	public void addMessageToBuffer(String user, Message msg){
		messageBuffer.get(user).add(msg);
	}

	public List<Message> getMessageBuffer(String user){
		List<Message> userBuffer = messageBuffer.get(user);
		messageBuffer.remove(user);
		return userBuffer;
	}
	public boolean isOnline(String user){
		return clients.containsKey(user);
	}

}
