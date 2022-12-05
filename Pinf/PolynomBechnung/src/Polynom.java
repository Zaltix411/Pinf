import java.util.ArrayList;

public class Polynom {

    private final double[] coefficients;
    private String symmetry;
    private String highestPotenz;
    public static final String[] SYMMETRIES = new String[] {"Axisymmetric", "Pointsymmetric", "No symmetry"};

    public Polynom(double[] coefficients) {
        this.coefficients = coefficients;
    }

    public String getHighestPotenz() {
        return highestPotenz;
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

    public ArrayList<Double> getZeropoints(){
        double[] temp = coefficients;
        ArrayList<Double> zeropoints = new ArrayList<>();
        Double x1;
        Double x2;
        Double sum;
        double p = coefficients[1];
        double q = coefficients[0];

        if(coefficients[2] != 0.0){

            if(temp[2] < 0){
                p = p / -1;
                q = q / -1;
            }
               p = p / coefficients[2];
               q = q / coefficients[2];

            double sqrtinput = Math.pow((p/2),2)-q;
            if(sqrtinput < 0 ){
                System.out.println("geht nicht");
            }else{
                double formel =  Math.sqrt(sqrtinput);
                x1 = -(p/2) - formel;
                x2 = -(p/2) + formel;
                zeropoints.add(x1);
                zeropoints.add(x2);
            }


        }else if(coefficients[1] != 0.0){
            sum = coefficients[0] * - 1 / coefficients[1];
            zeropoints.add(sum);


        }else if(coefficients[0] != 0){
            System.out.println("Lösung ist entweder 0 oder Unendlich");
        }else{
            System.out.println("Exponent ist zu groß");
        }
        return zeropoints;
    }



    public double[] firstDerivations() {
        double[] derivation = new double[5];

        for (int i = 0; i < coefficients.length; i++) {
            if (i == 0) derivation[i] = 0;
            else derivation[i-1] = i * coefficients[i];
        }
        return derivation;
    }

    public Polynom derivationPolynom() {
        return new Polynom(firstDerivations());
    }


    private void highestPotenz() {
        int potenz = 0;

        for (int i = 4; i > 0; i--) {
            if (coefficients[i] != 0.) {
                potenz = i;
                i = 0;
            }
        }
       highestPotenz = potenz + ". Grades";
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
        StringBuilder builder = new StringBuilder("f(x) =");
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