package com.example.lq;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class quiz_js extends AppCompatActivity {


    private TextView tvQuestion,tvScore ,tvQuestionNo,tvTimer;
    private RadioGroup radioGroup;
    private RadioButton rb1,rb2,rb3,rb4;
    private Button btnNext;

    int totalQuestions;
    int qCounter = 0;
    int score = 0;


    ColorStateList dfRbColor;
    boolean answered;
    CountDownTimer countDownTimer;



    private  QuestionModel  currentQuestion;



    private List<QuestionModel> questionsList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_js);

        questionsList = new ArrayList<>();

        tvQuestion =findViewById(R.id.textQuestion);
        tvScore =findViewById(R.id.textScore);
        tvQuestionNo=findViewById(R.id.textQuestionNo);
        tvTimer=findViewById(R.id.texttimer);


        radioGroup =findViewById(R.id.radioGroup);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);
        rb4=findViewById(R.id.rb4);
        btnNext=findViewById(R.id.btnNext);

        dfRbColor =rb1.getTextColors();



        addQuestions();
        totalQuestions = questionsList.size();
        showNextQuestion();


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answered == false) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                        checkAnswer();
                        countDownTimer.cancel();
                    } else {
                        Toast.makeText(quiz_js.this, "Please Select an option ", Toast.LENGTH_SHORT).show();
                    }
                }
                    else{
                        showNextQuestion();
                    }

                }

        });


    }

    private void checkAnswer() {
        answered = true;
        RadioButton rbSelected =findViewById(radioGroup.getCheckedRadioButtonId());

        int answerNo = radioGroup.indexOfChild(rbSelected) +1;
        if(answerNo == currentQuestion.getCorrectAnsNo()){
            score++;
            tvScore.setText("Score:  "+score);


        }
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);

        switch (currentQuestion.getCorrectAnsNo()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;

            case 2:
                rb2.setTextColor(Color.GREEN);
                break;

            case 3:
                rb3.setTextColor(Color.GREEN);
                break;

            case 4:
                rb4.setTextColor(Color.GREEN);
                break;




        }
        if(qCounter <totalQuestions){
            btnNext.setText("Next");
        }else {
            btnNext.setText("Finish");
        }
    }

    private void showNextQuestion() {

        radioGroup.clearCheck();
        rb1.setTextColor(dfRbColor);
        rb2.setTextColor(dfRbColor);
        rb3.setTextColor(dfRbColor);
        rb4.setTextColor(dfRbColor);

        if(qCounter < totalQuestions){
            timer();

            currentQuestion =questionsList.get(qCounter);
            tvQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());


            qCounter++;
            btnNext.setText("Submit");
            tvQuestionNo.setText("Question: "+qCounter+"/"+totalQuestions);
            answered= false;

        }else{


            finish();
        }


    }

    private void timer() {
        countDownTimer = new CountDownTimer(20000,1000) {
//            @Override
//            public void onTick(Long millisUntilFinished ) {
//                tvTimer.setText("00:" + millisUntilFinished/1000);
//
//            }

            @Override
            public void onTick(long millisUntilFinished) {
               tvTimer.setText( "00: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                showNextQuestion();

            }
        }.start();
    }


    private void addQuestions() {
        questionsList.add(new QuestionModel("1. java  langauge is ?","web","R","C","programing",4));
        questionsList.add(new QuestionModel("2. Which component is used to compile, debug and execute the java programs ?"," JRE","JIT","JDK","JDI",3));
        questionsList.add(new QuestionModel("3. Which one of the following is not a Java feature ?"," Object-oriented"," Use of pointers"," Portable","Dynamic and Extensible",2));
        questionsList.add(new QuestionModel("4. What will be the output of the following Java code? " +
                "class increment {\n" +
                "        public static void main(String args[]) \n" +
                "        {        \n" +
                "             int g = 3;\n" +
                "             System.out.print(++g * 8);\n" +
                "        } \n" +
                "    }",".32","33","24","25",1));

        questionsList.add(new QuestionModel("5. java  langauge is ?","web","R","C","programing",4));
        questionsList.add(new QuestionModel("6. java  langauge is ?","web","R","C","programing",4));
        questionsList.add(new QuestionModel("7. java  langauge is ?","web","R","C","programing",4));
        questionsList.add(new QuestionModel("8. java  langauge is ?","web","R","C","programing",4));
        questionsList.add(new QuestionModel("9. java  langauge is ?","web","R","C","programing",4));
        questionsList.add(new QuestionModel("10. java  langauge is ?","web","R","C","programing",4));
        questionsList.add(new QuestionModel("11. java  langauge is ?","web","R","C","programing",4));
        questionsList.add(new QuestionModel("12. java  langauge is ?","web","R","C","programing",4));
        questionsList.add(new QuestionModel("13. java  langauge is ?","web","R","C","programing",4));
    }


    }
