package example.com;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.content.Intent;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    private String [] data = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Strawberry", "Cherry"};
    private EditText editText;
    private ImageView image_view;
    private ProgressBar progress_bar;
    private boolean img_flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  // 调用父类的构造函数
        setContentView(R.layout.first_layout);
        Button button1 = findViewById(R.id.button_1);
        button1.setOnClickListener(this);
        editText = findViewById(R.id.edit_text);
        image_view = findViewById(R.id.image_view);
        progress_bar = findViewById(R.id.progress_bar);
        img_flag = true;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_1:
                String input_text = editText.getText().toString();
                Toast.makeText(FirstActivity.this, input_text, Toast.LENGTH_SHORT).show();
                if(img_flag) {
                    image_view.setImageResource(R.drawable.img2);
                } else {
                    image_view.setImageResource(R.drawable.img2);
                }
                img_flag = !img_flag;
                if(progress_bar.getVisibility() == View.GONE)
                {
                    progress_bar.setVisibility(View.VISIBLE);
                }
                else
                {
                    progress_bar.setVisibility(View.GONE);
                }
                int progress = progress_bar.getProgress();
                progress = progress + 10;
                progress_bar.setProgress(progress);

                AlertDialog.Builder  dialog = new AlertDialog.Builder(FirstActivity.this);
                dialog.setTitle("This is dialog");
                dialog.setMessage("Something important");
                dialog.setCancelable(true);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("CANLLE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();

                break;
            default:
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {     // 给当前活动创建菜单
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {   // 定义菜单响应事件
        switch (item.getItemId()) {
            case R.id.shut_up:
                finish();
                break;
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK)
                {
                    String temp = data.getStringExtra("data_return");
                    Log.d("FirstActivity", temp);
                }
                break;
            default:
        }
    }
}
