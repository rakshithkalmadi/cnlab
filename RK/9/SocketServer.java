import java.net.*;  
import java.io.*; 
public class SocketServer 
{ 
public static void main(String args[]) throws Exception 
 {  
/* Create a socket at server side */ 
ServerSocket servSocket = new ServerSocket(4000); 
System.out.println("****Server Side****"); 
System.out.println("Server ready for connection"); 
/* Accept the connection with port: 4000 */ 
 Socket connSock = servSocket.accept();  
System.out.println("Connection is successful and ready for file transfer"); /* Reading the filename from client using connection socket */ InputStream istream = connSock.getInputStream( ); 
BufferedReader fileRead =new BufferedReader(new InputStreamReader(istream));  String fname = fileRead.readLine(); 
 File fileName = new File(fname); 
/* Keeping output stream ready to send the contents */ 
OutputStream ostream = connSock.getOutputStream( ); 
PrintWriter pwrite = new PrintWriter(ostream, true); 
/* If file exists read the contents of file and send to the client */ if(fileName.exists()) 
 { 
BufferedReader contentRead = new BufferedReader(new FileReader(fname)); System.out.println("Writing file Contents to the socket"); 
 String str; 
while((str = contentRead.readLine()) != null)  
 /* Reading line-by-line from file */ 
 { 
/* Sending each line to the client */ 
pwrite.println(str);  
 } 
contentRead.close(); 
 } 
else 
 { 
System.out.println("Requested file does not exist"); 
 String msg = "Requested file does not exist at server side"; pwrite.println(msg);
} 
connSock.close();  
servSocket.close(); /* Close network sockets */ 
fileRead.close();  
pwrite.close(); 
 } 
} 
