package com.encore;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kickboard {

		static int M;
		static int N;
		static int[][] map;
		static boolean[][] visited;

		public static int execute(File path) throws FileNotFoundException {
			//Scanner sc = new Scanner(System.in);
			Scanner sc = new Scanner(path);
			M = sc.nextInt();
			N = sc.nextInt();
			map = new int[M][N];
		//	memo = new int[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			}
			visited = new boolean[M][N];
			int result = dfs(0,0);
			//System.out.println(result);		
			return result;
		}
		

		// 구현하세요




		private static int dfs(int i, int j) {
			// TODO Auto-generated method stub
			return 0;
		}


		
		public static void main(String[] args) throws FileNotFoundException {
			System.out.println(execute(new File("input.txt")));
		}

}
