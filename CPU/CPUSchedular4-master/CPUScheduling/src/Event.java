import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;


class  fcfsComparator implements Comparator<ProcessInfo>{ 
    
   
    public int compare(ProcessInfo p1, ProcessInfo p2) { 
        if (p1.arrivalTime > p2.arrivalTime) 
            return 1; 
        else if (p1.arrivalTime < p2.arrivalTime) 
            return -1;
        	return 0;           
        } 
}

class  PriorityComparator implements Comparator<ProcessInfo>{ 
    
	   
    public int compare(ProcessInfo p1, ProcessInfo p2) { 
        if (p1.priority >= p2.priority) 
            return 1; 
        else if (p1.priority < p2.priority) 
            return -1;
        	return 0;           
        } 
}

class  BurstComparator implements Comparator<ProcessInfo>{ 
    
	   
    public int compare(ProcessInfo p1, ProcessInfo p2) { 
        if (p1.burstTime >= p2.burstTime) 
            return 1; 
        else if (p1.burstTime < p2.burstTime) 
            return -1;
        	return 0;           
        } 
}





public class Event {
	

	
	
	private  int size;
	private   PriorityQueue<ProcessInfo> fcfsq = new PriorityQueue<ProcessInfo>(10, new fcfsComparator());
	private   PriorityQueue<ProcessInfo> pq = new PriorityQueue<ProcessInfo>(10, new PriorityComparator());
	private   PriorityQueue<ProcessInfo> bq = new PriorityQueue<ProcessInfo>(10, new BurstComparator());
	private   PriorityQueue<ProcessInfo> pqrb = new PriorityQueue<ProcessInfo>(10, new PriorityComparator());
	private   PriorityQueue<ProcessInfo> rbArrival = new PriorityQueue<ProcessInfo>(10, new fcfsComparator());
	private   Queue<ProcessInfo> priorityq=new LinkedList<>();
	private   Queue<ProcessInfo> burstq=new LinkedList<>();
	private   Queue<ProcessInfo> rbQ=new LinkedList<>();
	public   Vector<ProcessInfo> finalV =new Vector<>(size);
	
	
	Event()
	{
		finalV.removeAllElements();
	}
	
	
	public  void setSize(int i)
	{
		size=i;
	}
	
		
	private void fcfs(Vector v)
		{
		
		
		for(int i=0;i<size;i++)
		{
			
			ProcessInfo p=new ProcessInfo();
			p.processName=((Vector)v.elementAt(i)).elementAt(0).toString();
			p.arrivalTime=(Double) ((Vector)v.elementAt(i)).elementAt(1);
			p.burstTime=(Double) ((Vector)v.elementAt(i)).elementAt(2);
			if(((Vector)v.elementAt(i)).elementAt(3)!=null)
			p.priority=(Long) ((Vector)v.elementAt(i)).elementAt(3);
			fcfsq.add(p);
		
			
			
			
			
			
			
		}
		
		
	
		
	
	
		}
	
	
	
	public void priority(Vector v)
	{
		fcfs(v);
		ProcessInfo p=new ProcessInfo();
		double now=fcfsq.peek().arrivalTime; 
		pq.add(fcfsq.peek()); 
		fcfsq.remove();    
		
		
		while(!pq.isEmpty()||!fcfsq.isEmpty())    
		{
			
			Boolean stop=false;
			 
			while(!stop && !fcfsq.isEmpty())
			{
			p=fcfsq.peek();
			if(p.arrivalTime<=now)  
			{
				pq.add(p); 
				fcfsq.remove(); 
				
			}
			
			if(p.arrivalTime>now)
				stop=true;
			}
			
			priorityq.add(pq.peek()); 
			now=now+pq.peek().burstTime; 
			pq.remove();  
			
		}
		
		while(!priorityq.isEmpty())
		{
			finalV.add(priorityq.peek());
			priorityq.remove();
		}
		
		for(int i=0;i<finalV.size();i++)
		{
			System.out.println(finalV.elementAt(i).processName);
		}
		setTime();
		
		
		
	}
	
