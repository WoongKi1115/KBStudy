package day02;

import java.io.FileInputStream;
import java.util.Scanner;

public class SystemSetInExam {

	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("src/day02/info.txt"));
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
		   String data = sc.nextLine();
		   System.out.println(data);
		}

	}

}
