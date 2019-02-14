package com.example.ahalp.dicegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.animation.AnimationUtils;
import android.widget.ImageView; // Imports the ImageView class
import android.widget.TextView; // Imports the TextView class

import java.util.Random; // Imports the Random class

import android.view.animation.Animation; // Imports the classes for our animation "rotate" to work

/*
    import android.view.View imports the view class so we
    can create a new image view for each of the die when
    the player presses on their own die.

 */
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // This line creates the ImageView objects for player and computer dice images.
    ImageView iv_computer, iv_player;

    // This line creates the TextView objects for the texts.
    TextView tv_computer, tv_player, versus;

    // This line is for keeping score of the points for player and the computer.
    int computerPoints = 0, playerPoints = 0;

    Random r; // Creates the random "r" variable that will be used by both the player and computer.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sets the iv_computer variable in java equal to the ImageView tag in actitivy_main.xml that has the id iv_computer.
        iv_computer = (ImageView) findViewById(R.id.iv_computer);

        // Sets the iv_player variable in java equal to the ImageView tag in actitivy_main.xml that has the id iv_player.
        iv_player = (ImageView) findViewById(R.id.iv_player);

        // Sets the tv_computer variable in java equal to the TextView tag in actitivy_main.xml that has the id tv_computer.
        tv_computer = (TextView) findViewById(R.id.tv_computer);

        // Sets the tv_player variable in java equal to the TextView tag in actitivy_main.xml that has the id tv_player.
        tv_player = (TextView) findViewById(R.id.tv_player);

        // Sets the versus variable in java equal to the TextView tag in actitivy_main.xml that has the id versus.
        versus = (TextView) findViewById(R.id.versus);

        r = new Random(); // Offically intilializes the r random variable.

        /*
        Creates an action so that something will happen when the iv_player aka
        player's ImageView aka die image is clicked.Look up how events, actions
        and listeners are done in Java and this will make sense as to why the
        method/code is formatted the way it is.
     */
        iv_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Checks to see if the Versus's text equals "Computer Won!"
                if (versus.getText().equals("Computer Won!")) {

                    computerPoints = 0; // Resets computer's score aka game starts over

                    playerPoints = 0;    // Resets player's score aka game starts over

                }

                // Same as the above condition but with player instead of computer.
                if (versus.getText().equals("Player Won!")) {

                    computerPoints = 0; // Resets computer's score aka game starts over

                    playerPoints = 0;    // Resets player's score aka game starts over

                }


                /* This simulates when the computer throw's it's die the
                   die lands and generates a random face value from 1 to 6.
                */
                int computerThrow = r.nextInt(6) + 1;

                // Same as above with computerThrow only with the player.
                int playerThrow = r.nextInt(6) + 1;

                setImageComputer(computerThrow); // calls the method below

                setImagePlayer(playerThrow); // same as line above.

                /* Checks if the computer die is greater than the player's
                    in case it is the computer's score will be increased
                    by 1 and if the computer has 10 points it has won the
                    game and the text will be set to "Computer Won!"

                */
                if(playerThrow <  computerThrow){

                    computerPoints++; // increases score

                    if(computerPoints == 10){ // checks if computer won

                        versus.setText("Computer Won!");

                    }else{

                        versus.setText("VS"); // keeps the text the same.

                    }

                }
                // The same as above but this time with the player instead.
                if(playerThrow > computerThrow){

                    playerPoints++; // increases score

                    if(playerPoints == 10){ // checks if player won

                        versus.setText("Player Won!");

                    }else{

                        versus.setText("VS"); // keeps the text the same.

                    }

                }

                // Sets for text for computer after each "click" so that
                // it updates the score for both player and computer.
                tv_computer.setText("Computer: "+computerPoints);

                tv_player.setText("Player: "+playerPoints);

                // Line below creates the animation object. It's used so our dice can spin around.
                Animation rotate = AnimationUtils.loadAnimation(getApplicationContext() , R.anim.rotate);


                // Pass in that object so it can find the rotate.xml and know what to do next
                iv_computer.startAnimation(rotate);

                iv_player.startAnimation(rotate); // Same as line above but this time with the player's ImageView.
            }

        });
    }

    // Pulls a new die image for the computer depending on what number gets passed through the parameters.
    public void setImageComputer(int number) {

        // Checks what the number is and pulls up the corresponding image for it.
        switch (number) {

            case 1:
                iv_computer.setImageResource(R.drawable.die_one);
                break;

            case 2:
                iv_computer.setImageResource(R.drawable.die_two);
                break;

            case 3:
                iv_computer.setImageResource(R.drawable.die_three);
                break;

            case 4:
                iv_computer.setImageResource(R.drawable.die_four);
                break;

            case 5:
                iv_computer.setImageResource(R.drawable.die_five);
                break;

            case 6:
                iv_computer.setImageResource(R.drawable.die_six);
                break;
        }


    }

    // Exact same as with setImageComputer method above but this time with the player.
    public void setImagePlayer(int number) {

        switch (number) {

            case 1:
                iv_player.setImageResource(R.drawable.die_one);
                break;

            case 2:
                iv_player.setImageResource(R.drawable.die_two);
                break;

            case 3:
                iv_player.setImageResource(R.drawable.die_three);
                break;

            case 4:
                iv_player.setImageResource(R.drawable.die_four);
                break;

            case 5:
                iv_player.setImageResource(R.drawable.die_five);
                break;

            case 6:
                iv_player.setImageResource(R.drawable.die_six);
                break;

        }
    }
}
