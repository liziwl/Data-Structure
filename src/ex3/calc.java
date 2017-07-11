package ex3;

public class calc {
	public static String mid2post(String mid) throws Exception {
		String out = "";
		Stack_Sy sy = new Stack_Sy(20);
		for (int i = 0; i < mid.length(); i++) {
			char temp = mid.charAt(i);
			if (temp == '0' || temp == '1' || temp == '2' || temp == '3' || temp == '4' || temp == '5' || temp == '6'
					|| temp == '7' || temp == '8' || temp == '9')
				out += temp;
			else if (temp == '(') {
				sy.push('(');
			} else if (temp == ')') {
				char flag = sy.pop();
				while (flag != '(') {
					out += flag;
					flag = sy.pop();
				}
			} else if (temp == '+' || temp == '-' || temp == '*' || temp == '/') {
				if (!sy.isEmpty()) {
					char top = sy.top();
					while (priority(top, temp)) {
						out += sy.pop();
						if (sy.isEmpty())
							break;
						top = sy.top();
					}
				}
				sy.push(temp);

			}

		}
		while (!sy.isEmpty()) {
			out += sy.pop();
		}
		return out;
	}

	public static int calculate(String post) throws Exception {
		int temp = 0;
		Stack_Int in=new Stack_Int(20);
		for(int i=0;i<post.length();i++){
			char loc = post.charAt(i);
			if (loc == '0' || loc == '1' || loc == '2' || loc == '3' || loc == '4' || loc == '5' || loc == '6'
					|| loc == '7' || loc == '8' || loc == '9')
				in.push(Character.getNumericValue(loc));
			else if (loc=='+') {
				int a=in.pop();
				int b=in.pop();
				in.push(a+b);
			}else if (loc=='-') {
				int a=in.pop();
				int b=in.pop();
				in.push(b-a);
			}else if (loc=='*') {
				int a=in.pop();
				int b=in.pop();
				in.push(a*b);
			}else if (loc=='/') {
				int a=in.pop();
				int b=in.pop();
				in.push(b/a);
			}
		}
		temp=in.pop();
		return temp;
	}

	public static boolean priority(char a, char b) {
		// a的优先级>=b true
		if (a == '(')
			return false;
		else if (a == '*' || a == '/')
			return true;
		else {
			if (b == '*' || b == '/') {
				return false;
			} else {
				return true;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		String mid = "4*(6-3)+8/2";
		String post = mid2post(mid);
		System.out.println(mid);
		System.out.println(post);
		System.out.println(calculate(post));
	}
}
