package tqs;

import java.util.ArrayList;

public class Calculator {
    ArrayList<Object> calc = new ArrayList<>();

    public void push(Object o){
        calc.add(o);
    }

    public double value(){
        String op = (String) calc.remove(calc.size()-1);
        int num2 = (int) calc.remove(calc.size()-1);
        int num1 = (int) calc.remove(calc.size()-1);

        double v = 0;

        if (op.equals("+")){
            v = num1 + num2;
        }
        if (op.equals("-")){
            v = num1 - num2;
        }
        return v;
    }
}