	public  void fcfsV(Vector v)
	{
		fcfs(v);
		while(!fcfsq.isEmpty())
		{
			finalV.add(fcfsq.peek());
		    fcfsq.remove();
		}
		
		
		setTime();
		
		for(int i=0;i<finalV.size();i++)
		{
			System.out.println(finalV.elementAt(i).processName);
		}
		
	}
	
	
	public void sjf(Vector v)
	{
		fcfs(v); 
		ProcessInfo p=new ProcessInfo();
		double now=fcfsq.peek().arrivalTime; 
		bq.add(fcfsq.peek()); 
		fcfsq.remove();    
		
		
		while(!bq.isEmpty()||!fcfsq.isEmpty())    
		{
			
			Boolean stop=false;
			 
			while(!stop && !fcfsq.isEmpty())
			{
			p=fcfsq.peek();
			if(p.arrivalTime<=now)  
			{
				bq.add(p); 
				fcfsq.remove(); 
				
			}
			
			if(p.arrivalTime>now)
				stop=true;
			}
			
			burstq.add(bq.peek()); 
			now=now+bq.peek().burstTime; 
			bq.remove();  
			
		}
		
		while(!burstq.isEmpty())
		{
			finalV.add(burstq.peek());
			burstq.remove();
		}
		setTime();
		
		for(int i=0;i<finalV.size();i++)
		{
			System.out.println(finalV.elementAt(i).processName);
		}
		
	}
	
	
	//public void roundRobin(Vector v,double qTime)
	//{
	 	//now=now+2
	 	//if(arrivalTime<now)	
	 	//pq.add(p)
	 	//burstq
	 	//p.burstTime=p.burstTime-qTime
	 	//if(p.burstTime>0)
	 	//add(arrivalTime)
		//fcfs(v);//p1[0 6 ] p2 [2 4] p3 [2 8]
		//ProcessInfo p=new ProcessInfo();
		//double now=fcfsq.peek().arrivalTime; //now=0
		//rbArrival.add(fcfsq.peek()); //p1[0 6]
		//fcfsq.remove();  //p2 p3  
		
		
		
		
		//while(!rbArrival.isEmpty()||!fcfsq.isEmpty())    
		//{
			
			//Boolean stop=false;
			 
			//while(!stop && !fcfsq.isEmpty())
			//{
			//p=fcfsq.peek();
			//if(p.arrivalTime<=now)  
			//{
				//bq.add(p); 
				//fcfsq.remove(); 
				
			//}
			
			//if(p.arrivalTime>now)
				//stop=true;
			//}
			
			//rbQ.add(rbArrival.peek());
			//now=now+qTime; 
			//rbArrival.peek().burstTime=rbArrival.peek().burstTime-qTime;
			
			//rbArrival.remove();  
			
		//}
		
		//while(!burstq.isEmpty())
	//	{
		//	finalV.add(burstq.peek());
			//burstq.remove();
		//}
		//setTime();
		//
		//for(int i=0;i<finalV.size();i++)
		//{
			//System.out.println(finalV.elementAt(i).processName);
		//}
		
	 	
	//}
	
	
	private void setTime()
	{
		finalV.elementAt(0).startTime=finalV.elementAt(0).arrivalTime;
		finalV.elementAt(0).finishTime=finalV.elementAt(0).startTime+finalV.elementAt(0).burstTime;
		finalV.elementAt(0).waitingTime=finalV.elementAt(0).startTime-finalV.elementAt(0).arrivalTime;
		
		
		
		for(int i=1;i<finalV.size();i++)
		{
			double now=finalV.elementAt(i-1).finishTime;
			if(finalV.elementAt(i).arrivalTime<=now)
			{
				finalV.elementAt(i).startTime=finalV.elementAt(i-1).finishTime;
				finalV.elementAt(i).finishTime=finalV.elementAt(i).startTime+finalV.elementAt(i).burstTime;
				finalV.elementAt(i).waitingTime=finalV.elementAt(i).startTime-finalV.elementAt(i).arrivalTime;
			}
			else
			{
				finalV.elementAt(i).startTime=finalV.elementAt(i).arrivalTime;
				finalV.elementAt(i).finishTime=finalV.elementAt(i).startTime+finalV.elementAt(i).burstTime;
				finalV.elementAt(i).waitingTime=finalV.elementAt(i).startTime-finalV.elementAt(i).arrivalTime;
			}
				
				
			
				
				
		}
		
		
	}
	
	public double getWaitingTime()
	{
		double waitingTime=0;
		double avaregeWaitingTime;
		for(int i=0;i<finalV.size();i++)
		{
			waitingTime=waitingTime+finalV.elementAt(i).waitingTime;
		}
		
		avaregeWaitingTime=waitingTime/finalV.size();
		return avaregeWaitingTime;
	}
	
	
	
	
	
	
	 
	
	
	

};
