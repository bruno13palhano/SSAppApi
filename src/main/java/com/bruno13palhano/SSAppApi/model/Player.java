package com.bruno13palhano.SSAppApi.model;

public class Player {
    private long id;
    private String nickname;
    private String email;
    private int scoreTotal;
    private int scoreSeries;
    private int scoreMatch;
    private int numberOfWins;
    private int numberOfMatches;
    private int wonTournaments;

    public void setId(long id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public int getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(int scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    public int getScoreSeries() {
        return scoreSeries;
    }

    public void setScoreSeries(int scoreSeries) {
        this.scoreSeries = scoreSeries;
    }

    public int getScoreMatch() {
        return scoreMatch;
    }

    public void setScoreMatch(int scoreMatch) {
        this.scoreMatch = scoreMatch;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public void setNumberOfMatches(int numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

    public int getWonTournaments() {
        return wonTournaments;
    }

    public void setWonTournaments(int wonTournaments) {
        this.wonTournaments = wonTournaments;
    }

    @Override
    public String toString(){
        return  "id: "+id+"\n"+
                "nickname: "+nickname+"\n"+
                "email: "+email+"\n"+
                "score_match: "+scoreMatch+"\n"+
                "score_series: "+scoreSeries+"\n"+
                "score_total: "+scoreTotal+"\n"+
                "number_of_matches: "+numberOfMatches+"\n"+
                "number_of_wins: "+numberOfWins+"\n"+
                "won_tournaments: "+wonTournaments+"\n";
    }
}
