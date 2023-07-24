package day03.constructor;

public class StudentView {

	public static void main(String[] args) {
		System.out.println("****학생 관리 프로그램 *******");
		
		StudentService service =  new StudentService();//전역변수초기화,  생성자 호출
		
		System.out.println("1. 전체학생 검색하기 -----");
		Student [] arr = service.selectAll();
		//System.out.println("arr = "  + arr);//배열의 주소
		/*for(Student s : arr) {
			System.out.printf("%s | %d | %s%n",s.name,s.age,s.addr);
		}*/
		
		for(int i=0; i< StudentService.studentSavedSize ; i++) {
			Student s = arr[i];
			System.out.printf("%s | %d | %s%n",s.name,s.age,s.addr);
		}
		
		
		System.out.println("\n2. 이름에 해당하는 학생 정보 검색 -----");
	     Student st = service.selectByName("희정13");
	     if(st != null) {
	    	 System.out.printf("%s | %d | %s%n",st.name,st.age,st.addr);
	     }else {
	    	System.out.println("찾는정보가 없습니다.!!!"); 
	     }

	}

}




