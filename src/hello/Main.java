package hello;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

	public static String path = "/Users/cloudchan/Desktop/";
	
	public static void main(String[] args) throws UnknownHostException {
//		FileEncoder encoder = new FileEncoder();
//		encoder.encode(path+"eapi.lua", path+"E.dat");
//		encoder.decode(path+"E.dat", path+"E.lua");
		
//		String md5 = MD5.encode("陈新星妹夫");
//		System.out.println(md5);
		
		System.out.println(InetAddress.getLocalHost());
		
	}

	
}
