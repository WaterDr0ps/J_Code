package nuist_2.Practice.Exception;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入学生成绩：");
        int score = sc.nextInt();
        Teacher t=new Teacher();
        try {
            t.getScore(score);
        } catch (ScoreException e) {
            e.printStackTrace();
        }
    }
}
