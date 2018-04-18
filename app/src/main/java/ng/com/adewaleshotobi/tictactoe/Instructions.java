package ng.com.adewaleshotobi.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by Adewale on 4/11/2018.
 * @version 1.0
 * @author Adewale Shotobi
 */

public class Instructions extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructions);
    }

    public void threeByThree(View view){
        Intent intent = new Intent(Instructions.this,Game.class);
        //get isSingle intent and forward to the next activity
        intent.putExtra("isSingle",getIntent().getExtras().getBoolean("isSingle"));
        startActivity(intent);
        finish();
    }

    public void fiveByFive(View view){
        Intent intent = new Intent(Instructions.this,Game2.class);
        //get isSingle intent and forward to the next activity
        intent.putExtra("isSingle",getIntent().getExtras().getBoolean("isSingle"));
        startActivity(intent);
        finish();
    }
}

