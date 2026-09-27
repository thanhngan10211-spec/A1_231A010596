package vn.edu.vhu.ltdd.a1lifecycle;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "A1_231A010596";

    private TextView tvLog;
    private TextView tvCounter; // Khai báo cho NC1
    private final StringBuilder history = new StringBuilder();
    private int step = 0;

    // NC1: Dùng LinkedHashMap để đếm số lần gọi mỗi callback
    private final Map<String, Integer> callbackCounts = new LinkedHashMap<>();

    private void logEvent(String event) {
        step++;

        // NC1: Cập nhật đếm số lần gọi callback
        String callbackName = event.split(" ")[0]; // Lấy tên callback (onCreate, onStart,...)
        int currentCount = callbackCounts.getOrDefault(callbackName, 0) + 1;
        callbackCounts.put(callbackName, currentCount);
        updateCounterDisplay();

        String time = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault())
                .format(new Date());
        String line = step + ". [" + time + "] " + event;
        Log.d(TAG, line);
        history.append(line).append('\n');
        if (tvLog != null) {
            tvLog.setText(history);
        }
    }

    // NC1: Cập nhật chuỗi hiển thị bảng đếm
    private void updateCounterDisplay() {
        if (tvCounter == null) return;
        StringBuilder sb = new StringBuilder("Số lần gọi: ");
        for (Map.Entry<String, Integer> entry : callbackCounts.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append(" | ");
        }
        tvCounter.setText(sb.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvLog = findViewById(R.id.tvLog);
        tvCounter = findViewById(R.id.tvCounter); // Ánh xạ tvCounter (NC1)
        Button btnClear = findViewById(R.id.btnClear);
        Button btnCrash = findViewById(R.id.btnCrash);
        Button btnFinish = findViewById(R.id.btnFinish);

        btnClear.setOnClickListener(v -> {
            history.setLength(0);
            step = 0;
            callbackCounts.clear(); // NC1: Xóa bộ đếm khi bấm Xóa log
            tvLog.setText("");
            tvCounter.setText("Số lần gọi: ");
            Log.i(TAG, "---- Đã xóa lịch sử ----");
        });

        btnCrash.setOnClickListener(v -> {
            String ten = null;
            Log.d(TAG, "Độ dài tên: " + ten.length());
        });

        btnFinish.setOnClickListener(v -> finish());

        String state = (savedInstanceState == null) ? "= null" : "!= null";
        logEvent("onCreate (savedInstanceState " + state + ")");
    }

    @Override
    protected void onStart() {
        super.onStart();
        logEvent("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logEvent("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logEvent("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logEvent("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logEvent("onRestart");
    }

    @Override
    protected void onDestroy() {
        logEvent("onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        logEvent("onSaveInstanceState");
    }
}