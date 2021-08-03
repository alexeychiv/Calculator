package gb.android.calculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;


public class ThemesActivity extends AppCompatActivity implements View.OnClickListener {
    private int currentTheme;
    private final String KEY_SP = "theme";
    private final String KEY_CURRENT_THEME = "cur_theme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getCurrentThemeId());
        setContentView(R.layout.activity_themes);

        setCurrentRadio();
        setOnClickListeners();
    }

    private void setCurrentRadio() {
        switch (currentTheme)
        {
            case 1:
                ((RadioButton)findViewById(R.id.radio_theme_one)).setChecked(true);
                break;
            case 2:
                ((RadioButton)findViewById(R.id.radio_theme_two)).setChecked(true);
                break;
            case 3:
                ((RadioButton)findViewById(R.id.radio_theme_three)).setChecked(true);
                break;
        }
    }

    private void setOnClickListeners() {
        findViewById(R.id.buttonDone).setOnClickListener(this);

        findViewById(R.id.radio_theme_one).setOnClickListener(this);
        findViewById(R.id.radio_theme_two).setOnClickListener(this);
        findViewById(R.id.radio_theme_three).setOnClickListener(this);
    }

    private int getCurrentThemeId()
    {
        currentTheme = getSharedPreferences(KEY_SP, MODE_PRIVATE).getInt(KEY_CURRENT_THEME, -1);

        switch (currentTheme)
        {
            case 1:
                return R.style.Theme1;
            case 2:
                return R.style.Theme2;
            case 3:
                return R.style.Theme3;
        }

        return R.style.Theme1;
    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor = getSharedPreferences(KEY_SP, MODE_PRIVATE).edit();

        switch (v.getId()) {
            case R.id.buttonDone:
                editor.putInt(KEY_CURRENT_THEME, currentTheme);
                finish();
                break;
            case R.id.radio_theme_one:
                editor.putInt(KEY_CURRENT_THEME, 1);
                currentTheme = 1;
                break;
            case R.id.radio_theme_two:
                editor.putInt(KEY_CURRENT_THEME, 2);
                currentTheme = 2;
                break;
            case R.id.radio_theme_three:
                editor.putInt(KEY_CURRENT_THEME, 3);
                currentTheme = 3;
                break;
        }

        editor.apply();
        recreate();
    }
}