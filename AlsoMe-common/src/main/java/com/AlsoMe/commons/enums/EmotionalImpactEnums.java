package com.AlsoMe.commons.enums;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public enum EmotionalImpactEnums {
    ONE(1, "学习压力", 1),
    TWO(2, "同学关系", 2),
    THREE(3, "身体不适", 3),
    FOUR(4, "导师/老师关系", 4),
    FIVE(5, "睡眠不好", 5),
    SIX(6, "恋爱问题", 6),
    SEVEN(7, "父母关系", 7),
    EIGHT(8, "交不到好朋友", 8),
    NINE(9, "别人不能理解我", 9),
    TEN(10, "其他", 10);

    private int key;
    private String describe;
    private int value;

    private EmotionalImpactEnums(int key, String describe, int value) {
        this.key = key;
        this.value = value;
        this.describe = describe;
    }

    public static EmotionalImpactEnums getManJianType(int code) {
        EmotionalImpactEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            EmotionalImpactEnums t = var1[var3];
            if (t.key() == code) {
                return t;
            }
        }

        return null;
    }

    public static String getNameByKeys(String keys) {
        String name = "";
        String[] split = keys.split(",");

        for(int i = 0; i < split.length; ++i) {
            name = name + getNameByKey(Integer.valueOf(split[i])) + ",";
        }

        if (StringUtils.isNotBlank(name)) {
            name = name.substring(0, name.length() - 1);
        }

        return name;
    }

    public static List<EmotionalImpactEnums> getAllList() {
        List<EmotionalImpactEnums> list = new ArrayList();
        EmotionalImpactEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            EmotionalImpactEnums se = var1[var3];
            list.add(se);
        }

        return list;
    }

    public static int getValueByKey(int key) {
        int v = 0;
        EmotionalImpactEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            EmotionalImpactEnums pt = var2[var4];
            if (key == pt.key) {
                v = pt.value();
                break;
            }
        }

        return v;
    }

    public static String getNameByKey(int key) {
        String name = null;
        EmotionalImpactEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            EmotionalImpactEnums pt = var2[var4];
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

    public int key() {
        return this.key;
    }

    public String describe() {
        return this.describe;
    }
}
