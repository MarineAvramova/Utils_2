import java.io.File;
import java.text.SimpleDateFormat;
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.util.stream.Stream;
//import java.nio.file.Files;
//import java.nio.file.Path;
import java.util.Date;
  

public class RecursivlyListFiles {
	
	
			public static void main(String[] argvs)  {  
				// Providing the full path for the directory
				String path = "C:\\Users\\Marine\\Documents";
				// creating a file object
				File fObj = new File(path);
				// creating on object of the class DisplayFileExample1
				RecursivlyListFiles obj = new RecursivlyListFiles();

				if (fObj.exists() && fObj.isDirectory()) {
					// array for the files of the directory pointed by fObj
					File a[] = fObj.listFiles();
					// display statements
					System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
					System.out.println("Displaying Files from the directory: " + fObj);
					System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
					// Calling the method
					obj.printFileNames(a, 0, 0);
				}
			}

			public void printFileNames(File[] a, int i, int lvl) {
				// Check if the file array is null
				if (a == null) {
					return;
				}
				// base case of the recursion
				// i == a.length means the directory has
				// no more files. Hence, the recursion has to stop
				if (i == a.length) {
					return;
				}
				// tabs for providing the indentation
				// for the files of sub-directory
				for (int j = 0; j < lvl; j++) {
					System.out.print("\t");
				}
				// checking if the encountered object is a file or not
				if (a[i].isFile()) {
					// Get the last modified date of the file
					Date lastModifiedDate = new Date(a[i].lastModified());
					// Format the date to a human-readable form
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String formattedDate = dateFormat.format(lastModifiedDate);

					// Print file name and last modified date
					System.out.println("File: " + a[i].getName() + " Last Modified: " + formattedDate);
				}
				// for sub-directories
				else if (a[i].isDirectory()) {
					System.out.println("Is Directory: " + "[" + a[i].getName() + "]");
					// recursion for sub-directories
					printFileNames(a[i].listFiles(), 0, lvl + 1);
				}
				// recursively printing files from the directory
				// i + 1 means look for the next file
				printFileNames(a, i + 1, lvl);
			}

		}
		

		