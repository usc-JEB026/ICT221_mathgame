package au.edu.usc.mathgame;
public class HighScores {
    public int currentHighScore;

    public HighScores(){
        this.currentHighScore=0;
    }
    public int checkHighScore(int newScore){
        if (newScore > this.currentHighScore){
            this.currentHighScore = newScore;
        }
        return this.currentHighScore;
    }
}
