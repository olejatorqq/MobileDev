package ru.mirea.orlovsky.lesson5;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);

        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        ArrayList<HashMap<String, String>> sensorList = new ArrayList<>();
        for (Sensor sensor : sensors) {
            HashMap<String, String> sensorMap = new HashMap<>();
            sensorMap.put("Name", sensor.getName());
            sensorMap.put("Type", String.valueOf(sensor.getType()));
            sensorList.add(sensorMap);
        }

        SensorAdapter adapter = new SensorAdapter(this, sensorList);
        listView.setAdapter(adapter);
    }
}
