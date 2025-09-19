package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVo;

public interface MemberDao {

	
	
	// 조회
	public List<MemberVo> selectList();
	
	// mem_idx -> selectOne
	public MemberVo selectOne(int mem_idx);
	
	// mem_id -> selectOne
	public MemberVo selectOne(String mem_id);

	// 추가
	public int insert(MemberVo vo);

	//삭제
	public int delete(int mem_idx);
	
	//수정
	public int update(MemberVo vo);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
