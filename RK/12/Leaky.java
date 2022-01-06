import java.util.Random; 
import java.util.Scanner; 
public class Leaky
{ 
public static void main(String [] args) 
{ 
int bcktsize,iter, oprate, flow, total=0, rem_bytes; int pkt[] = new int[25]; 
Scanner in = new Scanner(System.in); 
System.out.println("Enter the no of input flows");
 flow = in.nextInt(); 
System.out.println("Enter the no of iterations");
 iter = in.nextInt();
 System.out.println("Enter the bucket size and output rate :"); 
bcktsize = in.nextInt(); 
oprate = in.nextInt(); 
Random rand = new Random();
 for(int i=0;i<iter;i++) 
{ 
System.out.println("Iteration: " + (i+1)); 
for(int j=0;j<flow;j++) 
{ 
rand.setSeed(System.nanoTime()); // To generate packets of unique size 
pkt[j] = rand.nextInt(500); // Unique random number is assigned as packet size total += pkt[j]; 
if(total<=bcktsize) // Check whether packetsize is less than bucket Size 
{ 
System.out.println(" Input from flow " + (j+1) + " with packet size " + pkt[j] +" bytes are accepted for the bucket Number of bytes in bucket is : "+total); 
} 
else 
{ 
total-=pkt[j]; 
System.out.println(" Input from flow " + (j+1) + " with packet size " + pkt[j]+" bytes are discarded from the bucket Number of bytes in bucket is: " +total); 
} 
} 
if(oprate> total) // check whether the output rate exceeds the bucket content
{ 
rem_bytes = total; total = 0; 
System.out.println(" "); 
System.out.println("Output rate of the bucket is: "+ oprate + " \n Bytes sent out of the bucket is " + rem_bytes); 
System.out.println(" "); 
} 
else 
{ 
total -= oprate; 
System.out.println(" "); 
System.out.println(" Output rate of the bucket is " + oprate +" \n Number of bytes remaining in bucket is" +total); 
System.out.println(" --------------------------------- "); 
} 
} 
} 
} 



/* op1
3
2
500 350

op2
2
3
400 250*/