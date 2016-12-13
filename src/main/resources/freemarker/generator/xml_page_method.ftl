
  <!-- 自己定义方法 -->
  <select id="getData" resultMap="BaseResultMap" parameterType="${params.packageMap["SqlBean"]}">
      SELECT t.* 
        FROM ${table.tableName} t
       WHERE (1=1) 
             ${r"${condition}"}
       order by ${r"${orderby}"}
  </select>

</mapper>