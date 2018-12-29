package helpOthers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Data {
	int pointNum;
	int edgeNum;
	int[][] edge;

	public Data() {
		int temp1 = 0;
		int temp2 = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("E:\\suanfa\\mediumDG.txt"))) {
			pointNum = Integer.parseInt(br.readLine());
			edgeNum = Integer.parseInt(br.readLine());
			System.out.println(pointNum + " " + edgeNum);
			edge = new int[pointNum][pointNum];
			for (int i = 0; i < pointNum; i++) {
				for (int j = 0; j < pointNum; j++) {
					edge[i][j] = 0;
				}
			}
			String s = null;
			while ((s = br.readLine()) != null) {
				String[] ss = s.split(" ");
				temp1 = Integer.parseInt(ss[0]);
				temp2 = Integer.parseInt(ss[1]);
				edge[temp1][temp2]++;
				edge[temp2][temp1]++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}