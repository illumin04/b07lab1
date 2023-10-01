public class Driver {
	public static void main(String [] args) {
		Polynomial p = new Polynomial();
		System.out.println(p.evaluate(3));
		double [] c1 = {1,1,1};
		int [] cc = {1,2,4};
		Polynomial p1 = new Polynomial(c1,cc);
		System.out.println(p1.evaluate(3));
		double [] c2 = {1,1,0,1};
		int [] cc1= {1,6,4,3};
		Polynomial p2 = new Polynomial(c2,cc1);
		double []t1= {1,1};
		int []tt1= {1,2};
		double []t2= {2,3};
		int []tt2= {1,3};
		Polynomial s1= new Polynomial(t1,tt1);
		Polynomial s2=new Polynomial(t2,tt2);
		Polynomial ss=s1.multiply(s2);
		System.out.println(ss.evaluate(2));
		Polynomial s = p1.add(p2);
		System.out.println("s(1) = " + s.evaluate(2));
		if(s.hasRoot(1))
			System.out.println("1 is a root of s");
		else
			System.out.println("1 is not a root of s");
	}
}