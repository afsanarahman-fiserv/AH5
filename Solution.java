import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static char mostFrequentChar(String s) {
        // edge cases
        if(s.isEmpty()) return ' ';

        // put all characters of given string in a HashMap w/respective counts
        HashMap<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(chars.containsKey(c)) {
                chars.put(c, chars.get(c) + 1);
            } else {
                chars.put(c, 1);
            }
        }

        // find the char(s) with the max count(s)
        int max = 0;
        for(Map.Entry<Character, Integer> e : chars.entrySet()) {
            if(e.getValue() > max) {
                max = e.getValue();
            }
        }

        // check if there are multiple characters with the same count
        ArrayList<Character> mostFreqChars = new ArrayList<>();
        for(Map.Entry<Character, Integer> e : chars.entrySet()) {
            if(e.getValue() == max) {
                mostFreqChars.add(e.getKey());
            }
        }

        if(mostFreqChars.size() == 1) return mostFreqChars.get(0);
        else {
            for (int i = 0; i < s.length(); i++) {
                if(mostFreqChars.contains(s.charAt(i))) {
                    return s.charAt(i);
                }
            }
        }

        return ' ';
    }
  
    public static void main(String[] args) {
      // Try out your test cases:
        System.out.println(Solution.mostFrequentChar("bookeeper")); // -> 'e'
        System.out.println(Solution.mostFrequentChar("david")); // -> 'd'
        System.out.println(Solution.mostFrequentChar("mississippi")); // -> 'i'
        System.out.println(Solution.mostFrequentChar("eleventennine")); // -> 'e'
    }

  }
