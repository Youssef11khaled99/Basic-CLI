import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Verify  {
	 String write = "reg";
	 StringBuilder terminal = new StringBuilder();
	 StringBuilder directory = new StringBuilder();
	 StringBuilder file = new StringBuilder();
	 StringBuilder destination = new StringBuilder();
	 StringBuilder source = new StringBuilder();
	 Terminal terminalObject = new Terminal();
	
	 String current;
	public Verify() {
		current = new String(terminalObject.pwd());
		terminal.append(current + " >> ");
	  	System.out.print(terminal.toString());
	}
	
	public void vr_empty() 
	{
		System.out.println("Enter the command");
    }
	
	public void vr_clear()
	{
		terminal.delete(0, terminal.length());
        terminal.append(current);
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
	}
	
	public void vr_cd(ArrayList <String> args) throws IOException, InterruptedException
	{
		int argSize = args.size();
		String arg = "";
		if (argSize == 1)
		{
			arg = args.get(0);
		}
		else if (argSize > 1)
		{
			System.out.println("cd takes only one parameter!!");
		}
		 
        if (arg.equals("args")) {
            System.out.println("Takes the file directory as a parameter");
        } else {
           
            if (arg.equals(">")) { //cd >
                write = "over";
                terminalObject.setToCurrentDirectory(write);
            }
            else if (args.isEmpty())
            {
	            terminalObject.setToCurrentDirectory(write);
	            if (!terminalObject.setToCurrentDirectory(write)) 
	            {
	                System.out.println("Error Occurred");
	            } 
            } 
            else 
            {
	            for (int i = 0; i < arg.length(); i++) 
	            {
	                directory.append(arg.charAt(i));
	            }
	
	            terminalObject.cd(directory.toString());
	            directory.delete(0, directory.length());
	            if (!terminalObject.cd(directory.toString())) 
	            {
	                System.out.println("Error Occurred");
	            } 
            }
        }
        
        
         
	}

	public void vr_pwd(ArrayList <String> args)
	{
		if (args.isEmpty() == true)
		{
			terminalObject.pwd();
            System.out.println(terminalObject.pwd());
		}
		else 
		{
			System.out.println("pwd takes no parameter");
		}
	}
	
	public void vr_ls (ArrayList <String> args) throws IOException, InterruptedException
	{
		int argSize = args.size();
		String arg="";
		if (argSize == 1)
		{
			arg  = args.get(0);
		}
		else if (argSize > 1)
		{
			System.out.println("ls takes only one parameter or no parameter!!");
			return;
		}
		
        if (arg.equals("args")) 
        {
            System.out.println("ls takes no parameter" + "\n- add > or >> to write on a external file" + "\n- " +
                    "> to overwrite on the file" + "\n" + "- >> to append on the file");
        } 
        else 
        {
			if (arg.equals(">")) 
            {
                write = "over";
                terminalObject.ls(write);
                write = "reg";
            } 
            else if ( arg.equals(">>") )
            {
                write = "app";
                terminalObject.ls(write);
                write = "reg";
            } 
            else 
            {
            	terminalObject.ls(write);
            }
        }

	}
	 
	public void vr_cat (ArrayList <String> args)
	{
		int argSize = args.size();
		String arg="";
		if (argSize == 1)
		{
			arg  = args.get(0);
		}
		else if (argSize > 1)
		{
			System.out.println("cat takes only two parameter!!");
		}
        if (arg.equals("args")) {
            System.out.println("cat (Concatenate) takes a file as a parameter");
        } else if (arg.equals("?")) {
            System.out.println("[cat] takes a file as a parameter");
            System.out.println("[cat] return the content of any file");
        } else {
               terminalObject.cat(args.get(0), args.get(1));
        }
	}
	
	public void vr_help()
	{
		System.out.println("[cat]  reads files sequentially, writing them to standard output.");
        System.out.println("[cp] Copy SOURCE to DEST, or multiple SOURCE(s) to DIRECTORY");
        System.out.println("[mv] moves one or more files or directories from one place to another");
        System.out.println("[rm] command used to remove objects such as files, directories");
        System.out.println("[mkdir] is used to make a new directory");
        System.out.println("[rmdir] is used to remove a new directory");
        System.out.println("[more] more is a command to view the contents of a text file one screen at a time");
        System.out.println("[date] used to display the current date");
        System.out.println("[pwd] used to display the current directory");
	}
	
	public void vr_cp(ArrayList <String> args) throws IOException, InterruptedException
	{
		boolean check = true;
		if ( args.size() > 2 || args.size() < 1)
		{
			System.out.println("[cp] takes two directories as a parameter the first is the source the second is the destination");
			check = false;
		}
        if (args.get(0).equals("args"))
        {
            System.out.println("cp (copy) takes two parameter the source file and the destination directory");
        } 
        else if (args.get(0).equals("?")) 
        {
            System.out.println("[cp] takes two directories as a parameter the first is the source the second is the destination");
        } 
        else if (check == true)
        {
            if (!String.valueOf(args.get(0)).equals(" ")) 
            {
                source.append(args.get(0));
            }
            
            if (!String.valueOf(args.get(1)).equals(" ")) 
            {
                destination.append(args.get(1));
            } 
        	
            terminalObject.cp(source.toString(), destination.toString());
            source.delete(0, source.length());
            destination.delete(0, destination.length());
        }

		
		
    
	    
	}
	
//	public void vr_mv(ArrayList <String> args) throws IOException, InterruptedException
//	{
//		
//		if (args.size() == 1)
//		{
//			if (args.get(0).equals("args")) 
//	        {
//	            System.out.println("mv (move) takes two parameter the source file and the destination directory");
//	        } 
//	        else if (args.get(0).equals("?")) 
//	        {
//	            System.out.println("[mv] takes two arguments as a parameter source and the destination");
//	        }
//	        else 
//	        {
//	        	System.out.println("[mv] takes two parameters the first parameter the file the second is the folder");
//	        }
//		}
//		else if (args.size() == 2)
//		{
//            if (!String.valueOf(args.get(0)).equals(" ")) 
//            {
//                source.append(args.get(0));
//            } 
//            
//            if (!String.valueOf(args.get(1)).equals(" ")) 
//            {
//                destination.append(args.get(1));
//            }
//            
//            terminalObject.mv(source.toString(), destination.toString());
//            source.delete(0, source.length());
//            destination.delete(0, destination.length());
//	       
//		}
//		else
//		{
//			System.out.println("[mv] takes two parameters the first parameter the first is the source the second is the destination");
//			return;
//		}
//		
//        
//
//	}
	
	public void vr_rm(ArrayList <String> args) throws IOException, InterruptedException
	{
		int argSize = args.size();
		
		String arg="";
		
		if (argSize == 1)
		{
			arg  = args.get(0);
		}
		else if (argSize > 1)
		{
			System.out.println("mv takes only one parameter!!");
		}
        if (arg.equals("args")) 
        {
            System.out.println("rm (remove) takes the file needed to be deleted directory as a parameter");
        } 
        else if (arg.equals("?")) 
        {
            System.out.println("[rm] takes one directory as a parameter");
        } 
        else 
        {  
            if (!String.valueOf(arg).equals(" ")) 
            {
            	for (int i = 0; i < arg.length(); i++) 
                {
                    source.append(arg.charAt(i));
                }
            } 
            else 
            {
            	System.out.println("rm (remove) takes the file needed to be deleted directory as a parameter no an empty string (\" \") ");
            }
            terminalObject.rm(source.toString());
            source.delete(0, source.length());
        }

	     
	}

	public void vr_mkdir(ArrayList <String> args) throws IOException, InterruptedException
	{
		int argSize = args.size();
		String arg="";
		if (argSize == 1)
		{
			arg  = args.get(0);
		}
		else if (argSize > 1)
		{
			System.out.println("mkdir takes only one parameter!!");
		}
        if (arg.equals("args")) 
        {
            System.out.println("mkdir takes a directory as a parameter");
        } 
        else if (arg.equals("?")) {
            System.out.println("[mkdir] is used to make a new directory");
        } 
        else 
        {
            
                if (!String.valueOf(arg).equals(" ")) 
                {
                	for (int i = 0; i < arg.length(); i++) 
                    {
                        source.append(arg.charAt(i));
                    }
                } 
                else 
                {
                	System.out.println("mkdir mkdir takes a directory as a parameter not an empty string (\" \") ");
                }
            
            terminalObject.mkdir(source.toString());
            source.delete(0, source.length());
        }
		
	}
	
	public void vr_rmdir(ArrayList <String> args) throws IOException, InterruptedException
	{
		int argSize = args.size();
		String arg="";
		if (argSize == 1)
		{
			arg  = args.get(0);
		}
		else if (argSize > 1)
		{
			System.out.println("rmdir takes only one parameter!!");
		}
        if (arg.equals("args")) 
        {
            System.out.println("rmdir takes a directory as a parameter");
        } 
        else if (arg.equals("?")) 
        {
            System.out.println("[rmdir] is used to remove a new directory");
        } 
        else 
        {
            for (int i = 0; i < arg.length(); i++) 
            {
                source.append(arg.charAt(i));
            }
            terminalObject.rmdir(source.toString());
            source.delete(0, source.length());
        }
		 
	}

	public void vr_more(ArrayList <String> args)
	{
		int argSize = args.size();
		String arg="";
		if (argSize == 1)
		{
			arg  = args.get(0);
		}
		else if (argSize > 1)
		{
			System.out.println("more takes only one parameter!!");
		}
        if (arg.equals("args")) 
        {
            System.out.println("more takes file directory as a parameter");
        } 
        else 
        {
            StringBuilder filename = new StringBuilder();
            for (int i = 0; i < arg.length(); i++) 
            {
                filename.append(arg.charAt(i));
            }
            terminalObject.more(filename.toString());
        }
	}
	
	public void vr_date(ArrayList <String> args)
	{
		int argSize = args.size();
		String arg="";
		if (argSize == 1)
		{
			arg  = args.get(0);
		}
		else if (argSize > 1)
		{
			System.out.println("date takes only one parameter!!");
		}
        if (arg.equals("args")) 
        {
            System.out.println("date takes no parameter");
        } 
        else 
        {
        	terminalObject.currentdate();
        }
	}
	
	public void vr_default ()
	{
        System.out.println("No such Command");
        terminal.delete(0, terminal.length());
        terminal.append(current);
	}

}
