package com.sales.chart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sales.chart.model.vo.SaleVO;
import com.sales.chart.service.SaleService;

@Controller
@RequestMapping("sale/*")
public class SaleController {
	
	private static final Logger log = LoggerFactory.getLogger(SaleController.class);
	
	@Autowired
	SaleService service;
	
	@RequestMapping("/list.do")
	public String list() {
		return "chart/list";
	}
	
	@RequestMapping(value="/ajax_list",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> ajax_list(@RequestParam(defaultValue="100000") int arg_rn, @RequestParam(defaultValue="") String arg_area_cd,
			@RequestParam(defaultValue="") String arg_gr, 
			@RequestParam(defaultValue="1") int arg_rk1, @RequestParam(defaultValue="2") int arg_rk2,
			@RequestParam(defaultValue="3") int arg_rk3, @RequestParam(defaultValue="4") int arg_rk4,
			@RequestParam(defaultValue="5") int arg_rk5, @RequestParam(defaultValue="6") int arg_rk6, 
			@RequestParam(defaultValue="7") int arg_rk7, @RequestParam(defaultValue="8") int arg_rk8, 
			@RequestParam(defaultValue="9") int arg_rk9, @RequestParam(defaultValue="10") int arg_rk10, 
			@RequestParam(defaultValue="F") String arg_dir){
		long start = System.currentTimeMillis();
		List<SaleVO> list = service.list(arg_rn, arg_area_cd, arg_gr, arg_rk1, arg_rk2, arg_rk3, arg_rk4, arg_rk5, arg_rk6, arg_rk7, arg_rk8, arg_rk9, arg_rk10, arg_dir);
		log.info("건수: "+arg_rn);
		long end = System.currentTimeMillis();
		double time = (end-start)/1000.0;
		log.info("실행 시간: "+time+" sec");
		Map<String,Object> map = new HashMap<>();
		map.put("list", list);
		map.put("time", String.format("%.3f", time));
		return map;
	}

}
