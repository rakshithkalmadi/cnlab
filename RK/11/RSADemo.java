import java.util.*; 
public class RSADemo  
{ 
 public static void main(String [] args) 
 { 
 String msg; 
 int pt [] = new int[100]; 
 int ct [] = new int[100]; 
 int z, n, d, e, p, q,mlen; 
 Scanner in = new Scanner(System.in); 
 do 
 { 
 System.out.println("Enter the two large prime numbers for p and q");  p = in.nextInt(); 
 q = in.nextInt(); 
 }
 while( prime(p)==0 || prime(q)==0);
 n = p*q; // Calculate the n value 
 z=(p-1)*(q-1); // Calculate the z value 
 System.out.println("Value of n " + n + "\n Value of z is :"+ z); 
// Key generation (Encryption key) 
 for(e=2;e<z;e++) 
 { 
 if(gcd(e,z)==1)  
 break; 
 } 
 System.out.println("Encryption key e is " + e); 
 System.out.println("Public key is (e, n) : " + e +","+ n); 
// Key generation(Decryption key) 
 for(d=2;d<z;d++) 
 { 
if((e*d)%z==1) 
break; 
 } 
 System.out.println("Decryption key d is : " + d); 
 System.out.println("Private key is (d, n) => "+ d +"," +n);
 in.nextLine(); // To avoid the new line character in input buffer 
 System.out.println("Enter the message for encryption "); 
 msg = in.nextLine(); 
 mlen = msg.length(); 
 for(int i=0;i<mlen;i++) 
 pt[i] = msg.charAt(i); // Extract the individual characters from string 
 System.out.println("ASCII Values of PT array is"); 
 for(int i=0;i<mlen;i++) 
 System.out.println(pt[i]); 
 System.out.println(" Encryption: Cipher Text Obtained : "); for(int i=0; i<mlen; i++) 
 ct[i] = mult(pt[i], e, n); 
 for(int i=0; i<mlen; i++) 
 System.out.print( ct[i] + "\t"); 
 System.out.println("\nDecryption: Plain Text Obtained: "); for(int i=0; i<mlen; i++) 
 pt[i] = mult(ct[i], d, n) ; 
for(int i=0; i<mlen; i++) 
 {  
System.out.println(pt[i] + ":" + (char)pt[i]); 
 } 
 } 
// Method to calculate the GCD of two numbers  
public static int gcd(int x, int y) 
{ 
 if(y == 0) 
 return x; 
 else 
 return gcd(y, x%y); 
} 
// Method to check a number prime or not 
public static int prime(int num) 
{ 
int i; 
for(i=2; i<=num/2; i++) 
{ 
if(num%i == 0) 
return 0;
} 
return 1; 
} 
// Method for encryption and decryption of specific values 
public static int mult(int base, int exp, int n) 
{ 
int res=1, j; 
for (j=1; j<=exp; j++) 
res = ((res * base) % n); 
return res; 
} 
} // end of class 



/*op1
103 107
icon */