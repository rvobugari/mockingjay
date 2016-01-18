package com.npixels.mockingjay;


import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;


import static org.mockito.Matchers.any;


@RunWith(PowerMockRunner.class)
public class FileServiceTest {
/*

    @Mock
    FilesRepository filesRepository;

    @Mock
    StorageSystemRepository storageSystemRepository;

    @Mock
    StorageDetailsFactory storageDetailsFactory;

    @Mock
    FileData fileData;

    @Mock
    StorageSystem storageSystem;

    @Mock
    InputStreamWriterFactory inputStreamWriterFactory;

    @Mock
    InputStreamWriter inputStreamWriter;

    @Mock
    InputStream inputStream;

    @Mock
    FileReaderFactory fileReaderFactory;

    @Mock
    FileReader fileReader;

    @Mock
    AccessLocationRepository accessLocationRepository;

    @Mock
    Session session;

    @Mock
    Transaction transaction;

    @Mock
    HibernateSessionFactoryManager hibernateSessionFactoryManager;

    @Mock
    FormDataBodyPart formDataBodyPart;

    @Mock
    ContentDisposition contentDisposition;

    @Mock
    mockingjayFile mockingjayFile;

    @Mock
    AccessLocation accessLocation;

    @Mock
    mockingjayConfiguration mockingjayConfiguration;

    @Mock
    FileUtils fileUtils;


    @InjectMocks
    private mockingjayFilesService mockingjayFilesService = new mockingjayFilesService();


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @PrepareForTest(HibernateSessionFactoryManager.class)
    @Test
    public void createFileTest() {
        FilesDTO filesDTO = new FilesDTO();
        List<FileDTO> fileDTOList = new ArrayList<>();
        filesDTO.setFiles(fileDTOList);
        FileDTO fileDTO = new FileDTO();
        fileDTO.setFileName("test");
        filesDTO.getFiles().add(fileDTO);
        List<FormDataBodyPart> formDataBodyParts = new ArrayList<>();
        PowerMockito.mockStatic(HibernateSessionFactoryManager.class);
        PowerMockito.when(storageSystemRepository.loadFirstTierStorageSystem(TierType.ONE)).thenReturn(storageSystem);
        PowerMockito.when(HibernateSessionFactoryManager.getInstance()).thenReturn(hibernateSessionFactoryManager);
        PowerMockito.when(hibernateSessionFactoryManager.openSession()).thenReturn(session);
        PowerMockito.when(session.beginTransaction()).thenReturn(transaction);
        storageSystem.setType(StorageType.LOCAL_DISK);
        PowerMockito.when(inputStreamWriterFactory.resolveInputStreamWriter(storageSystem.getType())).thenReturn(inputStreamWriter);
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("files/do_not_alter_me.txt");
        formDataBodyPart.setValue(InputStream.class.toString());
        formDataBodyPart.setValue(MediaType.TEXT_PLAIN_TYPE, in);
        formDataBodyPart.setName("test");
        formDataBodyParts.add(formDataBodyPart);
        PowerMockito.when(formDataBodyPart.getContentDisposition()).thenReturn(contentDisposition);
        PowerMockito.when(contentDisposition.getFileName()).thenReturn("test");
        fileData.setFilePath("");
        PowerMockito.when(mockingjayConfiguration.getWatermarkValue()).thenReturn(80f);
        PowerMockito.when(accessLocationRepository.loadAllForTier(storageSystem)).thenReturn(accessLocation);
        PowerMockito.when(formDataBodyPart.getValueAs(InputStream.class)).thenReturn(in);
        PowerMockito.when(inputStreamWriter.write(any(InputStream.class), any(StorageDetails.class), any(Map.class))).thenReturn(fileData);
        PowerMockito.when(filesRepository.save(any(mockingjayFile.class))).thenReturn(mockingjayFile);
        PowerMockito.when(fileUtils.getDiskUtilization(any(String.class))).thenReturn(50f);
        mockingjayFilesService.createFiles(filesDTO, "test", formDataBodyParts);

    }


    @Test
    public void readFileTest() throws IOException {

        PowerMockito.when(filesRepository.findOne("test")).thenReturn(mockingjayFile);
        mockingjayFile.setStorageSystemUUID("test");
        PowerMockito.when(storageSystemRepository.findOne(mockingjayFile.getStorageSystemUUID())).thenReturn(storageSystem);
        storageSystem.setType(StorageType.LOCAL_DISK);
        PowerMockito.when(fileReaderFactory.resolveFileReader(storageSystem.getType())).thenReturn(fileReader);
        PowerMockito.when(fileReader.getFileInputStream(storageSystem, mockingjayFile)).thenReturn(inputStream);
        mockingjayFilesService.getFileInputStream("test");
    }




    @Test(expected = FileNotFoundException.class)
    public void getMetadataTest() throws IOException{
        PowerMockito.when(filesRepository.findOne("test")).thenReturn(mockingjayFile);
        mockingjayFilesService.getFileMetadata("fileId");
    }


    @Test(expected = mockingjayGenericException.class)
    public void deleteFileTest() throws IOException {
        PowerMockito.when(filesRepository.findOne("test")).thenReturn(mockingjayFile);
        mockingjayFile.setId("test");
        mockingjayFile.setStorageSystemUUID("test");
        PowerMockito.when(storageSystemRepository.findOne(mockingjayFile.getStorageSystemUUID())).thenReturn(storageSystem);
        String location = System.getProperty("java.io.tmpdir");
        PowerMockito.when(mockingjayFile.getLocation()).thenReturn(location);
        mockingjayFilesService.deleteFile("test");
    }*/
}
