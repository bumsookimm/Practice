package com.example.demo.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SchedulerDto {

	private int schedule_id;
	private String user_id;
	private Date schedule_date;
	private String content;
	private Date created_at;
	private Date update_at;
	private int isdone;

}
