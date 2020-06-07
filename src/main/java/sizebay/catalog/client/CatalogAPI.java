package sizebay.catalog.client;

import java.util.*;
import lombok.NonNull;
import sizebay.catalog.client.http.*;
import sizebay.catalog.client.model.*;
import sizebay.catalog.client.model.filters.*;

/**
 * A Basic wrapper on generated Swagger client.
 * 
 * @author Miere L. Teixeira
 */
public class CatalogAPI {

	final static String
		DEFAULT_BASE_URL = "https://catalogue.fitpeek.co/api/v1/",

		ENDPOINT_BRAND = "/brands",
		ENDPOINT_MODELING = "/modelings",
		ENDPOINT_PRODUCT = "/products",
		ENDPOINT_CATEGORIES = "/categories",
		ENDPOINT_TENANTS = "/tenants/",
		ENDPOINT_USER = "/user",
		ENDPOINT_SIZE_STYLE = "/style",
		ENDPOINT_DEVOLUTION = "/devolution",
		ENDPOINT_IMPORTATION_ERROR = "/importations",
		ENDPOINT_STRONG_CATEGORY_TYPE = "types",
		ENDPOINT_STRONG_CATEGORY = "types/categories/strong",
		ENDPOINT_STRONG_SUBCATEGORY = "types/categories/strong/sub",
		ENDPOINT_STRONG_MODEL = "models/strong",

		SEARCH_BY_TEXT = "/search/all?text=";

	final RESTClient client;

	/**
	 * Constructs the Catalog API.
	 * 
	 * @param applicationToken
	 * @param securityToken
	 */
	public CatalogAPI(@NonNull String applicationToken, @NonNull String securityToken) {
		this(DEFAULT_BASE_URL, applicationToken, securityToken);
	}

	/**
	 * Constructs the Catalog API.
	 * 
	 * @param basePath
	 * @param applicationToken
	 * @param securityToken
	 */
	public CatalogAPI(@NonNull String basePath, @NonNull String applicationToken, @NonNull String securityToken) {
		final CatalogAuthentication authentication = new CatalogAuthentication( applicationToken, securityToken );
		final MimeType mimeType = new JSONMimeType();

		client = new RESTClient( basePath, mimeType, authentication );
	}

	/**
	 * Starting user profile management
	 */

	public void insertUser (UserProfile userProfile) {
		client.post(ENDPOINT_USER, userProfile);
	}

	public UserProfile updateProfileName(ProfileUpdateName profileUpdateName){
		return client.put( ENDPOINT_USER + "/update/profile/name", profileUpdateName, UserProfile.class);
	}

	public UserProfile retrieveUser (String userId) {
		return client.getSingle(ENDPOINT_USER + "/single/" + userId, UserProfile.class);
	}

	public UserProfile retrieveUserByFacebook(String facebookToken) {
		return client.getSingle(ENDPOINT_USER + "/social/facebook/" + facebookToken, UserProfile.class);
	}

	public UserProfile retrieveUserByGoogle(String googleToken) {
		return client.getSingle(ENDPOINT_USER + "/social/google/" + googleToken, UserProfile.class);
	}

	public Profile retrieveProfile (long profileId) {
		return client.getSingle(ENDPOINT_USER + "/profile/" + profileId, Profile.class);
	}

	public void updateUserFacebookToken(String userId, String facebookToken) {
		client.put(ENDPOINT_USER + "/social/facebook/" + userId, facebookToken);
	}

	public void updateUserGoogleToken(String userId, String googleToken) {
		client.put(ENDPOINT_USER + "/social/google/" + userId, googleToken);
	}

	public void insertProfile (Profile profile) {
		client.post(ENDPOINT_USER + "/profile", profile);
	}
	
	public void deleteProfile (long profileId) { client.delete(ENDPOINT_USER + "/profile/" + profileId); }

	/*
	 * End user profile management
	 */

	/*
	 * Starting size style management
	 */

