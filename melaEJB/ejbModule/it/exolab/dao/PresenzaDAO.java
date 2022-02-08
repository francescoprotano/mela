package it.exolab.dao;

import org.apache.ibatis.session.SqlSession;

import it.exolab.mapper.PresenzaMapper;
import it.exolab.model.Presenza;
import it.exolab.mybatis.MyBatisUtils;

public class PresenzaDAO {

	public static void add(Presenza presenza) {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		mapper.add(presenza);
		sqlSession.commit();
	}

}
