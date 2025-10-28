package com.futai.predict.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.futai.predict.R;
import com.futai.predict.utils.ApiClient;

import java.util.List;

public class TodayFragment extends Fragment {

    RecyclerView recyclerView;
    GamesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_today, container, false);
        recyclerView = view.findViewById(R.id.recycler_today);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Obter jogos reais do dia
        ApiClient apiClient = new ApiClient();
        apiClient.getGames("today", games -> {
            // games é a lista de jogos com todos os mercados
            adapter = new GamesAdapter(games);
            recyclerView.setAdapter(adapter);
        });

        return view;
    }
}