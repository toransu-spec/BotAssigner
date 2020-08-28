package com.test.infoupdate;

public class PageTicketUpdate {

	private TicketUpdateActController act;
	
	public TicketUpdateActController act() {
		return act;
	}
	
	private PageTicketUpdate(TicketUpdateActController act) {
		this.act = act;
	}
	
	private PageTicketUpdate() {
		//hide it
	}
	
	public static PageTicketUpdate getPageTicketUpdate() {
		return new PageTicketUpdate(new TicketUpdateActController());
	}
}
