//package Day15;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//class Span {
//	int a;
//	int b;
//	int value;
//	
//	Span(int a, int b, int value) {
//		this.a = a;
//		this.b = b;
//		this.value = value;
//	}
//}
//
//public class B1197 {
//	static int v; // 정점 개수
//	static int e; // 간선 개수
//	static Span [] eArr;
//	static int [] arr;
//	static int result;
//	
//	static int find(int x) {
//		if (x == arr[x]) return x;
//		return arr[x] = find(arr[x]);
//	}
//	
//	static void union(int x, int y) {
//		x = find(x);
//		y = find(y);
//		
//		if (x != y) {
//			if (x < y) arr[y] = x;
//			else arr[x] = y;
//		}
//	}
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(reader.readLine());
//		v = Integer.parseInt(st.nextToken());
//		e = Integer.parseInt(st.nextToken());
//		eArr = new Span [e];
//		arr = new int [v+1];
//		Arrays.setAll(arr, (i) -> i);
//		
//		for (int i = 0; i<e; i++) {
//			st = new StringTokenizer(reader.readLine());
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			int value = Integer.parseInt(st.nextToken());
//			eArr[i] = new Span(a, b, value);
//		}
//		Arrays.sort(eArr, (a,b)-> a.value - b.value);
//		
//		for (int i = 0; i<e; i++) {
//			if (find(eArr[i].a) != find(eArr[i]))
//		}
//		
//		
//		
//	}
//}
