package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVo;

public class DeptDao {
	
	//SqlSessionTemplate의 interface만 받겠다.  
	SqlSession sqlSession;

	//Constructor Injection
	public DeptDao(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}
	/** slectlist를 sqlsession에서 불러오는 부분 파일업로드코드랑 
	 * 등등이 있습니다.*/
	
	public List<DeptVo> selectList() {
		// TODO Auto-generated method stub
		
		//List<DeptVo> list = sqlSession.selectList("dept.dept_list");
		//return list; 원래 이렇게 
		
		//							"namespace.mapper_id"
		return sqlSession.selectList("dept.dept_list");
	}
	
	

}
