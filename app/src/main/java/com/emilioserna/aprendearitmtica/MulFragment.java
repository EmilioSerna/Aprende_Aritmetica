package com.emilioserna.aprendearitmtica;

import static com.emilioserna.aprendearitmtica.MainFragment.answered;
import static com.emilioserna.aprendearitmtica.MainFragment.grade;
import static com.emilioserna.aprendearitmtica.MainFragment.nums;
import static com.emilioserna.aprendearitmtica.MainFragment.setRandomizedText;
import static com.emilioserna.aprendearitmtica.MainFragment.setText;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MulFragment extends Fragment {

    private int indexAnswer = 2;
    private int indexNum1 = 4;
    private int indexNum2 = 5;
    private int result;             // this is the CORRECT result
    private int answer = 0;         // this is the GIVEN answer from the user
    private Button mBackButton;
    private Button mAcceptButton;
    private String operator = "x";
    private int rStringOption = R.string.option_mul;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_operation, container, false);

        TextView answerText = (TextView) v.findViewById(R.id.answer_edit);

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
