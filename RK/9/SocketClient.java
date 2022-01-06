import java.net.*; 
import java.io.*;
import java.util.*; 
public class SocketClient 
{ 
public static void main( String args[ ] ) throws Exception 
 { 
 Scanner in = new Scanner(System.in); 
/* Create socket at client side */ 
 Socket clientSocket = new Socket( "127.0.0.1",4000); 
System.out.println("****Client side****"); 
/* Reading the filename from keyboard. */  
System.out.println("Enter the file name to transfer"); 
 String fname = in.nextLine(); 
/* Sending the filename to server. Uses PrintWriter to write filename to outputstream */ OutputStream ostream = clientSocket.getOutputStream( ); 
PrintWriter pwrite = new PrintWriter(ostream, true); 
pwrite.println(fname);  
/* Receiving the contents from server.Uses input stream */ 
InputStream istream = clientSocket.getInputStream(); 
BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream)); System.out.println("Contents of the file " + fname + " are"); 
 String str; 
while((str = socketRead.readLine()) != null)  
 /* Reading line-by-line */  
 {  
System.out.println(str);  
 }  
pwrite.close();  
socketRead.close();  
 } 
}
