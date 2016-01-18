package com.npixels.mockingjay;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;


public class EntityTest {
/*
    private String location;
    private String checksum;
    private LocationType locationType;
    private String storageId;
    private String metadata;
    private String status;
    private float watermark;
    private String storageName;
    private String accessKey;
    private TierType tierType;
    private StorageType storageType;
    private String userId;

    @Before
    public void setUp(){
        location =  System.getProperty("java.io.tmpdir");
        checksum = "xyz";
        locationType = LocationType.BUCKET;
        storageId = "uuid";
        metadata = "metadata";
        status = "deleted";
        watermark = 1.0f;
        storageName = "cloud";
        accessKey = "nckcn";
        tierType = TierType.ONE;
        storageType = StorageType.LOCAL_DISK;
        userId = "superuser";
        }

    @Test
    public void mockingjayFileTest(){
        mockingjayFile file = new mockingjayFile();
        file.setLocation(location);
        file.setChecksum(checksum);
        file.setLocationType(locationType);
        file.setMetadataMap(new HashMap());
        file.setStorageSystemUUID(storageId);
        assertEquals(file.getLocation(), location);
        assertEquals(file.getChecksum(), checksum);
        assertEquals(file.getLocationType(), locationType);
        assertEquals(file.getStorageSystemUUID(), storageId);
    }

    @Test
    public void accessLocationTest(){
        AccessLocation location = new AccessLocation();
        location.setStorageSystemUUID(storageId);
        location.setMetadata(metadata);
        location.setStatus(status);
        location.setWatermark(watermark);
        assertEquals(location.getStorageSystemUUID(), storageId);
        assertEquals(location.getMetadata(), metadata);
        assertEquals(location.getStatus(), status);
        assertEquals(location.getWatermark(), watermark);
    }

    @Test
    public void storageSystemTest(){
        StorageSystem storageSystem = new StorageSystem();
        storageSystem.setAccessKey(accessKey);
        storageSystem.setName(storageName);
        storageSystem.setTierType(tierType);
        storageSystem.setType(storageType);
        storageSystem.setUserId(userId);
        assertEquals(storageSystem.getAccessKey(), accessKey);
        assertEquals(storageSystem.getName(), storageName);
        assertEquals(storageSystem.getTierType(), tierType);
        assertEquals(storageSystem.getType(), storageType);
        assertEquals(storageSystem.getUserId(),userId);
    }

    @Ignore
    public void storageDetailTest(){
        CloudStorageDetails cloudStorageDetails = new CloudStorageDetails(null,location, userId, accessKey,null);
        assertEquals(cloudStorageDetails.getUserId(), userId);
        assertEquals(cloudStorageDetails.getAccessKey(), accessKey);
        assertEquals(cloudStorageDetails.getAccessLocation(),location);
        MountPointStorageDetails localDiskStorageDetails = new MountPointStorageDetails(location);
        assertNull(localDiskStorageDetails.getUserId());
        assertNull(localDiskStorageDetails.getAccessKey());
        assertEquals(localDiskStorageDetails.getAccessLocation(),location);
    }*/

}
