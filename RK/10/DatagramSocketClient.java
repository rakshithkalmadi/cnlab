import java.net.*; 
public class DatagramSocketClient 
{ 
public static void main(String [] args) throws Exception 
 { 
 String line = "Connected with Client";  
 /* Create new datagram socket at client side */ 
DatagramSocket clientSocket = new DatagramSocket(); 
 /* Get IPAddress using the InetAddress class */ 
InetAddress IPAddress = InetAddress.getByName("localhost");  
byte[] sendData = new byte[1024];  
byte[] receiveData = new byte[1024]; 
sendData = line.getBytes(); 
/* Create the send datagram packet */ 
DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress,  9000);  
/* Send the packet using client socket */ 
clientSocket.send(sendPacket); 
System.out.println("*****Client Display Terminal****"); 
while(true) 
 { 
/* Create the receive datagram packet */ 
DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);  /*Receive the packet using client socket */ 
clientSocket.receive(receivePacket);  
/* Convert the message received into the string */ 
String messageReceived = new 
String(receivePacket.getData(),receivePacket.getOffset(),receivePacket.getLength());  System.out.println("Message typed at server side is : " + messageReceived);  } 
 } 
}
