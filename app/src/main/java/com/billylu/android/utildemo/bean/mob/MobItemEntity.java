package com.billylu.android.utildemo.bean.mob;

/**
 * Created by maning on 2017/5/8.
 */

public class MobItemEntity {

    private String title;
    private String desc;

    public MobItemEntity() {
    }

    public MobItemEntity(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "MobItemEntity{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
