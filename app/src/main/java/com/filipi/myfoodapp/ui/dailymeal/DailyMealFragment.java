package com.filipi.myfoodapp.ui.dailymeal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.filipi.myfoodapp.R;
import com.filipi.myfoodapp.adapters.DailyMealAdapter;
import com.filipi.myfoodapp.databinding.DailyMealFragmentBinding;
import com.filipi.myfoodapp.models.DailyMealModel;

import java.util.ArrayList;
import java.util.List;


public class DailyMealFragment extends Fragment {

    RecyclerView recyclerView;
    List<DailyMealModel> dailyMealModels;
    DailyMealAdapter dailyMealAdapter;

    private DailyMealFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = DailyMealFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerView = root.findViewById(R.id.daily_meal_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dailyMealModels = new ArrayList<>();

        dailyMealModels.add(new DailyMealModel(R.drawable.breakfast,"Breakfast","30% OFF","Description","breakfast"));
        dailyMealModels.add(new DailyMealModel(R.drawable.lunch,"Lunch","20% OFF","Description","lunch"));
        dailyMealModels.add(new DailyMealModel(R.drawable.dinner,"Dinner","50% OFF","Description","dinner"));
        dailyMealModels.add(new DailyMealModel(R.drawable.sweets,"Sweets","39% OFF","Description","sweets"));
        dailyMealModels.add(new DailyMealModel(R.drawable.coffe,"Coffee","20% OFF","Description","coffee"));

        dailyMealAdapter = new DailyMealAdapter(getContext(),dailyMealModels);
        recyclerView.setAdapter(dailyMealAdapter);
        dailyMealAdapter.notifyDataSetChanged();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}