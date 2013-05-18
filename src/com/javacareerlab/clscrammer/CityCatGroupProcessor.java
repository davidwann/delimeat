package com.javacareerlab.clscrammer;

import java.util.LinkedList;
import java.util.Queue;

public class CityCatGroupProcessor implements Runnable {
	
	private Queue<CityCat> cityCats;
	private CityCat cc;

	private boolean stopRequested;
	
	/* ==================================================== */
	
	public CityCatGroupProcessor() {
		this.cityCats = new LinkedList<CityCat>();
		this.stopRequested = false;
	}
	
	/* ==================================================== */

	public void run() {
		
		this.stopRequested = false;
		
		// CityCat cc;  //  moved to private member variable

		System.out.println("CityCatGroupProcessor Object is doing its thing in its own thread!");
		
		while (!this.cityCats.isEmpty()) {
			
			this.cc = this.cityCats.remove();
			this.cc.process();
			
			if (this.stopRequested)
				break;
		}
	}
	
	/* ==================================================== */
		
	public void addCityCatToQueue(CityCat cc) {
		this.cityCats.add(cc);
	}
	
	/* ==================================================== */
	
	public int getLength() {
		return this.cityCats.size();
	}
	
	/* ==================================================== */
	
	public void stopProcessing() {
		
		this.stopRequested = true;
		
		// call a method on cc?
		this.cc.stopProcessing();
		
	}

	/* ==================================================== */

}
