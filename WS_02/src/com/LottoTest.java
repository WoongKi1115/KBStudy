package com;
import java.util.Arrays;

public class LottoTest {
	int lotto [] = new int [6];//0
    int cnt=0;//배열방에 중복없이 숫자가 들어간 개수.
    
    /**
     * 로또 번호 한개 생성하여 기존 로또번호와 비교하여 같으면 다시 생성.
     * */
    public void createLottoNo(){
    	while (cnt != 6) {
    		int rand = (int) (Math.random() * 45) + 1;
    		if (isCompareNo(rand)) {
    			lotto[cnt] = rand;
    			cnt += 1;
    		}
    	}
 

        System.out.println("중복없이 추가완료 : " + Arrays.toString(lotto));

    } 
    
    /**
     * 로또번호 비교하는 부분
	    return : true : 중복아님, false이면 중복 * */
    public boolean isCompareNo(int lottoNo){
    	for (int i = 0; i < cnt; i++ ) {
    		if (lotto[i] == lottoNo) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    
    /**
     * 완성된 6개 번호 올림차순으로 정렬하기
     * */
     public void lottoSort(){
    	 // 카운팅 정렬
//       int countArray [] = new int [46];
//       int sortedArray [] = new int [6];
//       for (int i : lotto) {
//    	   countArray[i] += 1;
//       }
//       
//       for (int i = 1; i < 46; i++) {
//    	   countArray[i] += countArray[i-1];
//       }
//       
//       for (int i : lotto) {
//    	   sortedArray[countArray[i] -1] = i;
//       }
//       this.lotto = sortedArray;
    	 
    	 // 버블정렬
    	 int temp = 0;
    	 int len = lotto.length - 1;
    	 
    	 for (int i = len; i > 0; i--) {
    		 for (int j = 0; j < i; j++) {
    			 if (lotto[j] > lotto[j+1]) {
    				 temp = lotto[j];
    				 lotto[j] = lotto[j+1];
    				 lotto[j+1] = temp;
    			 }
    		 }
    	 }
    	 
     }
     

     /**
      * 출력하는 메소드
      * */
     public void printLotto(){
     	System.out.println(Arrays.toString(lotto));
     }
	
	public static void main(String[] args) {
		LottoTest lotto = new LottoTest();
		
		//로또번호를 중복없이 저장하는 메소드 소출
		lotto.createLottoNo();
		System.out.println("--정렬하자 ----");

		//정렬호출
		lotto.lottoSort();
		
		//출력호출
		lotto.printLotto();

	}
	

}
