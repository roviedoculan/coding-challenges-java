/************************************************************************
 Given a string, write a program to examine whether the pairs and
 the orders of “{“, “}”, “(“, “)”, “[“, “]” in the string are balanced.
 If it's balanced, print true. Else, print false.
 Date: October 29, 2020
 ************************************************************************/
import java.util.*;

public class BalancedString {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // get input
            String input = sc.next();

            // initialize map for symbols
            Map<Character, Character> charMap = new HashMap<Character,Character>();
            charMap.put('{', '}');
            charMap.put('[', ']');
            charMap.put('(', ')');

            // initialize variables
            Stack<Character> left = new Stack<Character>();
            int i = 0;
            boolean isBalanced = true;

            // go through current input string
            while (i < input.length()) {

                // get current character
                char curr = input.charAt(i);

                // if current character is an opening symbol, push to stack
                if (charMap.containsKey(curr)) {
                    left.push(curr);
                }

                // if current character is a closing symbol
                if (charMap.containsValue(curr)) {
                    // if stack is not empty
                    if (!left.isEmpty()) {
                        // top of stack is the opening symbol for current
                        if (charMap.get(left.peek()) == curr) {
                            left.pop();
                        } else {
                            // top of stack is not the opening symbol for current
                            isBalanced = false;
                            break;
                        }
                    }
                    else {
                        // stack is already empty
                        isBalanced = false;
                        break;
                    }
                }

                ++i;
            }

            // if any open symbol left in stack, then it is unbalanced
            if (isBalanced && !left.isEmpty()) {
                isBalanced = false;
            }

            // print output
            System.out.println(isBalanced);

            // reset stack for next iteration
            left.clear();
        }
    }

}