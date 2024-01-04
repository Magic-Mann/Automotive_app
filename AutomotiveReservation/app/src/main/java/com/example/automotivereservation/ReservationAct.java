package com.example.automotivereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReservationAct extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editname,editType,editLocation,editDate;
    Button btnReserve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        myDb = new DatabaseHelper(this);

        editname = (EditText)findViewById(R.id.ename);
        editType = (EditText)findViewById(R.id.etype);
        editLocation = (EditText)findViewById(R.id.elocation);
        editDate = (EditText)findViewById(R.id.edate);
        btnReserve = (Button) findViewById(R.id.btnreserve);
        AddData();
    }

    public void AddData(){
        btnReserve = (Button) findViewById(R.id.btnreserve);
        btnReserve.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                String txtName = editname.getText().toString();
                String txtType = editType.getText().toString();
                String txtLocation = editLocation.getText().toString();
                String txtDate = editDate.getText().toString();

              boolean isInserted =  myDb.insertData(txtName,txtType,txtLocation,txtDate);
              if(isInserted =  true){
                  Toast.makeText(ReservationAct.this,"Data Inserted",Toast.LENGTH_LONG).show();
              }else{
                  Toast.makeText(ReservationAct.this,"Data not Inserted",Toast.LENGTH_LONG).show();
              }
            }
        });
    }

}