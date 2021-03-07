package com.richieoscar.scorekeeper;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView scoreTeamA;
    private TextView scoreTeamB;
    private TextView pointTeamA;
    private TextView pointTeamB;
    private TextView freeKickTeamA;
    private TextView freeKickTeamB;
    private TextView penaltyTeamA;
    private TextView penaltyTeamB;
    private Button goalTeamA;
    private Button goalTeamB;
    private Button fKTeamA;
    private Button fkTeamB;
    private Button pkTeamA;
    private Button pkTeamB;
    private Button reset;
    private ScoreViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       viewModel = new ViewModelProvider(this).get(ScoreViewModel.class);

        initializeViews();
        clickOptions();
        displayScores();
    }

    private void initializeViews() {
        scoreTeamA = findViewById(R.id.textView_goal_teamA);
        scoreTeamB = findViewById(R.id.textView2_goal_teamB);
        pointTeamA = findViewById(R.id.textView_point_teamA);
        pointTeamB = findViewById(R.id.textView_point_teamB);
        freeKickTeamA = findViewById(R.id.textView_fk_teamA);
        freeKickTeamB = findViewById(R.id.textView_fk_teamB);
        penaltyTeamA = findViewById(R.id.textView_pk_teamA);
        penaltyTeamB = findViewById(R.id.textView_pk_teamB);
        goalTeamA = findViewById(R.id.button_goal_teamA);
        goalTeamB = findViewById(R.id.button_goal_teamB);
        fKTeamA = findViewById(R.id.button_fk_yeamA);
        fkTeamB = findViewById(R.id.button_fk_teamB);
        pkTeamA = findViewById(R.id.button_pk_teamA);
        pkTeamB = findViewById(R.id.button_pk_teamB);
        reset = findViewById(R.id.button_reset);


    }


    private void clickOptions() {
        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(goalTeamA);
        buttons.add(goalTeamB);
        buttons.add(fKTeamA);
        buttons.add(fkTeamB);
        buttons.add(pkTeamA);
        buttons.add(pkTeamB);
        buttons.add(reset);

        for (Button items : buttons) {
            int id = items.getId();

            switch (id) {
                case R.id.button_goal_teamA:
                    goalTeamA.setOnClickListener(v -> {
                        scoreTeamA.setText(String.valueOf(viewModel.incrementScoreForTeamA()));
                        pointTeamA.setText(String.valueOf(viewModel.incrementPointForTeamA()));
                    });
                    break;
                case R.id.button_goal_teamB:
                    goalTeamB.setOnClickListener(v -> {
                        scoreTeamB.setText(String.valueOf(viewModel.incrementScoreForTeamB()));
                        pointTeamB.setText(String.valueOf(viewModel.incrementPointForTeamB()));
                    });
                    break;
                case R.id.button_fk_yeamA:
                    fKTeamA.setOnClickListener(v -> {
                        freeKickTeamA.setText(String.valueOf(viewModel.incrementFKForTeamA()));
                    });
                    break;
                case R.id.button_fk_teamB:
                    fkTeamB.setOnClickListener(v -> {
                        freeKickTeamB.setText(String.valueOf(viewModel.incrementFkForTeamB()));
                    });
                    break;
                case R.id.button_pk_teamA:
                    pkTeamA.setOnClickListener(v -> {
                        penaltyTeamA.setText(String.valueOf(viewModel.incrementPkForTeamA()));
                    });
                    break;
                case R.id.button_pk_teamB:
                    pkTeamB.setOnClickListener(v -> {
                        penaltyTeamB.setText(String.valueOf(viewModel.incrementPkForTeamB()));
                    });
                    break;
                case R.id.button_reset:
                    reset.setOnClickListener(v -> {
                        reset();
                    });
            }

        }

    }

    public void displayScores() {
        scoreTeamA.setText(String.valueOf(viewModel.getSumTeamA()));
        scoreTeamB.setText(String.valueOf(viewModel.getSumTeamB()));
        pointTeamB.setText(String.valueOf(viewModel.getSumPointsA()));
        pointTeamB.setText(String.valueOf(viewModel.getSumPointsB()));
        penaltyTeamA.setText(String.valueOf(viewModel.getSumPkTeamA()));
        penaltyTeamB.setText(String.valueOf(viewModel.getSumPkTeamB()));
        freeKickTeamB.setText(String.valueOf(viewModel.getSumFKTeamB()));
        freeKickTeamA.setText(String.valueOf(viewModel.getSumFKTeamB()));

    }

    private void reset() {
        viewModel.setSumTeamA(0);
        viewModel.setSumTeamB(0);
        viewModel.setSumFKTeamA(0);
        viewModel.setSumFKTeamB(0);
        viewModel.setSumPkTeamA(0);
        viewModel.setSumPkTeamB(0);
        viewModel.setSumPointsA(0);
        viewModel.setSumPointsB(0);
        scoreTeamA.setText(String.valueOf(viewModel.getSumTeamA()));
        scoreTeamB.setText(String.valueOf(viewModel.getSumTeamB()));
        pointTeamA.setText(String.valueOf(viewModel.getSumPointsA()));
        pointTeamB.setText(String.valueOf(viewModel.getSumPointsB()));
        penaltyTeamA.setText(String.valueOf(viewModel.getSumPkTeamA()));
        penaltyTeamB.setText(String.valueOf(viewModel.getSumPkTeamB()));
        freeKickTeamB.setText(String.valueOf(viewModel.getSumFKTeamB()));
        freeKickTeamA.setText(String.valueOf(viewModel.getSumFKTeamB()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.item_exit){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}