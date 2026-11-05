package vn.edu.course.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import vn.edu.course.helloworld.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String KEY_NAME = "greeted_name";

    private ActivityMainBinding binding;
    @Nullable
    private String greetedName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });

        if (savedInstanceState != null) {
            greetedName = savedInstanceState.getString(KEY_NAME);
        }
        Log.d(TAG, "onCreate, restored=" + (savedInstanceState != null));

        showGreeting();
        binding.sayHelloButton.setOnClickListener(v -> sayHello());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_NAME, greetedName);
        Log.d(TAG, "onSaveInstanceState, saved greetedName=" + greetedName);
    }

    private void sayHello() {
        String name = binding.nameInput.getText().toString().trim();
        if (name.isEmpty()) {
            Toast.makeText(this, R.string.toast_enter_name, Toast.LENGTH_SHORT).show();
        } else {
            greetedName = name;
            showGreeting();
        }
    }

    private void showGreeting() {
        if (greetedName == null) {
            binding.greetingText.setText(getString(
                    R.string.greeting_intro,
                    getString(R.string.student_name),
                    getString(R.string.student_id)));
        } else {
            binding.greetingText.setText(getString(R.string.greeting_pattern, greetedName));
        }
    }
}
