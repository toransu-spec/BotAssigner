package com.test.header;

public enum HeaderTabsEnum {
	
	MYTICKETS("My Tickets"),
	TICKETSTOME("Tickets Assigned to Me"),
	MYQUEUES("My Queues");
	
	private String value;
	
	HeaderTabsEnum(String value){
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}

}
