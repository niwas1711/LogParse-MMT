package com.makemytrip.logparser.Service;

import java.text.ParseException;

public interface Occurance
	{
    int logoccurance(String value);
		int logoccuranceAND(String value,String value2);
		int logoccuranceOR(String value,String value2);


	}
