package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getAnswer(View view) {
        /*
        * Get EditText
        * */
        EditText editText = (EditText) findViewById(R.id.question_01_edit_text);
        Editable answerEdit = editText.getText();
        String answer = "";
        if (answerEdit != null) {
            answer = answerEdit.toString();
        }
        /*
        * Get CheckBox of Question_02
        * */
        CheckBox waston_checkbox = (CheckBox) findViewById(R.id.question_02_waston_check_box);
        boolean waston_isChecked = waston_checkbox.isChecked();
        CheckBox alphago_checkbox = (CheckBox) findViewById(R.id.question_02_alphago_check_box);
        boolean alphago_isChecked = alphago_checkbox.isChecked();
        CheckBox siri_checkbox = (CheckBox) findViewById(R.id.question_02_siri_check_box);
        boolean siri_isChecked = siri_checkbox.isChecked();
        CheckBox now_checkbox = (CheckBox) findViewById(R.id.question_02_now_check_box);
        boolean now_isChecked = now_checkbox.isChecked();
        /*
        * Get CheckBox of Question_03
        * */
        CheckBox dating_checkbox = (CheckBox) findViewById(R.id.question_03_dating_check_box);
        boolean dating_isChecked = dating_checkbox.isChecked();
        CheckBox coding_checkbox = (CheckBox) findViewById(R.id.question_03_coding_check_box);
        boolean coding_isChecked = coding_checkbox.isChecked();
        CheckBox stopcoding_checkbox = (CheckBox) findViewById(R.id.question_03_stopcoding_check_box);
        boolean stopcoding_isChecked = stopcoding_checkbox.isChecked();
        CheckBox eating_checkbox = (CheckBox) findViewById(R.id.question_03_eating_check_box);
        boolean eating_isChecked = eating_checkbox.isChecked();
        /*
        * Get RadioGroup of Question_04
        * */
        RadioGroup radioButton_01 = (RadioGroup) findViewById(R.id.question_04_radio_button);
        int radioButtonId_01 = radioButton_01.getCheckedRadioButtonId();
        RadioButton checkedButton_01 = (RadioButton) MainActivity.this.findViewById(radioButtonId_01);
        /*
        * Get RadioGroup of Question_05
        * */
        RadioGroup radioButton_02 = (RadioGroup) findViewById(R.id.question_05_radio_button);
        int radioButtonId_02 = radioButton_02.getCheckedRadioButtonId();
        RadioButton checkedButton_02 = (RadioButton) MainActivity.this.findViewById(radioButtonId_02);
        judgeQuestionOne(answer);
        judgeQuestionTwo(waston_isChecked, alphago_isChecked, siri_isChecked, now_isChecked);
        judgeQuestionThree(coding_isChecked, dating_isChecked, stopcoding_isChecked, eating_isChecked);
        judgeQuestionFour(checkedButton_01);
        judgeQuestionFive(checkedButton_02);
        showScore();
    }

    private void judgeQuestionOne(String answer) {
        String key = "php";
        if (key.equals(answer.toLowerCase())) {
            score += 20;
        }
    }

    private void judgeQuestionTwo(boolean checkbox_01, boolean checkbox_02, boolean checkbox_03, boolean checkbox_04) {
        if (!checkbox_01) {
            if (checkbox_02) {
                if (!checkbox_03) {
                    if (checkbox_04) {
                        score += 20;
                    }
                }
            }
        }
    }

    private void judgeQuestionThree(boolean checkbox_01, boolean checkbox_02, boolean checkbox_03, boolean checkbox_04) {
        if (!checkbox_01) {
            if (checkbox_02) {
                if (checkbox_03) {
                    if (!checkbox_04) {
                        score += 20;
                    }
                }
            }
        }
    }

    private void judgeQuestionFour(RadioButton radioButton) {
        String text = radioButton.getText().toString().toLowerCase();
        if ("yes".equals(text)) {
            score += 20;
        }
    }

    private void judgeQuestionFive(RadioButton radioButton) {
        String text = radioButton.getText().toString().toLowerCase();
        if ("no".equals(text)) {
            score += 20;
        }
    }

    private void showScore() {
        Toast.makeText(this, "Your score is " + score, Toast.LENGTH_SHORT).show();
        score = 0;
    }

}
