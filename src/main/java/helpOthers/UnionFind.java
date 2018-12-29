package helpOthers;

public class UnionFind {

	int[] parent;   // 标注当前元素的父节点的位置

	int[] rank;     // 标注当前元素的层级数

	private int size;       // 并查集中的元素个数

	private int groups;   //并查集中子树的数量

	public UnionFind(int size) {
		this.size = size;
		this.groups = groups;
		parent = new int[size];
		rank = new int[size];

		init();
	}

	private void init() {
		for (int i = 0; i < size; i++) {
			// 初始化时所有的节点的父节点指向本身，所有的元素层级均为 1
			parent[i] = i;
			rank[i] = 1;
		}
	}


	/**
	 * 寻找当前节点的根节点元素
	 */
	public int find(int target) {
		if (target >= size)
			throw new ArrayIndexOutOfBoundsException();
		if (target == parent[target])
			return target;
		return find(parent[target]);
	}

	/**
	 * 连接两个元素
	 */
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot)  //pq节点已经连接，不再二次连接
			return;
		if (rank[pRoot] > rank[qRoot]) { // p 所在的树的高度比 q 所在输的高度高，这时应该让 q 的根节点元素连接到 p 的根节点元素
			parent[qRoot] = pRoot; // 此时树的高度不变
		} else if (rank[pRoot] < rank[qRoot]) {
			parent[pRoot] = qRoot; // 此时树的高度不变
		} else {
			parent[pRoot] = qRoot; // 此时树的高度 +1
			rank[qRoot] += 1;
		}
		this.groups--;
	}

	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}

}
