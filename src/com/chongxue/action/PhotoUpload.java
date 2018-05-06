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
		Map session = ServletActionContext.getContext().getSession(); //获得session;
		String username = (String) session.get("username"); //获得username;

		InputStream is = new FileInputStream(myFile); //创建一个输入流

		String photoPath = ServletActionContext.getServletContext().getRealPath("/user/photo/" + username); //设置文件保存目录
		
		File filePhotoPath = new File(photoPath);
		if(!filePhotoPath.isDirectory()) { //不存在就新建目录;
			filePhotoPath.mkdir(); //创建单集目录;
		}
		
		String extension = FilenameUtils.getExtension(this.getMyFileFileName()); //得到文件后缀;
		String filename = UUID.randomUUID().toString() + "."+ extension; ////解决中文文件名问题，不直接用原来的文件名而是生成一个独一无二的序号作为文件的唯一标识;

		File tofile = new File(photoPath,filename); //设置目标文件
		
		OutputStream os = new FileOutputStream(tofile); //使用输出流来包装目标文件
		byte[] buffer = new byte[1024];
		int length = 0;
		while((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}

		is.close(); //关闭输入流
		os.close(); //关闭输出流

		return this.SUCCESS;

	}



	

}

