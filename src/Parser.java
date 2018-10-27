import java.util.ArrayList;


public class Parser {
	
	String usrStream;//To copy the user stream in it.

	ArrayList<UnitCmd> units = new ArrayList<UnitCmd>();
	
	public Parser(String usrStream) {
		this.usrStream = new String(usrStream);
	}
	
	//Getters.
	public ArrayList<UnitCmd> getUnits() { return units;}
	//End getters.
	
	//Utility functions.
	boolean equalsCmd(String stream)
	{

		if(
			stream.equals("clear") 	||
			stream.equals("cd") 	||
			stream.equals("ls") 	||
			stream.equals("cp") 	||
			stream.equals("mv") 	||
			stream.equals("rm") 	||
			stream.equals("mkdir") 	||
			stream.equals("rmdir") 	||
			stream.equals("cat") 	||
			stream.equals("more") 	||
			stream.equals("pwd") 	||
			stream.equals("args") 	||
			stream.equals("date") 	||
			stream.equals("help") )
				return true;
		else
			return false;
	}
	//End utility functions
	

	public boolean parse()
	{
		String[] parts = usrStream.split(" ");
		ArrayList<String> partsAL = new ArrayList<String>();
		for(String part: parts )//Add the elements of the string array to the ArrayList<String> partsAL, as ArrayList is easier to manipulate.
			partsAL.add(part);
		
		UnitCmd unit = new UnitCmd();
		for(int i=0; i<partsAL.size(); i++)//To loop through the ArrayList<String>.
		{
			String part = partsAL.get(i);//Temp of every String in the ArrayList<String>

			if(i == 0) { 
				if(equalsCmd(part))
					unit.setCmd(part);
				else {
					System.out.println("Sorry, " + part + " is not recogized as a CL command. Try again with a defined one.");
					return false;
				}	
			}//If first element
			else if(part.equals("|")) {//If you found "|"
				units.add(unit);//Add the unit I got to the list of units( ArrayList<UnitCmd> units) because this is the end
								//of a command with its parameters
				i++;
				String temp = partsAL.get(i);
				unit = new UnitCmd();//Create new unit as we've added the previous to the list of units.
				if(equalsCmd(temp))//Check if it is a defined command.
					unit.setCmd(temp) ;//Copy the command to the cmd in UnitCmd.
				else {
					System.out.println("Sorry, " + temp + " is not recogized as a CL command. Try again with a defined one.");
					return false;
				}
				
			}
			else{ unit.addArg(part); }
			
		}
		units.add(unit);//Adds the last unit that we've not taken.
		
		return true;
	}

}

