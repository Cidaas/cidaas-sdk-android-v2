package com.example.cidaasv2.VerificationV2.data.Entity.Initiate;

import com.example.cidaasv2.VerificationV2.data.Entity.ExcangeId.ExchangeIDEntity;

import java.io.Serializable;


public class InitiateResponseDataEntity implements Serializable {

    ExchangeIDEntity exchange_id;
    String sub;
    String status_id;

    public ExchangeIDEntity getExchange_id() {
        return exchange_id;
    }

    public void setExchange_id(ExchangeIDEntity exchange_id) {
        this.exchange_id = exchange_id;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }
}
