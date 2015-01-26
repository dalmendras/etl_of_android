package cl.david;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import tbcargo.cl.conn.DB_SqlServer;
import tbcargo.cl.conn.DB_Type;
import tbcargo.cl.procesos.Proceso_Metodos;

public class Inicio {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		try {
			
			String qry = "Select * from vivienda";
			String pathfile = "F:\\INE\\DatosCenso2012_SQL\\vivienda.txt";
			Proceso_Metodos pro = new Proceso_Metodos();
			pro.setBdToTxt(DB_Type.SQLSERVER, qry, pathfile, false);
			
			System.out.println("Version_1");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//try 
		//{ 
			
		//String instrucc[] = {"cmd /D f:\\Turbus", "cmd /c dir"} ;
		//String instrucc[] = {"cmd /c dir"} ;
		//Process p=Runtime.getRuntime().exec(instrucc);
		//String[] cmd = {"cmd.exe","/c","dir"};
		//String[] cmd = {"/c","dir"};
		//String[] cmd = {"cmd.exe","cd /D f:\\Turbus","dir"};
		//Process p=Runtime.getRuntime().exec(cmd);
		//Process p=Runtime.getRuntime().exec("cmd /c dir F:\\Turbus");
		//Process p=Runtime.getRuntime().exec("cmd /c dir");
		
		/*
		p.waitFor(); 
		BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
		String line=reader.readLine(); 
		while(line!=null) 
		{ 
		System.out.println(line); 
		line=reader.readLine(); 
		} 

		} 
		catch(IOException e1) {} 
		catch(InterruptedException e2) {} 

		System.out.println("Done");
		*/
		
		Routefile routefile = new Routefile("F:\\GisTest\\Censo_2002_Shapes", "manz_polygon.shp");
		
		System.out.println(routefile.getFiledir());
		System.out.println(routefile.getFilename());
		routefile.proceso();
		
		
		/*
		Path fileDir = Paths.get("F:\\GisTest\\Censo_2002_Shapes");
		
		FileFinder finder = new FileFinder("manz_polygon.shp");
		Files.walkFileTree(fileDir, finder);
		
		ArrayList<Path> foundFiles = finder.foundPaths;
		
		if (foundFiles.size() > 0) {
			for (Path path : foundFiles) {
				//System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));
				//System.out.println(path);
				System.out.println( normalizar( path.getParent().getFileName().toString() ) );
				
			}
		}
		else {
			System.out.println("No files were found!");
		}
		*/
		

	}
	
	public static String normalizar (String string) {
		
		string = NormaChar.getStringNormalize(string);
		string = string.toLowerCase();
		return string;
	}

}
