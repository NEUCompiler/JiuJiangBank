package jxl.tablemaker.service;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.ob.dao.DealinformDAO;
import com.ob.dao.impl.DealinformDAOImpl;
import com.ob.model.Dealinform;

import Operater.db.Operater;
import Operater.db.OperaterDAO;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.CellFormat;
import jxl.tablemaker.db.Appointment;
import jxl.tablemaker.db.AppointmentDAO;
import jxl.tablemaker.db.AppointmentId;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ToexcelService {

	DealinformDAO DealDao = new DealinformDAOImpl();
	AppointmentDAO Appdao = new AppointmentDAO();
	OperaterDAO Operdao   = new OperaterDAO();


	public void writeDealExcel() {
		String[] title = { "编号", "源账户", "交易时间", "交易类型", "收支", "目标账户", "交易状态",
				"金额" };
		try {
			// 获得开始时间
			long start = System.currentTimeMillis();
			// 输出的excel的路径
			String filePath = "d:\\DealinformationToexce.xls";
			// 创建Excel工作薄
			WritableWorkbook wwb;
			// 新建立一个jxl文件,即在d盘下生成testJXL.xls
			OutputStream os = new FileOutputStream(filePath);
			wwb = Workbook.createWorkbook(os);
			// 添加第一个工作表并设置第一个Sheet的名字
			WritableSheet sheet = wwb.createSheet("产品清单", 0);
			Label label;
			for (int i = 0; i < title.length; i++) {
				// Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z
				// 在Label对象的子对象中指明单元格的位置和内容
				label = new Label(i, 0, title[i]);
				// label = new Label(i, 0, title[i], getHeader());
				// 将定义好的单元格添加到工作表中
				sheet.addCell(label);
			}
			// 下面是填充数据
			/*
			 * 保存数字到单元格，需要使用jxl.write.Number 必须使用其完整路径，否则会出现错误
			 */

			List list = (List) DealDao.findAll();
			
			int i=1;

			for(Iterator I = list.iterator();I.hasNext();){
				
				

				Dealinform m = (Dealinform) I.next();

				label = new Label(0, i, m.getDealid());

				sheet.addCell(label);
				label = new Label(1, i, m.getAccountid());

				sheet.addCell(label);
				label = new Label(2, i, m.getDealtime().toString());

				sheet.addCell(label);
				label = new Label(3, i, m.getDealinform());

				sheet.addCell(label);
				label = new Label(4, i, m.getDealtype().toString());

				sheet.addCell(label);
				
				label = new Label(5, i, m.getDealDesti());

				sheet.addCell(label);

				label = new Label(6, i, m.getDealstate().toString());

				sheet.addCell(label);
				label = new Label(7, i, m.getDeaamountl().toString());

				sheet.addCell(label);
				
				i++;
			}

			wwb.write();
			// 关闭文件
			wwb.close();
			long end = System.currentTimeMillis();
			System.out.println("----完成该操作共用的时间是:" + (end - start) / 1000);
		} catch (Exception e) {
			System.out.println("---出现异常---");
			e.printStackTrace();
		}
	}

	private static CellFormat getHeader() {

		return null;
	}

	public void writeAppointExcel() {
		String[] title = { "编号", "客户号", "交易金额", "日期", "网点号"};
try {
	// 获得开始时间
	long start = System.currentTimeMillis();
	// 输出的excel的路径
	String filePath = "d:\\AppointmentToexce.xls";
	// 创建Excel工作薄
	WritableWorkbook wwb;
	// 新建立一个jxl文件,即在d盘下生成testJXL.xls
	OutputStream os = new FileOutputStream(filePath);
	wwb = Workbook.createWorkbook(os);
	// 添加第一个工作表并设置第一个Sheet的名字
	WritableSheet sheet = wwb.createSheet("大额预约", 0);
	Label label;
	for (int i = 0; i < title.length; i++) {
		// Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z
		// 在Label对象的子对象中指明单元格的位置和内容
		label = new Label(i, 0, title[i]);
		// label = new Label(i, 0, title[i], getHeader());
		// 将定义好的单元格添加到工作表中
		sheet.addCell(label);
	}
	List list = (List) Appdao.findAll();
	
	int i=1;

	for(Iterator I = list.iterator();I.hasNext();){
		
		

		Appointment m = (Appointment) I.next();
		

		label = new Label(0, i, m.getId().getAppointid());
		System.out .println(m.getAppointid());

		sheet.addCell(label);
		label = new Label(1, i, m.getId().getClientid());

		sheet.addCell(label);
		label = new Label(2, i, m.getId().getAmount());

		sheet.addCell(label);
		label = new Label(3, i, m.getId().getDate().toString());

		sheet.addCell(label);
		label = new Label(4, i, m.getId().getWebsiteid());

		sheet.addCell(label);
		i++;
	}
	wwb.write();
	wwb.close();
		
	}catch (Exception e) {
		System.out.println("---出现异常---");
		e.printStackTrace();}

}

	public void writeOperaterExcel() {
		String[] title = { "操作员号", "姓名", "密码", "类型", "性别","生日"};
		try {
			// 获得开始时间
			long start = System.currentTimeMillis();
			// 输出的excel的路径
			String filePath = "d:\\OperaterToexce.xls";
			// 创建Excel工作薄
			WritableWorkbook wwb;
			// 新建立一个jxl文件,即在d盘下生成testJXL.xls
			OutputStream os = new FileOutputStream(filePath);
			wwb = Workbook.createWorkbook(os);
			// 添加第一个工作表并设置第一个Sheet的名字
			WritableSheet sheet = wwb.createSheet("操作员表", 0);
			Label label;
			for (int i = 0; i < title.length; i++) {
				// Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z
				// 在Label对象的子对象中指明单元格的位置和内容
				label = new Label(i, 0, title[i]);
				// label = new Label(i, 0, title[i], getHeader());
				// 将定义好的单元格添加到工作表中
				sheet.addCell(label);
			}
			List list = (List) Operdao.findAll();
			
			int i=1;

			for(Iterator I = list.iterator();I.hasNext();){
				
				

				Operater m = (Operater) I.next();
				

				label = new Label(0, i, m.getOperaterId().toString());

				sheet.addCell(label);
				label = new Label(1, i, m.getOperaterName());

				sheet.addCell(label);
				label = new Label(2, i, m.getOperaterPassW());

				sheet.addCell(label);
				label = new Label(3, i, m.getOperaterType());

				sheet.addCell(label);
				label = new Label(4, i, m.getOperaterSex());

				sheet.addCell(label);
				label = new Label(5, i, m.getOperaterBirthday().toString());

				sheet.addCell(label);
				i++;
			}
			wwb.write();
			wwb.close();
				
			}catch (Exception e) {
				System.out.println("---出现异常---");
				e.printStackTrace();}

}
}

