package com.test.myq;

public class MyQueue {
	
	private MyQueueActController act;
	
	public MyQueueActController act() {
		return act;
	}
	
	private MyQueue(MyQueueActController act) {
		this.act = act;
	}
	
	private MyQueue() {
		//hide it
	}
	
	public static MyQueue getMyQueue() {
		return new MyQueue(new MyQueueActController());
	}

}
