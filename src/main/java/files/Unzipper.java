package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unzipper {

	private final String m_zipFileName;
	
	/** 
	 * Create an instance of Unzipper to unzip an existing zip archive.
	 * 
	 * @param zipFilename the existing archive to be unzipped
	 */
	public Unzipper(String zipFilename) { m_zipFileName = zipFilename; }

	/**
	 * Unzips the archive to a specified output folder, creating it, if necessary.
	 * 
	 * @param outputFolder the output folder to zip to.
	 */
	public void unzipTo(String outputFolder) {

		// Set up a buffer to store bytes read from the zip archive
		byte[] buffer = new byte[1024];

		// Create an input stream from an existing zip archive, and close it when we're done
		try (ZipInputStream zis = new ZipInputStream(new FileInputStream(m_zipFileName)) ) {
			
			System.out.println("Reading from zip archive: " + m_zipFileName);

			// Create output directory is not exists
			File folder = new File(outputFolder);			
			if ( !folder.exists() ) folder.mkdir();

			// Loop for as long as we can get entries from the zip archive
			ZipEntry zipItem;
			while ( (zipItem = zis.getNextEntry()) != null) {

				// Set up an output file.  Since we are just going to write the files in whatever order 
				// we find them in the zip archive, we have to be sure that there is an appropriate folder 
				// for it in the output directory, and if not, we create it.
				File out = new File(outputFolder + File.separator + zipItem.getName());
				new File(out.getParent()).mkdirs();
				
				// Open up the output file for streaming
				FileOutputStream fos = new FileOutputStream(out);             
				System.out.println("Unzipping: " + out);

				// For as long as we can read bytes from the zip archive to the buffer 
				// for the current item, write to the output file.
				int len;
				while ((len = zis.read(buffer)) > 0) { fos.write(buffer, 0, len); }

				// Close the zip entry and output file
				fos.close();
				zis.closeEntry();
				
			} // while zipItem

		} catch (IOException ex) {
			ex.printStackTrace(); 
		}
		
	} // unzipTo
	
	
	// Open an existing zip archive called "ZipDemo.zip" and extract the contents to the "Unzipped Files" folder
	public static void main(String[] args) { new Unzipper("ZipDemo.zip").unzipTo("Unzipped Files"); }

	
} // Unzipper
