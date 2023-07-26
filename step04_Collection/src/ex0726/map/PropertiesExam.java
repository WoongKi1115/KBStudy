package ex0726.map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesExam {
	Properties pro = new Properties();
	
	public PropertiesExam() {
		// 저장
		pro.setProperty("id", "na");
		pro.setProperty("age", "29");
		pro.setProperty("name", "Woongki");
		
		// 조회
		for (String key : pro.stringPropertyNames()) {
			String value = pro.getProperty(key);
			System.out.println(key + " = " + value);
		}
		
	}
	
	/**
	 * 외부 ~.properties 파일 읽어오기
	 * 1) Io를 이용한 방법
	 * 2) ResourceBundle 이용한 방법
	 */
	
	/**
	 * 1) Io를 이용한 방법 => 자주 읽어야 할 때 사용
	 * load(InputStream) 
	 */
	public void test() {
		System.out.println("1) Io 이용한 방법");
		try {			
			pro.clear();
			pro.load(new FileInputStream("src/ex0726/map/info.properties"));
			for (String key : pro.stringPropertyNames()) {
				String value = pro.getProperty(key);
				System.out.println(key + " = " + value);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	/**
	 * 2) ResourceBundle 이용한 방법 => 한번 읽은 후 다시 읽을 일이 안생길 때 사용
	 * resourcebundle의 경로 기준은 bin 파일 기준. 때문에 위의 io와는 다름. io는 src를 기준.
	 */
	public void test2() {
		System.out.println("2) resourceBundle 이용한 방법");
		// properties를 읽는 것. 때문에 확장자까지 쓸 필요 x
		// class가 위치한 폴더를 기준으로 경로, 확장자는 생략
		ResourceBundle rb = ResourceBundle.getBundle("ex0726/map/info");
		
		for (String key : rb.keySet()) {
			String value = rb.getString(key);
			System.out.println(key + " = " + value);
		}
	}
	
	public static void main(String[] args) {
		PropertiesExam pe = new PropertiesExam();
		System.out.println("-----------------------------");
		pe.test2();
	
		
	}
}
