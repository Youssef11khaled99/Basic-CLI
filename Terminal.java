import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.*;

public class Terminal {
	protected  void currentdate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }

    protected  void rmdir(String s) {
        File file = new File(s);
        if (s.length() == 0) {
            System.out.println("rmdir takes a directory as a parameter");
        } else {
            if (file.exists()) {
                file.delete();
                if (!file.exists()) {
                    System.out.println("Directory deleted successfully");
                }
            } else {
                System.out.println("Directory not exist");
            }
        }

    }

    protected  void mkdir(String source) {
        if (source.length() == 0) {
            System.out.println("mkdir takes a directory as a parameter");
        } else {
            File newDirectory = new File(source);
            if (!newDirectory.exists()) {
                System.out.println("creating new directory: " + newDirectory.getName());
                boolean result = false;
                try {
                    newDirectory.mkdir();
                    result = true;
                } catch (SecurityException se) {
                    System.out.println("Not secured!");
                }
                if (result) {
                    System.out.println("Directory created");
                }
            } else {
                System.out.println("The directory already exists");
            }
        }

    }

    protected  void cp(String src, String dest) throws IOException {
    	File sourceCheck = new File(src);
    	File destCheck = new File(dest);
    	if (sourceCheck.exists() && destCheck.exists())
    	{
    		Path source = Paths.get(src);
	    	Path nwdir = Paths.get(dest);
	    	
	    	Files.copy(source, nwdir.resolve(source.getFileName()), REPLACE_EXISTING);
    	}
    	else
    	{
    		System.out.println("Source or destnation dosen't exist!!");
    	}

    }

//    protected  void mv(String src, String dest) throws IOException {
//    	File sourceCheck = new File(src);
//    	File destCheck = new File(dest);
//    	if (sourceCheck.exists() && destCheck.exists())
//    	{
//			 Path source = Paths.get(src);
//			 Path nwdir = Paths.get(dest);
//		 
//			 Files.copy(source, nwdir.resolve(source.getFileName()), REPLACE_EXISTING);
//			 
//			 System.out.println("File moved");
//		}
//    	else
//    	{
//    		System.out.println("Source or destnation dosen't exist!!");
//    	}
//
//    }

    protected  void rm(String src) throws IOException {
        File Fsrc = new File(src);
        if (Fsrc.exists())
            Files.delete(Fsrc.toPath());
        else if (src.length() == 0) {
            System.out.println("rm takes one parameter the file directory");
        } else
            System.out.println("File not Exist");
    }

    protected  void cat(String file, String file2) {
        try {
        	String fullCat = "";
            FileReader fileReader = new FileReader(file);
            BufferedReader in = new BufferedReader(fileReader);
            String line;
            while ((line = in.readLine()) != null) {
                fullCat += line;
            }
            fileReader.close(); // sa3at bydrb lma ast5dm cat lazm 22flo 34an ast5do f el mv w el cp
            
            FileReader fileReader2 = new FileReader(file2);
            BufferedReader in2 = new BufferedReader(fileReader2);
            String line2;
            while ((line2 = in2.readLine()) != null) {
                fullCat += line2;
            }
            fileReader2.close(); 
            
            System.out.println(fullCat);
            
        } catch (FileNotFoundException ex) {
            System.out.println(file + ", file not found.");
        } catch (IOException ex) {
            System.out.println(file + ", input/output error.");
        }
    }

    protected  void ls(String write) throws FileNotFoundException, UnsupportedEncodingException {
        if (write.equals("over")) {
            PrintWriter writer = new PrintWriter("lsOver.txt", "UTF-8");
            File dir = new File(System.getProperty("user.dir"));
            String childs[] = dir.list();
            assert childs != null;
            for (String child : childs) {
                writer.println(child);
                writer.append(child);
            }
            writer.close();
        } else if (write.equals("reg")) {
            File dir = new File(System.getProperty("user.dir"));
            String childs[] = dir.list();
            assert childs != null;
            for (String child : childs) {
                System.out.println(child);
            }

        } else if (write.equals("app")) {
            try (FileWriter fw = new FileWriter("lsAppended.txt", true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                File dir = new File(System.getProperty("user.dir"));
                String childs[] = dir.list();
                assert childs != null;
                for (String child : childs) {
                    out.println(child);
                }

            } catch (IOException e) {
                System.out.println("Error Occurred");
            }

        }


    }

    protected  String pwd() {
        String pwd = System.getProperty("user.dir");
        return pwd;
    }

    protected  boolean cd(String directory_name) {
        boolean result = false;  // Boolean indicating whether directory was set
        File directory;       // Desired current working directory
        directory = new File(directory_name).getAbsoluteFile();
        if (directory.exists() || directory.mkdirs()) {
            result = (System.setProperty("user.dir", directory.getAbsolutePath()) != null);
        }
        return result;
    }

    protected  boolean setToCurrentDirectory(String write) throws IOException {
        boolean result = false;  // Boolean indicating whether directory was set
        File directory;
        String current = new java.io.File(".").getCanonicalPath();
        // Desired current working directory
        directory = new File(current).getAbsoluteFile();
        if (directory.exists() || directory.mkdirs()) {
            result = (System.setProperty("user.dir", directory.getAbsolutePath()) != null);
        }
        return result;
    }

    protected  void more(String filename) {
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            String sCurrentLine;
            for (int i = 0; i < 10; i++) {
                sCurrentLine = br.readLine();
                if (sCurrentLine != null) {
                    System.out.print(sCurrentLine);
                }
                while ((sCurrentLine = br.readLine()) != null) {
                    String s = new Scanner(System.in).nextLine();
                    if (s.length() == 0) {
                        System.out.print(sCurrentLine);
                    }


                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
