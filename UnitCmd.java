import java.util.ArrayList;

public class UnitCmd
{
	String cmd;
	ArrayList<String> args;
	public UnitCmd() {
		cmd = new String();
		args = new ArrayList<String>(); 
	}
	//Getters and setters.
	public String getCmd() { return cmd;}
	public ArrayList<String> getArgs() {return args;}
	public void setCmd(String cmd) { this.cmd = cmd;}
	public void addArg(String arg) {args.add(arg);}
}
