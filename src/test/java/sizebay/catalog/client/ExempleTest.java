package sizebay.catalog.client;

import org.junit.Ignore;
import org.junit.Test;
import sizebay.catalog.client.model.*;
import sizebay.catalog.client.model.Modeling.Gender;
import sizebay.catalog.client.model.ModelingSizeMeasures.SizeName;

import java.util.Arrays;

import static org.junit.Assert.assertNotEquals;
import static sizebay.catalog.client.model.Product.Wearability.*;

public class ExempleTest {

	final CatalogAPI api = new CatalogAPI( "testTenant", "secretTestTenant" );

	@Test
	@Ignore
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
		product.setAvailableSizes( Arrays.asList( SizeName.XXXL ) );
		product.setImages( Arrays.asList( "http://teste.com/p.png" ) );
		product.setPermalink("http://teste.com/p");
		final long productId = api.insertProduct( product );

		System.out.println( "Just created product " + productId );
	}

	private long createABrand() {
		final Brand brand = new Brand();
		brand.setName( "Minha Marca" );
		return api.insertBrand( brand );
	}

	private long createModeling( final long brandId ) {
		final ModelingSizeMeasures measures = new ModelingSizeMeasures();
		measures.setSizeName( SizeName.XXXL );
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
}
