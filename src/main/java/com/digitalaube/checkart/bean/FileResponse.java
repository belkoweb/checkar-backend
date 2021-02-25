package com.digitalaube.checkart.bean;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileResponse {
	
	 // You may add other file properties like size, file type, etc.
    private String fileName;
    
    public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	private byte[] photo;
 
    public FileResponse(String fileName, MultipartFile file) {
        this.fileName = fileName;
        try {
			this.photo = file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
 
    public String getFileName() {
        return fileName;
    }
 
    public void setFileName(String fileName,  byte[] photo) {
        this.fileName = fileName;
    }

}
