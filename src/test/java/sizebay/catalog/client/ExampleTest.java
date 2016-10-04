package sizebay.catalog.client;

import static org.junit.Assert.*;
import static sizebay.catalog.client.model.Product.Wearability.REGULAR;
import java.util.*;
import org.junit.*;
import sizebay.catalog.client.http.ApiException;
import sizebay.catalog.client.model.*;
import sizebay.catalog.client.model.Modeling.Gender;

public class ExampleTest {

	final CatalogAPI api = new CatalogAPI( "testTenant", "secretTestTenant" );

	@Before
	public void cleanUp(){
		api.deleteCategories();
		api.deleteBrands();
		api.deleteModelings();
		api.deleteProducts();
	}

	@Test
	public void ensureThatCanCreateCategories(){
		final Category category = new Category();
		category.setName("Category Test");
		final long id = api.insertCategory(category);
		final Category category1 = api.getCategory(id);
		assertEquals( category.getName(), category1.getName() );
		assertEquals( id, category1.getId().longValue() );
		api.deleteCategories();

		try {
			assertNull( api.getCategory(id) );
			fail( "Category wasn't removed" );
		} catch (ApiException cause) {}
	}

	@Test
	public void ensureThatCreatesAProduct()
	{
		// criando uma marca
		final long brandId = createABrand();
		assertNotEquals( -1, brandId );
		System.out.println( "Just created a brand: " + brandId );

		// criando uma modelagem (tabela de medidas)
		final long modelingId = createModeling( brandId );
		System.out.println( "Just created a modeling: " + modelingId );

		// criando um produto
		final Product product = new Product();
		product.setModelingId( modelingId );
		product.setName( "Produto" );
		product.setWearability( REGULAR );
		product.setCategoryId( 6l );
		product.setAvailableSizes( Arrays.asList( "XXXL" ) );
		product.setImages( Arrays.asList( "http://teste.com/p.png" ) );
		product.setPermalink("http://teste.com/p");
		final long productId = api.insertProduct( product );

		System.out.println( "Just created product " + productId );

		final ProductBasicInformation basicInfo = api.getProductBasicInfo(productId);
		assertEquals( basicInfo.getId(), productId, 0 );
		System.out.println( basicInfo );

		final Long id = api.getProductIdFromPermalink(product.getPermalink());
		assertEquals( basicInfo.getId(), id, 0 );
	}

	private long createABrand() {
		final Brand brand = new Brand();
		brand.setName( "Minha Marca" );
		return api.insertBrand( brand );
	}

	private long createModeling( final long brandId ) {
		final ModelingSizeMeasures measures = new ModelingSizeMeasures();
		measures.setSizeName( "XXXL" );
		measures.setHip( range( 50, 60 ) );
		measures.setWaist( range( 70, 80 ) );
		measures.setChest( range( 55, 75 ) );

		final Modeling modeling = new Modeling();
		modeling.setName( "Tabela de Medida A" );
		modeling.setBrandId( brandId );
		modeling.setGender( Gender.M );
		modeling.setSizeMeasures( Arrays.asList( measures ) );

		return api.insertModeling( modeling );
	}

	private ModelingMeasureRange range( long initialValue, long finalValue ) {
		final ModelingMeasureRange range = new ModelingMeasureRange();
		range.setInitialValue( initialValue );
		range.setFinalValue( finalValue );
		return range;
	}

	@Test
	public void ensureThatCanSearchForCategories(){
		final Category category = new Category();
		category.setName("Category Test");
		category.setId( api.insertCategory(category) );

		final List<Category> categories = api.searchForCategories(category.getName());
		assertEquals( category, categories.get(0) );
	}

	@Test
	public void ensureThatCanSearchForBrands(){
		final long brandId = createABrand();
		final Brand brand = api.getBrand(brandId);
		final List<Brand> brands = api.searchForBrands(brand.getName());
		assertEquals( brand, brands.get(0) );
	}

	@Test
	public void ensureThatCanSearchForModelings(){
		final long brandId = createABrand();
		final long modelingId = createModeling(brandId);
		final Modeling modeling = api.getModeling(modelingId);
		final List<Modeling> modelings = api.searchForModelings(modeling.getName());
		assertEquals( modeling, modelings.get(0) );
	}
}
