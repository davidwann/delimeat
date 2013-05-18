package com.javacareerlab.clscrammer;

// import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// import java.text.SimpleDateFormat;

import java.util.ArrayList;
// import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// import java.util.logging.FileHandler;
// import java.util.logging.Level;
// import java.util.logging.Logger;

import com.javacareerlab.clscrammer.events.HarvestCompletionEvent;
import com.javacareerlab.clscrammer.listeners.HarvestCompletionListener;

public class Harvester implements Runnable {
	
	private Queue<CityCat> cityCats;
	private CityCatGroupProcessor[] ccgp;
	
	private boolean harvesting;
	private boolean stopRequested;
	
	private List<HarvestCompletionListener> listeners = new ArrayList<HarvestCompletionListener>();
	
	// private Logger log;
	
	/* ==================================================== */

	// constructor
	
	public Harvester() {
		
		this.harvesting = false;
		this.stopRequested = false;
		this.cityCats = new LinkedList<CityCat>();
		
		// this.log = Logger.getLogger("Harvester");
		// this.log = Logger.getLogger(this.getClass().getName());
		
		// String file_suffix = ((new SimpleDateFormat("yyyy_MM_dd_HHmmss")).format(new Date())).toString();
		// System.out.println("File Suffix:  " + file_suffix);
		
//		try {
//			// this.log.addHandler(new FileHandler("harvester_" + file_suffix + ".log"));
//			// this.log.addHandler(new FileHandler("harvest_log_" + file_suffix + ".xml"));
//			this.log.addHandler(new FileHandler("harvest_log.xml"));
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	/* ==================================================== */
	
	public void logTest() {
		
//		this.log.log(Level.INFO, "Log me Seymore!");
//		// this.log.info("Log me Seymore!");
//		
//		// this.log.setLevel(Level.INFO);
//		
//		// System.out.println("Class name:  " + this.getClass().getName());
//		
//		this.log.log(Level.INFO, "Log message 2");
//		
//		this.log.log(Level.INFO, "Log message 3");
//		
//		this.log.log(Level.WARNING, "I'm warning you bitch!");
		
		
		
	}
	
	/* ==================================================== */

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.startHarvesting();
	}
	
	/* ==================================================== */
	
	public void startHarvesting() {
		
		// and away we go!
		
		this.harvesting = true;
		this.stopRequested = false;
		System.out.println("Harvesting has started.");
		// this.log.log(Level.INFO, "Harvest is starting");
		
		// populate queue of city cats
		this.buildQueue();
		
		int threadCount = this.cityCats.size();
		
		if (threadCount > 10)
			threadCount = 10;
		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// System.out.println("Thread Count: " + threadCount);
		
		// create an array of objects ( 0 to 10 elements )
		// each object will have a queue of city cats
		
		// TODO: come back here
		// CityCatGroupProcessor[] ccgp = new CityCatGroupProcessor[threadCount];
		this.ccgp = new CityCatGroupProcessor[threadCount];
		
		for (int i = 0; i < threadCount; i++)
			this.ccgp[i] = new CityCatGroupProcessor();

		// System.out.println("Number of elements in ccgp: " + ccgp.length);
		
		int idx = 0;
		
		while (!this.cityCats.isEmpty()) {
			if (idx >= threadCount)
				idx = 0;
			this.ccgp[idx].addCityCatToQueue(this.cityCats.remove());
			idx++;
		}

		Thread[] threads = new Thread[threadCount];

		idx = 0;

		for (CityCatGroupProcessor c : this.ccgp) {
			
			// System.out.println(c.getLength());
			
			threads[idx] = new Thread(c);
			threads[idx].start();
			
			idx++;
		}
		
		for (int i = 0; i < threadCount; i++)
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		
		
		// this point will not be reached until 
		// all the CityCatGroupProcessor objects finish
		// processing their groups of CityCat objects
		
		
		
		
		

		this.harvesting = false;
		this.stopRequested = false;
		
		this.fireHarvestCompletionEvent();
		
		// this.log.log(Level.INFO, "Harvest is complete");


		System.out.println(" ");
		System.out.println("Harvester has finished.");
		System.out.println(" ");
		
	}
	
	/* ==================================================== */
	
	
	/* ==================================================== */
	
	public void startHarvesting3() {
		
		this.harvesting = true;
		this.stopRequested = false;
		System.out.println("Harvesting has started.");
		
		// fire off some work in an asynchronous thread

		for (int i = 1; i <= 10; i++) {
			
			System.out.println(" ");
			System.out.println("We are harvesting...");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (this.stopRequested) {
				System.out.println("Harvesting is being terminated early by request");
				break;
			}
			
		}
		
		this.harvesting = false;
		System.out.println(" ");
		System.out.println("Harvesting is finished.");
		
		this.fireHarvestCompletionEvent();
	}
	
	/* ==================================================== */
	
	public boolean isHarvesting() {
		return this.harvesting;
	}
	
	/* ==================================================== */
	
