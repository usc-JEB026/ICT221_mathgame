package au.edu.usc.mathgame;

public class Question {
    double value1, value2;
    String operator;
    double correct;

    public Question(int i, int i1, String s) {
        this.value1 = i;
        this.value2 = i1;
        this.operator = s;
        String questionType = s;
        if (questionType == "+") {
            this.correct = this.value1 + this.value2;
        }
        else if (questionType == "-") {
            orderValues();
            this.correct = this.value1 - this.value2;
        }
        else if (questionType == "*") {
            this.correct = this.value1 * this.value2;
        }
        else {
            orderValues();
            this.correct = Math.round((this.value1 / this.value2)  * 10.0) / 10.0;
        }
    }
    public void showQuestion() {
        System.out.println("What is " + (int)this.value1 + this.operator + (int)this.value2 + "?");
    }
    public boolean checkAnswer(double answer) {
        {
            return answer==this.correct;
        }
    }
    void orderValues(){
        if (this.value1 < this.value2) {
            double temp = this.value1;
            this.value1 = this.value2;
            this.value2 = temp;
        }
    }
}

