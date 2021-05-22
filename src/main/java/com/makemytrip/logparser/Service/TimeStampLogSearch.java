package com.makemytrip.logparser.Service;

public interface TimeStampLogSearch
	{
		 int logtimestamp(String start, String end);
		 int logtimestamponevalue(String Start,String end,String value);

		 int logtimestamponevalueAnd(String Start,String end,String value,String value2);
		int logtimestamponevalueOr(String Start,String end,String value,String value2);


	}
