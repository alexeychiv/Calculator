package gb.android.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView display;
    private Calculator calculator;
    private String KEY_CALCULATOR = "calc";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        setOnClickListeners();

        calculator = new Calculator();

        display.setText(calculator.getDisplay());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putParcelable(KEY_CALCULATOR, calculator);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        calculator = instanceState.getParcelable(KEY_CALCULATOR);
        display.setText(calculator.getDisplay());
    }


    private void setOnClickListeners() {
        findViewById(R.id.buttonClear).setOnClickListener(this);

        findViewById(R.id.buttonOne).setOnClickListener(this);
        findViewById(R.id.buttonTwo).setOnClickListener(this);
        findViewById(R.id.buttonThree).setOnClickListener(this);
        findViewById(R.id.buttonFour).setOnClickListener(this);
        findViewById(R.id.buttonFive).setOnClickListener(this);
        findViewById(R.id.buttonSix).setOnClickListener(this);
        findViewById(R.id.buttonSeven).setOnClickListener(this);
        findViewById(R.id.buttonEight).setOnClickListener(this);
        findViewById(R.id.buttonNine).setOnClickListener(this);
        findViewById(R.id.buttonZero).setOnClickListener(this);

        findViewById(R.id.buttonDot).setOnClickListener(this);
        findViewById(R.id.buttonEquals).setOnClickListener(this);

        findViewById(R.id.buttonPlus).setOnClickListener(this);
        findViewById(R.id.buttonMinus).setOnClickListener(this);
        findViewById(R.id.buttonMultiply).setOnClickListener(this);
        findViewById(R.id.buttonDivide).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonClear:
                calculator.clear();
                break;
            case R.id.buttonOne:
                calculator.addDigit('1');
                break;
            case R.id.buttonTwo:
                calculator.addDigit('2');
                break;
            case R.id.buttonThree:
                calculator.addDigit('3');
                break;
            case R.id.buttonFour:
                calculator.addDigit('4');
                break;
            case R.id.buttonFive:
                calculator.addDigit('5');
                break;
            case R.id.buttonSix:
                calculator.addDigit('6');
                break;
            case R.id.buttonSeven:
                calculator.addDigit('7');
                break;
            case R.id.buttonEight:
                calculator.addDigit('8');
                break;
            case R.id.buttonNine:
                calculator.addDigit('9');
                break;
            case R.id.buttonZero:
                calculator.addDigit('0');
                break;
            case R.id.buttonDot:
                calculator.addDot();
                break;
            case R.id.buttonEquals:
                calculator.actionEquals();
                break;
            case R.id.buttonPlus:
                calculator.setAction(Calculator.Action.PLUS);
                break;
            case R.id.buttonMinus:
                calculator.setAction(Calculator.Action.MINUS);
                break;
            case R.id.buttonMultiply:
                calculator.setAction(Calculator.Action.MULTIPLY);
                break;
            case R.id.buttonDivide:
                calculator.setAction(Calculator.Action.DIVIDE);
                break;
        }

        display.setText(calculator.getDisplay());
    }
}