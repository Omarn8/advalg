package coarsework;
import java.util.Stack;
class Node {
    String val;
    Node left, right;

    Node(String val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class ExpressionTree {
    
    static boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }

    static Node buildExpressionTree(String[] expression) {
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < expression.length; i++) {
            String c = expression[i];

            if (isOperator(c)) {
                Node right = stack.pop();
                Node left = stack.pop();
                Node operator = new Node(c);
                operator.left = left;
                operator.right = right;
                stack.push(operator);
            } else {
                Node operand = new Node(c);
                stack.push(operand);
            }
        }

        return stack.pop();
    }

    static double getRootValue(Node root) {
        if (!isOperator(root.val)) {
            return Double.parseDouble(root.val);
        }

        double leftVal = getRootValue(root.left);
        double rightVal = getRootValue(root.right);

        switch(root.val) {
            case "+":
                return leftVal + rightVal;
            case "-":
                return leftVal - rightVal;
            case "*":
                return leftVal * rightVal;
            case "/":
                return leftVal / rightVal;
            default:
                throw new RuntimeException("Invalid operator");
        }
    }

    public static void main(String[] args) {
        String expression = "(((6+4)*3)-1)/5";
        String[] tokens = expression.split("(?<=[\\(\\)\\+\\-\\*/])|(?=[\\(\\)\\+\\-\\*/])");

        Node root = buildExpressionTree(tokens);
        System.out.println(getRootValue(root));
    }
}
