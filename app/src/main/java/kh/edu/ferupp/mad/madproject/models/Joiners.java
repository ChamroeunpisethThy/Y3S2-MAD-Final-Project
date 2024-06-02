package kh.edu.ferupp.mad.madproject.models;

import java.util.Objects;

public class Joiners {
    private String joinerId;
    private String JoinerName;
    private String school;
    private String imageUrl;

    public String getSchool() {
        return school;
    }

    public void setsShool(String school) {
        this.school = school;
    }

    public String getJoinerId() {
        return joinerId;
    }

    public void setJoinerId(String joinerId) {
        this.joinerId = joinerId;
    }

    public String getJoinerName() {
        return JoinerName;
    }

    public void setJoinerName(String JoinerName) {
        this.JoinerName = JoinerName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joiners that = (Joiners) o;
        return Objects.equals(joinerId, that.joinerId) &&
                Objects.equals(JoinerName, that.JoinerName) &&
                Objects.equals(school, that.school) &&
                Objects.equals(imageUrl, that.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(joinerId, JoinerName, school, imageUrl);
    }
}
