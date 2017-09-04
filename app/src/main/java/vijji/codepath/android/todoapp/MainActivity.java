package vijji.codepath.android.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE = 20;

    ArrayList<String> todoitems;
    ArrayAdapter<String> aTodoAdapter;
    ListView lv;
    EditText etEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateArrayItems();

        lv = (ListView)findViewById(R.id.lvitems);
        lv.setAdapter(aTodoAdapter);

        etEditText = (EditText)findViewById(R.id.etEditText);

        lv.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                todoitems.remove(position);
                aTodoAdapter.notifyDataSetChanged();
                writeItems();
                return true;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                String textToEdit = todoitems.get(position);

                Intent i = new Intent(MainActivity.this, EditItemActivity.class);

                i.putExtra("position",position);
                i.putExtra("textToEdit", textToEdit);

                startActivityForResult(i, REQUEST_CODE);
            }
        });
    }

    public void updateItem(String textEdited, int position){

        todoitems.set(position,textEdited);
        aTodoAdapter.notifyDataSetChanged();
        writeItems();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // REQUEST_CODE is defined above
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            // Extract textEdited value and position value from result extras
            String  textEdited= data.getExtras().getString("textEdited");
            int position = data.getExtras().getInt("position", 0);
            updateItem(textEdited, position);
        }
    }

    public void populateArrayItems(){
        readItems();
        aTodoAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,todoitems);

    }

    public void onAddItem(View view){
        aTodoAdapter.add(etEditText.getText().toString());
        etEditText.setText("");
        writeItems();
    }

    private void readItems(){
        File filesDir = getFilesDir();
        File file = new File(filesDir, "todo.txt");
        try{
            todoitems=new ArrayList<String>(FileUtils.readLines(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeItems(){
        File filesDir = getFilesDir();
        File file = new File(filesDir, "todo.txt");
        try{
            FileUtils.writeLines(file, todoitems);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
