package com.alg.middle;

public class Trie208 {
    /**
     * 方法一：字典树
     * Trie
     * Trie，又称前缀树或字典树，是一棵有根树，其每个节点包含以下字段：
     * 指向子节点的指针数组
     * children
     * children。对于本题而言，数组长度为26
     * 26，即小写英文字母的数量。此时
     * children[0]
     * children[0] 对应小写字母a
     * a，
     * children
     * [
     * 1
     * ]
     * children[1] 对应小写字母
     * b
     * b，…，
     * children
     * [
     * 25
     * ]
     * children[25] 对应小写字母
     * z
     * z。
     * 布尔字段
     * isEnd
     * isEnd，表示该节点是否为字符串的结尾。
     * 插入字符串
     * <p>
     * 我们从字典树的根开始，插入字符串。对于当前字符对应的子节点，有两种情况：
     * <p>
     * 子节点存在。沿着指针移动到子节点，继续处理下一个字符。
     * 子节点不存在。创建一个新的子节点，记录在
     * children
     * children 数组的对应位置上，然后沿着指针移动到子节点，继续搜索下一个字符。
     * 重复以上步骤，直到处理字符串的最后一个字符，然后将当前节点标记为字符串的结尾。
     * <p>
     * 查找前缀
     * <p>
     * 我们从字典树的根开始，查找前缀。对于当前字符对应的子节点，有两种情况：
     * <p>
     * 子节点存在。沿着指针移动到子节点，继续搜索下一个字符。
     * 子节点不存在。说明字典树中不包含该前缀，返回空指针。
     * 重复以上步骤，直到返回空指针或搜索完前缀的最后一个字符。
     * <p>
     * 若搜索到了前缀的末尾，就说明字典树中存在该前缀。此外，若前缀末尾对应节点的
     * isEnd
     * isEnd 为真，则说明字典树中存在该字符串。
     */

    private Trie208[] children;
    private boolean isEnd;

    /**
     * Initialize your data structure here.
     */
    public void Trie() {
        children = new Trie208[26];
        isEnd = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie208 node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie208();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie208 node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix)!=null;
    }
    private Trie208 searchPrefix(String prefix) {
        Trie208 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
       return node;
    }

    private class Trie {

        public Trie208 children;
        public Trie208 node;
        public boolean isEnd;

        public Trie208 getNode() {
            return node;
        }

        public void setNode(Trie208 node) {
            this.node = node;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public Trie208 getChildren() {
            return children;
        }

        public void setChildren(Trie208 children) {
            this.children = children;
        }

        public Trie(Trie208 node) {
            this.node = node;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
