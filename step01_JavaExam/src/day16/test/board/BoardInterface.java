package day16.test.board;

/**
 * 모든 게시판의 공통의 기능 정의(규격서 역할)
 *
 */
public interface BoardInterface {
	// Board 타입으로 받아오고 내보낼 수 있으므로 상속의 장점.
	/**
	 * 등록하기
	 * @return 0 이면 등록 실패, 1이면 등록 성공
	 */
	int insert(Board board); // QA, FreeBoard, UploadBoard 
	
	/**
	 * 글번호로 검색하기
	 */
	Board selectByBno(int bno);  // QA, FreeBoard, UploadBoard 
	
	/**
	 * 게시물 수정하기 (글 번호에 해당하는 제목 내용을 수정)
	 */
	int update(Board board);
	
	////////////////////////////////////////////////////
	/**
	 * java 1.8 version 추가된 문법
	 * : interface 안에 default 또는 static 제한자를 메소드에 선언하면
	 *   body가 있는 메소드를 만들 수 있음.
	 *   : 공통의 기능이 있다면 미리 기능을 정의할 수 있고,
	 *     적절학 필요한 구현체에서 재정의해서 사용할 수 있다.
	 *   : 유지보수할 때 특정 interface에 메서드를 추가하게 되면
	 *     ✨ 필요없는 모든 구현 객체들이 재정의 해야하는 번거로움을 막을 수 있다.✨
	 * 1) default
	 * 	  : 반드시 구현 객체를 이용해서 사용할 수 있다.
	 * 2) static
	 * 	  : 구현 객체 없이 바로 interface 이름, 메소드 이름()을 사용할 수 있음.
	 */
	
	/**
	 * 답변 등록
	 */
	default void replyInsert() {
		System.out.println("답변등록입니다........");
	};
	
	static void selectAll() {
		System.out.println("selectAll    입니다.....");
	};

}
