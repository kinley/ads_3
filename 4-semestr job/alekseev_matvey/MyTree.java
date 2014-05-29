
public class MyTree {
	int[] parents;
	public final int[] rank;

	public MyTree(int N) {
		parents = new int[N];
		rank = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	public void makeSet(int x) {
		parents[x] = x;

	}

	public int find(int x) {
		if (parents[x] == x) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}

	public void unite(int x, int y) {
		if ((x = find(x)) == (y = find(y))) {
			return;
		}

		if (rank[x] < rank[y]) {
			parents[x] = y;
		} else {
			parents[y] = x;
			if (rank[x] == rank[y]) {
				++rank[x];

			}
		}
	}

}