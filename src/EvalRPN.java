public class EvalRPN{
	public static void main(String[] args) {
		String[] tokens = {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(tokens));
	}
	public static int evalRPN(String[] tokens) {
		if (tokens.length == 1 && tokens[0].matches("-?\\d+"))
			return Integer.parseInt(tokens[0]);
		Stack stack = new Stack();
		int tIndex = 0;
		int result = 0, a, b;
		while (tIndex < tokens.length) {
			String token = tokens[tIndex];
			if (token.matches("-?\\d+"))
				stack.Push(token);
			else {
				b = Integer.parseInt(stack.Pop().value);
				a = Integer.parseInt(stack.Pop().value);
				if (token.equals("+")) 
					result = a + b;
				else if (token.equals("-"))
					result = a - b;
				else if (token.equals("*"))
					result = a * b;
				else if (token.equals("/"))
					result = a / b;
				stack.Push(Integer.toString(result));
			}
			tIndex ++;
		}
        return result;
    }
	static class Stack{
		StackNode top;
		public Stack() {
			top = null;
		}
		public void Push(String value) {
			StackNode newNode = new StackNode(value);
			newNode.next = top;
			top = newNode;
		}
		public StackNode Pop() {
			if (top == null)
				return null;
			else
			{
				StackNode tmp = top;
				top = top.next;
				return tmp;
			}
		}
		public boolean IsEmpty() {
			return top == null;
		}
	}
	static class StackNode {
		String value;
		StackNode next;
		public StackNode(String value) {
			this.value = value;
			next = null;
		}
	}
}