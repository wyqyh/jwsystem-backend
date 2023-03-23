package com.ldsg.jwsystem.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;
import com.ldsg.jwsystem.entity.Student;

public class XssfUtils {
    public void exportXlsModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 在内存中创建一个Excel文件，通过输出流写到客户端提供下载
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 创建一个sheet页
        XSSFSheet sheet = workbook.createSheet("学生信息模板");
        XSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(true);
        cellStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 居中
        cellStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        // 第一行表头
        XSSFRow headRow = sheet.createRow(0);
        headRow.createCell(0).setCellValue("学号");
        headRow.createCell(1).setCellValue("姓名");
        headRow.createCell(2).setCellValue("性别");
        headRow.createCell(3).setCellValue("户籍");
        headRow.createCell(4).setCellValue("手机");
        headRow.createCell(5).setCellValue("身份证号码");
        headRow.createCell(6).setCellValue("家庭住址");
        headRow.createCell(7).setCellValue("政治面貌");
        String filename = "学生信息模板.xlsx";
        String agent = request.getHeader("User-Agent");
        filename = FileUtils.encodeDownloadFilename(filename, agent);
        // 一个流两个头
        OutputStream out = response.getOutputStream();
        String contentType = request.getSession().getServletContext().getMimeType(filename);
//        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setContentType(contentType);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("content-disposition", "attchment;filename=" + filename);
        workbook.write(out);
    }

    public List<Student> readXLS(MultipartFile file, int classid) throws IOException {
        List<Student> list = Lists.newArrayList();
 
        InputStream inputStream = file.getInputStream();
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
 
        //读取第一张sheet
        HSSFSheet sheet = workbook.getSheetAt(0);
        //遍历每一行Excel获取内容
        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            HSSFRow row = sheet.getRow(rowNum);
            if (row != null){
            	Student student = new Student();
                //使用了getStringCellValue()方法来获取值，POI会判断单元格的类型，如果非字符串类型就会抛出上面的异常。
                //所以先使用setCellType()方法先将该单元格的类型设置为STRING
                //然后poi会根据字符串读取它
            	row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);

                //姓名为空则读取下一行
            	String stuname = row.getCell(1).getStringCellValue();
            	if(StringUtils.isEmpty(stuname)) {
            		continue;
            	}
            	student.setClassid(classid);
            	student.setStuno(row.getCell(0).getStringCellValue());
            	student.setStuname(stuname);
            	student.setSex(row.getCell(2).getStringCellValue());
            	student.setOrigin(row.getCell(3).getStringCellValue());
            	student.setTel(row.getCell(4).getStringCellValue());
            	student.setIdcard(row.getCell(5).getStringCellValue());
            	student.setAddress(row.getCell(6).getStringCellValue());
            	student.setPolitical(row.getCell(7).getStringCellValue());
                list.add(student);
            }
        }
        return list;
    }
 
 
    public List<Student> readXLSX(MultipartFile file, int classid) throws IOException {
        List<Student> list = Lists.newArrayList();
 
        InputStream inputStream = file.getInputStream();
        XSSFWorkbook Workbook = new XSSFWorkbook(inputStream);
 
        XSSFSheet sheet = Workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        for (int rowNum = 1; rowNum <= lastRowNum; rowNum++) {
            XSSFRow row = sheet.getRow(rowNum);
            if (row != null){
            	Student student = new Student();
                //使用了getStringCellValue()方法来获取值，POI会判断单元格的类型，如果非字符串类型就会抛出上面的异常。
                //所以先使用setCellType()方法先将该单元格的类型设置为STRING
                //然后poi会根据字符串读取它
            	row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
                
                //姓名为空则读取下一行
                String stuname = row.getCell(1).getStringCellValue();
            	if(StringUtils.isEmpty(stuname)) {
            		continue;
            	}
            	student.setClassid(classid);
            	student.setStuno(row.getCell(0).getStringCellValue());
            	student.setStuname(row.getCell(1).getStringCellValue());
            	student.setSex(row.getCell(2).getStringCellValue());
            	student.setOrigin(row.getCell(3).getStringCellValue());
            	student.setTel(row.getCell(4).getStringCellValue());
            	student.setIdcard(row.getCell(5).getStringCellValue());
            	student.setAddress(row.getCell(6).getStringCellValue());
            	student.setPolitical(row.getCell(7).getStringCellValue());
                list.add(student);
            }
        }
        return list;
    }
}
