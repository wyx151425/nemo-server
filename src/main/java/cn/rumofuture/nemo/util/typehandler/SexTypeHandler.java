package cn.rumofuture.nemo.util.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by WangZhenqi on 2017/8/14.
 */

@MappedTypes(String.class)
@MappedJdbcTypes(JdbcType.BOOLEAN)
public class SexTypeHandler implements TypeHandler<String> {

    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        if (parameter.equals("男"))
            ps.setBoolean(i, true);
        else if (parameter.equals("女"))
            ps.setBoolean(i, false);
        else
            ps.setBoolean(i, true);
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        Boolean sex = rs.getBoolean(columnName);
        if (sex)
            return "男";
        else
            return "女";
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        Boolean sex = rs.getBoolean(columnIndex);
        if (sex)
            return "男";
        else
            return "女";
    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        Boolean sex = cs.getBoolean(columnIndex);
        if (sex)
            return "男";
        else
            return "女";
    }
}
