package com.example.lab2a;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.lab2a.Weapon.PAPER;
import static com.example.lab2a.Weapon.ROCK;
import static com.example.lab2a.Weapon.SCISSORS;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView scoreCounter = (TextView) findViewById(R.id.scoreCounter);
        scoreCounter.setText("Player: 0, Computer: 0");
        TextView player = (TextView) findViewById(R.id.playerChoice);
        player.setText("Player's Weapon: ");
        TextView computer = (TextView) findViewById(R.id.comChoice);
        computer.setText("Computer's Weapon");
    }

    private Weapon playerWeapon;
    private Weapon comWeapon;
    int numChoices = 3;
    int comChoice;
    int playerScore = 0;
    int comScore = 0;
    Random rand = new Random();

    public void onClickRock(View V){
        playerWeapon = ROCK;
        comChoice = rand.nextInt(numChoices);

        if(comChoice == 0){
            comWeapon = ROCK;
        }
        else if(comChoice == 1){
            comWeapon = PAPER;
        }
        else if(comChoice == 2){
            comWeapon = SCISSORS;
        }


        if(comWeapon == ROCK){
            TextView winMessage = (TextView) findViewById(R.id.winMessage);
            TextView scoreCounter = (TextView) findViewById(R.id.scoreCounter);
            TextView player = (TextView) findViewById(R.id.playerChoice);
            TextView computer = (TextView) findViewById(R.id.comChoice);
            player.setText("Player's Weapon: " + ROCK.toString());
            computer.setText("Computer's Weapon: " + ROCK.toString());
            scoreCounter.setText("Player: " + playerScore +", Computer: " + comScore);
            winMessage.setText("The Match is a draw!");
        }
        else if(comWeapon == PAPER){
            ++comScore;
            TextView winMessage = (TextView) findViewById(R.id.winMessage);
            TextView scoreCounter = (TextView) findViewById(R.id.scoreCounter);
            TextView player = (TextView) findViewById(R.id.playerChoice);
            TextView computer = (TextView) findViewById(R.id.comChoice);
            player.setText("Player's Weapon: " + ROCK.toString());
            computer.setText("Computer's Weapon: " + PAPER.toString());
            scoreCounter.setText("Player: " + playerScore +", Computer: " + comScore);
            winMessage.setText("The Computer has won!");
        }
        else if(comWeapon == SCISSORS){
            ++playerScore;
            TextView winMessage = (TextView) findViewById(R.id.winMessage);
            TextView scoreCounter = (TextView) findViewById(R.id.scoreCounter);
            TextView player = (TextView) findViewById(R.id.playerChoice);
            TextView computer = (TextView) findViewById(R.id.comChoice);
            player.setText("Player's Weapon: " + ROCK.toString());
            computer.setText("Computer's Weapon: " + SCISSORS.toString());
            scoreCounter.setText("Player: " + playerScore +", Computer: " + comScore);
            winMessage.setText("The Player has won!");
        }
    }

    public void onClickPaper(View V){
        playerWeapon = PAPER;
    }

    public void onClickScissors(View V){
        playerWeapon = SCISSORS;
    }
}