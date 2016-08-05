package com.neu.register;



/**
 * AbstractAccount entity provides the base persistence definition of the Account entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAccount  implements java.io.Serializable {


    // Fields    

     private Integer accountid;
     private Integer dealpassword;
     private Integer amount;
     private Integer term;
     private Integer isloss;
     private Integer limit;
     private Integer integrate;
     private Integer isactive;
     private Integer isopenob;
     private Integer identityid;
     private Integer sign;


    // Constructors

    /** default constructor */
    public AbstractAccount() {
    }

	/** minimal constructor */
    public AbstractAccount(Integer accountid, Integer dealpassword, Integer amount, Integer isloss, Integer limit, Integer integrate, Integer isactive, Integer isopenob, Integer identityid, Integer sign) {
        this.accountid = accountid;
        this.dealpassword = dealpassword;
        this.amount = amount;
        this.isloss = isloss;
        this.limit = limit;
        this.integrate = integrate;
        this.isactive = isactive;
        this.isopenob = isopenob;
        this.identityid = identityid;
        this.sign = sign;
    }
    
    /** full constructor */
    public AbstractAccount(Integer accountid, Integer dealpassword, Integer amount, Integer term, Integer isloss, Integer limit, Integer integrate, Integer isactive, Integer isopenob, Integer identityid, Integer sign) {
        this.accountid = accountid;
        this.dealpassword = dealpassword;
        this.amount = amount;
        this.term = term;
        this.isloss = isloss;
        this.limit = limit;
        this.integrate = integrate;
        this.isactive = isactive;
        this.isopenob = isopenob;
        this.identityid = identityid;
        this.sign = sign;
    }

   
    // Property accessors

    public Integer getAccountid() {
        return this.accountid;
    }
    
    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public Integer getDealpassword() {
        return this.dealpassword;
    }
    
    public void setDealpassword(Integer dealpassword) {
        this.dealpassword = dealpassword;
    }

    public Integer getAmount() {
        return this.amount;
    }
    
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTerm() {
        return this.term;
    }
    
    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getIsloss() {
        return this.isloss;
    }
    
    public void setIsloss(Integer isloss) {
        this.isloss = isloss;
    }

    public Integer getLimit() {
        return this.limit;
    }
    
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getIntegrate() {
        return this.integrate;
    }
    
    public void setIntegrate(Integer integrate) {
        this.integrate = integrate;
    }

    public Integer getIsactive() {
        return this.isactive;
    }
    
    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

    public Integer getIsopenob() {
        return this.isopenob;
    }
    
    public void setIsopenob(Integer isopenob) {
        this.isopenob = isopenob;
    }

    public Integer getIdentityid() {
        return this.identityid;
    }
    
    public void setIdentityid(Integer identityid) {
        this.identityid = identityid;
    }

    public Integer getSign() {
        return this.sign;
    }
    
    public void setSign(Integer sign) {
        this.sign = sign;
    }
   








}