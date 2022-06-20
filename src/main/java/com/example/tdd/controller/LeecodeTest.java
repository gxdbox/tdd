package com.example.tdd.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeecodeTest {
    private  Map<Integer, Integer> sumCount = new HashMap<>();
    private  int maxFremax = Integer.MIN_VALUE;

    public int[] findFrequentTreeSum(TreeNode root) {
        postOrder(root);

        List<Integer> help = new ArrayList<>();
        for (Map.Entry<Integer, Integer> map : sumCount.entrySet()) {
            if (map.getValue().equals(maxFremax))
                help.add(map.getKey());
        }

        int[] res = new int[help.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = help.get(i);
        }
        return res;
    }

    private int postOrder(TreeNode node){
        if (null == node)
            return 0;

        int left = postOrder(node.left);
        int right = postOrder(node.right);

        int sum = left + right + node.val;

        Integer value = sumCount.getOrDefault(sum, 0);
        sumCount.put(sum, value + 1);

        maxFremax = Math.max(maxFremax, value + 1);
        return sum;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
