
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
    	   	
   	 
   	 String command;
    
        // Verification 
        while (true)  {
        	Verify verifyObject = new Verify();
        	 command = new Scanner(System.in).nextLine();
        	if (command.equals("exit"))
 			{
 				System.out.println("**************Terminated***************");
 				return;
 			}
        	 Parser parserObject = new Parser(command); 
        	 ArrayList<UnitCmd> units = parserObject.getUnits();
        	 verifyObject.write = "reg";        	 
        	 if (parserObject.parse())
        	 {
        		 for ( int i = 0; i < units.size(); i++)
        		 {
        			String cmd = units.get(i).getCmd();
        			ArrayList <String> arguments = units.get(i).getArgs();		
        			if (cmd.equals(" "))
        			{
        				verifyObject.vr_empty();
        			}
        			else if (cmd.equals ("clear"))
        			{
        				verifyObject.vr_clear();
        			}
        			else if (cmd.equals ("cd"))
        			{
        				verifyObject.vr_cd(arguments);
        			}
        			else if (cmd.equals ("ls"))
        			{
        				verifyObject.vr_ls(arguments);
        			}
        			else if (cmd.equals ("cp"))
        			{
        				verifyObject.vr_cp(arguments);
        			}
        			else if (cmd.equals ("mv"))
        			{
        				verifyObject.vr_cp(arguments);
        				ArrayList <String> a = new ArrayList <String>();
        				a.add(arguments.get(0));
        				verifyObject.vr_rm(a);
        			}
        			else if (cmd.equals ("rm"))
        			{
        				verifyObject.vr_rm(arguments);
        			}
        			else if (cmd.equals ("mkdir"))
        			{
        				verifyObject.vr_mkdir(arguments);
        			}
        			else if (cmd.equals ("rmdir"))
        			{
        				verifyObject.vr_rmdir(arguments);
        			}
        			else if (cmd.equals ("cat"))
        			{
        				verifyObject.vr_cat(arguments);
        			}
        			else if (cmd.equals ("more"))
        			{
        				verifyObject.vr_more(arguments);
        			}
        			else if (cmd.equals ("pwd"))
        			{
        				verifyObject.vr_pwd (arguments);
        			}
        			else if (cmd.equals ("date"))
        			{
        				verifyObject.vr_date(arguments);
        			}
        			else if (cmd.equals ("help"))
        			{
        				verifyObject.vr_help();
        			}
        			else
        			{
        				verifyObject.vr_default();
        			}
        		 }
        	 }
        	 else {System.out.println("Please enter a valid command!!");}
        	 
        	//Here we make object of Parser and call Parser.parse(command)
        	//if parse returned true
        		//Execute the code of the commands
        	//else
        		//Go back to take valid input from user
        	
        }
    }
}
