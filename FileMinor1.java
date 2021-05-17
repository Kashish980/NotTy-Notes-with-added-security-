import java.io.BufferedReader;      //IO Memory buffer
import java.io.File;          //File Handling
import java.io.FileNotFoundException;  //Exception handling
import java.io.FileReader;        //File functions
import java.io.FileWriter;      //File functions
import java.io.IOException; 
import java.math.BigInteger;
//****************
//import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.apache.commons.codec.digest.DigestUtils; 
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;    
import java.io.InputStreamReader;
import java.util.*;
public class FileMinor1
{
    public static void main(String args[]) throws FileNotFoundException, IOException 
  {
	System.out.println();
	System.out.println("|@@@|||||||||||||||||||||||||||||||||||||||||||@@@|");
    System.out.println("!!! Welcome to NotTy: Notes with Added Security !!!");
	System.out.println("|@@@|||||||||||||||||||||||||||||||||||||||||||@@@| \n");
	System.out.println("If you are a new user press 1 else if you are an existing user press 2");
	String inputpwd;
	String passwd="";
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); //typecasting (wrapper class)
	Scanner sc=new Scanner(System.in);
    int choice;
	choice = Integer.parseInt(br.readLine());
    //choice = sc.nextInt();
	switch(choice)
    {
	case 1: 	System.out.println("create a password");
				//inputpwd=sc.nextLine();
				 inputpwd=br.readLine();
				System.out.println("confirm password");
				//String input2pwd=sc.nextLine();
					String input2pwd=br.readLine();
					//passwd=input2pwd;
				if(inputpwd.equals(input2pwd))
                {
				   System.out.println("password created successfully");
                   System.out.println("Please select one of the below operations");
				   System.out.println(" w for write mode ");
				   System.out.println(" r for read mode ");
				   System.out.println(" a for append mode ");
				//Scanner in =new Scanner(System.in);
				/*String s=in.nextLine();
				if(s.equalsIgnoreCase("r"))
				{
					new FReading();
				}
				else if(s.equalsIgnoreCase("w")||s.equalsIgnoreCase("a"))
				{
            		writingToFile(s);
				}*/
                   String sx=sc.nextLine();
				if(sx.equalsIgnoreCase("r"))      
				{
					new FReading();
				}
				else if(sx.equalsIgnoreCase("w")||sx.equalsIgnoreCase("a"))
				{
            		writingToFile(sx);
				}
				else
				{
					System.out.println("Sorry you try to do unexpected ,betterluck next time ");
				}
				sc.close();
                }
				else 
				  /*{
					System.out.println("Your passwords do not match kindly try again!");
                    System.out.println("create a password");
				    inputpwd=sc.nextLine();
				    System.out.println("confirm password");
				    String input2pwd=sc.nextLine();
				    if(inputpwd.equals(input2pwd))
				    System.out.println("password created successfully");
                  }*/
                {
                  System.out.println("You have entered a wrong passwords, they do not match");
                }
				break;
    case 2: System.out.println("Enter your password");
			//inputpwd=sc.nextLine();
			//String 
			inputpwd=br.readLine();
            passwd = "K@sh";			
			if(inputpwd.equals(passwd))
	{
			System.out.println("\n*****Authenticate via One-Time-Password*****");	
			System.out.println("Enter the OTP provided by our authenticator");
			//*********************************** 
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmm");
            LocalDateTime now = LocalDateTime.now();
            //int OTP1= dtf.format(now);
			int OTP1= Integer.parseInt(dtf.format(now));
            int OTP2= Integer.parseInt(br.readLine());
			if(OTP1==OTP2)
		{
			//***********************************
			System.out.println("!** Successfullly Logged-In your account! **!\n");
        	System.out.println("Please select one of the below operations");
     		System.out.println(" w for write mode ");
        	System.out.println(" r for read mode ");
        	System.out.println(" a for append mode ");
            String st=sc.nextLine();
			if(st.equalsIgnoreCase("r"))
			{
				new FReading();
			}
			else if(st.equalsIgnoreCase("w")||st.equalsIgnoreCase("a"))
			{
            	writingToFile(st);
			}
        	else
        	{
        	    System.out.println("Sorry you try to do unexpected ,betterluck next time ");
        	}
        	sc.close();
		}
		else
		   	System.out.println("Incorrect OTP entered! , Program will now exit automatically");

	} 
     		else  	
	    	{
			System.out.println("Incorrect password entered");
			System.exit(0);
		    }
		
				break;
	default: System.out.println("Sorry you entered a wrong choice ");
}
}   

