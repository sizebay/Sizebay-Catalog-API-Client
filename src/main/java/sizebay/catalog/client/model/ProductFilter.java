package sizebay.catalog.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.StringJoiner;

@Getter
@Setter
@AllArgsConstructor
public class ProductFilter {

	private String page;
	private String name;
	private String permalink;
	private String ageGroup;
	private String gender;
	private String productId;
	private String feedProductId;
	private String brandId;
	private String brandName;
	private String categoryId;
	private String categoryName;
	private String modelingId;
	private String modelingName;
	private String strongBrandId;
	private String strongBrandName;
	private String strongTypeId;
	private String strongTypeName;
	private String strongCategoryId;
	private String strongCategoryName;
	private String strongSubcategoryId;
	private String strongSubcategoryName;
	private String strongModelId;
	private String strongModelName;
	private String onlyShoe;
	private String productsThatShouldBeFixed;
	private String productsAvailable;
	private String productsUnavailable;

	public String createQuery() {
		StringJoiner query = new StringJoiner("&");

		Field[] fields = this.getClass().getDeclaredFields();

		for(Field field : fields) {
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
