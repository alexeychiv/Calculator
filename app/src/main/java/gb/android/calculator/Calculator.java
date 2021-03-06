package gb.android.calculator;

import android.os.Parcel;
import android.os.Parcelable;

public class Calculator implements Parcelable {

    private int displaySize = 15;
    private String display;

    private boolean isDot;
    private boolean isNumber1Long;
    private boolean isNumber2Long;

    private long number1_long;
    private long number2_long;
    private double number1_double;
    private double number2_double;

    enum State {
        INIT,
        NUMBER1,
        ACTION,
        NUMBER2,
        EQUALS
    }

    private State state;

    enum Action {
        NONE,
        PLUS,
        MINUS,
        MULTIPLY,
        DIVIDE,
    }

    private Action action;


    //====================================================================================================================
    //  CONSTRUCTOR

    public Calculator() {
        clear();
    }

    //====================================================================================================================
    //  PARCELABLE

    protected Calculator(Parcel in) {
        displaySize = in.readInt();
        display = in.readString();
        isDot = in.readByte() != 0;
        isNumber1Long = in.readByte() != 0;
        isNumber2Long = in.readByte() != 0;
        number1_long = in.readLong();
        number2_long = in.readLong();
        number1_double = in.readDouble();
        number2_double = in.readDouble();
    }

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @Override
        public Calculator createFromParcel(Parcel in) {
            return new Calculator(in);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(displaySize);
        dest.writeString(display);
        dest.writeByte((byte) (isDot ? 1 : 0));
        dest.writeByte((byte) (isNumber1Long ? 1 : 0));
        dest.writeByte((byte) (isNumber2Long ? 1 : 0));
        dest.writeLong(number1_long);
        dest.writeLong(number2_long);
        dest.writeDouble(number1_double);
        dest.writeDouble(number2_double);
    }


    //====================================================================================================================
    //  UTILS

    private void parseNumber1() {
        if (isNumber1Long)
            number1_long = Long.parseLong(display);
        else
            number1_double = Double.parseDouble(display);
    }

    private void parseNumber2() {
        if (isNumber2Long)
            number2_long = Long.parseLong(display);
        else
            number2_double = Double.parseDouble(display);
    }

    private void calculate() {
        if (isNumber1Long && isNumber2Long) {
            switch (action) {
                case PLUS:
                    number1_long += number2_long;
                    return;
                case MINUS:
                    number1_long -= number2_long;
                    return;
                case MULTIPLY:
                    number1_long *= number2_long;
                    return;
                case DIVIDE: {
                    if (number1_long % number2_long > 0) {
                        isNumber1Long = false;
                        number1_double = (double) number1_long / number2_long;
                    } else {
                        number1_long = number1_long / number2_long;
                    }
                }
            }
        } else {
            double result = isNumber1Long ? number1_long : number1_double;
            double num2 = isNumber2Long ? number2_long : number2_double;

            switch (action) {
                case PLUS:
                    result += num2;
                    break;
                case MINUS:
                    result -= num2;
                    break;
                case MULTIPLY:
                    result *= num2;
                    break;
                case DIVIDE:
                    result /= num2;
                    break;
            }

            if (result == (long) result) {
                isNumber1Long = true;
                number1_long = (long) result;
            } else {
                isNumber1Long = false;
                number1_double = result;
            }
        }
    }

    //====================================================================================================================
    //  INTERFACE


    public String getDisplay() {
        return display;
    }

    public void clear() {
        display = "0";

        isDot = false;
        isNumber1Long = true;
        isNumber2Long = true;

        number1_long = 0;

        state = State.INIT;

        action = Action.NONE;
    }

    public void addDigit(char digit) {
        switch (state) {
            case INIT:
            case EQUALS: {
                clear();

                state = State.NUMBER1;
                display = Character.toString(digit);

                return;
            }

            case NUMBER1: {
                if (display.length() == displaySize + (isDot ? 1 : 0))
                    return;

                if (isNumber1Long && isDot) {
                    display += ".";
                    isNumber1Long = false;
                }

                display += digit;

                return;
            }

            case ACTION: {
                state = State.NUMBER2;

                if (isNumber2Long && isDot) {
                    isNumber2Long = false;
                    display = "0." + digit;
                } else
                    display = Character.toString(digit);

                return;
            }

            case NUMBER2: {
                if (display.length() == displaySize + (isDot ? 1 : 0))
                    return;

                if (isNumber2Long && isDot) {
                    display += ".";
                    isNumber2Long = false;
                }

                display += digit;
            }
        }
    }

    public void addDot() {
        if (isDot)
            return;

        switch (state) {
            case INIT:
            case EQUALS: {
                clear();

                isDot = true;
                state = State.NUMBER1;
                display = "0.";

                return;
            }

            case NUMBER1:
            case NUMBER2: {
                if (display.length() == displaySize)
                    return;

                isDot = true;

                return;
            }

            case ACTION: {
                isDot = true;
            }
        }
    }

    public void setAction(Action action) {
        switch (state) {
            case ACTION:
                this.action = action;
                isDot = false;
            case INIT:
            case EQUALS: {
                state = State.ACTION;

                return;
            }

            case NUMBER1: {
                parseNumber1();

                state = State.ACTION;
                this.action = action;
                isDot = false;
                isNumber2Long = true;

                return;
            }

            case NUMBER2: {
                parseNumber2();

                calculate();

                if (isNumber1Long)
                    display = Long.toString(number1_long);
                else
                    display = Double.toString(number1_double);
            }
        }
    }

    public void actionEquals() {
        switch (state) {
            case INIT:
            case NUMBER1:
                isDot = false;
                return;

            case ACTION:
                isNumber2Long = isNumber1Long;
            case NUMBER2:
                isDot = false;
                parseNumber2();
                state = State.EQUALS;
            case EQUALS: {
                calculate();

                if (isNumber1Long)
                    display = Long.toString(number1_long);
                else
                    display = Double.toString(number1_double);
            }
        }
    }
}
