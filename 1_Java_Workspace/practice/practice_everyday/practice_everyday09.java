import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class practice_everyday09 {
		
		// 1.바이트 기반+보조
		// 2.문자 기반+보조
		
		
		// 1.바이트 기반+보조 : 입력
	public void Stream_outputByte() {
		// 목적 : 파일에 바이트기반으로 데이터를 빠르게 쓰고 싶다
		FileOutputStream fos;
		BufferedOutputStream bos = null;
		try {
			fos = new FileOutputStream("D:\\test\\test.txt");
			bos = new BufferedOutputStream(fos);
			
			bos.write(65);
			byte[] arr = {66,67,68,69};
			bos.write(arr);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void Stream_inputByte() {
		// 목적 :파일에 있는 데이터를 바이트 기반으로 빠르게 읽어오고 싶다
		FileInputStream fis;
		try {
			fis = new FileInputStream("D:\\test\\test.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			int val;
			while((val=bis.read()) != -1) {
				System.out.println(val);
			}	
		} catch (IOException e) { // IOE
			e.printStackTrace();
		}
		
		

	// 2.문자 기반+보조

		
		
	}	
}