package com.example.healhcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][]doctor_details1 =
            {
                    {"Doctor Name : Kartik Sawant", "Hospital Address : Vashi", "Exp : 5yrs","Mobile No : 8693860000","600"},
                    {"Doctor Name : Avishkar Kakade", "Hospital Address : Kalyan","Exp : 5yrs", "Mobile No :1234567890 ","900"},
                    {"Doctor Name : Ayush Sonawane", "Hospital Address : Bandra","Exp : 5yrs", "Mobile No : 8612345678","300"},
                    {"Doctor Name : Sahil Tadavi", "Hospital Address : Kalyan", "Exp : 5yrs","Mobile No : 0123456789","500"},
                    {"Doctor Name : Yadnyesh Patil", "Hospital Address : Bandra", "Exp : 5yrs","Mobile No : 0321654987","800"},

            };
    private String[][]doctor_details2 =
            {
                    {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp : 8yrs", "Hobile No: 8898989898", "300"},
                    {"Doctor Name : Deepak Deshnukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Ashok Panda", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No: 7798989898", "800"},

            };
    private String[][]doctor_details3 =
            {
                    {"Doctor Name : Neelam Patil", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Swati Pawar", "Hospital Address : Nigdi", "Exp : 15yrs", "Hobile No: 7898989898", "900"},
                    {"Doctor Name : Neeraja Kale", "Hospitat Address : Pune", "Exp : 8yrs", "Hobile No:8898989898", "388"},
                    {"Doctor Name : Mayuri Deshnukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898000000", "508"},
                    {"Doctor Name : Minakshi Panda", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No:7798989898", "800"}

            };
    private String[][]doctor_details4 =
            {
                    {"Doctor Name : Seema Patil", "Hospital Address : Pimpri", "Exp : 4yrs", "Mobile No:9898989898", "200"},
                    {"Doctor Name : Pnkaj Parab", "Hospital Address : Nigdi", "Exp : 5yrs", "Mobile No:7898989898", "300"},
                    {"Doctor Name : Monish Jain", "Hospital Address : Pune", "Exp : 7yrs", "Mobile No:8898989898", "380"},
                    {"Doctor Name : Vishal Deshnukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Shrikant Panda", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No:7798989898", "600"}

            };
    private String[][]doctor_details5 =
            {
                    {"Doctor Name : Amol Gawade", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
                    {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No:7898989898", "900"},
                    {"Doctor Name : Nilesh Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898", "300"},
                    {"Doctor Name : Deepak Deshpande", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898000000", "500"},
                    {"Doctor Name : Ashok Singh", "Hospital Address : Katrai", "Exp : 7yrs", "Mobile No: 7798989898", "800"}

            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String>item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if (title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if (title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if (title.compareTo("Surgean")==0)
            doctor_details = doctor_details4;
        else {
            doctor_details = doctor_details5;
        }


            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));

            }
        });
            list = new ArrayList();
            for (int i=0;i<doctor_details.length;i++){
                item = new HashMap<String,String>();
                item.put("line1", doctor_details[i][0]);
                item.put("line2", doctor_details[i][1]);
                item.put("line3", doctor_details[i][2]);
                item.put("line4", doctor_details[i][3]);
                item.put("line5", "Cons Fees " +doctor_details[i][4]+"/-");
                list.add( item);
            }
            sa = new SimpleAdapter(this,list,
                    R.layout.multi_lines,
                    new String[]{"Line1,Line2,Line3,Line4,Line5,"},
                    new int []{R.id.Line_a,R.id.Line_b,R.id.Line_c,R.id.Line_d,R.id.Line_e}
            );
        ListView lst = findViewById(R.id.ListViewDD);
        lst.setAdapter(sa);
    }
}