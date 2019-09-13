package ca.bcit.intentmessenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_message);
    }

    public void onSendMessage(View view) {
        EditText messageView = (EditText) findViewById(R.id.message);
        String messageText = messageView.getText().toString();
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra("msg", messageText);
        startActivity(intent);
    }

    public void onSendMessageToOtherApp(View view) {
        EditText messageView = findViewById(R.id.message);
        String messageText = messageView.getText().toString();

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, messageText);
        startActivity(i);
    }

    public void onSendMessageToToast(View view) {
        EditText messageView = findViewById(R.id.message);
        String messageText = messageView.getText().toString();

        Toast toast = Toast.makeText(this, messageText, Toast.LENGTH_SHORT);
        toast.show();

    }
}
