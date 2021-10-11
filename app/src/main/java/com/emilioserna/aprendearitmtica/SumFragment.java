package com.emilioserna.aprendearitmtica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class SumFragment extends Fragment {

    private int indexAnswer = 0;
    private int indexNum1 = 0;
    private int indexNum2 = 1;
    private int answer;
    private Button mBackButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_operation, container, false);
        answer = MainFragment.nums[0] + MainFragment.nums[1];

        // Set Title
        MainFragment.setText(v, R.id.title_text, R.string.option_sum);

        // Set Operator
        MainFragment.setText(v, R.id.operator_text, "+");

        // Randomizes numbers
        MainFragment.randomize(indexAnswer, indexNum1, indexNum2);

        // Set Text on both numbers
        MainFragment.setText(v, R.id.num_1_text, String.valueOf(MainFragment.nums[0]));
        MainFragment.setText(v, R.id.num_2_text, String.valueOf(MainFragment.nums[1]));

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

        return v;
    }
}
