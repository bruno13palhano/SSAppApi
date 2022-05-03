package com.bruno13palhano.SSAppApi.controllers;

import com.bruno13palhano.SSAppApi.PlayerLookupService;
import com.bruno13palhano.SSAppApi.model.Player;
import com.bruno13palhano.SSAppApi.repository.PlayerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class PlayerController {
    private PlayerLookupService playerLookupService;
    private PlayerRepository repository;

    PlayerController(PlayerLookupService playerLookupService, PlayerRepository repository){
        this.playerLookupService = playerLookupService;
        this.repository = repository;
    }

    // TODO: 02/05/2022 o problema é a variável ser static

//    DatabaseConfig databaseConfig = new DatabaseConfig();

    @GetMapping("/all")
    public List<Player> getAllPlayer(){
        return repository.getAll();
    }

    @GetMapping("/player/{id}")
    public Player findPlayerById(@PathVariable Long id){
        return repository.findById(id);
    }

    @GetMapping("/delete/{id}")
    public Boolean deletePlayer(@PathVariable Long id){
        return repository.delete(id);
    }

    @PostMapping("/insert")
    public Player insertPlayer(@RequestBody Player player){
        return repository.insert(player);
    }

    @PutMapping("/update")
    public Player update(@RequestBody Player player){
        return repository.update(player);
    }

    @PutMapping("update/score_match")
    public Player updatePlayerScoreMatch(@RequestBody Player player){
        return repository.updateIntegerValues("score_match",
                player.getScoreMatch(),
                player.getId());
    }

    @PutMapping("update/score_series")
    public Player updatePlayerScoreSeries(@RequestBody Player player){
        return repository.updateIntegerValues("score_series",
                player.getScoreSeries(),
                player.getId());
    }

    @PutMapping("update/score_total")
    public Player updatePlayerScoreTotal(@RequestBody Player player){
        return repository.updateIntegerValues("score_total",
                player.getScoreTotal(),
                player.getId());
    }

    @PutMapping("update/number_of_matches")
    public Player updatePlayerScoreNumberOfMatches(@RequestBody Player player){
        return repository.updateIntegerValues("number_of_matches",
                player.getNumberOfMatches(),
                player.getId());
    }

    @PutMapping("update/number_of_wins")
    public Player updatePlayerScoreNumberOfWins(@RequestBody Player player){
        return repository.updateIntegerValues("number_of_wins",
                player.getNumberOfWins(),
                player.getId());
    }

    @PutMapping("update/won_tournaments")
    public Player updatePlayerScoreWonTournaments(@RequestBody Player player){
        return repository.updateIntegerValues("won_tournaments",
                player.getWonTournaments(),
                player.getId());
    }

    //assíncrono
    @GetMapping("/test/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        CompletableFuture<Player> p1;
        if (playerLookupService != null) {
            try {
                p1 = playerLookupService.findPlayer(id);
                return p1.get();

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

        }

        return null;
    }
}
