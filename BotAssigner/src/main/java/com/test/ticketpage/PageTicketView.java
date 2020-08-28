package com.test.ticketpage;

public class PageTicketView {
	
	private TicketViewActController act;
	
	public TicketViewActController act() {
		return act;
	}
	
	private PageTicketView(TicketViewActController act) {
		this.act = act;
	}
	
	private PageTicketView() {
		//hide it
	}
	
	public static PageTicketView getPageTicketView() {
		return new PageTicketView(new TicketViewActController());
	}

}
