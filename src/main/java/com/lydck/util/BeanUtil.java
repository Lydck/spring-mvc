package com.lydck.util;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;

import com.lydck.domain.Gender;
import com.lydck.domain.User;
import com.lydck.entity.TUser;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;

public class BeanUtil {
	private static HashMap<String, BeanCopier> copier = new HashMap<String, BeanCopier>();
	private static final EnumConvert conveter = new EnumConvert();

	public static void copyBean(Object source, Object target) {
		String key = source.getClass().getName() + target.getClass().getName();
		BeanCopier copyer = copier.get(key);
		if (copyer == null) {
			copyer = BeanCopier.create(source.getClass(), target.getClass(), true);
			copier.put(key, copyer);
		}
		copyer.copy(source, target, conveter);
	}

	public static void main(String[] args) {
		User user = new User();
		user.setGender(Gender.FEMALE);
		user.setEmail("132jldkjfo");
		user.setLastLoginTime(new Date());
		TUser tuser = new TUser();
		/*tuser.setGender(1);
		tuser.setEmail("34sdfe");
		tuser.setLastLoginTime(new Date());*/
		copyBean(user, tuser);
		System.out.println(tuser);
	}
}

class EnumConvert implements Converter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object convert(Object value, Class target, Object context) {
		if (value instanceof Gender) {//性别转换，目标对象的属性不是Gender
			try {
				Method memthod = Gender.class.getDeclaredMethod("getGender", Gender.class);
				return memthod.invoke(null, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//转换为枚举类型的属性
		if(Enum.class.isAssignableFrom(target)) {
			try {
				Method method = target.getDeclaredMethod("getEnum", Integer.class);
				return method.invoke(null, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return value;
		}
		return value;
	}

}