	public List<SizeStyle> getSizeStyles(SizeStyleFilter filter) {
		return client.getList(ENDPOINT_SIZE_STYLE + "/search/all" + "?" + filter.createQuery(), SizeStyle.class);
	}

	public List<SizeStyle> getSizeStyle(long brandId, int typeId, char gender, int ageGroup) {
		return client.getList(ENDPOINT_SIZE_STYLE + "/" + brandId + "/" + typeId + "/" + gender + "/" + ageGroup, SizeStyle.class);
	}

	public List<SizeStyle> getSizeStyle(long brandId, int typeId, char gender, int ageGroup, int categoryId) {
		return client.getList(ENDPOINT_SIZE_STYLE + "/" + brandId + "/" + typeId + "/" + gender + "/" + ageGroup + "/" + categoryId, SizeStyle.class);
	}

	public List<SizeStyle> getSizeStyle(long brandId, int typeId, char gender, int ageGroup, int categoryId, int subcategoryId) {
		return client.getList(ENDPOINT_SIZE_STYLE + "/" + brandId + "/" + typeId + "/" + gender + "/" + ageGroup + "/" + categoryId + "/" + subcategoryId, SizeStyle.class);
	}

	public SizeStyle getSingleSizeStyle(long id) {
		return client.getSingle(ENDPOINT_SIZE_STYLE + "/single/" + id, SizeStyle.class);
	}

	public long insertSizeStyle(SizeStyle sizeStyle) {
		return client.post(ENDPOINT_SIZE_STYLE + "/single", sizeStyle);
	}

	public void updateWeightStyle(long id, SizeStyle sizeStyle) {
		client.put(ENDPOINT_SIZE_STYLE + "/single/" + id, sizeStyle);
	}

	public void bulkUpdateSizeStyles(BulkUpdateSizeStyle bulkUpdateSizeStyle) {
		client.patch(ENDPOINT_SIZE_STYLE, bulkUpdateSizeStyle);
	}

	public void deleteSizeStyle(long id) {
		client.delete(ENDPOINT_SIZE_STYLE + "/single/" + id);
	}

	public void deleteSizeStyles(List<Integer> ids) {
		client.delete(ENDPOINT_SIZE_STYLE + "/bulk/some", ids);
	}

	/*
	 * End size style management
	 */

	/*
	 * Starting devolution management
	 */

	public List<DevolutionError> retrieveDevolutionErrors() {
		return client.getList(ENDPOINT_DEVOLUTION + "/errors", DevolutionError.class);
	}

	public List<DevolutionError> retrieveDevolutionErrors(DevolutionFilter filter) {
		return client.getList(ENDPOINT_DEVOLUTION + "/errors" + "?" + filter.createQuery(), DevolutionError.class);
	}

	public long insertDevolutionError(DevolutionError devolution) {
		return client.post(ENDPOINT_DEVOLUTION + "/errors/single", devolution);
	}

	public void deleteDevolutionErrors() {
		client.delete(ENDPOINT_DEVOLUTION + "/errors");
	}

	public DevolutionSummary retrieveDevolutionSummaryLastBy() {
		return client.getSingle(ENDPOINT_DEVOLUTION + "/summary/last", DevolutionSummary.class);
	}

	public long insertDevolutionSummary(DevolutionSummary devolutionSummary) {
		return client.post(ENDPOINT_DEVOLUTION + "/summary/single", devolutionSummary);
	}

	public void deleteDevolutionSummary() {
		client.delete(ENDPOINT_DEVOLUTION + "/summary");
	}

	/*
	 * End devolution management
	 */

	/*
	 * Starting user (MySizebay) management
	 */

	public List<Tenant> authenticateAndRetrieveTenants(String username, String password ) {
		return client.getList( "/users/" + username + "/" + password + "/tenants", Tenant.class );
	}

	/*
	 * End user (MySizebay) management
	 */

	/*
	 * Starting product management
	 */

	public List<Product> getProducts(int page) {
		return client.getList(ENDPOINT_PRODUCT + "?page=" + page, Product.class);
	}

