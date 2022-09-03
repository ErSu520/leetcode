package hello;

public class SuperEncoder {
	
	/**
	 *	该方法加密比特数组时会使用多种加密手段
	 *	1.取反加密
	 *	2.异或加密
	 *	3.插入加密
	 * @param bytes	需要被加密的比特数组
	 * @param insert 用来插入的比特集合
	 * @param density 插入密度 即隔多少个比特插入
	 * @return
	 */
	public byte[] encode(byte[] bytes, int density) {
		byte[] temp = nagateEncode(bytes);
		exorEncode(temp, (byte)0x10);
		return insertEncode(temp, bytes, density);
	}
	
	/**
	 * 	按位取反式的将比特数组加密
	 * @param bytes	需要被加密的比特数组
	 */
	public byte[] nagateEncode(byte[] bytes) {
		byte[] temp = new byte[bytes.length];
		for(int i=0;i<bytes.length;i++) {
			temp[i] = (byte) ~bytes[i];
		}
		return temp;
	}
	
	/**
	 * 	使用比特关键词与数组每一位相异或来加密
	 * @param bytes 需要被加密的比特数组
	 * @param key 用来加密的关键字
	 */
	public void exorEncode(byte[] bytes, byte key) {
		for(int i=0;i<bytes.length;i++) {
			bytes[i] = (byte) (bytes[i]^key);
		}
	}
	
	/**
	 *	向比特数组插入一些字符式的将比特数组加密
	 * @param bytes	需要被加密的比特数组
	 * @param insert 用来插入的比特集合
	 * @param density 插入密度 即隔多少个比特插入
	 * @return
	 */
	public byte[] insertEncode(byte[] bytes , byte[] insert , int density) {
		byte[] newBytes = new byte[bytes.length+bytes.length/density];
		int index = 0 , offset = 0;
		for(int i=0;i<bytes.length;i++) {
			newBytes[index++] = bytes[i];
			offset++;
			if(offset==density) {
				newBytes[index++] = insert[i/density];
				offset=0;
			}
		}
		return newBytes;
	}
	
	
	
	/**
	 * 该方法解密比特数组时会使用多种加密手段
	 *	1.取反解密法
	 *	2.异或解密法
	 *	2.插入解密法
	 * @param bytes	需要被解密的比特数组
	 * @param density 插入密度 即隔多少个比特插入
	 * @return
	 */
	public byte[] decode(byte[] bytes , int density) {
		byte[] temp = insertDecode(bytes, density);
		exorDecode(temp, (byte)0x10);
		return	nagateDecode(temp);
	}
	
	/**
	 * 	按位取反式的将比特数组解密
	 * @param bytes	需要被加密的比特数组
	 */
	public byte[] nagateDecode(byte[] bytes) {
		return nagateEncode(bytes);
	}
	
	/**
	 * 	使用比特关键词与数组每一位相异或来加密
	 * @param bytes 需要被解密的比特数组
	 * @param key 用来解密的关键字
	 */
	public void exorDecode(byte[] bytes, byte key) {
		exorEncode(bytes, key);
	}
	
	/**
	 *	解密使用插入法加密的比特数组
	 * @param bytes	需要被解密的比特数组
	 * @param density 插入密度 即隔多少个比特插入
	 * @return
	 */
	public byte[] insertDecode(byte[] bytes , int density) {
		byte[] newBytes = new byte[bytes.length-bytes.length/(density+1)];
		int index = 0 , offset = 0;
		for(int i=0;i<bytes.length;i++) {
			offset++;
			if(offset==density+1) {
				offset=0;
			}else {
				newBytes[index++] = bytes[i];
			}
		}
		return newBytes;
	}
	
	
	
	
	
	
	
}
