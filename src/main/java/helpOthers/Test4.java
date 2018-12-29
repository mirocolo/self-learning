package helpOthers;

import org.apache.commons.lang3.time.StopWatch;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Test4 {
	static int bridge = 0; //桥

	public static void main(String[] args) throws IOException {

		Data d = new Data();
		int V = d.pointNum;
		//int E = d.edgeNum;
		int[][] edgu = d.edge; //边
		int[][] find = new int[V][V];

		StopWatch stopWatch = StopWatch.createStarted();
		for (int i = 0; i < V; i++)
			for (int j = i; j < V; j++) {
				if (edgu[i][j] == 1 && find[i][j] == 0) {
					edgu[i][j] = 0;
					edgu[j][i] = 0;
					System.out.println(i + "---" + j);
					BFS(edgu, V, i, j);
					edgu[i][j] = 1;
					edgu[j][i] = 1;
					find[j][i] = 1;
				}
			}
		System.out.println("该无向图共有" + bridge + "条桥！！！");
		stopWatch.stop();
		System.out.println("并查集耗时：" + stopWatch.getTime(TimeUnit.MILLISECONDS) + "ms");
	}

	static void BFS(int[][] G, int V, int u, int v) {
		WeightedQUWithPathCompression bcj = new WeightedQUWithPathCompression(V);
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++) {
				if (G[i][j] > 0)
					bcj.union(i, j);
			}


		System.out.println();

		if (!bcj.isConnected(u, v)) {
			bridge++;
			System.out.println(u + "-" + v + "为桥");
		}
	}
}