	public List<Product> getProducts(ProductFilter filter) {
		return client.getList(ENDPOINT_PRODUCT + "/search/all" + "?" + filter.createQuery(), Product.class);
	}

	public Product getProduct(long id) {
		return client.getSingle(ENDPOINT_PRODUCT + "/single/" + id, Product.class);
	}

	public Long getProductIdFromPermalink(String permalink){
		return client.getSingle(ENDPOINT_PRODUCT + "/search/product-id"
				+ "?permalink=" + permalink,
			Long.class);
	}

	public Long getAvailableProductIdFromPermalink(String permalink){
		return client.getSingle(ENDPOINT_PRODUCT + "/search/product-id"
				+ "?permalink=" + permalink
				+ "&onlyAvailable=true",
			Long.class);
	}

	public ProductIntegration retrieveProductIntegration(Long tenantId, String feedProductId) {
		return client.getSingle(ENDPOINT_PRODUCT + "/search/feed-product-id"
				+ "/" + tenantId
				+ "/" + feedProductId,
			ProductIntegration.class);
	}

	public ProductBasicInformation retrieveProductByBarcode(Long barcode) {
		return client.getSingle(ENDPOINT_PRODUCT + "/search/barcode/" + barcode, ProductBasicInformation.class);
	}

	public ProductBasicInformation getProductBasicInfo(long id){
		return client.getSingle(ENDPOINT_PRODUCT
				+ "/" + id
				+ "/basic-info",
			ProductBasicInformation.class);
	}

	public ProductBasicInformation getProductBasicInfoFilterSizes(long id, String sizes){
		return client.getSingle( ENDPOINT_PRODUCT
				+ "/" + id
				+ "/basic-info-filter-sizes"
				+ "?sizes=" + sizes,
			ProductBasicInformation.class);
	}

	public long insertProduct(Product product) {
		return client.post(ENDPOINT_PRODUCT + "/single", product);
	}

	public ProductIntegration insertProductIntegration(ProductIntegration product) {
		return client.post(ENDPOINT_PRODUCT + "/single/integration", product, ProductIntegration.class);
	}

	public long insertMockedProduct(String permalink) {
		return client.post(ENDPOINT_PRODUCT + "/mock?permalink=" + permalink, String.class);
	}

	public void updateProduct(long id, Product product) {
		client.put(ENDPOINT_PRODUCT + "/single/" + id, product);
	}

	public void bulkUpdateProducts(BulkUpdateProducts products) {
		client.patch(ENDPOINT_PRODUCT, products);
	}

	public void deleteProducts() {
		client.delete(ENDPOINT_PRODUCT);
	}

	public void deleteProduct(long id) {
		client.delete(ENDPOINT_PRODUCT + "/single/" + id);
	}

	public void deleteProducts(List<Integer> ids) {
		client.delete(ENDPOINT_PRODUCT + "/bulk/some", ids);
	}

	/*
	 * End product management
	 */


	/*
	 * Starting brand management
	 */

	public List<Brand> searchForBrands(String text){
		return client.getList(ENDPOINT_BRAND + SEARCH_BY_TEXT + text, Brand.class);
	}

	public List<Brand> getBrands(int page) {
		return client.getList(ENDPOINT_BRAND + "?page=" + page, Brand.class);
	}

	public List<Brand> getBrands(int page, String name) {
		return client.getList(ENDPOINT_BRAND + "?page=" + page + "&name=" + name, Brand.class);
	}

	public Brand getBrand(long id) {
		return client.getSingle(ENDPOINT_BRAND + "/single/" + id, Brand.class);
	}

	public long insertBrand(Brand brand) {
		return client.post(ENDPOINT_BRAND + "/single", brand);
	}

	public void updateBrand(long id, Brand brand) {
		client.put(ENDPOINT_BRAND + "/single/" + id, brand);
	}

	public void deleteBrands() {
		client.delete(ENDPOINT_BRAND);
	}

