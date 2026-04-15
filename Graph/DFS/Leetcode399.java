public class Leetcode399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String u = equation.get(0);
            String v = equation.get(1);
            double val = values[i];
            graph.computeIfAbsent(u, k -> new HashMap<>()).put(v, val);
            graph.computeIfAbsent(v, k -> new HashMap<>()).put(u, 1.0 / val);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!graph.containsKey(start) || !graph.containsKey(end))
                result[i] = -1.0;
            else if (start.equals(end))
                result[i] = 1.0;
            else
                result[i] = dfs(start, end, graph, new HashSet<>());
        }
        return result;
    }

    private double dfs(String start, String end, Map<String, Map<String, Double>> graph, Set<String> visited) {
        visited.add(start);
        Map<String, Double> nexts = graph.get(start);
        for (Map.Entry<String, Double> entry : nexts.entrySet()) {
            String next = entry.getKey();
            Double weight = entry.getValue();

            if (next.equals(end))
                return weight;
            if (!visited.contains(next)) {
                double res = dfs(next, end, graph, visited);
                if (res != -1.0)
                    return weight * res;
            }
        }
        return -1.0;
    }
}
