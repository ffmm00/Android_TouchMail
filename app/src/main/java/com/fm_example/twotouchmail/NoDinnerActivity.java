package com.fm_example.twotouchmail;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class NoDinnerActivity extends ActionBarActivity implements View.OnClickListener,View.OnLongClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_dinner);

        Button btnSend=(Button)this.findViewById(R.id.button01);
        btnSend.setOnClickListener(this);
        btnSend.setOnLongClickListener(this);
    }

    public void onClick(View v){
        EditText edit01=(EditText)findViewById(R.id.editText);
        String title=edit01.getText().toString();
        Resources res =getResources();
        Uri uri=Uri.parse("mailto:" + res.getString(R.string.mail_to).toString());
        Intent intent=new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra(Intent.EXTRA_SUBJECT,title);
        intent.putExtra(Intent.EXTRA_TEXT,"遅くなるから飯要らない");
        startActivity(intent);
    }

    public boolean onLongClick(View v){
        EditText edit01=(EditText)findViewById(R.id.editText);
        String title=edit01.getText().toString();
        Resources res =getResources();
        Uri uri=Uri.parse("mailto:" + res.getString(R.string.mail_to).toString());
        Intent intent=new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra(Intent.EXTRA_SUBJECT,title);
        intent.putExtra(Intent.EXTRA_TEXT,"今日は遅くなるのでご飯はいりません");
        startActivity(intent);
        return true;}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_no_dinner, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
