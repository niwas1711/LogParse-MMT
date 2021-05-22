package com.makemytrip.logparser.Service.impl;

import com.makemytrip.logparser.Model.LogModel;
import com.makemytrip.logparser.Service.Occurance;
import com.makemytrip.logparser.Utility.Utility;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OccuranceImpl implements Occurance
	{

		@Autowired
		ParseLogImpl parseLog = new ParseLogImpl();

		@Autowired
		Utility util = new Utility();

		@Override
		public int logoccurance(String value)
			{
				List<LogModel> logdata = parseLog.parse();
				Map<String, Long> result = util.occurenceMap(logdata);

			//Making search for all uppercase and lowercase data
				Map<String, Long> UppercaseMap = 	result.entrySet().stream()
						.collect(Collectors.toMap(entry -> entry.getKey().toUpperCase(), entry -> entry.getValue()));



				int res = Math.toIntExact(UppercaseMap.get(value.toUpperCase()));

				if (res > 0) {
					return res;
				}
				else {
					return -1;
				}

			}

		@Override
		public int logoccuranceAND(String value, String value2)
			{
				List<LogModel> logdata = parseLog.parse();
				int res=0;
				for(int i=0;i<logdata.size();i++)
				{
					String tmp = logdata.get(i).getLevel() +" "+logdata.get(i).getPfm()+" "+logdata.get(i).getStep()+" "+
												logdata.get(i).getTimestamp();
					if(tmp.contains(value) && tmp.contains(value2))
						res++;
				}
				return res;
			}

		@Override
		public int logoccuranceOR(String value, String value2)
			{
				List<LogModel> logdata = parseLog.parse();
				int res=0;
				for(int i=0;i<logdata.size();i++)
				{
					String tmp = logdata.get(i).getLevel() +" "+logdata.get(i).getPfm()+" "+logdata.get(i).getStep()+" "+
							             logdata.get(i).getTimestamp();
					if(tmp.contains(value) || tmp.contains(value2))
						res++;
				}
				return res;
			}






	}
