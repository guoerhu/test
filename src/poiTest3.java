
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;



public class poiTest3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {		
		try {
//		response.setCharacterEncoding("UTF-8");
//		request.setCharacterEncoding("UTF-8");
//		String saBeginDate = request.getParameter("saBeginDate");
//		String saEndDate = request.getParameter("saEndDate");
		String saBeginDate = "2014-02-23";
		String saEndDate = "2014-12-24";
		//Map params = new HashMap();
/*		if ((request.getParameter("saBeginDate") == null || ""
				.equals(request.getParameter("saBeginDate")))
				&& ((request.getParameter("saEndDate") == null || ""
						.equals(request.getParameter("saEndDate"))))) {
			Calendar cal = Calendar.getInstance();
			// cal.add(Calendar.DATE, -1); //得到前一天
			cal.add(Calendar.MONTH, -1); // 得到前一个月
			long date = cal.getTimeInMillis();
			String beginTime = DateUtil.formatDateToStr(new Date(date),
					"yyyyMMdd");
			String endTime = DateUtil.formatDateToStr(new Date(),
					"yyyyMMdd");
			params.put("saBeginDate", beginTime);
			params.put("saEndDate", endTime);
		} else {
			saBeginDate = saBeginDate.replaceAll("-", "");
			saEndDate = saEndDate.replaceAll("-", "");
			params.put("saBeginDate", saBeginDate);
			params.put("saEndDate", saEndDate);
		}*/
	
//		List<Map> list = custSignService.SelectQuery(params);
//		logger.info("list size------------------"+list.size());
		Map   m=new HashMap();
		/*m.put("RN","123");
		m.put("ORG_ID","234");
		m.put("ORG_NAME","234");
		m.put("LAST_CUST_NUM","234");
		m.put("TELLER_SIGN_NUM","234");
		m.put("EBANK_SIGN_NUM","234");
		m.put("SELF_SIGN_NUM","234");
		m.put("TELLER_CANCLE_NUM","234");
		m.put("EBANK_CANCLE_NUM","234");
		m.put("SELF_CANCLE_NUM","234");
		m.put("CURRENT_CUST_NUM","234");
		m.put("ADD_CUST_NUM","234");*/
		

		List<Map> list =  new ArrayList<Map>();
		 
		HSSFWorkbook workbook = new HSSFWorkbook();
		@SuppressWarnings("unused")
		HSSFSheet hfs = workbook.createSheet("交易笔数统计");	
		HSSFCellStyle style = workbook.createCellStyle(); // 样式对象
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
		
		HSSFRow row = hfs.createRow(0);
		HSSFCell hfc = null;
		for (int j = 0; j < 4; j++) {
			hfc = row.createCell((short) j);
			switch (j) {
			case 0:
				hfc.setCellValue("开始日期");
				hfc.setCellStyle(style); // 样式，居中
				break;
			case 1:
				hfc.setCellValue(saBeginDate);
				hfc.setCellStyle(style); 
				break;
			case 2:
				hfc.setCellValue("结束日期");
				hfc.setCellStyle(style); 
				break;
			case 3:
				hfc.setCellValue(saEndDate);
				hfc.setCellStyle(style);
				break;
			default:
				break;
			}
		}
		row = hfs.createRow(1);	
		HSSFRow row3 = hfs.createRow(2);	
		HSSFRow row4 = hfs.createRow(3);
		for (int j = 0; j < 8; j++) {
			// 四个参数分别是：起始行，起始列，结束行，结束列
			switch (j) {
			case 0:
				hfs.addMergedRegion(new Region(1, (short) j, 3, (short) j));
				hfc = row.createCell((short) j);
				hfc.setCellValue("机构号");
				hfc.setCellStyle(style);
				break;
			case 1:
				hfs.addMergedRegion(new Region(1, (short) j, 3, (short) j));
				hfc = row.createCell((short) j);
				hfc.setCellValue("机构名称");
				hfc.setCellStyle(style);
				break;
			case 2:
				hfs.addMergedRegion(new Region(1, (short) j, 2, (short) (j+1)));
				hfc = row.createCell((short) j);
				hfc.setCellValue("行内转账");
				hfc.setCellStyle(style);
				hfc = row4.createCell((short) j);
				hfc.setCellValue("成功");
				hfc.setCellStyle(style);
				hfc = row4.createCell((short) (j+1));
				hfc.setCellValue("失败");
				hfc.setCellStyle(style);
				break;
			case 3:
				hfs.addMergedRegion(new Region(1, (short) (j+1), 2, (short) (j+2)));
				hfc = row.createCell((short) (j+1));
				hfc.setCellValue("跨行转账");
				hfc.setCellStyle(style);
				hfc = row4.createCell((short) (j+1));
				hfc.setCellValue("成功");
				hfc.setCellStyle(style);
				hfc = row4.createCell((short) (j+2));
				hfc.setCellValue("失败");
				hfc.setCellStyle(style);
				break;
			case 4:
				hfs.addMergedRegion(new Region(1, (short) (j+2), 2, (short) (j+3)));
				hfc = row.createCell((short) (j+2));
				hfc.setCellValue("手机号转账");
				hfc.setCellStyle(style);
				hfc = row4.createCell((short) (j+2));
				hfc.setCellValue("成功");
				hfc.setCellStyle(style);
				hfc = row4.createCell((short) (j+3));
				hfc.setCellValue("失败");
				hfc.setCellStyle(style);
				break;
			case 5:
				hfs.addMergedRegion(new Region(1, (short) (j+3), 2, (short) (j+4)));
				hfc = row.createCell((short) (j+3));
				hfc.setCellValue("信用卡还款");
				hfc.setCellStyle(style);
				hfc = row4.createCell((short) (j+3));
				hfc.setCellValue("成功");
				hfc.setCellStyle(style);
				hfc = row4.createCell((short) (j+4));
				hfc.setCellValue("失败");
				hfc.setCellStyle(style);
				break;
			case 6:
				hfs.addMergedRegion(new Region(1, (short) (j+4), 1, (short) (j+7)));
				hfc = row.createCell((short) (j+4));
				hfc.setCellValue("理财业务");
				hfc.setCellStyle(style);
				hfs.addMergedRegion(new Region(2, (short) (j+4), 2, (short) (j+5)));
				hfc = row3.createCell((short) (j+4));
				hfc.setCellValue("基金");
				hfc.setCellStyle(style);
				hfc = row4.createCell((short) (j+4));
				hfc.setCellValue("成功");
				hfc.setCellStyle(style);
				hfc = row4.createCell((short) (j+5));
				hfc.setCellValue("失败");
				hfc.setCellStyle(style);
				hfs.addMergedRegion(new Region(2, (short) (j+6), 2, (short) (j+7)));
				hfc = row3.createCell((short) (j+6));
				hfc.setCellValue("理财");
				hfc.setCellStyle(style);
				hfc = row4.createCell((short) (j+6));
				hfc.setCellValue("成功");
				hfc.setCellStyle(style);
				hfc = row4.createCell((short) (j+7));
				hfc.setCellValue("失败");
				hfc.setCellStyle(style);
				break;
			case 7:
				hfs.addMergedRegion(new Region(1, (short) (j+7), 2, (short) (j+8)));
				hfc = row.createCell((short) (j+7));
				hfc.setCellValue("总计");
				hfc.setCellStyle(style);
				hfc = row4.createCell((short) (j+7));
				hfc.setCellValue("成功");
				hfc.setCellStyle(style);
				hfc = row4.createCell((short) (j+8));
				hfc.setCellValue("失败");
				hfc.setCellStyle(style);
				break;
			default:
				break;
			}
		}
		for (int i = 1; i <= list.size(); i++) {
			row = hfs.createRow(i+3);
			Map map = list.get(i - 1);
			for (int j = 0; j < 16; j++) {
				hfc = row.createCell((short) j);
				switch (j) {
				case 0:
					hfc.setCellValue(null==map.get("ORG_ID")?"":map.get("ORG_ID").toString());
					break;
				case 1:
					hfc.setCellValue(null==map.get("ORG_NAME")?"":map.get("ORG_NAME").toString());
					break;
				case 2:
					hfc.setCellValue(null==map.get("INNER_SUC_NUM")?"":map.get("INNER_SUC_NUM").toString());
					break;
				case 3:
					hfc.setCellValue(null==map.get("INNER_FAIL_NUM")?"":map.get("INNER_FAIL_NUM").toString());
					break;
				case 4:
					hfc.setCellValue(null==map.get("OUTER_SUC_NUM")?"":map.get("OUTER_SUC_NUM").toString());
					break;
				case 5:
					hfc.setCellValue(null==map.get("OUTER_FAIL_NUM")?"":map.get("OUTER_FAIL_NUM").toString());
					break;
				case 6:
					hfc.setCellValue(null==map.get("MOBILE_SUC_NUM")?"":map.get("MOBILE_SUC_NUM").toString());
					break;
				case 7:
					hfc.setCellValue(null==map.get("MOBILE_FAIL_NUM")?"":map.get("MOBILE_FAIL_NUM").toString());
					break;
				case 8:
					hfc.setCellValue(null==map.get("CREIN_SUC_NUM")?"":map.get("CREIN_SUC_NUM").toString());
					break;
				case 9:
					hfc.setCellValue(null==map.get("CREIN_FAIL_NUM")?"":map.get("CREIN_FAIL_NUM").toString());
					break;
				case 10:
					hfc.setCellValue(null==map.get("FUN_SUC_NUM")?"":map.get("FUN_SUC_NUM").toString());
					break;
				case 11:
					hfc.setCellValue(null==map.get("FUN_FAIL_NUM")?"":map.get("FUN_FAIL_NUM").toString());
					break;
				case 12:
					hfc.setCellValue(null==map.get("FINANCE_SUC_NUM")?"":map.get("FINANCE_SUC_NUM").toString());
					break;
				case 13:
					hfc.setCellValue(null==map.get("FINANCE_FAIL_NUM")?"":map.get("FINANCE_FAIL_NUM").toString());
					break;
				case 14:
					hfc.setCellValue(null==map.get("TOTAL_SUC_NUM")?"":map.get("TOTAL_SUC_NUM").toString());
					break;
				case 15:
					hfc.setCellValue(null==map.get("TOTAL_FAIL_NUM")?"":map.get("TOTAL_FAIL_NUM").toString());
					break;
				default:
					break;
				}
			}
		}
		FileOutputStream fileOut = new FileOutputStream("交易笔数统计.xls");
		workbook.write(fileOut);
		fileOut.close();
		System.out.print("OK");
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	}
	

}