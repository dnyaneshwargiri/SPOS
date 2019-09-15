import java.io.*;
import java.util.Arrays;
class scheduling
{
static	int n,ch,at[],burstTime[],copyburstTime[],wt[],tat[],priority[],sortedArray[],copyPriority[],arrivalTime[],copyarrivalTime[],finalProcess[];
static float ttt,awt;
	public scheduling()
	{
		wt=new int[15];
		tat=new int[15];
		burstTime=new int[15];
		at=new int[15];
		priority=new int[15];
		copyPriority=new int[15];
		sortedArray=new int[15];
		arrivalTime=new int[15];
		copyarrivalTime=new int[15];
		finalProcess=new int[15];
		copyburstTime=new int [15];
		ttt=0;
		awt=0;
	}
	static InputStreamReader isr=new InputStreamReader(System.in);
	static BufferedReader br=new BufferedReader(isr);
	
	public void getBurstTime() throws NumberFormatException, IOException
	{
		System.out.println("Enter no of process");
		n=Integer.parseInt(br.readLine());	
		System.out.println("Enter Burst time for each process\n");
		for(int i=0;i<n;i++)
		{
			System.out.println("Process["+(i+1)+"]");
			burstTime[i]=Integer.parseInt(br.readLine());
			copyburstTime[i]=burstTime[i];
		}
		
	}
	
		
	
	
	
	public void getPriority() throws NumberFormatException, IOException
	{
		System.out.println("\n Enter Priority for each process\n");
		for(int i=0;i<n;i++)
		{
			System.out.println("Process["+(i+1)+"]");
			priority[i]=Integer.parseInt(br.readLine());
			copyPriority[i]=priority[i];
		}
	
	}
	
	public void getReady() throws NumberFormatException, IOException
	{
		System.out.println("\n Enter Ready Period for each process\n");
		for(int i=0;i<n;i++)
		{
			System.out.println("Process["+(i+1)+"]");
			arrivalTime[i]=Integer.parseInt(br.readLine());
			copyarrivalTime[i]=arrivalTime[i];
		}
	}
	
	public void FCFS() throws NumberFormatException, IOException
	{
		getBurstTime();
		System.out.println("\n");
		wt[0]=0;
		for(int i=1;i<n;i++)
		{
			wt[i]=wt[i-1]+burstTime[i-1];

		}
		for(int i=1;i<n;i++)
		{
			tat[i]=wt[i]+burstTime[i];
			awt=awt+wt[i];

		}
		for(int i=0;i<n;i++)
		{

			ttt=ttt+tat[i];
		}	
		
		System.out.println("  PROCESS  BURST-TIME  WAITING-TIME  TURNAROUND-TIME \n");
		for(int i=0;i<n;i++)
		{
			System.out.println("   "+ (i+1) + "\t\t"+burstTime[i]+"\t"+wt[i]+"\t\t"+tat[i]);
		}
		
		System.out.print("\n Scheduled Process :\t");
		for(int i=0;i<n;i++)
		{
			System.out.print("P"+(i+1)+"\t");
		}
		
		awt=awt/n;
		System.out.println("\n");
		System.out.println("Avg waiting time="+awt+"\n");

		ttt=ttt/n;
		System.out.println("\n");
		System.out.println("Avg turnaround time="+ttt+"\n");
	}
	
	public void priority() throws NumberFormatException, IOException
	{
		getBurstTime();
		getPriority();
		
		System.out.println("  PROCESS  BURST-TIME  PRIORITY  WAITING-TIME  TURNAROUND-TIME \n");
		for(int i=0;i<n;i++)
		{
			System.out.println("   "+ (i+1) + "\t\t"+burstTime[i]+"\t"+priority[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
		}

		Arrays.sort(priority, 0, n);
		System.out.println("\n Priortised Process Are : \t");
	
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(priority[i]==copyPriority[j])
				{    
					if(sortedArray[i]==j)
					{
						i++;
					}else
					{
						sortedArray[i]=j;
					}
				}
			}
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.print("P"+(sortedArray[i]+1)+"\t");
		}
		
	}
	
	public void SJF() throws NumberFormatException, IOException{
		getBurstTime();
		getReady();
		System.out.println("  PROCESS  BURST-TIME  READY  WAITING-TIME  TURNAROUND-TIME \n");
		
		for(int i=0;i<n;i++)
		{
			System.out.println("   "+ (i+1) + "\t\t"+burstTime[i]+"\t"+arrivalTime[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
		}
		int first;
		Arrays.sort(copyarrivalTime, 0, n);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(arrivalTime[i]==copyarrivalTime[j])
				{    
					if(sortedArray[i]==j)
					{
						i++;
					}else
					{
						sortedArray[i]=j;
					}
				}
			}
		}
		first=sortedArray[0];
		finalProcess[0]=first;
		Arrays.sort(copyburstTime, 0, n);
		
		copyburstTime[first]=copyburstTime[first]-copyarrivalTime[1];
		
		
		
		
		
	}
	
	public static void main(String args[]) throws Exception
	{
		scheduling sc=new scheduling();
		System.out.println("\n 1. FCFS \n 2. Priority \n 3. SJF \n 4. Round Robin");
		System.out.println("\n Enter Your Choice :");
		ch=Integer.parseInt(br.readLine());
		switch(ch)
		{
		case 1:
			sc.FCFS();
			break;
		case 2:
			sc.priority();
			break;
		case 3:
			sc.SJF();
			break;
		case 4:
		
			break;
		default:
			System.out.println("\n Invalid Choice !!!");
		}
		
	}
}
