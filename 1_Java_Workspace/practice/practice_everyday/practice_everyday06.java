import java.io.File;
import java.io.IOException;

public class practice_everyday06 {
	
	public static void main(String[] args) {
		
	File f = new File("D:\\file\\file1.txt");		// 경로지정 방법1
//	File f = new File("D:/file.txt");  		// 경로지정 방법2
//	File f = new File("D:/file.txt",true);  // ,true : 파일 내용 추가
		
		f.mkdir();  // 해당 디렉토리 생성. 생성하려는 폴더 직전까지의 경로가 다 생성되어있어야 생성하려는 폴더 생성가능
					// 경로 생성이 제대로 안되어있으면 생성이 안될 뿐 에러발생은 안난다
		f.mkdirs(); // 해당 디렉토리 생성. 생성하려는 폴더 직전까지 없는 경로도 같이 생성
		
		f.exists(); // true
		f.isFile(); // false
		System.out.println(f.exists());
		System.out.println(f.isFile());
		
	File ff = new File("D:\\file\\file2");
		System.out.println(ff.exists()); // false
		System.out.println(ff.isFile()); // false
		
		ff.mkdirs();	// 파일 생성 
		System.out.println(ff.exists()); // true
		System.out.println(ff.isFile()); // false
		System.out.println();
		
		System.out.println(ff.getName()); // file2
		System.out.println(ff.getAbsolutePath());  // D:\file\file2
		System.out.println(ff.getPath()); //상대경로 // D:\file\file2
		System.out.println(ff.length()); 		  // 0
		System.out.println(ff.getParent()); 	  // D:\file
		
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}	
}