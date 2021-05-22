package com.makemytrip.logparser.Model;


import java.util.Date;
import lombok.Data;

@Data
public class LogModel
	{
   private String pfm;
   private String level;
   private String Step;
   private String timestamp;


	//	pfm":"DESKTOP", "level":"DEBUG", "step" : "REVIEW", "timestamp":"2020-11-18 13:44:11.039+0530"

	}
