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
}
