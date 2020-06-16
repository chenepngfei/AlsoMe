package com.AlsoMe.commons.enums;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public enum FeelingEnums {
    ONE(1, "庆幸自己是中国人", 1),
    TWO(2, "中国越来越强大了", 2),
    THREE(3, "父母/家庭/亲情很重要", 3),
    FOR(4, "医护人员彰显奉献精神", 4),
    FIVE(5, "天有不测风云，人有旦夕祸福", 5),
    SIX(6, "不要乱吃野生动物", 6),
    SEVEN(7, "只能宅家不能有所作为有点遗憾", 7),
    EIGHT(8, "卯足学习动力将来为国出力", 8),
    NINE(9, "感觉自己更加成熟了", 9),
    TEN(10, "其他", 10);

    private int key;
    private String describe;
    private int value;

    private FeelingEnums(int key, String describe, int value) {
        this.key = key;
        this.describe = describe;
        this.value = value;
    }

    public static FeelingEnums getManJianType(int code) {
        FeelingEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            FeelingEnums t = var1[var3];
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

    public static List<FeelingEnums> getAllList() {
        List<FeelingEnums> list = new ArrayList();
        FeelingEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            FeelingEnums se = var1[var3];
            list.add(se);
        }

        return list;
    }

    public static int getValueByKey(int key) {
        int v = 0;
        FeelingEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            FeelingEnums pt = var2[var4];
            if (key == pt.key) {
                v = pt.value();
                break;
            }
        }

        return v;
    }

    public static String getNameByKey(int key) {
        String name = null;
        FeelingEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            FeelingEnums pt = var2[var4];
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
