package gst;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhaolong Zhong Jun 26, 2016
 * 
 * Implement Trie (Prefix Tree)
 * 
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
class TrieNode {
    // Initialize your data structure here.
	private TrieNode[] children;
	public boolean hasWord;
	
    public TrieNode() {
    	children = new TrieNode[26];
    	hasWord = false;
    }

    //O(m) where m is the length of word
	public void insert(String word, int index) {
		if (index == word.length()) {
			this.hasWord = true;
			return;
		}
		
		int pos = word.charAt(index) - 'a';
		if (children[pos] == null) {
			children[pos] = new TrieNode();
		}
		
		children[pos].insert(word, index + 1);
	}
	
	//O(m) where m is the length of word
	public TrieNode find(String word, int index) {
		if (index == word.length()) {
			return this;
		}
		
		int pos = word.charAt(index) - 'a';
		if (children[pos] == null) {
			return null;
		}
		
		return children[pos].find(word, index + 1);
	}
}

public class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root.find(word, 0);
        
    	return node != null && node.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode node = root.find(prefix, 0);
    	
    	return node != null;
    }
    
    public static void main(String[] args) {
    	 Trie trie = new Trie();
    	 trie.insert("hello");
    	 boolean result = trie.search("hello");
    	 System.out.println(result);
    	 
    	 TrieHash trieHash = new TrieHash();
    	 trieHash.insert("hello");
    	 boolean result2 = trie.search("hello");
    	 System.out.println(result2);
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

// Use HashMap
class TrieNodeHash {
	public Map<Character, TrieNodeHash> children;
	public boolean hasWord;
	
	public TrieNodeHash() {
		this.children = new HashMap<Character, TrieNodeHash>();
		this.hasWord = false;
	}
}

class TrieHash {
	private TrieNodeHash root;
	
	public TrieHash() {
		this.root = new TrieNodeHash();
	}
	
	public void insert(String word) {
		TrieNodeHash cur = root;
		
		for (int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);
			
			if (!cur.children.containsKey(c)) {
				cur.children.put(c, new TrieNodeHash());
			}
			
			cur = cur.children.get(c);
		}
		
		cur.hasWord = true;
	}
	
	public boolean search(String word) {
		TrieNodeHash cur = root;
		for (int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);
			
			if (!cur.children.containsKey(c)) {
				return false;
			}
			
			cur = cur.children.get(c);
		}
		
		return cur.hasWord;
	}
	
	public boolean startsWith(String prefix) {
		TrieNodeHash cur = root;
		for (int i = 0; i < prefix.length(); i++) {
			Character c = prefix.charAt(i);
			
			if (!cur.children.containsKey(c)) {
				return false;
			}
			
			cur = cur.children.get(c);
		}
		
		return true;
	}
}
