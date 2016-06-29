package jxlExcel;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * 写入一个Excel文件
 * @author LiuBo
 *
 */
public class WriteExcel {

	/**
	 * @param args
	 * @throws Throwable 
	 */
	public static void Excel() throws Throwable {
		try {
			
			WritableCellFormat wcf_value;			// 表格数据样式
			WritableCellFormat wcf_value_left;
			WritableCellFormat wcf_key;				// 表头样式
			WritableCellFormat wcf_name_left;		// 表名样式
			WritableCellFormat wcf_name_right;		// 表名样式
			WritableCellFormat wcf_name_center;		// 表名样式
			WritableCellFormat wcf_title;			// 页名称样式
			WritableCellFormat wcf_percent_float;
			//定义表格格式
			WritableFont wf_key =new jxl.write.WritableFont(WritableFont.createFont("微软雅黑"),10,WritableFont.BOLD);
			WritableFont wf_value = new jxl.write.WritableFont(WritableFont.createFont("微软雅黑"),10,WritableFont.NO_BOLD);
			//设置单元格样式
			wcf_value = new WritableCellFormat(wf_value);
			//设置单元格字体样式
			wcf_value.setAlignment(jxl.format.Alignment.CENTRE);  // 设置水平对齐样式
			wcf_value.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);			//单元格垂直对齐样式
			wcf_value.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN);		//单元格边框样式
			
			
			wcf_value_left =new WritableCellFormat(wf_value);
			wcf_value_left.setAlignment(jxl.format.Alignment.LEFT);
			wcf_value_left.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			wcf_value_left.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			wcf_value_left.setWrap(true);
			
			wcf_key = new WritableCellFormat(wf_key);
			wcf_key.setAlignment(jxl.format.Alignment.CENTRE);
			wcf_key.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN);
			
			wcf_name_left = new WritableCellFormat(wf_key);
			wcf_name_left.setAlignment(Alignment.LEFT);
			wcf_name_left.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			
			wcf_name_right = new WritableCellFormat(wf_key);
			wcf_name_right.setAlignment(Alignment.LEFT);
			
			wcf_name_center = new WritableCellFormat(wf_key);
			wcf_name_center.setAlignment(Alignment.CENTRE);
			
			jxl.write.NumberFormat wf_percent_float = new jxl.write.NumberFormat("0.00");//定义单元浮点数据类型		
			wcf_percent_float = new jxl.write.WritableCellFormat(wf_value,wf_percent_float);
			wcf_percent_float.setAlignment(jxl.format.Alignment.CENTRE);
			wcf_percent_float.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			wcf_percent_float.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN);
			
			WritableFont wf_title = new jxl.write.WritableFont(WritableFont.createFont("微软雅黑"), 12, WritableFont.NO_BOLD);		//定义标题样式
			wcf_title = new WritableCellFormat(wf_title);
			wcf_title.setAlignment(Alignment.CENTRE);
			wcf_title.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN);		
			/******   定义表格格式end    *****/
			
			
			//添加时间戳，重命名文件
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");			
			// 1. 打开文件
			WritableWorkbook book = Workbook.createWorkbook(new File("d:\\testruslt\\"+"testresult"+df.format(new Date())+".xls"));
			// 2. 生成名为“第一页”的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet("测试结果", 0);
			// 设置列宽
			sheet.setColumnView(0, 24);			
	
			int startRow = 0;  //设置起始行
			int startColumn = 0;  // 设置起始列
			 //创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容,第四个参数为样式
			Label label = new Label(startRow, startColumn, "应用Activity",wcf_title);
			// 4. 将定义好的单元格添加到工作表中
			sheet.addCell(label);
			
			startApp.StartAPP.start();
		
			//获取启动时的流量
			for (int i=0;i<10;i++){
				int RawData = testData.GetData.tcp_rcv()+testData.GetData.tcp_snd();
				System.out.println(RawData);
				getParameter.InPutKey.inputkey(4);
				startApp.StartAPP.start();
				thearSleep.ThearSleep.sleep(3000);
				int RawData2 = testData.GetData.tcp_rcv()+testData.GetData.tcp_snd();
				System.out.println(RawData2);
				thearSleep.ThearSleep.sleep(3000);
				int total = RawData2-RawData;
				System.out.println(total);
				getParameter.InPutKey.inputkey(4);
				startApp.StartAPP.start();
				jxl.write.Number num= new jxl.write.Number(0, i+1, total,wcf_title);
				sheet.addCell(num);
			}
			clearChace.Clearpackage.cleanAPP();
			thearSleep.ThearSleep.sleep(5000);
			
			//获取应用热启动时间
			Label label4 = new Label(2, 0, "应用热启动时间",wcf_title);
			// 4. 将定义好的单元格添加到工作表中
			sheet.addCell(label4);
			for (int i = 0; i < 10; i++) {
				startApp.StartAPP.start();
				thearSleep.ThearSleep.sleep(5000);
				getParameter.InPutKey.inputkey(4);
				jxl.write.Number label5= new jxl.write.Number(2, i+1, startTime.StartAPPTime.gettime(),wcf_title);
//				Label label5 = new Label(2, i+1, startTime.StartAPPTime.gettime(),wcf_title);
				// 4. 将定义好的单元格添加到工作表中
				sheet.addCell(label5);
			}				
			clearChace.Clearpackage.cleanAPP();
			thearSleep.ThearSleep.sleep(5000);
			
			//获取应用冷启动时间
			Label label2 = new Label(startRow+1, startColumn, "应用冷启动时间",wcf_title);
			// 4. 将定义好的单元格添加到工作表中
			sheet.addCell(label2);
			for (int i = 0; i < 10; i++) {				
				startApp.StartAPP.start();
				thearSleep.ThearSleep.sleep(3000);
				clearChace.Clearpackage.cleanAPP();
				jxl.write.Number label3= new jxl.write.Number(1, i+1, startTime.StartAPPTime.gettime(),wcf_title);
//				Label label3 = new Label(1, i+1, startTime.StartAPPTime.gettime(),wcf_title);
				// 4. 将定义好的单元格添加到工作表中
				sheet.addCell(label3);
			}
			clearChace.Clearpackage.cleanAPP();			

		
//			Label label2 = new Label(1,0,getParameter.GetActivityName.getActivityName(),wcf_key);
//			sheet.addCell(label2);
			// 5. 定义数值类型 必须使用Number的完整包路径，否则有语法歧义
//			jxl.write.Number number = new jxl.write.Number(1, 0, 555.1254);
//			sheet.addCell(number); 
			// 6 .写入数据并关闭文件
			book.write();
			book.close();
			System.out.println("写入成功！");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
