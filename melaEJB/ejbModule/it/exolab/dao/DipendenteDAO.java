package it.exolab.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.mapper.DipendenteMapper;
import it.exolab.model.Dipendente;
import it.exolab.mybatis.MyBatisUtils;

public class DipendenteDAO {

	
	public static void add(Dipendente dipendente) {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		mapper.add(dipendente);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public static List<Dipendente> findAll(){
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		List<Dipendente> dipendenti = mapper.findAll();
		
		return dipendenti;
	}
	
}
