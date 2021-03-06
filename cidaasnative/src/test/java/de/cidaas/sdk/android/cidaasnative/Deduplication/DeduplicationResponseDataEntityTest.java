package de.cidaas.sdk.android.cidaasnative.Deduplication;

import org.junit.Assert;
import org.junit.Test;

import de.cidaas.sdk.android.cidaasnative.data.entity.deduplication.DeduplicationList;
import de.cidaas.sdk.android.cidaasnative.data.entity.deduplication.DeduplicationResponseDataEntity;

public class DeduplicationResponseDataEntityTest {
    //Field deduplicationList of type DeduplicationList[] - was not mocked since Mockito doesn't mock arrays
    DeduplicationResponseDataEntity deduplicationResponseDataEntity = new DeduplicationResponseDataEntity();

    @Test
    public void testGetDeduplicationList() throws Exception {
        DeduplicationList deduplicationList = new DeduplicationList();
        deduplicationList.setZipcode("Test");

        DeduplicationList[] result = {deduplicationList};
        deduplicationResponseDataEntity.setDeduplicationList(result);
        Assert.assertEquals("Test", deduplicationResponseDataEntity.getDeduplicationList()[0].getZipcode());
    }

    @Test
    public void setVerificationType() {
        deduplicationResponseDataEntity.setEmail("Test");
        junit.framework.Assert.assertEquals("Test", deduplicationResponseDataEntity.getEmail());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme