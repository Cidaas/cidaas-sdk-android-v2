package de.cidaas.cidaasv2.Service.Entity.ValidateDevice;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import de.cidaas.sdk.android.cidaas.Service.Entity.ValidateDevice.ValidateDeviceResponseDataEntity;

public class ValidateDeviceResponseDataEntityTest {
    ValidateDeviceResponseDataEntity validateDeviceRequestEntity;


    @Before
    public void setUp() {

        validateDeviceRequestEntity = new ValidateDeviceResponseDataEntity();
    }


    @Test
    public void setUsagePass() {
        validateDeviceRequestEntity.setUsage_pass("Test");
        Assert.assertEquals("Test", validateDeviceRequestEntity.getUsage_pass());

    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme