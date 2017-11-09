package com.relay42.interview.ws;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.relay42.interview.ErrorCodes;
import com.relay42.interview.model.Response;
import com.relay42.interview.model.TomatoData;
import com.relay42.interview.service.ITomatoService;

@RestController
public class TomatoListController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(TomatoListController.class);
	
	@Autowired
	ITomatoService tomatoService;

    @RequestMapping(value="/data" ,method={RequestMethod.GET,RequestMethod.POST} )
    public @ResponseBody Response<List<TomatoData>>getTomatoList(@RequestParam(value="size", required=false, defaultValue="1000") String sizeStr, Model model) {
    	try {
    		Integer size = Integer.valueOf(sizeStr);
    		List<TomatoData> retList = tomatoService.list(size);
    		return new Response<List<TomatoData>>().setBody(retList).setResponseCode(ErrorCodes.SUCCESS).setDescription(String.format("%d rows returned.", retList.size()));
    	}catch (NumberFormatException e){
    		LOGGER.error("Not a valid size input!",e);
    		return new Response().setResponseCode(ErrorCodes.WRONG_INPUT_TYPE).setDescription("Wrong input type : " + sizeStr );
    	}
    }

}