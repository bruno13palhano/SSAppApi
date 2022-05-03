package com.bruno13palhano.SSAppApi;

import com.bruno13palhano.SSAppApi.Utils.PlayerUtil;
import com.bruno13palhano.SSAppApi.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.CompletableFuture;

@Service
public class PlayerLookupService {
    private static final Logger logger =
            LoggerFactory.getLogger(PlayerLookupService.class);

    @Async
    public CompletableFuture<Player> findPlayer(Long playerId) throws InterruptedException{
        Player result = null;
        String SQL_SELECT = "SELECT * FROM player";

        try{
            Connection conn = new ConnectionFactory().getConnection();

            PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                if (playerId == resultSet.getLong("player_id")) {
                    result = PlayerUtil.instantiatePlayer(resultSet);
                    break;
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        //fake daley
        Thread.sleep(1000L);

        return CompletableFuture.completedFuture(result);
    }
}