	public void startHarvesting2() {
		
		// and away we go!
		
		this.harvesting = true;
		this.stopRequested = false;
		System.out.println("Harvesting has started.");
		

		
		
		// populate queue of city cats
		this.buildQueue();
		
		int threadCount = this.cityCats.size();
		
		if (threadCount > 10)
			threadCount = 10;
		
		// System.out.println("Thread Count: " + threadCount);
		
		// create an array of objects ( 0 to 10 elements )
		// each object will have a queue of city cats
		
		CityCatGroupProcessor[] ccgp = new CityCatGroupProcessor[threadCount];
		
		for (int i = 0; i < threadCount; i++)
			ccgp[i] = new CityCatGroupProcessor();

		// System.out.println("Number of elements in ccgp: " + ccgp.length);
		
		int idx = 0;
		
		while (!this.cityCats.isEmpty()) {
			if (idx >= threadCount)
				idx = 0;
			ccgp[idx].addCityCatToQueue(this.cityCats.remove());
			idx++;
		}

		Thread[] threads = new Thread[threadCount];

		idx = 0;

		for (CityCatGroupProcessor c : ccgp) {
			
			// System.out.println(c.getLength());
			
			threads[idx] = new Thread(c);
			threads[idx].start();
			
			idx++;
		}
		
		for (int i = 0; i < threadCount; i++)
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		this.harvesting = false;
		
		this.fireHarvestCompletionEvent();

		System.out.println(" ");
		System.out.println("Harvester has finished.");
		System.out.println(" ");
	}
	
	/* ==================================================== */
	
	public void stopHarvesting() {
		
		// let's shut her down!
		
		System.out.println("Harvester object is executing its stopHarvesting method.");
		this.stopRequested = true;
		
		// Iterate thru the array this.     private CityCatGroupProcessor[] ccgp;

		for (CityCatGroupProcessor c : this.ccgp) {
			c.stopProcessing();
		}
		
	}
	
	/* ==================================================== */

	private void buildQueue() {
		
		Connection conn = null;
		Statement ps;
		String sql;

		this.cityCats.clear();
		
		try {
			// conn = DriverManager.getConnection("jdbc:derby:SpamDB");
			conn = DriverManager.getConnection("jdbc:derby:D:/JavaCLScrammer/SpamDB");
			
			// D:\JavaCLScrammer\SpamDB

			ps = conn.createStatement();
			
//			sql = "SELECT a.city,                            " +  
//		          "       b.category,                        " +
//		          "       a.city_sector,                     " +
//		          "       a.website,                         " +
//		          "       a.website_type,                    " + 
//		          "       a.spam                             " +
//		          "   FROM Cities a                          " +
//		          "      JOIN Categories b                   " +
//		          "         ON 1 = 1                         " +
//		          "   WHERE a.spam = 'yes' AND               " +
//		          "         a.website_type = 'homesfsbo' AND " + 
//		          "         b.category = 'reo'               " +
//		          "UNION                                     " +
//		          "SELECT a.city,                            " +
//		          "       b.category,                        " +
//		          "       a.city_sector,                     " +
//		          "       a.website,                         " +
//		          "       a.website_type,                    " + 
//		          "       a.spam                             " +
//		          "   FROM Cities a                          " +
//		          "      JOIN Categories b                   " +
//		          "         ON 1 = 1                         " +
//		          "   WHERE a.spam = 'yes' AND               " + 
//		          "         a.website_type = 'classifieds'   "; 

			sql = "SELECT a.city,                            " +  
	              "       b.category,                        " +
	              "       a.city_sector,                     " +
	              "       a.website,                         " +
	              "       a.website_type,                    " + 
	              "       a.spam                             " +
	              "   FROM Cities a                          " +
	              "      JOIN Categories b                   " +
	              "         ON 1 = 1                         " +
	              "   WHERE a.spam = 'yes' AND               " +
	              "         a.website_type = 'homesfsbo' AND " + 
	              "         b.category = 'reo'               ";
			
			//    "   FETCH NEXT 2 ROWS ONLY                 ";

			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				this.cityCats.add(new CityCat(rs.getString(1), 
                                              rs.getString(2), 
                                              rs.getString(3), 
                                              rs.getString(4), 
                                              rs.getString(5), 
                                              rs.getString(6), 16));   // 200 
				
				System.out.println(rs.getString(1) + " : " + rs.getString(2) + " : " + rs.getString(3));
			}
			
			// TODO:  are we testing?  want to clear the queue?
			
			// System.out.println("We are clearing city cats queue for debugging purposes!!!");
			// this.cityCats.clear();
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}   // end of method buildQueue() 

	/* ==================================================== */
	
	public synchronized void addHarvestCompletionListener(HarvestCompletionListener listener) {
		listeners.add(listener);
	}
	
	/* ==================================================== */
	
	public synchronized void removeHarvestCompletionListener(HarvestCompletionListener listener) {
		listeners.remove(listener);
	}
	
	/* ==================================================== */

	private synchronized void fireHarvestCompletionEvent() {
		
		HarvestCompletionEvent event = new HarvestCompletionEvent(this);
		
		Iterator<HarvestCompletionListener> i = listeners.iterator();
		
		HarvestCompletionListener listener;
		
		while (i.hasNext()) {
			
			// listener = (HarvestCompletionListener) i.next();
			listener = i.next();
			listener.actionPerformed(event);
		}
	}
	
	/* ==================================================== */
	
	
	/* ==================================================== */
	
}
