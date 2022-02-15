package it.exolab.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import it.exolab.exception.EmptyTextException;
import it.exolab.exception.NotFoundException;
import it.exolab.mapper.DipendenteMapper;
import it.exolab.mapper.MeseMapper;
import it.exolab.model.Dipendente;
import it.exolab.model.Mese;
import it.exolab.mybatis.MyBatisUtils;

public class DipendenteDAO {
	
	public static void add(Dipendente dipendente) throws EmptyTextException {		
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);		
		if(dipendente.getCognome().equals("") || dipendente.getNome().equals("") ||
				dipendente.getEmail().equals("") || dipendente.getPassword().equals("")) {
			throw new EmptyTextException();
		}		
		mapper.add(dipendente);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public static List<Dipendente> findAll() {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		List<Dipendente> dipendenti = mapper.findAll();
		
		return dipendenti;
	}
	
	public static Dipendente tuttoDelDipendente(String id_dipendente) throws NotFoundException {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		Dipendente dipendente = mapper.tuttoDelDipendente(id_dipendente);
		if(dipendente == null) {
			throw new NotFoundException();
		}
		
		return dipendente;
	}
	
	public static Dipendente findByEmailAndPassword(Dipendente dipendente) throws NotFoundException {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		Dipendente dip = mapper.findByEmailAndPassword(dipendente);
		if(dip == null) {
			throw new NotFoundException();
		}
		
		return dip;
	}
	
	public static Dipendente dipendenteConContrattoAttuale(String id_dipendente) throws NotFoundException {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		Dipendente dip = mapper.dipendenteConContrattoAttuale(id_dipendente);
		if(dip == null) {
			throw new NotFoundException("Dipendente senza contratto o ID non presente.");
		}
		
		return dip;
	}
	
	public static Dipendente dipendenteConContrattoAttualeSenzaException(String id_dipendente) {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		Dipendente dip = mapper.dipendenteConContrattoAttuale(id_dipendente);

		return dip;
	}
	
	public static Dipendente findById(String id_dipendente) throws NotFoundException {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		Dipendente dip = mapper.findById(id_dipendente);
		if(dip == null) {
			throw new NotFoundException("Dipendente non trovato.");
		}
		
		return dip;
	}
	
	public static Dipendente findByEmail(String email) throws NotFoundException {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);
		Dipendente dip = mapper.findByEmail(email);
		if(dip == null) {
			throw new NotFoundException("Email inesistente");
		}
		return dip;
	}
	
	public static Dipendente findPresenzeRelativeAlDipendenteConStatoMeseAperto(int id_dipendente) {
		SqlSession sqlSession = MyBatisUtils.getSqlSessionFactory().openSession();
		DipendenteMapper mapper = sqlSession.getMapper(DipendenteMapper.class);		
		MeseMapper mapperMese = sqlSession.getMapper(MeseMapper.class);
		Mese m = new Mese();
		m = mapperMese.findActualMonth();
		Dipendente d = new Dipendente();
		d = mapper.findPresenzeRelativeAlDipendenteConStatoMeseAperto(2, m.getId_mese());

		return d;
	}

	
}
