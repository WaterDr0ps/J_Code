package nuist_2.Practice.May.May_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Eliot
 */
public class EmployeeDemo {

    public static int allMoney=0;

    public static void main(String[] args) {
        List<Employee> one=new ArrayList<>();
        one.add(new Employee("张三","男",5000,2000,null));
        one.add(new Employee("李四","男",6670,5000,null));
        one.add(new Employee("王五","男",10000,15000,"迟到"));
        one.add(new Employee("赵六","男",2000,1800,null));

        List<Employee> two=new ArrayList<>();
        two.add(new Employee("猪八戒","男",5000,2000,"偷吃"));
        two.add(new Employee("孙悟空","男",10000,5000,"吵架"));
        two.add(new Employee("唐僧","男",20000,15000,null));
        two.add(new Employee("白龙马","男",3000,500,null));
        two.add(new Employee("铁扇公主","女",25000,10001,null));

        GoodEmployee g1 = one.stream().max(Comparator.comparingInt(s -> s.getSalary() + s.getBonus()))
                .map(s -> new GoodEmployee(s.getName())).get();
        System.out.println(g1);

        GoodEmployee g2 = two.stream().max(Comparator.comparingInt(s -> s.getSalary() + s.getBonus()))
                .map(s -> new GoodEmployee(s.getName())).get();
        System.out.println(g2);

        one.stream().sorted(Comparator.comparingInt(s->s.getSalary()+s.getBonus()))
                .skip(1).limit(one.size()-2).forEach(s->{
                    allMoney+=s.getSalary()+s.getBonus();
                });
        System.out.println("一组平均工资："+allMoney/(one.size()-2));
    }
}
