
public class DeadLockSolution {

	final static Object resource1 = "Resource1";
	final static Object resource2 = "Resource2";

	
	public static void main(String[] args) {
	
		Thread t1 = new Thread() {
		      public void run() {
		        synchronized(resource1){
		          System.out.println("Resource 1 is locked by Thread 1");
		      
		          try{ 
		            Thread.sleep(50); 
		          } catch (InterruptedException e) {}

		          //Now wait 'till we can get a lock on resource 2
		          synchronized(resource2){
		            System.out.println("Resource 2 is locked by Thread 1");
		          }
		          
		        }
		        System.out.println("Execution completed for Thread 1");
		      }
		    };
		    
		  //Here's the second thread.  
		    Thread t2 = new Thread(){
		      public void run(){
		        synchronized(resource1){
		          System.out.println("Resource 2 is locked by Thread 2");
		          try{
		            Thread.sleep(50); 
		          } catch (InterruptedException e){}

		          synchronized(resource2){
		            System.out.println("Resource 1 is locked by Thread 2");
		          }
		        }
		        System.out.println("Execution completed for Thread 2");
		      }
		    };
		    
		    
	    t1.start(); 
	    t2.start();
		      
		    
	}

}
