package com.chongxue.action;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.UUID;






import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;






import com.opensymphony.xwork2.ActionSupport;



@SuppressWarnings("serial")
public class PhotoUpload  extends ActionSupport {

	private File myFile;
	private String myFileContentType;
	private String myFileFileName;

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}



	@SuppressWarnings("static-access")
	public String execute() throws Exception {

		@SuppressWarnings("rawtypes")
		Map session = ServletActionContext.getContext().getSession(); //���session;
		String username = (String) session.get("username"); //���username;

		InputStream is = new FileInputStream(myFile); //����һ��������

		String photoPath = ServletActionContext.getServletContext().getRealPath("/user/photo/" + username); //�����ļ�����Ŀ¼
		
		File filePhotoPath = new File(photoPath);
		if(!filePhotoPath.isDirectory()) { //�����ھ��½�Ŀ¼;
			filePhotoPath.mkdir(); //��������Ŀ¼;
		}
		
		String extension = FilenameUtils.getExtension(this.getMyFileFileName()); //�õ��ļ���׺;
		String filename = UUID.randomUUID().toString() + "."+ extension; ////��������ļ������⣬��ֱ����ԭ�����ļ�����������һ����һ�޶��������Ϊ�ļ���Ψһ��ʶ;

		File tofile = new File(photoPath,filename); //����Ŀ���ļ�
		
		OutputStream os = new FileOutputStream(tofile); //ʹ�����������װĿ���ļ�
		byte[] buffer = new byte[1024];
		int length = 0;
		while((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}

		is.close(); //�ر�������
		os.close(); //�ر������

		return this.SUCCESS;

	}



	

}

