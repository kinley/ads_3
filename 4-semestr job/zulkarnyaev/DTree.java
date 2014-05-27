package ru.kpfu.ivmiit.tree;

public class DTree extends UFSet {
	public final int[] rank;
	public final int[] weight;
	public int[] depth;
	public int[] size;

	public DTree(int N) {
		super(N);
		parents = new int[N];
		rank = new int[N];
		weight = new int[N];
		depth = new int[N];
		size = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
		for (int i = 0; i < N; i++) {
			weight[i] = 1;
		}
		for (int i = 0; i < N; i++) {
			size[i] = 1;
		}
	}

	@Override
	public void unite(int x, int y) {
		if ((x = find(x)) == (y = find(y))) {
			return;
		}

		if (rank[x] < rank[y]) {
			parents[x] = y;
			size[y] += size[x];
		} else {
			parents[y] = x;
			size[x] += size[y];
			if (rank[x] == rank[y]) {
				++rank[x];

			}
		}
	}

	public void merge(int r, int v) {
		int w = find(v);
		if (size[r] < size[w]) {
			parents[r] = v;
			depth[r] += depth(v) + 1;
		} else {
			parents[w] = r;
			depth[w] += depth[r] + 1;
		}
	}

	public int depth2(int x) {
		if (parents[x] == x) {
			depth[x] = weight[x];
			return 0;
		}
		depth[x] += weight[x];
		return depth[x] += depth2(parents[x]);
	}

	public int depth(int x) {

		int r = depth2(x);
		find(x);// cut paths
		return r;
	}

}
