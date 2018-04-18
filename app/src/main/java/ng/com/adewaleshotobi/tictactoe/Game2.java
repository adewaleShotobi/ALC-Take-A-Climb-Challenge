package ng.com.adewaleshotobi.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Adewale on 4/11/2018.
 * @version 1.0
 * @author Adewale Shotobi
 */


public class Game2 extends Activity {

    Button[][] gameButtons = new Button[5][5];
    boolean isPlayer1Turn = true;
    int turns,rounds = 0;
    boolean isSinglePlayer;
    TextView player1, player2 , p1Score, p2Score;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game2);

        player1 = (TextView) findViewById(R.id.G2p1);
        player2 = (TextView) findViewById(R.id.G2p2);

        p1Score = (TextView) findViewById(R.id.G2s1);
        p2Score = (TextView) findViewById(R.id.G2s2);


        gameButtons[0][0] = (Button) findViewById(R.id.G_btn_00);
        gameButtons[0][1] = (Button) findViewById(R.id.G_btn_01);
        gameButtons[0][2] = (Button) findViewById(R.id.G_btn_02);
        gameButtons[0][3] = (Button) findViewById(R.id.G_btn_03);
        gameButtons[0][4] = (Button) findViewById(R.id.G_btn_04);
        gameButtons[1][0] = (Button) findViewById(R.id.G_btn_10);
        gameButtons[1][1] = (Button) findViewById(R.id.G_btn_11);
        gameButtons[1][2] = (Button) findViewById(R.id.G_btn_12);
        gameButtons[1][3] = (Button) findViewById(R.id.G_btn_13);
        gameButtons[1][4] = (Button) findViewById(R.id.G_btn_14);
        gameButtons[2][0] = (Button) findViewById(R.id.G_btn_20);
        gameButtons[2][1] = (Button) findViewById(R.id.G_btn_21);
        gameButtons[2][2] = (Button) findViewById(R.id.G_btn_22);
        gameButtons[2][3] = (Button) findViewById(R.id.G_btn_23);
        gameButtons[2][4] = (Button) findViewById(R.id.G_btn_24);
        gameButtons[3][0] = (Button) findViewById(R.id.G_btn_30);
        gameButtons[3][1] = (Button) findViewById(R.id.G_btn_31);
        gameButtons[3][2] = (Button) findViewById(R.id.G_btn_32);
        gameButtons[3][3] = (Button) findViewById(R.id.G_btn_33);
        gameButtons[3][4] = (Button) findViewById(R.id.G_btn_34);
        gameButtons[4][0] = (Button) findViewById(R.id.G_btn_40);
        gameButtons[4][1] = (Button) findViewById(R.id.G_btn_41);
        gameButtons[4][2] = (Button) findViewById(R.id.G_btn_42);
        gameButtons[4][3] = (Button) findViewById(R.id.G_btn_43);
        gameButtons[4][4] = (Button) findViewById(R.id.G_btn_44);

        //Get isSingle intent
        isSinglePlayer = getIntent().getExtras().getBoolean("isSingle");

        if (!isSinglePlayer){
            player2.setText("Player 2");
        }
    }

    public void doCheckOut(boolean isGameOver) {
        if (isGameOver){
            int sc = Integer.valueOf(String.valueOf(p1Score.getText()));
            int sc2 = Integer.valueOf(String.valueOf(p2Score.getText()));

            if (sc2 > sc){
                isPlayer1Turn = false;
                showMessage();
            }else if (sc2 < sc){
                isPlayer1Turn = true;
                showMessage();
            }else {
                Tie();
            }
        }else if(turns == 9){
            Toast.makeText(this,"No Winner this round",Toast.LENGTH_SHORT).show();
            reset();
            rounds++;
        }
        isPlayer1Turn = !isPlayer1Turn;
    }

    public void doClick2(View view){
        Button btn = (Button) view;
        if (!btn.isEnabled()) return;
        turns++;
        if (!isSinglePlayer){
            if (isPlayer1Turn){
                Utilities.setBtnToX(btn);
                if (checkForWin()) {
                    int score = Integer.parseInt(String.valueOf(p1Score.getText()));
                    score++;
                    p1Score.setText(String.valueOf(score));
                    rounds++;
                    reset();
                    Toast.makeText(this, "Player 1 wins", Toast.LENGTH_SHORT).show();
                    doCheckOut(Utilities.isGameOver(rounds));
                }else {
                    doCheckOut(Utilities.isGameOver(rounds));
                }
            }else {
                Utilities.setBtnToO(btn);
                if (checkForWin()){
                    int score = Integer.parseInt(String.valueOf(p2Score.getText()));
                    score ++;
                    p2Score.setText(String.valueOf(score));
                    rounds++;
                    Toast.makeText(this,"Player 2 wins",Toast.LENGTH_SHORT).show();
                    doCheckOut(Utilities.isGameOver(rounds));
                }else {
                    doCheckOut(Utilities.isGameOver(rounds));
                }
            }
        }

        //single player mode
        else {
            Utilities.setBtnToX(btn);
            if (checkForWin()){
                int score = Integer.parseInt(String.valueOf(p1Score.getText()));
                score ++;
                p1Score.setText(String.valueOf(score));
                rounds++;
                Toast.makeText(this,"You win",Toast.LENGTH_SHORT).show();
                doCheckOut(Utilities.isGameOver(rounds));
            }else {
                doCheckOut(Utilities.isGameOver(rounds));
                Utilities.RandomClick(25,gameButtons,5);
                if (checkForWin()){
                    int score = Integer.parseInt(String.valueOf(p2Score.getText()));
                    score ++;
                    p2Score.setText(String.valueOf(score));
                    rounds++;
                    Toast.makeText(this,"Computer Wins",Toast.LENGTH_SHORT).show();
                    doCheckOut(Utilities.isGameOver(rounds));
                }else{
                   doCheckOut(Utilities.isGameOver(rounds));
                }
            }
        }
    }

    public boolean checkForWin() {
        String[][] btnTexts = new String[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                btnTexts[i][j] = gameButtons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 5; i++) {
            if (btnTexts[i][0].equals(btnTexts[i][1])
                    && btnTexts[i][0].equals(btnTexts[i][2])
                    && btnTexts[i][0].equals(btnTexts[i][3])
                    && btnTexts[i][0].equals(btnTexts[i][4])
                    && !btnTexts[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (btnTexts[0][i].equals(btnTexts[1][i])
                    && btnTexts[0][i].equals(btnTexts[2][i])
                    && btnTexts[0][i].equals(btnTexts[3][i])
                    && btnTexts[0][i].equals(btnTexts[4][i])
                    && !btnTexts[0][i].equals("")) {
                return true;
            }
        }

        if (btnTexts[0][0].equals(btnTexts[1][1])
                && btnTexts[0][0].equals(btnTexts[2][2])
                && btnTexts[0][0].equals(btnTexts[3][3])
                && btnTexts[0][0].equals(btnTexts[4][4])
                && !btnTexts[0][0].equals("")) {
            return true;
        }

        if (btnTexts[0][4].equals(btnTexts[1][3])
                && btnTexts[0][4].equals(btnTexts[2][2])
                && btnTexts[0][4].equals(btnTexts[3][1])
                && btnTexts[0][4].equals(btnTexts[4][0])
                && !btnTexts[0][4].equals("")) {
            return true;
        }

        return false;
    }

    public void gameOver(){
        Intent intent = new Intent(Game2.this,Message.class);
        intent.putExtra("message","GAME OVER!");
        startActivity(intent);
        finish();
    }

    public void showMessage(){
        Intent intent;
        if (isSinglePlayer){
            if (isPlayer1Turn){
                intent = new Intent(Game2.this,Message.class);
                intent.putExtra("message","You Win!");
            }else {
                intent = new Intent(Game2.this,Message.class);
                intent.putExtra("message","Computer WINS!");
            }
            startActivity(intent);
            finish();
        }else {
            if (isPlayer1Turn){
                intent = new Intent(Game2.this,Message.class);
                intent.putExtra("message","Player 1 WINS!");
            }else {
                intent = new Intent(Game2.this,Message.class);
                intent.putExtra("message","Player 2 WINS!");
            }
            startActivity(intent);
            finish();
        }

    }


    public void reset(){
        for (int x = 0; x < 5; x++){
            for (int y = 0 ; y < 5; y++){
                gameButtons[x][y].setEnabled(true);
                gameButtons[x][y].setText("");
            }
        }
        turns = 0;
    }

    public void reset2(View view){
        reset();
    }



    public void Tie(){
        Intent intent = new Intent(Game2.this,Message.class);
        intent.putExtra("message","Game Ended with a Tie!");
        startActivity(intent);
        finish();
    }

}
