package com.thinkgem.jeesite.modules.operate.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.IdEntity;

/**
 * 销量Entity
 * @author lejingw
 * @version 2014-10-31
 */
@Entity
@Table(name = "operate_sale")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Sale extends IdEntity<Sale> {
	
	private static final long serialVersionUID = 1L;
	private String orderTime;   //销售日期
    private String lotteryType; //彩种代码
    private String orderbonus;  //销售金额
    private String bonus;   //中奖金额
    private String saleChannelType; //渠道商

    private String dayPattern;
    private String beginDate;
    private String endDate;

    public Sale() {
		super();
	}

	public Sale(String id){
		this();
		this.id = id;
	}

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(String lotteryType) {
        this.lotteryType = lotteryType;
    }

    public String getOrderbonus() {
        return orderbonus;
    }

    public void setOrderbonus(String orderbonus) {
        this.orderbonus = orderbonus;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getSaleChannelType() {
        return saleChannelType;
    }

    public void setSaleChannelType(String saleChannelType) {
        this.saleChannelType = saleChannelType;
    }

    public String getDayPattern() {
        return dayPattern;
    }

    public void setDayPattern(String dayPattern) {
        this.dayPattern = dayPattern;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}


