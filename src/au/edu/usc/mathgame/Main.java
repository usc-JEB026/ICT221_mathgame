package au.edu.usc.mathgame;

import java.util.Random;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Random;
/**
 * A simple console-based maths quiz for primary school children.
 *
 * @author Jordan Baird
 *
 */
public class Main {
    private int score = 0;
    private Random rn = new Random();
    private Scanner input = new Scanner(System.in);
    private HighScores hs = new HighScores();

    public static void main(String[] args) {
        Main main = new Main();
        main.playMultipleGames();
    }

    public void playMultipleGames(){
        System.out.println("Welcome to this math game! I hope you have fun playing this game while learning maths.");
        System.out.println("Are you ready to play (y or n)?");
        String keepPlaying = input.next();
        while (keepPlaying.equals("y")){
            this.playGame();
            System.out.println("Would you like to play again (y or n)?");
            keepPlaying = input.next();
        }
    }

    public void playGame(){
        score = 0;
        for (int i = 0; i < 10; i++) {
            int i1 = rn.nextInt(10)+1;
            int i2 = rn.nextInt(10)+1;
            Question q = new Question(i1, i2, generateOperator());
            q.showQuestion();
            double response = input.nextDouble();
            boolean correct = q.checkAnswer(response);

            if (correct) {
                System.out.println("Congratulations your answer is correct");
                score++;
            } else {
                System.out.println("Your answer was wrong, better luck with the next question. The answer was " + q.correct + ".");
            }
        }
        System.out.println("Your score was " + score + " out of 10");
        if (score <=4) {
            System.out.println("Good start, Can you practice to improve your score?");
        } else if (score >= 8) {
            System.out.println("Superb! - Congratulations on your result");
        } else {
            System.out.println("Good Job! - Better luck in your next quiz");
        }
        System.out.println("Your new high score is " + hs.checkHighScore(score));
    }

    public String generateOperator(){
        Random rn = new Random();
        int questionType = rn.nextInt(4);
        String s;
        if (questionType == 1) {
            s = "+";
        } else if (questionType == 2) {
            s = "-";
        } else if (questionType == 3) {
            s = "/";
        } else {
            s = "*";
        }
        return s;
    }
}
