package com.example.demo.composite;

/**
 * 组合模式
 */
public class Client {
    public static void main(String[] args) {
        University major1 = new Major("软件工程","Java专业不错");
        University major2 = new Major("网络工程","网络专业不错");
        University major3 = new Major("男护","都是男的");
        University major4 = new Major("女护","都是女的");

        University college1 = new College("软件学院","一个it男");
        University college2 = new College("护理学院","女生多的学院");
        college1.add(major1);
        college1.add(major2);
        college2.add(major3);
        college2.add(major4);

        University heNanUniversity =  new HeNanUniversity("河南大学","一个怀念的学校");
        heNanUniversity.add(college1);
        heNanUniversity.add(college2);

        heNanUniversity.outPut();




    }
}