	public void deleteBrand(long id) {
		client.delete(ENDPOINT_BRAND + "/single/" + id);
	}

	public void deleteBrands(List<Integer> ids) {
		client.delete(ENDPOINT_BRAND + "/bulk/some", ids);
	}

	/*
	 * End brand management
	 */

	/*
	 * Starting category management
	 */

	public List<Category> getCategories() {
		return client.getList(ENDPOINT_CATEGORIES, Category.class);
	}

	public List<Category> getCategories(int page) {
		return client.getList(ENDPOINT_CATEGORIES + "?page=" + page, Category.class);
	}

	public List<Category> getCategories(int page, String name) {
		return client.getList(ENDPOINT_CATEGORIES + "?page=" + page + "&name=" + name, Category.class);
	}

	public List<Category> searchForCategories(String text){
		return client.getList(ENDPOINT_CATEGORIES + SEARCH_BY_TEXT + text, Category.class);
	}

	public Category getCategory(long id) {
		return client.getSingle(ENDPOINT_CATEGORIES + "/single/" + id, Category.class);
	}

	public long insertCategory(Category brand) {
		return client.post(ENDPOINT_CATEGORIES + "/single", brand);
	}

	public void updateCategory(long id, Category brand) {
		client.put(ENDPOINT_CATEGORIES + "/single/" +id, brand);
	}

	public void deleteCategories() {
		client.delete(ENDPOINT_CATEGORIES);
	}

	public void deleteCategory(long id) {
		client.delete(ENDPOINT_CATEGORIES + "/single/" + id);
	}

	public void deleteCategories(List<Integer> ids) {
		client.delete(ENDPOINT_CATEGORIES + "/bulk/some", ids);
	}

	/*
	 * End category management
	 */


	/*
	 * Starting modeling management
	 */

	public List<Modeling> searchForModelings(long brandId, String gender) {
		return searchForModelings(String.valueOf(brandId), gender);
	}

	public List<Modeling> searchForModelings(String brandId, String gender){
		return client.getList(ENDPOINT_MODELING + "/search/brand/" + brandId + "/gender/" + gender, Modeling.class);
	}

	public List<Modeling> getModelings(int page){
		return client.getList(ENDPOINT_MODELING + "?page=" + page, Modeling.class);
	}

	public List<Modeling> getModelings(ModelingFilter filter) {
		return client.getList(ENDPOINT_MODELING + "/search/all" + "?" + filter.createQuery(), Modeling.class);
	}

	public Modeling getModeling(long id) {
		return client.getSingle(ENDPOINT_MODELING + "/single/" + id, Modeling.class);
	}

	public long insertModeling(Modeling modeling) {
		return client.post(ENDPOINT_MODELING + "/single", modeling);
	}

	public void updateModeling(long id, Modeling modeling) {
		client.put(ENDPOINT_MODELING + "/single/" + id, modeling);
	}

	public void deleteModelings() {
		client.delete(ENDPOINT_MODELING);
	}

	public void deleteModeling(long id) {
		client.delete(ENDPOINT_MODELING + "/single/" + id);
	}

	public void deleteModelings(List<Integer> ids) {
		client.delete(ENDPOINT_MODELING + "/bulk/some", ids);
	}

	/*
	 * End modeling management
	 */

	/*
	 * Starting importation error management
	 */

	public List<ImportationError> getImportationErrors(int page){
		return client.getList(ENDPOINT_IMPORTATION_ERROR + "/errors?page=" + page, ImportationError.class);
	}

	public long insertImportationError(ImportationError importationError){
		return client.post( ENDPOINT_IMPORTATION_ERROR + "/errors", importationError);
	}

	public void deleteImportationErrors() {
		client.delete(ENDPOINT_PRODUCT + "/importation-errors/all");
	}

	public ImportationSummary getImportationSummary(){
		return client.getSingle(ENDPOINT_IMPORTATION_ERROR + "/summary/last" , ImportationSummary.class);
	}

