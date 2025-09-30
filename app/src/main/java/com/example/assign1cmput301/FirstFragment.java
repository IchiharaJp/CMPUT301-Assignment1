package com.example.assign1cmput301;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.assign1cmput301.databinding.FragmentFirstBinding;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
//    private ArrayList<String> logData = new ArrayList<>();
    private static Log log = new Log();
    private int[] btnIDs = {R.id.happyBtn, R.id.sadBtn, R.id.angryBtn, R.id.boredBtn,
        R.id.surprisedBtn, R.id.excitedBtn};

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.logBtn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FirstFragmentDirections.ActionFirstFragmentToSecondFragment action =
                            FirstFragmentDirections.actionFirstFragmentToSecondFragment(log.getLog());
                    NavHostFragment.findNavController(FirstFragment.this).navigate(action);
                }
        });

        for (int i = 0; i < btnIDs.length; i++) {
            int id = btnIDs[i];
            Button btn = view.findViewById(id);
            String type = btn.getText().toString();

            EmoticonBTN emotionBtn = new EmoticonBTN(type);

            view.findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast t = Toast.makeText(getActivity(), emotionBtn.getEmotionText(), Toast.LENGTH_SHORT);
                    t.show();
                    log.addData(emotionBtn.getEmotionData());
                }
            });
        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}