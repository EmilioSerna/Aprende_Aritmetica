package com.emilioserna.aprendearitmtica;

import static com.emilioserna.aprendearitmtica.MainFragment.grade;
import static com.emilioserna.aprendearitmtica.MainFragment.setRandomizedText;
import static com.emilioserna.aprendearitmtica.MainFragment.setText;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SumFragment extends Fragment {

    private int indexAnswer = 0;
    private int indexNum1 = 0;
    private int indexNum2 = 1;
    private Button mBackButton;
    private Button mAcceptButton;
    private String operator = "+";
    private int rStringOption = R.string.option_sum;
    private TextView answerText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_operation, container, false);

        answerText = (TextView) v.findViewById(R.id.answer_edit);

        // Set grade
        setText(v, R.id.grade_text, getResources().getString(R.string.grade) + " " + grade);

        // Set Title
        setText(v, R.id.title_text, rStringOption);

        // Set Operator
        setText(v, R.id.operator_text, operator);

        // Randomize numbers
        setRandomizedText(v, indexAnswer, indexNum1, indexNum2);

        mBackButton = (Button) v.findViewById(R.id.back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        answerText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                        new MainFragment().answer(indexAnswer, answerText, indexNum1, indexNum2, operator, v);
                        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    }
                }

                return false;
            }
        });

        mAcceptButton = (Button) v.findViewById(R.id.accept_button);
        mAcceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MainFragment().answer(indexAnswer, answerText, indexNum1, indexNum2, operator, v);
            }
        });

        return v;
    }
}
