package com.bruno13palhano.SSAppApi.repository;

import com.bruno13palhano.SSAppApi.ConnectionFactory;
import com.bruno13palhano.SSAppApi.Utils.PlayerUtil;
import com.bruno13palhano.SSAppApi.model.Player;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerRepository {
    public List<Player> getAll(){
        List<Player> result = new ArrayList<>();
        String SQL_SELECT_ALL = "SELECT * FROM player";

        Connection connection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                result.add(PlayerUtil.instantiatePlayer(resultSet));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    public Player findById(Long id){
        Player result = null;
        String SQL_SELECT =
                "SELECT * FROM player WHERE id = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                result = PlayerUtil.instantiatePlayer(resultSet);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    public Boolean delete(Long id){
        String SQL_DELETE =
                "DELETE FROM player WHERE id = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            return true;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public Player insert(Player player){
        String SQL_INSERT =
                "INSERT INTO player (nickname, email) VALUES (?,?)";

        Connection connection = new ConnectionFactory().getConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, player.getNickname());
            preparedStatement.setString(2, player.getEmail());
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return player;
    }

    public Player update(Player player){
        String SQL_UPDATE =
                "UPDATE player SET nickname = ?, email = ?," +
                        "number_of_matches = ?, score_total = ?, score_match = ?, " +
                        "score_series = ?, number_of_wins = ?, won_tournaments = ? " +
                        "WHERE id = ?";

        Connection connection = new ConnectionFactory().getConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, player.getNickname());
            preparedStatement.setString(2, player.getEmail());
            preparedStatement.setInt(3, player.getNumberOfMatches());
            preparedStatement.setInt(4, player.getScoreTotal());
            preparedStatement.setInt(5, player.getScoreMatch());
            preparedStatement.setInt(6, player.getScoreSeries());
            preparedStatement.setInt(7, player.getNumberOfWins());
            preparedStatement.setInt(8, player.getWonTournaments());
            preparedStatement.setLong(9, player.getId());
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public Player updateIntegerValues(String scoreType, int score, long id){
        String SQL_UPDATE = String.format(
                "UPDATE player SET %s=? WHERE id=?", scoreType);

        Connection connection = new ConnectionFactory().getConnection();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setInt(1, score);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}
