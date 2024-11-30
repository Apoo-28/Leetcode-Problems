class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        
        // Build the graph and count in-degrees and out-degrees
        for (int[] pair : pairs) {
            int start = pair[0];
            int end = pair[1];
            graph.computeIfAbsent(start, k -> new ArrayList<>()).add(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }
        
        // Find the starting node
        int startNode = pairs[0][0];
        for (int node : outDegree.keySet()) {
            if (outDegree.get(node) - inDegree.getOrDefault(node, 0) == 1) {
                startNode = node;
                break;
            }
        }
        
        // Perform DFS to find the Eulerian path
        List<int[]> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNode);
        
        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (graph.containsKey(node) && !graph.get(node).isEmpty()) {
                stack.push(graph.get(node).remove(graph.get(node).size() - 1));
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    result.add(new int[]{stack.peek(), node});
                }
            }
        }
        
        // Convert the result list to array
        Collections.reverse(result);
        return result.toArray(new int[result.size()][]);
    }
}