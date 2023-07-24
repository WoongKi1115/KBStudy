package day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110 {
	static int n;
	static int c;
	static int [] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int [n];
		
		for (int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(reader.readLine());
		}
		Arrays.sort(arr);
		
		System.out.println((arr[0] + arr[n-1])/c );
	}
}
