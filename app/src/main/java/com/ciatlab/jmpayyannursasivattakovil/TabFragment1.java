package com.ciatlab.jmpayyannursasivattakovil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class TabFragment1 extends Fragment {
    EditText Cname, phone, email, muncipaplity, complaint;
    Spinner ward;
    Button submit;
    String current_item;
    String array_os[] = {"--SELECT--", "1", "2", "3", "4", "5", "6","7","8","9","10",
            "11", "12", "13", "14", "15", "16","17","18","19","20","21", "22", "23", "24", "25", "26","27","28","29","30",
            "31", "32", "33", "34", "35", "36","37","38","39","40","41", "42", "43", "44", "45", "46","47","48","49","50",};
    View v;

   /* private ListView lView;
    private MyListAdapter obj;
    List<Storage> profList;

    //the listview
    ListView listView;
*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tab_fragment_1, container, false);
        Cname = (EditText) v.findViewById(R.id.cname);
       phone = (EditText) v.findViewById(R.id.phone);
        email = (EditText) v.findViewById(R.id.email);
        muncipaplity = (EditText) v.findViewById(R.id.muncipal);
        complaint = (EditText) v.findViewById(R.id.complaint);
        ward = (Spinner) v.findViewById(R.id.ward);
        submit=(Button)v.findViewById(R.id.submit);
        ArrayAdapter<String> spinner_adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item, array_os);

        ward.setAdapter(spinner_adapter);
        ward.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                current_item = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name=Cname.getText().toString();
                String Phone=phone.getText().toString();
                String Email=email.getText().toString();
                String Ward=current_item ;
                String Munciplality=muncipaplity.getText().toString();
                String Complaint=complaint.getText().toString();
                ComplaintRegisterClass complaintRegisterClass = new ComplaintRegisterClass(getContext());
                complaintRegisterClass.execute(Name,Phone,Email,Ward,Munciplality,Complaint);


            }
        });
        return v;




        // View v = inflater.inflate(R.layout.tab_fragment_1, container, false);
        // perform(v);


        // return inflater.inflate(R.layout.tab_fragment_1, container, false);

    }

}















