package FinaleExam;

import java.util.*;
import java.util.concurrent.*;

public class PrintOut implements Runnable
{
	private String name;
	private int numToPrint;
	private int iterations;
	static final Random ranNum = new Random();

	public PrintOut(String name, int n)
	{
		this.name = name;
	    numToPrint = n;
	    iterations = 0;
	}

	@Override
	public String toString()
	{
	    return name + ": iterations completed - " + iterations;
	}

	@Override
	public void run() // run method start
	{
		for (; iterations <= numToPrint; iterations++)
		{
			System.out.println(this.toString());
			try {
				Thread.sleep(ranNum.nextInt(10));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end for
	} // run method end
	
	public static void main(String[] args) // main method start
	{
		// creating needed objects
		ExecutorService executor = Executors.newCachedThreadPool();
		PrintOut test1 = new PrintOut("Test 1", ranNum.nextInt(100));
		PrintOut test2 = new PrintOut("Test 2", ranNum.nextInt(100));
		PrintOut test3 = new PrintOut("Test 3", ranNum.nextInt(100));
		PrintOut test4 = new PrintOut("Test 4", ranNum.nextInt(100));
		
		// executing tasks
		executor.execute(test1);
		executor.execute(test2);
		executor.execute(test3);
		executor.execute(test4);
		
		// shutting down thread
		executor.shutdown();
	} // main method end
}
