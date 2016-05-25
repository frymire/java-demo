
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.util.List;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zipper {

	private final String m_zipFileName;
	
	public Zipper(String zipFileName) { m_zipFileName = zipFileName; }

	/**
	 * Zip a file or all of the elements of a folder recursively.
	 * 
	 * @param sourceName A file or folder name to be added to the zip archive.
	 */
	public void zip(String sourceName){
		
		List<String> fileList= new ArrayList<String>();
		generateFileList(new File(sourceName), fileList);

		byte[] buffer = new byte[1024];

		try (ZipOutputStream zipArchive = new ZipOutputStream(new FileOutputStream(m_zipFileName) ) ) {

			System.out.println("Writing to zip archive: " + m_zipFileName);

			// Loop over the files on the file list
			for (String file: fileList) {

				// Start a new entry within the archive
				System.out.println("Writing file: " + file);
				zipArchive.putNextEntry(new ZipEntry(file));

				// Open up the input file for streaming
				FileInputStream in = new FileInputStream(file);

				// For as long as we can read in bytes from the input file to the buffer, write them to the zip stream
				int len;
				while ( (len = in.read(buffer)) > 0) { zipArchive.write(buffer, 0, len); }

				// Close the input file and the current zip entry
				in.close();
				zipArchive.closeEntry();

			} // file
			
		} catch (IOException ex) {
			ex.printStackTrace();   
		}
		
	} // zipIt()
	

	/**
	 * Traverse a directory and get all files, and add the file into fileList
	 *   
	 * @param node file or directory
	 * @param fileList a running list of files to be added
	 */
	private void generateFileList(File node, List<String> fileList) {
		
		// If the node is a file, add it
		if (node.isFile()) { fileList.add(node.toString()); return; }

		// If it's a directory, recursively call this method on every subnode in the directory
		if (node.isDirectory()) {			
			String[] subNode = node.list();
			for(String fileName: subNode) { generateFileList(new File(node, fileName), fileList); }
		}

	} // generateFileList()
	

	// Start a new zip archive, and add to it everything under the "src" folder
	public static void main(String[] args) { new Zipper("ZipDemo.zip").zip("src"); }

}
