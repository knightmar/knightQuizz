package fr.knightmar.knightquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import fr.knightmar.knightquizz.utils.Questions;

public class MainActivity extends AppCompatActivity {
    protected TextView title;
    protected EditText name_field;
    protected Button confirm_button;
    protected boolean isEnabled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title_text);
        name_field = findViewById(R.id.name_field);
        confirm_button = findViewById(R.id.confirm_button);

        confirm_button.setEnabled(false);

        name_field.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                isEnabled = name_field.getText().length() > 3;
                confirm_button.setEnabled(isEnabled);
            }
        });

        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Bienvenue " + name_field.getText(), Toast.LENGTH_SHORT).show();
                Intent gameActivityIntent = new Intent(MainActivity.this,GameActivity.class);
                startActivity(gameActivityIntent);
            }
        });
    }
}