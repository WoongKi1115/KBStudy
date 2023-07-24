package day04.encapsulation;

public class StudentView {

	public static void main(String[] args) {
		System.out.println("******학생 관리 프로그램******");
		
		StudentService service = new StudentService(); // 전역 변수 초기화, 생성자 호출
		
		
		System.out.println("1 전체 학생 검색하기 ------");
		Student [] arr = service.selectAll();
		for (int i = 0; i < StudentService.studentSavedSize; i++) {
			System.out.printf("%s | %d | %s%n", arr[i].getName(), arr[i].getAge(), arr[i].getAddr());
		}
		
		System.out.println("\n2.이름에 해당하는 학생 정보 검색 ------ ");
		Student st = service.selectByName("희정1");
		if (st != null) {
			System.out.printf("%s | %d | %s%n", st.getName(), st.getAge(), st.getAddr());
		} else {
			System.out.println("찾는 정보가 없습니다.");
		}
	}

}
