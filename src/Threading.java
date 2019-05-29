class Threading extends Thread {
	   private Thread t;
	   private String threadName;
	   Object x;

	   public Threading( String name,  Object pd) {
	      threadName = name;
	      this.x = pd;
	   }
	   
	   public void run() {
		   synchronized(x){
		      System.out.println(threadName + " exiting.");
		   }
	   }

	   public void start () {
	      System.out.println("Starting " +  threadName );
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	      synchronized(x){
	    	  if(x instanceof SSTF){
	    		  ((SSTF) x).afisare();
	    	  }
	    	  else if(x instanceof FCFS){
	    		  ((FCFS) x).afisare();
	    	  }
	    	  else if(x instanceof SCAN){
	    		  ((SCAN) x).afisare();
	    	  }
	    	  else if(x instanceof CSCAN){
	    		  ((CSCAN) x).afisare();
	    	  }
	    	  else if(x instanceof LOOK){
	    		  ((LOOK) x).afisare();
	    	  }
	    	  else if(x instanceof CLOOK){
	    		  ((CLOOK) x).afisare();
	    	  }
	      }
	   }
}