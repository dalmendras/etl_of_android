package cl.david;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.lynda.javatraining.filetree.FileFinder;


public class Routefile {
	
	private static final String MANZ_POLYGON_SHP = "manz_polygon.shp";
	private String filedir;
	private String filename;
	
	
	public Routefile(String filedir, String filename) {
		this.filedir = filedir;
		this.filename = filename;
	}

	public String getFiledir() {
		return filedir;
	}
	public String getFilename() {
		return filename;
	}

	public void proceso () throws IOException {
		
		Path fileDir = Paths.get(filedir);
		
		FileFinder finder = new FileFinder(MANZ_POLYGON_SHP);
		Files.walkFileTree(fileDir, finder);
		
		ArrayList<Path> foundFiles = finder.foundPaths;
		
		if (foundFiles.size() > 0) {
			for (Path path : foundFiles) {
				//System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));
				//System.out.println(path);
				System.out.println( path.getParent().getFileName().toString() );
				
			}
		} else {
			System.out.println("No files were found!");
		}
		
	}
	

}
