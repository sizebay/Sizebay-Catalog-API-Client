package sizebay.catalog.client.model.filters;

import java.lang.reflect.Field;
import java.util.StringJoiner;

public class Filter {

	public String createQuery() {
		StringJoiner query = new StringJoiner("&");

		Field[] fields = this.getClass().getDeclaredFields();

		for(Field field : fields) {
			field.setAccessible(true);
			try {
				if(field.get(this) != null) {
					String parameter = field.getName() + "=" + field.get(this);
					query.add(parameter);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		return query.toString();
	}

}
