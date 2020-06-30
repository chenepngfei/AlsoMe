package com.AlsoMe.commons.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 总体状况
 */
public enum LifeSatisfactionEnums {
    ONE(1, "总体而言，你心理状况良好，无焦虑和抑郁症状，感觉自己毕竟幸福。" +
            "在学业上出现了职业倦怠的前期症状，需要你及时的关注与调节。", 49),

    TWO(2, "总体而言，你的心里状况欠佳，呈现出轻微至轻度抑郁症状。你感到自己不幸福，" +
            "表现出大的学业压力以及重度的职业倦怠，特别需要你的关注和重视", 2),


    FOUR(3, "总体而言，你的心里状态欠佳，呈现出轻微至轻度抑郁症状，你感到自己不幸福，表现出大的学习压力以及重度职业倦怠，特别需要你的关注和重视。", 3),
    ;

    private int key;
    private String describe;
    private int value;




    private LifeSatisfactionEnums(int key, String describe, int value) {
        this.key = key;
        this.describe = describe;
        this.value = value;
    }

    public static LifeSatisfactionEnums getManJianType(int code) {
        LifeSatisfactionEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            LifeSatisfactionEnums t = var1[var3];
            if (t.key() == code) {
                return t;
            }
        }

        return null;
    }

    public static List<LifeSatisfactionEnums> getAllList() {
        List<LifeSatisfactionEnums> list = new ArrayList();
        LifeSatisfactionEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            LifeSatisfactionEnums se = var1[var3];
            list.add(se);
        }

        return list;
    }

    public static int getValueByKey(int key) {
        int v = 0;
        LifeSatisfactionEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            LifeSatisfactionEnums pt = var2[var4];
            if (key == pt.key) {
                v = pt.value();
                break;
            }
        }

        return v;
    }

    public static String getNameByKey(int key) {
        String name = null;
        LifeSatisfactionEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            LifeSatisfactionEnums pt = var2[var4];
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
