package com.example.ludogame;

import java.util.Currency;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.*;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Toast;

public class DashboardActivity extends Activity {
	private Button yellowPlayer1Button;
	private Button yellowPlayer2Button;
	private Button yellowPlayer3Button;
	private Button yellowPlayer4Button;
	private Button redPlayer1Button;
	private Button redPlayer2Button;
	private Button redPlayer3Button;
	private Button redPlayer4Button;
	private Button greenPlayer1Button;
	private Button greenPlayer2Button;
	private Button greenPlayer3Button;
	private Button greenPlayer4Button;
	private Button bluePlayer1Button;
	private Button bluePlayer2Button;
	private Button bluePlayer3Button;
	private Button bluePlayer4Button;

	// animation
	private Animation translateAnimation;

	// used to store position of players in array;
	private int yellowPlayersPath[];
	private int greenPlayersPath[];
	private int redPlayersPath[];
	private int bluePlayersPath[];
	private int yellowPlayersWinnerToken = 0;
	private int bluePlayersWinnerToken = 0;
	private int redPlayersWinnerToken = 0;
	private int greenPlayersWinnerToken = 0;
	// actual x y co ordinate to show position
	private float playerPosition[][];
	private int playerCommonPath[];
	private float yellowPlayerHomePositionPath[][];
	private float greenPlayerHomePositionPath[][];
	private float bluePlayerHomePositionPath[][];
	private float redPlayerHomePositionPath[][];

	private Button diceButton;

	private int playerTurn;
	private static int activePlayer;
	private static String[] activePlayerList;
	private static final int TOTAL_STEPS = 97;// 58
	private static final int YELLOW_HOME_START = 52;
	private static final int YELLOW_HOME_END = 57;
	private static final int BLUE_HOME_START = 65;
	private static final int BLUE_HOME_END = 70;
	private static final int RED_HOME_START = 78;
	private static final int RED_HOME_END = 83;
	private static final int GREEN_HOME_START = 91;
	private static final int GREEN_HOME_END = 96;

	private static final int YELLOW_VARIATION = 0;
	private static final int BLUE_VARIATION = 13;
	private static final int RED_VARIATION = 26;
	private static final int GREEN_VARIATION = 39;

	private static final int YELLOW1_ORIGIN_X = 495;
	private static final int YELLOW1_ORIGIN_Y = 142;
	private static final int YELLOW2_ORIGIN_X = 582;
	private static final int YELLOW2_ORIGIN_Y = 142;
	private static final int YELLOW3_ORIGIN_X = 495;
	private static final int YELLOW3_ORIGIN_Y = 252;
	private static final int YELLOW4_ORIGIN_X = 582;
	private static final int YELLOW4_ORIGIN_Y = 252;
	private static final int BLUE1_ORIGIN_X = 495;
	private static final int BLUE1_ORIGIN_Y = 726;
	private static final int BLUE2_ORIGIN_X = 582;
	private static final int BLUE2_ORIGIN_Y = 726;
	private static final int BLUE3_ORIGIN_X = 495;
	private static final int BLUE3_ORIGIN_Y = 836;
	private static final int BLUE4_ORIGIN_X = 582;
	private static final int BLUE4_ORIGIN_Y = 836;
	private static final int RED1_ORIGIN_X = 90;
	private static final int RED1_ORIGIN_Y = 726;
	private static final int RED2_ORIGIN_X = 177;
	private static final int RED2_ORIGIN_Y = 726;
	private static final int RED3_ORIGIN_X = 726;
	private static final int RED3_ORIGIN_Y = 836;
	private static final int RED4_ORIGIN_X = 177;
	private static final int RED4_ORIGIN_Y = 836;
	private static final int GREEN1_ORIGIN_X = 90;
	private static final int GREEN1_ORIGIN_Y = 142;
	private static final int GREEN2_ORIGIN_X = 177;
	private static final int GREEN2_ORIGIN_Y = 142;
	private static final int GREEN3_ORIGIN_X = 90;
	private static final int GREEN3_ORIGIN_Y = 252;
	private static final int GREEN4_ORIGIN_X = 177;
	private static final int GREEN4_ORIGIN_Y = 252;

	private static final int YELLOW_TEAM = 100;
	private static final int BLUE_TEAM = 200;
	private static final int RED_TEAM = 300;
	private static final int GREEN_TEAM = 400;

	private static final int YELLOW_PLAYER_1 = 1;
	private static final int YELLOW_PLAYER_2 = 2;
	private static final int YELLOW_PLAYER_3 = 3;
	private static final int YELLOW_PLAYER_4 = 4;
	private static final int BLUE_PLAYER_1 = 5;
	private static final int BLUE_PLAYER_2 = 6;
	private static final int BLUE_PLAYER_3 = 7;
	private static final int BLUE_PLAYER_4 = 8;
	private static final int RED_PLAYER_1 = 9;
	private static final int RED_PLAYER_2 = 10;
	private static final int RED_PLAYER_3 = 11;
	private static final int RED_PLAYER_4 = 12;
	private static final int GREEN_PLAYER_1 = 13;
	private static final int GREEN_PLAYER_2 = 14;
	private static final int GREEN_PLAYER_3 = 15;
	private static final int GREEN_PLAYER_4 = 16;
	private static String yellowPlayerName;
	private static String bluePlayerName;
	private static String redPlayerName;
	private static String greenPlayerName;

