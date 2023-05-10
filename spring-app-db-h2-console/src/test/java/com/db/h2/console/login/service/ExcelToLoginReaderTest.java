package com.db.h2.console.login.service;

import com.db.h2.console.service.ExcelToLoginReader;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@TestPropertySource(locations = "classpath:application-test.properties")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Sql({"/testscripts/schema-h2.sql"})
//@Sql(value = "/testscripts/data-h2.sql")
//@ExtendWith(SpringExtension.class)
class ExcelToLoginReaderTest {

    @InjectMocks
    private ExcelToLoginReader excelToLoginReader;

//
//    @Test
//    public void importLoginData_newExcelFormat_tenLoginsImported() throws IOException {
//        byte[] data = Files.readAllBytes(new ClassPathResource("data/Login/login-10-rows.xlsx").getFile().toPath());
//        LoginImportResultDto result = new LoginImportResultDto();
//
//        List<Login> Logins = excelToLoginReader.readAndParse(data, result);
//
//        assertThat(result.getSource()).isEqualTo(JIRA);
//        assertThat(result.getReadCount()).isEqualTo(10);
//        assertThat(result.getCreatedCount()).isEqualTo(0);
//        assertThat(result.getUpdatedCount()).isEqualTo(0);
//        assertThat(result.getUnchangedCount()).isEqualTo(0);
//        assertThat(result.getIgnoredCount()).isEqualTo(0);
//        assertThat(result.getErrorCount()).isEqualTo(0);
//
//        assertThat(Logins).hasSize(10).extracting(Login::getExternalId).containsExactly("ISSBETRIEB-425", "ISSBETRIEB-449", "ISSBETRIEB-450", "ISSBETRIEB-212", "ISSBETRIEB-321", "ISSBETRIEB-323", "ISSBETRIEB-325", "ISSBETRIEB-326", "ISSBETRIEB-339", "ISSBETRIEB-340");
//        assertThat(Logins.get(0).getSubmitTimestamp()).isEqualTo(LocalDateTime.parse("2017-11-02T16:08:02"));
//        assertThat(Logins.get(0).getCloseTimestamp()).isEqualTo(LocalDateTime.parse("2017-11-03T16:08:02"));
//    }
//
//    @Test
//    public void importLoginData_oldExcelFormat_tenLoginsImported() throws IOException {
//        byte[] data = Files.readAllBytes(new ClassPathResource("data/Login/login-tickets-10-rows.xls").getFile().toPath());
//        LoginImportResultDto result = new LoginImportResultDto();
//
//        List<Login> Logins = excelToLoginReader.readAndParse(data, result);
//
//        assertThat(result.getSource()).isEqualTo(JIRA);
//        assertThat(result.getReadCount()).isEqualTo(10);
//        assertThat(result.getCreatedCount()).isEqualTo(0);
//        assertThat(result.getUpdatedCount()).isEqualTo(0);
//        assertThat(result.getUnchangedCount()).isEqualTo(0);
//        assertThat(result.getIgnoredCount()).isEqualTo(0);
//        assertThat(result.getErrorCount()).isEqualTo(0);
//
//        assertThat(Logins).hasSize(10).extracting(Login::getExternalId).containsExactly("ISSBETRIEB-425", "ISSBETRIEB-449", "ISSBETRIEB-450", "ISSBETRIEB-212", "ISSBETRIEB-321", "ISSBETRIEB-323", "ISSBETRIEB-325", "ISSBETRIEB-326", "ISSBETRIEB-339", "ISSBETRIEB-340");
//        assertThat(Logins.get(0).getSubmitTimestamp()).isEqualTo(LocalDateTime.parse("2017-11-02T16:08:02"));
//    }
//
//
//    @Test
//    public void importLoginData_emptyFile_noLoginsImported() throws IOException {
//        byte[] data = Files.readAllBytes(new ClassPathResource("data/Login/login-empty.xlsx").getFile().toPath());
//        LoginImportResultDto result = new LoginImportResultDto();
//
//        List<Login> Logins = excelToLoginReader.readAndParse(data, result);
//
//        assertThat(result.getSource()).isEqualTo(JIRA);
//        assertThat(result.getReadCount()).isEqualTo(0);
//        assertThat(Logins).isEmpty();
//    }
//
//    @Test
//    public void importLoginData_invalidDate_correctError() throws IOException {
//        byte[] data = Files.readAllBytes(new ClassPathResource("data/Login/login-invalid-cell-data.xlsx").getFile().toPath());
//        LoginImportResultDto result = new LoginImportResultDto();
//
//        List<Login> Logins = excelToLoginReader.readAndParse(data, result);
//
//        assertThat(result.getSource()).isEqualTo(JIRA);
//        assertThat(result.getReadCount()).isEqualTo(8);
//        assertThat(result.getCreatedCount()).isEqualTo(0);
//        assertThat(result.getUpdatedCount()).isEqualTo(0);
//        assertThat(result.getUnchangedCount()).isEqualTo(0);
//        assertThat(result.getIgnoredCount()).isEqualTo(0);
//        assertThat(result.getErrorCount()).isEqualTo(2);
//
//        assertThat(Logins).hasSize(6).extracting(Login::getExternalId).containsExactly("ISSBETRIEB-425", "ISSBETRIEB-450", "ISSBETRIEB-212", "ISSBETRIEB-321", "ISSBETRIEB-325", "ISSBETRIEB-339");
//        assertThat(Logins.get(0).getSubmitTimestamp()).isEqualTo(LocalDateTime.parse("2017-11-02T16:08:02"));
//    }
//
//
//    @Test
//    public void importLoginData_invalidFirstCell_correctError() throws IOException {
//        byte[] data = Files.readAllBytes(new ClassPathResource("data/Login/login-invalid-first-cell.xlsx").getFile().toPath());
//        LoginImportResultDto result = new LoginImportResultDto();
//
//        List<Login> Logins = excelToLoginReader.readAndParse(data, result);
//
//        assertThat(result.getSource()).isEqualTo(UNKNOWN);
//        assertThat(result.getReadCount()).isEqualTo(0);
//        assertThat(result.getCreatedCount()).isEqualTo(0);
//        assertThat(result.getUpdatedCount()).isEqualTo(0);
//        assertThat(result.getUnchangedCount()).isEqualTo(0);
//        assertThat(result.getIgnoredCount()).isEqualTo(0);
//        assertThat(result.getErrorCount()).isEqualTo(1);
//        assertThat(result.getErrorMessages()).containsIgnoringCase("invalid type");
//
//        assertThat(Logins).isEmpty();
//    }
//
//    @Test
//    public void importLoginData_invalidFileFormat_correctError() throws IOException {
//        byte[] data = Files.readAllBytes(new ClassPathResource("data/Login/login-invalid-file-format.xml").getFile().toPath());
//        LoginImportResultDto result = new LoginImportResultDto();
//
//        List<Login> Logins = excelToLoginReader.readAndParse(data, result);
//
//        assertThat(result.getSource()).isEqualTo(null);
//        assertThat(result.getReadCount()).isEqualTo(0);
//        assertThat(result.getCreatedCount()).isEqualTo(0);
//        assertThat(result.getUpdatedCount()).isEqualTo(0);
//        assertThat(result.getUnchangedCount()).isEqualTo(0);
//        assertThat(result.getErrorCount()).isEqualTo(1);
//        assertThat(result.getErrorMessages()).containsIgnoringCase("invalid file");
//
//        assertThat(Logins).isEmpty();
//    }
//

}
