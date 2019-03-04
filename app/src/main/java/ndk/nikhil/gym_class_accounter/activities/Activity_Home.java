package ndk.nikhil.gym_class_accounter.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ndk.nikhil.gym_class_accounter.Gym_Class_Accounter;
import ndk.nikhil.gym_class_accounter.R;
import ndk.utils.Activity_Utils;

public class Activity_Home extends Gym_Class_Accounter {

    @BindView(R.id.button_notifications)
    Button button_Notifications;
    @BindView(R.id.button_collect_fee)
    Button button_Collect_Fee;
    @BindView(R.id.button_members)
    Button button_Members;
    @BindView(R.id.button_unpaid_members)
    Button button_Unpaid_Members;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        //TODO : Activity blank to Utils

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

        //        ConstraintLayout layout_constraint_activity_blank=findViewById(R.id.layout_constraint_activity_blank);
//        Button button_notifications=new Button(this);
//        button_notifications.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,48));
////        button_notifications.setBackground(getDrawable(ndk.utils.R.drawable.shape_button));
//        button_notifications.setText(getString(R.string.notifications));
//
//        layout_constraint_activity_blank.addView(button_notifications);

    }

    @OnClick({R.id.button_notifications, R.id.button_collect_fee, R.id.button_members, R.id.button_unpaid_members})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_notifications:
                Activity_Utils.start_activity(activity_context, Activity_Notifications.class);
                break;
            case R.id.button_collect_fee:
                Activity_Utils.start_activity(activity_context, Activity_Collect_Fee_Old.class);
                break;
            case R.id.button_members:
                Activity_Utils.start_activity(activity_context, Activity_Members.class);
                break;
            case R.id.button_unpaid_members:
                Activity_Utils.start_activity(activity_context, Activity_Members.class);
                break;
        }
    }
}
