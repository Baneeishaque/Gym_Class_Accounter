package ndk.nikhil.gym_class_accounter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ndk.utils.Activity_Utils;

public class Activity_Home extends Gym_Class_Accounter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //TODO : Activity blank to Utils

//        ConstraintLayout layout_constraint_activity_blank=findViewById(R.id.layout_constraint_activity_blank);

        //TODO : Use Plugins to generate layout fields

        /*
        <Button
        android:id="@+id/button_pandora"
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:layout_marginLeft="16dp"
        android:layout_marginTop="16dp"
        android:layout_marginRight="16dp"
        android:background="@drawable/shape_button"
        android:text="@string/pandora"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:layout_constraintBottom_creator="1"
        tools:layout_constraintLeft_creator="1"
        tools:layout_constraintRight_creator="1" />
         */

        //TODO : Create above button
//        Button button_notifications=new Button(this);
//        button_notifications.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,48));
////        button_notifications.setBackground(getDrawable(ndk.utils.R.drawable.shape_button));
//        button_notifications.setText(getString(R.string.notifications));
//
//        layout_constraint_activity_blank.addView(button_notifications);

        Button button_notifications = findViewById(R.id.button_notifications);
        button_notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity_Utils.start_activity(activity_context, Activity_Home.class);
            }
        });
    }
}
