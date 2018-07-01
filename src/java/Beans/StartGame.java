package Beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StartGame {

    private ArrayList<Question> questions;

    public StartGame() {
        questions = new ArrayList<>();

//        questions.add(new Question(
//                1,
//                100,
//                "What is the only manmade object that is observable from moon",
//                new String[]{"Tesla", "India", "China Great Wall", "India"},
//                "China Great Wall",
//                "false"));
//        questions.add(new Question(
//                2,
//                200,
//                "What is most popular drink in world without alcohol",
//                new String[]{"Tea", "Coke", "Beer", "Coffee"},
//                "Coffee",
//                "false"));
//        questions.add(new Question(
//                3,
//                300,
//                "Which is the largest planet in solar system",
//                new String[]{"Moon", "Earth", "Pluto", "Jupiter"},
//                "Jupiter",
//                "false"));
//        questions.add(new Question(
//                4,
//                400,
//                "What is another name for superman",
//                new String[]{"Man of Steel", "Masked Avenger", "Not Batman", "Red Redeemer"},
//                "Man of Steel",
//                "false"));
//        questions.add(new Question(
//                5,
//                500,
//                "Batman protects which city",
//                new String[]{"Chicago", "Metropolis", "Gotham", "New York City"},
//                "Gotham",
//                "false"));
//
//        questions.add(new Question(
//                6,
//                100,
//                "How many colours are there in a rainbow",
//                new String[]{"Seven", "7", "11", "3"},
//                "7",
//                "false"));
//        questions.add(new Question(
//                7,
//                200,
//                "What do you call a time span of one thousand years",
//                new String[]{"Decade", "1000 years", "Millennium", "Century"},
//                "Millennium",
//                "false"));
//        questions.add(new Question(
//                8,
//                300,
//                "Which fictional character lived at 221b Baker Street",
//                new String[]{"Flash", "Goku", "Iron Man", "Sherlock Holmes"},
//                "Sherlock Holmes",
//                "false"));
//        questions.add(new Question(
//                9,
//                400,
//                "How fast can a honey bee fly",
//                new String[]{"Speed of Light", "8MPH", "15 MPH", "1 MPH"},
//                "15 MPH",
//                "false"));
//        questions.add(new Question(
//                10,
//                500,
//                "Which is only country to have played in every Football World Cup",
//                new String[]{"Portugal", "Brazil", "Italy", "Spain"},
//                "Brazil",
//                "false"));
    }

    public ArrayList<Question> getQuestions() throws ClassNotFoundException, SQLException {
        QuestionDB q = new QuestionDB();
        return q.getAllQuestions();
    }

    public ArrayList<Question> populateQueries() throws ClassNotFoundException, SQLException {
        return questions;
    }

//    public ArrayList<Question> getQuestions() throws ClassNotFoundException, SQLException {
//        questions = new ArrayList<>();
//
//        QuestionDB qdb = new QuestionDB();
//        ResultSet r = qdb.getAllQuestions();
//
//        while (r.next()) {
//            Question q = new Question(
//                    r.getString(2),
//                    qdb.lineInArray(r.getString(3)),
//                    r.getString(4),
//                    Integer.parseInt(r.getString(5))
//            );
//            questions.add(q);
//            r.next();
//        }
//
//        return questions;
//    }
}
