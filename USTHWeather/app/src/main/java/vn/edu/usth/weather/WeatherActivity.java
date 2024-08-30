package vn.edu.usth.weather;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class WeatherActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("OnCreate", "This is the onCreate function!");
//        // Create a new Fragment to be placed in the activity
//        ForecastFragment firstFragment = new ForecastFragment();
//
//        // Add the fragment to the 'container' FrameLayout
//        getSupportFragmentManager().beginTransaction().add(
//                R.id.main, firstFragment).commit();

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

