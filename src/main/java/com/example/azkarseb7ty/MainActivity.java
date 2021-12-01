package com.example.azkarseb7ty;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtRes, txtFinalRes;
    int count = 0, foo = 0;
    String[] values = {"سبحان الله","الحمد لله","لا اله الا الله",
            "لا حول ولا قوة الا بالله","الله اكبر","سبحان الله العظيم وبحمده",
            "سبحان الله وبحمده","سبحان الله العظيم",
            "اللهم صلي علي محمد وعلي آل محمد وصحبه والتابعين له باحسان الي يوم الدين",
            "ربي اغفر لي","اللهم اصلح شأني","يلا ندعي لأولادنا","ما تيجوا نصلي ركعتين لله",
            "اوعي تنسوا تصلوا بالليل والناس نيام","وأذكر ربك اذا نسيت",
            "ادعيلي بالهدايه والزوجه الصالحه"};

    MyDataBase mdb;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRes = findViewById(R.id.txtRes);
        txtFinalRes = findViewById(R.id.final_result);

        mdb = new MyDataBase(this);
        db = mdb.getWritableDatabase();

    }

    @SuppressLint("SetTextI18n")
    public void onClickCount(View view) {
        if (count == 0){
            Toast.makeText(this, "أذكروا الله", Toast.LENGTH_SHORT).show();
        }
        //Count
        txtRes.setText(++count + "");
        txtFinalRes.setText(++foo + "");
        //db.execSQL("insert into data values (1,?);", new String[] {foo + ""});

        if (count % 33 == 0){
            count = 0;
            Toast.makeText(this, values[foo%15] + " 33 ", Toast.LENGTH_LONG).show();
        }

    }

    @SuppressLint("SetTextI18n")
    public void onClickMinus(View view) {
        if (count > 0)
            txtRes.setText(--count + "");
    }

    @SuppressLint("SetTextI18n")
    public void onClickReset(View view) {
        count = 0;
        txtRes.setText(count + "");
        Toast.makeText(this,
                "سوف نبدأ من جديد!!", // We will start from the first!!
                Toast.LENGTH_LONG).show();
    }
}
