package dao;

import java.util.List;
import java.util.Map;

import vo.VisitVo;

// DAO(Data Access Object)
// : CRUD처리하는 객체

public interface VisitDao {

	
	// 조회
	public List<VisitVo> selectList();
	public List<VisitVo> selectList(Map<String, Object> map);
	// idx 에 해당하는 1건 데이터 조회
	public VisitVo selectOne(int idx);

	//추가
	public int insert(VisitVo vo);

	// 삭제
	public int delete(int idx);
	// 수정
	public int update(VisitVo vo);

	
	
	
	
	
	
	
	
	
	
	
	
}
