package example.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ListViewAutoScrollHelper;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewTest extends AppCompatActivity {

    private String [] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Strawberry", "Cherry"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewTest.this, android.R.layout.simple_list_item_1, data);
        ListView  listView = (ListView) findViewById(R.id.activity_list_view_test);
        listView.setAdapter(adapter);
    }
}
