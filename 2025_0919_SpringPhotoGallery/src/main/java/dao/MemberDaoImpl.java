package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.MemberVo;

@Repository
public class MemberDaoImpl  implements MemberDao{

	//@Autowired
	// 1.해당 컴포넌트가 자동생성되면 자동연결해준다. 
	// 2.수동생성이면 <bean>이 등록된 부분위에
	// 				<context:annotation-config/> 속성을 정의해야 한다. 
	
	@Autowired
	SqlSession sqlSession;
	
	public MemberDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("--MemberDaoImpl()--");
	}
	
	// 조회
	public List<MemberVo> selectList() {

		
		return sqlSession.selectList("member.member_list");
	}
	
	// mem_idx -> selectOne
	public MemberVo selectOne(int mem_idx) {


		return sqlSession.selectOne("member.member_one_idx", mem_idx);
	}
	
	// mem_id -> selectOne
	public MemberVo selectOne(String mem_id) {

	
		return sqlSession.selectOne("member.member_one_id", mem_id);
	}

	// 추가
	public int insert(MemberVo vo) {


		return sqlSession.insert("member.member_insert", vo);
	}

	//삭제
	public int delete(int mem_idx) {

	
		return sqlSession.delete("member.member_delete", mem_idx);
	}

	public int update(MemberVo vo) {

	

		return sqlSession.update("member.member_update", vo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
