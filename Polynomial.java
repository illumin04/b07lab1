import java.util.Arrays;

public class Polynomial{
	private double[] coefficients;
	
	private double power(double x,int y) {
		double result=1.0;
		for(int i=0;i<y;i++)
		{
			result*=x;
		}
		return result;
	}
	public Polynomial() {
		this.coefficients = new double[]{0.0};
	}
	
	
	public Polynomial(double[] coefficients) {
		this.coefficients = new double [coefficients.length];
		for(int i=0;i<coefficients.length;i++)
		{
			this.coefficients[i]=coefficients[i];
		}
	}
	
	
	public Polynomial add(Polynomial link) {
		int size=Math.max(this.coefficients.length,link.coefficients.length);
		double[] result=new double [size];
		for(int i=0;i<this.coefficients.length;i++)
		{
			result[i]+=this.coefficients[i];
		}
		for(int i=0;i<link.coefficients.length;i++)
		{
			result[i]+=link.coefficients[i];
		}
		return new Polynomial(result);
	}
	
	
	public double evaluate(double x) {
		double sum=0.0;
		for(int i=0;i<coefficients.length;i++)
		{
			sum+=coefficients[i]*power(x,i);
		}
		return sum;
	}
	
	public boolean hasRoot(double x) {
		return evaluate(x)==0.0;
	}
	
}