package com.makemytrip.logparser.Controller;


import com.makemytrip.logparser.Service.Occurance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@Api(value = "LogQueryController APIs", description = "API for quering the Logs, inputs query", tags = {"LogQueryController API"})
public class LogQueryController
	{

	@Autowired
	Occurance occuranceservice;


			@GetMapping("/single")
			@ApiOperation(value = "Search the occurance of Data using single value ",consumes = "String",produces = "Integer")
			public ResponseEntity<Integer> occuranceSingle(@PathParam("value")String value)
				{
					int res= occuranceservice.logoccurance(value);

      return new ResponseEntity<>(res, HttpStatus.OK);
				}

		@GetMapping("/and/")
		@ApiOperation(value = "Search the occurance of Data using and Queries value ",consumes = "String",produces = "Integer")
		public ResponseEntity<Integer> occuranceAnd(@PathParam("value")String value,@PathParam("value")String value2)
			{
				int res=	occuranceservice.logoccuranceAND(value,value2);

				   return new ResponseEntity<>(res, HttpStatus.OK);
			}

		@GetMapping("/or")
		@ApiOperation(value = "Search the occurance of Data using Or Queries value ",consumes = "String",produces = "Integer")

		public ResponseEntity<Integer> occuranceOr(@PathParam("value")String value,@PathParam("value2")String value2)
			{
				int res=	occuranceservice.logoccuranceOR(value,value2);

				return new ResponseEntity<>(res, HttpStatus.OK);
			}




	}
