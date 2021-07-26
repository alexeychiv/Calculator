package gb.android.calculator;

public class Calculator {
    String  displayNumber;

    int     number1_int;
    int     number2_int;
    double  number1_double;
    double  number2_double;

    enum Action
    {
        plus,
        minus,
        miltiply,
        divide,
    };

    Action action;

    public String getDisplayNumber()
    {
        return displayNumber;
    }





}
