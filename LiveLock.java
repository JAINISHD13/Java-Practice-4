
class Customer 
{
	private boolean paid = false;

	public void payment(Shop shop)
	{
		while(!shop.isOrderShipped())
		{
			System.out.println("Waiting for Order!");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		setPayment(true);
	}
	
	private void setPayment(boolean b) {
		// TODO Auto-generated method stub
		this.paid = b;
	}

	public boolean isPaid() {
		// TODO Auto-generated method stub
		return paid;
	}
}

class Shop
{
	private boolean delivery = false;
	
	public void shippingOrder(Customer customer)
	{
		while(!customer.isPaid())
		{
			System.out.println("Money is not paid yet!!!!");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		setOrderDelivery(true);
	}

	public void setOrderDelivery(boolean b) {
		// TODO Auto-generated method stub
		this.delivery = b;
	}
	
	public boolean isOrderShipped() {
	    return delivery;
	  }
	
}
public class LiveLock {
	
	static Customer customer = new Customer();
	
	static Shop shop = new Shop();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Thread thread1 = new Thread(new Runnable() {
		      @Override
		      public void run() {
		        customer.payment(shop);	
		      }
		    });
		    
		    Thread thread2 = new Thread(new Runnable() {
		      @Override
		      public void run() {
		        shop.shippingOrder(customer);	
		      }
		    });

		    thread1.start();
		    thread2.start();
	}

}
