package cf.member.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.*;
import cf.member.model.MemDTO;
import cf.member.model.LoginSQL;

public class MemDAO {
   
        
/*    @싱글턴 패턴
018.    생성자의 접근지정자는 private으로 지정
019.    static한 getInstance()를  메소드를 사용
020.    객체의 주소를 보관하는 static 참조변수 사용
021.    //참조변수 instance에 객체 주소할당
022.    //객체를 한번생성해서 계속가지고있슴 (변경에관한게 아무것도없슴)
023.    객체를 하나만 생성해서 공유하고자 싱글턴 패턴 구현
024.    @멤버변수가 있는 경우에는 절대로 싱글턴 패턴을 구현하면 안된다.
025.    //멤버변수를 공유시켜버리면 여러사용자가 멤버변수를 같이 변경하게됨    */
   private static MemDAO instance =new MemDAO();
   
    public static MemDAO getInstance(){
       return instance;
   }

   private MemDAO(){
   }
   
   //커네션풀로 부터 커넥션을 할당 받는 메소드
   private Connection getConnection() throws Exception{
     Context initCtx= new InitialContext();
       Context envCtx=(Context)initCtx.lookup("java:comp/env");
      DataSource ds=(DataSource)envCtx.lookup("jdbc/orcl");
         
      return ds.getConnection();
  }

  //회원가입
  public void insertMember(MemDTO member)throws Exception{
      Connection conn= null;
    PreparedStatement pstmt = null;
      String sql="";
     int cnt = 0;
     
     try{
            //커넥션 풀로 부터 커넥션 할당
      conn= getConnection();
         sql ="insert into MEMBER values(?,?,?,?,?,?,?,?)";
        pstmt = conn.prepareStatement(sql);
          pstmt.setString(++cnt, member.getM_id());
        pstmt.setString(++cnt, member.getM_name());
         pstmt.setString(++cnt, member.getM_pwd());
         pstmt.setString(++cnt, member.getM_phone());
         pstmt.setDate(++cnt, member.getM_ldate());
         pstmt.setDate(++cnt, member.getM_mdate());
  
     //   pstmt.setTimestamp(++cnt, member.getReg_date());
            pstmt.executeUpdate();
        }catch(Exception e){
          e.printStackTrace();
      }finally{
           execClose(null,pstmt,conn);
       }
  }
  
  //회원 아이디 , 비밀번호 체크
   public int userCheck(String m_id, String m_pwd)throws Exception{
     
     Connection conn= null;
      PreparedStatement pstmt = null;
     ResultSet rs =null;
      String sql="";
      String dbpasswd="";
     int x = -1;
       
     try{
        conn =getConnection();
        sql ="select passwd from MEMBER where m_id = ?";
         pstmt =conn.prepareStatement(sql);
         pstmt.setString(1, m_id);
          rs=pstmt.executeQuery();
          
            if(rs.next()){
             dbpasswd =rs.getString("m_pwd");
             if(dbpasswd.equals(m_pwd))
                x=1; //인증성공
            else
                x=0; //비밀번호 틀림
      }else
              x=-1; //해당 아이디 없음
       }catch(Exception e){
         e.printStackTrace();
       }finally{
           execClose(rs,pstmt,conn);
      }
       return x;
  }
  
  //회원 상세정보
   public MemDTO getMember(String m_id)throws Exception{
     Connection conn =null;
       PreparedStatement pstmt = null;
        ResultSet rs = null;
      MemDTO member=null;
      String sql="";
       try{
         conn=getConnection();
         sql="select * from MEMBER where m_id= ?";
          pstmt = conn.prepareStatement(sql);
          pstmt.setString(1, m_id);
           rs= pstmt.executeQuery();

          if(rs.next()){
              member= new MemDTO();
              member.setM_Id(rs.getString("m_id"));
              member.setM_name(rs.getString("m_name"));
               member.setM_pwd(rs.getString("m_pwd"));
              member.setM_phone(rs.getString("m_phone"));
               member.setDate(rs.getString("m_ldate"));
               member.setDate(rs.getString("m_mdate"));

    //          member.setReg_date(rs.getTimestamp("reg_date"));
           }
      }catch(Exception ex){
          ex.printStackTrace();
      }finally{
          execClose(rs,pstmt,conn);
    }
       return member;
   }

  //회원정보 수정
  public void updateMember(MemDTO member)throws Exception{
    Connection conn=null;
      PreparedStatement pstmt =null;
     String sql = null;
     int cnt =0;
      try{
            conn =getConnection();
          sql = "update MEMBER set m_name=?, m_pwd=?, m_phone where m_id=?";
           pstmt =conn.prepareStatement(sql);
           pstmt.setString(++cnt, member.getM_name());
           pstmt.setString(++cnt, member.getM_pwd());
           pstmt.setString(++cnt, member.getM_phone());

        pstmt.executeUpdate();

     }catch(Exception ex){
          ex.printStackTrace();
       }finally{
          execClose(null,pstmt,conn);
      }
   }  

  //회원탈퇴 , 회원정보 삭제
  public void deleteMember(String m_id)throws Exception{
     Connection conn=null;
     PreparedStatement pstmt =null;
      String sql = null;
     try{
        conn =getConnection();
          sql = "delete from MEMBER where m_id=?";
        pstmt =conn.prepareStatement(sql);
          pstmt.setString(1, m_id);
         pstmt.executeUpdate();
    }catch(Exception e){
          e.printStackTrace();
      }finally{
         execClose(null,pstmt,conn);
       }
   }

  //ID 중복 체크
  public int confirmId(String m_id)throws Exception{
     Connection conn =null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       String sql="";
      int x=-1;
      try{
        conn=getConnection();
          sql="select * from MEMBER where m_id= ?";
         pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, m_id);
         rs= pstmt.executeQuery();   
          
          if(rs.next())
              x=1; //해당아이디 있음
          else
             x=-1;//해당아이디 없음
     }catch(Exception ex){
          ex.printStackTrace();
      }finally{
           execClose(rs,pstmt,conn);
      }       
       return x;
   }

   //자원 정리를 위한 메소드
   //계란노른자
   //Connection 를통해서 PreparedStatement 를생성하고
   //PreparedStatement 를 통해서 ResultSet 를 생성하기때문에
 //종료할때는 ResultSet=>PreparedStatement=>Connection 와같이 생성순서의 역순으로 close 해줘야한다
  public void execClose(ResultSet rs, PreparedStatement pstmt, Connection conn)throws Exception{
    //자원정리
       if(rs !=null) try{rs.close();}catch(SQLException sqle){}
      if(pstmt !=null) try{pstmt.close();}catch(SQLException sqle){}
      //커넥션 풀로 반납
     if(conn !=null) try{conn.close();}catch(SQLException sqle){}
  }
}
