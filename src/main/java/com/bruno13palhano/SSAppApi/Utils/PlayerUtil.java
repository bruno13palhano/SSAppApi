package com.bruno13palhano.SSAppApi.Utils;

import com.bruno13palhano.SSAppApi.model.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerUtil {
    public static Player instantiatePlayer(ResultSet resultSet){
        Player player = new Player();

        try{
            player.setId(resultSet.getLong("id"));
            player.setNickname(resultSet.getString("nickname"));
            player.setEmail(resultSet.getString("email"));
            player.setScoreMatch(resultSet.getInt("score_match"));
            player.setScoreSeries(resultSet.getInt("score_series"));
            player.setScoreTotal(resultSet.getInt("score_total"));
            player.setNumberOfMatches(resultSet.getInt("number_of_matches"));
            player.setNumberOfWins(resultSet.getInt("number_of_wins"));
            player.setWonTournaments(resultSet.getInt("won_tournaments"));

        }catch (NullPointerException | SQLException ignored){}

        return player;
    }
}