public static void writingToFile(String s)
   	 {
   	     Scanner in=null;
   	     try
   	     {
	  	           String source = "";
			   Scanner s2=new Scanner(System.in);
			   System.out.println("Enter file name u want to edit or create");
			   String fn=s2.nextLine();
			   File f=new File(fn);
              //choose files option to be inserted
           		 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
           		 //For writing new Content Everytime you run
           		 FileWriter f0 =null;
           		 if(s.equalsIgnoreCase("w"))
           		 {
                		f0 = new FileWriter(f,false);
                		System.out.println("CAUTION >> Please understand it will overwrite the content of the file ");
                		System.out.println("Type 'no' to exit");
                		System.out.println("Do you want to proceed :type 'yes' ");
               			in=new Scanner(System.in);
                		String s1=in.nextLine();
                		if(s1.equals("no"))
                		System.exit(0);
                		System.out.println("Write 'stop' when you finish writing file ");
                		//f.delete(); //optional karna h
                		f.createNewFile();
                		while(!(source=bf.readLine()).equalsIgnoreCase("stop")){
                	        f0.write(source + System.getProperty("line.separator"));                 
                	}               
                		in.close();
             }
            	//For appending the content
            		else
            			{ 
				    f0 = new FileWriter(f,true);
            			    System.out.println("Write 'stop' when you finish appending file ");
     			            while(!(source=bf.readLine()).equalsIgnoreCase("stop")){
        		            f0.append(source+ System.getProperty("line.separator"));
                		}
            }
         		   f0.close();        
        }
            catch(Exception e){
            System.out.println("Error : " );
            e.printStackTrace();
        } 
//*****************************************************************************************************8**8
//System.out.println("Do you also want to check the integrity of the file you are reading? If yes press 1 else press 2");
		try{
			BufferedReader bx=new BufferedReader(new InputStreamReader(System.in));
			//int ch;
			//ch = Integer.parseInt(bx.readLine());
			//System.out.println("Enter file name u want to read");
			//String fi=s3.nextLine();       //file to check integrity
			File fmd=new File("C://JAVA//Kashish.txt");  
			FileReader f3=new FileReader(fmd);
			BufferedReader bf=new BufferedReader(f3);
	    //String password = bf.readLine();
		//switch(ch)
		       //{
					try{
				        	   String password = bf.readLine();
								String hash= String.format("%032x", // produces lower case 32 char wide hexa left-padded with 0
								new BigInteger(1, // handles large POSITIVE numbers 
								MessageDigest.getInstance("MD5").digest(password.getBytes())));
								System.out.println("This is the MD5 hash for your file  : "+hash);
								}
                        catch (NoSuchAlgorithmException e) {
						e.printStackTrace();// do whatever seems relevant
						}
					//case 2: break;
					//default: System.out.println("Thannkyou, you will exit from the editor" );

		        //}
	    }
		catch(Exception e)
		{
			System.out.println(e);
		}
//********************************************************************************************************8		
     }
  }    
class FReading {
    public static String str="";
    
    public FReading() {
        			Scanner s3=new Scanner(System.in);

        try{
			System.out.println("Enter file name u want to read");
			String fq=s3.nextLine();
            File f5=new File(fq);        //choose option which file to be read
            if(! f5.exists())
            f5.createNewFile();
            FileReader fl=new FileReader(f5);
            BufferedReader bf=new BufferedReader(fl);
            //For reading till end
            while((str=bf.readLine())!=null){
                System.out.println(str);
            }
            fl.close();
            }catch(Exception e){
            System.out.println("Error : " );
            e.printStackTrace();
        }
		System.out.println("Do you also want to check the integrity of the file you are reading? If yes press 1 else press 2");
		try{
			BufferedReader bx=new BufferedReader(new InputStreamReader(System.in));
			int ch;
			ch = Integer.parseInt(bx.readLine());
			System.out.println("Enter file name u want to read");
			String fi=s3.nextLine();       //file to check integrity
			File fmd=new File(fi);  
			FileReader f3=new FileReader(fmd);
			BufferedReader bf=new BufferedReader(f3);
	    //String password = bf.readLine();
		switch(ch)
		       {
					case 1:try{
				        	   String password = bf.readLine();
								String hash= String.format("%032x", // produces lower case 32 char wide hexa left-padded with 0
								new BigInteger(1, // handles large POSITIVE numbers 
								MessageDigest.getInstance("MD5").digest(password.getBytes())));
								System.out.println("Here is the hash for your file for integrity check  : " + hash);
								}
                        catch (NoSuchAlgorithmException e) {
						e.printStackTrace();// do whatever seems relevant
						}
					case 2: break;
					default: System.out.println("Thannkyou, you will exit from the editor" );

		        }
	    }
		catch(Exception e)
		{
			System.out.println(e);
		}
    } 
}





