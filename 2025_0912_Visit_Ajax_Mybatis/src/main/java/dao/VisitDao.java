package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import db.vo.VisitVo;
import service.MyBatisConnector;

// DAO(Data Access Object)
// : CRUD처리하는 객체

public class VisitDao {

	
	SqlSessionFactory factory;
	
	//single-ton
	static VisitDao single = null;

	public static VisitDao getInstance() {

		if (single == null)
			single = new VisitDao();

		return single;
	}

	private VisitDao() {

		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
		
	}
	
	
	// 조회
	public List<VisitVo> selectList() {

		List<VisitVo> list = null;

		//1.작업객체 얻어온다
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행                 "namespace.mapper_id"
		list = sqlSession.selectList("visit.visit_list");
		
		//3.닫기
		sqlSession.close();
		

		return list;
	}
	
	public List<VisitVo> selectList(Map<String, Object> map) {

		List<VisitVo> list = null;

		//1.작업객체 얻어온다
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행                 "namespace.mapper_id"  		  parameter	
		list = sqlSession.selectList("visit.visit_list_condition",map);
		
		//3.닫기
		sqlSession.close();
		

		return list;
	}
	
	

	//추가
	public int insert(VisitVo vo) {

		int res = 0;

		//1.작업객체 얻어오기
//		SqlSession sqlSession = factory.openSession();
		//                                          true : auto commit
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행                 mapper_id      , parameter
		res = sqlSession.insert("visit.visit_insert", vo);
				
		//2-1.
//		sqlSession.commit();  //DB적용
//		sqlSession.rollback();//취소
		
		//3.닫기
		sqlSession.close();
				

		return res;
	}

	// 삭제
	public int delete(int idx) {

		int res = 0;
		
		//1.작업객체 얻어오기
		//                                          true : auto commit
		SqlSession sqlSession = factory.openSession(true);
		
		//2.작업수행                 mapper_id      , parameter
		res = sqlSession.delete("visit.visit_delete", idx);
		
		//3.닫기
		sqlSession.close();

		
		return res;
	}

	// idx 에 해당하는 1건 데이터 조회
	public VisitVo selectOne(int idx) {

		VisitVo vo = null;
		
		//1.작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행
		vo = sqlSession.selectOne("visit.visit_one", idx);
		
		//3.닫기
		sqlSession.close();

		
		return vo;
	}

	
	// 수정
	public int update(VisitVo vo) {

		int res = 0;

		//1.작업객체 얻어오기
		SqlSession sqlSession = factory.openSession();
		
		//2.작업수행
		res = sqlSession.update("visit.visit_update",vo);
		
		//3.닫기
		sqlSession.close();

		return res;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
