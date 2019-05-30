package test;

import org.apache.poi.util.StringUtil;

import java.math.BigDecimal;

/**
 * @author hongcq
 * @Description TODO
 * @date 2019/5/27 14:15
 * @ClassName TimeUtil
 */

class test{
    private double x;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
}

public class TimeUtil {

     public static void main(String[] args){
         Integer a = 10;
         test t = new test();
         t.setX(a);
         System.out.println(t.getX());
     }
}
