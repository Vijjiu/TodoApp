package vijji.codepath.android.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity===Vijji";
    EditText etEditItem;
    Button btnSave;
    int itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String textToEdit = getIntent().getStringExtra("textToEdit");
        itemPosition = getIntent().getIntExtra("position", 0);
        etEditItem = (EditText)findViewById(R.id.etEditItem);
        etEditItem.setText(textToEdit);

    }

    public void submtChanges(View v){

        EditText etText = (EditText) findViewById(R.id.etEditItem);
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("textEdited", etEditItem.getText().toString());
        data.putExtra("position", itemPosition); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent

    }
}
