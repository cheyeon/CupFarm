package cf.member.model;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.*;
import cf.member.model.MemDTO;
import cf.member.model.LoginSQL;

public class MemDAO {
   
        
/*    @�̱��� ����
018.    �������� ���������ڴ� private���� ����
019.    static�� getInstance()��  �޼ҵ带 ���
020.    ��ü�� �ּҸ� �����ϴ� static �������� ���
021.    //�������� instance�� ��ü �ּ��Ҵ�
022.    //��ü�� �ѹ������ؼ� ��Ӱ������ֽ� (���濡���Ѱ� �ƹ��͵�����)
023.    ��ü�� �ϳ��� �����ؼ� �����ϰ��� �̱��� ���� ����
024.    @��������� �ִ� ��쿡�� ����� �̱��� ������ �����ϸ� �ȵȴ�.
025.    //��������� �������ѹ����� ��������ڰ� ��������� ���� �����ϰԵ�    */
   private static MemDAO instance =new MemDAO();
   
    public static MemDAO getInstance(){
       return instance;
   }

   private MemDAO(){
   }
   
   //Ŀ�׼�Ǯ�� ���� Ŀ�ؼ��� �Ҵ� �޴� �޼ҵ�
   private Connection getConnection() throws Exception{
     Context initCtx= new InitialContext();
       Context envCtx=(Context)initCtx.lookup("java:comp/env");
      DataSource ds=(DataSource)envCtx.lookup("jdbc/orcl");
         
      return ds.getConnection();
  }

  //ȸ������
  public void insertMember(MemDTO member)throws Exception{
      Connection conn= null;
    PreparedStatement pstmt = null;
      String sql="";
     int cnt = 0;
     
     try{
            //Ŀ�ؼ� Ǯ�� ���� Ŀ�ؼ� �Ҵ�
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
  
  //ȸ�� ���̵� , ��й�ȣ üũ
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
                x=1; //��������
            else
                x=0; //��й�ȣ Ʋ��
      }else
              x=-1; //�ش� ���̵� ����
       }catch(Exception e){
         e.printStackTrace();
       }finally{
           execClose(rs,pstmt,conn);
      }
       return x;
  }
  
  //ȸ�� ������
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

  //ȸ������ ����
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

  //ȸ��Ż�� , ȸ������ ����
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

  //ID �ߺ� üũ
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
              x=1; //�ش���̵� ����
          else
             x=-1;//�ش���̵� ����
     }catch(Exception ex){
          ex.printStackTrace();
      }finally{
           execClose(rs,pstmt,conn);
      }       
       return x;
   }

   //�ڿ� ������ ���� �޼ҵ�
   //����븥��
   //Connection �����ؼ� PreparedStatement �������ϰ�
   //PreparedStatement �� ���ؼ� ResultSet �� �����ϱ⶧����
 //�����Ҷ��� ResultSet=>PreparedStatement=>Connection �Ͱ��� ���������� �������� close ������Ѵ�
  public void execClose(ResultSet rs, PreparedStatement pstmt, Connection conn)throws Exception{
    //�ڿ�����
       if(rs !=null) try{rs.close();}catch(SQLException sqle){}
      if(pstmt !=null) try{pstmt.close();}catch(SQLException sqle){}
      //Ŀ�ؼ� Ǯ�� �ݳ�
     if(conn !=null) try{conn.close();}catch(SQLException sqle){}
  }
}
