package com.neqo.portafolio.domain.tag.entities;

import java.util.Locale;

public class Tag {
    private String uuid;
    private String tag_description;

    public Tag(String uuid, String tag_description) {
        this.uuid = uuid;
        this.tag_description = tag_description;
    }

    public Tag() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTag_description() {
        return tag_description;
    }

    public void setTag_description(String tag_description) {
        this.tag_description = tag_description.toLowerCase(Locale.ROOT);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "uuid='" + uuid + '\'' +
                ", tag_description='" + tag_description + '\'' +
                '}';
    }
}
