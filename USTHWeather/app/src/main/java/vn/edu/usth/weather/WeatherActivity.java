package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class WeatherActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_forecast);


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            // Create a new Fragment to be placed in the activity
//            ForecastFragment firstFragment = new ForecastFragment();
//
//            // Add the fragment to the 'container' FrameLayout
//            getSupportFragmentManager().beginTransaction().add(
//                    R.id.main, firstFragment).commit();
//
//            return insets;
//        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("OnStart", "This is the onStart function!");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i("OnStop", "This is the onStop function!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("OnDestroy", "This is the onDestroy function!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("OnPause", "This is the onPause function!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("OnResume", "This is the onResume function!");
    }


}

