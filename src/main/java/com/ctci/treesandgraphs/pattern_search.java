import java.util.LinkedList; 
import java.util.List; 
class SuffixTrieNode { 
  
    final static int MAX_CHAR = 256; 
  
    SuffixTrieNode[] children = new SuffixTrieNode[MAX_CHAR]; 
    List<Integer> indexes; 
  
    SuffixTrieNode()
    { 
        
        indexes = new LinkedList<Integer>(); 
  
        for (int i = 0; i < MAX_CHAR; i++) 
            children[i] = null; 
    } 
  
    
    void insertSuffix(String s, int index) { 
          
        
        indexes.add(index); 
  
        
        if (s.length() > 0) { 
          
            
            char cIndex = s.charAt(0); 
  
            
           
            if (children[cIndex] == null) 
                children[cIndex] = new SuffixTrieNode(); 
  
            // Recur for next suffix 
            children[cIndex].insertSuffix(s.substring(1), 
                                              index + 1); 
        } 
    } 
  
  
    List<Integer> search(String s) { 
          
        
        if (s.length() == 0) 
            return indexes; 
  
   
        if (children[s.charAt(0)] != null) 
            return (children[s.charAt(0)]).search(s.substring(1)); 
  
      
        else
            return null; 
    } 
} 
  
// A Trie of all suffixes 
class Suffix_tree{ 
  
    SuffixTrieNode root = new SuffixTrieNode(); 
  
 
    Suffix_tree(String txt) { 
      
       
        for (int i = 0; i < txt.length(); i++) 
            root.insertSuffix(txt.substring(i), i); 
    } 
  
    void search_tree(String pat) { 
      
        
        List<Integer> result = root.search(pat); 
  
        
        if (result == null) 
            System.out.println("Pattern not found"); 
        else { 
  
            int patLen = pat.length(); 
  
            for (Integer i : result) 
                System.out.println("Pattern found at position " + 
                                                (i - patLen)); 
        } 
    } 
  
   
    public static void main(String args[]) { 
          
        
        String txt = "geeksforgeeks.org"; 
        Suffix_tree S = new Suffix_tree(txt); 
  
        System.out.println("Search for 'ee'"); 
        S.search_tree("ee"); 
  
        System.out.println("\nSearch for 'geek'"); 
        S.search_tree("geek"); 
  
        System.out.println("\nSearch for 'quiz'"); 
        S.search_tree("quiz"); 
  
        System.out.println("\nSearch for 'forgeeks'"); 
        S.search_tree("forgeeks"); 
    } 
}