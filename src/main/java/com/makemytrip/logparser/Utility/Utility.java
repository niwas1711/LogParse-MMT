package com.makemytrip.logparser.Utility;

import com.makemytrip.logparser.Model.LogModel;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class Utility
	{


		 public Date ConvertStringTodate(String date)
			 {
				 System.out.println(date);
				 Date parsedDate = null;

				 try {
					 DateFormat   dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					 parsedDate = dateFormat.parse(date);
					// Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
					// System.out.println(timestamp);
					 return parsedDate;
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
				 return null;
			 }
		public Map<String, Long> occurenceMap(List<LogModel> logparsedata)
			{
				Map<String, Long> occurenceMap = new HashMap<>();

				Map<String, Long> PfmCounts =
						logparsedata.stream()
								.collect(Collectors.groupingBy(LogModel::getPfm, Collectors.counting()));

				Map<String, Long> LevelCounts =
						logparsedata.stream()
								.collect(Collectors.groupingBy(LogModel::getLevel, Collectors.counting()));

				Map<String, Long> StepCounts =
						logparsedata.stream()
								.collect(Collectors.groupingBy(LogModel::getStep, Collectors.counting()));

				Map<String, Long> TimestampCounts =
						logparsedata.stream()
								.collect(Collectors.groupingBy(LogModel::getTimestamp, Collectors.counting()));

				occurenceMap.putAll(PfmCounts);
				occurenceMap.putAll(LevelCounts);
				occurenceMap.putAll(StepCounts);
				occurenceMap.putAll(TimestampCounts);

				System.out.println(occurenceMap);
				return occurenceMap;


			}


	}
