package com.sales.chart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.chart.model.repository.SaleRepository;
import com.sales.chart.model.vo.SaleVO;

@Service
public class SaleServiceImpl implements SaleService {
	
	@Autowired
	SaleRepository saleRepository;

	@Override
	public List<SaleVO> list(int arg_rn, String arg_area_cd, String arg_gr, int arg_rk1, int arg_rk2, int arg_rk3,
			int arg_rk4, int arg_rk5, int arg_rk6, int arg_rk7, int arg_rk8, int arg_rk9, int arg_rk10,
			String arg_dir) {
		
		return saleRepository.list(arg_rn, arg_area_cd, arg_gr, arg_rk1, arg_rk2, arg_rk3, arg_rk4, arg_rk5, arg_rk6, arg_rk7, arg_rk8, arg_rk9, arg_rk10, arg_dir);
	}

}
