package it.exolab.dao;


import org.apache.ibatis.session.SqlSession;

import it.exolab.mapper.DipendenteMeseMapper;
import it.exolab.model.DipendenteMese;
import it.exolab.model.Presenza;
import it.exolab.mybatis.MyBatisUtils;

public class DipendenteMeseDAO {
	
	public static void add(Presenza presenza) {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMeseMapper mapper = sqlSession.getMapper(DipendenteMeseMapper.class);
		mapper.add(presenza);		
		sqlSession.commit();
	}
	
	
	public static DipendenteMese find(DipendenteMese dipendenteMese){
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMeseMapper mapper = sqlSession.getMapper(DipendenteMeseMapper.class);
		DipendenteMese dipMese = mapper.find(dipendenteMese);
		return dipMese;
	}
	
	
	public static void updateStato(DipendenteMese dipendenteMese) {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMeseMapper mapper = sqlSession.getMapper(DipendenteMeseMapper.class);
		mapper.updateStato(dipendenteMese);
		sqlSession.commit();
	}

}
