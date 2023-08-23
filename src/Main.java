import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "as(d)a[s(asdsa{asd{sad}}asds[dsa])hjla]c";
        System.out.println(function(s));
    }

    private static boolean function(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (stack.isEmpty() && (c == ')' || c == '}' || c == ']')) {
                return false;
            }


            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            switch (c) {
                case ')':
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }

        return stack.isEmpty();
    }
}
