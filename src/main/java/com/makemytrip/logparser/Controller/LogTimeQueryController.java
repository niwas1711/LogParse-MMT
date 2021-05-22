package com.makemytrip.logparser.Controller;

import com.makemytrip.logparser.Service.TimeStampLogSearch;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
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
		public ResponseEntity<Integer> occuranceSingle(@PathParam("value")String value,@PathParam("start")String start,@PathParam("end")String end)
			{
				int res= timestampsearcService.logtimestamponevalue(start,end,value);

				return new ResponseEntity<>(res, HttpStatus.OK);
			}

		@GetMapping("/andtimestamp/")
		public ResponseEntity<Integer> occuranceAnd(@PathParam("value")String value,@PathParam("value")String value2,@PathParam("start")String start,@PathParam("end")String end)
			{
				int res=	timestampsearcService.logtimestamponevalueAnd(start,end,value,value2);

				return new ResponseEntity<>(res, HttpStatus.OK);
			}

		@GetMapping("/ortimestamp")
		public ResponseEntity<Integer> occuranceOr(@PathParam("value")String value,@PathParam("value2")String value2,@PathParam("start")String start,@PathParam("end")String end)
			{
				int res=	timestampsearcService.logtimestamponevalueOr(start,end,value,value2);

				return new ResponseEntity<>(res, HttpStatus.OK);
			}



	}
