package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVo;

// DAO(Data Access Object)
// : CRUD처리하는 객체

public class VisitDaoImpl implements VisitDao {

	//Spring에서 제공 되는 SqlSessionTemplate의 interface
	SqlSession sqlSession;
	
	
	//Setter Injection
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// 조회
	public List<VisitVo> selectList() {

//		List<VisitVo> list = null;
//		//2.작업수행                 "namespace.mapper_id"
//		list = sqlSession.selectList("visit.visit_list");
//		return list;
		
		// sqlSession <- sqlSessionTemplate Spring방식으로 재정의
		// sqlSession.selectList(mapper_id="visit.visit_list")
		// 1.SqlSession sqlSession = factory.openSession();
		// 2.list = sqlSession.selectList(mapper_id);
		// 3.sqlSession.close();
		// 4.return list;
		
		return sqlSession.selectList("visit.visit_list");
		
		
	}
	
	public List<VisitVo> selectList(Map<String, Object> map) {

//		List<VisitVo> list = null;
//		//2.작업수행                 "namespace.mapper_id"  		  parameter	
//		list = sqlSession.selectList("visit.visit_list_condition",map);
//		return list;
		return sqlSession.selectList("visit.visit_list_condition",map);
	}
	
	

	//추가
	public int insert(VisitVo vo) {

//		int res = 0;
//		//2.작업수행                 mapper_id      , parameter
//		res = sqlSession.insert("visit.visit_insert", vo);	
//		return res;
		return sqlSession.insert("visit.visit_insert", vo);	
	}

	// 삭제
	public int delete(int idx) {

//		int res = 0;	
//		//2.작업수행                 mapper_id      , parameter
//		res = sqlSession.delete("visit.visit_delete", idx);		
//		return res;
		return sqlSession.delete("visit.visit_delete", idx);		
	}

	// idx 에 해당하는 1건 데이터 조회
	public VisitVo selectOne(int idx) {

//		VisitVo vo = null;
//		//2.작업수행
//		vo = sqlSession.selectOne("visit.visit_one", idx);
//		return vo;
		
		return sqlSession.selectOne("visit.visit_one", idx);
	}

	
	// 수정
	public int update(VisitVo vo) {

//		int res = 0;
//
//		//2.작업수행
//		res = sqlSession.update("visit.visit_update",vo);
//	
//		return res;
		
		return sqlSession.update("visit.visit_update",vo);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
