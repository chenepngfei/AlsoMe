package com.AlsoMe.commons.enums;


import java.util.ArrayList;
import java.util.List;

/**
 * 抑郁自评
 */
public enum DepressionPerformanceEnums {
    ONE(1, "你的抑郁得分显示无抑郁。表示你现在的心情稳定，心理相对健康，请继续保持当前状态，轻松学习，快乐生活。", 52),

    TWO(2, "你的抑郁自评得分显示你有轻度抑郁状态。自认为有时候会出现情绪低落，或者感觉到常常没有愉快的心情。" +
            "同时兴趣感也逐步减少，对以往的事情也变得无趣，对生活上也感到空虚，没劲，缺乏意义。经常感到疲惫，有时食欲不振，胃部不适，" +
            "偶尔会出现简章、不安的情绪反应。请你调整心情，放松身心，增加户外互动和人际交往，必要时请向专业人士寻求心理咨询或心理教练支持。", 5),
    THREE(3, "你的抑郁自评得分显示你有中度抑郁状态。自认为情绪低落比较明显，经常感到心情很不愉快，持续时间也比较长。兴趣明显下降，对以往非常喜欢的东西变得毫无兴趣，常有生活没意义的想法，" +
            "常认为自己无用、无能、缺少价值感，甚至会哭泣、流泪、发脾气，经常有疲惫感，食欲不振，睡眠不好、早醒。请你多多关爱自己，多参加户外活动和增加人际交往，平衡学习与生活，" +
            "让自己渐渐恢复活力。同时，建议你及时向专业人士寻求心理咨询或心理教练支持。", 4),
    FOUR(4, "你的抑郁自评得分显示你有重度抑郁症状。你近来情绪非常低落，感觉自己毫无生气，丝毫没有愉快的感觉，经常产生无助感或者绝望感，自怨自责。" +
            "经常有活着太累，想解脱、想消失的念头出现，经常哭泣或者整日愁眉苦脸，话说明显减少，活动量也明显减少，对一切都不感兴趣，甚至连最喜欢的事物也不喜欢了，" +
            "出现明显的睡眠障碍，入睡困难或者早醒。请你务必引起重视，强烈建议你及时向专业人士寻求心理治疗", 3),
    ;

    private int key;
    private String describe;
    private int value;

    private DepressionPerformanceEnums(int key, String describe, int value) {
        this.key = key;
        this.describe = describe;
        this.value = value;
    }

    public static DepressionPerformanceEnums getManJianType(int code) {
        DepressionPerformanceEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            DepressionPerformanceEnums t = var1[var3];
            if (t.key() == code) {
                return t;
            }
        }

        return null;
    }



    public static String getDescribeByKey(int key) {
        String v = "";
        if(key <= 52){
            v =  ONE.describe;
        }else if(key >= 52 && key < 60){
            v = TWO.describe;
        }else if(key >= 60 && key < 70){
            v = THREE.describe;
        }else if(key >= 70){
            v = FOUR.describe;
        }

        return v;
    }


    public static List<DepressionPerformanceEnums> getAllList() {
        List<DepressionPerformanceEnums> list = new ArrayList();
        DepressionPerformanceEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            DepressionPerformanceEnums se = var1[var3];
            list.add(se);
        }

        return list;
    }

    public static int getValueByKey(int key) {
        int v = 0;
        DepressionPerformanceEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            DepressionPerformanceEnums pt = var2[var4];
            if (key == pt.key) {
                v = pt.value();
                break;
            }
        }

        return v;
    }

    public static String getNameByKey(int key) {
        String name = null;
        DepressionPerformanceEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            DepressionPerformanceEnums pt = var2[var4];
            if (key == pt.key) {
                name = pt.describe;
                break;
            }
        }

        return name;
    }

    public int value() {
        return this.value;
    }

    public String describe() {
        return this.describe;
    }

    public int key() {
        return this.key;
    }
}
