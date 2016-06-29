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
 * д��һ��Excel�ļ�
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
			
			WritableCellFormat wcf_value;			// ���������ʽ
			WritableCellFormat wcf_value_left;
			WritableCellFormat wcf_key;				// ��ͷ��ʽ
			WritableCellFormat wcf_name_left;		// ������ʽ
			WritableCellFormat wcf_name_right;		// ������ʽ
			WritableCellFormat wcf_name_center;		// ������ʽ
			WritableCellFormat wcf_title;			// ҳ������ʽ
			WritableCellFormat wcf_percent_float;
			//�������ʽ
			WritableFont wf_key =new jxl.write.WritableFont(WritableFont.createFont("΢���ź�"),10,WritableFont.BOLD);
			WritableFont wf_value = new jxl.write.WritableFont(WritableFont.createFont("΢���ź�"),10,WritableFont.NO_BOLD);
			//���õ�Ԫ����ʽ
			wcf_value = new WritableCellFormat(wf_value);
			//���õ�Ԫ��������ʽ
			wcf_value.setAlignment(jxl.format.Alignment.CENTRE);  // ����ˮƽ������ʽ
			wcf_value.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);			//��Ԫ��ֱ������ʽ
			wcf_value.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN);		//��Ԫ��߿���ʽ
			
			
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
			
			jxl.write.NumberFormat wf_percent_float = new jxl.write.NumberFormat("0.00");//���嵥Ԫ������������		
			wcf_percent_float = new jxl.write.WritableCellFormat(wf_value,wf_percent_float);
			wcf_percent_float.setAlignment(jxl.format.Alignment.CENTRE);
			wcf_percent_float.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			wcf_percent_float.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN);
			
			WritableFont wf_title = new jxl.write.WritableFont(WritableFont.createFont("΢���ź�"), 12, WritableFont.NO_BOLD);		//���������ʽ
			wcf_title = new WritableCellFormat(wf_title);
			wcf_title.setAlignment(Alignment.CENTRE);
			wcf_title.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN);		
			/******   �������ʽend    *****/
			
			
			//���ʱ������������ļ�
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");			
			// 1. ���ļ�
			WritableWorkbook book = Workbook.createWorkbook(new File("d:\\testruslt\\"+"testresult"+df.format(new Date())+".xls"));
			// 2. ������Ϊ����һҳ���Ĺ���������0��ʾ���ǵ�һҳ
			WritableSheet sheet = book.createSheet("���Խ��", 0);
			// �����п�
			sheet.setColumnView(0, 24);			
	
			int startRow = 0;  //������ʼ��
			int startColumn = 0;  // ������ʼ��
			 //����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����,���ĸ�����Ϊ��ʽ
			Label label = new Label(startRow, startColumn, "Ӧ��Activity",wcf_title);
			// 4. ������õĵ�Ԫ����ӵ���������
			sheet.addCell(label);
			
			startApp.StartAPP.start();
		
			//��ȡ����ʱ������
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
			
			//��ȡӦ��������ʱ��
			Label label4 = new Label(2, 0, "Ӧ��������ʱ��",wcf_title);
			// 4. ������õĵ�Ԫ����ӵ���������
			sheet.addCell(label4);
			for (int i = 0; i < 10; i++) {
				startApp.StartAPP.start();
				thearSleep.ThearSleep.sleep(5000);
				getParameter.InPutKey.inputkey(4);
				jxl.write.Number label5= new jxl.write.Number(2, i+1, startTime.StartAPPTime.gettime(),wcf_title);
//				Label label5 = new Label(2, i+1, startTime.StartAPPTime.gettime(),wcf_title);
				// 4. ������õĵ�Ԫ����ӵ���������
				sheet.addCell(label5);
			}				
			clearChace.Clearpackage.cleanAPP();
			thearSleep.ThearSleep.sleep(5000);
			
			//��ȡӦ��������ʱ��
			Label label2 = new Label(startRow+1, startColumn, "Ӧ��������ʱ��",wcf_title);
			// 4. ������õĵ�Ԫ����ӵ���������
			sheet.addCell(label2);
			for (int i = 0; i < 10; i++) {				
				startApp.StartAPP.start();
				thearSleep.ThearSleep.sleep(3000);
				clearChace.Clearpackage.cleanAPP();
				jxl.write.Number label3= new jxl.write.Number(1, i+1, startTime.StartAPPTime.gettime(),wcf_title);
//				Label label3 = new Label(1, i+1, startTime.StartAPPTime.gettime(),wcf_title);
				// 4. ������õĵ�Ԫ����ӵ���������
				sheet.addCell(label3);
			}
			clearChace.Clearpackage.cleanAPP();			

		
//			Label label2 = new Label(1,0,getParameter.GetActivityName.getActivityName(),wcf_key);
//			sheet.addCell(label2);
			// 5. ������ֵ���� ����ʹ��Number��������·�����������﷨����
//			jxl.write.Number number = new jxl.write.Number(1, 0, 555.1254);
//			sheet.addCell(number); 
			// 6 .д�����ݲ��ر��ļ�
			book.write();
			book.close();
			System.out.println("д��ɹ���");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
