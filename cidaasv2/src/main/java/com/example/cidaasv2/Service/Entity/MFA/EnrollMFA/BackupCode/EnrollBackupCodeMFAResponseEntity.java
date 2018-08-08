package com.example.cidaasv2.Service.Entity.MFA.EnrollMFA.BackupCode;

import com.example.cidaasv2.Service.Entity.MFA.EnrollMFA.Pattern.EnrollPatternResponseDataEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown=true)
public class EnrollBackupCodeMFAResponseEntity implements Serializable{
    boolean success;
    int status;
    EnrollBackupCodeResponseDataEntity data;

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

    public EnrollBackupCodeResponseDataEntity getData() {
        return data;
    }

    public void setData(EnrollBackupCodeResponseDataEntity data) {
        this.data = data;
    }
}
