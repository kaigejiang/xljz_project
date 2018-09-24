package cn.edu.nyist.xljzspringbootthymeleafmybatisforum.admin.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class CardSqlProvider {

	public String createCardFindAll(@Param(value = "name") String name) {

		return new SQL() {
			{
				SELECT("*");
				FROM("t_card");
				if (name!=null && !name.equals("")) {
					WHERE("name like concat('%',#{name},'%')");
				}

			}

		}.toString();
	}

}
