package jdbc.app;
import java.util.List;
import jdbc.dao.UserDAOImpl;
import jdbc.dto.UserDto;

public class Test {

	public static void main(String[] args) {
		
			// #1. users table 에 insert 1건 처리를 위해 insert() 를 완성한다.
			insert();
			// #2. users table 에 update 1건 처리를 위해 update() 를 완성한다.
			update();
			// #3. users table 을 전체 조회, 출력하는 selectAll() 를 완성한다.
			selectAll();
			// #4. users table 을 user_seq 로 1건  조회, 출력하는 selectOne() 를 완성한다.
			selectOne();
			// #5. users table 을 user_seq 로 1건  삭제하는 delete() 를 완성한다.
			delete();
	}
	
	static void insert() {
		UserDto userDto = new UserDto();
		userDto.setUserSeq(666);
		userDto.setName("육길동");
		userDto.setEmail("six@gildong@com");
		userDto.setPhone("010-6666-6666");
		userDto.setSleep(false); // DB에 넣을때 true이면 Y , false이면 N의 값으로 저장한다.
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		int result = userDAOImpl.insert(userDto);
		if(result >0) System.out.println("등록되었습니다.");
		else System.out.println("등록되지않았습니다.");
	}
	
	static void update() {
		
		UserDto userDto = new UserDto();
		userDto.setUserSeq(666);
		userDto.setName("육길동");
		userDto.setEmail("yook@gildong@com");
		userDto.setPhone("010-7777-7777");
		userDto.setSleep(true);
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		int result = userDAOImpl.update(userDto);
		if(result >0) System.out.println("변경되었습니다.");
		else System.out.println("변경되지않았습니다.");
		 //dao 호출하고 리턴한 값을 받아서 상황에 맞게 출력해본다.
		
	}
	
	static void selectAll() {
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		List<UserDto> list = userDAOImpl.selectAll();
		for (UserDto u : list) {
			System.out.println(u);
		}
		 
	}
	
	static void selectOne() {
		
		int userSeq = 666;
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		UserDto dto = userDAOImpl.selectOne(userSeq);
		System.out.println(dto);
		 //dao 호출하고 리턴한 값을 받아서 상황에 맞게 출력해본다.
		
		
	}
	
	static void delete() {
		
		int userSeq = 666;
		 //dao 호출하고 리턴한 값을 받아서 상황에 맞게 출력해본다.
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		int result = userDAOImpl.delete(userSeq);
		if(result >0) System.out.println("삭제되었습니다.");
		else System.out.println("삭제되지않았습니다.");
	}
}
