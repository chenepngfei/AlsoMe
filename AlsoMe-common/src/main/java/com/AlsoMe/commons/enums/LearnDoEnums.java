package com.AlsoMe.commons.enums;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public enum LearnDoEnums {
    ONE(1, "尝试做自媒体", 1),
    TWO(2, "做饭做菜", 2),
    THREE(3, "上网/聊天/刷抖音等短视频", 3),
    FOR(4, "上网玩游戏", 4),
    FIVE(5, "参加志愿者/做义工", 5),
    SIX(6, "学习/读书", 6),
    SEVEN(7, "运动/健身/旅行", 7),
    EIGHT(8, "听音乐/看剧", 8),
    NINE(9, "关注国内外疫情", 9),
    TEN(10, "其他", 10);

    private int key;
    private String describe;
    private int value;

    private LearnDoEnums(int key, String describe, int value) {
        this.key = key;
        this.describe = describe;
        this.value = value;
    }

    public static LearnDoEnums getManJianType(int code) {
        LearnDoEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            LearnDoEnums t = var1[var3];
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

    public static List<LearnDoEnums> getAllList() {
        List<LearnDoEnums> list = new ArrayList();
        LearnDoEnums[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            LearnDoEnums se = var1[var3];
            list.add(se);
        }

        return list;
    }

    public static int getValueByKey(int key) {
        int v = 0;
        LearnDoEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            LearnDoEnums pt = var2[var4];
            if (key == pt.key) {
                v = pt.value();
                break;
            }
        }

        return v;
    }

    public static String getNameByKey(int key) {
        String name = null;
        LearnDoEnums[] var2 = values();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            LearnDoEnums pt = var2[var4];
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
