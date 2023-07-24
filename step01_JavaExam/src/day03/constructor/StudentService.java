package day03.constructor;

/**
 * 학생들의 정보를 관리하는 Businness Logic 클래스
 * ex) 등록, 수정, 삭제, 전체 검색, 부분 검색
 */
public class StudentService {
	
	Student [] stArr = new Student[10];
	static int studentSavedSize = 0;
	/**
	 * 학생 5명 초기화하기
	 */ 
	// 생성자로 만들어줌
	public StudentService() {
		// 5명 
	    System.out.println("생성자 호출됨");
	  	    
		stArr[studentSavedSize++] = new Student("희정1", 23, "서울");
		stArr[studentSavedSize++] = new Student("희정2", 21);
		stArr[studentSavedSize++] = new Student("희정3", 27, "대구");
		stArr[studentSavedSize++] = new Student("희정4", 29, "부산");
		stArr[studentSavedSize++] = new Student("희정5", 24);	
		
		System.out.println("생성자 호출됨");
	    for (Student s : stArr) {
	    	System.out.println(s);
	    }
	}
	
	/**
	 * 전체 학생 검색
	 */
	public Student[] selectAll() {
		
		return stArr;
	}
	
	/**
	 * 이름에 해당하는 학생 정보 검색(이름은 중복안됨 = pk)
	 * @return : 찾는 경우 Student 리턴, 없는 경우 null
	 * @param : 찾을 이름 정보
	 */
	public Student selectByName (String name) {
		for (int i = 0; i<studentSavedSize; i++) {
			// String은 == 으로 비교할 수 없음. 
			// equals : 왼쪽의 문자열과 인수의 문자열을 비교.
			if (stArr[i].name.equals(name)) {
				return stArr[i];
			}
		}
		return null;
	}
	
}
