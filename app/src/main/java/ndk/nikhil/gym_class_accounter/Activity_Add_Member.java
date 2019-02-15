package ndk.nikhil.gym_class_accounter;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ndk.utils.Activity_Utils;
import ndk.utils.Date_Picker_Utils;
import ndk.utils.Date_Utils;
import ndk.utils.Log_Utils;
import ndk.utils.Toast_Utils;

public class Activity_Add_Member extends Gym_Class_Accounter {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    Button join_date, submit;
    private ImageView mImageView;
    private Calendar start_calendar = Calendar.getInstance();

    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        // Spinner element
        Spinner spinner = findViewById(R.id.spinner);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Monthly");
        categories.add("Two Monthly");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        mImageView = findViewById(R.id.imageView);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        join_date = findViewById(R.id.button_join);
        join_date.setText("Start Date : " + Date_Utils.get_current_date_string_in_normal_format());
        final DatePickerDialog.OnDateSetListener start_date_chooser_listener = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                start_calendar.set(Calendar.YEAR, year);
                start_calendar.set(Calendar.MONTH, monthOfYear);
                start_calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        join_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date_Picker_Utils.show_date_picker(activity_context, start_date_chooser_listener, start_calendar);
            }
        });


        DatabaseHelper db = new DatabaseHelper(this);

        submit = findViewById(R.id.sign_in_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText name = findViewById(R.id.name);
                EditText address = findViewById(R.id.address);
                EditText fee = findViewById(R.id.fee);

                long id = db.insertNote(name.getText().toString(), address.getText().toString(), getBitmapAsByteArray(((BitmapDrawable) mImageView.getDrawable()).getBitmap()), join_date.getText().toString().substring(join_date.getText().toString().indexOf(":") + 1), spinner.getSelectedItem().toString(), fee.getText().toString());
                Log_Utils.debug("Gym_Class_Accounter", String.valueOf(id), BuildConfig.DEBUG);
                Toast_Utils.longToast(activity_context, "Inserted : " + id);

                Activity_Utils.start_activity_with_finish(activity_context, Activity_Members.class, "Gym_Class_Accounter");
            }
        });

    }

    private void updateLabel() {
        join_date.setText("Start Date : " + Date_Utils.date_to_normal_date_string(start_calendar.getTime()));

    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }

}
