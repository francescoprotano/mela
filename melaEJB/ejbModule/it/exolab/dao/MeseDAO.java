package it.exolab.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.exception.NotFoundException;
import it.exolab.mapper.MeseMapper;
import it.exolab.model.Mese;
import it.exolab.mybatis.MyBatisUtils;

public class MeseDAO {
	
	public static List<Mese> findAll() throws NotFoundException{
		SqlSession sqlSession =MyBatisUtils.getSqlSessionFactory().openSession();
		MeseMapper mapper = sqlSession.getMapper(MeseMapper.class);
		List<Mese> mesi = mapper.findAll();
		if(mesi == null) {
			throw new NotFoundException("Mesi non trovati");
		}
		return mesi;
	}
	
	
	public static void updateChiuso(Mese mese) {
		SqlSession sqlSession =MyBatisUtils.getSqlSessionFactory().openSession();
		MeseMapper mapper = sqlSession.getMapper(MeseMapper.class);
		mapper.updateChiuso(mese);
		sqlSession.commit();
	}

}
