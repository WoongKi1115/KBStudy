package test.board;

import java.util.Collections;

public class MainApp {

	private BoardInterface service; // 
	
	public MainApp() {
		// service의 메소드 3개를 호출하기
		service = new QABoardServiceImpl();
		test(service);
		
		service = new UploadBoardServiceImpl();
		test(service);
		service = new FreeBoardServiceImpl();
		test(service);
	}
	public void test(BoardInterface service) { // 인수로 serivce 전달
		service.insert(null);
		service.selectByBno(0);
		service.update(null);
		
		// 추가된 메서드
		service.replyInsert();
		BoardInterface.selectAll(); // static 호출이므로 구현 객체 없이 호출
	}
	
	public static void main(String[] args) {
		System.out.println("*****다형성 TEST*****");
		new MainApp();
		
	}
}
