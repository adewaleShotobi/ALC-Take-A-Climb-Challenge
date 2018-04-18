package ng.com.adewaleshotobi.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Adewale on 4/11/2018.
 * @version 1.0
 * @author Adewale Shotobi
 */

public class Message extends Activity {

    TextView message;
    Intent send;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);

        message = (TextView) findViewById(R.id.msg);
        Intent intent = getIntent();
        message.setText(intent.getStringExtra("message"));
    }

    public void playAgain(View view){
        send = new Intent(Message.this,Instructions.class);
        startActivity(send);
        finish();
    }

    public void Exit(View view){
        send = new Intent(Message.this,MainActivity.class);
        finish();
    }


}
