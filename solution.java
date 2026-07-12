class Solution {

    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    Map<String, List<String>> parent = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord))
            return ans;

       
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> level = new HashMap<>();

        q.offer(beginWord);
        level.put(beginWord, 0);

        while (!q.isEmpty()) {

            String word = q.poll();
            int currLevel = level.get(word);

            char[] arr = word.toCharArray();

            for (int i = 0; i < arr.length; i++) {

                char old = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    arr[i] = ch;
                    String next = new String(arr);

                    if (!dict.contains(next))
                        continue;

                    
                    if (!level.containsKey(next)) {

                        level.put(next, currLevel + 1);
                        q.offer(next);

                        parent.putIfAbsent(next, new ArrayList<>());
                        parent.get(next).add(word);
                    }

                   
                    else if (level.get(next) == currLevel + 1) {

                        parent.get(next).add(word);
                    }
                }

                arr[i] = old;
            }
        }

        if (!level.containsKey(endWord))
            return ans;

        path.add(endWord);
        dfs(endWord, beginWord);

        return ans;
    }

    void dfs(String word, String beginWord) {

        if (word.equals(beginWord)) {

            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }

        if (!parent.containsKey(word))x
            return;

        for (String par : parent.get(word)) {

            path.add(par);
            dfs(par, beginWord);
            path.remove(path.size() - 1);
        }
    }
}