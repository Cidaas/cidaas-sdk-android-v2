package com.example.cidaasv2.Service.Entity.Deduplication.RegisterDeduplication;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class RegisterDeduplicationEntityTest {
    @Mock
    RegisterDeduplicationDataEntity data;
    @InjectMocks
    RegisterDeduplicationEntity registerDeduplicationEntity;

    @Before
    public void setUp() {
        registerDeduplicationEntity=new RegisterDeduplicationEntity();
    }

    @Test
    public void setSuccess(){
        registerDeduplicationEntity.setSuccess(true);
        Assert.assertTrue(registerDeduplicationEntity.isSuccess());

    }

    @Test
    public void setStatus(){
        registerDeduplicationEntity.setStatus(27);
        Assert.assertEquals(27,registerDeduplicationEntity.getStatus());

    }

    @Test
    public void setData(){
        data=new RegisterDeduplicationDataEntity();

        data.setSub("Code");
        registerDeduplicationEntity.setData(data);
        Assert.assertEquals("Code",registerDeduplicationEntity.getData().getSub());

    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme