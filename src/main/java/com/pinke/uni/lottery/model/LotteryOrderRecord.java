package com.pinke.uni.lottery.model;

import com.zte.ssb.dynamicobj.DynamicBaseObject;

import java.io.Serializable;

public class LotteryOrderRecord extends DynamicBaseObject implements Serializable
{

    private Long orderindex;
    private String orderid;
    private String outerorderid;      //外部orderid',
    private Long userindex;            //用户index',
    private String useraccount;        //用户账号',
    private String username;           //姓名',
    private Integer status;            //订单状态 0 待支付 1 支付成功 2 支付失败 3 未中奖  4 中奖',
    private String lcode;              //投注内容',
    private String ltype;              //彩种',
    private String lissue;             //期号',
    private Integer lcount;            //注数',
    private Long price;                //应付金额 分',
    private Long payfee;               //支付金额 分',
    private String payinfo;            //支付信息',
    private String payseqid;           //支付流水号
    private Integer printstatus;       //出票状态 0 未出票  1 出票成功 2 部分出票成功 3 出票失败',
    private String printresult;        //出票结果',
    private Long printfee;             //出票金额',
    private Long winmoney;             //中奖金额',
    private String winresult;          //中奖结果',
    private String paytime;            //支付时间',
    private String ordertime;          //下单时间'

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

    public Long getUserindex() {
        return userindex;
    }

    public void setUserindex(Long userindex) {
        this.userindex = userindex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPayfee() {
        return payfee;
    }

    public void setPayfee(Long payfee) {
        this.payfee = payfee;
    }

    public String getPayinfo() {
        return payinfo;
    }

    public void setPayinfo(String payinfo) {
        this.payinfo = payinfo;
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

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public String getPayseqid() {
        return payseqid;
    }

    public void setPayseqid(String payseqid) {
        this.payseqid = payseqid;
    }

    public Long getPrintfee() {
        return printfee;
    }

    public void setPrintfee(Long printfee) {
        this.printfee = printfee;
    }

    public void initRelation()
    {
        this.addRelation("orderindex", "orderindex");
        this.addRelation("orderid", "orderid");
        this.addRelation("outerorderid", "outerorderid");
        this.addRelation("userindex", "userindex");
        this.addRelation("useraccount", "useraccount");
        this.addRelation("username", "username");
        this.addRelation("status", "status");
        this.addRelation("lcode", "lcode");
        this.addRelation("ltype", "ltype");
        this.addRelation("lissue", "lissue");
        this.addRelation("lcount", "lcount");
        this.addRelation("price", "price");
        this.addRelation("payfee", "payfee");
        this.addRelation("payinfo", "payinfo");
        this.addRelation("payseqid", "payseqid");
        this.addRelation("printstatus", "printstatus");
        this.addRelation("printresult", "printresult");
        this.addRelation("printfee", "printfee");
        this.addRelation("winmoney", "winmoney");
        this.addRelation("winresult", "winresult");
        this.addRelation("paytime", "paytime");
        this.addRelation("ordertime", "ordertime");
    }

    @Override
    public String toString() {
        return "LotteryOrderRecord{" +
                "orderindex=" + orderindex +
                ", orderid='" + orderid + '\'' +
                ", outerorderid='" + outerorderid + '\'' +
                ", userindex=" + userindex +
                ", useraccount='" + useraccount + '\'' +
                ", username='" + username + '\'' +
                ", status=" + status +
                ", lcode='" + lcode + '\'' +
                ", ltype='" + ltype + '\'' +
                ", lissue='" + lissue + '\'' +
                ", lcount=" + lcount +
                ", price=" + price +
                ", payfee=" + payfee +
                ", payinfo='" + payinfo + '\'' +
                ", payseqid='" + payseqid + '\'' +
                ", printstatus=" + printstatus +
                ", printresult='" + printresult + '\'' +
                ", printfee=" + printfee +
                ", winmoney=" + winmoney +
                ", winresult='" + winresult + '\'' +
                ", paytime='" + paytime + '\'' +
                ", ordertime='" + ordertime + '\'' +
                '}';
    }
}
