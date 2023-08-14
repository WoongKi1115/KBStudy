package test.board;

public class FreeBoardServiceImpl implements BoardInterface {

	@Override
	public int insert(Board board) {
		System.out.println("FreeBoardServiceImpl의 insert call");
		return 0;
	}

	@Override
	public Board selectByBno(int bno) {
		System.out.println("FreeBoardServiceImpl의 selectByBno call");
		return null;
	}

	@Override
	public int update(Board board) {
		System.out.println("FreeBoardServiceImpl의 update call");
		return 0;
	}

}