	public long insertImportationSummary(ImportationSummary importationSummary){
		return client.post( ENDPOINT_IMPORTATION_ERROR + "/summary/single", importationSummary);
	}

	public void deleteImportationSummary() {
		client.delete(ENDPOINT_IMPORTATION_ERROR);
	}

	/*
	 * End importation error management
	 */

	/*
	 * Starting strong brand management
	 */

	public List<StrongBrand> getAllBrand(){
		return client.getList(ENDPOINT_BRAND + "/strong", StrongBrand.class);
	}

	public List<StrongBrand> getStrongBrands(StrongBrandFilter filter) {
		return client.getList(ENDPOINT_BRAND + "/strong?" + filter.createQuery(), StrongBrand.class);
	}

	public StrongBrand getSingleBrand(long id) {
		return client.getSingle(ENDPOINT_BRAND + "/strong/single/" + id, StrongBrand.class);
	}

	public long insertStrongBrand(StrongBrand strongBrand){
		return client.post( ENDPOINT_BRAND + "/strong/single", strongBrand);
	}

	public void updateStrongBrand(long id, StrongBrand strongBrand) {
		client.put(ENDPOINT_BRAND + "/strong/single/" + id, strongBrand);
	}

	public void deleteStrongBrand(long id) {
		client.delete(ENDPOINT_BRAND + "/strong/single/" + id);
	}

	public void deleteStrongBrands(List<Integer> ids) {
		client.delete(ENDPOINT_BRAND + "/strong/bulk/some", ids);
	}

	/*
	 * End strong brand management
	 */


	/*
	 * Starting strong category management
	 */

	public List<StrongCategory> getAllStrongCategories(){
		return client.getList(ENDPOINT_STRONG_CATEGORY, StrongCategory.class);
	}

	public List<StrongCategory> getAllStrongCategories(int page, String categoryName, Long typeId){
		String condition;

		condition = categoryName == null ? "" : "&name=" + categoryName;
		condition += typeId == null ? "" : "&typeId=" + typeId;

		return client.getList(ENDPOINT_STRONG_CATEGORY + "/search/all?page=" + page + condition, StrongCategory.class);
	}

	public StrongCategory getSingleStrongCategory(long id) {
		return client.getSingle(ENDPOINT_STRONG_CATEGORY + "/single/" + id, StrongCategory.class);
	}

	public long insertStrongCategory(StrongCategory strongCategory){
		return client.post(ENDPOINT_STRONG_CATEGORY + "/single", strongCategory);
	}

	public void updateStrongCategory(long id, StrongCategory strongCategory) {
		client.put(ENDPOINT_STRONG_CATEGORY + "/single/" + id, strongCategory);
	}

	public void deleteStrongCategory(long id) {
		client.delete(ENDPOINT_STRONG_CATEGORY + "/single/" + id);
	}


	/*
	 * End strong category management
	 */

	/*
	 * Starting strong subcategory management
	 */

	public List<StrongSubcategory> getAllStrongSubcategories(int page){
		return client.getList(ENDPOINT_STRONG_SUBCATEGORY + "?page=" + page, StrongSubcategory.class);
	}

	public List<StrongSubcategory> getAllStrongSubcategories(int page, String subcategoryName){
		return client.getList(ENDPOINT_STRONG_SUBCATEGORY + "?page=" + page + "&name=" + subcategoryName, StrongSubcategory.class);
	}

	public StrongSubcategory getSingleStrongSubcategory(long id) {
		return client.getSingle(ENDPOINT_STRONG_SUBCATEGORY + "/single/" + id, StrongSubcategory.class);
	}

	public long insertStrongSubcategory(StrongSubcategory strongSubcategory){
		return client.post(ENDPOINT_STRONG_SUBCATEGORY + "/single", strongSubcategory);
	}

	public void updateStrongSubcategory(long id, StrongSubcategory strongSubcategory) {
		client.put(ENDPOINT_STRONG_SUBCATEGORY + "/single/" + id, strongSubcategory);
	}

