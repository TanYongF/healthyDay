package com.course.coursedesign2022.pojo;
//实体类
public class PointObject {
    private Integer id;
    //成长积分数
    private Integer growScore;
    //可兑换积分数
    private Integer exchangeScore;
    //总积分数
    private Integer scoreTotal;

    public PointObject() {
    }

    public PointObject(Integer id, Integer growScore, Integer exchangeScore, Integer scoreTotal) {
        this.id = id;
        this.growScore = growScore;
        this.exchangeScore = exchangeScore;
        this.scoreTotal = scoreTotal;
    }

    public Integer getId() {
        return id;
    }

    public Integer getGrowScore() {
        return growScore;
    }

    public Integer getExchangeScore() {
        return exchangeScore;
    }

    public Integer getScoreTotal() {
        return scoreTotal;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGrowScore(Integer growScore) {
        this.growScore = growScore;
    }

    public void setExchangeScore(Integer exchangeScore) {
        this.exchangeScore = exchangeScore;
    }

    public void setScoreTotal(Integer scoreTotal) {
        this.scoreTotal = scoreTotal;
    }

    @Override
    public String toString() {
        return "PointObject{" +
                "id=" + id +
                ", growScore=" + growScore +
                ", exchangeScore=" + exchangeScore +
                ", scoreTotal=" + scoreTotal +
                '}';
    }

}
