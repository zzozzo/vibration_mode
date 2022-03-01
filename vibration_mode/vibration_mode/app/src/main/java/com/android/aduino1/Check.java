package com.android.aduino1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Check extends AppCompatActivity {
    TextView className;
    Button button;
    long diff;
    long min;
    FirebaseDatabase database;
    String studentId;
    String email;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        //Intent intent = getIntent();
        email = MainActivity.id1;
        database = FirebaseDatabase.getInstance();
        studentId = email.substring(0,8);

        mDatabase = FirebaseDatabase.getInstance().getReference("출석부");

        className = findViewById(R.id.className);
        button = findViewById(R.id.button);

        SimpleDateFormat dFormatter = new SimpleDateFormat("yyyy/MM/dd", Locale.KOREA);
        Date currentDate = new Date();
        String date = dFormatter.format(currentDate);

        SimpleDateFormat tFormatter = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
        Date currentTime = new Date();
        String ctime = tFormatter.format(currentTime);

        className.setText(date + ClassName.CN + ctime );

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Toast.makeText(Check.this, studentId, Toast.LENGTH_SHORT).show();
            }
        });



        if (ClassName.CN.equals("시스템프로그래밍")){
            try {
                Date start = tFormatter.parse("9:00:00");
                Date now = tFormatter.parse(ctime);
                diff = now.getTime() - start.getTime();
                min = diff / 60000;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (min <= 5) {
                button.setVisibility(View.VISIBLE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDatabase.child("출석").setValue(studentId);
                        Toast.makeText(Check.this, "출석하셨습니다",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
            else if (min <= 30) {
                button.setText("지각");
                button.setVisibility(View.VISIBLE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDatabase.child("지각").setValue(studentId);
                        Toast.makeText(Check.this, "지각하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                });
            }
            else {
                button.setText("결석");
                button.setVisibility(View.VISIBLE);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDatabase.child("결석").setValue(studentId);
                        Toast.makeText(Check.this, "결석하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        } else if(ClassName.CN.equals("데이터보안실습")){
            try {
                Date start = tFormatter.parse("12:00:00");
                Date now = tFormatter.parse(ctime);
                diff = now.getTime() - start.getTime();
                min = diff / 60000;

            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (min <= 5) {
                button.setVisibility(View.VISIBLE);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDatabase.child("출석").setValue(studentId);
                        Toast.makeText(Check.this, "출석하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            else if (min <= 30) {
                button.setText("지각");
                button.setVisibility(View.VISIBLE);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDatabase.child("지각").setValue(studentId);
                        Toast.makeText(Check.this, "지각하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            else {
                button.setText("결석");
                button.setVisibility(View.VISIBLE);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDatabase.child("결석").setValue(studentId);
                        Toast.makeText(Check.this, "결석하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                });

            }



        } else if (ClassName.CN.equals("정보보안제품설계보안성평가")){
            try {
                Date start = tFormatter.parse("15:00:00");
                Date now = tFormatter.parse(ctime);
                diff = now.getTime() - start.getTime();
                min = diff / 60000;

            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (min <= 5) {
                button.setVisibility(View.VISIBLE);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDatabase.child("출석").setValue(studentId);
                        Toast.makeText(Check.this, "출석하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            else if (min <= 30) {
                button.setText("지각");
                button.setVisibility(View.VISIBLE);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDatabase.child("지각").setValue(studentId);
                        Toast.makeText(Check.this, "지각하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            else {
                button.setText("결석");
                button.setVisibility(View.VISIBLE);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mDatabase.child("결석").setValue(studentId);
                        Toast.makeText(Check.this, "결석하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }
    }
}
