package com.sales.chart.model.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sales.chart.model.vo.SaleVO;

@Repository
public class SaleRepositoryImpl implements SaleRepository {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<SaleVO> list(int arg_rn, String arg_area_cd, String arg_gr, int arg_rk1, int arg_rk2, int arg_rk3,
			int arg_rk4, int arg_rk5, int arg_rk6, int arg_rk7, int arg_rk8, int arg_rk9, int arg_rk10,
			String arg_dir) {
		
		Map<String,Object> map = new HashMap<>();
		map.put("arg_rn", arg_rn);
		map.put("arg_area_cd", arg_area_cd);
		map.put("arg_gr", arg_gr);
		map.put("arg_rk1", arg_rk1);
		map.put("arg_rk2", arg_rk2);
		map.put("arg_rk3", arg_rk3);
		map.put("arg_rk4", arg_rk4);
		map.put("arg_rk5", arg_rk5);
		map.put("arg_rk6", arg_rk6);
		map.put("arg_rk7", arg_rk7);
		map.put("arg_rk8", arg_rk8);
		map.put("arg_rk9", arg_rk9);
		map.put("arg_rk10", arg_rk10);
		map.put("arg_dir", arg_dir);
		
		return sqlSession.selectList("sale.list", map);
	}

}
