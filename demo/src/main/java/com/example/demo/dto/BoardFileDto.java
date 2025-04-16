package com.example.demo.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardFileDto {
	
    private int fileNo;
    private int boardNo;
    private String originalName;
    private String saveName;
    private String filePath;
    private long fileSize;
    private String fileExtension;
    private Date uploadedDate;
}
