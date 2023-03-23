package com.ldsg.jwsystem.enums;

public enum Message {

	OLDPWDERROR(1, "旧密码错误"), UPDATEPWDSUCCESS(2, "密码修改成功"), FILEERROR(3, "文件上传错误，重新上传"), 
	FILETYPEWRONG(4, "文件上传格式错误，请重新上传"), FILEUPLOADSUCCESS(5, "文件上传成功"), 
	FILEUPLOADFAILURE(6, "文件内容读取失败，请重试"), CLASSNOEXIST(7, "期班号已经存在"), CLASSADDSUCCESS(8, "期班添加成功"),
	CLASSUPDATESUCCESS(9, "期班信息更新成功"), COURSENAMEEXISTENCE(10, "该期班存在同名课程"), COURSEADDSUCCESS(11, "课程录入成功"),
	DETAILCOURSECONFLICT(12, "上课时间 / 任课教员 / 授课教室存在冲突"), DETAILCOURSEADDSUCCESS(13, "细化课表添加成功");
	

	private int code;
	private String msg;

	Message(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
