package de.cidaas.sdk.android.cidaasnative.data.entity.accountverification;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountVerificationListResponseEntity implements Serializable {
    private boolean success = false;
    private int status = 0;
    private AccountVerificationListResponseDataEntity data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public AccountVerificationListResponseDataEntity getData() {
        return data;
    }

    public void setData(AccountVerificationListResponseDataEntity data) {
        this.data = data;
    }
}
