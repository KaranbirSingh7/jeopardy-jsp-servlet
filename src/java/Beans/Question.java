package Beans;

public class Question implements java.io.Serializable {

    private int questionNumber;
    private int amount;
    private String question;
    private String[] options;
    private String answer;
    private String questionState;

    public Question() {
        this(0, 0, "", new String[]{}, "", "");
    }

    public Question(String ques, String[] options, String answer, int amount) {
        this.question = ques;
        this.options = options;
        this.answer = answer;
        this.amount = amount;
    }

    public Question(int qNumber, String ques, String[] options, String answer, int amount) {
        this.questionNumber = qNumber;
        this.question = ques;
        this.options = options;
        this.answer = answer;
        this.amount = amount;
    }

    public Question(int qNumber, int a, String q, String[] op, String ans, String stat) {
        this.questionNumber = qNumber;
        this.amount = a;
        this.question = q;
        this.options = op;
        this.answer = ans;
        this.questionState = stat;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestionState() {
        return questionState;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setQuestionState(String questionState) {
        this.questionState = questionState;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

}
