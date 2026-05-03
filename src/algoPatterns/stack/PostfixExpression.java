package algoPatterns.stack;

import java.util.Stack;

/**
 * Given an array of strings arr[] representing a postfix expression, evaluate it.
 * A postfix expression is of the form operand1 operand2 operator (e.g., "a b +"), where two operands are followed by an operator.
 * The operators can include +, -, *, /, and ^ (where ^ denotes exponentiation, i.e., power). Division / uses floor division.
 */

public class PostfixExpression {

    public static void main(String[] args) {
        PostfixExpression pe = new PostfixExpression();
        String[] arr = {"2", "3", "1", "*", "+", "9", "-"};
        System.out.println(pe.evaluatePostfix(arr));
    }

    public int evaluatePostfix(String[] arr) {
        // code here
        return 0;

    }
}
