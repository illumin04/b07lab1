public class Polynomial{
	private double[] coefficients;
	private int[] powers;
	
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
		this.powers = new int[]{0};
	}
	
	
	public Polynomial(double[] coefficients, int[] powers) {
        this.coefficients = coefficients.clone();
        this.powers = powers.clone();
    }
	
	
	public Polynomial add(Polynomial other) {
        int maxLength = Math.max(this.coefficients.length, other.coefficients.length);
        double[] resultCoefficients = new double[1000005];
        int[] resultExponents = new int[1000005];

        for (int i = 0; i < this.coefficients.length; i++) {
            double coeff = this.coefficients[i];
            int exp = this.powers[i];
            int index = indexOfExponent(other.powers, exp);

            if (index != -1) {
                resultCoefficients[i] = coeff + other.coefficients[index];
                resultExponents[i] = exp;
            } else {
                resultCoefficients[i] = coeff;
                resultExponents[i] = exp;
            }
        }

        for (int i = 0; i < other.coefficients.length; i++) {
            double coeff = other.coefficients[i];
            int exp = other.powers[i];
            if (indexOfExponent(resultExponents, exp) == -1) {
                resultCoefficients[maxLength] = coeff;
                resultExponents[maxLength] = exp;
                maxLength++;
            }
        }

        return new Polynomial(resultCoefficients, resultExponents);
    }

    private int indexOfExponent(int[] array, int exp) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == exp) {
                return i;
            }
        }
        return -1;
    }

	
    public Polynomial multiply(Polynomial other) {
        int maxLength = this.coefficients.length + other.coefficients.length;
        double[] resultCoefficients = new double[1000005];
        int[] resultExponents = new int[1000005];

        for (int i = 0; i < this.coefficients.length; i++) {
            double coeff1 = this.coefficients[i];
            int exp1 = this.powers[i];

            for (int j = 0; j < other.coefficients.length; j++) {
                double coeff2 = other.coefficients[j];
                int exp2 = other.powers[j];

                int exp = exp1 + exp2;
                double coeff = coeff1 * coeff2;
                int index = indexOfExponent(resultExponents, exp);

                if (index != -1) {
                    resultCoefficients[index] += coeff;
                } else {
                    resultCoefficients[maxLength] = coeff;
                    resultExponents[maxLength] = exp;
                    maxLength++;
                }
            }
        }

        return new Polynomial(resultCoefficients, resultExponents);
    }
	public double evaluate(double x) {
		double sum=0.0;
		for(int i=0;i<coefficients.length;i++)
		{
			sum+=coefficients[i]*power(x,powers[i]);
		}
		return sum;
	}
	
	public boolean hasRoot(double x) {
		return evaluate(x)==0.0;
	}
	
}