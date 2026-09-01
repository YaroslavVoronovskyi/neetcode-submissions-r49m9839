class Solution {

    private Map<String, Integer> emailIndex = new HashMap<>();
    private List<String> emails = new ArrayList<>();
    private Map<Integer, Integer> emailToAccount = new HashMap<>();
    private List<List<Integer>> adj;
    private Map<Integer, List<String>> emailGroup = new HashMap<>();
    private boolean[] visited;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int m = 0;

        for (int accountId = 0; accountId < n; accountId++) {
            List<String> account = accounts.get(accountId);
            for (int index = 1; index < account.size(); index++) {
                String email = account.get(index);
                if (!emailIndex.containsKey(email)) {
                    emails.add(email);
                    emailIndex.put(email, m);
                    emailToAccount.put(m, accountId);
                    m++;
                }
            }
        }

        adj = new ArrayList<>();
        for (int index = 0; index < m; index++) {
            adj.add(new ArrayList<>());
        }
        for (List<String> account : accounts) {
            for (int index = 2; index < account.size(); index++) {
                int id1 = emailIndex.get(account.get(index));
                int id2 = emailIndex.get(account.get(index - 1));
                adj.get(id1).add(id2);
                adj.get(id2).add(id1);
            }
        }
        
        visited = new boolean[m];
        
        for (int index = 0; index < m; index++) {
            if (!visited[index]) {
                int accountId = emailToAccount.get(index);
                emailGroup.putIfAbsent(accountId, new ArrayList<>());
                depthFirstSearch(index, accountId);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (int accountId : emailGroup.keySet()) {
            List<String> group = emailGroup.get(accountId);
            Collections.sort(group);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(accountId).get(0));
            merged.addAll(group);
            result.add(merged);
        }
        return result;
    }

    private void depthFirstSearch(int node, int accountId) {
        visited[node] = true;
        emailGroup.get(accountId).add(emails.get(node));
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                depthFirstSearch(neighbor, accountId);
            }
        }
    }
}