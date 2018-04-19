class MultithreadingDemo implements Runnable
{
	public synchronized void doing(){
		int count=0;
		while(true){
			System.out.println(++count);
			if(count==10)break;
		}
	}
    public void run()
    {
        try
        {
        	doing();
        }
        catch (Exception e)
        {
            System.out.println ("Exception is caught");
        }
    }
}
public class ThreadSynchronization extends Thread{
	public static void main(String[] args) {
		int n = 8;
        for (int i=0; i<n; i++)
        {
            Thread object = new Thread(new MultithreadingDemo());
            object.start();
        }
		
	}

}
