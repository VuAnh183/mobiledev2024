package vn.edu.usth.weather;


import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class WeatherActivity extends AppCompatActivity{
    private ViewPager viewPager;
    private PagerAdapter weatherPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
        mediaPlayer.start();

        PagerAdapter adapter = new HomeFragmentPagerAdapter(
                getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.weather_pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);

        final Handler handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                // This method is executed in main thread
                String content = msg.getData().getString("server_response");
                Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
            }
        };

        AsyncTask<String, Integer, Bitmap> task = new AsyncTask<String, Integer, Bitmap>() {

            @Override
            protected Bitmap doInBackground(String... params) {
                // This is where the worker thread's code is executed
                // params are passed from the execute() method call
                try {
                    // initialize URL
                    URL url = new URL("https://usth.edu.vn/wp-content/uploads/2021/11/logo.png");
                    // Make a request to server
                    HttpURLConnection connection =
                            (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setDoInput(true);
                    // allow reading response code and response dataconnection.
                    connection.connect();
                    // Receive response
                    int response = connection.getResponseCode();
                    Log.i("USTHWeather", "The response is: " + response);
                    InputStream is = connection.getInputStream();
                    // Process image response
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    connection.disconnect();
                    return bitmap;

                } catch (ProtocolException e) {
                    throw new RuntimeException(e);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                // This method is called in the main thread. After #doInBackground returns
                // the bitmap data, we simply set it to an ImageView using ImageView.setImageBitmap()

                ImageView logo = (ImageView) findViewById(R.id.logo);
                logo.setImageBitmap(bitmap);
                Toast.makeText(WeatherActivity.this, "Download finished", Toast.LENGTH_SHORT).show();
            }
        };
        task.execute("https://usth.edu.vn/wp-content/uploads/2021/11/logo.png");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_refresh){
            Toast.makeText(this,"Refresh button pressed", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.action_setting) {
            Toast.makeText(this,"Setting button pressed", Toast.LENGTH_SHORT).show();
        } else {
            return false;
        }
        return true;
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


