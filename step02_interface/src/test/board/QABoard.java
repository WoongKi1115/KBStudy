package test.board;

/**
 * 
 * 질의 응답 관련 게시판
 */
public class QABoard extends Board { // QABoard is Board 성립
	private boolean replyState; // 답변 여부
	
	public QABoard() {
		
	}


	public QABoard(int bno, String subject, String writer, String content, boolean replyState) {
		super(bno, subject, writer, content);
		this.replyState = replyState;
	}

	// boolean형은 get이 아닌 is로 사용
	public boolean isReplyState() {
		return replyState;
	}


	public void setReplyState(boolean replyState) {
		this.replyState = replyState;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName());
		builder.append(super.toString());
		builder.append("replyState=");
		builder.append(replyState);
		builder.append("]");
		return builder.toString();
	}
	
}
