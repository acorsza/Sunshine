package com.aderleifilho.sunshine;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        ArrayAdapter<String> mForecastAdapter;
        ListView mListViewForecast;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            String[] forecastArray = {
                    "Today - Sunny - 88 / 33",
                    "Tomorrow - Foggy - 70 / 46",
                    "Weds - Cloudy - 72 / 63",
                    "Thursday - Rainy - 64 / 51",
                    "Fri - Foggy - 70 / 46",
                    "Sat - Sunny - 76 / 68",
            };

            List<String> weekForecast = new ArrayList<>(Arrays.asList(forecastArray));

            mForecastAdapter =
                    new ArrayAdapter<>(
                            getActivity(),
                            R.layout.list_item_forecast,
                            R.id.list_item_forecast_textview,
                            weekForecast);

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            mListViewForecast = (ListView) rootView.findViewById(R.id.listview_forecast);
            mListViewForecast.setAdapter(mForecastAdapter);
            return rootView;
        }
    }
}
