package shoppingMall;

import java.io.IOException;

public class ChildException extends Exception{
	static int cnt;
	public ChildException() {
		super("애들은 가라");
		cnt++;
	}
	
	public ChildException(String s) {
		super(s);
		cnt++;
	}
}
