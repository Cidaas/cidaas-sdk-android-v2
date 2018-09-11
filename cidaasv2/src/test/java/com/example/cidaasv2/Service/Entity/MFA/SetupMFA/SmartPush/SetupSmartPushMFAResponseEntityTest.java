package com.example.cidaasv2.Service.Entity.MFA.SetupMFA.SmartPush;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class SetupSmartPushMFAResponseEntityTest {
    @Mock
    SetupSmartPushMFAResponseDataEntity data;
    @InjectMocks
    SetupSmartPushMFAResponseEntity setupSmartPushMFAResponseEntity;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void setSuccess(){
        setupSmartPushMFAResponseEntity.setSuccess(true);
        Assert.assertTrue(setupSmartPushMFAResponseEntity.isSuccess());

    }

    @Test
    public void setStatus(){
        setupSmartPushMFAResponseEntity.setStatus(27);
        Assert.assertEquals(27,setupSmartPushMFAResponseEntity.getStatus());

    }

    @Test
    public void setData(){
        data=new SetupSmartPushMFAResponseDataEntity();

        data.setStatusId("Test");
        setupSmartPushMFAResponseEntity.setData(data);
        Assert.assertEquals("Test",setupSmartPushMFAResponseEntity.getData().getStatusId());

    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme