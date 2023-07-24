package day03.constructor;

/**
 * 학생들의 정보를 관리하는 Businness Logic 클래스 
 *   ex) 등록, 수정, 삭제, 전제검색, 부분검색.....
 * */
public class StudentService {
	
	Student [] stArr = new Student [10];
	
   static int studentSavedSize = 0;
	
	/**
	 * 학생 5명 초기화 하기 
	 * */
	public StudentService() {
		//5명
		System.out.println("생성자 호출됨... stArr = " + stArr);
		stArr[studentSavedSize++]  = new Student("희정1",23,"서울");
		stArr[studentSavedSize++]  = new Student("희정2",21);
		stArr[studentSavedSize++]  = new Student("희정3",33,"서울");
		stArr[studentSavedSize++]  = new Student("희정4",55,"부산");
		stArr[studentSavedSize++]  = new Student("희정5",11);
		
		
		
//		for(Student s:stArr) {
//			System.out.println(s.name);//null
//		}
		
	}
	
	/**
	 * 전체학생 검색
	 * */
	public Student[] selectAll(){
		//실제로 저장된 Student 를 새로운 배열로 생성해서 리턴
		// Student savedStudent [] = new Student [studentSavedSize];
		
		return stArr;
	}
	
	/**
	 *  이름에 해당하는 학생정보 검색(이름은 중복안됨 = pk)
	 *  @return : 찾는 경우 Student 리턴,  없는경우 null
	 *  @param : 찾을 이름정보
	 * */
	public Student selectByName(String name){
		/*for(Student st : stArr) {
			if( st.name.equals(name) ) {//왼쪽의문자열과 인수의 문자열비교
				//찾았다.
				return st;
			}
		}*/
		
		for(int i=0; i < studentSavedSize ; i++) {
			if( stArr[i].name.equals(name) ) {//왼쪽의문자열과 인수의 문자열비교
				//찾았다.
				return stArr[i];
			}
		}
		
		return null;
	}
	
  
	
}









