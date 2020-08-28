package com.test.cases;

import static com.test.assigntome.AssignedToMe.getAssignedToMe;
import static com.test.header.PageHeader.getPageHeader;
import static com.test.infoupdate.PageTicketUpdate.getPageTicketUpdate;
import static com.test.myq.MyQueue.getMyQueue;
import static com.test.ticketpage.PageTicketView.getPageTicketView;
import static com.test.utils.StandardMessages.getStandardMessage;
import static com.test.utils.TestUtils.printTime;
import static com.test.utils.TestUtils.waitSecTime;
import static com.test.utils.TestUtils.refreshPage;
import static com.test.utils.TestUtils.getTicketUrl;
import static com.test.utils.TestUtils.goToTicketUrl;
import static com.test.utils.TestUtils.sendMail;
import org.testng.annotations.Test;

import com.test.assigntome.AssignedToMe;
import com.test.conditions.Conditions;
import com.test.header.HeaderTabsEnum;
import com.test.header.PageHeader;
import com.test.infoupdate.PageTicketUpdate;
import com.test.myq.MyQueue;
import com.test.ticketpage.PageTicketView;
import com.test.utils.StandardMessages;

public class TicketManager extends Conditions{
	
	PageHeader pageHeader = getPageHeader();
	AssignedToMe assignedToMe = getAssignedToMe();
	PageTicketView pageTicketView = getPageTicketView();
	PageTicketUpdate pageTicketUpdate = getPageTicketUpdate();
	MyQueue myQueue = getMyQueue();
	StandardMessages standardMsg = getStandardMessage();
	String stringTicketNro;
	int intTicketCounter = 0;
	
	@Test(dataProvider = "controltest", enabled = true, invocationCount = 100)
	public void ticketControlTEST(String inShift, String queue, String ntid, String zone) {
		
		standardMsg.printLine();
		if (inShift.equalsIgnoreCase("YES")) { //Si el usuario esta en shift, procede a buscar un ticket
			
			do {
				
				printTime();
				standardMsg.userInShift(ntid);
				standardMsg.printQueue(queue);
				
				pageHeader.selectTab(HeaderTabsEnum.MYQUEUES);
				
				waitSecTime(20);
				
				while (myQueue.act().queueDropDownVisible())
				{
					standardMsg.refreshingPage();
					pageHeader.selectTab(HeaderTabsEnum.MYTICKETS);
					pageHeader.selectTab(HeaderTabsEnum.MYQUEUES);
				}
				
				myQueue.act()
						.showUnassignedOnly()
						.selectQueueDropDown();
				
				//tratamiento para queue no encontrada
				if (!myQueue.act().queueIsNotVisible(queue)) { //si encuentra la queue, la selecciona
					myQueue.act()
							.selectYourQueue(queue);
				}
				else { //si no esta la queue, imprime el mensaje
					printTime();
					standardMsg.noTicketFound();
					standardMsg.totalTicketsAssigned(intTicketCounter);
					standardMsg.printLine();
					refreshPage();
				}
				
			}while(myQueue.act().queueIsNotVisible(queue));
			
			printTime();
			standardMsg.ticketFound();
			
			myQueue.act().selectUnassignedTicket() //busca el primero en status
						.printTicketNumber();
			
			stringTicketNro = myQueue.act().stringTicketNumber();
			
			pageTicketUpdate.act()
						.clickCraDropDown()
						.selectCRA(ntid)
						.clickCraDropDown()
						.clickActionDropDown()
						.selectAction(2) //opcion 2 es assignar en el dropdown
						.clickActionDropDown()
						.inputTextBoxAssigned()
						.submitUpdate();
			
			printTime();
			
			standardMsg.assignmentInProgress();
			
			goToTicketUrl(getTicketUrl());
			
			pageTicketUpdate.act()
						.clickCraDropDown()
						.selectCRA(ntid)
						.clickCraDropDown()
						.clickActionDropDown()
						.selectAction(3) // opcion 3 es Start Work
						.clickActionDropDown()
						.inputTextBoxWIP()
						.submitUpdate();
			
			standardMsg.ticketWorkInProgress();
			
			sendMail(stringTicketNro,ntid);
			printTime();
			intTicketCounter++;
			standardMsg.assignmentFinished();
			standardMsg.printLine();
			standardMsg.totalTicketsAssigned(intTicketCounter);
			
		} else {
			printTime();
			standardMsg.userNotInShift(ntid);
			standardMsg.printQueue(queue);
		}
	}
	
	
}
