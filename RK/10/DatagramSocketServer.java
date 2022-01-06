import java.net.*; 
import java.util.*; 
public class DatagramSocketServer 
{ 
public static void main(String [] args) throws Exception 
 { 
 Scanner in = new Scanner(System.in); 
/* Create new datagram socket at server side */ 
DatagramSocket serverSocket = new DatagramSocket(9000); 
byte[] receiveData = new byte[1024];  
byte[] sendData = new byte[1024];  
System.out.println("***Server Side***"); 
/* Create the receive datagram packet */ 
DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);  /* Receive the packet using server socket */ 
serverSocket.receive(receivePacket); 
System.out.println(new String(receivePacket.getData())); 
/* Get the IPaddress of the client side */ 
InetAddress IPAddress = receivePacket.getAddress();  
int port = receivePacket.getPort(); 
while(true) 
 { 
System.out.println("Type some message to display at client end"); 
 String message = in.nextLine(); 
sendData = message.getBytes(); 
System.out.println("Message sent from the server:" + new String(sendData)); /* Create the send datagram packet */ 
DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, port);  
/* Send the packet using server socket */ 
serverSocket.send(sendPacket);  
 }  
 } 
}
