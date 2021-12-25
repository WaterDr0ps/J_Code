package Homework;

public class work_2 {
    public static void main(String[] args) {
        double[][] revenues= {
                {56.4, 69.4, 67.2, 65.6, 65.2, 64.4, 66.7, 67.4, 70.2, 70.4, 78.7, 79.4},
                {76.2, 88.3, 87.5, 90.2, 85.9, 78.0, 88.4, 89.2, 88.4, 86.9, 86.3,90.4},
                {95.3, 94.5, 90.2, 95.0, 97.2, 97.1, 95.1, 90.2, 95.3, 98.2, 92.3, 95.9}
        };
        double[] avg=average_Sales(revenues);
        System.out.println(max_AverageSales(avg));
        double[] mergeSales=merge_Sales(revenues);
        count_Months(mergeSales);
        System.out.println(get_Sales(2001,11,revenues));
        find_maxYearMonth(mergeSales,revenues);
    }

    //平均销售额
    public static double[] average_Sales(double[][] revenues){
        double[] arr=new double[3];
        double count=0;
        for(int i=0;i< revenues.length;i++){
            for(int j=0;j<revenues[i].length;j++){
                count+=revenues[i][j];
            }
            arr[i]=count/revenues[i].length;
        }
        return arr;
    }

    //最大平均销售额年份
    public static int max_AverageSales(double[] avg){
        return avg[0]>avg[1]?avg[0]>avg[2]?2000:2002:avg[1]>avg[2]?2001:2002;
    }

    //三个年度销售额
    public static double[] merge_Sales(double[][] revenues){
        double[] sales=new double[revenues.length*revenues[0].length];
        int index=0;
        for(int i=0;i<revenues.length;i++){
            for(int j=0;j<revenues[i].length;j++){
                sales[index++]=revenues[i][j];
            }
        }
        return sales;
    }

    //统计销售额段月份数
    public static void count_Months(double[] sales){
        int s_5060=0,s_6070=0,s_7080=0,s_8090=0,s_90100=0;
        for(int i=0;i<sales.length;i++){
            if(sales[i]<60){
                s_5060++;
            }else if(sales[i]<70){
                s_6070++;
            }else if(sales[i]<80){
                s_7080++;
            }else if(sales[i]<90){
                s_8090++;
            }else if(sales[i]<100){
                s_90100++;
            }
        }
        System.out.println("50-60总共"+s_5060+"个月"+",60-70总共"+s_6070+"个月"+",70-80总共"+s_7080+"个月"+",80-90总共"+s_8090+"个月"+",90-100总共"+s_90100+"个月");
    }

    //给定年份和月份，获取销售额
    public static double get_Sales(int year,int month,double revenues[][]){
        return revenues[year-2000][month];
    }

    //查找最大销售额年份月份
    public static void find_maxYearMonth(double[] sales,double[][] revenues){
        double max=0;
        for(int i=0;i<sales.length;i++){
            if(sales[i]>max){
                max=sales[i];
            }
        }
        for(int i=0;i<revenues.length;i++){
            for(int j=0;j<revenues[i].length;j++){
                if(revenues[i][j]==max){
                    System.out.printf("最大销售额为：%.1f,%d年%d月",max,i+2000,j);
                    return;
                }
            }
        }
    }
}
