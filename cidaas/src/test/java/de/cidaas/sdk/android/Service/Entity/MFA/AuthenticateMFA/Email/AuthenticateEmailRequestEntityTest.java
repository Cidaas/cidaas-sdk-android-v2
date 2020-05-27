package de.cidaas.sdk.android.Service.Entity.MFA.AuthenticateMFA.Email;

import org.junit.Before;
import org.junit.Test;

import de.cidaas.sdk.android.entities.DeviceInfoEntity;
import de.cidaas.sdk.android.service.entity.mfa.AuthenticateMFA.Email.AuthenticateEmailRequestEntity;

import static junit.framework.TestCase.assertTrue;


public class AuthenticateEmailRequestEntityTest {


    AuthenticateEmailRequestEntity authenticateEmailRequestEntity = new AuthenticateEmailRequestEntity();

    @Before
    public void setUp() {

    }

    @Test
    public void getCode() {
        authenticateEmailRequestEntity.setCode("Password");
        assertTrue(authenticateEmailRequestEntity.getCode().equals("Password"));
    }


    @Test
    public void getDeviceInfoEntity() {
        DeviceInfoEntity deviceInfoEntity = new DeviceInfoEntity();
        deviceInfoEntity.setPushNotificationId("push");
        deviceInfoEntity.setDeviceId("deviceID");
        deviceInfoEntity.setDeviceMake("deviceMake");
        deviceInfoEntity.setDeviceModel("deviceModel");
        deviceInfoEntity.setDeviceVersion("deviceVersion");

        authenticateEmailRequestEntity.setDeviceInfo(deviceInfoEntity);

        assertTrue(authenticateEmailRequestEntity.getDeviceInfo().getDeviceId().equals("deviceID"));
        assertTrue(authenticateEmailRequestEntity.getDeviceInfo().getDeviceMake().equals("deviceMake"));
        assertTrue(authenticateEmailRequestEntity.getDeviceInfo().getDeviceModel().equals("deviceModel"));
        assertTrue(authenticateEmailRequestEntity.getDeviceInfo().getDeviceVersion().equals("deviceVersion"));
        assertTrue(authenticateEmailRequestEntity.getDeviceInfo().getPushNotificationId().equals("push"));
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme