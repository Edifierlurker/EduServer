package com.pinke.uni.lottery.model;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

import java.io.Serializable;

public class LotteryPrintRecord extends DynamicBaseObject implements Serializable
{

    private Long printindex;
    private String printid;            //出票流水号
    private Long orderindex;
    private String orderid;            //订单号
    private String outerorderid;      //外部orderid',
    private String lcode;              //投注内容',
    private String ltype;              //彩种',
    private String gtype;              //玩法',
    private String lissue;             //期号',
    private Integer lcount;            //注数',
    private Integer printstatus;       //出票状态 0 未出票  1 出票成功 2 部分出票成功 3 出票失败',
    private String printresult;        //出票结果',
    private String printtime;            //出票时间',
    private Long printfee;             //中奖金额',
    private Long winmoney;             //中奖金额',
    private String winresult;          //中奖结果',
    private Integer status;             //记录状态 1 请求出票成功 0 请求出票失败
    private String reqtime;            //出票请求时间',

    public Long getPrintindex() {
        return printindex;
    }

    public void setPrintindex(Long printindex) {
        this.printindex = printindex;
    }

    public String getPrintid() {
        return printid;
    }

    public void setPrintid(String printid) {
        this.printid = printid;
    }

    public Long getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(Long orderindex) {
        this.orderindex = orderindex;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOuterorderid() {
        return outerorderid;
    }

    public void setOuterorderid(String outerorderid) {
        this.outerorderid = outerorderid;
    }

    public String getLcode() {
        return lcode;
    }

    public void setLcode(String lcode) {
        this.lcode = lcode;
    }

    public String getLtype() {
        return ltype;
    }

    public void setLtype(String ltype) {
        this.ltype = ltype;
    }

    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype;
    }

    public String getLissue() {
        return lissue;
    }

    public void setLissue(String lissue) {
        this.lissue = lissue;
    }

    public Integer getLcount() {
        return lcount;
    }

    public void setLcount(Integer lcount) {
        this.lcount = lcount;
    }

    public Integer getPrintstatus() {
        return printstatus;
    }

    public void setPrintstatus(Integer printstatus) {
        this.printstatus = printstatus;
    }

    public String getPrintresult() {
        return printresult;
    }

    public void setPrintresult(String printresult) {
        this.printresult = printresult;
    }

    public String getPrinttime() {
        return printtime;
    }

    public void setPrinttime(String printtime) {
        this.printtime = printtime;
    }

    public Long getWinmoney() {
        return winmoney;
    }

    public void setWinmoney(Long winmoney) {
        this.winmoney = winmoney;
    }

    public String getWinresult() {
        return winresult;
    }

    public void setWinresult(String winresult) {
        this.winresult = winresult;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReqtime() {
        return reqtime;
    }

    public void setReqtime(String reqtime) {
        this.reqtime = reqtime;
    }

    public Long getPrintfee() {
        return printfee;
    }

    public void setPrintfee(Long printfee) {
        this.printfee = printfee;
    }

    public void initRelation()
    {
        this.addRelation("printindex", "printindex");
        this.addRelation("printid", "printid");
        this.addRelation("orderindex", "orderindex");
        this.addRelation("orderid", "orderid");
        this.addRelation("outerorderid", "outerorderid");
        this.addRelation("lcode", "lcode");
        this.addRelation("ltype", "ltype");
        this.addRelation("gtype", "gtype");
        this.addRelation("lissue", "lissue");
        this.addRelation("lcount", "lcount");
        this.addRelation("printstatus", "printstatus");
        this.addRelation("printresult", "printresult");
        this.addRelation("printtime", "printtime");
        this.addRelation("winmoney", "winmoney");
        this.addRelation("winresult", "winresult");
        this.addRelation("status", "status");
        this.addRelation("reqtime", "reqtime");
        this.addRelation("printfee", "printfee");
    }

    @Override
    public String toString() {
        return "LotteryPrintRecord{" +
                "printindex=" + printindex +
                ", printid='" + printid + '\'' +
                ", orderindex=" + orderindex +
                ", orderid='" + orderid + '\'' +
                ", outerorderid='" + outerorderid + '\'' +
                ", lcode='" + lcode + '\'' +
                ", ltype='" + ltype + '\'' +
                ", gtype='" + gtype + '\'' +
                ", lissue='" + lissue + '\'' +
                ", lcount=" + lcount +
                ", printstatus=" + printstatus +
                ", printresult='" + printresult + '\'' +
                ", printtime='" + printtime + '\'' +
                ", printfee=" + printfee +
                ", winmoney=" + winmoney +
                ", winresult='" + winresult + '\'' +
                ", status=" + status +
                ", reqtime='" + reqtime + '\'' +
                '}';
    }
}
