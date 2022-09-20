package BinomischeBaeume;

public  enum OperatorType {
    ADD {
        @Override
        double getValue(Node leftValue, Node rightValue) {
            return leftValue.getValue() + rightValue.getValue();
        }
    },
    SUBSTRACT{
        @Override
        double getValue(Node leftValue,Node rightValue){
            return leftValue.getValue() - rightValue.getValue();
        }
    },
    MUTIPLY{
        @Override
        double getValue(Node leftValue, Node rightValue) {
            return leftValue.getValue() * rightValue.getValue();
        }
    },
    DIVIDE{
        @Override
        double getValue(Node leftValue, Node rightValue) {
            return leftValue.getValue() / rightValue.getValue();
        }
    },
    POWER{
        @Override
        double getValue(Node leftValue, Node rightValue) {
            return Math.pow(leftValue.getValue(),rightValue.getValue());
        }
    };


    abstract double getValue(Node leftValue, Node rightValue);


}
