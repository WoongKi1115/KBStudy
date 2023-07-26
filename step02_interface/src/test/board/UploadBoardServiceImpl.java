package test.board;

public class UploadBoardServiceImpl implements BoardInterface {

	@Override
	public int insert(Board board) {
		System.out.println("UploadBoardServiceImpl의 insert call");
		return 0;
	}

	@Override
	public Board selectByBno(int bno) {
		System.out.println("UploadBoardServiceImpl의 selectByBno call");
		return null;
	}

	@Override
	public int update(Board board) {
		System.out.println("UploadBoardServiceImpl의 update call");
		return 0;
	}

}
