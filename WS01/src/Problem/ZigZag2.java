package Problem;

public class ZigZag2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] intArray = {
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11, 12, 13, 14, 15},
				{16, 17, 18, 19, 20}
		};
		
		int len1 = intArray[0].length;
		int len2 = intArray.length;
		for (int i = 0; i < len1; i++) {
			if (i%2 == 0) {
				for (int j = 0; j < len2; j++) {
					System.out.print(intArray[j][i] + "\t");
				}
			} else {
				for (int j = len2-1; j >= 0; j--) {
					System.out.print(intArray[j][i] + "\t");
				}
			}
			System.out.println();
		}
	}

}
