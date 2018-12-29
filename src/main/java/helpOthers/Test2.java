package helpOthers;

import java.io.IOException;

public class Test2 {
	static int bridge = 0; //桥

	public static void main(String[] args) throws IOException {
		long starttime = System.currentTimeMillis();
		Data d = new Data();
		int V = d.pointNum;
		//int E = d.edgeNum;
		int[][] edgu = d.edge; //边
		int[][] find = new int[V][V];
		//int i=3,j=42;
		for (int i = 0; i < V; i++)
			for (int j = i; j < V; j++) {
				if (edgu[i][j] == 1 && find[i][j] == 0) {
					edgu[i][j] = 0;
					edgu[j][i] = 0;
					System.out.println(i + "---" + j);
					BFS(edgu, V, i, j);
					edgu[i][j] = 1;
					edgu[j][i] = 1;
					find[i][j] = 1;
					find[j][i] = 1;
				}
			}
		System.out.println("该无向图共有" + bridge + "条桥！！！");
		long endTime = System.currentTimeMillis();
		System.out.println("耗时：" + (endTime - starttime) + "ms");
	}

	static void BFS(int[][] G, int V, int u, int v) {
		int d = 0;
		UnionFind unionFind = new UnionFind(V);
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++) {
				if (G[i][j] > 0)
					unionFind.union(i, j);
			}

		for (int k = 0; k < V; k++)
			System.out.print(k + "-" + unionFind.parent[k] + "-" + unionFind.rank[k]);

		System.out.println();

		if (!unionFind.isConnected(u, v)) {
			bridge++;
			System.out.println(u + "-" + v + "为桥");
		}
	}
}