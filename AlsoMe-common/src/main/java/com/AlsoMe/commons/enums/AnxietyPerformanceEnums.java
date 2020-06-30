package com.AlsoMe.commons.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 焦虑得分表现
 */
public enum AnxietyPerformanceEnums {
    ONE(1, "你的焦虑得分显示无焦虑症状。表明你现在心情稳定，心理相对健康,请继续保持当前状态，用心学习，快乐生活。", 49),

    TWO(2, "你的得分显示轻微至轻度焦虑。有时自感内心比较烦乱，容易出现紧张和害怕，对未来有莫名的担忧。" +
            "有时会出现心跳快，心慌，头痛、 头晕，胃部不适、食欲减退，睡眠不好，易惊" +
            "醒。请你调整心情，放松身心，放慢节奏，规律作息，必要时请向专业人士寻求心理咨询或心理焦虑支持", 2),

    THREE(3, "显示你有中度焦虑症状。你现在自感内心比较烦乱，很容易出现紧张和害怕，" +
            "非常担心未来会有不好的事情发生。经常心跳快，心慌，身体也常常有不舒服的感觉，" +
            "诸如头痛、头晕，胃部不适、食欲减退，经常做梦，睡眠困难，易惊醒等。请你多多关爱自己，平衡学习与生活，" +
            "让自己的身心放松下来。如有必要，建议你及时向专业人士寻求心理咨询或者心理教练支持", 3),

    FOUR(4, "显示你有重度焦虑症状。你经常感到内心非常烦乱，很容易出现紧张和害怕，躁动不安，" +
            "对未来有莫名的强烈恐惧。明显感觉到心跳快，心慌，身体出现不舒服的感觉，诸如头痛、头晕或头和背有紧绷感，" +
            "胃部不适、 食欲减退，经常做梦等，睡眠很困难，易惊醒。请你引起注意，强烈建议你及时向专业人士寻求心理治疗。", 4),
    ;

    private int key;
    private String describe;
    private int value;

    public static String getDescribeByKey(int key) {
        String v = "";
        if(key <= 49){
            v =  ONE.describe;
        }else if(key >= 50 && key < 60){
            v = TWO.describe;
        }else if(key >= 60 && key < 70){
            v = "你的焦虑自评得分为" +key + "," + THREE.describe;
        }else if(key >= 70){
            v = "你的焦虑自评得分为" +key + "," + FOUR.describe;
        }

        return v;
    }


    private AnxietyPerformanceEnums(int key, String describe, int value) {
        this.key = key;
        this.describe = describe;
        this.value = value;
    }

    public static AnxietyPerformanceEnums getManJianType(int code) {
        AnxietyPerformanceEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            AnxietyPerformanceEnums t = var1[var3];
            if (t.key() == code) {
                return t;
            }
        }

        return null;
    }

    public static List<AnxietyPerformanceEnums> getAllList() {
        List<AnxietyPerformanceEnums> list = new ArrayList();
        AnxietyPerformanceEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            AnxietyPerformanceEnums se = var1[var3];
            list.add(se);
        }

        return list;
    }

    public static int getValueByKey(int key) {
        int v = 0;
        AnxietyPerformanceEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            AnxietyPerformanceEnums pt = var2[var4];
            if (key == pt.key) {
                v = pt.value();
                break;
            }
        }

        return v;
    }

    public static String getNameByKey(int key) {
        String name = null;
        AnxietyPerformanceEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            AnxietyPerformanceEnums pt = var2[var4];
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
