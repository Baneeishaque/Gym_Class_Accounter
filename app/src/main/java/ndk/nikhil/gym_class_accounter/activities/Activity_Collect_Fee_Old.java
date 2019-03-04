package ndk.nikhil.gym_class_accounter.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ndk.nikhil.gym_class_accounter.DatabaseHelper;
import ndk.nikhil.gym_class_accounter.Model_Gym_Class;
import ndk.nikhil.gym_class_accounter.R;
import ndk.utils.Date_Utils;

public class Activity_Collect_Fee_Old extends AppCompatActivity {

    Button join_date, submit;
    private ImageView mImageView;
    private Calendar start_calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_fee_old);

        join_date = findViewById(R.id.button_join);
        join_date.setText("Date : " + Date_Utils.get_current_date_string_in_normal_format());

        // Spinner element
        Spinner spinner = findViewById(R.id.spinner);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
//        categories.add("Monthly");
//        categories.add("Two Monthly");
        categories.add("Select Member");

        DatabaseHelper db = new DatabaseHelper(this);
        List<Model_Gym_Class> members = db.getAllNotes();
        for (int i = 0; i < members.size(); i++) {
            Model_Gym_Class member = members.get(i);
            categories.add(member.getName());
        }

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position != 0) {
                    EditText fee = findViewById(R.id.fee);
                    EditText collected_amount = findViewById(R.id.collected_amount);
                    EditText balance = findViewById(R.id.balance);

                    fee.setText(members.get(position + 1).getFee());
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
