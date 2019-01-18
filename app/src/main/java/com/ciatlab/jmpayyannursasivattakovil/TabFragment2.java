package com.ciatlab.jmpayyannursasivattakovil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class TabFragment2 extends Fragment {
    Button SUB;
    EditText token;
    View view;

    @Override
    public View onCreateView(LayoutInflater abc, ViewGroup container, Bundle savedInstanceState) {
        // return abc.inflate(R.layout.tab_fragment_2, container, false);
        view = abc.inflate(R.layout.tab_fragment_2, container, false);

        SUB=(Button)view.findViewById(R.id.sub);
        token=(EditText) view.findViewById(R.id.edittext);
        SUB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TokenCode= token.getText().toString();
                Log.e("Token_CodeTab",""+TokenCode);
                // Log.e("Token_Codetoken ",""+String.valueOf(token));
                if(!TokenCode.equals("")) {
                    Intent nxt = new Intent(getContext(), ComplaintStatusDetails.class);
                    nxt.putExtra("Token_Code", TokenCode);

                    startActivity(nxt);
                }


            }
        });


        return view;}
}
