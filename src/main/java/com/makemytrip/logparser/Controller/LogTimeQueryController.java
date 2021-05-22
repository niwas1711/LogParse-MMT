package com.makemytrip.logparser.Controller;

import com.makemytrip.logparser.Service.TimeStampLogSearch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@Api(value = "LogTimeQueryController APIs", description = "API for quering the Logs, using Timestamp as a String query", tags = {"LogTimeQueryController API"})
public class LogTimeQueryController
	{
		@Autowired
		TimeStampLogSearch timestampsearcService;


		@GetMapping("/timestamp")
		public ResponseEntity<Integer> occuranceSingle(@PathParam("start")String start,@PathParam("end") String end)
			{
				int res= timestampsearcService.logtimestamp(start,end);

				return new ResponseEntity<>(res, HttpStatus.OK);
			}


		@GetMapping("/singletimestamp")
		@ApiOperation(value = "Search the occurance of Data using and Queries value along with Time as a String ",consumes = "String",produces = "Integer")
		public ResponseEntity<Integer> occuranceSingle(@PathParam("value")String value,@PathParam("start")String start,@PathParam("end")String end)
			{
				int res= timestampsearcService.logtimestamponevalue(start,end,value);

				return new ResponseEntity<>(res, HttpStatus.OK);
			}

		@GetMapping("/andtimestamp/")
		@ApiOperation(value = "Search the occurance of Data using and Queries value along with Time as a String ",consumes = "String",produces = "Integer")
		public ResponseEntity<Integer> occuranceAnd(@PathParam("value")String value,@PathParam("value")String value2,@PathParam("start")String start,@PathParam("end")String end)
			{
				int res=	timestampsearcService.logtimestamponevalueAnd(start,end,value,value2);

				return new ResponseEntity<>(res, HttpStatus.OK);
			}

		@GetMapping("/ortimestamp")
		@ApiOperation(value = "Search the occurance of Data using Or Queries value along with Time as a String ",consumes = "String",produces = "Integer")
		public ResponseEntity<Integer> occuranceOr(@PathParam("value")String value,@PathParam("value2")String value2,@PathParam("start")String start,@PathParam("end")String end)
			{
				int res=	timestampsearcService.logtimestamponevalueOr(start,end,value,value2);

				return new ResponseEntity<>(res, HttpStatus.OK);
			}



	}
