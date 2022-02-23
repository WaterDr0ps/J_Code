package nuist_2.Practice.Exception;

public class Teacher {
    public void getScore(int score) throws ScoreException{

            if(score<0||score>100){
                throw new ScoreException("输入的成绩有误");
            }else{
                System.out.println("分数正常");
            }

    }
}
