package com.futai.predict.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.futai.predict.R;
import com.futai.predict.utils.Game;

import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.GameViewHolder> {

    private List<Game> games;

    public GamesAdapter(List<Game> games) {
        this.games = games;
    }

    @Override
    public GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_game, parent, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GameViewHolder holder, int position) {
        Game game = games.get(position);
        holder.tvTeams.setText(game.homeTeam + " vs " + game.awayTeam);
        holder.tvVictory.setText("Vitória: " + game.oddsVictory + "%");
        holder.tvDraw.setText("Empate: " + game.oddsDraw + "%");
        holder.tvOverUnder.setText("Over/Under: " + game.oddsOverUnder + "%");
        holder.tvBothScore.setText("Ambas Marcam: " + game.oddsBothScore + "%");
        holder.tvHomeAway.setText("Casa/Fora: " + game.oddsHomeAway + "%");
        holder.tvHalfTimeFullTime.setText("1º/2º tempo: " + game.oddsHalfTimeFullTime + "%");
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public static class GameViewHolder extends RecyclerView.ViewHolder {

        TextView tvTeams, tvVictory, tvDraw, tvOverUnder, tvBothScore, tvHomeAway, tvHalfTimeFullTime;

        public GameViewHolder(View itemView) {
            super(itemView);
            tvTeams = itemView.findViewById(R.id.tv_teams);
            tvVictory = itemView.findViewById(R.id.tv_victory);
            tvDraw = itemView.findViewById(R.id.tv_draw);
            tvOverUnder = itemView.findViewById(R.id.tv_overunder);
            tvBothScore = itemView.findViewById(R.id.tv_bothscore);
            tvHomeAway = itemView.findViewById(R.id.tv_homeaway);
            tvHalfTimeFullTime = itemView.findViewById(R.id.tv_halftime_fulltime);
        }
    }
}