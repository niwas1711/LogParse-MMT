package com.makemytrip.logparser.Service.impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.makemytrip.logparser.Model.LogModel;
import com.makemytrip.logparser.Service.ParseLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class ParseLogImpl implements ParseLog
	{

		/***
		 *
		 * @param
		 * @return List of Json Data
		 */

		@Override
		public List<LogModel> parse()
			{
				List<LogModel> logdata = new ArrayList<>();

				ObjectMapper mapper = new ObjectMapper();
				JsonFactory jsonFactory = new JsonFactory();



				try (Stream<Path> walk = Files.walk(Paths.get("LogData"))) {
					List<Path> LogLocaton = walk.filter(Files::isRegularFile).collect(Collectors.toList());

					for(int i=0;i<LogLocaton.size();i++)
					{
						BufferedReader br =Files.newBufferedReader(LogLocaton.get(i));
						Iterator<LogModel> value = mapper
								                           .readValues(jsonFactory.createParser(br), LogModel.class);


						value.forEachRemaining((j) -> { logdata.add(j);});

					}

				}catch (IOException e) {
					e.printStackTrace();
				}

				return logdata;
			}




	}
