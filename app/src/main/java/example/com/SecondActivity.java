package example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.util.Log;
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent = new Intent(Intent.ACTION_VIEW);
                                           intent.putExtra("data_return", "hello first");
                                           setResult(RESULT_OK, intent);
                                           finish();
                                       }
                                   }
        );
    }
}
