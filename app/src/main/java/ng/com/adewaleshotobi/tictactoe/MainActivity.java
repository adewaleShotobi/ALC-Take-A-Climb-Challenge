package ng.com.adewaleshotobi.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Adewale on 4/11/2018.
 * @version 1.0
 * @author Adewale Shotobi
 */

public class MainActivity extends AppCompatActivity {

    Intent intent;
    //used to track Single/Double Player mode
    boolean isSingle = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(MainActivity.this,Instructions.class);
    }

    public void singleToInstructions(View view){
        //send isSingle to the next activity
        intent.putExtra("isSingle",isSingle);
        startActivity(intent);
    }

    public void doubleToInstructions(View view){
        //send isSingle to the next activity
        intent.putExtra("isSingle",!isSingle);
        startActivity(intent);
    }
}
