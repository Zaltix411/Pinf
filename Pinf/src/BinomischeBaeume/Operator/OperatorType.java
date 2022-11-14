package BinomischeBaeume.Operator;

public  enum OperatorType {
    ADD {
        @Override
        double getValue(Node leftValue, Node rightValue) {
            return leftValue.getValue() + rightValue.getValue();
        }

        @Override
        public String toString() {
            return "+";

        }
    },
    SUBSTRACT{
        @Override
        double getValue(Node leftValue,Node rightValue){
            return leftValue.getValue() - rightValue.getValue();
        }

        @Override
        public String toString(){
            return "-";
        }
    },
    MUTIPLY{
        @Override
        double getValue(Node leftValue, Node rightValue) {
            return leftValue.getValue() * rightValue.getValue();
        }
        @Override
        public String toString(){
            return "*";
        }
    },
    DIVIDE{
        @Override
        double getValue(Node leftValue, Node rightValue) {
            return leftValue.getValue() / rightValue.getValue();
        }

        @Override
        public String toString(){
            return "/";
        }
    },
    POWER{
        @Override
        double getValue(Node leftValue, Node rightValue) {
            return Math.pow(leftValue.getValue(),rightValue.getValue());
        }
        @Override
        public String toString(){
            return "^";
        }
    };


    abstract double getValue(Node leftValue, Node rightValue);


}
