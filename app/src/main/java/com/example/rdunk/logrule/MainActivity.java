package com.example.rdunk.logrule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int width_min = 6;
    public int width_max = 60;
    public int width_inc = 1;
    public int length_min = 6;
    public int length_max = 16;
    public int length_inc = 2;
    public boolean metric = false;
    public static boolean decimal = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createTable();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(this, PrefActivity.class);
        startActivity(i);
        return true;
    }



    private void createTable() {
        TableLayout tl = (TableLayout) findViewById(R.id.tl);
        tl.removeAllViews();
        TableRow.LayoutParams trlp = new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        trlp.weight = 1;
        for(int width = width_min;width<width_max;width += width_inc) {
            TableRow tr = new TableRow(this);
            TextView wtv = new TextView(this);
            wtv.setLayoutParams(trlp);
            wtv.setText(String.valueOf(width));
            tr.addView(wtv);
            for (int length = length_min; length < length_max; length += length_inc) {
                TextView x = new TextView(this);
                x.setLayoutParams(trlp);
                double bdft = Calculator.calc_doyle_bdft(width, length);
                if(decimal){
                    x.setText(String.valueOf(bdft));
                }
                else{
                    x.setText(String.valueOf(Math.round(bdft)));
                }
                tr.addView(x);
            }
            tl.addView(tr);
        }

        TableRow header = (TableRow) findViewById(R.id.header);
        TextView col_header = new TextView(this);
        col_header.setText(R.string.width);
        col_header.setLayoutParams(trlp);
        header.addView(col_header);
        for (int length = length_min; length < length_max; length += length_inc) {
            col_header = new TextView(this);
            col_header.setText(String.valueOf(length));
            col_header.setLayoutParams(trlp);
            header.addView(col_header);
        }
    }
}
