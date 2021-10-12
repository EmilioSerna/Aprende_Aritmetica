package com.emilioserna.aprendearitmtica;

import static com.emilioserna.aprendearitmtica.MainFragment.answered;
import static com.emilioserna.aprendearitmtica.MainFragment.grade;
import static com.emilioserna.aprendearitmtica.MainFragment.nums;
import static com.emilioserna.aprendearitmtica.MainFragment.setRandomizedText;
import static com.emilioserna.aprendearitmtica.MainFragment.setText;
import com.emilioserna.aprendearitmtica.MainFragment;

import android.os.Bundle;
import android.view.KeyEvent;
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

public class SumFragment extends Fragment {

    private int indexAnswer = 0;
    private int indexNum1 = 0;
    private int indexNum2 = 1;
    private int result;             // this is the CORRECT result
    private int answer = 0;         // this is the GIVEN answer from the user
    protected Button mBackButton;
    protected Button mAcceptButton;
    protected String operator = "+";
    protected int rStringOption = R.string.option_sum;
    protected static TextView answerText;

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
                Fragment fragment = new MainFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
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
