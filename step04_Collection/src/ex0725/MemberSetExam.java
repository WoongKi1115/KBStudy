package ex0725;

import java.util.HashSet;
import java.util.Set;

public class MemberSetExam {
	Set<Member> set = new HashSet<>();
	
	
	public MemberSetExam() {
		set.add(new Member("웅기", 21, "서울"));
		set.add(new Member("나영", 21, "광주"));
		set.add(new Member("희정", 21, "대구"));
		
		System.out.println("저장된 객체 개수 : " + set.size());
	}
	
	public static void main(String[] args) {
		new MemberSetExam();
	}
}
