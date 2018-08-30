package sizebay.catalog.client;

import static sizebay.catalog.client.CatalogAPI.DEFAULT_BASE_URL;
import java.io.*;
import java.net.*;
import java.util.List;
import java.util.function.BiConsumer;
import org.junit.*;
import sizebay.catalog.client.model.*;
//import sizebay.emmett.tasks.Threads;

/*@Ignore
public class SynchJob {

	final Threads threads = Threads.fixedPool(10);
	final CatalogAPI dynamoAdmin = new CatalogAPI( "http://localhost:9000/", "admin", "1q2w3e" );
	final CatalogAPI mysqlAdmin = new CatalogAPI( DEFAULT_BASE_URL, "admin", "1q2w3e" );
	
	final SyncLog log = new SyncLog();
	
	@After
	public void closeLog(){
		log.close();
	}

	@Test
	@Ignore
	public void synchronizeTenants() throws URISyntaxException {
		final List<Tenant> tenants = mysqlAdmin.retrieveAllTenants();
		for ( Tenant tenant : tenants ) {
			if ( tenant.getFeedRSS() != null && !tenant.getFeedRSS().isEmpty() ) {
				final String domain = new URI(tenant.getFeedRSS()).getHost();
				tenant.setDomain( domain );
				dynamoAdmin.insertTenant(tenant);
				log.info( "Synchronized: " + tenant );
			}
		}
	}

	@Test
	public void synchronize(){
		log.info("## CATEGORIES");
		synchronizeCategories();
		log.info("## BRANDS");
		synchronizeBrands();
		log.info("## MODELINGS");
		synchronizeModelings();
		log.info("## PRODUCTS");
		synchronizeProducts();
	}

	@Test
	@Ignore
	public void synchronizeCategories(){
		forEachTenant( (mysql, dynamo) -> {
			//dynamo.deleteCategories();
			try (Threads.BackgroundJob bg = threads.background()) {
				for (final Category category : mysql.getCategories())
					bg.run(() -> {
						dynamo.insertCategory(category);
						log.info("Synchronized: " + category.getName());
					});
			}
		});
	}

	@Test
	@Ignore
	public void synchronizeBrands(){
		forEachTenant( (mysql, dynamo) -> {
			//dynamo.deleteBrands();
			try (Threads.BackgroundJob bg = threads.background()) {
				for ( int page=0; page<1000; page++ ) {
					final List<Brand> brands = mysql.getBrands(page);
					if ( brands.isEmpty() ) break;
					for (final Brand brand : brands)
						bg.run(() -> {
							dynamo.insertBrand(brand);
							log.info("Synchronized: " + brand.getName());
						});
				}
			}
		});
	}

	@Test
	@Ignore
	public void synchronizeModelings(){
		forEachTenant( (mysql, dynamo) -> {
			//dynamo.deleteModelings();
			try (Threads.BackgroundJob bg = threads.background()) {
				for ( int page=0; page<1000; page++ ) {
					final List<Modeling> brands = mysql.getModelings(page);
					if ( brands.isEmpty() ) break;
					for (final Modeling brand : brands)
						bg.run(() -> {
							dynamo.insertModeling(brand);
							log.info("Synchronized: " + brand.getName());
						});
				}
			}
		});
	}

	@Test
	@Ignore
	public void synchronizeProducts(){
		forEachTenant( (mysql, dynamo) -> {
			//dynamo.deleteProducts();
			try (Threads.BackgroundJob bg = threads.background()) {
				for ( int page=0; page<1000; page++ ) {
					final List<Product> brands = mysql.getProducts(page);
					if ( brands.isEmpty() ) break;
					for (final Product brand : brands)
						bg.run(() -> tryInsertProduct(dynamo,mysql,brand.getId()));
				}
			}
		});
	}

	void tryInsertProduct( CatalogAPI dynamo, CatalogAPI mysql, Long productId ){
		final Product product = mysql.getProduct(productId);
		if ( product.getImages() == null || product.getImages().isEmpty() )
			log.info( "No image defined: " + product.getName() );
		else {
			try {
				dynamo.insertProduct(product);
				log.info("Synchronized: " + productId + ": " + product.getName());
			} catch ( Throwable e ) {
				log.error( e );
			}
		}
	}

	void forEachTenant(BiConsumer<CatalogAPI,CatalogAPI> consumer){
		final List<Tenant> tenants = dynamoAdmin.retrieveAllTenants();
		final List<Tenant> tenants = Collections.singletonList(new Tenant().setName("Aramis")
				.setAppToken("a572da5e8b5a3d8de044e5c55dc7a022364dffff")
				.setSecretToken("8cd5a5a1fc2465694196535fb1bbada0ecdec95d"));

		for( Tenant tenant : tenants ) {
			log.info( "Synchronizing " + tenant.getName() );
			final CatalogAPI mysqlAPI = new CatalogAPI( DEFAULT_BASE_URL, tenant.getAppToken(), tenant.getSecretToken() );
			final CatalogAPI dynamoAPI = new CatalogAPI( "http://localhost:9000/", tenant.getAppToken(), tenant.getSecretToken() );
			consumer.accept( mysqlAPI, dynamoAPI );
		}
	}

}

class SyncLog {

	final File file = new File("target/sync." + System.currentTimeMillis() + ".log" );
	final PrintWriter writer;

	SyncLog(){
		try {
			writer = new PrintWriter(new FileWriter( file ));
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	void close(){
		writer.close();
	}

	void info( String msg ) {
		System.out.println( msg );
		writer.println( msg  );
	}

	void error( Throwable c ) {
		c.printStackTrace( writer );
	}
}*/