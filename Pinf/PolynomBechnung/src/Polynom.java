import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Polynom {

    private final double[] coefficients;
    private int derivationCounter = 0;
    private String symmetry;
    private double maxima;
    private double minima;
    public static final String[] SYMMETRIES = new String[] {"Axisymmetric", "Pointsymmetric", "No symmetry"};

    public Polynom(double[] coefficients) {
        this.coefficients = coefficients;
    }
    private Polynom(double[] coefficients, int derivationCounter){
        this.coefficients = coefficients;
        this.derivationCounter = derivationCounter;
    }



    public int getHighestPotenz() {
        return highestPotenz();
    }
    public String getSymmetry() {
        return symmetry;
    }


    public double calculateY(double x) {
        double sum = 0.;
        for (int i = 0; i < coefficients.length; i++) {
            sum += coefficients[i] * Math.pow(x, i);
        }
        return sum;
    }

    public ArrayList<Double> getZeropoints() {
        // If function is linear
        if (getHighestPotenz() == 1) {
            return getNullLinear();
        }
        // If function is quadratic
        else if(getHighestPotenz() == 2) {
            return getNullQuadratic();
        }
        return new ArrayList<>();
    }

    private ArrayList<Double> getNullQuadratic() {
        double[] temp = coefficients;
        ArrayList<Double> zeropoints = new ArrayList<>();
        double x1;
        double x2;

        double p = coefficients[1];
        double q = coefficients[0];



            if (temp[2] < 0) {
                p = p / -1;
                q = q / -1;
            }
            p = p / coefficients[2];
            q = q / coefficients[2];

            double sqrtinput = Math.pow((p / 2), 2) - q;
            if (sqrtinput < 0) {
                return zeropoints;
            } else {
                double formel = Math.sqrt(sqrtinput);
                x1 = -(p / 2) - formel;
                x2 = -(p / 2) + formel;
                zeropoints.add(x1);
                zeropoints.add(x2);
                return zeropoints;
            }

    }
    private ArrayList<Double> getNullLinear(){
        return new ArrayList<>(List.of((coefficients[0] * -1) / coefficients[1]));
    }


    public double[] firstDerivations() {
        double[] derivation = { 0.0, 0.0, 0.0, 0.0, 0.0 };

        for (int i = 0; i < coefficients.length-1; i++) {
            derivation[i] = (i+1) * coefficients[i+1];
        }

        return derivation;
    }


    public double[] getExtremePointsQuadratic(){
        ArrayList<Double> sumssecond = new ArrayList<>();
        double sum = 0;
        Polynom polynom = new Polynom(firstDerivations());
        ArrayList<Double> zeropoints = polynom.getZeropoints();
        double[] second = polynom.firstDerivations();
        //make the polynom into a second derivation to check for maxima and minima

        for(int j = 0; j < zeropoints.size(); j++){
            for (int i = 0; i< second.length; i++) {
                sum += second[i] * Math.pow(zeropoints.get(j), i);
            }
        }

    }


    public Polynom derivationPolynom() {
        return new Polynom(firstDerivations(), (derivationCounter+1));
    }


    private int highestPotenz() {
        int highestPotenz = 0;
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (highestPotenz == 0) {
                if (coefficients[i] != 0) {
                    highestPotenz = i;

                }

            }
        }
            return highestPotenz;
    }


    private void checkForSymmetry() {
        int totalNumbers = 0;
        int evenNumbers = 0;
        int oddNumbers = 0;

        for (int i = 0; i< coefficients.length; i++){
            if(coefficients[i] != 0){
                if(i % 2 == 0) evenNumbers ++; else oddNumbers++;
                totalNumbers++;
            }
        }
        if(evenNumbers == totalNumbers){
            symmetry = SYMMETRIES[0];
        } else if(oddNumbers == totalNumbers){
            symmetry = SYMMETRIES[1];
        } else {
            symmetry = SYMMETRIES[2];
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("f" + ("'".repeat(derivationCounter)) + "(x) = ");
        double[] temp = coefficients;
        int firstValueIndex = -1;
        for (int i = coefficients.length - 1; i >= 0; i--) if (coefficients[i] != 0) firstValueIndex = i;

        for (int i = temp.length - 1; i >= 0; i--) {
            if (temp[i] != 0) {
                builder.append(temp[i]);
                if (i != 0) {
                    builder.append("x");
                    if (i != 1) builder.append("^").append(i);

                    if (i > firstValueIndex) {
                        if (i - 1 != 0 && temp[i - 1] < 0) {
                            builder.append(" - ");
                            temp[i - 1] *= -1;
                        } else {
                            builder.append(" + ");
                        }
                    }
                }
            }

        }
        System.out.println(builder);
        return builder.toString();
    }
}