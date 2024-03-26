package InterestingPrograms;
import java.util.*;
public class ExpressinEvaluvation {
	public static void main(String[] args)
	{
		Scanner ab = new Scanner(System.in);

		Stack<Integer> values = new Stack<>();
		Stack<Character> operators = new Stack<>();
		String exp = ab.nextLine();

		for(int i=0;i<exp.length();i++)
		{
			char ch = exp.charAt(i);

			if(ch == ' ')
			continue;

			else if(ch >= '0' && ch <= '9')
			{
				StringBuffer st = new StringBuffer();
				while(i<exp.length() && exp.charAt(i)>='0' && exp.charAt(i)<='9')
				{
					st.append(exp.charAt(i++));
				}

				int x = Integer.parseInt(String.valueOf(st));
				values.push(x);
				i--;
			}

			else if(ch == '(')
			{
				operators.push(ch);
			}

			else if(ch == ')')
			{
				while(!operators.isEmpty() && operators.peek() != '(')
				{
					values.push(operation(values.pop(), values.pop(), operators.pop()));
				}
				operators.pop();
			}
			else if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
			{
			
				while(!operators.isEmpty() && checkPrecedence(ch,operators.peek()))
				{
					values.push(operation(values.pop(),values.pop(),operators.pop()));
				}
				
				operators.push(ch);	
			}
			
		}
		

		while(!operators.isEmpty())
		{
			values.push(operation(values.pop(),values.pop(),operators.pop()));
		}
		System.out.print(values);
		ab.close();
	}

	public static boolean checkPrecedence(char op1, char op2)
	{
		if(op2 == '(' || op2 == ')')
		return false;
		else if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
		return false;
		else
		return true;
	}

	public static int operation(int num2, int num1,char operator)
	{
		switch (operator) {
			case '+':
				return num1 + num2;
	
		    case '-':
				return num1 - num2;

			case '*':
			    return num1 * num2;

			case '/':
				if(num2!=0)
				return num1 / num2;
	
		}
		return 0;
	}
}
