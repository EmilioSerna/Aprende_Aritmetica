package com.emilioserna.aprendearitmtica;

import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainFragment extends Fragment implements View.OnClickListener {
    private Button mSumButton;
    private Button mSubButton;
    private Button mMulButton;
    private Button mDivButton;
    private Button mQuitButton;

    public static int grade = 0;
    public static int nums[] = new int[8];

    public static boolean answered[] = {true, true, true, true};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_title, container, false);

        mSumButton = (Button) v.findViewById(R.id.button_sum);
        mSubButton = (Button) v.findViewById(R.id.button_sub);
        mMulButton = (Button) v.findViewById(R.id.button_mul);
        mDivButton = (Button) v.findViewById(R.id.button_div);
        mQuitButton = (Button) v.findViewById(R.id.button_quit);

        mSumButton.setOnClickListener(this);
        mSubButton.setOnClickListener(this);
        mMulButton.setOnClickListener(this);
        mDivButton.setOnClickListener(this);
        mQuitButton.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;

        switch (v.getId()) {
            case R.id.button_sum:
                fragment = new SumFragment();
                break;
            case R.id.button_sub:
                fragment = new SubFragment();
                break;
            case R.id.button_mul:
                fragment = new MulFragment();
                break;
            case R.id.button_div:
                fragment = new DivFragment();
                break;
            case R.id.button_quit:
                getActivity().finish();
                System.exit(0);
                break;

        }

        replaceFragment(fragment);
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public static TextView setText(View v, int id, int rString) {
        TextView mText;
        mText = v.findViewById(id);
        mText.setText(rString);
        return mText;
    }

    public static TextView setText(View v, int id, String text) {
        TextView mText;
        mText = v.findViewById(id);
        mText.setText(text);
        return mText;
    }

    public TextView setText(View v, int id, int rString, String text) {
        TextView mText;
        mText = v.findViewById(id);
        text = MainActivity.context.getResources().getString(rString) + " " + text;
        mText.setText(text);
        return mText;
    }

    static void randomize(int indexAnswer, int indexNum1, int indexNum2) {
        if (answered[indexAnswer]) {
            nums[indexNum1] = Random.getRandomNumber();
            nums[indexNum2] = Random.getRandomNumber();

            if (indexAnswer == 3) {
                while (Double.valueOf(nums[indexNum1]) / Double.valueOf(nums[indexNum2]) % 1 != 0) {
                    nums[indexNum1] = Random.getRandomNumber();
                    nums[indexNum2] = Random.getRandomNumber();
                }
            }
            answered[indexAnswer] = false;
        }
    }

    public static void setRandomizedText(View v, int indexAnswer, int indexNum1, int indexNum2) {
        // Randomizes numbers
        randomize(indexAnswer, indexNum1, indexNum2);

        // Set Text on both numbers
        setText(v, R.id.num_1_text, String.valueOf(nums[indexNum1]));
        setText(v, R.id.num_2_text, String.valueOf(nums[indexNum2]));
    }

    public void answer(int indexAnswer, TextView answerText, int indexNum1, int indexNum2, String operator, View v) {
        answered[indexAnswer] = true;

        if (answerText.length() > 0) {
            int answer = Integer.valueOf(answerText.getText().toString());
            int result = nums[indexNum1] + nums[indexNum2];
            if (result == answer) {
                grade += 10;
                Toast.makeText(MainActivity.context, R.string.correct_answer, Toast.LENGTH_SHORT).show();

                // Set grade
                setText(v, R.id.grade_text, R.string.grade, String.valueOf(grade));
            } else {
                Toast.makeText(MainActivity.context, R.string.incorrect_answer, Toast.LENGTH_SHORT).show();
            }

            // Set correct answer
            setText(v, R.id.answer_text, String.valueOf(result));

            //Randomize numbers
            setRandomizedText(v, indexAnswer, indexNum1, indexNum2);

        } else {
            Toast.makeText(MainActivity.context, R.string.answer_required, Toast.LENGTH_SHORT).show();
        }
    }
}
