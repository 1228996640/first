package com.example.asus.app;

import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity implements Button.OnClickListener,AdapterView.OnItemLongClickListener {
    private Button btn;
    private EditText name,note;
    private Sqlite mySql;
    private SQLiteDatabase dbReader,dbWriter;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        btn = (Button) findViewById(R.id.save);
        name = (EditText) findViewById(R.id.ed_name);
        note = (EditText) findViewById(R.id.ed_note);

        mySql = new Sqlite(this);
        dbReader = mySql.getReadableDatabase();
        dbWriter = mySql.getWritableDatabase();

        adapter= new SimpleCursorAdapter(this,R.layout.shipei,null,new String[]{mySql.NAME,mySql.NOTE},new int[]{R.id.name,R.id.note});
        setListAdapter(adapter);
        getListView().setOnItemLongClickListener(this);
        btn.setOnClickListener(this);

        //ContentValues cv = new ContentValues();
        //cv.put("name","huyang");
        //cv.put("note","haoshuai");
        //dbWriter.insert(mySql.TABLE_NAME, null, cv);
        //select();
    }

    public void select(){
        Cursor cursor = dbReader.query(mySql.TABLE_NAME,null,null,null,null,null,null);

        adapter.changeCursor(cursor);
    }

   @Override

    public void onClick(View v) {
switch (v.getId()){
    case R.id.save:
        ContentValues cv = new ContentValues();
        cv.put(mySql.NAME,name.getText().toString());
        cv.put(mySql.NOTE,note.getText().toString());
        dbWriter.insert(mySql.TABLE_NAME, null, cv);
        select();
        break;
}
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }
}
