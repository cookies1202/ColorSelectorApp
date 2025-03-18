package at.fh.haas;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); // MUSS zuerst kommen!

        layout = findViewById(R.id.second_layout);

        String color = getIntent().getStringExtra("FARBE");

        if (color != null) {
            if (color.equals("Rot")) {
                layout.setBackgroundColor(Color.RED);
            } else if (color.equals("Grün")) {
                layout.setBackgroundColor(Color.GREEN);
            } else if (color.equals("Blau")) {
                layout.setBackgroundColor(Color.BLUE);
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(layout, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
