package hello;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileEncoder {

	public void encode(String sourcePath , String targetPath) {
		try {
			DataInputStream in = new DataInputStream(new FileInputStream(new File(sourcePath)));
			byte[] ss = in.readAllBytes();
			in.close();
			
			byte[] bytes = new SuperEncoder().encode(ss, 1);
			
			DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(targetPath)));
			out.write(bytes);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void decode(String sourcePath , String targetPath) {
		try {
			DataInputStream in = new DataInputStream(new FileInputStream(new File(sourcePath)));
			byte[] ss = in.readAllBytes();
			in.close();
			
			byte[] bytes = new SuperEncoder().decode(ss, 1);
			
			DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(targetPath)));
			out.write(bytes);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
