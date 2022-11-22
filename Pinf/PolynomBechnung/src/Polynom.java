public class Polynom {

    private final double[] coefficients;
    private String symmetry;
    private String highestPotenz;
    public final String[] SYMMETRIES = new String[] {"Axisymmetric", "Pointsymmetric", "No symmetry"};

    public Polynom(double[] coefficients) {
        this.coefficients = coefficients;
        checkForSymmetry();
        highestPotenz();
    }

    public String getHighestPotenz() {
        return highestPotenz;
    }

    public String getSymmetry() {
        return symmetry;
    }

    //following methods are unfinished or not build in the right way atm
    public double calculateY(double x) {
        double sum = 0.;
        for (int i = 0; i < coefficients.length; i++) {
            sum += coefficients[i] * Math.pow(x, i);
        }
        return sum;
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
        }
        if(oddNumbers == totalNumbers){
            symmetry = SYMMETRIES[1];
        }
        symmetry = SYMMETRIES[2];
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