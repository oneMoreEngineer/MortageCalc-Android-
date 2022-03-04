package edu.sjsu.android.mortgagecalculator;

public class Calculator {
    public static float CalculateInterest(float amount, float years,
                                          float interest, boolean taxes ) {
        float numOfMonth = years * 12;
        float taxesAndInsurance = 0;
        float monthlyInterest = interest / 1200;
        if (taxes) {
            taxesAndInsurance = (float) (amount * 0.001);
        }

        if (interest == 0.0) {
            return (amount / numOfMonth) + taxesAndInsurance;
        } else {
            return (float) (amount * (monthlyInterest /
                    (1 - Math.pow((1 + monthlyInterest), -numOfMonth))) + taxesAndInsurance);
        }
    }
}
