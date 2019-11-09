package com.sales.chart.model.repository;

import java.util.List;

import com.sales.chart.model.vo.SaleVO;

public interface SaleRepository {
	
	public List<SaleVO> list(int arg_rn, String arg_area_cd, 
			String arg_gr, int arg_rk1, int arg_rk2, 
			int arg_rk3, int arg_rk4, int arg_rk5, int arg_rk6, 
			int arg_rk7, int arg_rk8, int arg_rk9, 
			int arg_rk10, String arg_dir);

}
