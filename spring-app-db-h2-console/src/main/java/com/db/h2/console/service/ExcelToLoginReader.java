package com.db.h2.console.service;

import com.db.h2.console.domain.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


@Component
public class ExcelToLoginReader {

    private Logger log = LoggerFactory.getLogger(getClass());

//
//    public List<Login> readAndParse(byte[] fileData, LoginImportResultDto result) {
//
//        Workbook workbook = openWorkbook(fileData, result);
//        if (workbook != null) {
//            Sheet sheet = workbook.getSheetAt(0);
//            List<List<Cell>> cellMatrix = readCells(sheet);
//
//            extractSource(cellMatrix, result);
//            return convertAndSaveLogin(cellMatrix, result);
//        }
//
//        return new ArrayList<>();
//    }
//
//    private Workbook openWorkbook(byte[] fileData, LoginImportResultDto result) {
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(fileData);
//        try {
//            return new XSSFWorkbook(inputStream);   // .xlsx
//        } catch (Exception e1) {
//            try {
//                inputStream.reset();
//                return new HSSFWorkbook(inputStream);   // .xls
//            } catch (Exception e2) {
//                result.addErrorMessage("Invalid file: " + e1.getMessage());
//                return null;
//            }
//        }
//    }
//
//    private List<List<Cell>> readCells(Sheet sheet) {
//        List<List<Cell>> cellMatrix = new ArrayList<>();
//
//        Iterator<Row> iterator = sheet.rowIterator();
//        while (iterator.hasNext()) {
//            Row row = iterator.next();
//
//            List<Cell> cellList = new ArrayList<>();
//            for (int j = 0; j < 12; j++) {
//                Cell cell = row.getCell(j, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
//                if (j == 0 && cell == null) {
//                    break;
//                }
//                cellList.add(cell);
//            }
//            if (!cellList.isEmpty()) {
//                cellMatrix.add(cellList);
//            }
//        }
//        return cellMatrix;
//    }
//
//    private void extractSource(List<List<Cell>> cellMatrix, LoginImportResultDto result) {
//        if (!cellMatrix.isEmpty() && !cellMatrix.get(0).isEmpty()) {
//            String value = extractString(cellMatrix.get(0), 0, 999);
//            if (StringUtils.containsIgnoreCase(value, "schl") || StringUtils.containsIgnoreCase(value, "key")) {
//                result.setSource(JIRA);
//            } else if (StringUtils.containsIgnoreCase(value, "incident")) {
//                result.setSource(REMEDY);
//            }
//        }
//
//        if (result.getSource() == null) {
//            result.addErrorMessage("Invalid type or format of input file");
//            result.setSource(UNKNOWN);
//        }
//    }
//
//
//    private List<Login> convertAndSaveLogin(List<List<Cell>> cellMatrix, LoginImportResultDto result) {
//
//        List<Login> Logins = new ArrayList<>();
//
//        boolean firstRow = true;
//        for (List<Cell> cells : cellMatrix) {
//
//            String externalId = extractString(cells, 0, 999);
//            String title = extractString(cells, 1, 999);
//            if (!firstRow) {
//                if (StringUtils.isBlank(externalId) || StringUtils.isBlank(title)) {
//                    log.info("Skiping cell line with id = '{}' and title = '{}'", externalId, title);
//                } else {
//                    result.incReadCount();
//                    try {
//                        Login Login;
//                        if (result.getSource() == JIRA) {
//                            Login = createLoginFromJiraRow(cells);
//                        } else if (result.getSource() == REMEDY) {
//                            Login = createLoginFromRemedyRow(cells);
//                        } else {
//                            throw new RuntimeException("Unknown Source: " + result.getSource());
//                        }
//                        Logins.add(Login);
//
//                    } catch (Exception e) {
//                        String msg = "ID: '" + externalId + "', Error-Message: " + e.getMessage();
//                        result.addErrorMessage(msg);
//                        log.error(msg);
//                    }
//                }
//            }
//            firstRow = false;
//        }
//
//        return Logins;
//    }
//
//
//    private Login createLoginFromJiraRow(List<Cell> cells) {
//        Login Login = new Login();
//        Login.setExternalId(extractString(cells, 0, 50));
//        Login.setTitle(extractString(cells, 1, 1000));
//        Login.setType(extractString(cells, 2, 25));
//        Login.setDescription(extractString(cells, 9, Login.MAX_TEXT_LEN));
//        Login.setCategory(LoginConstants.JIRA_CATEGORY);
//        Login.setPriority(extractString(cells, 4, 20));
//        Login.setStatus(extractString(cells, 3, 20));
//        Login.setResolution(extractString(cells, 5, Login.MAX_TEXT_LEN));
//        Login.setSubmitTimestamp(extractDate(cells, 6));
//        Login.setCloseTimestamp(extractDate(cells, 7));
//        Login.setOrganization(LoginConstants.JIRA_ORGANIZATION);
//        Login.setSource(JIRA);
//        Login.setEingabeUser(LoginConstants.DEFAULT_EINGABE_USER);
//        return Login;
//    }
//
//
//    private Login createLoginFromRemedyRow(List<Cell> cells) {
//        Login Login = new Login();
//
//        Login.setExternalId(extractString(cells, 0, 50));
//        Login.setTitle(extractString(cells, 1, 1000));
//        Login.setDescription(extractString(cells, 2, Login.MAX_TEXT_LEN));
//        Login.setCategory(extractString(cells, 3, 120));
//        Login.setPriority(extractString(cells, 4, 20));
//        Login.setStatus(extractString(cells, 5, 20));
//        Login.setResolution(extractString(cells, 6, Login.MAX_TEXT_LEN));
//        Login.setAssignedGroup(extractString(cells, 7, 20));
//        Login.setSubmitTimestamp(extractDate(cells, 8));
//        Login.setCloseTimestamp(extractDate(cells, 9));
//        Login.setCompany(extractString(cells, 10, 50));
//        Login.setOrganization(extractString(cells, 11, 50));
//        Login.setSource(REMEDY);
//        Login.setEingabeUser(LoginConstants.DEFAULT_EINGABE_USER);
//        return Login;
//    }

//
//    private String extractString(List<Cell> cells, int index, int maxLen) {
//        String strVal = null;
//        Cell cell = cells.get(index);
//        if (cell != null && cell.getCellTypeEnum() == CellType.STRING) {
//            strVal = cell.getStringCellValue();
//        }
//        if (cell != null && cell.getCellTypeEnum() == CellType.NUMERIC) {
//            strVal = String.valueOf(cell.getNumericCellValue());
//        }
//        return StringUtils.abbreviate(strVal, maxLen);
//    }
//
//
//    private LocalDateTime extractDate(List<Cell> cells, int index) {
//        if (cells.get(index) == null) {
//            return null;
//        }
//
//        // try to read cell as type 'date'
//        try {
//            Date date = cells.get(index).getDateCellValue();
//            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//        } catch (Exception e) {
//            log.trace("Unable to read and convert Date-Cell");
//        }
//
//        // try to read cell as type 'string'
//        String date = cells.get(index).getStringCellValue();
//        if (date.isEmpty()) {
//            return null;
//        }
//
//        List<DateTimeFormatter> formatters = Arrays.asList(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        for (DateTimeFormatter formatter : formatters) {
//            try {
//                return LocalDateTime.parse(date, formatter);
//
//            } catch (DateTimeParseException e) {
//                log.trace("Unable to parse date string");
//            }
//        }
//        throw new RuntimeException("Unknown date/time format: " + date);
//    }

}
