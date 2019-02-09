package ndk.nikhil.gym_class_accounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_Add_Member extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_constraint_recyclerview);
        ButterKnife.bind(this);

//        build_form(recyclerView);
    }

//    private void build_form(RecyclerView recyclerView) {
//
//        // initialize variables
////        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        mFormBuilder = new FormBuildHelper(this, recyclerView);
//
//// declare form elements
//        FormHeader header = FormHeader.createInstance("Personal Info");
//        FormElementTextEmail element = FormElementTextEmail.createInstance().setTitle("Email").setHint("Enter Email");
//
//// add them in a list
//        List<FormObject> formItems = new ArrayList<>();
//        formItems.add(header);
//        formItems.add(element);
//
//// build and display the form
//        mFormBuilder.addFormElements(formItems);
//        mFormBuilder.refreshView();
//    }
}