	public void deleteStrongSubcategory(long id) {
		client.delete(ENDPOINT_STRONG_SUBCATEGORY + "/single/" + id);
	}


	/*
	 * End strong subcategory management
	 */

	/*
	 * Starting strong category type management
	 */

	public List<StrongCategoryType> getAllStrongCategoryTypes(int page){
		return client.getList(ENDPOINT_STRONG_CATEGORY_TYPE + "?page=" + page, StrongCategoryType.class);
	}

	public List<StrongCategoryType> getAllStrongCategoryTypes(int page, String categoryTypeName){
		return client.getList(ENDPOINT_STRONG_CATEGORY_TYPE + "?page=" + page + "&name=" + categoryTypeName, StrongCategoryType.class);
	}

	public StrongCategoryType getSingleStrongCategoryType(long id) {
		return client.getSingle(ENDPOINT_STRONG_CATEGORY_TYPE + "/single/" + id, StrongCategoryType.class);
	}

	public long insertStrongCategoryType(StrongCategoryType strongCategoryType){
		return client.post(ENDPOINT_STRONG_CATEGORY_TYPE + "/single", strongCategoryType);
	}

	public void updateStrongCategoryType(long id, StrongCategoryType strongCategoryType) {
		client.put(ENDPOINT_STRONG_CATEGORY_TYPE + "/single/" + id, strongCategoryType);
	}

	public void deleteStrongCategoryType(long id) {
		client.delete(ENDPOINT_STRONG_CATEGORY_TYPE + "/single/" + id);
	}


	/*
	 * End strong category type management
	 */

	/*
	 * Starting strong model management
	 */

	public List<StrongModel> getAllStrongModels(int page){
		return client.getList(ENDPOINT_STRONG_MODEL + "?page=" + page, StrongModel.class);
	}

	public List<StrongModel> getAllStrongModels(int page, String modelName){
		return client.getList(ENDPOINT_STRONG_MODEL + "?page=" + page + "&name=" + modelName, StrongModel.class);
	}

	public StrongModel getSingleStrongModel(long id) {
		return client.getSingle(ENDPOINT_STRONG_MODEL + "/single/" + id, StrongModel.class);
	}

	public long insertStrongModel(StrongModel strongModel){
		return client.post(ENDPOINT_STRONG_MODEL + "/single", strongModel);
	}

	public void updateStrongModel(long id, StrongModel strongModel) {
		client.put(ENDPOINT_STRONG_MODEL + "/single/" + id, strongModel);
	}

	public void deleteStrongModel(long id) {
		client.delete(ENDPOINT_STRONG_MODEL + "/single/" + id);
	}

	/*
	 * End strong model management
	 */



	public void updateHashXML(String hash) {
		client.put(ENDPOINT_TENANTS + "hash", hash);
	}

	public List<Tenant> retrieveAllTenants(){
		return client.getList( ENDPOINT_TENANTS, Tenant.class );
	}

	public Tenant getTenant( String appToken ){
		return client.getSingle( ENDPOINT_TENANTS+ "single/" + appToken, Tenant.class );
	}

	@Deprecated
	void saveUser( User user ){
		client.post( "/users/", user );
	}

	public void insertTenant(Tenant tenant) {
		client.post( ENDPOINT_TENANTS, tenant );
	}

	public void insertImportationSummary(long tenantId, ImportationSummary importationSummary) {
		client.post( "/importations/tenantId/"+tenantId, importationSummary );
	}

	public String retrieveImportRules(long id) {
		return client.getSingle( ENDPOINT_TENANTS + id + "/rules", String.class );
	}

	public List<Tenant> searchTenants(TenantFilter filter) {
		return client.getList( ENDPOINT_TENANTS + "search?monitored=" + filter.getMonitored(), Tenant.class);
	}

	public List<Tenant> searchAllTenants() {
		return client.getList( ENDPOINT_TENANTS + "search/all", Tenant.class);
	}

}
