package it.exolab.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.mapper.ContrattoMapper;
import it.exolab.model.Contratto;
import it.exolab.mybatis.MyBatisUtils;

public class ContrattoDAO {
	
	
	public static List<Contratto> findAll() {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		List<Contratto> contratti = mapper.findAll();
		
		return contratti;
	}
	
	public static void add(Contratto contratto) {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		mapper.add(contratto);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public static void update(Contratto contratto) {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		ContrattoMapper mapper = sqlSession.getMapper(ContrattoMapper.class);
		mapper.updateContrattoCorrente(contratto);
		sqlSession.commit();
		sqlSession.close();
	}

}
