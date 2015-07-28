package com.example.ludogame;

import java.util.ArrayList;
import java.util.List;

import android.animation.AnimatorSet.Builder;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.text.InputType;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.*;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SetupActivity extends Activity {

	private Button startButton;
	private String strPlayerName;
	private ImageButton redPlayerImageButton;
	private TextView redPlayerTextView;
	private ImageButton greenPlayerImageButton;
	private TextView greenPlayerTextView;
	private ImageButton yellowPlayerImageButton;
	private TextView yellowPlayerTextView;
	private ImageButton bluePlayerImageButton;
	private TextView bluePlayerTextView;
	private static final int RED_PLAYER = 1;
	private static final int GREEN_PLAYER = 2;
	private static final int BLUE_PLAYER = 3;
	private static final int YELLOW_PLAYER = 4;
	private static int redPlayerType = 1;
	private static int greenPlayerType = 1;
	private static int bluePlayerType = 1;
	private static int yellowPlayerType = 1;
	private static String[] activePlayerList;
    private static int noOfPlayers=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setup);

		startButton = (Button) findViewById(R.id.startButton);

		// init clicklistener
		initPlayers();
		
		startButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// Toast.makeText(getApplicationContext(), "Button Clicked",
				// Toast.LENGTH_SHORT).show();
				
				Bundle bundle= new Bundle();
				activePlayerList=new String[]{yellowPlayerTextView.getText().toString(),bluePlayerTextView.getText().toString(),redPlayerTextView.getText().toString(),greenPlayerTextView.getText().toString()};
				bundle.putStringArray("playerList",activePlayerList);
				Intent dashboardIntent = new Intent(SetupActivity.this, DashboardActivity.class);
				
				for(int i=0;i<4;i++)
				{
					if(!activePlayerList[i].equals("None"))
					{
						noOfPlayers++;	
					}
				}
			/*	if(noOfPlayers<2)
				{
					Toast.makeText(getApplicationContext(), "Please Select Atleast two players..", Toast.LENGTH_LONG).show();
				}
				else
				*/
				{
					dashboardIntent.putExtras(bundle);
					SetupActivity.this.startActivity(dashboardIntent);
				}
			}
		});
	}

	public void initPlayers() {

		
		
		redPlayerTextView = (TextView) findViewById(R.id.redPlayerTextView);
		redPlayerImageButton = (ImageButton) findViewById(R.id.redPlayerImageButton);
		// redPlayerType=1;
		// redPlayerTextView.setText("Player 1");
		redPlayerImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// Toast.makeText(getApplicationContext(), "red called",
				// Toast.LENGTH_SHORT).show();

				// change player type
				setPlayerType(RED_PLAYER, redPlayerTextView);

			}
		});

		greenPlayerTextView = (TextView) findViewById(R.id.greenPlayerTextView);
		greenPlayerImageButton = (ImageButton) findViewById(R.id.greenPlayerImageButton);
		// greenPlayerType=1;
		greenPlayerImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// Toast.makeText(getApplicationContext(), "red called",
				// Toast.LENGTH_SHORT).show();

				// change player type
				setPlayerType(GREEN_PLAYER, greenPlayerTextView);

				// set player name
				// setPlayerName(greenPlayerTextView);

			}
		});

		yellowPlayerTextView = (TextView) findViewById(R.id.yellowPlayerTextView);
		yellowPlayerImageButton = (ImageButton) findViewById(R.id.yellowPlayerImageButton);
		// yellowPlayerType=1;
		yellowPlayerImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// Toast.makeText(getApplicationContext(), "red called",
				// Toast.LENGTH_SHORT).show();

				// change player type
				setPlayerType(YELLOW_PLAYER, yellowPlayerTextView);
				// set player name
				// setPlayerName(yellowPlayerTextView);

			}
		});

		bluePlayerTextView = (TextView) findViewById(R.id.bluePlayerTextView);
		bluePlayerImageButton = (ImageButton) findViewById(R.id.bluePlayerImageButton);

		bluePlayerImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// Toast.makeText(getApplicationContext(), "red called",
				// Toast.LENGTH_SHORT).show();

				// change player type
				setPlayerType(BLUE_PLAYER, bluePlayerTextView);

				// set player name
				// setPlayerName(bluePlayerTextView);

			}
		});

		/*
		 * // Register the redPlayerButton for Context menu
		 * registerForContextMenu(redPlayerImageButton);
		 * registerForContextMenu(greenPlayerImageButton);
		 * registerForContextMenu(bluePlayerImageButton);
		 * registerForContextMenu(yellowPlayerImageButton);
		 */

	}

	public void setPlayerName(final TextView playerName) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Player Name");

		// Set up the input
		final EditText playerNameEditText = new EditText(this);
		// Specify the type of input expected; this, for example, sets the input
		// as a password, and will mask the text
		playerNameEditText.setInputType(InputType.TYPE_CLASS_TEXT);
		builder.setView(playerNameEditText);

		// Set up the buttons
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				strPlayerName = playerNameEditText.getText().toString();
				// Toast.makeText(getApplicationContext(),
				// "str player name:"+strPlayerName, Toast.LENGTH_SHORT).show();
				playerName.setText(strPlayerName);
			}
		});
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});

		builder.show();

	}

	public void setPlayerType(int player, TextView textView) {
		
		//Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
		
		
		if (player == 1) {
			switch (redPlayerType) {
			case 1:
				redPlayerType = 0;
				textView.setText("None");
				
				break;

			case 0:
				redPlayerType = 1;
				textView.setText("User");

				// set Player name
				setPlayerName(textView);

				break;
			default:
				break;
			}
		}
		else if (player == 2) {
			switch (greenPlayerType) {
			case 1:
				greenPlayerType = 0;
				textView.setText("None");
				break;

			case 0:
				greenPlayerType = 1;
				textView.setText("User");

				// set Player name
				setPlayerName(textView);

				break;
			default:
				break;
			}
		}
		else if (player == 3) {
			switch (bluePlayerType) {
			case 1:
				bluePlayerType = 0;
				textView.setText("None");
				break;

			case 0:
				bluePlayerType = 1;
				textView.setText("User");

				// set Player name
				setPlayerName(textView);

				break;
			default:
				break;
			}
		}
		else {
			switch (yellowPlayerType) {
			case 1:
				yellowPlayerType = 0;
				textView.setText("None");
				break;

			case 0:
				yellowPlayerType = 1;
				textView.setText("User");

				// set Player name
				setPlayerName(textView);

				break;
			default:
				break;
			}
		}
	}
	
}
