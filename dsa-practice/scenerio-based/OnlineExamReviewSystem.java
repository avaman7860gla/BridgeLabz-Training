import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Stack;

class User{
    private String UserId;
    private String name;

    // constructor
    public User(String UserId, String name){
        this.UserId=UserId;
        this.name=name;
    }

    // getters
    public String getUserId(){
        return UserId;
    }

    public String getName(){
        return name;
    }

    // login and logout methods
    public void login(){
        System.out.println("Login user: "+getName());
    }
    public void logout(){
        System.out.println("Logout User: "+getName());
    }
}

class Question{
    private int questionId;
    private String text;
    private String correctAnswer;

    // constructor
    public Question(int questionId, String text, String correctAnswer){
        this.questionId=questionId;
        this.text=text;
        this.correctAnswer=correctAnswer;
    }

    // getters
    public int getQuestionId(){
        return questionId;
    }

    public String getQuestion(){
        return text;
    }
    // validate answer
    public boolean validateQuestion(String ans){
        return ans.equals(correctAnswer);
    }
}

class ExamNavigation{
    private Stack<Integer> navigationStack=new Stack<>();

    // visit question
    public void visitQuestion(int questionId){
        navigationStack.push(questionId);
        System.out.println("Visited Question Id: "+questionId);
    }

    // method to get last visit
    public int getLastVisited(){
        if(navigationStack.isEmpty()){
            return -1;
        }
        return navigationStack.peek();
    }

    // go back method
    public int goBack(){
        if(navigationStack.isEmpty()){
            return -1;
        }
        return navigationStack.pop();
    }
}

class AnswerSheet{
    private HashMap<Integer, String> answers=new HashMap<>();

    // save answer
    public void saveAnswer(int qId, String ans){
        answers.put(qId, ans);
        System.out.println("Saved answer for question id: "+qId);
    }

    // method to get answer
    public String getAnswer(int qId){
        return answers.getOrDefault(qId, "No answer saved");
    }

    // display all answers
    public HashMap<Integer, String> getAllAnswers(){
        return answers;
    }
}

interface ScoringLogic{
    public int calculateScore(HashMap<Integer, String> answers, List<Question> questions);
}

class SimpleScoring implements ScoringLogic{
    // each correct answer gives 1 score
    public int calculateScore(HashMap<Integer, String> answers, List<Question> questions){
        int score=0;
        for(Question q:questions){
            String ans=answers.get(q.getQuestionId());
            if(ans!=null && q.validateQuestion(ans)){
                score+=1;
            }
        }
        return score;
    }
}

class ExamProctor{
    private User user;
    private List<Question> questions;
    private ExamNavigation navigation;
    private AnswerSheet answerSheet;
    private ScoringLogic scoring;

    // constructor
    public ExamProctor(User user, List<Question> questions, ScoringLogic scoring){
        this.user=user;
        this.questions=questions;
        this.scoring=scoring;
        this.navigation=new ExamNavigation();
        this.answerSheet=new AnswerSheet();
    }

    // method to start exam
    public void startExam(){
        user.login();
        System.out.println("Exam started: "+user.getName());
    }

    // method to answer questions
    public void answerQuestion(int qId, String ans){
        answerSheet.saveAnswer(qId, ans);
        navigation.visitQuestion(qId);
    }

    // to submit exam
    public int submitExam(){
        int score=scoring.calculateScore(answerSheet.getAllAnswers(), questions);
        return score;
    }

    // to show result
    public void showResult(){
        int score=submitExam();
        System.out.println("Exam submitted. Score: "+score+"/"+questions.size());
        user.logout();
    }
}

public class OnlineExamReviewSystem {
    public static void main(String[] args) {
        // user
        User u1 = new User("U101", "Aman"); 
        // create questions 
        List<Question> questions = new ArrayList<>(); 
        questions.add(new Question(1, "What is 2+2?", "4")); 
        questions.add(new Question(2, "Capital of India?", "Delhi")); 
        questions.add(new Question(3, "Java keyword for inheritance?", "extends"));
        // create ExamProctor with simple scoring 
        ExamProctor exam = new ExamProctor(u1, questions, new SimpleScoring()); 
        // start exam 
        exam.startExam(); 
        // answer questions 
        exam.answerQuestion(1, "4"); 
        exam.answerQuestion(2, "Delhi"); 
        exam.answerQuestion(3, "implements"); // wrong intentionally
        //submit and show result 
        exam.showResult();
    }    
}
