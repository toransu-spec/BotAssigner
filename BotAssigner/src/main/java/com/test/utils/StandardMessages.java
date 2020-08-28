package com.test.utils;

public class StandardMessages {
	
	public static StandardMessages getStandardMessage() {
		return new StandardMessages();
	}
	
	public void printLine() {
		System.out.println("************************************************");
	}
	
	public void noTicketFound() {
		System.out.println("Queue doesn't have unassigned incidents.");
	}
	
	public void assignmentFinished() {
		System.out.println("* Assignment finished. Recycling...");
	}
	
	public void totalTicketsAssigned(int intTicketCounter) {
		System.out.println("* Total ticket assigned by bot: "+ intTicketCounter);
	}
	
	public void assignmentInProgress() {
		System.out.println("* Assignment step in progress...");
	}
	
	public void ticketWorkInProgress() {
		System.out.println("* Ticket status has been changed to Work in Progress");
	}
	
	public void ticketFound() {
		System.out.println("* Unassigned ticket found. ");
	}
	
	public void userInShift(String ntid) {
		System.out.println("* User: " + ntid + "in shift. Initializing...");
	}
	
	public void userNotInShift(String ntid) {
		System.out.println("* User: "+ ntid + "not in shift. Recycling...");
	}
	
	public void printQueue(String queue) {
		System.out.println("* Queue of User: "+ queue);
	}
	
	public void refreshingPage() {
		System.out.println("* Refreshing to Home, as is not returning results...");
	}

}
