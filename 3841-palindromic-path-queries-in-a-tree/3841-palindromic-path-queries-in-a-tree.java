class Solution {
    private List<Integer>[] adj;
    private int[] parent, depth, size, heavy;
    private int[] head, pos, nodeMask, bit;
    private int n, timer;

    public List<Boolean> palindromePath(int n, int[][] edges,
                                        String s, String[] queries) {
        this.n = n;

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        size = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];
        nodeMask = new int[n];
        Arrays.fill(heavy, -1);

        int[] order = new int[n];
        int[] stack = new int[n];
        int top = 0, count = 0;

        stack[top++] = 0;
        parent[0] = -1;

        while (top > 0) {
            int u = stack[--top];
            order[count++] = u;

            for (int v : adj[u]) {
                if (v == parent[u]) continue;

                parent[v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            size[u] = 1;
            int maxSize = 0;

            for (int v : adj[u]) {
                if (parent[v] != u) continue;

                size[u] += size[v];

                if (size[v] > maxSize) {
                    maxSize = size[v];
                    heavy[u] = v;
                }
            }
        }
        int[] nodes = new int[n];
        int[] chainHeads = new int[n];
        int chainTop = 0;

        nodes[chainTop] = 0;
        chainHeads[chainTop++] = 0;
        timer = 0;

        while (chainTop > 0) {
            chainTop--;
            int u = nodes[chainTop];
            int h = chainHeads[chainTop];

            while (u != -1) {
                head[u] = h;
                pos[u] = ++timer;

                for (int v : adj[u]) {
                    if (parent[v] == u && v != heavy[u]) {
                        nodes[chainTop] = v;
                        chainHeads[chainTop++] = v;
                    }
                }

                u = heavy[u];
            }
        }
        bit = new int[n + 1];

        for (int i = 0; i < n; i++) {
            nodeMask[i] = 1 << (s.charAt(i) - 'a');
            add(pos[i], nodeMask[i]);
        }

        List<Boolean> results = new ArrayList<>();

        for (String query : queries) {
            String[] parts = query.split(" ");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int newMask = 1 << (c - 'a');
                int delta = nodeMask[u] ^ newMask;

                if (delta != 0) {
                    add(pos[u], delta);
                    nodeMask[u] = newMask;
                }
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int mask = pathXor(u, v);
                results.add((mask & (mask - 1)) == 0);
            }
        }

        return results;
    }

    private void add(int index, int value) {
        while (index <= n) {
            bit[index] ^= value;
            index += index & -index;
        }
    }

    private int prefixXor(int index) {
        int result = 0;

        while (index > 0) {
            result ^= bit[index];
            index -= index & -index;
        }

        return result;
    }

    private int rangeXor(int left, int right) {
        return prefixXor(right) ^ prefixXor(left - 1);
    }

    private int pathXor(int u, int v) {
        int result = 0;

        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }

            result ^= rangeXor(pos[head[u]], pos[u]);
            u = parent[head[u]];
        }

        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        result ^= rangeXor(pos[u], pos[v]);
        return result;
    }
}
