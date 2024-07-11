package com.practise.java.codes;

public class DeadLock {

	public static void main(String[] args) {
		final Object resource1=new Object();
		final Object resource2=new Object();
		
		Thread thread1=new Thread(()->
				{
					synchronized(resource1)
					{
						System.out.println("Resource1 is locked");
						try
						{
							Thread.sleep(500);
						}
						catch(Exception e)
						{
							System.out.println("Exeception is"+e);
						}
						synchronized(resource2)
						{
							System.out.println("Resource2 is locked");
						}
					}
				}
				);
		Thread thread2=new Thread(()->
		{
			synchronized(resource2)
			{
				System.out.println("Resource2 is locked");
				try
				{
					Thread.sleep(50);
				}
				catch(Exception e)
				{
					System.out.println("Exeception is"+e); 
				}
				synchronized(resource1)
				{
					System.out.println("Resource1 is locked");
				}
			}
		}
		);
		
		thread1.start();
		thread2.start();

	}

}
