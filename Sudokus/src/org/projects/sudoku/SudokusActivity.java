package org.projects.sudoku;


import android.app.AlertDialog;
//import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.util.Log;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class SudokusActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		View continueButton = findViewById(R.id.continue_button);
		continueButton.setOnClickListener(this);
		View newGameButton = findViewById(R.id.newgame_button);
		newGameButton.setOnClickListener(this);
		View aboutButton = findViewById(R.id.about_button);
		aboutButton.setOnClickListener(this);
		View helpButton = findViewById(R.id.help_button);
		helpButton.setOnClickListener(this);
		View exitButton = findViewById(R.id.exit_button);
		exitButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.settings:
			startActivity(new Intent(this, Pref.class));
			return true;

		}
		return false;
	}

	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.continue_button:
			break;
		case R.id.newgame_button:
			openNewGameDialog();
			break;
		case R.id.about_button:
			Intent i = new Intent(this, About.class);
			startActivity(i);
			break;
		case R.id.help_button:
			break;
		case R.id.exit_button:
			finish();
			break;
		}

	}

	private final String TAG = "Sudoku";

	private void openNewGameDialog() {
		new AlertDialog.Builder(this).setTitle(R.string.new_game_title)

		.setItems(R.array.difficulty, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialoginterface, int i) {
				startGame(i);
			}
		}).show();
	}

	private void startGame(int i) {
		Log.d(TAG, "clicked  on  " + i);
		// Start game here...
	}
}