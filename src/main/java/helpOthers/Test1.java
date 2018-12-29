package helpOthers;

import org.apache.commons.lang3.time.StopWatch;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Test1 {
	static int bridge = 0; //桥

	public static void main(String[] args) throws IOException {
		Data d = new Data();
		int V = d.pointNum;
		int E = d.edgeNum;
		int[][] edgu = d.edge; //边

		StopWatch stopWatch = StopWatch.createStarted();
		for (int i = 0; i < V; i++)
			for (int j = i; j < V; j++) {
				if (edgu[i][j] == 1) {
					edgu[i][j] = 0;
					edgu[j][i] = 0;
					BFS(edgu, i, j, V, E);
					edgu[i][j] = 1;
					edgu[j][i] = 1;
				}
			}
		System.out.println("该无向图共有" + bridge + "条桥！！！");
		stopWatch.stop();
		System.out.println("并查集耗时：" + stopWatch.getTime(TimeUnit.MILLISECONDS) + "ms");
	}

	static void BFS(int[][] G, int u, int v, int V, int E) {
//		System.out.println("源节点："+u+"；目标点："+v);
		int[] dl1 = new int[E];  //接下来应该查找的点 ppt里的队列
		int[] dl2 = new int[V];  //灰色
		int count = 0;
		int head = 0;
		int tail = 0;

		dl1[tail] = u;
		tail++;
		dl2[count] = u;
		count++;
		while (head <= tail) {
			System.out.print("队列1：");
			for (int i = head; i < tail; i++)
				System.out.print(dl1[i] + " ");
			System.out.println();

			int n = dl1[head];
			head++;
			System.out.println("遍历查找到点：" + n);


			for (int j = 0; j < V; j++) {
				boolean flag = true;
				if (G[n][j] > 0) {
					if (j == v) {
						System.out.println("找到目标点！！！！！！");
						System.out.println();
						return;
					}

					for (int k = 0; k < count; k++) {
						if (j == dl2[k])
							flag = false;
					}

					if (flag) {
						dl1[tail] = j;
						tail++;
						dl2[count] = j;
						count++;
					}
				}
			}

			System.out.print("队列2：");
			for (int k = 0; k < count; k++)
				System.out.print(dl2[k] + " ");
			System.out.println();
			System.out.println();
		}
		System.out.println("没有查找到目标点！！！该边(" + u + "," + v + ")为桥！！！");
		System.out.println();
		bridge++;
	}
}