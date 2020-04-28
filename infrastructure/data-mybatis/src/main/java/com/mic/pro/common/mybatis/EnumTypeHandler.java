package com.mic.pro.common.mybatis;

import com.mic.pro.common.lang.utils.EnumUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnumTypeHandler<E extends Enum<E>> extends BaseTypeHandler<E> {

    private final Class<E> type;

    public EnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        } else {
            this.type = type;
        }
    }
    
    @Override
    public void setNonNullParameter(PreparedStatement ps, int columnIndex, E parameter, JdbcType jdbcType) throws SQLException {
        String code = EnumUtils.getCode(parameter);
        if (jdbcType == null) {
            ps.setString(columnIndex, code);
        } else {
            ps.setObject(columnIndex, code, jdbcType.TYPE_CODE);
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String code = rs.getString(columnName);
        return code == null ? null : EnumUtils.codeOf(this.type, code);
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String code = rs.getString(columnIndex);
        return code == null ? null : EnumUtils.codeOf(this.type, code);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String code = cs.getString(columnIndex);
        return code == null ? null : EnumUtils.codeOf(this.type, code);
    }
}
