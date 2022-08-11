package sg.edu.rp.c346.id20047102.covidrecords;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Covid> covidList;

    public CustomAdapter(Context context, int resource, ArrayList<Covid> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        covidList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvCaseCount = rowView.findViewById(R.id.tvCaseCount);
        TextView tvStatus = rowView.findViewById(R.id.tvStatus);
        TextView tvAgeGrp = rowView.findViewById(R.id.tvAgeGroup);
        TextView tvDate = rowView.findViewById(R.id.tvDate);

        // Obtain the Song information based on the position
        Covid currentCovid = covidList.get(position);

        // Set values to the TextView to display the corresponding information
        tvCaseCount.setText("No. of Covid Cases: " + currentCovid.getCovidCases());
        tvStatus.setText("Status: " + currentCovid.getClinicalStatus());
        tvAgeGrp.setText("Age Group: " + currentCovid.getAgeGroups());
        tvDate.setText("Date: " + currentCovid.getDate() + "\n");

        return rowView;
    }


}
