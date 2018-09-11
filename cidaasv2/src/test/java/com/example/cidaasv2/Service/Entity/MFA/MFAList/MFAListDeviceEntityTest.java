package com.example.cidaasv2.Service.Entity.MFA.MFAList;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class MFAListDeviceEntityTest {

    @Test
    public void getDeviceInfoEntity()
    {
        MFAListDeviceEntity deviceInfoEntity=new MFAListDeviceEntity();
        deviceInfoEntity.set_id("Id");
        deviceInfoEntity.setDeviceId("deviceID");
        deviceInfoEntity.setDeviceMake("deviceMake");
        deviceInfoEntity.setDeviceModel("deviceModel");
       

        assertTrue(deviceInfoEntity.getDeviceId().equals("deviceID"));
        assertTrue(deviceInfoEntity.getDeviceMake().equals("deviceMake"));
        assertTrue(deviceInfoEntity.getDeviceModel().equals("deviceModel"));
        assertTrue(deviceInfoEntity.get_id().equals("Id"));

    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme