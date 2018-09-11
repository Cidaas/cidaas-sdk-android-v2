package com.example.cidaasv2.Service.Entity.MFA.InitiateMFA.Face;

import com.example.cidaasv2.Helper.Entity.DeviceInfoEntity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class InitiateFaceMFARequestEntityTest {

    InitiateFaceMFARequestEntity initiateFaceMFARequestEntity;

    @Before
    public void setUp() {
        initiateFaceMFARequestEntity=new InitiateFaceMFARequestEntity();
    }

    @Test
    public void setClientId()
    {
        initiateFaceMFARequestEntity.setClient_id("ClientID");
        assertTrue(initiateFaceMFARequestEntity.getClient_id().equals("ClientID"));
    }

    @Test
    public void setEmail()
    {
        initiateFaceMFARequestEntity.setEmail("email");
        assertTrue(initiateFaceMFARequestEntity.getEmail().equals("email"));
    }
    @Test
    public void setMobile()
    {
        initiateFaceMFARequestEntity.setMobile("Mobile");
        assertTrue(initiateFaceMFARequestEntity.getMobile().equals("Mobile"));
    }

    @Test
    public void setUsagePass()
    {
        initiateFaceMFARequestEntity.setUsagePass("UsagePass");
        assertTrue(initiateFaceMFARequestEntity.getUsagePass().equals("UsagePass"));
    }

    @Test
    public void getUsageType()
    {
        initiateFaceMFARequestEntity.setUsageType("UsageType");
        assertTrue(initiateFaceMFARequestEntity.getUsageType().equals("UsageType"));
    }



    @Test
    public void setSub()
    {
        initiateFaceMFARequestEntity.setSub("Sub");
        assertTrue(initiateFaceMFARequestEntity.getSub().equals("Sub"));
    }

    @Test
    public void getDeviceInfoEntity()
    {
        DeviceInfoEntity deviceInfoEntity=new DeviceInfoEntity();
        deviceInfoEntity.setPushNotificationId("push");
        deviceInfoEntity.setDeviceId("deviceID");
        deviceInfoEntity.setDeviceMake("deviceMake");
        deviceInfoEntity.setDeviceModel("deviceModel");
        deviceInfoEntity.setDeviceVersion("deviceVersion");

        initiateFaceMFARequestEntity.setDeviceInfo(deviceInfoEntity);

        assertTrue(initiateFaceMFARequestEntity.getDeviceInfo().getDeviceId().equals("deviceID"));
        assertTrue(initiateFaceMFARequestEntity.getDeviceInfo().getDeviceMake().equals("deviceMake"));
        assertTrue(initiateFaceMFARequestEntity.getDeviceInfo().getDeviceModel().equals("deviceModel"));
        assertTrue(initiateFaceMFARequestEntity.getDeviceInfo().getDeviceVersion().equals("deviceVersion"));
        assertTrue(initiateFaceMFARequestEntity.getDeviceInfo().getPushNotificationId().equals("push"));
    }

    @Test
    public void getUserDeviceId()
    {
        initiateFaceMFARequestEntity.setUserDeviceId("UserDeveiceId");
        assertTrue(initiateFaceMFARequestEntity.getUserDeviceId().equals("UserDeveiceId"));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme