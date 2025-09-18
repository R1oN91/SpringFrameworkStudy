package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.SawonVo;

public class SawonDao {

	SqlSession sqlSession;

	public SawonDao(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}
	/** slectlist를 sqlsession에서 불러오는 부분 */
	public List<SawonVo> selectList(){
		
		return sqlSession.selectList("sawon.sawon_list");
				
		
	}
	
	
	
}
