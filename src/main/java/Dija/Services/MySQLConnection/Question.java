package Dija.Services.MySQLConnection;

public class Question {
    private String ques;
    private String ansA;
    private String ansB;
    private String ansC;
    private String ansD;
    private String answer;

    public Question(String ques, String a, String b, String c, String d, String ans) {
        this.ques = ques;
        ansA = a;
        ansB = b;
        ansC = c;
        ansD = d;
        answer = ans;
    }

    public String getAnsA() {
        return ansA;
    }

    public String getAnsB() {
        return ansB;
    }

    public String getAnsC() {
        return ansC;
    }

    public String getAnsD() {
        return ansD;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQues() {
        return ques;
    }

    public void setAnsA(String ansA) {
        this.ansA = ansA;
    }

    public void setAnsB(String ansB) {
        this.ansB = ansB;
    }

    public void setAnsC(String ansC) {
        this.ansC = ansC;
    }

    public void setAnsD(String ansD) {
        this.ansD = ansD;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }
}
