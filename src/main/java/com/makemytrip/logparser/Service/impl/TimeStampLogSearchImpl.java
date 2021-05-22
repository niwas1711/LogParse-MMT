package com.makemytrip.logparser.Service.impl;

import com.makemytrip.logparser.Model.LogModel;
import com.makemytrip.logparser.Service.ParseLog;
import com.makemytrip.logparser.Service.TimeStampLogSearch;
import com.makemytrip.logparser.Utility.Utility;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeStampLogSearchImpl implements TimeStampLogSearch
	{

		@Autowired
		Utility util;

		@Autowired
		ParseLog parseLog;

		@Override
		public int logtimestamp(String start, String end)
			{
				List<LogModel> logdata = parseLog.parse();
				Date StarDate= util.ConvertStringTodate(start);
				System.out.println(StarDate.getTime());
				Date EndDate= util.ConvertStringTodate(end);
				System.out.println(EndDate.getTime());

				Date date = null;
				int temp=0;
				for(int i=0;i<logdata.size();i++)
				{
					System.out.println("inside loop");
					String tmp = logdata.get(i).getLevel() +" "+logdata.get(i).getPfm()+" "+logdata.get(i).getStep();
					date=	util.ConvertStringTodate(logdata.get(i).getTimestamp());

					if (date.getTime() >= StarDate.getTime() && date.getTime() <= EndDate.getTime() )
					{
						temp++;
					}

				}
				return temp;
			}

		@Override
		public int logtimestamponevalue(String Start, String end, String value)
			{
				List<LogModel> logdata = parseLog.parse();
				Date StarDate= util.ConvertStringTodate(Start);
				System.out.println(StarDate.getTime());
				Date EndDate= util.ConvertStringTodate(end);
				System.out.println(EndDate.getTime());

				Date date = null;
				int res=0;
				for(int i=0;i<logdata.size();i++)
				{
					System.out.println("inside loop");
					String tmp = logdata.get(i).getLevel() +" "+logdata.get(i).getPfm()+" "+logdata.get(i).getStep();
					date=	util.ConvertStringTodate(logdata.get(i).getTimestamp());

					if (date.getTime() >= StarDate.getTime() && date.getTime() <= EndDate.getTime() && tmp.contains(value) )
					{
						res++;
					}

				}
				return res;
			}

		@Override
		public int logtimestamponevalueAnd(String Start, String end, String value, String value2)
			{
				List<LogModel> logdata = parseLog.parse();
				Date StarDate= util.ConvertStringTodate(Start);
				System.out.println(StarDate.getTime());
				Date EndDate= util.ConvertStringTodate(end);
				System.out.println(EndDate.getTime());

				Date date = null;
				int res=0;
				for(int i=0;i<logdata.size();i++)
				{
					System.out.println("inside loop");
					String tmp = logdata.get(i).getLevel() +" "+logdata.get(i).getPfm()+" "+logdata.get(i).getStep();
					date=	util.ConvertStringTodate(logdata.get(i).getTimestamp());

					if (date.getTime() >= StarDate.getTime() && date.getTime() <= EndDate.getTime() && tmp.contains(value) && tmp.contains(value2))
					{
						res++;
					}

				}
				return res;
			}

		@Override
		public int logtimestamponevalueOr(String Start, String end, String value, String value2)
			{
				List<LogModel> logdata = parseLog.parse();
				Date StarDate= util.ConvertStringTodate(Start);
				System.out.println(StarDate.getTime());
				Date EndDate= util.ConvertStringTodate(end);
				System.out.println(EndDate.getTime());

				Date date = null;
				int res=0;
				for(int i=0;i<logdata.size();i++)
				{
					System.out.println("inside loop");
					String tmp = logdata.get(i).getLevel() +" "+logdata.get(i).getPfm()+" "+logdata.get(i).getStep();
					date=	util.ConvertStringTodate(logdata.get(i).getTimestamp());

					if (date.getTime() >= StarDate.getTime() && date.getTime() <= EndDate.getTime() && (tmp.contains(value) || tmp.contains(value2)))
					{
						res++;
					}

				}
				return res;
			}
	}
