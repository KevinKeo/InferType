
public class InferType {
	public static void main(String[] args) {

		Expression e = new LBool(true);
		System.out.println(e.infer());
		Expression e1 = new LInt(2);
		System.out.println(e1.infer());
		
		
	}
}
