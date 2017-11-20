package sizebay.catalog.client;

import java.util.*;
import lombok.NonNull;
import sizebay.catalog.client.http.*;
import sizebay.catalog.client.model.*;

/**
 * A Basic wrapper on generated Swagger client.
 * 
 * @author Miere L. Teixeira
 */
public class CatalogAPI {

	final static String
		DEFAULT_BASE_URL = "http://catalog.sizebay.com/api/v1/",

		ENDPOINT_BRAND = "/brands/",
		ENDPOINT_MODELING = "/modelings/",
		ENDPOINT_PRODUCT = "/products/",
		ENDPOINT_CATEGORIES = "/categories/",
		ENDPOINT_TENANTS = "/tenants/",

		SEARCH_BY_TEXT = "/search/all?text=";

	final RESTClient client;

	/**
	 * Constructs the Catalog API.
	 * 
	 * @param applicationToken
	 * @param securityToken
	 */
	public CatalogAPI(
			@NonNull String applicationToken,
			@NonNull String securityToken )
	{
		this( DEFAULT_BASE_URL, applicationToken, securityToken );
	}

	/**
	 * Constructs the Catalog API.
	 * 
	 * @param basePath
	 * @param applicationToken
	 * @param securityToken
	 */
	public CatalogAPI(
			@NonNull String basePath,
			@NonNull String applicationToken,
			@NonNull String securityToken )
	{
		final CatalogAuthentication authentication = new CatalogAuthentication( applicationToken, securityToken );
		final MimeType mimeType = new JSONMimeType();
		client = new RESTClient( basePath, mimeType, authentication );
	}

	public Brand getBrand( long id ) {
		return client.getSingle( ENDPOINT_BRAND + id, Brand.class );
	}

	public List<Brand> searchForBrands(String text ){
		return client.getList( ENDPOINT_BRAND + SEARCH_BY_TEXT + text, Brand.class );
	}

	public List<Brand> getBrands( int page ) {
		return client.getList( ENDPOINT_BRAND + "?page=" + page, Brand.class );
	}

	public long insertBrand( Brand brand ) {
		return client.post( ENDPOINT_BRAND, brand );
	}

	public void updateBrand( long id, Brand brand ) {
		client.put( ENDPOINT_BRAND + id, brand );
	}

	public void deleteBrand( long id ) {
		client.delete( ENDPOINT_BRAND + id );
	}

	public void deleteBrands() {
		client.delete( ENDPOINT_BRAND );
	}

	public Modeling getModeling( long id ) {
		return client.getSingle( ENDPOINT_MODELING + id, Modeling.class );
	}

	public List<Modeling> searchForModelings( long brandId, String gender ) {
		return searchForModelings( String.valueOf( brandId ), gender );
	}

	public List<Modeling> searchForModelings( String brandId, String gender ){
		return client.getList( ENDPOINT_MODELING + "/search/brand/" + brandId + "/gender/" + gender, Modeling.class );
	}

	public List<Modeling> getModelings( int page ){
		return client.getList( ENDPOINT_MODELING + "?page=" + page, Modeling.class );
	}

	public long insertModeling( Modeling brand ) {
		return client.post( ENDPOINT_MODELING, brand );
	}

	public void updateModeling( long id, Modeling brand ) {
		client.put( ENDPOINT_MODELING + id, brand );
	}

	public void deleteModeling( long id ) {
		client.delete( ENDPOINT_MODELING + id );
	}

	public void deleteModelings() {
		client.delete( ENDPOINT_MODELING );
	}

	public Product getProduct( long id ) {
		return client.getSingle( ENDPOINT_PRODUCT + id, Product.class );
	}

	public List<Product> getProducts( int page ) {
		return client.getList( ENDPOINT_PRODUCT + "?page=" + page, Product.class );
	}

	public long insertProduct( Product brand ) {
		return client.post( ENDPOINT_PRODUCT, brand );
	}

	public void updateProduct( long id, Product brand ) {
		client.put( ENDPOINT_PRODUCT + id, brand );
	}

	public void deleteProduct( long id ) {
		client.delete( ENDPOINT_PRODUCT + id );
	}

	public void deleteProducts() {
		client.delete( ENDPOINT_PRODUCT );
	}

	public ProductBasicInformation getProductBasicInfo(long id ){
		return client.getSingle( ENDPOINT_PRODUCT + id + "/basic-info", ProductBasicInformation.class );
	}

	public Long getProductIdFromPermalink( String permalink ){
		return client.getSingle( ENDPOINT_PRODUCT + "/search/product-id?permalink=" + permalink, Long.class );
	}

	public Long getAvailableProductIdFromPermalink( String permalink ){
		return client.getSingle( ENDPOINT_PRODUCT + "/search/product-id?permalink=" + permalink + "&onlyAvailable=true", Long.class );
	}

	public Category getCategory( long id ) {
		return client.getSingle( ENDPOINT_CATEGORIES + id, Category.class );
	}

	public List<Category> getCategories() {
		return client.getList( ENDPOINT_CATEGORIES, Category.class );
	}

	public long insertCategory( Category brand ) {
		return client.post( ENDPOINT_CATEGORIES, brand );
	}

	public void updateCategory( long id, Category brand ) {
		client.put( ENDPOINT_CATEGORIES + id, brand );
	}

	public void deleteCategory( long id ) {
		client.delete( ENDPOINT_CATEGORIES + id );
	}

	public void deleteCategories() {
		client.delete( ENDPOINT_CATEGORIES );
	}

	public List<Category> searchForCategories(String text ){
		return client.getList( ENDPOINT_CATEGORIES + SEARCH_BY_TEXT + text, Category.class );
	}

	public List<Tenant> retrieveAllTenants(){
		return client.getList( ENDPOINT_TENANTS, Tenant.class );
	}

	public Tenant getTenant( String appToken ){
		return client.getSingle( ENDPOINT_TENANTS + appToken, Tenant.class );
	}

	@SuppressWarnings("unchecked")
	public List<Tenant> authenticateAndRetrieveTenants(String username, String password ) {
		return client.getList( "/users/" + username + "/" + password + "/tenants", Tenant.class );
	}

	@Deprecated
	void saveUser( User user ){
		client.post( "/users/", user );
	}

	public void insertTenant(Tenant tenant) {
		client.post( ENDPOINT_TENANTS, tenant );
	}

	public void insertImportationSummary(long tenantId, ImportationSummary importationSummary) {
		client.post( "/importations/"+tenantId, importationSummary );
	}

	public String retrieveImportRules(long id) {
		return client.getSingle( ENDPOINT_TENANTS + id + "/rules", String.class );
	}

	public void deleteImportationSummary() {
		client.delete( ENDPOINT_PRODUCT+"importation-errors/all" );
	}

	public List<Tenant> searchTenants(TenantFilter filter) {
		return client.getList( ENDPOINT_TENANTS + "search?monitored=" + filter.getMonitored(), Tenant.class);
	}

	public void insertImportationError(ImportationError importationError){
		client.post( "/importations/errors", importationError);
	}
}
