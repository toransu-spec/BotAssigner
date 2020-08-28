package com.test.assigntome;

public class AssignedToMe {
	
	private AssignedToMeActController act;
	
	public AssignedToMeActController act() {
		return act;
	}
	
	private AssignedToMe(AssignedToMeActController act) {
		this.act = act;
	}
	
	private AssignedToMe() {
		//hide it
	}
	
	public static AssignedToMe getAssignedToMe() {
		return new AssignedToMe(new AssignedToMeActController());
	}
	

}
