package it.exolab.dao;

import org.apache.ibatis.session.SqlSession;

import it.exolab.exception.FailedInsertException;
import it.exolab.mapper.PresenzaMapper;
import it.exolab.model.Presenza;
import it.exolab.mybatis.MyBatisUtils;

public class PresenzaDAO {

	public static void add(Presenza presenza) throws FailedInsertException {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		PresenzaMapper mapper = sqlSession.getMapper(PresenzaMapper.class);
		mapper.add(presenza);
		if(presenza.getId_presenza() == 0) {
			throw new FailedInsertException("Insert presenza fallito");
		}
		sqlSession.commit();
	}

}
