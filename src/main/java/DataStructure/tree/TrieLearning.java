package DataStructure.tree;

public class TrieLearning {
    public static void main(String[] args) {
        Trie trie = new Trie();
        // TODO: implement insert() method
        trie.insert("Joe");
        trie.insert("John");
        trie.insert("Johnny");
        trie.insert("Jane");
        trie.insert("Jack");

        System.out.println(trie.search("jk"));
    }
}

class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            if(node.children[Character.toLowerCase(c) - 'a'] == null)
                node.children[Character.toLowerCase(c) - 'a'] = new TrieNode();
            node = node.children[Character.toLowerCase(c) - 'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            if(node.children[Character.toLowerCase(c) - 'a'] == null) return false;
            node = node.children[Character.toLowerCase(c) - 'a'];
        }
        return node.isWord;
    }

    public boolean startWith(String prefix) {
        TrieNode node = root;
        for(char c: prefix.toCharArray()) {
            if(node.children[Character.toLowerCase(c) - 'a'] == null) return false;
            node = node.children[Character.toLowerCase(c) - 'a'];
        }
        return true;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
    }
}