	private static boolean yellowPlayerActive = true;
	private static boolean bluePlayerActive = true;
	private static boolean redPlayerActive = true;
	private static boolean greenPlayerActive = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);

		// set position of all players
		setupPlayers();

	}

	public void setupPlayers() {

		// initializing players

		yellowPlayer1Button = (Button) findViewById(R.id.yellowPlayer1Button);
		yellowPlayer2Button = (Button) findViewById(R.id.yellowPlayer2Button);
		yellowPlayer3Button = (Button) findViewById(R.id.yellowPlayer3Button);
		yellowPlayer4Button = (Button) findViewById(R.id.yellowPlayer4Button);
		redPlayer1Button = (Button) findViewById(R.id.redPlayer1Button);
		redPlayer2Button = (Button) findViewById(R.id.redPlayer2Button);
		redPlayer3Button = (Button) findViewById(R.id.redPlayer3Button);
		redPlayer4Button = (Button) findViewById(R.id.redPlayer4Button);
		greenPlayer1Button = (Button) findViewById(R.id.greenPlayer1Button);
		greenPlayer2Button = (Button) findViewById(R.id.greenPlayer2Button);
		greenPlayer3Button = (Button) findViewById(R.id.greenPlayer3Button);
		greenPlayer4Button = (Button) findViewById(R.id.greenPlayer4Button);
		bluePlayer1Button = (Button) findViewById(R.id.bluePlayer1Button);
		bluePlayer2Button = (Button) findViewById(R.id.bluePlayer2Button);
		bluePlayer3Button = (Button) findViewById(R.id.bluePlayer3Button);
		bluePlayer4Button = (Button) findViewById(R.id.bluePlayer4Button);

		yellowPlayersPath = new int[TOTAL_STEPS];
		bluePlayersPath = new int[TOTAL_STEPS];
		redPlayersPath = new int[TOTAL_STEPS];
		greenPlayersPath = new int[TOTAL_STEPS];
		playerCommonPath = new int[52];

		// receiving active players and setting player on dashboard

		Bundle bundle = this.getIntent().getExtras();
		activePlayerList = bundle.getStringArray("playerList");

		yellowPlayerName = activePlayerList[0];
		bluePlayerName = activePlayerList[1];
		redPlayerName = activePlayerList[2];
		greenPlayerName = activePlayerList[3];

		if (yellowPlayerName.equals("None")) {
			// Toast.makeText(getApplicationContext(), "yellow disbaled",
			// Toast.LENGTH_SHORT).show();
			yellowPlayerActive = false;
			yellowPlayer1Button.setVisibility(View.GONE);
			yellowPlayer2Button.setVisibility(View.GONE);
			yellowPlayer3Button.setVisibility(View.GONE);
			yellowPlayer4Button.setVisibility(View.GONE);
		}

		if (bluePlayerName.equals("None")) {
			bluePlayerActive = false;
			bluePlayer1Button.setVisibility(View.GONE);
			bluePlayer2Button.setVisibility(View.GONE);
			bluePlayer3Button.setVisibility(View.GONE);
			bluePlayer4Button.setVisibility(View.GONE);
		}

		if (redPlayerName.equals("None")) {
			redPlayerActive = false;
			redPlayer1Button.setVisibility(View.GONE);
			redPlayer2Button.setVisibility(View.GONE);
			redPlayer3Button.setVisibility(View.GONE);
			redPlayer4Button.setVisibility(View.GONE);
		}
		if (greenPlayerName.equals("None")) {
			greenPlayerActive = false;
			greenPlayer1Button.setVisibility(View.GONE);
			greenPlayer2Button.setVisibility(View.GONE);
			greenPlayer3Button.setVisibility(View.GONE);
			greenPlayer4Button.setVisibility(View.GONE);
		}

		// gap 65 vertically
		// gap 45 horizon
		playerPosition = new float[][] { { 381, 38 }, { 381, 103 }, { 381, 168 }, { 381, 233 },
				{ 381, 298 },
				{ 381, 363 },// 6
				{ 426, 428 }, { 471, 428 }, { 516, 428 }, { 561, 428 }, { 606, 428 }, { 651, 428 },
				{ 651, 493 },// 13
				{ 651, 558 }, { 606, 558 }, { 561, 558 }, { 516, 558 }, { 471, 558 },
				{ 426, 558 },// 19
				{ 381, 623 }, { 381, 688 }, { 381, 753 }, { 381, 758 }, { 381, 818 }, { 381, 883 }, { 381, 883 },
				{ 381, 948 },// 27
				{ 336, 948 }, { 291, 948 }, { 291, 883 }, { 291, 818 }, { 291, 753 }, { 291, 688 }, { 291, 623 },// 34
				{ 246, 558 }, { 201, 558 }, { 156, 558 }, { 111, 558 }, { 66, 558 }, { 21, 558 },// 40
				{ 21, 493 }, { 21, 428 }, { 66, 428 }, { 111, 428 }, { 156, 428 }, { 201, 428 }, { 246, 428 },// 47
				{ 291, 363 }, { 291, 298 }, { 291, 233 }, { 291, 168 }, { 291, 103 }, { 291, 38 }, { 336, 38 } };// 54

		yellowPlayerHomePositionPath = new float[][] { { 336, 103 }, { 336, 168 }, { 336, 233 }, { 336, 298 },
				{ 336, 363 }, { 336, 428 } };
		bluePlayerHomePositionPath = new float[][] { { 606, 493 }, { 561, 493 }, { 516, 493 }, { 471, 493 },
				{ 426, 493 }, { 381, 493 } };
		greenPlayerHomePositionPath = new float[][] { { 66, 493 }, { 111, 493 }, { 156, 493 }, { 201, 493 },
				{ 246, 493 }, { 291, 493 } };
		redPlayerHomePositionPath = new float[][] { { 336, 883 }, { 336, 818 }, { 336, 753 }, { 336, 688 },
				{ 336, 623 },
				{ 336, 558 },// additional
				{ 381, 38 }, { 381, 103 }, { 381, 168 }, { 381, 233 }, { 381, 298 },
				{ 381, 363 },// 6
				{ 426, 428 }, { 471, 428 }, { 516, 428 }, { 561, 428 }, { 606, 428 }, { 651, 428 },
				{ 651, 493 },// 13
				{ 651, 558 }, { 606, 558 }, { 561, 558 }, { 516, 558 }, { 471, 558 },
				{ 426, 558 },// 19
				{ 381, 623 }, { 381, 688 }, { 381, 753 }, { 381, 758 }, { 381, 818 }, { 381, 883 }, { 381, 883 },
				{ 381, 948 },// 27
				{ 336, 948 }, { 291, 948 }, { 291, 883 }, { 291, 818 }, { 291, 753 }, { 291, 688 }, { 291, 623 },// 34
				{ 246, 558 }, { 201, 558 }, { 156, 558 }, { 111, 558 }, { 66, 558 } };

		if (yellowPlayerActive == true) {
			activePlayer = YELLOW_TEAM;
		} else if (bluePlayerActive == true) {
			activePlayer = BLUE_TEAM;
		} else if (redPlayerActive == true) {
			activePlayer = RED_TEAM;
		} else if (greenPlayerActive == true) {
			activePlayer = GREEN_TEAM;
		}

		setPlayerTurn(activePlayer);

	}

	public void setPlayerTurn(int activePlayer) {
		// initializing data
		// Toast.makeText(getApplicationContext(), "Its " + activePlayer +
		// " 's turn", Toast.LENGTH_SHORT).show();
		if (activePlayer == YELLOW_TEAM) {

			yellowPlayer1Button.setEnabled(true);
			yellowPlayer2Button.setEnabled(true);
			yellowPlayer3Button.setEnabled(true);
			yellowPlayer4Button.setEnabled(true);
			yellowPlayer1Button.setText("X");
			yellowPlayer2Button.setText("X");
			yellowPlayer3Button.setText("X");
			yellowPlayer4Button.setText("X");

		}

		else if (activePlayer == BLUE_TEAM) {

			bluePlayer1Button.setEnabled(true);
			bluePlayer2Button.setEnabled(true);
			bluePlayer3Button.setEnabled(true);
			bluePlayer4Button.setEnabled(true);
			bluePlayer1Button.setText("X");
			bluePlayer2Button.setText("X");
			bluePlayer3Button.setText("X");
			bluePlayer4Button.setText("X");

		} else if (activePlayer == RED_TEAM) {

			redPlayer1Button.setEnabled(true);
			redPlayer2Button.setEnabled(true);
			redPlayer3Button.setEnabled(true);
			redPlayer4Button.setEnabled(true);
			redPlayer1Button.setText("X");
			redPlayer2Button.setText("X");
			redPlayer3Button.setText("X");
			redPlayer4Button.setText("X");

		} else {

			greenPlayer1Button.setEnabled(true);
			greenPlayer2Button.setEnabled(true);
			greenPlayer3Button.setEnabled(true);
			greenPlayer4Button.setEnabled(true);
			greenPlayer1Button.setText("X");
			greenPlayer2Button.setText("X");
			greenPlayer3Button.setText("X");
			greenPlayer4Button.setText("X");

		}
		throwDice(activePlayer);

	}

	public void throwDice(final int player) {

		diceButton = (Button) findViewById(R.id.diceButton);
		diceButton.setEnabled(true);
		// Toast.makeText(getApplicationContext(), "dice enabled to throw",
		// Toast.LENGTH_SHORT).show();
		diceButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Random random = new Random();
				int diceNumber = (random.nextInt(6) + 1);

				switch (diceNumber) {
				case 1:
					diceButton.setBackgroundResource(R.drawable.face1);
					break;

				case 2:
					diceButton.setBackgroundResource(R.drawable.face2);
					break;
				case 3:
					diceButton.setBackgroundResource(R.drawable.face3);
					break;
				case 4:
					diceButton.setBackgroundResource(R.drawable.face4);
					break;
				case 5:
					diceButton.setBackgroundResource(R.drawable.face5);
					break;
				case 6:
					diceButton.setBackgroundResource(R.drawable.face6);
					break;
				default:
					break;
				}
				// Toast.makeText(getBaseContext(), "Dice Clicked",
				// Toast.LENGTH_SHORT).show();
				diceButton.setEnabled(false);
				// Toast.makeText(getBaseContext(), "start moving player :" +
				// player, Toast.LENGTH_SHORT).show();
				movePlayer(diceNumber, player);

			}
		});

	}

	/*
	 * move token of specific player
	 */
	public void movePlayer(final int diceNumber, int player) {
		// setting click listener of tokens

		
		
		if (player == YELLOW_TEAM) {
			if (checkInitPosition(YELLOW_TEAM,YELLOW_PLAYER_1) == false && checkInitPosition(YELLOW_TEAM,YELLOW_PLAYER_2) == false && checkInitPosition(YELLOW_TEAM,YELLOW_PLAYER_3) == false && checkInitPosition(YELLOW_TEAM,YELLOW_PLAYER_4) == false )
			{
				if (diceNumber != 6)
				{
					Toast.makeText(getApplicationContext(), "You can  not move your token until you get 6 ",
							Toast.LENGTH_SHORT).show();
					
					finishPlayerTurn(YELLOW_TEAM);
					//Toast.makeText(getApplicationContext(), "next turn started for"+activePlayer, Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			}
			

			
			yellowPlayer1Button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					
					if (checkInitPosition(YELLOW_TEAM,YELLOW_PLAYER_1) == false)
					{
						if (diceNumber == 6)
						{

							 setInitPosition(YELLOW_TEAM, YELLOW_PLAYER_1);

						} 
						else
						{
							Toast.makeText(getApplicationContext(), "You can not move token until you get 6.",
									Toast.LENGTH_SHORT).show();
						}
						
						
					} else 
					{
						int oldPosition = getCurrentPosition(YELLOW_TEAM,YELLOW_PLAYER_1);
						int currentPosition = oldPosition + diceNumber;
						
						if((currentPosition- YELLOW_HOME_END)>=0)
						{
							currentPosition=oldPosition;
						}
						
						if(currentPosition>=YELLOW_HOME_START)
						{
							
							yellowPlayer1Button.setX(yellowPlayerHomePositionPath[currentPosition-YELLOW_HOME_START][0]);
							yellowPlayer1Button.setY(yellowPlayerHomePositionPath[currentPosition-YELLOW_HOME_START][1]);
							
						}
						else
						{
							//check for existing position
							removeOpponent(YELLOW_TEAM,currentPosition);
							yellowPlayer1Button.setX(playerPosition[currentPosition+YELLOW_VARIATION+1][0]);
							yellowPlayer1Button.setY(playerPosition[currentPosition+YELLOW_VARIATION+1][1]);
														
						}
						
						if(checkWonGame(YELLOW_TEAM)== true)
						{
							Toast.makeText(getApplicationContext(), yellowPlayerName+" won the game.", Toast.LENGTH_LONG).show();
						}
						
						
												
						yellowPlayersPath[oldPosition] = 0;
						yellowPlayersPath[currentPosition] = YELLOW_PLAYER_1;

						
					}
					//finish player turn and disable tokens
					finishPlayerTurn(YELLOW_TEAM);
					//Toast.makeText(getApplicationContext(), "next turn started..", Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			});

			// second yellow player

			yellowPlayer2Button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					
					if (checkInitPosition(YELLOW_TEAM,YELLOW_PLAYER_2) == false)
					{
						if (diceNumber == 6)
						{

							 setInitPosition(YELLOW_TEAM, YELLOW_PLAYER_2);

						} 
						else
						{
							Toast.makeText(getApplicationContext(), "You can not move token until you get 6.",
									Toast.LENGTH_SHORT).show();
						}
						
						
					} else 
					{
						int oldPosition = getCurrentPosition(YELLOW_TEAM,YELLOW_PLAYER_2);
						int currentPosition = oldPosition + diceNumber;
						
						if((currentPosition- YELLOW_HOME_END)>=0)
						{
							currentPosition=oldPosition;
						}
						
						if(currentPosition>=YELLOW_HOME_START)
						{
							
							yellowPlayer2Button.setX(yellowPlayerHomePositionPath[currentPosition-YELLOW_HOME_START][0]);
							yellowPlayer2Button.setY(yellowPlayerHomePositionPath[currentPosition-YELLOW_HOME_START][1]);
							
						}
						else
						{
							//check for existing position
							removeOpponent(YELLOW_TEAM,currentPosition+YELLOW_VARIATION);
							playerCommonPath[currentPosition+YELLOW_VARIATION]=1;
							yellowPlayer2Button.setX(playerPosition[currentPosition+YELLOW_VARIATION+1][0]);
							yellowPlayer2Button.setY(playerPosition[currentPosition+YELLOW_VARIATION+1][1]);
														
						}
						
						if(checkWonGame(YELLOW_TEAM)== true)
						{
							Toast.makeText(getApplicationContext(), yellowPlayerName+" won the game.", Toast.LENGTH_LONG).show();
						}
						
												
						yellowPlayersPath[oldPosition] = 0;
						yellowPlayersPath[currentPosition] = YELLOW_PLAYER_2;

						
					}
					//finish player turn and disable tokens
					finishPlayerTurn(YELLOW_TEAM);
					//Toast.makeText(getApplicationContext(), "next turn started..", Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			});
			// third yellow player

			yellowPlayer3Button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					if (checkInitPosition(YELLOW_TEAM,YELLOW_PLAYER_3) == false )
					{
						if (diceNumber == 6)
						{

							setInitPosition(YELLOW_TEAM, YELLOW_PLAYER_3);

						} 
						else
						{
							Toast.makeText(getApplicationContext(), "You can not move token until you get 6.",
									Toast.LENGTH_SHORT).show();
						}
					} else {
						int oldPosition = getCurrentPosition(YELLOW_TEAM,YELLOW_PLAYER_3);
						int currentPosition = oldPosition + diceNumber;
						
						if((currentPosition- YELLOW_HOME_END)>=0)
						{
							currentPosition=oldPosition;
						}
						if(currentPosition>=YELLOW_HOME_START)
						{
							
							yellowPlayer3Button.setX(yellowPlayerHomePositionPath[currentPosition-YELLOW_HOME_START][0]);
							yellowPlayer3Button.setY(yellowPlayerHomePositionPath[currentPosition-YELLOW_HOME_START][1]);
							
						}
						else
						{
							removeOpponent(YELLOW_TEAM,currentPosition);
							yellowPlayer3Button.setX(playerPosition[currentPosition+YELLOW_VARIATION+1][0]);
							yellowPlayer3Button.setY(playerPosition[currentPosition+YELLOW_VARIATION+1][1]);
														
						}
						//removeOpponent(YELLOW_TEAM,currentPosition);
						if(checkWonGame(YELLOW_TEAM)== true)
						{
							Toast.makeText(getApplicationContext(), yellowPlayerName+" won the game.", Toast.LENGTH_LONG).show();
						}
						
												
						yellowPlayersPath[oldPosition] = 0;
						yellowPlayersPath[currentPosition] = YELLOW_PLAYER_3;

						
					}
					//finish player turn and disable tokens
					finishPlayerTurn(YELLOW_TEAM);
					//Toast.makeText(getApplicationContext(), "next turn started..", Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			});
			// forth yellow player

			yellowPlayer4Button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					if (checkInitPosition(YELLOW_TEAM,YELLOW_PLAYER_4) == false )
					{
						if (diceNumber == 6)
						{

							setInitPosition(YELLOW_TEAM, YELLOW_PLAYER_4);

						} 
						else
						{
							Toast.makeText(getApplicationContext(), "You can not move token until you get 6.",
									Toast.LENGTH_SHORT).show();
						}
					} else {
						
						Toast.makeText(getApplicationContext(), "current posi.start", 	Toast.LENGTH_SHORT).show();
						int oldPosition = getCurrentPosition(YELLOW_TEAM,YELLOW_PLAYER_4);
						
						int currentPosition = oldPosition + diceNumber;
						
						
					
						if((currentPosition- YELLOW_HOME_END)>=0)
						{
							currentPosition=oldPosition;
						}
						if(currentPosition>=YELLOW_HOME_START)
						{
							
							yellowPlayer4Button.setX(yellowPlayerHomePositionPath[currentPosition-YELLOW_HOME_START][0]);
							yellowPlayer4Button.setY(yellowPlayerHomePositionPath[currentPosition-YELLOW_HOME_START][1]);
							
						}
						else
						{
							removeOpponent(YELLOW_TEAM,currentPosition+YELLOW_VARIATION);
							yellowPlayer4Button.setX(playerPosition[currentPosition+YELLOW_VARIATION+1][0]);
							yellowPlayer4Button.setY(playerPosition[currentPosition+YELLOW_VARIATION+1][1]);
														
						}
						removeOpponent(YELLOW_TEAM,currentPosition);
						if(checkWonGame(YELLOW_TEAM)== true)
						{
							Toast.makeText(getApplicationContext(), yellowPlayerName+" won the game.", Toast.LENGTH_LONG).show();
						}
						
												
						yellowPlayersPath[oldPosition] = 0;
						yellowPlayersPath[currentPosition] = YELLOW_PLAYER_4;

						
					}
					//finish player turn and disable tokens
					finishPlayerTurn(YELLOW_TEAM);
					Toast.makeText(getApplicationContext(), "next turn started..", Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			});
		}

		// setting evnt for blue token

		else if (player == BLUE_TEAM) {
			if (checkInitPosition(BLUE_TEAM,BLUE_PLAYER_1) == false && checkInitPosition(BLUE_TEAM,BLUE_PLAYER_2) == false && checkInitPosition(BLUE_TEAM,BLUE_PLAYER_3) == false && checkInitPosition(BLUE_TEAM,BLUE_PLAYER_4) == false )
			{
				if (diceNumber != 6)
				{
					Toast.makeText(getApplicationContext(), "You can  not move your token until you get 6 ",
							Toast.LENGTH_SHORT).show();
					
					finishPlayerTurn(BLUE_TEAM);
					//Toast.makeText(getApplicationContext(), "next turn started for"+activePlayer, Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			}
			

			
			bluePlayer1Button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					
					if (checkInitPosition(BLUE_TEAM,BLUE_PLAYER_1) == false)
					{
						if (diceNumber == 6)
						{

							 setInitPosition(BLUE_TEAM, BLUE_PLAYER_1);

						} 
						else
						{
							Toast.makeText(getApplicationContext(), "You can not move token until you get 6.",
									Toast.LENGTH_SHORT).show();
						}
						
						
					} else 
					{
						int oldPosition = getCurrentPosition(BLUE_TEAM,BLUE_PLAYER_1);
						int currentPosition = oldPosition + diceNumber;
						Toast.makeText(getApplicationContext(), "cur pos:"+currentPosition, Toast.LENGTH_SHORT).show();
						if((currentPosition- BLUE_HOME_END)>=0)
						{
							currentPosition=oldPosition;
						}
						
						if(currentPosition>=BLUE_HOME_START)
						{
							
							bluePlayer1Button.setX(bluePlayerHomePositionPath[currentPosition-BLUE_HOME_START][0]);
							bluePlayer1Button.setY(bluePlayerHomePositionPath[currentPosition-BLUE_HOME_START][1]);
							
						}
						else
						{
							removeOpponent(BLUE_TEAM, currentPosition);
							bluePlayer1Button.setX(playerPosition[currentPosition+BLUE_VARIATION+1][0]);
							bluePlayer1Button.setY(playerPosition[currentPosition+BLUE_VARIATION+1][1]);
														
						}
						
						if(checkWonGame(BLUE_TEAM)== true)
						{
							Toast.makeText(getApplicationContext(), bluePlayerName+" won the game.", Toast.LENGTH_LONG).show();
						}
						
						//Log.d("blue", "current pos:"+currentPosition);						
						bluePlayersPath[oldPosition] = 0;
						bluePlayersPath[currentPosition] = BLUE_PLAYER_1;

						
					}
					//finish player turn and disable tokens
					finishPlayerTurn(BLUE_TEAM);
					//Toast.makeText(getApplicationContext(), "next turn started..", Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			});

			// second blue player

			bluePlayer2Button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					
					if (checkInitPosition(BLUE_TEAM,BLUE_PLAYER_2) == false)
					{
						if (diceNumber == 6)
						{

							 setInitPosition(BLUE_TEAM, BLUE_PLAYER_2);

						} 
						else
						{
							Toast.makeText(getApplicationContext(), "You can not move token until you get 6.",
									Toast.LENGTH_SHORT).show();
						}
						
						
					} else 
					{
						int oldPosition = getCurrentPosition(BLUE_TEAM,BLUE_PLAYER_2);
						int currentPosition = oldPosition + diceNumber;
						
						if((currentPosition- BLUE_HOME_END)>=0)
						{
							currentPosition=oldPosition;
						}
						
						if(currentPosition>=BLUE_HOME_START)
						{
							
							bluePlayer2Button.setX(bluePlayerHomePositionPath[currentPosition-BLUE_HOME_START][0]);
							bluePlayer2Button.setY(bluePlayerHomePositionPath[currentPosition-BLUE_HOME_START][1]);
							
						}
						else
						{
							//check for existing position
							removeOpponent(BLUE_TEAM,currentPosition);
							//playerCommonPath[oldPosition+BLUE_VARIATION]=0;
						//	playerCommonPath[currentPosition+BLUE_VARIATION]=1;
							bluePlayer2Button.setX(playerPosition[currentPosition+BLUE_VARIATION+1][0]);
							bluePlayer2Button.setY(playerPosition[currentPosition+BLUE_VARIATION+1][1]);
														
						}
						
						if(checkWonGame(BLUE_TEAM)== true)
						{
							Toast.makeText(getApplicationContext(), bluePlayerName+" won the game.", Toast.LENGTH_LONG).show();
						}
						
												
						bluePlayersPath[oldPosition] = 0;
						bluePlayersPath[currentPosition] = BLUE_PLAYER_2;

						
					}
					//finish player turn and disable tokens
					finishPlayerTurn(BLUE_TEAM);
					//Toast.makeText(getApplicationContext(), "next turn started..", Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			});
			// third blue player

			bluePlayer3Button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					if (checkInitPosition(BLUE_TEAM,BLUE_PLAYER_3) == false )
					{
						if (diceNumber == 6)
						{

							setInitPosition(BLUE_TEAM, BLUE_PLAYER_3);

						} 
						else
						{
							Toast.makeText(getApplicationContext(), "You can not move token until you get 6.",
									Toast.LENGTH_SHORT).show();
						}
					} else {
						int oldPosition = getCurrentPosition(BLUE_TEAM,BLUE_PLAYER_3);
						int currentPosition = oldPosition + diceNumber;
						
						if((currentPosition- BLUE_HOME_END)>=0)
						{
							currentPosition=oldPosition;
						}
						if(currentPosition>=BLUE_HOME_START)
						{
							
							bluePlayer3Button.setX(bluePlayerHomePositionPath[currentPosition-BLUE_HOME_START][0]);
							bluePlayer3Button.setY(bluePlayerHomePositionPath[currentPosition-BLUE_HOME_START][1]);
							
						}
						else
						{
							removeOpponent(BLUE_TEAM,currentPosition);
							bluePlayer3Button.setX(playerPosition[currentPosition+BLUE_VARIATION+1][0]);
							bluePlayer3Button.setY(playerPosition[currentPosition+BLUE_VARIATION+1][1]);
														
						}
						//removeOpponent(BLUE_TEAM,currentPosition);
						if(checkWonGame(BLUE_TEAM)== true)
						{
							Toast.makeText(getApplicationContext(), bluePlayerName+" won the game.", Toast.LENGTH_LONG).show();
						}
						
												
						bluePlayersPath[oldPosition] = 0;
						bluePlayersPath[currentPosition] = BLUE_PLAYER_3;

						
					}
					//finish player turn and disable tokens
					finishPlayerTurn(BLUE_TEAM);
					Toast.makeText(getApplicationContext(), "next turn started..", Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			});
			// forth blue player

			bluePlayer4Button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					if (checkInitPosition(BLUE_TEAM,BLUE_PLAYER_4) == false )
					{
						if (diceNumber == 6)
						{

							setInitPosition(BLUE_TEAM, BLUE_PLAYER_4);

						} 
						else
						{
							Toast.makeText(getApplicationContext(), "You can not move token until you get 6.",
									Toast.LENGTH_SHORT).show();
						}
					} else {
						
						Toast.makeText(getApplicationContext(), "current posi.start", 	Toast.LENGTH_SHORT).show();
						int oldPosition = getCurrentPosition(BLUE_TEAM,BLUE_PLAYER_4);
						
						int currentPosition = oldPosition + diceNumber;
						
						
					
						if((currentPosition- BLUE_HOME_END)>=0)
						{
							currentPosition=oldPosition;
						}
						if(currentPosition>=BLUE_HOME_START)
						{
							
							bluePlayer4Button.setX(bluePlayerHomePositionPath[currentPosition-BLUE_HOME_START][0]);
							bluePlayer4Button.setY(bluePlayerHomePositionPath[currentPosition-BLUE_HOME_START][1]);
							
						}
						else
						{
							removeOpponent(BLUE_TEAM,currentPosition);
							bluePlayer4Button.setX(playerPosition[currentPosition+BLUE_VARIATION+1][0]);
							bluePlayer4Button.setY(playerPosition[currentPosition+BLUE_VARIATION+1][1]);
														
						}
						
						if(checkWonGame(BLUE_TEAM)== true)
						{
							Toast.makeText(getApplicationContext(), bluePlayerName+" won the game.", Toast.LENGTH_LONG).show();
						}
						
												
						bluePlayersPath[oldPosition] = 0;
						bluePlayersPath[currentPosition] = BLUE_PLAYER_4;

						
					}
					//finish player turn and disable tokens
					finishPlayerTurn(BLUE_TEAM);
					Toast.makeText(getApplicationContext(), "next turn started..", Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			});
		}

		// red button

		else if (player == RED_TEAM) {
			if (checkInitPosition(RED_TEAM,RED_PLAYER_1) == false && checkInitPosition(RED_TEAM,RED_PLAYER_2) == false && checkInitPosition(RED_TEAM,RED_PLAYER_3) == false && checkInitPosition(RED_TEAM,RED_PLAYER_4) == false )
			{
				if (diceNumber != 6)
				{
					Toast.makeText(getApplicationContext(), "You can  not move your token until you get 6 ",
							Toast.LENGTH_SHORT).show();
					
					finishPlayerTurn(RED_TEAM);
					//Toast.makeText(getApplicationContext(), "next turn started for"+activePlayer, Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			}
			

			
			redPlayer1Button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					
					if (checkInitPosition(RED_TEAM,RED_PLAYER_1) == false)
					{
						if (diceNumber == 6)
						{

							 setInitPosition(RED_TEAM, RED_PLAYER_1);

						} 
						else
						{
							Toast.makeText(getApplicationContext(), "You can not move token until you get 6.",
									Toast.LENGTH_SHORT).show();
						}
						
						
					} else 
					{
						int oldPosition = getCurrentPosition(RED_TEAM,RED_PLAYER_1);
						int currentPosition = oldPosition + diceNumber;
						
						if((currentPosition- RED_HOME_END)>=0)
						{
							currentPosition=oldPosition;
						}
						
						if(currentPosition>=RED_HOME_START)
						{
							
							redPlayer1Button.setX(redPlayerHomePositionPath[currentPosition-RED_HOME_START][0]);
							redPlayer1Button.setY(redPlayerHomePositionPath[currentPosition-RED_HOME_START][1]);
							
						}
						else
						{
							//check for existing position
							removeOpponent(RED_TEAM,currentPosition);
							//playerCommonPath[oldPosition+RED_VARIATION]=0;
						//	playerCommonPath[currentPosition+RED_VARIATION]=1;
							redPlayer1Button.setX(playerPosition[currentPosition+RED_VARIATION+1][0]);
							redPlayer1Button.setY(playerPosition[currentPosition+RED_VARIATION+1][1]);
														
						}
						
						if(checkWonGame(RED_TEAM)== true)
						{
							Toast.makeText(getApplicationContext(), redPlayerName+" won the game.", Toast.LENGTH_LONG).show();
						}
						
												
						redPlayersPath[oldPosition] = 0;
						redPlayersPath[currentPosition] = RED_PLAYER_1;

						
					}
					//finish player turn and disable tokens
					finishPlayerTurn(RED_TEAM);
					//Toast.makeText(getApplicationContext(), "next turn started..", Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			});

			// second red player

			redPlayer2Button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					
					if (checkInitPosition(RED_TEAM,RED_PLAYER_2) == false)
					{
						if (diceNumber == 6)
						{

							 setInitPosition(RED_TEAM, RED_PLAYER_2);

						} 
						else
						{
							Toast.makeText(getApplicationContext(), "You can not move token until you get 6.",
									Toast.LENGTH_SHORT).show();
						}
						
						
					} else 
					{
						int oldPosition = getCurrentPosition(RED_TEAM,RED_PLAYER_2);
						int currentPosition = oldPosition + diceNumber;
						
						if((currentPosition- RED_HOME_END)>=0)
						{
							currentPosition=oldPosition;
						}
						
						if(currentPosition>=RED_HOME_START)
						{
							
							redPlayer2Button.setX(redPlayerHomePositionPath[currentPosition-RED_HOME_START][0]);
							redPlayer2Button.setY(redPlayerHomePositionPath[currentPosition-RED_HOME_START][1]);
							
						}
						else
						{
							//check for existing position
							removeOpponent(RED_TEAM,currentPosition);
							//playerCommonPath[oldPosition+RED_VARIATION]=0;
						//	playerCommonPath[currentPosition+RED_VARIATION]=1;
							redPlayer2Button.setX(playerPosition[currentPosition+RED_VARIATION+1][0]);
							redPlayer2Button.setY(playerPosition[currentPosition+RED_VARIATION+1][1]);
														
						}
						
						if(checkWonGame(RED_TEAM)== true)
						{
							Toast.makeText(getApplicationContext(), redPlayerName+" won the game.", Toast.LENGTH_LONG).show();
						}
						
												
						redPlayersPath[oldPosition] = 0;
						redPlayersPath[currentPosition] = RED_PLAYER_2;

						
					}
					//finish player turn and disable tokens
					finishPlayerTurn(RED_TEAM);
					//Toast.makeText(getApplicationContext(), "next turn started..", Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			});
			// third red player

			redPlayer3Button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					if (checkInitPosition(RED_TEAM,RED_PLAYER_3) == false )
					{
						if (diceNumber == 6)
						{

							setInitPosition(RED_TEAM, RED_PLAYER_3);

						} 
						else
						{
							Toast.makeText(getApplicationContext(), "You can not move token until you get 6.",
									Toast.LENGTH_SHORT).show();
						}
					} else {
						int oldPosition = getCurrentPosition(RED_TEAM,RED_PLAYER_3);
						int currentPosition = oldPosition + diceNumber;
						
						if((currentPosition- RED_HOME_END)>=0)
						{
							currentPosition=oldPosition;
						}
						if(currentPosition>=RED_HOME_START)
						{
							
							redPlayer3Button.setX(redPlayerHomePositionPath[currentPosition-RED_HOME_START][0]);
							redPlayer3Button.setY(redPlayerHomePositionPath[currentPosition-RED_HOME_START][1]);
							
						}
						else
						{
							removeOpponent(RED_TEAM,currentPosition);
							redPlayer3Button.setX(playerPosition[currentPosition+RED_VARIATION+1][0]);
							redPlayer3Button.setY(playerPosition[currentPosition+RED_VARIATION+1][1]);
														
						}
						//removeOpponent(RED_TEAM,currentPosition);
						if(checkWonGame(RED_TEAM)== true)
						{
							Toast.makeText(getApplicationContext(), redPlayerName+" won the game.", Toast.LENGTH_LONG).show();
						}
						
												
						redPlayersPath[oldPosition] = 0;
						redPlayersPath[currentPosition] = RED_PLAYER_3;

						
					}
					//finish player turn and disable tokens
					finishPlayerTurn(RED_TEAM);
					//Toast.makeText(getApplicationContext(), "next turn started..", Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			});
			// forth red player

			redPlayer4Button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					if (checkInitPosition(RED_TEAM,RED_PLAYER_4) == false )
					{
						if (diceNumber == 6)
						{

							setInitPosition(RED_TEAM, RED_PLAYER_4);

						} 
						else
						{
							Toast.makeText(getApplicationContext(), "You can not move token until you get 6.",
									Toast.LENGTH_SHORT).show();
						}
					} else {
						
						Toast.makeText(getApplicationContext(), "current posi.start", 	Toast.LENGTH_SHORT).show();
						int oldPosition = getCurrentPosition(RED_TEAM,RED_PLAYER_4);
						
						int currentPosition = oldPosition + diceNumber;
						
						
					
						if((currentPosition- RED_HOME_END)>=0)
						{
							currentPosition=oldPosition;
						}
						if(currentPosition>=RED_HOME_START)
						{
							
							redPlayer4Button.setX(redPlayerHomePositionPath[currentPosition-RED_HOME_START][0]);
							redPlayer4Button.setY(redPlayerHomePositionPath[currentPosition-RED_HOME_START][1]);
							
						}
						else
						{
							removeOpponent(RED_TEAM,currentPosition);
							redPlayer4Button.setX(playerPosition[currentPosition+RED_VARIATION+1][0]);
							redPlayer4Button.setY(playerPosition[currentPosition+RED_VARIATION+1][1]);
														
						}
						//removeOpponent(RED_TEAM,currentPosition);
						if(checkWonGame(RED_TEAM)== true)
						{
							Toast.makeText(getApplicationContext(), redPlayerName+" won the game.", Toast.LENGTH_LONG).show();
						}
						
												
						redPlayersPath[oldPosition] = 0;
						redPlayersPath[currentPosition] = RED_PLAYER_4;

						
					}
					//finish player turn and disable tokens
					finishPlayerTurn(RED_TEAM);
					//Toast.makeText(getApplicationContext(), "next turn started..", Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			});
		}


		// green button event
		else if (player == GREEN_TEAM) {
			if (checkInitPosition(GREEN_TEAM,GREEN_PLAYER_1) == false && checkInitPosition(GREEN_TEAM,GREEN_PLAYER_2) == false && checkInitPosition(GREEN_TEAM,GREEN_PLAYER_3) == false && checkInitPosition(GREEN_TEAM,GREEN_PLAYER_4) == false )
			{
				if (diceNumber != 6)
				{
					Toast.makeText(getApplicationContext(), "You can  not move your token until you get 6 ",
							Toast.LENGTH_SHORT).show();
					
					finishPlayerTurn(GREEN_TEAM);
					//Toast.makeText(getApplicationContext(), "next turn started for"+activePlayer, Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			}
			

			
			greenPlayer1Button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					
					if (checkInitPosition(GREEN_TEAM,GREEN_PLAYER_1) == false)
					{
						if (diceNumber == 6)
						{

							 setInitPosition(GREEN_TEAM, GREEN_PLAYER_1);

						} 
						else
						{
							Toast.makeText(getApplicationContext(), "You can not move token until you get 6.",
									Toast.LENGTH_SHORT).show();
						}
						
						
					} else 
					{
						int oldPosition = getCurrentPosition(GREEN_TEAM,GREEN_PLAYER_1);
						int currentPosition = oldPosition + diceNumber;
						
						if((currentPosition- GREEN_HOME_END)>=0)
						{
							currentPosition=oldPosition;
						}
						
						if(currentPosition>=GREEN_HOME_START)
						{
							
							greenPlayer1Button.setX(greenPlayerHomePositionPath[currentPosition-GREEN_HOME_START][0]);
							greenPlayer1Button.setY(greenPlayerHomePositionPath[currentPosition-GREEN_HOME_START][1]);
							
						}
						else
						{
							//check for existing position
							removeOpponent(GREEN_TEAM,currentPosition);
							//playerCommonPath[oldPosition+GREEN_VARIATION]=0;
						//	playerCommonPath[currentPosition+GREEN_VARIATION]=1;
							greenPlayer1Button.setX(playerPosition[currentPosition+GREEN_VARIATION+1][0]);
							greenPlayer1Button.setY(playerPosition[currentPosition+GREEN_VARIATION+1][1]);
														
						}
						
						if(checkWonGame(GREEN_TEAM)== true)
						{
							Toast.makeText(getApplicationContext(), greenPlayerName+" won the game.", Toast.LENGTH_LONG).show();
						}
						
												
						greenPlayersPath[oldPosition] = 0;
						greenPlayersPath[currentPosition] = GREEN_PLAYER_1;

						
					}
					//finish player turn and disable tokens
					finishPlayerTurn(GREEN_TEAM);
					//Toast.makeText(getApplicationContext(), "next turn started..", Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			});

			// second green player

			greenPlayer2Button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					
					if (checkInitPosition(GREEN_TEAM,GREEN_PLAYER_2) == false)
					{
						if (diceNumber == 6)
						{

							 setInitPosition(GREEN_TEAM, GREEN_PLAYER_2);

						} 
						else
						{
							Toast.makeText(getApplicationContext(), "You can not move token until you get 6.",
									Toast.LENGTH_SHORT).show();
						}
						
						
					} else 
					{
						int oldPosition = getCurrentPosition(GREEN_TEAM,GREEN_PLAYER_2);
						int currentPosition = oldPosition + diceNumber;
						
						if((currentPosition- GREEN_HOME_END)>=0)
						{
							currentPosition=oldPosition;
						}
						
						if(currentPosition>=GREEN_HOME_START)
						{
							
							greenPlayer2Button.setX(greenPlayerHomePositionPath[currentPosition-GREEN_HOME_START][0]);
							greenPlayer2Button.setY(greenPlayerHomePositionPath[currentPosition-GREEN_HOME_START][1]);
							
						}
						else
						{
							//check for existing position
							removeOpponent(GREEN_TEAM,currentPosition+GREEN_VARIATION);
							//playerCommonPath[oldPosition+GREEN_VARIATION]=0;
						//	playerCommonPath[currentPosition+GREEN_VARIATION]=1;
							greenPlayer2Button.setX(playerPosition[currentPosition+GREEN_VARIATION+1][0]);
							greenPlayer2Button.setY(playerPosition[currentPosition+GREEN_VARIATION+1][1]);
														
						}
						
						if(checkWonGame(GREEN_TEAM)== true)
						{
							Toast.makeText(getApplicationContext(), greenPlayerName+" won the game.", Toast.LENGTH_LONG).show();
						}
						
												
						greenPlayersPath[oldPosition] = 0;
						greenPlayersPath[currentPosition] = GREEN_PLAYER_2;

						
					}
					//finish player turn and disable tokens
					finishPlayerTurn(GREEN_TEAM);
					//Toast.makeText(getApplicationContext(), "next turn started..", Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			});
			// third green player

			greenPlayer3Button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					if (checkInitPosition(GREEN_TEAM,GREEN_PLAYER_3) == false )
					{
						if (diceNumber == 6)
						{

							setInitPosition(GREEN_TEAM, GREEN_PLAYER_3);

						} 
						else
						{
							Toast.makeText(getApplicationContext(), "You can not move token until you get 6.",
									Toast.LENGTH_SHORT).show();
						}
					} else {
						int oldPosition = getCurrentPosition(GREEN_TEAM,GREEN_PLAYER_3);
						int currentPosition = oldPosition + diceNumber;
						
						if((currentPosition- GREEN_HOME_END)>=0)
						{
							currentPosition=oldPosition;
						}
						if(currentPosition>=GREEN_HOME_START)
						{
							
							greenPlayer3Button.setX(greenPlayerHomePositionPath[currentPosition-GREEN_HOME_START][0]);
							greenPlayer3Button.setY(greenPlayerHomePositionPath[currentPosition-GREEN_HOME_START][1]);
							
						}
						else
						{
							removeOpponent(GREEN_TEAM,currentPosition);
							greenPlayer3Button.setX(playerPosition[currentPosition+GREEN_VARIATION+1][0]);
							greenPlayer3Button.setY(playerPosition[currentPosition+GREEN_VARIATION+1][1]);
														
						}
						//removeOpponent(GREEN_TEAM,currentPosition);
						if(checkWonGame(GREEN_TEAM)== true)
						{
							Toast.makeText(getApplicationContext(), greenPlayerName+" won the game.", Toast.LENGTH_LONG).show();
						}
						
												
						greenPlayersPath[oldPosition] = 0;
						greenPlayersPath[currentPosition] = GREEN_PLAYER_3;

						
					}
					//finish player turn and disable tokens
					finishPlayerTurn(GREEN_TEAM);
					Toast.makeText(getApplicationContext(), "next turn started..", Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			});
			// forth green player

			greenPlayer4Button.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					if (checkInitPosition(GREEN_TEAM,GREEN_PLAYER_4) == false )
					{
						if (diceNumber == 6)
						{

							setInitPosition(GREEN_TEAM, GREEN_PLAYER_4);

						} 
						else
						{
							Toast.makeText(getApplicationContext(), "You can not move token until you get 6.",
									Toast.LENGTH_SHORT).show();
						}
					} else {
						
						Toast.makeText(getApplicationContext(), "current posi.start", 	Toast.LENGTH_SHORT).show();
						int oldPosition = getCurrentPosition(GREEN_TEAM,GREEN_PLAYER_4);
						
						int currentPosition = oldPosition + diceNumber;
						
						
					
						if((currentPosition- GREEN_HOME_END)>=0)
						{
							currentPosition=oldPosition;
						}
						if(currentPosition>=GREEN_HOME_START)
						{
							
							greenPlayer4Button.setX(greenPlayerHomePositionPath[currentPosition-GREEN_HOME_START][0]);
							greenPlayer4Button.setY(greenPlayerHomePositionPath[currentPosition-GREEN_HOME_START][1]);
							
						}
						else
						{
							removeOpponent(GREEN_TEAM,currentPosition);
							greenPlayer4Button.setX(playerPosition[currentPosition+GREEN_VARIATION+1][0]);
							greenPlayer4Button.setY(playerPosition[currentPosition+GREEN_VARIATION+1][1]);
														
						}
						//removeOpponent(GREEN_TEAM,currentPosition);
						if(checkWonGame(GREEN_TEAM)== true)
						{
							Toast.makeText(getApplicationContext(), greenPlayerName+" won the game.", Toast.LENGTH_LONG).show();
						}
						
												
						greenPlayersPath[oldPosition] = 0;
						greenPlayersPath[currentPosition] = GREEN_PLAYER_4;

						
					}
					//finish player turn and disable tokens
					finishPlayerTurn(GREEN_TEAM);
					Toast.makeText(getApplicationContext(), "next turn started..", Toast.LENGTH_SHORT).show();
					setPlayerTurn(activePlayer);
				}
			});
		}


	}
	/*
	 * THIS method remove the opponent if it is on the same position of preveous one
	 * @param player value player name
	 * param currentPosition is value of old position+Dice number 
	 */

	public void removeOpponent(final int player, int currentPosition) {
		// check for existing token on destination position

		if (player == YELLOW_TEAM) {
			if ((currentPosition - 1 - BLUE_VARIATION) >= 0) {
				if (bluePlayersPath[currentPosition - 1 - BLUE_VARIATION] == BLUE_PLAYER_1) {
					bluePlayersPath[currentPosition] = 0;
					// seting to initialposition
					bluePlayer1Button.setX(BLUE1_ORIGIN_X);
					bluePlayer1Button.setY(BLUE1_ORIGIN_Y);
				} else if (bluePlayersPath[currentPosition - 1 - BLUE_VARIATION] == BLUE_PLAYER_2) {
					bluePlayersPath[currentPosition] = 0;

					bluePlayer2Button.setX(BLUE2_ORIGIN_X);
					bluePlayer2Button.setY(BLUE2_ORIGIN_Y);
				} else if (bluePlayersPath[currentPosition - 1 - BLUE_VARIATION] == BLUE_PLAYER_3) {
					bluePlayersPath[currentPosition] = 0;

					bluePlayer3Button.setX(BLUE3_ORIGIN_X);
					bluePlayer3Button.setY(BLUE3_ORIGIN_Y);
				} else if (bluePlayersPath[currentPosition - 1 - BLUE_VARIATION] == BLUE_PLAYER_4) {
					bluePlayersPath[currentPosition] = 0;
					bluePlayer4Button.setX(BLUE4_ORIGIN_X);
					bluePlayer4Button.setY(BLUE4_ORIGIN_Y);
				}
			} else if ((currentPosition - 1 - RED_VARIATION) >= 0) {
				if (redPlayersPath[currentPosition - 1 - RED_VARIATION] == RED_PLAYER_1) {
					redPlayersPath[currentPosition] = 0;
					// seting to initialposition
					redPlayer1Button.setX(RED1_ORIGIN_X);
					redPlayer1Button.setY(RED1_ORIGIN_Y);
				} else if (redPlayersPath[currentPosition - 1 - RED_VARIATION] == RED_PLAYER_2) {
					redPlayersPath[currentPosition] = 0;

					redPlayer2Button.setX(RED2_ORIGIN_X);
					redPlayer2Button.setY(RED2_ORIGIN_Y);
				} else if (redPlayersPath[currentPosition - 1 - RED_VARIATION] == RED_PLAYER_3) {
					redPlayersPath[currentPosition] = 0;

					redPlayer3Button.setX(RED3_ORIGIN_X);
					redPlayer3Button.setY(RED3_ORIGIN_Y);
				} else if (redPlayersPath[currentPosition - 1 - RED_VARIATION] == RED_PLAYER_4) {
					redPlayersPath[currentPosition] = 0;
					redPlayer4Button.setX(RED4_ORIGIN_X);
					redPlayer4Button.setY(RED4_ORIGIN_Y);
				}
			}

			else if ((currentPosition - 1 - GREEN_VARIATION) >= 0) {
				if (greenPlayersPath[currentPosition - 1 - GREEN_VARIATION] == GREEN_PLAYER_1) {
					greenPlayersPath[currentPosition] = 0;
					// seting to initialposition
					greenPlayer1Button.setX(GREEN1_ORIGIN_X);
					greenPlayer1Button.setY(GREEN1_ORIGIN_Y);
				} else if (greenPlayersPath[currentPosition - 1 - GREEN_VARIATION] == GREEN_PLAYER_2) {
					greenPlayersPath[currentPosition] = 0;

					greenPlayer2Button.setX(GREEN2_ORIGIN_X);
					greenPlayer2Button.setY(GREEN2_ORIGIN_Y);
				} else if (greenPlayersPath[currentPosition - 1 - GREEN_VARIATION] == GREEN_PLAYER_3) {
					greenPlayersPath[currentPosition] = 0;

					greenPlayer3Button.setX(GREEN3_ORIGIN_X);
					greenPlayer3Button.setY(GREEN3_ORIGIN_Y);
				} else if (greenPlayersPath[currentPosition - 1 - GREEN_VARIATION] == GREEN_PLAYER_4) {
					greenPlayersPath[currentPosition] = 0;
					greenPlayer4Button.setX(GREEN4_ORIGIN_X);
					greenPlayer4Button.setY(GREEN4_ORIGIN_Y);
				}
			}
		}

		else if (player == BLUE_TEAM) {

			if ((currentPosition - 1 - BLUE_VARIATION) >= 0) {

				if (yellowPlayersPath[currentPosition - 1 - BLUE_VARIATION] == YELLOW_PLAYER_1) {
					yellowPlayersPath[currentPosition] = 0;
					yellowPlayer1Button.setX(YELLOW1_ORIGIN_X);
					yellowPlayer1Button.setY(YELLOW1_ORIGIN_Y);
				} else if (yellowPlayersPath[currentPosition - 1 - BLUE_VARIATION] == YELLOW_PLAYER_2) {
					yellowPlayersPath[currentPosition] = 0;

					yellowPlayer2Button.setX(YELLOW2_ORIGIN_X);
					yellowPlayer2Button.setY(YELLOW2_ORIGIN_Y);
				} else if (yellowPlayersPath[currentPosition - 1 - BLUE_VARIATION] == YELLOW_PLAYER_3) {
					yellowPlayersPath[currentPosition] = 0;

					yellowPlayer3Button.setX(YELLOW3_ORIGIN_X);
					yellowPlayer3Button.setY(YELLOW3_ORIGIN_Y);
				} else if (yellowPlayersPath[currentPosition - 1 - BLUE_VARIATION] == YELLOW_PLAYER_4) {
					yellowPlayersPath[currentPosition] = 0;
					yellowPlayer4Button.setX(YELLOW4_ORIGIN_X);
					yellowPlayer4Button.setY(YELLOW4_ORIGIN_Y);
				}

				else if (redPlayersPath[currentPosition - 1 - BLUE_VARIATION] == RED_PLAYER_1) {
					redPlayersPath[currentPosition] = 0;

					redPlayer1Button.setX(RED1_ORIGIN_X);
					redPlayer1Button.setY(RED1_ORIGIN_Y);
				} else if (redPlayersPath[currentPosition - 1 - BLUE_VARIATION] == RED_PLAYER_2) {
					redPlayersPath[currentPosition] = 0;

					redPlayer2Button.setX(RED2_ORIGIN_X);
					redPlayer2Button.setY(RED2_ORIGIN_Y);
				} else if (redPlayersPath[currentPosition - 1 - BLUE_VARIATION] == RED_PLAYER_3) {
					redPlayersPath[currentPosition] = 0;

					redPlayer3Button.setX(RED3_ORIGIN_X);
					redPlayer3Button.setY(RED3_ORIGIN_Y);
				} else if (redPlayersPath[currentPosition - 1 - BLUE_VARIATION] == RED_PLAYER_4) {
					redPlayersPath[currentPosition] = 0;
					redPlayer4Button.setX(RED4_ORIGIN_X);
					redPlayer4Button.setY(RED4_ORIGIN_Y);
				}

				else if (greenPlayersPath[currentPosition - 1 - BLUE_VARIATION] == GREEN_PLAYER_1) {
					greenPlayersPath[currentPosition] = 0;
					// seting to initialposition
					greenPlayer1Button.setX(GREEN1_ORIGIN_X);
					greenPlayer1Button.setY(GREEN1_ORIGIN_Y);
				} else if (greenPlayersPath[currentPosition - 1 - BLUE_VARIATION] == GREEN_PLAYER_2) {
					greenPlayersPath[currentPosition] = 0;

					greenPlayer2Button.setX(GREEN2_ORIGIN_X);
					greenPlayer2Button.setY(GREEN2_ORIGIN_Y);
				} else if (greenPlayersPath[currentPosition - 1 - BLUE_VARIATION] == GREEN_PLAYER_3) {
					greenPlayersPath[currentPosition] = 0;

					greenPlayer3Button.setX(GREEN3_ORIGIN_X);
					greenPlayer3Button.setY(GREEN3_ORIGIN_Y);
				} else if (greenPlayersPath[currentPosition - 1 - BLUE_VARIATION] == GREEN_PLAYER_4) {
					greenPlayersPath[currentPosition] = 0;
					greenPlayer4Button.setX(GREEN4_ORIGIN_X);
					greenPlayer4Button.setY(GREEN4_ORIGIN_Y);
				}
			}
		}
		if (player == RED_TEAM) {

			if ((currentPosition - 1 - RED_VARIATION) >= 0) {

				if (yellowPlayersPath[currentPosition - 1 - RED_VARIATION] == YELLOW_PLAYER_1) {
					yellowPlayersPath[currentPosition] = 0;
					yellowPlayer1Button.setX(BLUE1_ORIGIN_X);
					yellowPlayer1Button.setY(BLUE1_ORIGIN_Y);
				} else if (yellowPlayersPath[currentPosition - 1 - RED_VARIATION] == YELLOW_PLAYER_2) {
					yellowPlayersPath[currentPosition] = 0;

					yellowPlayer2Button.setX(BLUE2_ORIGIN_X);
					yellowPlayer2Button.setY(BLUE2_ORIGIN_Y);
				} else if (yellowPlayersPath[currentPosition - 1 - RED_VARIATION] == YELLOW_PLAYER_3) {
					yellowPlayersPath[currentPosition] = 0;

					yellowPlayer3Button.setX(BLUE3_ORIGIN_X);
					yellowPlayer3Button.setY(BLUE3_ORIGIN_Y);
				} else if (yellowPlayersPath[currentPosition - 1 - RED_VARIATION] == YELLOW_PLAYER_4) {
					yellowPlayersPath[currentPosition] = 0;
					yellowPlayer4Button.setX(BLUE4_ORIGIN_X);
					yellowPlayer4Button.setY(BLUE4_ORIGIN_Y);
				}

				else if (bluePlayersPath[currentPosition - 1 - RED_VARIATION] == BLUE_PLAYER_1) {
					bluePlayersPath[currentPosition] = 0;

					bluePlayer1Button.setX(BLUE1_ORIGIN_X);
					bluePlayer1Button.setY(BLUE1_ORIGIN_Y);
				} else if (bluePlayersPath[currentPosition - 1 - RED_VARIATION] == BLUE_PLAYER_2) {
					bluePlayersPath[currentPosition] = 0;

					bluePlayer2Button.setX(BLUE2_ORIGIN_X);
					bluePlayer2Button.setY(BLUE2_ORIGIN_Y);
				} else if (bluePlayersPath[currentPosition - 1 - RED_VARIATION] == BLUE_PLAYER_3) {
					bluePlayersPath[currentPosition] = 0;

					bluePlayer3Button.setX(BLUE3_ORIGIN_X);
					bluePlayer3Button.setY(BLUE3_ORIGIN_Y);
				} else if (bluePlayersPath[currentPosition - 1 - RED_VARIATION] == BLUE_PLAYER_4) {
					bluePlayersPath[currentPosition] = 0;
					bluePlayer4Button.setX(BLUE4_ORIGIN_X);
					bluePlayer4Button.setY(BLUE4_ORIGIN_Y);
				}

				else if (greenPlayersPath[currentPosition - 1 - RED_VARIATION] == GREEN_PLAYER_1) {
					greenPlayersPath[currentPosition] = 0;
					// seting to initialposition
					greenPlayer1Button.setX(GREEN1_ORIGIN_X);
					greenPlayer1Button.setY(GREEN1_ORIGIN_Y);
				} else if (greenPlayersPath[currentPosition - 1 - RED_VARIATION] == GREEN_PLAYER_2) {
					greenPlayersPath[currentPosition] = 0;

					greenPlayer2Button.setX(GREEN2_ORIGIN_X);
					greenPlayer2Button.setY(GREEN2_ORIGIN_Y);
				} else if (greenPlayersPath[currentPosition - 1 - RED_VARIATION] == GREEN_PLAYER_3) {
					greenPlayersPath[currentPosition] = 0;

					greenPlayer3Button.setX(GREEN3_ORIGIN_X);
					greenPlayer3Button.setY(GREEN3_ORIGIN_Y);
				} else if (greenPlayersPath[currentPosition - 1 - RED_VARIATION] == GREEN_PLAYER_4) {
					greenPlayersPath[currentPosition] = 0;
					greenPlayer4Button.setX(GREEN4_ORIGIN_X);
					greenPlayer4Button.setY(GREEN4_ORIGIN_Y);
				}
			}		}
		if (player == GREEN_TEAM) {

			if ((currentPosition - 1 - GREEN_VARIATION) >= 0) {

				if (yellowPlayersPath[currentPosition - 1 - GREEN_VARIATION] == YELLOW_PLAYER_1) {
					yellowPlayersPath[currentPosition] = 0;
					yellowPlayer1Button.setX(BLUE1_ORIGIN_X);
					yellowPlayer1Button.setY(BLUE1_ORIGIN_Y);
				} else if (yellowPlayersPath[currentPosition - 1 - GREEN_VARIATION] == YELLOW_PLAYER_2) {
					yellowPlayersPath[currentPosition] = 0;

					yellowPlayer2Button.setX(BLUE2_ORIGIN_X);
					yellowPlayer2Button.setY(BLUE2_ORIGIN_Y);
				} else if (yellowPlayersPath[currentPosition - 1 - GREEN_VARIATION] == YELLOW_PLAYER_3) {
					yellowPlayersPath[currentPosition] = 0;

					yellowPlayer3Button.setX(BLUE3_ORIGIN_X);
					yellowPlayer3Button.setY(BLUE3_ORIGIN_Y);
				} else if (yellowPlayersPath[currentPosition - 1 - GREEN_VARIATION] == YELLOW_PLAYER_4) {
					yellowPlayersPath[currentPosition] = 0;
					yellowPlayer4Button.setX(BLUE4_ORIGIN_X);
					yellowPlayer4Button.setY(BLUE4_ORIGIN_Y);
				}

				else if (bluePlayersPath[currentPosition - 1 - GREEN_VARIATION] == BLUE_PLAYER_1) {
					bluePlayersPath[currentPosition] = 0;

					bluePlayer1Button.setX(RED1_ORIGIN_X);
					bluePlayer1Button.setY(RED1_ORIGIN_Y);
				} else if (bluePlayersPath[currentPosition - 1 - GREEN_VARIATION] == BLUE_PLAYER_2) {
					bluePlayersPath[currentPosition] = 0;

					bluePlayer2Button.setX(RED2_ORIGIN_X);
					bluePlayer2Button.setY(RED2_ORIGIN_Y);
				} else if (bluePlayersPath[currentPosition - 1 - GREEN_VARIATION] == BLUE_PLAYER_3) {
					bluePlayersPath[currentPosition] = 0;

					bluePlayer3Button.setX(RED3_ORIGIN_X);
					bluePlayer3Button.setY(RED3_ORIGIN_Y);
				} else if (bluePlayersPath[currentPosition - 1 - GREEN_VARIATION] == BLUE_PLAYER_4) {
					bluePlayersPath[currentPosition] = 0;
					bluePlayer4Button.setX(RED4_ORIGIN_X);
					bluePlayer4Button.setY(RED4_ORIGIN_Y);
				}

				else if (redPlayersPath[currentPosition - 1 - GREEN_VARIATION] == RED_PLAYER_1) {
					redPlayersPath[currentPosition] = 0;
					// seting to initialposition
					redPlayer1Button.setX(RED1_ORIGIN_X);
					redPlayer1Button.setY(RED1_ORIGIN_Y);
				} else if (redPlayersPath[currentPosition - 1 - GREEN_VARIATION] == RED_PLAYER_2) {
					redPlayersPath[currentPosition] = 0;

					redPlayer2Button.setX(RED2_ORIGIN_X);
					redPlayer2Button.setY(RED2_ORIGIN_Y);
				} else if (redPlayersPath[currentPosition - 1 - GREEN_VARIATION] == RED_PLAYER_3) {
					redPlayersPath[currentPosition] = 0;

					redPlayer3Button.setX(RED3_ORIGIN_X);
					redPlayer3Button.setY(RED3_ORIGIN_Y);
				} else if (redPlayersPath[currentPosition - 1 - GREEN_VARIATION] == RED_PLAYER_4) {
					redPlayersPath[currentPosition] = 0;
					redPlayer4Button.setX(RED4_ORIGIN_X);
					redPlayer4Button.setY(RED4_ORIGIN_Y);
				}
			}
		}

	}

	public boolean checkInitPosition(final int player, final int token) {

		boolean checkPosition = false;
		if (player == YELLOW_TEAM) {
			for (int i = 0; i < yellowPlayersPath.length; i++) {
				if (yellowPlayersPath[i] == token) {
					checkPosition = true;
				}
			}

		} else if (player == BLUE_TEAM) {
			for (int i = 0; i < bluePlayersPath.length; i++) {
				if (bluePlayersPath[i] == token) {
					checkPosition = true;
				}
			}

		} else if (player == RED_TEAM) {
			for (int i = 0; i < redPlayersPath.length; i++) {
				if (redPlayersPath[i] == token) {
					checkPosition = true;
				}
			}

		} else if (player == GREEN_TEAM) {
			for (int i = 0; i < greenPlayersPath.length; i++) {
				if (greenPlayersPath[i] == token) {
					checkPosition = true;
				}
			}

		}
		// Toast.makeText(getApplicationContext(), " check init position set",
		// Toast.LENGTH_SHORT).show();
		return checkPosition;
	}

	public boolean checkExistingPosition(final int player) {
		if (player == YELLOW_TEAM) {
			if (yellowPlayersPath[1] == 1 || yellowPlayersPath[1] == 2 || yellowPlayersPath[1] == 3
					|| yellowPlayersPath[1] == 4) {
				return true;
			}
		} else if (player == BLUE_TEAM) {
			if (bluePlayersPath[1] == 5 || bluePlayersPath[1] == 6 || bluePlayersPath[1] == 7
					|| bluePlayersPath[1] == 8) {
				return true;
			}
		}
		if (player == RED_TEAM) {
			if (redPlayersPath[1] == 9 || redPlayersPath[1] == 10 || redPlayersPath[1] == 11 || redPlayersPath[1] == 12) {
				return true;
			}
		} else {
			if (greenPlayersPath[1] == 13 || greenPlayersPath[1] == 14 || greenPlayersPath[1] == 15
					|| greenPlayersPath[1] == 16) {
				return true;
			}
		}
		// Toast.makeText(getApplicationContext(), "check existing pos",
		// Toast.LENGTH_SHORT).show();
		return false;
	}

	/*
	 * get current position of active token
	 */
	public int getCurrentPosition(final int player, final int token) {

		int currentPosition = 0;
		if (player == YELLOW_TEAM) {
			for (int i = 0; i < yellowPlayersPath.length; i++) {
				if (yellowPlayersPath[i] == token) {
					currentPosition = i;
				}
			}

		} else if (player == BLUE_TEAM) {
			for (int i = 0; i < bluePlayersPath.length; i++) {
				if (bluePlayersPath[i] == token) {
					currentPosition = i;
				}
			}

		} else if (player == RED_TEAM) {
			for (int i = 0; i < redPlayersPath.length; i++) {
				if (redPlayersPath[i] == token) {
					currentPosition = i;
				}
			}

		} else if (player == GREEN_TEAM) {
			for (int i = 0; i < greenPlayersPath.length; i++) {
				if (greenPlayersPath[i] == token) {
					currentPosition = i;
				}
			}

		}
		// Toast.makeText(getApplicationContext(), "get current position ",
		// Toast.LENGTH_SHORT).show();
		return currentPosition;
	}

	/*
	 * set initial position for token
	 */

	public void setInitPosition(final int player, final int token) {

		// Toast.makeText(getApplicationContext(), "init position set",
		// Toast.LENGTH_SHORT).show();
		if (player == YELLOW_TEAM) {
			if (token == YELLOW_PLAYER_1) {

				yellowPlayer1Button.setX(playerPosition[1][0]);
				yellowPlayer1Button.setY(playerPosition[1][1]);
			} else if (token == YELLOW_PLAYER_2) {

				yellowPlayer2Button.setX(playerPosition[1][0]);
				yellowPlayer2Button.setY(playerPosition[1][1]);
			} else if (token == YELLOW_PLAYER_3) {

				yellowPlayer3Button.setX(playerPosition[1][0]);
				yellowPlayer3Button.setY(playerPosition[1][1]);
			} else {

				yellowPlayer4Button.setX(playerPosition[1][0]);
				yellowPlayer4Button.setY(playerPosition[1][1]);
			}

			yellowPlayersPath[0] = token;
			// Toast.makeText(getApplicationContext(),
			// token+"is set :"+yellowPlayersPath[0],Toast.LENGTH_SHORT).show();
			// playerCommonPath[1]=token;

		} else if (player == BLUE_TEAM) {
			if (token == BLUE_PLAYER_1) {
				bluePlayer1Button.setX(playerPosition[14][0]);
				bluePlayer1Button.setY(playerPosition[14][1]);
			} else if (token == BLUE_PLAYER_2) {
				bluePlayer2Button.setX(playerPosition[14][0]);
				bluePlayer2Button.setY(playerPosition[14][1]);
			} else if (token == BLUE_PLAYER_3) {
				bluePlayer3Button.setX(playerPosition[14][0]);
				bluePlayer3Button.setY(playerPosition[14][1]);
			} else {
				bluePlayer4Button.setX(playerPosition[14][0]);
				bluePlayer4Button.setY(playerPosition[14][1]);
			}

			bluePlayersPath[0] = token;
			// playerCommonPath[14]=token;
		} else if (player == RED_TEAM) {
			if (token == RED_PLAYER_1) {
				redPlayer1Button.setX(playerPosition[29][0]);
				redPlayer1Button.setY(playerPosition[29][1]);
			} else if (token == RED_PLAYER_2) {
				redPlayer2Button.setX(playerPosition[29][0]);
				redPlayer2Button.setY(playerPosition[29][1]);
			} else if (token == RED_PLAYER_3) {
				redPlayer3Button.setX(playerPosition[29][0]);
				redPlayer3Button.setY(playerPosition[29][1]);
			} else {
				redPlayer4Button.setX(playerPosition[29][0]);
				redPlayer4Button.setY(playerPosition[29][1]);
			}
			redPlayersPath[0] = token;
			// playerCommonPath[27]=token;
		} else {
			if (token == GREEN_PLAYER_1) {
				greenPlayer1Button.setX(playerPosition[40][0]);
				greenPlayer1Button.setY(playerPosition[40][1]);
			} else if (token == GREEN_PLAYER_2) {
				greenPlayer2Button.setX(playerPosition[40][0]);
				greenPlayer2Button.setY(playerPosition[40][1]);
			} else if (token == GREEN_PLAYER_3) {
				greenPlayer3Button.setX(playerPosition[40][0]);
				greenPlayer3Button.setY(playerPosition[40][1]);
			} else {
				greenPlayer4Button.setX(playerPosition[40][0]);
				greenPlayer4Button.setY(playerPosition[40][1]);
			}
			greenPlayersPath[0] = token;
			// playerCommonPath[40]=token;
		}

	}

	public boolean checkWonGame(final int player) {
		/* eror */
		if (player == YELLOW_TEAM) {
			if (yellowPlayersPath[YELLOW_HOME_END] == YELLOW_PLAYER_1
					|| yellowPlayersPath[YELLOW_HOME_END] == YELLOW_PLAYER_2
					|| yellowPlayersPath[YELLOW_HOME_END] == YELLOW_PLAYER_3
					|| yellowPlayersPath[YELLOW_HOME_END] == YELLOW_PLAYER_4) {
				yellowPlayersWinnerToken++;
			}
			if (yellowPlayersWinnerToken == 4) {

				yellowPlayer1Button.setEnabled(false);
				yellowPlayer2Button.setEnabled(false);
				yellowPlayer3Button.setEnabled(false);
				yellowPlayer4Button.setEnabled(false);
				yellowPlayer1Button.setVisibility(View.GONE);
				yellowPlayer1Button.setVisibility(View.GONE);
				yellowPlayer2Button.setVisibility(View.GONE);
				yellowPlayer3Button.setVisibility(View.GONE);
				yellowPlayer4Button.setVisibility(View.GONE);
				return true;
			}

		} else if (player == BLUE_TEAM) {

			if (BLUE_PLAYER_1 == bluePlayersPath[BLUE_HOME_END] && BLUE_PLAYER_2 == bluePlayersPath[BLUE_HOME_END]
					&& BLUE_PLAYER_3 == bluePlayersPath[BLUE_HOME_END]
					&& BLUE_PLAYER_4 == bluePlayersPath[BLUE_HOME_END]) {
				bluePlayersWinnerToken++;
			}
			if (bluePlayersWinnerToken == 4) {
				Toast.makeText(getApplicationContext(), bluePlayerName + " won the game.", Toast.LENGTH_LONG).show();
				bluePlayer1Button.setEnabled(false);
				bluePlayer2Button.setEnabled(false);
				bluePlayer3Button.setEnabled(false);
				bluePlayer4Button.setEnabled(false);
				bluePlayer1Button.setVisibility(View.GONE);
				bluePlayer1Button.setVisibility(View.GONE);
				bluePlayer2Button.setVisibility(View.GONE);
				bluePlayer3Button.setVisibility(View.GONE);
				bluePlayer4Button.setVisibility(View.GONE);
				return true;
			}

		} else if (player == RED_TEAM) {

			if (RED_PLAYER_1 == redPlayersPath[RED_HOME_END] && RED_PLAYER_2 == redPlayersPath[RED_HOME_END]
					&& RED_PLAYER_3 == redPlayersPath[RED_HOME_END] && RED_PLAYER_4 == redPlayersPath[RED_HOME_END]) {
				redPlayersWinnerToken++;
			}
			if (redPlayersWinnerToken == 4) {
				Toast.makeText(getApplicationContext(), redPlayerName + " won the game.", Toast.LENGTH_LONG).show();
				redPlayer1Button.setEnabled(false);
				redPlayer2Button.setEnabled(false);
				redPlayer3Button.setEnabled(false);
				redPlayer4Button.setEnabled(false);
				redPlayer1Button.setVisibility(View.GONE);
				redPlayer1Button.setVisibility(View.GONE);
				redPlayer2Button.setVisibility(View.GONE);
				redPlayer3Button.setVisibility(View.GONE);
				redPlayer4Button.setVisibility(View.GONE);
				return true;
			}

		}
		if (player == GREEN_TEAM) {

			if (GREEN_PLAYER_1 == greenPlayersPath[GREEN_HOME_END]
					&& GREEN_PLAYER_2 == greenPlayersPath[GREEN_HOME_END]
					&& GREEN_PLAYER_3 == greenPlayersPath[GREEN_HOME_END]
					&& GREEN_PLAYER_4 == greenPlayersPath[GREEN_HOME_END]) {
				greenPlayersWinnerToken++;
			}
			if (greenPlayersWinnerToken == 4) {
				Toast.makeText(getApplicationContext(), greenPlayerName + " won the game.", Toast.LENGTH_LONG).show();
				greenPlayer1Button.setEnabled(false);
				greenPlayer2Button.setEnabled(false);
				greenPlayer3Button.setEnabled(false);
				greenPlayer4Button.setEnabled(false);
				greenPlayer1Button.setVisibility(View.GONE);
				greenPlayer1Button.setVisibility(View.GONE);
				greenPlayer2Button.setVisibility(View.GONE);
				greenPlayer3Button.setVisibility(View.GONE);
				greenPlayer4Button.setVisibility(View.GONE);
				return true;
			}

		}
		return false;
	}

	public void finishPlayerTurn(final int player) {
		if (player == YELLOW_TEAM) {
			yellowPlayer1Button.setEnabled(false);
			yellowPlayer2Button.setEnabled(false);
			yellowPlayer3Button.setEnabled(false);
			yellowPlayer4Button.setEnabled(false);
			yellowPlayer1Button.setText("");
			yellowPlayer2Button.setText("");
			yellowPlayer3Button.setText("");
			yellowPlayer4Button.setText("");

			if (bluePlayerActive == true) {
				activePlayer = BLUE_TEAM;
			} else if (redPlayerActive == true) {
				activePlayer = RED_TEAM;
			} else if (greenPlayerActive == true) {
				activePlayer = GREEN_TEAM;
			}

		} else if (player == BLUE_TEAM) {
			bluePlayer1Button.setEnabled(false);
			bluePlayer2Button.setEnabled(false);
			bluePlayer3Button.setEnabled(false);
			bluePlayer4Button.setEnabled(false);
			bluePlayer1Button.setText("");
			bluePlayer2Button.setText("");
			bluePlayer3Button.setText("");
			bluePlayer4Button.setText("");
			if (redPlayerActive == true) {
				activePlayer = RED_TEAM;
			} else if (greenPlayerActive == true) {
				activePlayer = GREEN_TEAM;
			} else if (yellowPlayerActive == true) {
				activePlayer = YELLOW_TEAM;
			}

		} else if (player == RED_TEAM) {
			redPlayer1Button.setEnabled(false);
			redPlayer2Button.setEnabled(false);
			redPlayer3Button.setEnabled(false);
			redPlayer4Button.setEnabled(false);
			redPlayer1Button.setText("");
			redPlayer2Button.setText("");
			redPlayer3Button.setText("");
			redPlayer4Button.setText("");

			if (greenPlayerActive == true) {
				activePlayer = GREEN_TEAM;
			} else if (yellowPlayerActive == true) {
				activePlayer = YELLOW_TEAM;
			} else if (bluePlayerActive == true) {
				activePlayer = BLUE_TEAM;
			}

		} else {
			greenPlayer1Button.setEnabled(false);
			greenPlayer2Button.setEnabled(false);
			greenPlayer3Button.setEnabled(false);
			greenPlayer4Button.setEnabled(false);
			greenPlayer1Button.setText("");
			greenPlayer2Button.setText("");
			greenPlayer3Button.setText("");
			greenPlayer4Button.setText("");

			if (yellowPlayerActive == true) {
				activePlayer = YELLOW_TEAM;
			} else if (bluePlayerActive == true) {
				activePlayer = BLUE_TEAM;
			} else if (redPlayerActive == true) {
				activePlayer = RED_TEAM;
			}
		}

	}

	/*
	 * this method used to throw dice on dashboard
	 */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dashboard, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
