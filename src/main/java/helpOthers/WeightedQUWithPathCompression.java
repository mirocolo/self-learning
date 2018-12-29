package helpOthers;

/**
 * Created on 2018/12/24.
 *
 * @author He Xin
 */
public class WeightedQUWithPathCompression {
	private int count;
	private int[] id;
	private int[] size;

	public WeightedQUWithPathCompression(int N) {
		this.count = N;
		this.id = new int[N];
		this.size = new int[N];

		for (int i = 0; i < this.count; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}

	private int find(int p) {
		while (p != id[p]) {
			id[p] = id[id[p]];  // 路径压缩，会破坏掉当前节点的父节点的尺寸信息，因为压缩后，当前节点的父节点已经变了
			p = id[p];
		}

		return p;
	}

	public void union(int p, int q) {
		int pCom = this.find(p);
		int qCom = this.find(q);

		if (pCom == qCom) {
			return;
		}
		// 按秩进行合并
		if (size[pCom] > size[qCom]) {
			id[qCom] = pCom;
			size[pCom] += size[qCom];
		} else {
			id[pCom] = qCom;
			size[qCom] += size[pCom];
		}
		// 每次合并之后，树的数量减1
		count--;
	}

	public int count() {
		return this.count;
	}

	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}
}
