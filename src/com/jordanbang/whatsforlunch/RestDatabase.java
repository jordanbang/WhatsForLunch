package com.jordanbang.whatsforlunch;

public class RestDatabase {
	private long mId;
	private String mName;
	
	public long getId(){
		return mId;
	}
	
	public void setId(long id){
		mId = id;
	}
	
	public String getName(){
		return mName;
	}
	
	public void setName(String name){
		mName = name;
	}

}
