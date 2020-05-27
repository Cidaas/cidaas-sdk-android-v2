package de.cidaas.sdk.android.service.entity.mfa.InitiateMFA.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InitiatePatternMFARequestDataEntity implements Serializable {
    String deviceId;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}