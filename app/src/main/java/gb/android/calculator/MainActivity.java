package gb.android.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


/*
<androidx.appcompat.widget.AppCompatImageView
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:background="@drawable/bg"
		app:layout_constraintBottom_toBottomOf="parent"
		app:layout_constraintEnd_toEndOf="parent"
		app:layout_constraintHorizontal_bias="0.0"
		app:layout_constraintStart_toStartOf="parent"
		app:layout_constraintTop_toTopOf="parent"
		app:layout_constraintVertical_bias="0.0" />
*
*
* */


public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    TextView display;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.display);

        Button buttonClear   = findViewById(R.id.buttonClear);

        Button buttonOne        = findViewById(R.id.buttonOne);
        Button buttonTwo        = findViewById(R.id.buttonTwo);
        Button buttonThree      = findViewById(R.id.buttonThree);
        Button buttonFour       = findViewById(R.id.buttonFour);
        Button buttonFive       = findViewById(R.id.buttonFive);
        Button buttonSix        = findViewById(R.id.buttonSix);
        Button buttonSeven      = findViewById(R.id.buttonSeven);
        Button buttonEight      = findViewById(R.id.buttonEight);
        Button buttonNine       = findViewById(R.id.buttonNine);
        Button buttonZero       = findViewById(R.id.buttonZero);

        Button buttonDot        = findViewById(R.id.buttonDot);
        Button buttonEquals     = findViewById(R.id.buttonEquals);

        Button buttonPlus       = findViewById(R.id.buttonPlus);
        Button buttonMinus      = findViewById(R.id.buttonMinus);
        Button buttonMultiply   = findViewById(R.id.buttonMultiply);
        Button buttonDivide     = findViewById(R.id.buttonDivide);

        buttonClear.setOnClickListener(this);
        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonSix.setOnClickListener(this);
        buttonSeven.setOnClickListener(this);
        buttonEight.setOnClickListener(this);
        buttonNine.setOnClickListener(this);
        buttonZero.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Button b;

        switch (v.getId())
        {
            case R.id.buttonClear:
                b = findViewById(R.id.buttonClear);
                display.setText(b.getText());
                break;
            case R.id.buttonOne:
                b = findViewById(R.id.buttonOne);
                display.setText(b.getText());
                break;
            case R.id.buttonTwo:
                b = findViewById(R.id.buttonTwo);
                display.setText(b.getText());
                break;
            case R.id.buttonThree:
                b = findViewById(R.id.buttonThree);
                display.setText(b.getText());
                break;
            case R.id.buttonFour:
                b = findViewById(R.id.buttonFour);
                display.setText(b.getText());
                break;
            case R.id.buttonFive:
                b = findViewById(R.id.buttonFive);
                display.setText(b.getText());
                break;
            case R.id.buttonSix:
                b = findViewById(R.id.buttonSix);
                display.setText(b.getText());
                break;
            case R.id.buttonSeven:
                b = findViewById(R.id.buttonSeven);
                display.setText(b.getText());
                break;
            case R.id.buttonEight:
                b = findViewById(R.id.buttonEight);
                display.setText(b.getText());
                break;
            case R.id.buttonNine:
                b = findViewById(R.id.buttonNine);
                display.setText(b.getText());
                break;
            case R.id.buttonZero:
                b = findViewById(R.id.buttonZero);
                display.setText(b.getText());
                break;
            case R.id.buttonDot:
                b = findViewById(R.id.buttonDot);
                display.setText(b.getText());
                break;
            case R.id.buttonEquals:
                b = findViewById(R.id.buttonEquals);
                display.setText(b.getText());
                break;
            case R.id.buttonPlus:
                b = findViewById(R.id.buttonPlus);
                display.setText(b.getText());
                break;
            case R.id.buttonMinus:
                b = findViewById(R.id.buttonMinus);
                display.setText(b.getText());
                break;
            case R.id.buttonMultiply:
                b = findViewById(R.id.buttonMultiply);
                display.setText(b.getText());
                break;
            case R.id.buttonDivide:
                b = findViewById(R.id.buttonDivide);
                display.setText(b.getText());
                break;
        }
    }
}