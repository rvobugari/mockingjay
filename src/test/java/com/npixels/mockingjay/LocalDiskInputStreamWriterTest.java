package com.npixels.mockingjay;

/**
 * LocalDiskInputStreamWriter Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jul 31, 2015</pre>
 */
public class LocalDiskInputStreamWriterTest
{/*
    private static final Logger logger = LoggerFactory.getLogger(LocalDiskInputStreamWriterTest.class);
    
    @Before
    public void before() throws Exception
    {
    }

    @After
    public void after() throws Exception
    {
    }

    *//**
     * Method: write(InputStream in, StorageDetails storageDetails)
     *//*
    @Test
    public void testWrite() throws Exception
    {

        Map<String, String> mimeTypeMap = new HashMap<>();
        mimeTypeMap.put("files/do_not_alter_me.txt", "text/plain");
        mimeTypeMap.put("files/excel_97_2003_workbook.xls", "application/vnd.ms-excel");
        mimeTypeMap.put("files/excel_workbook.xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        mimeTypeMap.put("files/opendocument_spreadsheet.ods", "application/vnd.oasis.opendocument.spreadsheet");
        mimeTypeMap.put("files/opendocument_text.odt", "application/vnd.oasis.opendocument.text");
        mimeTypeMap.put("files/PDF.pdf", "application/pdf");
        mimeTypeMap.put("files/rich_text_file.rtf", "application/rtf");
        mimeTypeMap.put("files/test.png", "image/png");
        mimeTypeMap.put("files/test.tif", "image/tiff");
        mimeTypeMap.put("files/word2003_xml_document.xml", "application/xml");
        mimeTypeMap.put("files/word_97_2003_document.doc", "application/msword");
        mimeTypeMap.put("files/word_document.docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");

        for(Map.Entry<String, String> e : mimeTypeMap.entrySet()) {
            try (InputStream in = this.getClass().getClassLoader().getResourceAsStream(e.getKey())) {

                if (in == null) {
                    throw new NullPointerException("inputstream is null!");
                }

                LocalDiskInputStreamWriter writer = new LocalDiskInputStreamWriter();
                StorageDetails storageDetails = new MountPointStorageDetails(System.getProperty("java.io.tmpdir"));
                Map<String, String> additionalData = new HashMap<>();
                additionalData.put("filename", e.getKey());
                FileData fileData = writer.write(in, storageDetails, additionalData);
                File createdFile = new File(fileData.getFilePath());
                
                Assert.assertTrue(createdFile.exists() && createdFile.isFile());
                Assert.assertEquals("File:" + e.getKey(), mimeTypeMap.get(e.getKey()), fileData.getContentType());

                //noinspection ResultOfMethodCallIgnored
                createdFile.delete();
            }
        }
    }*/
}
