package com.npixels.mockingjay;

public class LocalDiskFileReadTest {

  /*  StorageSystem storageSystem;
    mockingjayFile mockingjayFile;
    FileData fileData;

    @Before
    public void setUp(){
        storageSystem = new StorageSystem();
        mockingjayFile = new mockingjayFile();
        String tmpDir = System.getProperty("java.io.tmpdir");
        LocalDiskInputStreamWriter writer = new LocalDiskInputStreamWriter();
        StorageDetails storageDetails = new MountPointStorageDetails(tmpDir);
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("files/do_not_alter_me.txt");
        fileData = writer.write(in, storageDetails, new HashMap<String, String>());
        mockingjayFile.setLocation(fileData.getFilePath());
    }

    @After
    public void deleteFile(){
        File createdFile = new File(fileData.getFilePath());
        createdFile.delete();
    }

    @Test
    public void testRead(){
        LocalDiskFileReader localDiskFileReader = new LocalDiskFileReader();
        try {
            InputStream fileInputStream = localDiskFileReader.getFileInputStream(storageSystem, mockingjayFile);
            assertNotNull(fileInputStream);
            assertEquals(fileData.getChecksum(),findChecksum(fileInputStream));
        } catch (Exception e) {
            fail("File Read Exception");
        }
    }

    private String findChecksum(InputStream in) throws Exception{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        long sizeInBytes = 0;
        int bytesRead;
        byte[] buffer = new byte[40960]; // 10 x 4KiB
        while ((bytesRead = in.read(buffer)) > 0) {
            digest.update(buffer, 0, bytesRead);
            sizeInBytes = sizeInBytes + bytesRead;
        }
        byte[] digestBytes = digest.digest();
        return Hex.encodeHexString(digestBytes);
    }*/
}
