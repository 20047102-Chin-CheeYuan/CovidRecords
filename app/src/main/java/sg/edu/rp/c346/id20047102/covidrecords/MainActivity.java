package sg.edu.rp.c346.id20047102.covidrecords;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvCovidCases;
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCovidCases = findViewById(R.id.lvCovid);
        client = new AsyncHttpClient();

    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Covid> covidList = new ArrayList<Covid>();
        ArrayAdapter<Covid> covidAdapter = new ArrayAdapter<Covid>(this, android.R.layout.simple_list_item_1, covidList);
        lvCovidCases.setAdapter(covidAdapter);

        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=9de30d8d-3c0d-48ab-8c1b-4a7dc03d687a&limit=5", new JsonHttpResponseHandler() {

            String covidCases;
            String clinicalStatus;
            String ageGroups;
            String date;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONObject resultObj = response.getJSONObject("result");
                    JSONArray jsonArrRecords = resultObj.getJSONArray("records");
                    for (int i = 0; i < jsonArrRecords.length(); i++) {
                        JSONObject jsonObjRecords = jsonArrRecords.getJSONObject(i);
                        covidCases = jsonObjRecords.getString("count_of_case");
                        clinicalStatus = jsonObjRecords.getString("clinical_status");
                        ageGroups = jsonObjRecords.getString("age_groups");
                        date = jsonObjRecords.getString("day_of_as_of_date");
                        Covid covidRecords = new Covid(covidCases, clinicalStatus, ageGroups, date);
                        covidList.add(covidRecords);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.d("app", covidList.size() + "");
                covidAdapter.notifyDataSetChanged();
            }

        });


    }
}