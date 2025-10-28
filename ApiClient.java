package com.futai.predict.utils;

import android.os.AsyncTask;
import java.util.List;
import java.util.ArrayList;

// Interface de callback
interface GamesCallback {
    void onResult(List<Game> games);
}

public class ApiClient {

    private static final String API_KEY = "COLOQUE_SUA_CHAVE_API_FOOTBALL_AQUI";

    public void getGames(String day, GamesCallback callback) {
        new AsyncTask<Void, Void, List<Game>>() {
            @Override
            protected List<Game> doInBackground(Void... voids) {
                List<Game> games = new ArrayList<>();

                // Aqui você implementaria a chamada real à API-Football
                // Caso não haja resposta, pode gerar previsões simuladas
                // Percentuais variando de 1% a 100%

                for (int i = 1; i <= 5; i++) { // Simulação de 5 jogos
                    Game game = new Game();
                    game.homeTeam = "Time A" + i;
                    game.awayTeam = "Time B" + i;
                    game.oddsVictory = (int)(Math.random() * 100) + 1;
                    game.oddsDraw = (int)(Math.random() * 100) + 1;
                    game.oddsOverUnder = (int)(Math.random() * 100) + 1;
                    game.oddsBothScore = (int)(Math.random() * 100) + 1;
                    game.oddsHomeAway = (int)(Math.random() * 100) + 1;
                    game.oddsHalfTimeFullTime = (int)(Math.random() * 100) + 1;
                    games.add(game);
                }

                return games;
            }

            @Override
            protected void onPostExecute(List<Game> games) {
                callback.onResult(games);
            }
        }.execute();
    }
}