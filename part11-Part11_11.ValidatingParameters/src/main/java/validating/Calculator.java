package validating;

public class Calculator {

    public int factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Factorial can only be calculated for positive numbers.");
        }

        int answer = 1;
        for (int i = 1; i <= num; i++) {
            answer *= i;
        }

        return answer;
    }

    public int binomialCoefficent(int setSize, int subsetSize) {
        if (setSize < 0 || subsetSize < 0 || subsetSize > setSize) {
            throw new IllegalArgumentException("When calculating the binomial coefficient the set size"
                    + " and subset size must be greater than 0."
                    + " Subset size must also not exceed set size.");
        }
        
        if (subsetSize > setSize) {
            throw new IllegalArgumentException("When calculating the binonmial coefficient the subset size must no exceed set size.");
        }
        
        int numerator = factorial(setSize);
        int denominator = factorial(subsetSize) * factorial(setSize - subsetSize);

        return numerator / denominator;
    }
}
